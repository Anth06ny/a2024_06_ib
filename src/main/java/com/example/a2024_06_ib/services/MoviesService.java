package com.example.a2024_06_ib.services;

import com.example.a2024_06_ib.model.MovieBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MoviesService {

    //Webflux only
    @Autowired//Laisse à Spring le remplissage
    //Si plusieurs objet de même type permet de les différencier
    @Qualifier("moviesAPIClient")
    private WebClient anyApiClient;

    //LoadBalancer only
    @Autowired
    private RestTemplate restTemplate;

    //WebFlux + LoadBalncer
    @Autowired
    @Qualifier("moviesAPIClientWithLoadBalancing")
    private WebClient webFluxBalancerClient;

    // Obtenir un utilisateur par ID (GET) Asynchrone
    public Mono<MovieBean> getMoviesByIdAsync(Long id) {
        return anyApiClient.get().uri("/{id}", id).retrieve().bodyToMono(MovieBean.class);
    }



    // Utilise le nom du micro-service sur Eureka
    private static final String URL = "http://MoviesService/movies";

    public MovieBean getMoviesByIdLoadBalancing(Long id) {
        return  restTemplate.getForObject(URL + "/1", MovieBean.class);
    }

    public Mono<MovieBean> getMoviesByIdLoadBalancingAndWebFlux(Long id) {
        return  webFluxBalancerClient.get().uri("/{id}", id).retrieve().bodyToMono(MovieBean.class);
    }

}
