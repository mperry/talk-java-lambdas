package com.github.mperry.java8talk;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertTrue;

/**
 * Created by MarkPerry on 10/02/14.
 */
public class FunctionTest {


    @Test
    public void testAndThen() {
        Function<Integer, Integer> f = i -> i + 1;
        assertTrue(f.andThen(j -> j * 2).apply(2) == 6);
    }

}
