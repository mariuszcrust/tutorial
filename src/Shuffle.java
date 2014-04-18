import java.util.Arrays;
import java.util.Random;

public class Shuffle {

	private static final Random generator = new Random();

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(Arrays.toString(a));

		shuffle(a);
		System.out.println(Arrays.toString(a));
	}

	public static void shuffle(int[] a) {

		int N = a.length;

		for (int i = 0; i < N; i++) {

			int r = generator.nextInt(i + 1);
			swap(a, i, r);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int value = a[i];
		a[i] = a[j];
		a[j] = value;

	}
}
