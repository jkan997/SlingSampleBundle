package org.jkan997.booklibrary.htl;

import java.util.Date;
import javax.jcr.Repository;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.models.annotations.Model;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

@Model(adaptables = Resource.class)
public class BooklistModel {

    public Repository getRepository() {
        BundleContext bundleContext = FrameworkUtil.getBundle(BooklistModel.class).getBundleContext();
        ServiceReference factoryRef = bundleContext.getServiceReference(SlingRepository.class.getName());
        SlingRepository res = (SlingRepository) bundleContext.getService(factoryRef);
        return res;
    }

    /*
        YOUR HTL MODEL HERE HERE
     */
    public String getSampleBook() {
        //SlingHttpServletRequest s = this.adaptTo(SlingHttpServletRequest.class);
        return "A!" + (new Date()).toString() + " '" + getRepository();
    }
}

/*package org.jkan997.booklibrary.htl;

import java.util.Date;
import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.adapter.SlingAdaptable;
import org.apache.sling.jcr.api.SlingRepository;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = SlingHttpServletRequest.class)
public class BooklistModel  extends  SlingAdaptable {


    public String getDate() {
        SlingHttpServletRequest s = this.adaptTo(SlingHttpServletRequest.class);
        return (new Date()).toString() + " '" + s ;

    }

   
}
 */
