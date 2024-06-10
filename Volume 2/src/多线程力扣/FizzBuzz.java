package 多线程力扣;

import java.util.function.IntConsumer;


class FizzBuzz {
    private int n;

    private final Object lock = new Object();

    private int count = 1;

    private int countMod3 = 0;
    private int countMod5 = 0;
    private int countMod5And3 = 0;
    private int countNo = 0;

    public FizzBuzz(int n) {
        this.n = n;
        for ( int i = 1; i <= n; i++ ) {
            if ( i % 3 == 0 && i % 5 == 0 ) countMod5And3++;
            else if ( i % 3 == 0 ) countMod3++;
            else if ( i % 5 == 0 ) countMod5++;
            else countNo++;
        }
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        for ( int i = 0; i < countMod3; ) {
            synchronized (this) {
                if ( count % 3 == 0 && count % 5 != 0 ) {
                    printFizz.run();
                    count++;
                    i++;
                    notifyAll();
                }
            }
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        for ( int i = 0; i < countMod5; ) {
            synchronized (this) {
                if ( count % 3 != 0 && count % 5 == 0 ) {
                    printBuzz.run();
                    count++;
                    i++;
                    notifyAll();
                }
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for ( int i = 0; i < countMod5And3; ) {
            synchronized (this) {
                if ( count % 3 == 0 && count % 5 == 0 ) {
                    printFizzBuzz.run();
                    count++;
                    i++;
                    notifyAll();
                }
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for ( int i = 0; i < countNo; ) {
            synchronized (this) {
                if ( count % 3 != 0 && count % 5 != 0 ) {
                    printNumber.accept(count);
                    count++;
                    i++;
                    notifyAll();
                }
            }
        }
    }
}
