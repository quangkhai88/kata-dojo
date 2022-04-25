package models;

import lombok.Getter;

import java.util.UUID;

/**
 * @author Quang-Khai TRAN
 * @date 13/04/2022
 */

@Getter
public class Present {

    private final UUID uuid;

    public Present(UUID uuid) {
        this.uuid = uuid;
    }
}
