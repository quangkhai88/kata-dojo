package models;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * @author Quang-Khai TRAN
 * @date 13/04/2022
 */

public class Santa implements Runnable{

    private final Sleigh sleigh;
    private final int NUMBER_OF_PRESENT= 10;

    private final Elf elf;

    public Santa(Sleigh sleigh, ToyMachine toyMachine) {
        this.sleigh = sleigh;
        this.elf = new Elf(toyMachine::makePresent, this.packToSleigh(), this.elfCallBack());
    }


    @Override
    public void run() {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        //Manipulate elf
        int i = 0;
        while (i < this.NUMBER_OF_PRESENT) {
            executor.execute(this.elf);
            i++;
        }
        executor.shutdown();
    }

    private Consumer<Elf> elfCallBack() {
        return (Elf elf) -> {
            System.out.println(elf.getName() + ": i'm available, i can continue to work");
        };
    }

    private Consumer<Present> packToSleigh() {
        return (present) -> {
            System.out.println("Bags receive a present");
            this.sleigh.receive(present);
            this.checkSleigh();
        };
    }

    private void checkSleigh() {
        if (this.sleigh.getPresents().size() == this.NUMBER_OF_PRESENT) {
            System.out.println("========== Ok it's finished !!!! End work ============ My bags has " + this.sleigh.getPresents().size());
        }
    }

    private boolean isOk() {
        return this.sleigh.getPresents().size() == this.NUMBER_OF_PRESENT;
    }

    public static void main(String ...args) {
        Santa santa = new Santa(new Sleigh(), new ToyMachine());
        Thread t = new Thread(santa);
        t.start();
    }


}
