package util;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome; 
	private Double healthSpending;
	private Double educationSpending; 
	
	public TaxPayer() {
	}
	
	
	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}


	public Double getSalaryIncome() {
		return salaryIncome;
	}


	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}


	public Double getServicesIncome() {
		return servicesIncome;
	}


	public void setServicesIncome(Double prestacaoServ) {
		this.servicesIncome = prestacaoServ;
	}


	public Double getCapitalIncome() {
		return capitalIncome;
	}


	public void setCapitalIncome(Double ganhocapital) {
		this.capitalIncome = ganhocapital;
	}


	public Double getHealthSpending() {
		return healthSpending;
	}


	public void setHealthSpending(Double gastosMedicos) {
		this.healthSpending = gastosMedicos;
	}


	public Double getEducationSpending() {
		return educationSpending;
	}


	public void setEducationSpending(Double gastosEdu) {
		this.educationSpending = gastosEdu;
	}


	public double salaryTax(double salaryIncome) {
		double taxOverService = 0.0;
		if (salaryIncome < 36000) {
			return taxOverService;
		}
		else if(salaryIncome >= 36000 && salaryIncome <= 60000) {
			taxOverService = salaryIncome * 0.1;
			return taxOverService;
		}
		else {
			taxOverService = salaryIncome * 0.2;
			return taxOverService;
		}
	}
	
	public double servicesTax(double servicesIncome) {
		return servicesIncome * 0.15;
	}
	
	public double capitalTax(double capitalIncome) {
		return capitalIncome * 0.2;
	}
	
	public double grossTax(double salaryIncome, double servicesIncome, double capitalIncome) {
		return salaryTax(salaryIncome) + servicesTax(servicesIncome) + capitalTax(capitalIncome);
	}
	
	public double maxDeductible(double salaryIncome, double servicesIncome, double capitalIncome) {
		return grossTax(salaryIncome, servicesIncome,capitalIncome) * 0.3;
	}
	
	public double deductibleSpending(double healthSpending, double educationSpending) {
		return healthSpending + educationSpending;
	}
	
	public double taxRebate(double salaryIncome, double servicesIncome, double capitalIncome,double healthSpending, double educationSpending) {
		if (deductibleSpending(healthSpending,educationSpending) <= maxDeductible(salaryIncome,servicesIncome,capitalIncome)) {
			return deductibleSpending(healthSpending,educationSpending);
		}
		else {
			return maxDeductible(salaryIncome,servicesIncome,capitalIncome);
		}
	}
	 public double netTax(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
		 return grossTax(salaryIncome,servicesIncome,capitalIncome) - taxRebate(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
	 }
	
}
