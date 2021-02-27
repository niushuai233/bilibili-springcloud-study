import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ns
 * @date 2021/2/27
 */
public class T {

    private AtomicInteger atomicInteger = new AtomicInteger(100);

    public final int getAndIncrement() {
        int current;
        int next;

        do {
            current = this.atomicInteger.get();
            next = current == Integer.MAX_VALUE ? 0 : current + 1;
            System.out.println("current: " + current + "  next: " + next);
        } while (!this.atomicInteger.compareAndSet(current, next));

        System.out.println("next = " + next);

        return next;
    }


    @Test
    public void tes() {

        int andIncrement = new T().getAndIncrement();

        System.out.println(andIncrement);
    }
}
