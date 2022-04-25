package models;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author Quang-Khai TRAN
 * @date 13/04/2022
 */

@Getter
@Setter
public class Elf implements Runnable{

    private Supplier<Present> supplier;
    private Consumer<Present> consumer;
    private Consumer<Elf> callBack;

    private final String name = "ELF-X";

    public Elf(Supplier<Present> supplier, Consumer<Present> consumer, Consumer<Elf> callBack) {
        this.supplier = supplier;
        this.consumer = consumer;
        this.callBack = callBack;
    }

    @Override
    public void run() {
        System.out.println(this.name + " start working");
        this.walk();
        Present present = this.supplier.get();
        this.walk();

        System.out.println(this.name + " is still working");

        this.consumer.accept(present);
        this.notifySanta();
    }

    private void walk(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void notifySanta() {
        this.callBack.accept(this);
    }

}
