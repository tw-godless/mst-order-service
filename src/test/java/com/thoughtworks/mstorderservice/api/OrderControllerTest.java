package com.thoughtworks.mstorderservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.mstorderservice.Repository.OrderRepository;
import com.thoughtworks.mstorderservice.entity.Order;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@ActiveProfiles(profiles = "test")
class OrderControllerTests {


    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private OrderRepository orderRepository;

    protected MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @BeforeEach
    public void beforeEach() throws Exception {
        Order order = new Order(1, 1, 1, new BigDecimal(100), "created");
        orderRepository.saveAndFlush(order);
    }

    @Test
    public void should_return_order_detail_when_create_order() throws Exception {
        Order order = Order.builder()
            .goodId(1)
            .goodNumber(2)
            .totalPrice(new BigDecimal(100))
            .build();

        MockHttpServletRequestBuilder request = post("/api/order")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(order));
        String response = mockMvc.perform(request)
            .andReturn()
            .getResponse()
            .getContentAsString();
        JSONObject jsonObject = new JSONObject(response);

        assertThat(jsonObject.get("good_id")).isEqualTo(1);
        assertThat(jsonObject.get("good_number")).isEqualTo(2);
        assertThat(jsonObject.get("total_price")).isEqualTo(100);
    }

}
