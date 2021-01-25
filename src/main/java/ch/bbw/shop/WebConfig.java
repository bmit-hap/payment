package ch.bbw.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Bean
	public WebMvcConfigurer corsConfiguration() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greetings/**")
						.allowedOrigins("http://localhost:3000")
						.allowedMethods("GET");
				registry.addMapping("/articles/**")
						.allowedOrigins("http://localhost:3000")
						.allowedMethods("GET","POST");
				registry.addMapping("/carts/**")
						.allowedOrigins("http://localhost:3000")
						.allowedMethods("GET", "POST", "DELETE");
			}
		};
	}

}
