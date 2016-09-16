package com.ayadykin.blackjack.core.timer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ayadykin.blackjack.core.table.BlackJackTable;

/**
 * Created by Yadykin Andrii Sep 15, 2016
 *
 */

@Stateless
public class StartGameTimer {

    private static final Logger logger = LoggerFactory.getLogger(StartGameTimer.class);

    @Resource
    private TimerService timerService;
    private BlackJackTable blackJackTable;

    public void setStartGameTimer(BlackJackTable blackJackTable) {
        this.blackJackTable = blackJackTable;
        logger.debug(" setTimer ");
        timerService.createSingleActionTimer(10000, null);
    }

    @Timeout
    public void timeoutTimerService() {
        blackJackTable.startGame();
        logger.debug(" timeoutTimerService ");
    }
}