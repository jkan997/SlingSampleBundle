package org.jkan997.booklibrary.servlet;

import java.util.Map;
import javax.servlet.Servlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=" + HttpConstants.METHOD_GET,
    "sling.servlet.paths=" + "/bin/ListBooks"
})
public class ListBooks extends SlingSafeMethodsServlet {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ListBooks.class);

    @Reference
    SlingRepository repository;

    @Activate
    protected void activate(Map<String, Object> props) {
        LOGGER.info("Activating " + this.getClass().getSimpleName());
    }

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        /*
        YOUR IMPLEMENTATION HERE
         */
        throw new RuntimeException("" + getClass().getCanonicalName() + " not implemented yet.");
    }

}
