package miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import miniproject.Interceptor.GlobalInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GlobalInterceptor glo;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(glo)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
	}
	
	
}
