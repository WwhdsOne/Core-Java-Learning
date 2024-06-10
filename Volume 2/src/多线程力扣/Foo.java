package 多线程力扣;

class FooBar {
    private int n;

    private int num = 1;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for ( int i = 0; i < n; i++ ) {
            synchronized (this) {
                while ( (num & 1) != 1 ) {
                    wait();
                }
                printFoo.run();
                num++;
                notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for ( int i = 0; i < n; i++ ) {
            synchronized (this) {
                while ( (num & 1) == 1 ) {
                    wait();
                }
                printBar.run();
                num++;
                notifyAll();
            }
        }
    }
}
