package com.foo;


import com.foo.model.Customer;
import com.foo.service.CustomerRestClientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CustomerApplicationIntegrationTest {

    @Autowired
    private CustomerApplication underTest;

    @Autowired
    private ApplicationContext ctx;

    @MockBean
    private CustomerRestClientService customerRestClientService;

    @Test
    void shouldMakePostRequestFromCsv() throws Exception {

        // given
        String[] args = {"customerDir/customers.csv"};
        Customer expectedCustomer = new Customer("ABC123",
                "Joe Bloggs",
                "123, Some Street",
                "Some Area",
                "Some Town",
                "Some County",
                "UK",
                "CBA 321");

        // when
        underTest.commandLineRunner(ctx).run(args);

        // then
        Mockito.verify(customerRestClientService, Mockito.atLeastOnce())
                .postCustomer(expectedCustomer);
    }
}