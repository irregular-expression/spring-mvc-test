package springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springtest.service.ApiService;
import springtest.service.ApiServiceImpl;

@Configuration
public class ApiConfig {

   @Bean
   public ApiService apiService() {
       return new ApiServiceImpl();
   }

}
