package BraggIndia.dataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class dataCalling {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Exceldriven data = new Exceldriven();
		ArrayList<String> d = data.getData("Purchase");
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		System.out.println(d.get(3));
		

	}

}
