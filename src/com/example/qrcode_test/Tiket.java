package com.example.qrcode_test;

public class Tiket {
 private String tiketID;
 private String gameID;
 
 Tiket(String _tiketID, String _gameID){
	 setGameID(_gameID);
	 setTiketID(_tiketID);
	 
 }
protected String getTiketID() {
	return tiketID;
}
private void setTiketID(String tiketID) {
	this.tiketID = tiketID;
}
protected String getGameID() {
	return gameID;
}
private void setGameID(String gameID) {
	this.gameID = gameID;
}

}
