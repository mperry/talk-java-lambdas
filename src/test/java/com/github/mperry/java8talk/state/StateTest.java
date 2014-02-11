package com.github.mperry.java8talk.state;

import com.github.mperry.java8talk.state.State;
import fj.P;
import fj.P2;
import fj.data.List;
import fj.data.Stream;

import java.util.Random;

/**
 * Created by MarkPerry on 11/02/14.
 */
public class StateTest {

    public class MyState {
        fj.data.List<Boolean> list;
        Random rand;

        public MyState(fj.data.List<Boolean> l, Random r) {
            list = l;
            rand = r;
        }

        public fj.data.List<Boolean> getList() { return list; }
        public Random getRandom() { return rand; }
    }

    State<P2<Boolean, Integer>, Integer> playGame(String s) {
        if (s.length() == 0) {


        }
        return null;
    }

    public void test1() {

        String s = "cabca";
        List<Character> list = List.fromString(s);

//        State.lift();
//        Stream.iterate((State<Random, Boolean> st2) -> {
//        });

    }

    public void test2() {
//        Stream.iterate((State<MyState, Boolean> s) -> {
//
//
////            s.eval()
//        }, State.lift((MyState s) -> {
//
//            Boolean b = s.getRandom().nextBoolean();
//            return P.p(b, new MyState(s.getList().snoc(b), s.getRandom()));
////            r.nextBoolean;
//        }));
    }

}
