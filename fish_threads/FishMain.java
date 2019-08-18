package week1.day7.assignment5.fish_threads;

import java.util.Scanner;
//import java.util.concurrent.TimeUnit;

public class FishMain {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		System.out.println("Integer for loop?");
		int loops = in.nextInt();
		
		for (int i = 1; i <= loops; i++) {
			if (i % 2 == 0) {
				
//				try {
//					TimeUnit.MILLISECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				FoodThread t = new FoodThread();
				t.run();
			}
			
			else if (i % 3 == 0) {
//				try {
//					TimeUnit.MILLISECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				new FishThread().run();
			}
			
			else if (i % 5 == 0) {
//				try {
//					TimeUnit.MILLISECONDS.sleep(10);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				new FishFoodThread().run();
			}
			else
				System.out.println(i);
		}
		
		in.close();
	}
}
