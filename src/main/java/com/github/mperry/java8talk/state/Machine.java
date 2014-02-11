package com.github.mperry.java8talk.state;

/**
 * Created by MarkPerry on 11/02/14.
 */
public class Machine {

    Boolean locked;
    int chips;
    int coins;

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

}
