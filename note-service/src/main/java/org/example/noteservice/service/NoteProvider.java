package org.example.noteservice.service;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NoteProvider {
    private final WebClient webClient;
//    private final EurekaClient eurekaClient;

    public NoteProvider(ReactorLoadBalancerExchangeFilterFunction reactorLoadBalancerExchangeFilterFunction) {
        this.webClient = WebClient.builder()
                .filter(reactorLoadBalancerExchangeFilterFunction)
                .build();


    }
}
