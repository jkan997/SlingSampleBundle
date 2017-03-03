package org.jkan997.booklibrary.servlet;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.jcr.Node;
import javax.jcr.Session;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.io.JSONWriter;
import org.apache.sling.jcr.api.SlingRepository;
import org.jkan997.booklibrary.util.Constans;
import static org.jkan997.booklibrary.util.Constans.NT_UNSTRUCTURED;
import org.jkan997.booklibrary.util.internal.CsvProcessor;
import org.jkan997.booklibrary.util.internal.JcrHelper;
import org.slf4j.LoggerFactory;

@SlingServlet(paths = "/bin/ImportBooks", methods = "GET", metatype = true)
public class ImportBooks extends SlingSafeMethodsServlet {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ImportBooks.class);

    @Reference
    SlingRepository repository;

    @Activate
    protected void activate(Map<String, Object> props) {
        LOGGER.info("Activation " + this.getClass().getSimpleName());
    }
    
    

    private int importBooks(Node parentNode, String resourceName) throws Exception {
        int res = 0;
        List<String[]> books = CsvProcessor.readBooks(resourceName);
        for (String[] book : books) {
            String author = book[0];
            String title = book[1];
            String newName = JcrHelper.escapeName(title);
            int i = 1;
            while (parentNode.hasNode(newName)) {
                newName = JcrHelper.escapeName(title) + " " + (i++);
            }
            Node bookNode = parentNode.addNode(newName, NT_UNSTRUCTURED);
            bookNode.setProperty("author", title);
            bookNode.setProperty("title", author);
            bookNode.setProperty("sling:resourceType", Constans.BOOK);
            res++;
        }
        return res;
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        try {
            response.setContentType("application/json");
            PrintWriter wrt = response.getWriter();
            Session jcrSession = repository.loginAdministrative(null);
            Node rootNode = jcrSession.getRootNode();
            Node booksNode;
            if (rootNode.hasNode("books")) {
                booksNode = rootNode.getNode("books");
                booksNode.remove();
                jcrSession.save();
            }
            booksNode = rootNode.addNode("books", "sling:OrderedFolder");
            Node fictionNode = booksNode.addNode("fiction", "sling:OrderedFolder");
            Node nonFictionNode = booksNode.addNode("nonfiction", "sling:OrderedFolder");
            int count = 0;
            count += importBooks(fictionNode, "fiction.csv");
            count += importBooks(nonFictionNode, "nonfiction.csv");
            jcrSession.save();
            JSONWriter json = new JSONWriter(wrt);
            json.object();
            json.key("BookCount").value(count);
            json.endObject();
            wrt.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
