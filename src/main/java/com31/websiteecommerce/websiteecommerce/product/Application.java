package com31.websiteecommerce.websiteecommerce.product;

import com31.websiteecommerce.websiteecommerce.product.model.ApiKeyHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new ApiKeyHandlerMethodArgumentResolver());
	}
}
