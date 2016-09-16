package com.ayadykin.blackjack.rest.dto;

import java.io.Serializable;

import com.ayadykin.blackjack.actions.GameActions;

/**
 * Created by Yadykin Andrii Sep 15, 2016
 *
 */

public class GameActionDto implements Serializable {
    private GameActions gameActions;

    public GameActions getGameActions() {
        return gameActions;
    }

    public void setGameActions(GameActions gameActions) {
        this.gameActions = gameActions;
    }

}
