package com.github.mperry.java8talk;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MarkPerry on 10/02/14.
 */
public class FuncTest {

    @Test
    public void test1() {
        Func<Integer, Integer> f = i -> i + 1;
        Func<Integer, Integer> g = i -> i * 2;
        Func<Integer, Integer> h = f.andThen(g);
        Integer i = h.f(3);
        assertTrue(i == 8);
        assertTrue(f.andThen(j -> j * 2).f(3) == 8);
    }

}
