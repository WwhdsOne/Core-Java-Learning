package Test;

import java.util.concurrent.*;

public class 吉利矩阵 {
    private static int l;
    private static int n;
    private static int[] matrix = new int[10];
    private static int count = 0;
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        l = 5; // replace with actual input
        n = 3; // replace with actual input
        Future<Integer> future = executorService.submit(new DFS(0));
        count = future.get();
        System.out.println(count);
        executorService.shutdown();
    }

    static class DFS implements Callable<Integer> {
        private int pos;

        public DFS(int pos) {
            this.pos = pos;
        }

        @Override
        public Integer call() throws Exception {
            if (pos == n * n) {
                int[][] g = new int[10][10];
                for (int i = 0; i < n * n; i++) {
                    g[i / 3][i % 3] = matrix[i];
                }
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) sum += g[i][j];
                    if (sum != l) ok = false;
                }
                if (!ok) return 0;
                for (int i = 0; i < n; i++) {
                    int sum = 0;
                    for (int j = 0; j < n; j++) sum += g[j][i];
                    if (sum != l) ok = false;
                }
                if (!ok) return 0;
                return 1;
            }
            int count = 0;
            for (int i = 0; i <= l; i++) {
                matrix[pos] = i;
                count += executorService.submit(new DFS(pos + 1)).get();
            }
            return count;
        }
    }
}
