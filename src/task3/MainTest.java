package task3;

import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    public void fuzzySearchStream() {
        Assert.assertTrue(Main.fuzzySearchStream("car", "ca6$$#_rtwheel"));
        Assert.assertTrue(Main.fuzzySearchStream("cwhl", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearchStream("cwhee", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearchStream("cartwheel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearchStream("cwheeel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearchStream("lw", "cartwheel"));
    }

    @Test
    public void fuzzySearchLoop() {
        Assert.assertTrue(Main.fuzzySearchLoop("car", "ca6$$#_rtwheel"));
        Assert.assertTrue(Main.fuzzySearchLoop("cwhl", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearchLoop("cwhee", "cartwheel"));
        Assert.assertTrue(Main.fuzzySearchLoop("cartwheel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearchLoop("cwheeel", "cartwheel"));
        Assert.assertFalse(Main.fuzzySearchLoop("lw", "cartwheel"));
    }
}