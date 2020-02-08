
public class SalesAgent extends SalesEmployee {

	private static final long serialVersionUID = 1L;

	public SalesAgent() {
		super();
	}

	public SalesAgent(String fname, String lname, String pps) {
		super(fname, lname, pps);
	}

	@Override
	public void calculateCommission() {
		commission = sales * .10;

	}

}
