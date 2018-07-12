package com.qainfotech.tap.training;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.InvalidTurnException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.NoUserWithSuchUUIDException;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class TestSNL {

	Board boardObject;
	JSONObject player;
	JSONArray players;
	UUID Uuid;

	@BeforeTest
	public void init() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		boardObject = new Board();
		Uuid = UUID.randomUUID();
	}
	
	@Test(priority=1)//(expectedExceptions = {FileNotFoundException.class, UnsupportedEncodingException.class, PlayerExistsException.class, GameInProgressException.class, MaxPlayersReachedExeption.class, IOException.class})
	public void addMoreThan4Players() {// throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
//		boolean flag = false;
		int length = 0;
		try{
			boardObject.registerPlayer("player1");
			boardObject.registerPlayer("player2");
			boardObject.registerPlayer("player3");
//			boardObject.registerPlayer("player4");
//			boardObject.registerPlayer("player5");
		}
		catch(Exception e){                               
			if(e instanceof MaxPlayersReachedExeption) {
//				System.out.println(e);
//				flag = true;
				length = boardObject.getData().getJSONArray("players").length();
				System.out.println(length);
			}
			
	//		 Assert.assertEquals();
	//		Assert.assertEquals(length , length >= 0 );
			Assert.assertTrue(length <= 4);
		}
	//Assert.assertTrue(flag);
	}
	
	@Test
	public void addingPlayersWithSameName() throws FileNotFoundException, UnsupportedEncodingException, GameInProgressException, MaxPlayersReachedExeption, IOException {
	
		boardObject = new Board();
		try {
			boardObject.registerPlayer("player1");
			boardObject.registerPlayer("player1");
		}catch (PlayerExistsException e) {
			assertEquals("Player '"+"player1"+"' already exists on board", e.getMessage());
		}
	}
	
	@Test
	public void addPlayerWhenGameInProgress() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException,  MaxPlayersReachedExeption {
		int initialLength = boardObject.getData().getJSONArray("players").length();
		
		  for(Object playerObject : boardObject.getData().getJSONArray("players")) {
			  player = (JSONObject) playerObject;
			  player.put("position", 1);
		  }
		  try {
		  boardObject.registerPlayer("newPlayer");
		  }catch(GameInProgressException e) {
		  int lengthAfterAddingPlayer = boardObject.getData().getJSONArray("players").length();
		  Assert.assertEquals(initialLength, lengthAfterAddingPlayer, "You can't add player when game in progress");
		  }
	}
	
	@Test()
	public void deletePlayerWhenUuidExist() throws NoUserWithSuchUUIDException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
		int initialLengthOfPlayerArray = boardObject.getData().getJSONArray("players").length();
		player = (JSONObject) boardObject.getData().getJSONArray("players").get(0);
		boardObject.deletePlayer((UUID) player.get("uuid"));
		int lengthOfPlayerArrayAfterDeletion = boardObject.getData().getJSONArray("players").length();
		Assert.assertEquals(lengthOfPlayerArrayAfterDeletion, initialLengthOfPlayerArray-1);
	}
	
	@Test
	public void deletePlayerWhenUuidDoesNotExist() throws FileNotFoundException, UnsupportedEncodingException, NoUserWithSuchUUIDException {
		try{
			boardObject.deletePlayer(Uuid);
		}catch (NoUserWithSuchUUIDException e) {
			assertTrue(e.getMessage().equals("No Player with uuid '"+Uuid+"' on board")); 
		}		
	}
	
	@Test(dependsOnMethods = {"deletePlayerWhenUuidExist"})
	public void playerExistAfterDeletion() {
		boolean flag = true;
		players = boardObject.getData().getJSONArray("players");
		for(Object player : players) {
			JSONObject objPlayer = (JSONObject) player;
			if(objPlayer.get("uuid") == Uuid) 
				flag = false;
			break;
		}
		assertTrue(flag);
	}
	
	 @Test
	 public void rollDiceWithoutAnyPlayer() throws InvalidTurnException, IOException {
		 try{
			 boardObject.rollDice(Uuid);
		 }catch (Exception e) {
			 assertEquals(e.getMessage(), "No Player with uuid '"+Uuid+"' on board");
		}
	 }
}











