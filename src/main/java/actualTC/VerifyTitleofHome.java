package actualTC;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.Baseclass;

public class VerifyTitleofHome extends Baseclass {
	@Test
	public void TC() {
		String et="Swag Labs";
		String ht=driver.getTitle();
		Assert.assertEquals(et, ht,"both are not macthing");
		System.out.println("TC is pass");
	}

}
