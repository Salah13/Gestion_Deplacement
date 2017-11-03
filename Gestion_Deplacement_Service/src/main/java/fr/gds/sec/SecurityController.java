package fr.gds.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SecurityController extends WebMvcConfigurerAdapter{

	@Override
	   public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chercherProduit").setViewName("/chercherProduit");
        registry.addViewController("/").setViewName("/chercherProduit");
        registry.addViewController("/login").setViewName("login");
    }
}
