package yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

import java.util.stream.Stream;

import static yandex.practicum.enums.Dimensions.SMALL;

public class DeliveryNoneFragileTest {

    @Test
    @DisplayName("Single test")
    public void test1() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(400, Delivery.calculateShippingCost(1, SMALL, false, ServiceLoad.HIGH));
    }

    @Test
    public void testCalculateShippingCost() throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(400, Delivery.calculateShippingCost(11, Dimensions.LARGE, false, ServiceLoad.OTHER));
    }

    @ParameterizedTest
    @CsvSource({"17,SMALL,false,VERY_HIGH,480", "8,LARGE,false,VERY_HIGH,480", "5,SMALL,false,OTHER,400", "11,LARGE,false,HIGH,560", "2,LARGE,false,VERY_HIGH,400"})
    @DisplayName("Parameterized test with data")
    public void test3(int distance, Dimensions dimensions, boolean isFragile, ServiceLoad serviceLoad, int expected) throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(expected, Delivery.calculateShippingCost(distance, dimensions, isFragile, serviceLoad));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    @DisplayName("Parameterized test with test data from CSV file")
    public void test4(int distance, Dimensions dimensions, boolean isFragile, ServiceLoad serviceLoad, int expected) throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(expected, Delivery.calculateShippingCost(distance, dimensions, isFragile, serviceLoad));
    }

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of(1, SMALL, false, ServiceLoad.INCREASED, 400),
                Arguments.of(2, Dimensions.LARGE, false, ServiceLoad.OTHER, 400),
                Arguments.of(99, SMALL, false, ServiceLoad.INCREASED, 480),
                Arguments.of(16, Dimensions.LARGE, false, ServiceLoad.INCREASED, 480),
                Arguments.of(10000, SMALL, false, ServiceLoad.OTHER, 400)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    @DisplayName("Parameterized test with test data from method source")
    public void test5(int distance, Dimensions dimensions, boolean isFragile, ServiceLoad serviceLoad, int expected) throws CargoDeliveryException, FragileCargoDeliveryException {
        Assertions.assertEquals(expected, Delivery.calculateShippingCost(distance, dimensions, isFragile, serviceLoad));
    }
}
