
public class SalesPerson extends SalesEmployee {

	private static final long serialVersionUID = 1L;

	public SalesPerson() {
		super();
	}

	public SalesPerson(String fname, String lname, String pps) {
		super(fname, lname, pps);
	}

	@Override
	public void calculateCommission() {
		commission = sales * .15;

	}

}
