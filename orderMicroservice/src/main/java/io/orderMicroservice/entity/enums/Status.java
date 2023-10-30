package io.orderMicroservice.entity.enums;

import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
public enum Status {

    PENDENTE("Pendente"),
    CONFIRMADO("Confirmado"),
    ENTREGUE("Entregue");


    private final String value;
    Status(String value) {
        this.value = value;
    }

    public static Optional<Status> fromString(String description) {
        return Stream.of(values())
                .filter(status -> status.getValue().equals(description))
                .findFirst();
    }
}
