package dev.aherscu.instancio.experiment.utils;

public class Tuple<X, Y> {
    private final X key;
    private final Y value;

    private Tuple(final X key, final Y value) {
        this.key = key;
        this.value = value;
    }

    public static <X, Y> Tuple<X, Y> of(X key, Y value) {
        return new Tuple<>(key, value);
    }

    public X getKey() {
        return key;
    }

    public Y getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Tuple[%s, %s]", key, value);
    }
}
