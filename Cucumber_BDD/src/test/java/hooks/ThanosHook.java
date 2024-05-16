package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ThanosHook {
	
	@Before(order = 1)
	public void beforeSnapping() {
		System.out.println("Thanos collecting the Infinity Stones");
	}
	
	@After(order = 1)
	public void afterSnapping() {
		System.out.println("After killing everyone, taking rest on garden");
	}
	
	@Before(order = 0)
	public void beforeToBeforeScenario() {
		System.out.println("Thanos has to be Born");
	}
	
	@After(order = 0)
	public void afterAfterScenario() {
		System.out.println("Finally Thanos is also dying");
	}

}
