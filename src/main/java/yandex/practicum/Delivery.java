package yandex.practicum;

import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

public class Delivery {

    private final static int MIN_SHIPPING_COST_RUB = 400;
    private final static int ADDITIONAL_300_RUB = 300;
    private final static int ADDITIONAL_200_RUB = 200;
    private final static int ADDITIONAL_100_RUB = 100;
    private final static int ADDITIONAL_50_RUB = 50;

    private final static int DISTANCE_30_KM = 30;
    private final static int DISTANCE_10_KM = 10;
    private final static int DISTANCE_2_KM = 2;

    private final static double COEFFICIENT_SERVICE_LOAD_VERY_HIGH = 1.6;
    private final static double COEFFICIENT_SERVICE_LOAD_HIGH = 1.4;
    private final static double COEFFICIENT_SERVICE_INCREASED = 1.2;
    private final static double COEFFICIENT_SERVICE_OTHER = 1.0;

    public static int calculateShippingCost(int distance, Dimensions dimensions, boolean isFragile, ServiceLoad serviceLoad) throws FragileCargoDeliveryException, CargoDeliveryException {
        int shippingCost = 0;

        if (distance < 0) {
            throw new CargoDeliveryException(distance);
        }

        if (distance > DISTANCE_30_KM && isFragile) {
            throw new FragileCargoDeliveryException(DISTANCE_30_KM, distance);
        }

        if (isFragile && distance <= DISTANCE_30_KM) {
            shippingCost += ADDITIONAL_300_RUB;
        }

        if (distance > DISTANCE_30_KM) {
            shippingCost += ADDITIONAL_300_RUB;
        } else if (distance > DISTANCE_10_KM) {
            shippingCost += ADDITIONAL_200_RUB;
        } else if (distance > DISTANCE_2_KM) {
            shippingCost += ADDITIONAL_100_RUB;
        } else {
            shippingCost += ADDITIONAL_50_RUB;
        }

        switch (dimensions) {
            case Dimensions.LARGE:
                shippingCost += ADDITIONAL_200_RUB;
                break;
            case Dimensions.SMALL:
                shippingCost += ADDITIONAL_100_RUB;
                break;
        }

        switch (serviceLoad) {
            case ServiceLoad.VERY_HIGH -> shippingCost *= COEFFICIENT_SERVICE_LOAD_VERY_HIGH;
            case ServiceLoad.HIGH -> shippingCost *= COEFFICIENT_SERVICE_LOAD_HIGH;
            case ServiceLoad.INCREASED -> shippingCost *= COEFFICIENT_SERVICE_INCREASED;
            case ServiceLoad.OTHER -> shippingCost *= COEFFICIENT_SERVICE_OTHER;
        }

        return (shippingCost < MIN_SHIPPING_COST_RUB) ? MIN_SHIPPING_COST_RUB : shippingCost;
    }
}
