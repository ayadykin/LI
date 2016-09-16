package com.ayadykin.blackjack.rest;

import java.util.concurrent.Callable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ayadykin.blackjack.actions.PlayerStatus;
import com.ayadykin.blackjack.rest.dto.PlayerActionDto;
import com.ayadykin.blackjack.rest.dto.ResponseDto;
import com.ayadykin.blackjack.services.GameService;

/**
 * Created by Andrey Yadykin on 22.02.2016.
 */

@Stateless
@Path("/blackjack")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlackJackRestService {

    private static final Logger logger = LoggerFactory.getLogger(BlackJackRestService.class);

    @EJB
    private GameService gameService;

    @GET
    public Response newGame() {
        return Response.ok().build();
    }

    @GET
    @Path("/list")
    public Response getList() {
        return Response.ok().build();
    }

    @GET
    @Path("/status")
    public Response status() {
        PlayerStatus playerStatus = null;
        try {
            Callable<PlayerStatus> f = gameService.gameStatus();
            playerStatus = f.call();
        } catch (Exception e) {
            logger.error(" status error : {}", e.getMessage());
        }
        return Response.ok(playerStatus).build();
    }
    
    @GET
    @Path("/getCards")
    public Response getCards() {
        ResponseDto responseDto = null;
        try {
            Callable<ResponseDto> f = gameService.getCards();
            responseDto = f.call();
        } catch (Exception e) {
            logger.error(" status error : {}", e.getMessage());
        }
        return Response.ok(responseDto).build();
    }
    
    @POST
    public Response gameAction(PlayerActionDto playerActionDto) {
        return Response.ok(gameService.gameAction(playerActionDto)).build();
    }

}
