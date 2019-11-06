package com.blockchaincore;

import java.sql.Date;
import java.time.Instant;

import com.utils.StringUtil;

public class Transaction {
	public String fromAddress;
	public String toAddress;
	private long timestamp;
	private String transactionHash;
	public int value;
	public int hash;
	
	public Transaction(String fromAddress, String toAddress, int value) {
		this.timestamp = Instant.now().getEpochSecond();
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.value = value;
		this.transactionHash = calculateHash();
		makeTransaction();
	}
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(this.fromAddress + this.toAddress + Long.toString(timestamp) + value);
		return calculatedhash;
	}
	
	public String[] makeTransaction() {
		String[] x = {String.valueOf(this.transactionHash),  String.valueOf(this.timestamp), String.valueOf(this.fromAddress), String.valueOf(this.toAddress), String.valueOf(this.value)};
		return x;
	}
	
	public boolean checkBalance(String address, float transfer) {
		return false;
		
	}
}
