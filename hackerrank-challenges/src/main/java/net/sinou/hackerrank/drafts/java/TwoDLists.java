package net.sinou.hackerrank.drafts.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoDLists {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			List<List<Integer>> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int p = in.nextInt();
				List<Integer> subarr = new ArrayList<>();
				for (int j = 0; j < p; j++) {
					subarr.add(in.nextInt());
				}
				arr.add(subarr);
			}
		
			int q =  in.nextInt();
			for (int i = 0; i< q; q++) {
				int j= in.nextInt();
				int k= in.nextInt();
				
				if (j>arr.size() || k > arr.get(j-1).size() )
					System.out.println("ERROR!");
				else 
					System.out.println(arr.get(j-1).get(k-1)+"");
			}
		}
	}
}
