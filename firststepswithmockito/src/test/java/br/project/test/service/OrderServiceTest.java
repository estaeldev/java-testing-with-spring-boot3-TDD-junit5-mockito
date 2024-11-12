package br.project.test.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.project.test.model.Order;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    
    @InjectMocks
    private OrderService orderService;

    @Test
    void testCreateOrder_WhenOrderIdIsNull_ThenIncludeRandomOrderId() {
        UUID defaultUUID = UUID.fromString("91167ae4-685a-4707-93ff-d0c23e86b908");

        try (MockedStatic<UUID> mockedUUID = Mockito.mockStatic(UUID.class)) {
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUUID);
            Order order = this.orderService.createOrder(null, null, null);
            Assertions.assertEquals(defaultUUID.toString(), order.getId());
        }
        
    }

    @Test
    void testCreateOrder_ShouldReturnLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 11, 7, 0, 0);

        try (MockedStatic<LocalDateTime> mockitoStatic = Mockito.mockStatic(LocalDateTime.class)) {
            mockitoStatic.when(LocalDateTime::now).thenReturn(localDateTime);
            Order order = this.orderService.createOrder(null, null, null);
            Assertions.assertEquals(localDateTime, order.getCreationDate());
            Assertions.assertEquals(localDateTime.getYear(), order.getCreationDate().getYear());
        }
        
    }

    @Test
    void testCreateOrder_WhenFieldsIsValid_ThenReturnObjectOrder() {
        String productName = "TV";
        Long amount = 8650l;
        Order order = this.orderService.createOrder(productName, amount, null);

        Assertions.assertEquals(productName, order.getProductName());
        Assertions.assertEquals(amount, order.getAmount());
        Assertions.assertNotNull(order.getId());
        Assertions.assertNotNull(order.getCreationDate());
    }
    

}
