package com.github.mperry.java8talk;

import org.junit.Test;

/**
 * Created by MarkPerry on 10/02/14.
 */
public class ConflictTest {

    public interface A {
        default void hello() { System.out.println("Hello World from A"); }
    }

    public interface B {
        default void hello() { System.out.println("Hello World from B"); }
    }

    public class C implements A, B {
        public void hello() {
            A.super.hello();
        }
    }

    @Test
    public void test1() {

    }

}
