package shellsort;

public class ShellSort {

	public static void sort(Comparable[] a) {

	}

	// TODO change name of it
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
