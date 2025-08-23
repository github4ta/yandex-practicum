package yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yandex.practicum.data.Distances;
import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

public class DeliveryExceptionsTest {

    @Test
    @DisplayName("Test CargoDeliveryException")
    public void test1() {
        int distance = Distances.generateDistanceInRange(Integer.MIN_VALUE, -1);
        CargoDeliveryException thrown = Assertions.assertThrows(CargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, false, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Distance cannot be negative. Your distance is %s.", distance), thrown.getMessage());
    }

    @Test
    @DisplayName("Test CargoDeliveryException")
    public void test2() {
        int distance = Distances.generateDistanceInRange(Integer.MIN_VALUE, -1);
        CargoDeliveryException thrown = Assertions.assertThrows(CargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, true, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Distance cannot be negative. Your distance is %s.", distance), thrown.getMessage());
    }

    @Test
    @DisplayName("Test FragileCargoDeliveryException")
    public void test20() {
        final int MAX_DISTANCE_30_KM = 30;
        int distance = Distances.generateDistanceInRange(31, Integer.MAX_VALUE);
        FragileCargoDeliveryException thrown = Assertions.assertThrows(FragileCargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, true, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Fragile cargo cannot be transported over a distance of more than %s km. Your distance is %s.", MAX_DISTANCE_30_KM, distance), thrown.getMessage());
    }

    @Test
    @DisplayName("Test FragileCargoDeliveryException")
    public void test21() {
        final int MAX_DISTANCE_30_KM = 30;
        int distance = Distances.generateDistanceInRange(31, Integer.MAX_VALUE);
        FragileCargoDeliveryException thrown = Assertions.assertThrows(FragileCargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.SMALL, true, ServiceLoad.INCREASED);
        });

        Assertions.assertEquals(String.format("Fragile cargo cannot be transported over a distance of more than %s km. Your distance is %s.", MAX_DISTANCE_30_KM, distance), thrown.getMessage());
    }

    @Test
    @DisplayName("Test FragileCargoDeliveryException")
    public void test22() {
        final int MAX_DISTANCE_30_KM = 30;
        int distance = Distances.generateDistanceInRange(31, Integer.MAX_VALUE);
        FragileCargoDeliveryException thrown = Assertions.assertThrows(FragileCargoDeliveryException.class, () -> {
            Delivery.calculateShippingCost(distance, Dimensions.LARGE, true, ServiceLoad.OTHER);
        });

        Assertions.assertEquals(String.format("Fragile cargo cannot be transported over a distance of more than %s km. Your distance is %s.", MAX_DISTANCE_30_KM, distance), thrown.getMessage());
    }
}
