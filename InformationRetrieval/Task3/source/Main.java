import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		int n;
		int[] rel;
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer tok = new StreamTokenizer(stdin);
		
		tok.nextToken();
		n = (int) tok.nval;
		
		rel = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			tok.nextToken();
			rel[i] = (int) tok.nval;
		}
		
		double dcg = DCGMeasure.compute(rel);
		double ndcg = NDCGMeasure.compute(rel);
		double pFound = PFoundMeasure.compute(rel);
		
		StringBuilder sb = new StringBuilder();
		sb.append("DCG=").append(dcg).append("\n");
		sb.append("NDCG=").append(ndcg).append("\n");
		sb.append("pFound=").append(pFound).append("\n");	
		System.out.println(sb);
	}
}
