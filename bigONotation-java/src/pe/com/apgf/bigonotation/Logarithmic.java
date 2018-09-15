package pe.com.apgf.bigonotation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Logarithmic {
	public static void main(String[] args) throws IOException {
 
        Logarithmic logarithmic = new Logarithmic();
        LogarithmicExampleType quadraticExampleType = LogarithmicExampleType.BinarySearch;
        switch (quadraticExampleType)
        {
            case BinarySearch:
                List<Integer> numberList = new ArrayList<>(Arrays.asList(1, 3, 3, 7, 10, 11, 16, 17, 20, 21, 25, 26, 30, 32, 34 , 35 ));
                int needle = 26;
                int min = 0;
                Integer position = logarithmic.BinarySearch(numberList, needle, min, numberList.size() - 1);
                position = position !=null? position : -1;
                System.out.printf("Position: %d", position);
                break;
        }
        System.in.read();
    }

	/// Complexity: O(log2 N)
	Integer BinarySearch(List<Integer> numberList, int needle, int min, int max) {
		int midpoint = (max + min) / 2;
		if (numberList.size() > 0 && numberList.get(midpoint) == needle) {
			return midpoint;
		}
		if (min >= max) {
			return null;
		}
		if (numberList.get(midpoint) > needle) {
			return BinarySearch(numberList, needle, min, midpoint - 1);
		}
		return BinarySearch(numberList, needle, midpoint + 1, max);
	}
}
