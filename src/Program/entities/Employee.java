package Program.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {
	private BigDecimal salary;
	private String function;

	public Employee() {

	}

	public Employee(String name, LocalDate birthDate, BigDecimal salary, String function) {
		super(name, birthDate);
		this.salary = calculateSalary(salary);
		this.function = function;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = calculateSalary(salary);
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public void applyRaise(BigDecimal percentage) {
		BigDecimal multiplier = percentage.divide(new BigDecimal("100")).add(BigDecimal.ONE);
		this.salary = this.salary.multiply(multiplier);
	}

	public abstract BigDecimal calculateSalary(BigDecimal currentBaseSalary);
}
