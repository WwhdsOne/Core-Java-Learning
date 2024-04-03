package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 11:59
 * @description volatile字段
 **/
public class volatie字段 {


    public static void main(String[] args) {

    }
    private boolean done;
    public synchronized boolean isDone() {
        return done;
    }

    public synchronized void setDone(boolean done) {
        this.done = done;
    }
}
