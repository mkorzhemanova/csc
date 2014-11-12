import java.util.Arrays;


public class NDCGMeasure {
	
	public static double compute(int[] rel) {
		int[] ideal = idealRel(rel);
		
		double dcg = DCGMeasure.compute(rel);
		double idcg = DCGMeasure.compute(ideal);
		
		return dcg / idcg;
	}
	
	private static int[] idealRel(int[] rel) {
		// Copy
		int[] ideal = Arrays.copyOf(rel, rel.length);
		
		// Sort in ascending order
		Arrays.sort(ideal);
		
		// Reverse to have descending order
		for (int i = 1; i <= ideal.length / 2; i++) {
			int tmp = ideal[i];
			ideal[i] = ideal[ideal.length - i];
			ideal[ideal.length - i] = tmp;
		}
		
		return ideal;
	}
}
