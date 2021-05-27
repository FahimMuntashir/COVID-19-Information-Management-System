import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DiagnosticCenter extends Institution implements TotalInfo {
	private int noOfCoronaDate;
	private ArrayList<CoronaDay> coronaInfo = new ArrayList<>();
	private int testFee;

	public DiagnosticCenter(String userName, String password, String name, String address, String division,
			String phnNo,int noOfCoronaDate, int testFee) {
		super(userName, password, name, address, division, phnNo);
		this.noOfCoronaDate = noOfCoronaDate;
		this.testFee = testFee;
	}

	public DiagnosticCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiagnosticCenter(String userName, String password, String name, String address, String division,
			String phnNo) {
		super(userName, password, name, address, division, phnNo);
		// TODO Auto-generated constructor stub
	}

	public int getNoOfCoronaDate() {
		return noOfCoronaDate;
	}

	public void setNoOfCoronaDate(int noOfCoronaDate) {
		this.noOfCoronaDate = noOfCoronaDate;
	}

	public ArrayList<CoronaDay> getCoronaInfo() {
		return coronaInfo;
	}

	public void addDate(int year, int month, int day, int totalTest, int totalAffected, int totalCured, int totalDeath) {
		coronaInfo.add(new CoronaDay(year, month, day, totalTest, totalAffected, totalCured, totalDeath));
		noOfCoronaDate++;
	}

	public void addDate(int totalTest, int totalAffected, int totalCured, int totalDeath) {
		coronaInfo.add(new CoronaDay(totalTest, totalAffected, totalCured, totalDeath));
		noOfCoronaDate++;
	}

	public void addDate(GregorianCalendar calendar,int totalTest, int totalAffected, int totalCured, int totalDeath) {
		coronaInfo.add(new CoronaDay(calendar,totalTest, totalAffected, totalCured, totalDeath));
		noOfCoronaDate++;
	}

	public int getTestFee() {
		return testFee;
	}

	public void setTestFee(int testFee) {
		this.testFee = testFee;
	}

	@Override
	public int getTotalTest() {
		int total = 0;
		for (int i = 0; i < this.coronaInfo.size(); i++) {
			total += this.coronaInfo.get(i).getTotalTest();
		}
		return total;
	}


	@Override
	public int getTotalAffected() {
		int total = 0;
		for (int i = 0; i < this.coronaInfo.size(); i++) {
			total += this.coronaInfo.get(i).getTotalAffected();
		}
		return total;
	}

	@Override
	public int getTotalCured() {
		int total = 0;
		for (int i = 0; i < this.coronaInfo.size(); i++) {
			total += this.coronaInfo.get(i).getTotalCured();
		}
		return total;
	}

	@Override
	public int getTotalDeath() {
		int total = 0;
		for (int i = 0; i < this.coronaInfo.size(); i++) {
			total += this.coronaInfo.get(i).getTotalDeath();
		}
		return total;
	}

}
