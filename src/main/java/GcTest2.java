import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Spirit
 * @since 2019-02-28
 * 启动：-Xms41m -Xmx41m -Xmn10m -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
 */
public class GcTest2 {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) {
        System.out.println("-----------------------JVM-Info-start----------------");

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage mu = memoryMXBean.getHeapMemoryUsage();

        System.out.println("heapInfo:" +  mu);
        System.out.println("初始化堆:" +  mu.getInit()/1024/1024 + "Mb");
        System.out.println("最大堆值:"  +  mu.getMax()/1024/1024 + "Mb");
        System.out.println("已用堆值:" +  mu.getUsed()/1024/1024 + "Mb");

        System.out.println("0.---");
        List caches = new ArrayList();
        for (int i = 0; i < 11; i++){
            System.out.println("current index: " + i);
            caches.add(new byte[3 * _1MB]);
        }
        System.out.println("1.---");
        caches.add(new byte[3 * _1MB]);
        caches.remove(0);
        caches.add(new byte[3 * _1MB]);
        for (int i = 0; i < 8; i++) {
            caches.remove(0);
        }
        caches.add(new byte[3 * _1MB]);
        System.out.println("2.---");
        for (int i = 0; i < 7; i++){
            caches.add(new byte[3 * _1MB]);
        }
    }
}