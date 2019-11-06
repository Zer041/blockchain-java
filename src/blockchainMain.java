//import java.util.ArrayList;

import com.blockchaincore.*;
import com.utils.MyResult;


public class blockchainMain {
	//public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int difficulty = 4;
	
	public static void main(String[] args) {	
		//add our blocks to the blockchain ArrayList:
		Blockchain blck = new Blockchain(difficulty);
		blck.mineBlock("bloque0");
		blck.addTransaction("Carlos", "Diego", 10);
		blck.addTransaction("Carlos", "Diego", 11);
		blck.addTransaction("Carlos", "Diego", 12);
		blck.addTransaction("Carlos", "Diego", 13);		
		blck.mineBlock("bloque1");
		blck.mineBlock("bloque2");
		blck.mineBlock("bloque3");
		blck.findTransactions("Carlos", "Diego", 1);
		blck.getChain(); 
	}


	/*
	public static boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
		}
		return true;
	}

	 	blockchain.add(new Block("Hi im the first block", "0", new Transaction("yo", "ti", 40).makeTransaction(), difficult));		
		blockchain.get(0).mineBlock();
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash, null, difficult)); 
		blockchain.get(1).mineBlock();
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash, null, difficult));
		blockchain.get(2).mineBlock();
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);		
		System.out.println(blockchainJson);
		System.out.println(isChainValid());
	 */
}
