import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.access.BeanFactoryLocator;
import org.springframework.beans.factory.access.BeanFactoryReference;
import org.springframework.beans.factory.access.SingletonBeanFactoryLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author mplescano
 * 
 * @see http://senthadev.com/sharing-spring-container-between-modules-in-a-web-application.html
 *
 */
public class SpringInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		//BeanFactoryLocator bfl = SingletonBeanFactoryLocator.getInstance();
		//BeanFactoryReference bfr = bfl.useBeanFactory();
		//ApplicationContext rootContext = (ApplicationContext) bfr.getFactory();
		servletContext.setInitParameter(ContextLoader.LOCATOR_FACTORY_KEY_PARAM, "ear.context");
		
		// Create the 'web' Spring application context
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		//webContext.setParent(rootContext);
		// rootContext.register(AppConfig.class);

		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(webContext));
		

		
	}

}
