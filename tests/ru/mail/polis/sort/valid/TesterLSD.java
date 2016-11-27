
package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.LSD;
import ru.mail.polis.sort.HelperLSD;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TesterLSD {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                {0},
                {0, 0, 0, 0},
                {4, 3, 2, 1},
                {0, 1, 1, 0},
                {1},
                {Long.MAX_VALUE, Long.MAX_VALUE-2, Long.MAX_VALUE-3, Long.MAX_VALUE-4},
                HelperLSD.gen(1),
                HelperLSD.gen(10),
                HelperLSD.gen(100),
                HelperLSD.gen(1000),
                HelperLSD.gen(10000),
        });
    }

    private boolean isSorted(long[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_checkLSD() throws IOException {
        Assert.assertTrue(isSorted(LSD.sort(array)));
    }

}