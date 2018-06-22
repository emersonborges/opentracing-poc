package br.com.poc.opentracing.salesservice;

import br.com.poc.opentracing.salesservice.controller.CustomersApi;
import br.com.poc.opentracing.salesservice.controller.OrdersApi;
import br.com.poc.opentracing.salesservice.controller.SalesController;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SalesControllerTest {

    @Test
    public void shouldCreateSales() {
        OrdersApi ordersApi = mock(OrdersApi.class);
        CustomersApi customersApi = mock(CustomersApi.class);
        SalesController salesController = new SalesController(ordersApi, customersApi);
        salesController.create();
        verify(ordersApi).create();
        verify(customersApi).createCustomer();
    }
}
