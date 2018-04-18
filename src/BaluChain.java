import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class BaluChain {

	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
	
		public static void main(String[] args) {
			
			blockchain.add(new Block ("Hi im the first block" , "0")); //   Constructs Genesis  
			System.out.println("Trying to mine block 1... " );
			blockchain.get(0).mineBlock(difficulty);

			blockchain.add(new Block ("Yo im the second block", blockchain.get(blockchain.size()-1).hash)); // block 2 construction
			System.out.println("Trying to mine block 2..." );
			blockchain.get(1).mineBlock(difficulty);
			
			blockchain.add(new Block ("Hey im the third block", blockchain.get(blockchain.size()-1).hash));
			System.out.println("Trying to mine block 3...");
			blockchain.get(2).mineBlock(difficulty);
			
			System.out.println("\nBlockchain is valid: " + isChainValid());

			
			String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
			System.out.println("\nThe block Chain: ");
			System.out.println(blockchainJson);
		
		
			
		}
		
		public static Boolean isChainValid() {
			Block currentBlock;
			Block previousBlock; 
			String hashTarget = new String(new char[difficulty]).replace('\0', '0');
			
			//loop thought blockchain to check hashes: 
			for (int i=1; i < blockchain.size(); i++) {
				currentBlock = blockchain.get(i);
				previousBlock = blockchain.get(i-1);
				// compare registered hash and calculated hash
				if(!previousBlock.hash.equals(currentBlock.calculateHash()) ) {
					System.out.println("Current Hashes not equal");
					return false;
				}
				// compare preview has and registered preview hash 
				if (! previousBlock.hash.equals(currentBlock.previousHash) ) {
						System.out.println("previous hashes not equal");
						return false;
				}
			}
			return true;
		}

}
