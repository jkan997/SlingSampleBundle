package org.jkan997.booklibrary.htl;

import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class)
public class BooklistModel {

    @Inject
    ResourceResolver rr;

    /*
        YOUR HTL MODEL HERE HERE
     */
    public String getSampleBook() throws Exception {
        Resource r = rr.getResource("/books/fiction/AMidsummerNightsDream");
        Book b = r.adaptTo(Book.class);
        return b.toString();
    }
}
