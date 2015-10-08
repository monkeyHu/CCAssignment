package ch6;

import java.util.Random;

/*If all family have continue to have children until they have one girl, at which point they immediately stop,
 * what will the gender ratio of the new generation be? (Assume that the odds of someone havinng a boy or a girl
 * on any given pregnancy is equal) Solve this out logically and then write a computer simulation of it
 */
public class Solution07 {
/*if the number of family is large enough, the ratio will be 0.5
 * Although the policy is designed to favor girls as it ensures that all families have a girl
 * on the other hand, the families that keeping having children contribute multiple boys to the population. This could
 * offset the impact of the "one girl policy"
 * If we put all the gender sequence of each family into one giant string. So if family 1 has G, family 2 has BG,
 * family has BBG, we could write GBGBBG
 * In fact, we don't really care about the groupings of families because we're concerned about the population as a whole
 * As soon as a child is born, we can just append its gender to the string
 * Since the odds of having a boy or girl is equal, then the odds of hte nexr character being a G is 50%, Therefore,
 * roughly half of the string should be Gs and half should be Bs, giving an even gender ratio.
 */
	int[] runOneFamily(){
		int numberBoys = 0;
		int numberGirls = 0;
		Random random = new Random();
		while(numberGirls == 0){
			if(random.nextBoolean()){
				numberGirls++;
			}else
				numberBoys++;
		}
		
		int [] genders = {numberBoys,numberGirls};
		return genders;
	}
	double runFamilies(int n){
		int totalNumberBoys = 0;
		int totalNumberGirls = 0;
		for(int i = 0; i < n ; i++){
			int [] genders = runOneFamily();
			totalNumberBoys += genders[0];
			totalNumberGirls += genders[1];
		}
		return totalNumberGirls / (double)(totalNumberGirls + totalNumberBoys);
	}
}
