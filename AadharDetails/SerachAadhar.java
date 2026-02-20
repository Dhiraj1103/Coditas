package AadharDetails;

import java.util.ArrayList;

import java.util.LinkedHashMap;

public class SerachAadhar {

	public static void main(String[] args) {
		ArrayList<AadharDetails> a1= new ArrayList<>();

		
		a1.add(new AadharDetails("Ram Shelke", "Hadapsar, Pune", "21/03/2003", 23, "123456789123"));
		a1.add(new AadharDetails("Sita Patil", "Shivajinagar, Pune", "15/07/2002", 24, "234567891234"));
		a1.add(new AadharDetails("Amit Jadhav", "Kothrud, Pune", "09/11/2001", 25, "345678912345"));
		a1.add(new AadharDetails("Priya Deshmukh", "Wakad, Pune", "30/01/2004", 22, "456789123456"));
		a1.add(new AadharDetails("Rohit Pawar", "Baner, Pune", "12/05/2000", 26, "567891234567"));
		a1.add(new AadharDetails("Neha Kulkarni", "Aundh, Pune", "18/08/2003", 23, "678912345678"));
		a1.add(new AadharDetails("Sanket More", "Nigdi, Pune", "25/12/1999", 27, "789123456789"));
		a1.add(new AadharDetails("Pooja Shinde", "Katraj, Pune", "05/04/2002", 24, "891234567891"));
		a1.add(new AadharDetails("Vikas Chavan", "Pimpri, Pune", "14/09/2001", 25, "912345678912"));
		a1.add(new AadharDetails("Anjali Gaikwad", "Viman Nagar, Pune", "02/02/2003", 23, "112233445566"));
		
		LinkedHashMap<String, AadharDetails> hm= new LinkedHashMap<>();

		
	    for (AadharDetails i : a1) {
	        hm.put(i.aadharNo, i);
	    }
         
        for (String key : hm.keySet()) {
		//	System.out.println(key+">> "+hm.get(key));
		}
        
        
       System.out.println(      hm.get("123456789123"));

		


		
		

	}
	 
	
}
