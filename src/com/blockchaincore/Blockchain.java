package com.blockchaincore;
import java.util.ArrayList;
import com.utils.MyResult;
import com.google.gson.GsonBuilder;

public class Blockchain {
	private ArrayList<Transaction> pendingTransactions = new ArrayList<Transaction>(); 
	private ArrayList<Block> chain = new ArrayList<Block>(); 
	int difficulty;
	
	public Blockchain() {
	}
	
	public Blockchain(int difficulty) {
		this.difficulty = difficulty;
		createGenesisBlock();
	}
	
	// create genesis block
	public void createGenesisBlock() {
		chain.add(new Block("Genesis Block", "NULL", pendingTransactions, 0));
	}
	
	// mine block method
	public void mineBlock(String data) {
		//Block blck = new Block("test data", String.valueOf(chain.get(chain.size() - 1).hash), pendingTransactions, this.difficulty);
		Block blck = new Block(data, getLastHash(), pendingTransactions, this.difficulty);
		blck.mineBlock();
		chain.add(blck);
		pendingTransactions.clear();
		addTransaction("Ganador", "sad", 1000);
	}
	
	// get last block hash
	public String getLastHash() {
		return String.valueOf((chain.get(chain.size() - 1).hash));
	}
	
	// add block, method just for testing
	public void addBlock() {
		chain.add(new Block("block2", getLastHash(), pendingTransactions, this.difficulty));
	}
	
	// return entire chain
	public void getChain() {
		String chainJson = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
		System.out.println(chainJson);
	}
	
	// add transaction to pending transactions
	public void addTransaction(String fromAddress, String toAddress, int value) {
		pendingTransactions.add(new Transaction(fromAddress, toAddress, value));
	}
	
	public void removeTransactions(int index) {
		
	}
	
	
	public void findTransactions(String fromAddressFind, String toAddressFind, int valueFind) {
		for (int i = 0; i < chain.size() - 1; i++) {
			// block iteration
			//System.out.println("BLOQUE: " + i);
			//System.out.println(chain.get(i));
			for(int j = 0; j < ((chain.get(i).transactions).size() - 1); j++) {
				// transaction iteration
				//System.out.println("transaccion: " + j);
				if (chain.get(i).transactions.get(j).toAddress == toAddressFind && chain.get(i).transactions.get(j).fromAddress == fromAddressFind && chain.get(i).transactions.get(j).value == valueFind) {
					System.out.println(chain.get(i).transactions.get(j).toAddress);
					System.out.println(chain.get(i).transactions.get(j).fromAddress);
					System.out.println(chain.get(i).transactions.get(j).value);
				} else {
					System.out.println("No encontrada");
				}				
			}
		}
		//return new MyResult(-1, 0);	

	}
	
	public void checkIfFromAddressIntoBlockchain(String fromAddressFind) {
		for (int i = 0; i < chain.size() - 1; i++) {
			// block iteration
			System.out.println("BLOQUE: " + i);
			//System.out.println(chain.get(i));
			for(int j = 0; j < ((chain.get(i).transactions).size() - 1); j++) {
				// transaction iteration
				System.out.println("transaccion: " + j);
				if (chain.get(i).transactions.get(j).fromAddress == fromAddressFind) {
					System.out.println(chain.get(i).transactions.get(j).fromAddress);
				} else {
					System.out.println("No encontrada");
				}				
			}
		}
		//return new MyResult(-1, 0);	

	}
	public void checkIfToAddressIntoBlockchain(String toAddressFind) {
		for (int i = 0; i < chain.size() - 1; i++) {
			// block iteration
			System.out.println("BLOQUE: " + i);
			//System.out.println(chain.get(i));
			for(int j = 0; j < ((chain.get(i).transactions).size() - 1); j++) {
				// transaction iteration
				System.out.println("transaccion: " + j);
				if (chain.get(i).transactions.get(j).toAddress == toAddressFind) {
					System.out.println(chain.get(i).transactions.get(j).toAddress);
				} else {
					System.out.println("No encontrada");
				}				
			}
		}
		//return new MyResult(-1, 0);	

	}

	// returns block index and transaction index on the block
	public MyResult checkIfValueIntoBlockchain(int valueFind) {
		for (int i = 0; i < chain.size() - 1; i++) {
			// block iteration
			System.out.println("BLOQUE: " + i);
			//System.out.println(chain.get(i));
			for(int j = 0; j < ((chain.get(i).transactions).size() - 1); j++) {
				// transaction iteration
				System.out.println("transaccion: " + j);
				if (chain.get(i).transactions.get(j).value == valueFind) {
					System.out.println(chain.get(i).transactions.get(j).value);
					return new MyResult(i, j);
				} else {
					return new MyResult(-1, -1);
				}				
			}
		}
		return null;
	}
}

