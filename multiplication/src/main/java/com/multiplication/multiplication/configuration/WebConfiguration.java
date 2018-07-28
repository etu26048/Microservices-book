package com.multiplication.multiplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
/**
 * it's enabled SpringMVC configuration then, when we would reach
 * localhost:8080/index.html, the dispatcher servlet will look for a
 * requestmapping associated to this value. Therefore, no page will actually be
 * rendered and this error appear : 
 * No mapping found for HTTP request with URI [/index.html] in DispatcherServlet with name 'dispatcherServlet'
 */
public class WebConfiguration implements WebMvcConfigurer {

	/**
	 * Enables Cross-Origin Resource Sharing (CORS) More info:
	 * http://docs.spring.io/ spring/docs/current/spring-framework-reference/html
	 * /cors.html
	 * 
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

}
