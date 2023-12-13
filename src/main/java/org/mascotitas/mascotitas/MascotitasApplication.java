package org.mascotitas.mascotitas;

import org.mascotitas.mascotitas.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MascotitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotitasApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<JwtFilter> jwtFilter() {
//		FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new JwtFilter());
//		registrationBean.addUrlPatterns("/api/productos/*");
//	    registrationBean.addUrlPatterns("/api/clientes/*");
//		return registrationBean;
//	}// jwtFilter

}
