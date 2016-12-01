package ss.week3.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ss.week3.hotel.Bill;
import ss.week3.hotel.Bill.Item;
import ss.week3.hotel.TestItem;

public class BillTest {
    
	private Bill bill;
	private Item item1;
	private Item item2;
	
	@Before
    public void setUp() throws Exception {
        bill = new Bill(System.out);
        item1 = new TestItem("Cola", 1.20);
        item2 = new TestItem("Pepsi", 2.00);
        bill.newItem(item1);
        bill.newItem(item2);
    }
	
	@Test
	public void testAmount() {
		assertTrue(item1.getAmount() == 1.20);
	}
	
	@Test
	public void testGetSum() {
		assertTrue(bill.getSum() == 3.20);
	}

	@Test
	public void testClose() {
		bill.close();
	}
}
