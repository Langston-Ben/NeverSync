/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.neversync.view;

import cit260.neversync.model.Game;

/**
 *
 * @author jeffledbetter
 */
public class ActorView {
	
	public ActorView() {
	}
	
	public void displayActorGuide() {
		
		Game game = new Game();
		// create call to function that finds and sorts actors
			
		System.out.println("\n=============================");
        System.out.println("=============================");
        System.out.println("Actor View Guide");
        System.out.println("=============================");
        System.out.println("=============================\n");
		
		
		// Actor Sort Function
		// it makes more sense to sort by location value than name.
		// 
		// create an array of the Actors
		
//		public class ActorSort {
//  
//    // logic to sort the elements
//    public static void bubble_srt(int array[]) {
//        int n = array.length;
//        int k;
//        for (int m = n; m >= 0; m--) {
//            for (int i = 0; i < n - 1; i++) {
//                k = i + 1;
//                if (array[i] > array[k]) {
//                    swapNumbers(i, k, array);
//                }
//            }
//            printNumbers(array);
//        }
//    }
//  
//    private static void swapNumbers(int i, int j, int[] array) {
//  
//        int temp;
//        temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//  
//    private static void printNumbers(int[] input) {
//          
//        for (int i = 0; i < input.length; i++) {
//            System.out.print(input[i] + ", ");
//        }
//        System.out.println("\n");
//    }
//  
//    public static void main(String[] args) {
//        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
//        bubble_srt(input);
//  
//    }
		


		// Print loop
		// for(Actor actor: actor) {
	// String actorPrintList = actor.getActorWriteup();
	// System.out.println(actorPrintList);
	//}
	
	// actorPrintList = actor.name, actor.description, actor.location;
	// sortedActorList[].
	
		

	}
	
}
