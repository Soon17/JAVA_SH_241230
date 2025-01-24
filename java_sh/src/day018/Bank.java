package day018;
import java.util.Objects;

import lombok.Data;

@Data
public class Bank {

	
	private String bankName, name, accountNum, password;
	private int balance;
	
	public Bank(String bankName, String name, String accountNum, String password) {
		this.bankName = bankName;
		this.name = name;
		this.accountNum = accountNum;
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(accountNum, other.accountNum) && Objects.equals(bankName, other.bankName)
				&& Objects.equals(name, other.name);
	}
}
