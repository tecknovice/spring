package springdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer 
	extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// return a Class array
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// return a String array
		return new String[] {"/"};
	}

}
