package pl.coderslab;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {
                new CharacterEncodingFilter()
        };
    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",
//                new CharacterEncodingFilter());
//        fr.setInitParameter("encoding", "UTF-8");
//        fr.setInitParameter("forceEncoding", "true");
//        fr.addMappingForUrlPatterns(null, true, "/*");
//    }
}
