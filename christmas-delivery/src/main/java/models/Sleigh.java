package models;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Quang-Khai TRAN
 * @date 13/04/2022
 */

@Getter
public class Sleigh {

    private final Set<Present> presents = new HashSet<>();

    public void receive(Present present) {
        this.presents.add(present);
    }

    public boolean isFull() {
        return this.presents.size() == 10;
    }
}
