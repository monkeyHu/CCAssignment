package ch6;

import java.util.ArrayList;

/*You have 1000 bottles of soda and exactly one is poisoned. You have 10 test strips which can
 * be used to detect poison. You can only run tests once per day and it takes seven days to 
 * return a result. How would you figure out the poisoned bottle in as few days as possible
 */
public class Solution10 {
/*Since the test strip indicate whether the bottle is poisoned or unpoisoned. since 2^10=1024,
 * so it is possible for us to use the binary representation of number of bottle.
 * If there is a 1 in the ith digit, then we will add a drop of this bottle's contents to
 * test strip i.
 * We wait seven days, and then read the results. If test strip i is positive, then set bit i of 
 * the result value. Reading all the test strips and convert the binary presentation to decimal number
 * which is the ID of the poisoned bottle.
 *if bottle 1 is poisoned, the binary presentation of bottle 1 is 0000000001, so the number 1
 *test strip will be positive, For bottle 3, its binary presentation is 0000000011, so if bottle
 *is poisoned, the first strip and second strip will be positive
 **/
	
	/*Follow Up: Simulate the approach*/
	class Bottle{
		private boolean poisoned = false;
		private int id;
		
		public Bottle(int id){
			this.id = id;
		}
		public int getId(){
			return this.id;
		}
		public void setAsPoisoned(){
			poisoned = true;
		}
		
		public boolean isPoisoned(){
			return this.poisoned;
		}
	}
	
	class TestStrip{
		private ArrayList<Bottle> drops = new ArrayList<Bottle>();
		private int id;
		
		public TestStrip(int id){
			this.id = id;
		}
		
		public int getId(){
			return this.id;
		}
		
		public void addDrop(Bottle bottle){
			drops.add(bottle);
		}
		
		private boolean hasPoison(ArrayList<Bottle> bottles){
			for(Bottle bottle: bottles){
				if(bottle.isPoisoned())
					return true;
			}
			return false;
		}
		
		public boolean isPositive(){
			if(hasPoison(this.drops))
				return true;
			else
				return false;
		}
	}
	int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips){
		runTests(bottles,strips);
		ArrayList<Integer> positive = getPositive(strips);
		return findBottleNum(positive);
	}
	
	
	/*Add bottle contents to test strips*/
	void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips){
		for(Bottle bottle:bottles){
			int id = bottle.getId();
			int bitIndex = 0;
			while(id < 0){
				if((id & 1)==1){
					testStrips.get(bitIndex).addDrop(bottle);
				}
				bitIndex++;
				id >>= 1;
				}
			}
		}
	
	/*Get the strips that are positive*/
	ArrayList<Integer> getPositive(ArrayList<TestStrip> testStrips){
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for(TestStrip testStrip:testStrips){
			int id = testStrip.getId();
			if(testStrip.isPositive())
				positive.add(id);
		}
		return positive;
	}
	
	/*Find the number of bottle with indices specified in positive*/
	int findBottleNum(ArrayList<Integer> positive){
		int id = 0;
		for(Integer bitIndex : positive){
			id |= 1 << bitIndex;
		}
		return id;
	}
}
