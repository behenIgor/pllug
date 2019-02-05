
public class Home_work_0 {

		int A = 0;
	 	int B = 1;
	 	int C = 0;
	 	
	 	public void sumyKvadrativ() {     //System.out.println(A);
	 		for(int i = 3; i <=9; i++)    //{System.out.println(i);
	 			A = A + i * 2;            //System.out.println(A + " " + i);
	 		System.out.println(A);        //}
	 	}
	 	
	 	
	 	public int dobutkyInt(){
		 	for(int i = 2; i<=8; i++)
		 		B = B * i;
		 	return	B;
		 	}
	 	
	 	public void sum(){
	 		 System.out.println(C = A + B);
	 	}
	 	
	 	
	 public static void main(String[] args) {
		 Home_work_0 s = new Home_work_0();
		
		s.sumyKvadrativ();
		System.out.println(s.dobutkyInt());
		s.sum();

	}

}






