import java.util.*;
public class StringCalculator {
	public static int add(final String numbers) 
	{
	    String delimiter = ",|n";
	    String numWithoutDelimeter = numbers;
	    if (numbers.startsWith("//")) {
	        int delimiterIndex = numbers.indexOf("//") + 2;
	        delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
	        numWithoutDelimeter = numbers.substring(numbers.indexOf("n") + 1);
	    }
	    return add(numWithoutDelimeter, delimiter);
	}
	public static final int add(final String numbers,final String delimiter) 
	{
		int sum=0;
        String[] numArray = numbers.split(delimiter);
//        if (numArray.length > 2) {
//            throw new RuntimeException("Two number are allowed with comma(,)");
//        }
//        else 
//        {
//            for (String number : numArray) {
//            	if(!number.isEmpty())
//            	{
//            		Integer.parseInt(number);
//            	}
//            }
//        }
        
        List<Integer> negativeNums = new ArrayList<>();
        for (String number : numArray) {
        	if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                	negativeNums.add(numberInt);
                } else if (numberInt <= 1000) {
                        sum += numberInt;
                }
        }
        }
        if (negativeNums.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNums.toString());
        }
        return sum;  
        
      
    }
}
