package Test;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/13 下午12:22
 * @description
 **/
public class Dijkstra {
    int n;
    int m;

    final int N = 200010;

    int []h = new int[N];
    int []e = new int[N];
    int []ne = new int[N];
    int []w = new int[N];
    int []d = new int[N];
    boolean []st = new boolean[N];

    int idx = 0;

    class Pair{

        public Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }

    int dijk(){
        d[1] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((Comparator.comparingInt(o -> o.y)));
        q.add(new Pair(0,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int v = p.y;
            if(st[v])continue;
            st[v] = true;
            for(int i = h[v];i != -1;i = ne[i]){
                int j = e[i];
                if(d[j] > d[v] + w[i]){
                    d[j] = d[v] + w[i];
                    q.add(new Pair(d[j],j));
                }
            }
        }
        return d[n];
    }

    void add(int a,int b,int c){
        e[idx] = b;ne[idx] = h[a];w[idx] = c;h[a] = idx++;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dijkstra dijkstra = new Dijkstra();
        Arrays.fill(dijkstra.h,-1);
        Arrays.fill(dijkstra.d,0x3f);
        dijkstra.n = sc.nextInt();
        dijkstra.m = sc.nextInt();
        for ( int i = 0; i < dijkstra.m; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dijkstra.add(a,b,c);
        }
        int dijk = dijkstra.dijk();
        System.out.println(dijk == 0x3f3f3f3f ? -1 : dijk);
    }
}
