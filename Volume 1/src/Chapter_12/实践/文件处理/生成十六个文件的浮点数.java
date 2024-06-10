package Chapter_12.实践.文件处理;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/29 下午7:08
 * @description 生成十个文件的浮点数
 **/
public class 生成十六个文件的浮点数 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(16);

    private static final Random random = new Random();

    private final Integer num = 1000000;

    static final Integer loopTimes = 144;

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        生成十六个文件的浮点数 generateFiles = new 生成十六个文件的浮点数();
        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < loopTimes; i++) {
            int finalI = i;
            Future<Double> future = executorService.submit(() -> {
                try {
                    return generateFiles.generateFiles(finalI);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }
        executorService.shutdown();

        double total = 0;
        for (Future<Double> future : futures) {
            total += future.get();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Total sum: " + df.format(total));
    }

    public double generateFiles(Integer num) throws IOException {
        double sum = 0;
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Programming_Learning\\Project\\Core Java\\Volume 1\\src\\Chapter_12\\实践\\文件处理\\file" + num + ".txt");
        for (int i = 0; i < this.num; i++) {
            double value = random.nextDouble(50,100);
            sum += value;
            fileOutputStream.write((value + "\n").getBytes());
        }
        System.out.println(Thread.currentThread().getName() + "生成文件" + num + " total sum: " + sum);
        return sum;
    }
}
