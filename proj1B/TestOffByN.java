import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    CharacterComparator OffByN = new OffByN(0);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertFalse(OffByN.equalChars('b', 'a'));
        assertFalse(OffByN.equalChars('c', 'D'));
        assertTrue(OffByN.equalChars('d', 'd'));
        assertTrue(OffByN.equalChars('%', '%'));
        assertFalse(OffByN.equalChars('F', 'f'));
    }
}
