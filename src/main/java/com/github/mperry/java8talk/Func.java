package com.github.mperry.java8talk;

/**
 * Created by MarkPerry on 10/02/14.
 */
public interface Func<A, B> {

    B f(A a);

    default <C> Func<A, C> andThen(Func<B, C> f) {
       return a -> f.f(f(a));
    }

    default <C> Func<C, B> compose(Func<C, A> f) {
        return c -> f(f.f(c));
    }
}
