package Chapter_12.实践;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;

    volatile AtomicInteger dice = new AtomicInteger(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for ( int i = 1; i <= n; i++ ) {
            while ( dice.get() % 2 == 0 )Thread.yield();
            printNumber.accept(0);
            dice.getAndIncrement();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for ( int i = 2; i <= n; i+=2 ) {
            while ( dice.get() % 4 != 0 )Thread.yield();
            printNumber.accept(i);
            dice.getAndIncrement();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for ( int i = 1; i <= n; i+=2 ) {
            while ( dice.get() % 4 != 2 )Thread.yield();
            printNumber.accept(i);
            dice.getAndIncrement();
        }
    }
}
