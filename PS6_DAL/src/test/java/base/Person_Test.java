package base;

import javax.persistence.Entity;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.cglib.core.Local;

import domain.PersonDomainModel;

@Entity
public class Person_Test {

private static PersonDomainModel personOne;

private static UUID personOneUUID = UUID.randomUUID();



@BeforeClass
public static void personInstance() throws Exception {
	personOne = new PersonDomainModel();



	personOne.setFirstName("Casey");
	personOne.setLastName("Morris");
	personOne.setStreet("123 Blue Drive");
	personOne.setPostalCode(19711);
	personOne.setCity("Newark");
	personOne.setBirthday(new Date(1995));
	
	
}


@Test
public void AddPersonTest() {
	PersonDAL.addPerson(personOne);
	PersonDomainModel personTwo = PersonDAL.getPerson(personOne.getPersonID());
	assertEquals(personOne.getPersonID(), personTwo.getPersonID());

}

@Test
public void GetPersonTest() {
	String Name1 = personOne.getLastName();
	assertEquals("Morris", Name1);

}



@Test
public void UpdatePersonTest() {
	personOne.setFirstName("Kacey");
	String UpdatedName = personOne.getFirstName();
	PersonDAL.updatePerson(personOne);
	assertEquals("Kacey", UpdatedName);

}

@Test
public void deletePersontest() {
	PersonDAL.addPerson(personOne);
	PersonDAL.deletePerson(personOneUUID);

}
@AfterClass
public static void CleanUpTest(){
	PersonDAL.deletePerson(personOneUUID);

}


}