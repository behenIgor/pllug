package ua.pllug.market;

import java.util.ArrayList;

public class Market {
	//клас Market - €кий м≥стить перел≥к користувач≥в, продавц≥в та поточних покупок.
	
	private int sale_id;   			// id покупки
	private int user_id;   			// id користувача
	private int seller_id;			// id продавц€
	private int[] sale_products;	// список проданих товар≥в

	
	
	
	public Market(int sale_id, int seller_id, int user_id, int[] sale_products) {
		super();
		this.sale_id = sale_id;
		this.user_id = user_id;
		this.seller_id = seller_id;
		this.sale_products = sale_products;
	}

	public int getSale_id() {
		return sale_id;
	}

	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int[] getSale_products() {
		return sale_products;
	}

	public void setSale_products(int[] sale_products) {
		this.sale_products = sale_products;
	}
	
	
	
	
	
	
}
