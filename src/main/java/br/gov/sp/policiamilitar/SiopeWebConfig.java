package br.gov.sp.policiamilitar;

import br.gov.sp.policiamilitar.web.conversion.CurrencyFormatter;
import br.gov.sp.policiamilitar.web.conversion.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SiopeWebConfig extends WebMvcConfigurerAdapter {

    public SiopeWebConfig() {
        super();
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }

    @Bean
    public CurrencyFormatter currencyFormatter(){
        return new CurrencyFormatter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}