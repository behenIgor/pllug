package ua.pllug.market;

public class Purchase {
	//клас Purchase - описує дані про покупку користувачів
	
	private int goods_id;          // id товару
	private String goods_producer; // виробник
	private String goods_name;	   // назва товару
	private double goods_price;    // ціна
	private Categorys categorys;   //категорії товарів в ENUM
	
	
	public Purchase(int goods_id, String goods_producer, String goods_name, double goods_price, Categorys categorys) {
		this.goods_id = goods_id;
		this.goods_producer = goods_producer;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.categorys = categorys;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_producer() {
		return goods_producer;
	}

	public void setGoods_producer(String goods_producer) {
		this.goods_producer = goods_producer;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public Categorys getCategorys() {
		return categorys;
	}

	public void setCategorys(Categorys categorys) {
		this.categorys = categorys;
	}


}
