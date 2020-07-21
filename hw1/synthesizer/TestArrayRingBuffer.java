package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(0.1);
        arb.enqueue(1.2);
        arb.enqueue(2.3);
        arb.enqueue(3.4);
        arb.enqueue(4.5);
        arb.enqueue(5.6);
        arb.dequeue();
        arb.dequeue();
        System.out.println(arb.fillCount());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);

    }
} 
