package com.github.mperry.java8talk;

import fj.F2;
import org.junit.Assert;
import org.junit.Test;
//import fj..F2;

/**
 * Created by MarkPerry on 9/02/14.
 */
public class FlipTest {


    @Test
    public void test1() {
        F2<Integer, Integer, Integer> f2 = (a, b) -> { return a + b; };
        int x = f2.flip().f(3, 4);
        Assert.assertTrue(x == 7);
    }

}
