package yandex.practicum;

import yandex.practicum.enums.Dimensions;
import yandex.practicum.enums.ServiceLoad;
import yandex.practicum.exceptions.CargoDeliveryException;
import yandex.practicum.exceptions.FragileCargoDeliveryException;

public class Main {

    public static void main(String[] args) {
        try {
            int shippingCost = Delivery.calculateShippingCost(-31, Dimensions.SMALL, true, ServiceLoad.INCREASED);
        } catch (FragileCargoDeliveryException e) {
            System.out.println(e.getMessage());
        } catch (CargoDeliveryException e) {
            System.out.println(e.getMessage());
        }
    }
}
