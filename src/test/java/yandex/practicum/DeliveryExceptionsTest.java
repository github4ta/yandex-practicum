package yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

public class DeliveryExceptionsTest {

    @Test
    @DisplayName("Test CargoDeliveryException")
    public void test1() {
        int distance = -1;
        CargoDeliveryException thrown = Assertions.assertThrows(CargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, false, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Distance cannot be negative. Your distance is %s.", distance), thrown.getMessage());
    }

    @Test
    @DisplayName("Test FragileCargoDeliveryException")
    public void test2() {
        final int MAX_DISTANCE_30_KM = 30;
        int distance = 31;
        FragileCargoDeliveryException thrown = Assertions.assertThrows(FragileCargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, true, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Fragile cargo cannot be transported over a distance of more than %s km. Your distance is %s.", MAX_DISTANCE_30_KM, distance), thrown.getMessage());
    }
}
