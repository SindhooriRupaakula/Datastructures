public class NLengthStringFromKLength {

	public void print(int n, char[] k, char[] A) {
		if (n <= 0) {
			System.out.print(String.valueOf(A) + " ");
		} else {
			for (int i = 0; i < k.length; i++) {
				A[n - 1] = k[i];
				print(n - 1, k, A);
			}
		}
	}

	public static void main(String[] args) {
		String k = "ALGO";
		int n = 2;
		NLengthStringFromKLength i = new NLengthStringFromKLength();
		i.print(n, k.toCharArray(), new char[n]);
	}
}