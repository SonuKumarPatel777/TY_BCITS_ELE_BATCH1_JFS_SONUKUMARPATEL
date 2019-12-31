package com.org.third;

public class Product {
        public static void main(String[] args) {
		
		ProductInfo p1 = new ProductInfo();
		p1.setId(1);
		p1.setName("Apple");
		p1.setPrice(10);
		
		ProductInfo p2 = new ProductInfo();
		p2.setId(2);
		p2.setName("Mobile");
		p2.setPrice(15000);
		
		ProductInfo p3 = new ProductInfo();
		p3.setId(3);
		p3.setName("T-Shart");
		p3.setPrice(500);
		
		ProductInfo p4 = new ProductInfo();
		p4.setId(4);
		p4.setName("Car");
		p4.setPrice(1000000);

		Object a[]= {p1,p2,p3,p4};
		for (Object pf : a) {
			System.out.println(pf);
		}

        }
}       
