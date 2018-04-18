// Class Block definition 
// Code: Rainierpinero@gmail.com 
// Block chain 101 

// import java library for date.
import java.util.Date;


public final class Block {
	
	public String hash;  // define of hash variable 
	public String previousHash; // define previous hash variable 
	private String data; // our date will be a simple message. 
	private long timeStamp; // as number of milliseconds since 1/1/1970
	private int nonce; // def variable 
	
	// Block constructor. 
	
	public Block ( String data, String previousHash2 ) {
		this.data = data; 
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); // making sure we do this after we set the other values.
	}

	// calculate new hash  based on blocks contents
	public String calculateHash() {	
			String calculatedhash = StringUtil.applySha256(
					previousHash +
					Long.toString(timeStamp) + 
					Integer.toString(nonce) +
					data
					);
			return calculatedhash; 
	}
	
	public void mineBlock(int difficulty) {
			String target = new String (new char[difficulty]).replace('\0', '0'); // create
					while (!hash.substring( 0, difficulty).equals(target)) {
						nonce ++;
						hash =  calculateHash();	
					}
				System.out.println("Block Mined!!!: " + hash);
	}
}
	

