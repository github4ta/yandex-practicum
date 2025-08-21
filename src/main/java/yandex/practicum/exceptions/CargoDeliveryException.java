package yandex.practicum.exceptions;

public class CargoDeliveryException extends Exception {

    public CargoDeliveryException(int distance) {
        super(String.format("Distance cannot be negative. Your distance is %s.", distance));
    }
}
