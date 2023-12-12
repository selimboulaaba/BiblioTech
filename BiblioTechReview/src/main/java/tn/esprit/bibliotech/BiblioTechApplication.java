package tn.esprit.bibliotech;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import tn.esprit.bibliotech.entities.Review;
import tn.esprit.bibliotech.services.ReviewService;

@SpringBootApplication
@EnableDiscoveryClient
public class BiblioTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(BiblioTechApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(ReviewService reviewService) {
//        return (args) -> {
//            reviewService.addReview(new Review("1", ));
//        };
//    }

}
