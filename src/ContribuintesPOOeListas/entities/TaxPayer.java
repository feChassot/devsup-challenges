package ContribuintesPOOeListas.entities;

public class TaxPayer {

    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome,
                    double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax(){
        double monthlySalary = salaryIncome/12;
        if ((monthlySalary) < 3000.00){
            return 0.0;
        } else if ((monthlySalary) < 5000.00){
            return salaryIncome * 0.1;
        } else{
            return salaryIncome * 0.2;
        }
    }

    public double servicesTax(){
        if (servicesIncome > 0){
            return servicesIncome * 0.15;
        } else {
            return 0.0;
        }
    }

    public double capitalTax(){
        if (capitalIncome > 0){
            return capitalIncome * 0.2;
        } else {
            return 0.0;
        }
    }

    public double grossTax(){
        return capitalTax() + servicesTax() + salaryTax();
    }

    public double taxRebate(){
        return Math.min((healthSpending + educationSpending), (grossTax() * 0.3));
    }

    public double netTax(){
        return grossTax() - taxRebate();
    }

}
