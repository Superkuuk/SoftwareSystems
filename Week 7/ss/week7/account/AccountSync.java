package ss.week7.account;

public class AccountSync {
	static Account account = new Account();
	public static void main(String[] args) {
		Thread A = new MyThread(1, 10000, account);
		Thread B = new MyThread(-1, 500, account);
		A.start();
		B.start();
		try {
			A.join();
			B.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(account.getBalance());
	}

}