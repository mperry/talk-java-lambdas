package com.github.mperry.java8talk;

import fj.P;
import fj.P2;
import fj.data.Stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static fj.Unit.unit;

/**
 * Created by MarkPerry on 11/02/14.
 */
public class PaperScissorsRock {

    enum Move { PAPER, SCISSORS, ROCK }
    enum MoveResult { WIN, LOSE, DRAW }

    public static void main(String args[]) {
        new PaperScissorsRock().gameSequence();
    }

    void gameSequence() {
        gameMessages().take(20).toList().foreach( s -> {
            System.out.println(s);
            return unit();
        });
    }

    Stream<String> gameMessages() {
        return messages().zipIndex().map( (P2<String, Integer> p2) ->
            String.format("game: %s %s", p2._2(), p2._1())
        );
    }

    Stream<String> messages() {
        return moves().zip(moves()).map( (P2<Move, Move> p) ->
            gameMessage(p._1(), p._2(), result(p._1(), p._2()))
        );
    }

    String gameMessage(Move m1, Move m2, MoveResult r) {
        return String.format("p1: %s p2: %s result: %s", m1, m2, gameResultMessage(r, "p1 wins", "p2 wins", "draw"));
    }

    String gameResultMessage(MoveResult r, String win, String lost, String draw) {
        return r == MoveResult.DRAW ? draw : (r == MoveResult.WIN ? win : lost);
    }

    Stream<Move> moves() {
        return Stream.range(1).map ( i ->
            randomMove(new Random())._2()
        );
    }

    P2<Random, Move> randomMove(Random r) {
        Move[] v = Move.values();
        return P.p(r, v[r.nextInt(v.length)]);
    }

    boolean beats(Move p1, Move p2) {
        Map<Move, Move> map = new HashMap<>();
        map.put(Move.PAPER, Move.ROCK);
        map.put(Move.SCISSORS, Move.PAPER);
        map.put(Move.ROCK, Move.SCISSORS);
        return map.get(p1) == p2;
    }

    boolean draw(Move m1, Move m2) {
        return m1 == m2;
    }

    MoveResult result(Move m1, Move m2) {
        return draw(m1, m2) ? MoveResult.DRAW : (beats(m1, m2) ? MoveResult.WIN : MoveResult.LOSE);
    }

}
