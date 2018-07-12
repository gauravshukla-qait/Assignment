package com.qainfotech.tap.training.snl.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qainfotech.tap.training.snl.api.Board;
import com.qainfotech.tap.training.snl.api.GameInProgressException;
import com.qainfotech.tap.training.snl.api.MaxPlayersReachedExeption;
import com.qainfotech.tap.training.snl.api.PlayerExistsException;

public class TestSNL {

	Board boardObject;
	
	/*@BeforeTest
	public void init() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		
	}*/
	
	@Test//(expectedExceptions = {FileNotFoundException.class, UnsupportedEncodingException.class, PlayerExistsException.class, GameInProgressException.class, MaxPlayersReachedExeption.class, IOException.class})
	public void addMoreThan4Players() {// throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
//		boolean flag = false;
		try{
			boardObject = new Board();
			boardObject.registerPlayer("player1");
			boardObject.registerPlayer("player2");
			boardObject.registerPlayer("player3");
			boardObject.registerPlayer("player4");
			boardObject.registerPlayer("player5");
		}
		catch(Exception e){
//			if(e instanceof MaxPlayersReachedExeption)
///			flag = true;
			Assert.assertEquals(boardObject.getData().getJSONArray("players").length(), 4);
		}
//		Assert.assertTrue(flag);
	}
	
	/*@Test
	public void addingPlayersWithSameName() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
//		boolean flag = false;
		try {
			boardObject.registerPlayer("player1");
			boardObject.registerPlayer("player1");
			boardObject.registerPlayer("player4");
			boardObject.registerPlayer("player5");
		}catch(Exception e) {
//			if(e instanceof PlayerExistsException)
//				System.out.println(e);
//				flag = true;
		}
//		Assert.assertTrue(flag);
		
		Assert.assertEquals(boardObject.getData().getJSONArray("players").length(), 3);
	}*/
}










