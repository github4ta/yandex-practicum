package yandex.practicum.exceptions;

public class FragileCargoDeliveryException extends Exception {

    public FragileCargoDeliveryException(int maxDistance, int distance) {
        super(String.format("Fragile cargo cannot be transported over a distance of more than %s km. Your distance is %s.", maxDistance, distance));
    }
}
