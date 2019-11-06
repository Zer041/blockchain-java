package com.blockchaincore;


import java.util.ArrayList;
import java.time.Instant;

import com.utils.*;

public class Block {
	// Strings
	public String hash;
	public String previousHash;
	public String data;
	public ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	private int difficulty; 
	// unixtime
	private long timeStamp;
	private int nonce; 
	
	public Block(String data, String previousHash, ArrayList<Transaction> transactions, int difficulty) {
		this.difficulty = difficulty;
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = Instant.now().getEpochSecond();


		//this.timeStamp = System.currentTimeMillis() / 1000L;
		this.transactions = transactions;
		this.hash = calculateHash();
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(previousHash + transactions + Long.toString(timeStamp) + data + nonce);
		return calculatedhash;
	}
	
	
	// address winner implementation left
	public void mineBlock() {
		String target = new String(new char[this.difficulty]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, this.difficulty).equals(target)) {
			nonce++;
			hash = calculateHash();
			//System.out.println(hash);
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}
