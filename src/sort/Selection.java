package sort;

public class Selection {

	public static void sort(Comparable[] a) {
		int N = a.length;

		for (int i = 0; i < N; i++) {
			int min = i;

			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}

			swap(a, i, min);

		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < -1;
	}

	private static void swap(Comparable[] a, int i, int j) {
		Comparable value = a[i];
		a[i] = a[j];
		a[j] = value;

	}

	public static void main(String[] args) {
		Comparable[] a = new Comparable[] { "ghi", "jkl", "abc", "def" };
		sort(a);
		for (Comparable comparable : a) {
			System.out.println(comparable);
		}
	}
}
