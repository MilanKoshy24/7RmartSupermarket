package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {

	Faker faker = new Faker();

	public String createrandomusername() {

		return faker.name().username();
	}

	public String createrandompassword() {

		return faker.internet().password();
	}

	public String createrandomname() {

		return faker.name().fullName();
	}

	public String createrandomemail() {

		return faker.internet().emailAddress();

	}

	public String createrandomaddress() {

		return faker.address().fullAddress();
	}

}
