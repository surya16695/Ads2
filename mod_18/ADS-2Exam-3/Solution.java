import java.util.Scanner;
import java.util.*;


/**
 * Class for solution.
 */
public class Solution {

	/**
	 * { function_description }main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
	// Don't modify this method.
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	/**
	 * { function_description }reads file.
	 *
	 * @param      file  The file
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String[] toReadFile(String file) {
	// Don't modify this method.
		In in = new In(file);
		return in.readAllStrings();
	}

	/**
	 * Loads a dictionary.
	 * compllexity of time N^2.
	 *
	 * @param      file  The file
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		String[] lines = toReadFile(file);
		for (String line : lines) {
			String[] words = line.toLowerCase().split(" ");
			for (String each : words) {
				if (st.contains(each)) {
					st.put(each, st.get(each) + 1);
				} else {
					st.put(each, 1);
				}
			}
		}
		return st;
	}
}

/**
 * Class for t 9.
 */
class T9 {
	/**
	 * { var_description }
	 */
	private TST<Integer> tst;

	/**
	 * Constructs the object.
	 *complexity of time - N =(no of keys).
	 * @param      st    { parameter_description }
	 */
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		tst = new TST<Integer>();
		for (String each : st.keys()) {
			tst.put(each, st.get(each));
		}

	}

	/**
	 * Gets all words.
	 *
	 * @param      prefix  The prefix
	 *
	 * @return     All words.
	 */
	public Iterable<String> getAllWords(final String prefix) {
	// get all the prefixes that match with given prefix.
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}
	/**
	 * compares.
	 * complexity n=(number of chars in word) .
	 *
	 * @param      word  The word
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String compare(final String word) {
		String[] c = word.split("");
			String val = "";
			for (String each : c) {
				if (each.equals("a") || each.equals("b") ||
				 each.equals("c")) {
					val = val + "2";
				}
				if (each.equals("d") || each.equals("e") ||
				 each.equals("f")) {
					val = val + "3";
				}
				if (each.equals("g") || each.equals("h") ||
				 each.equals("i")) {
					val = val + "4";
				}
				if (each.equals("j") || each.equals("k") ||
				 each.equals("l")) {
					val = val + "5";
				}
				if (each.equals("m") || each.equals("n") ||
				 each.equals("o")) {
					val = val + "6";
				}
				if (each.equals("p") || each.equals("q") ||
				 each.equals("r") || each.equals("s")) {
					val = val + "7";
				}
				if (each.equals("t") || each.equals("u") ||
				 each.equals("v")) {
					val = val + "8";
				}
				if (each.equals("w") || each.equals("x") ||
				 each.equals("y") || each.equals("z")) {
					val = val + "9";
				}
			}
			return val;
		}

		/**
		 * { function_description }.
		 *
		 * @param      t9Signature  The t 9 signature
		 *
		 * @return     { description_of_the_return_value }
		 */
	public Iterable<String> potentialWords(final String t9Signature) {
		// your code goes here
		TreeSet<String> set = new TreeSet<>();
		for (String word : tst.keys()) {
			String s = compare(word);
			if (s.equals(t9Signature)) {
				set.add(word);
			}
		}
		return set;
	}

	/**
	 * Gets the suggestions.
	 *complexity N^2.
	 * @param      words  The words
	 * @param      k      { parameter_description }
	 *
	 * @return     The suggestions.
	 */
	public Iterable<String> getSuggestions(final Iterable<String> words, final int k) {
	// return all possibilities(words), find top k with highest frequency.
		// your code goes here
		TreeSet<String> set = new TreeSet<>();
		MaxPQ<Integer> maxpq = new MaxPQ<>();
		for (String each : words) {
			maxpq.insert(tst.get(each));
		}
		for (int i = 0; i < k; i++) {
			int f = maxpq.delMax();
			for (String each : words) {
				if (f == tst.get(each)) {
					set.add(each);
				}
			}
		}
		return set;
	}

	//
	// final output Don't modify this method.
	//
	// @param      t9Signature  The t 9 signature
	// @param      k            { parameter_description }
	//
	// @return     { description_of_the_return_value }
	//
	/**
	 * { function_description }.
	 *complexity n.
	 * @param      t9Signature  The t 9 signature
	 * @param      k            { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Iterable<String> t9(final String t9Signature, final int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}