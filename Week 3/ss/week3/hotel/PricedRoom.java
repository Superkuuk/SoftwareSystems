package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {

	private double roomPrice;
	
	public PricedRoom(double safePrice, double roomPrice, int roomNr) {
		super(roomNr, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}
	
	@Override
	public double getAmount() {
		return roomPrice;
	}

	@Override
	public String toString() {
		return String.format("%-5.2f", roomPrice);
	}

}
