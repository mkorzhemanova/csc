

public class PFoundMeasure {

	private static final double P_BREAK = 0.15;
	private static final int MAX_GRADE = 3;
	
	public static double compute(int[] rel) {
		double result = 0;
		double[] pRel = computePRel(rel);
		double[] pLook = computePLook(pRel);

		for (int i = 1; i < rel.length; i++) {
			result += pLook[i] * pRel[i];
		}
		return result;
	}

	private static double[] computePRel(int[] rel) {
		double[] pRel = new double[rel.length];
		
		for (int i = 1; i < rel.length; i++) {
			pRel[i] = (Utils.pow2(rel[i]) - 1) / Utils.pow2(MAX_GRADE);
		}
		
		return pRel;
	}

	private static double[] computePLook(double[] pRel) {
		double[] pLook = new double[pRel.length];
		pLook[1] = 1;
		
		for (int i = 2; i < pRel.length; i++) {
			pLook[i] = pLook[i - 1] * (1 - pRel[i - 1]) * (1 - P_BREAK);
		}
		
		return pLook;
	}
}
