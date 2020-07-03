import org.junit.Test;
import static org.junit.Assert.*;

public class OffByNtest {

    @Test
    public void testOffByN() {
    OffByN offByN5 = new OffByN(5);
    assertTrue(offByN5.equalChars('a', 'f'));
    assertTrue(offByN5.equalChars('f', 'a'));
    assertFalse(offByN5.equalChars('a', 'd'));
    }
}
