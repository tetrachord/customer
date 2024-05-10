package com.foo.service;

import com.foo.model.Customer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CustomerRestClientService {

    private final RestClient restClient;

    public CustomerRestClientService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8080")
                .build();
    }

    public void postCustomer(Customer customer) {
        restClient.post().uri("/customer").body(customer).contentType(MediaType.APPLICATION_JSON);
    }
}
