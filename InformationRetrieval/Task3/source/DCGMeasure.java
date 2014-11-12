public class DCGMeasure {
	
	public static double compute(int[] rel) {
		double result = 0;
		for (int i = 1; i < rel.length; i++) {
			result += (Utils.pow2(rel[i]) - 1) / (Utils.log2(i + 1)); 
		}
		return result;
	}	
}
