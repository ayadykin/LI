package com.ayadykin.blackjack.services;

import com.ayadykin.blackjack.exceptions.BlackJackException;
import com.ayadykin.blackjack.rest.dto.PlayerActionDto;
import com.ayadykin.blackjack.rest.dto.ResponseDto;

/**
* Created by Andrey Yadykin on 22 ���. 2016 �.
*/


public interface GameService {
    ResponseDto initGame(Integer id) throws BlackJackException;
   
}
