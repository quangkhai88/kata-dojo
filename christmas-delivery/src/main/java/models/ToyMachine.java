package models;

import java.util.UUID;

/**
 * @author Quang-Khai TRAN
 * @date 13/04/2022
 */

public class ToyMachine {

    public Present makePresent() {
        System.out.println("Machine gives a present");
        return new Present(UUID.randomUUID());
    }

}
