package ua.pllug.market;

import ua.pllug.market.User;
import ua.pllug.market.Seller;
import ua.pllug.market.Purchase;
import ua.pllug.market.Market;

import java.util.ArrayList;



public class MarketMain {

	static ArrayList<Purchase> purchases = new ArrayList<>();
	static ArrayList<User> users = new ArrayList<>();
	static ArrayList<Seller> sellers = new ArrayList<>();
	static ArrayList<Market> markets = new ArrayList<>();
	
	private static double totalSum = 0;

	public static void main(String[] args) {
		
		initData();
		
		String info = String.format("�������� ������� �������� ������: %d "  + "�� ���� " + "%.2f " + "$.", quantityOfSoldGoods(), sumOfAllSoldGoods());
		System.out.println(info);
		String prof = String.format("�������� �� ���� � 5%% ���������: %.2f ", profitFromCommission());
		System.out.println(prof);
		
	
	}
	
	
	

	// �������� ���� �������� ������
	public static double sumOfAllSoldGoods() {
		
		for(Market market : markets){
			totalSum += sumOfSoldGoods(market);
		}
		return totalSum;
	}
	
	//�������� �� ���� � 5%
		public static double profitFromCommission() {
			double profit = 0;
			profit = totalSum * 0.05;
			return profit;
			
		}
		
	// ������� �������� ������ ������� �������
	public static double sumOfSoldGoods(Market market) {
		double sum = 0;
		for(int goodsId : market.getSale_products()) {
			Purchase purchase = getGoodsById(goodsId);
			if(purchase != null)
	        sum += purchase.getGoods_price();
	        }
		return sum;
	}
	
	// ������� �������� ������
	public static int quantityOfSoldGoods(){
		int count = 0;
		for (Market market : markets ) {
			count += market.getSale_products().length;
		}
	return count;
	}
	
		
	// ����� ������ �� id
	public static Purchase getGoodsById(int id){
		Purchase actual = null;
		for(Purchase purchase : purchases) {
			if(purchase.getGoods_id() == id) {
				actual =  purchase;
			break;
			}
		}
		return actual;
	}
	
public static  void initData() {
		
		// ��������
		sellers.add(new Seller(1, "����������� ������", 23 ));
		sellers.add(new Seller(2, "������ �������", 25 ));
		sellers.add(new Seller(3, "�������� �������", 31 ));
		
		// �������
		users.add(new User(1, "�������� ������", 42));
		users.add(new User(2, "������ �����", 28));
		users.add(new User(3, "�������� ���������", 35));
		users.add(new User(4, "������ �����", 51));
		users.add(new User(5, "����� ������", 39));
		users.add(new User(6, "������� ������", 21));
		
		
		// ������
		purchases.add(new Purchase(1, "Intel", "Intel Hades Canyon Mini Gaming PC", 1099.00, Categorys.Desktops));
		purchases.add(new Purchase(2, "ASUS", "Powered By ASUS Gaming PC", 1325.00, Categorys.Desktops));
		purchases.add(new Purchase(3, "Intel", "Intel small micro-ATX", 1431.00, Categorys.Desktops));
		purchases.add(new Purchase(4, "HP", "HP OMEN 15.6\" FHD", 2349.00, Categorys.Laptops));
		purchases.add(new Purchase(5, "ASUS", "ASUS TUF Gaming FX504GE", 1599.00, Categorys.Laptops));
		purchases.add(new Purchase(6, "LG", "LG 27UK850-W", 869.00, Categorys.Monitors));
		purchases.add(new Purchase(7, "Samsung", "Samsung LU28E590DS/XY", 399.00, Categorys.Monitors));
		purchases.add(new Purchase(8, "Dell", "Dell P2415Q", 579.00, Categorys.Monitors));
		purchases.add(new Purchase(9, "NVIDIA ", "MSI GeForce GTX 1060 Gaming X 6GB Video Card ", 425.00, Categorys.Components));
		
		
		
		// ����������
		markets.add(new Market(1, 3, 1, new int[] {2, 7}));
		markets.add(new Market(2, 1, 2, new int[] {1, 6}));
		markets.add(new Market(3, 3, 3, new int[] {3, 8}));
		markets.add(new Market(4, 2, 4, new int[] {5}));
		markets.add(new Market(5, 1, 5, new int[] {4}));
		markets.add(new Market(6, 2, 6, new int[] {9}));
		
	}
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



