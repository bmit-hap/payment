package ch.bbw.shop.cart;

public class Token {
	
	private String id;

	public Token() {
		super();
		this.id = String.valueOf(this.hashCode());
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
