package demo;

import demo.vo.Transaction;

public class TransactionGenerator {

	private static long id = 0L;
/*	private static TransactionGenerator instance;
	
	private TransactionGenerator() {		
	}
	
	public TransactionGenerator getTransactionGenerator() {
		if(instance == null) {
			instance = new TransactionGenerator();
			return instance;
		}else {
			return instance;
		}
	}
*/	
	public static Transaction getRandomTransaction() {
		Transaction txn = new Transaction();
		txn.setId(++id);
		txn.setCardMemberNumber(Long.toString((37_0000_0000_00000L + (long)Math.random()*10_000)));
		txn.setMerchantId(Long.toString((1_000_000_000L + (long)Math.random()*10_000)));
		txn.setAmount(Math.round(Math.random()*10000)/100.0);
		txn.setApprovalCode("000000");
		txn.setTimestamp(Long.toString(System.currentTimeMillis()));
		return txn;
	}
}
