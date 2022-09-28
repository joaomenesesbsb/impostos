package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import util.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n =sc.nextInt();
		System.out.println();
		
		for (int i = 0; i< n; i++) {
			System.out.println("Digite os dados do " + (1 + i) + "o contribuinte: ");
			System.out.print("Renda anual com salario: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos medicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			System.out.println();

			TaxPayer tp = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			list.add(tp);
		}

		for (TaxPayer c : list) {
			System.out.println("Resumo do " + (list.indexOf(c) + 1) + "o contribuinte:");
			System.out.println("Imposto bruto total: " + String.format("%.2f", c.grossTax(c.getSalaryIncome(),c.getServicesIncome(),c.getCapitalIncome())));
			System.out.println("Abatimento: " + String.format("%.2f", c.taxRebate(c.getSalaryIncome(), c.getServicesIncome(), c.getCapitalIncome(), c.getHealthSpending(), c.getEducationSpending())));
			System.out.println("Imposto devido: " + String.format("%.2f", c.netTax(c.getSalaryIncome(), c.getServicesIncome(), c.getCapitalIncome(), c.getHealthSpending(), c.getEducationSpending())));
			System.out.println();
		}
		
		sc.close();

	}

}
