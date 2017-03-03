package org.jkan997.booklibrary.servlet;

import java.util.Map;
import javax.servlet.ServletException;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
import org.slf4j.LoggerFactory;

@SlingServlet(resourceTypes = "book", extensions = {"reserve", "unreserve", "rent", "return"}, metatype = true)
public class ModifyBookState extends SlingSafeMethodsServlet {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ModifyBookState.class);

    @Reference
    SlingRepository repository;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
        /*
        YOUR IMPLEMENTATION HERE
         */
        throw new RuntimeException("" + getClass().getCanonicalName() + " not implemented yet.");
    }

}
