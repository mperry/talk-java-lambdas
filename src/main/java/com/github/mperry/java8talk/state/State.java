package com.github.mperry.java8talk.state;

import fj.F;
import fj.P;
import fj.P2;
import fj.Unit;

/**
 * Created by MarkPerry on 10/02/14.
 */
public class State<S, A> {

    F<S, P2<A, S>> run;

    public State(F<S, P2<A, S>> f) {
        run = f;
    }

    public P2<A, S> run(S s) {
        return run.f(s);
    }

    public static <S1, A1> State<S1, A1> lift(F<S1, P2<A1, S1>> f) {
        return new State<S1, A1>(f);
    }

    public <B> State<S, B> map(F<A, B> f) {
        return lift( (S s) -> {
                P2<A, S> p2 = run.f(s);
                B b = f.f(p2._1());
                return P.p(b, p2._2());
        });
    }

    public <B, C, D> State<S, C> flatMap(State<S, B> mb, F<B, State<S, C>> f) {
        return mb.flatMap(f);
    }

    public <B> State<S, B> flatMap(F<A, State<S, B>> f) {
        return lift( (S s) -> {
                P2<A, S> p = run.f(s);
                A a = p._1();
                S s2 = p._2();
                State<S, B> smb = f.f(a);
                return smb.run.f(s2);
        });
    }

    public <S1, A1> State<S1, A1> unit(F<S1, P2<A1, S1>> f) {
        return lift(f);
    }

    public static <S> State<S, S> get() {
        return lift((S s) -> P.p(s, s));
    }

    public static <S> State<S, Unit> put(S s) {
        return lift((S s2) -> P.p(Unit.unit(), s));

    }

    public A eval(S s) {
        return run(s)._1();
    }

}
