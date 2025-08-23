package yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

public class DeliveryFragileTest {

    @Test
    public void test1() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(600, Delivery.calculateShippingCost(Distances.generateDistanceInRange(3, 10), Dimensions.SMALL, true, ServiceLoad.INCREASED));
    }

    @Test
    public void test2() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(840, Delivery.calculateShippingCost(Distances.generateDistanceInRange(11, 30), Dimensions.LARGE, true, ServiceLoad.INCREASED));
    }

    @Test
    public void test3() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(770, Delivery.calculateShippingCost(Distances.generateDistanceInRange(0, 2), Dimensions.LARGE, true, ServiceLoad.HIGH));
    }

    @Test
    public void test4() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(600, Delivery.calculateShippingCost(Distances.generateDistanceInRange(3, 10), Dimensions.LARGE, true, ServiceLoad.OTHER));
    }

    @Test
    public void test5() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(720, Delivery.calculateShippingCost(Distances.generateDistanceInRange(0, 2), Dimensions.SMALL, true, ServiceLoad.VERY_HIGH));
    }

    @Test
    public void test6() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(840, Delivery.calculateShippingCost(Distances.generateDistanceInRange(11, 30), Dimensions.SMALL, true, ServiceLoad.HIGH));
    }

    @Test
    public void test7() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(960, Delivery.calculateShippingCost(Distances.generateDistanceInRange(3, 11), Dimensions.LARGE, true, ServiceLoad.VERY_HIGH));
    }

    @Test
    public void test8() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(540, Delivery.calculateShippingCost(Distances.generateDistanceInRange(0, 2), Dimensions.SMALL, true, ServiceLoad.INCREASED));
    }

    @Test
    public void test9() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(450, Delivery.calculateShippingCost(Distances.generateDistanceInRange(0, 2), Dimensions.SMALL, true, ServiceLoad.OTHER));
    }

    @Test
    public void test10() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(700, Delivery.calculateShippingCost(Distances.generateDistanceInRange(3, 10), Dimensions.SMALL, true, ServiceLoad.HIGH));
    }

    @Test
    public void test11() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(1120, Delivery.calculateShippingCost(Distances.generateDistanceInRange(11, 30), Dimensions.LARGE, true, ServiceLoad.VERY_HIGH));
    }

    @Test
    public void test12() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(700, Delivery.calculateShippingCost(Distances.generateDistanceInRange(11, 30), Dimensions.LARGE, true, ServiceLoad.OTHER));
    }
}
