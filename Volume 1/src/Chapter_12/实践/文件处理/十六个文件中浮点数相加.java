package Chapter_12.实践.文件处理;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/29 下午7:08
 * @description 读取十个文件中的浮点数并相加
 **/
public class 十六个文件中浮点数相加 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(16);
    public static void main(String[] args) {
        十六个文件中浮点数相加 sumFiles = new 十六个文件中浮点数相加();
        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 生成十六个文件的浮点数.loopTimes; i++) {
            int finalI = i;
            CompletableFuture<Double> future = CompletableFuture.supplyAsync(() ->
                    sumFiles.readAndSum("D:\\Programming_Learning" +
                            "\\Project\\Core Java\\Volume 1\\src\\Chapter_12\\实践\\文件处理\\file" + finalI + ".txt"), executorService)
                    .thenApply(result -> {
                        System.out.println(Thread.currentThread().getName() + "处理文件" + finalI + " total sum: " + result);
                        return result;
                    });
            futures.add(future);
        }
        double total = 0;
        for (Future<Double> future : futures) {
            try {
                total += future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Total sum: " + df.format(total));
    }

    private Double readAndSum(String fileName) {
        double sum = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sum += Double.parseDouble(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }
}
