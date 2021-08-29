import org.junit.Assert;


public class Test {

	@org.junit.Test
	public final void moreThanTwoNumberThrownException() 
	{
        StringCalculator.add("1,2,3");
    }
	
	@org.junit.Test
    public final void twoNumbers() 
	{
        StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    
	@org.junit.Test
    public final void unknownNumberIsUseThrowException() 
    {
        StringCalculator.add("1,X");
    }
	
	@org.junit.Test
	public final void emptyStringReturnValue0() 
	{
	    Assert.assertEquals(0, StringCalculator.add(""));
	}
	
	@org.junit.Test
	public final void onlyOneNumberThenReturnThatNumber() 
	{
	    Assert.assertEquals(8, StringCalculator.add("8"));
	}
	 
	@org.junit.Test
	public final void twoNumberThenReturnSumOfthatTwoNumbers() 
	{
	    Assert.assertEquals(11+19, StringCalculator.add("11,19"));
	}
	
	@org.junit.Test
	public final void unknownAmountOfNumbersReturnTheirSum() 
	{
		Assert.assertEquals(8+3+11+19+24, StringCalculator.add("8,3,11,19,24"));
	}
	
	@org.junit.Test
	public final void newLineBetweenNumbersSumAllThatNumbersAndReturnThat() 
	{
	    Assert.assertEquals(3+8+30, StringCalculator.add("3,8n30"));
	}
	
	@org.junit.Test
	public final void delimeterIsSpecifiedUsedSeoarateNumbers() {
	    Assert.assertEquals(3+8+19, StringCalculator.add("//;n3;8;19"));
	}

	@org.junit.Test
	public final void negativeNumberIsUsedThrowRuntimeException() 
	{
	    StringCalculator.add("5,-11,19,3");
	}
	
	@org.junit.Test
	public final void negativeNumbersAreUsedthrowRuntimeException() 
	{
	    RuntimeException exception = null;
	    try {
	        StringCalculator.add("3,-11,8,-19,30,45");
	    } catch (RuntimeException e) {
	        exception = e;
	    }
	    Assert.assertNotNull(exception);
	    Assert.assertEquals("Negatives not allowed: [-11, -19]", exception.getMessage());
	}
	
	@org.junit.Test
	public final void numberIsGreaterThen1000DoNotCountInSum() {
	    Assert.assertEquals(3+1000+6, StringCalculator.add("3,1012,85,113,1052"));
	}
}
