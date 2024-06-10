package Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/13 下午1:46
 * @description Map遍历比较
 **/
public class Map遍历速度 {

    static Map<Integer,String> map = new HashMap<>(){{
        for(int i = 1;i<=10000;i++){
            map.put(i,"val" + i);
        }
    }};
    public static void main(String[] args) {

    }


    public void entrySet() {
        // 遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Integer k = entry.getKey();
            String v = entry.getValue();
        }
    }


    public void forEachEntrySet() {
        // 遍历
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer k = entry.getKey();
            String v = entry.getValue();
        }
    }


    public void keySet() {
        // 遍历
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer k = iterator.next();
            String v = map.get(k);
        }
    }


    public void forEachKeySet() {
        // 遍历
        for (Integer key : map.keySet()) {
            Integer k = key;
            String v = map.get(k);
        }
    }


    public void lambda() {
        // 遍历
        map.forEach((key, value) -> {
            Integer k = key;
            String v = value;
        });
    }


    public void streamApi() {
        // 单线程遍历
        map.entrySet().stream().forEach((entry) -> {
            Integer k = entry.getKey();
            String v = entry.getValue();
        });
    }

    public void parallelStreamApi() {
        // 多线程遍历
        map.entrySet().parallelStream().forEach((entry) -> {
            Integer k = entry.getKey();
            String v = entry.getValue();
        });
    }
}
