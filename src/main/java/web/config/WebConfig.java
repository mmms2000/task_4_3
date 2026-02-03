package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver r = new SpringResourceTemplateResolver();
        r.setPrefix("/WEB-INF/pages/");
        r.setSuffix(".html");
        r.setCharacterEncoding("UTF-8");
        return r;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine e = new SpringTemplateEngine();
        e.setTemplateResolver(templateResolver());
        return e;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver r = new ThymeleafViewResolver();
        r.setTemplateEngine(templateEngine());
        r.setCharacterEncoding("UTF-8");
        return r;
    }
}
