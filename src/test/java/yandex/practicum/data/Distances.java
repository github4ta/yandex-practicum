package yandex.practicum.data;

public class Distances {

    public static int generateDistanceInRange(int begin, int end) {
        return (int) (begin + (end - begin + 1) * Math.random());
    }
}
