package m2i.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import m2i.utilisateur.Activite;
import m2i.utilisateur.Sexe;
import m2i.utilisateur.Utilisateur;

import java.time.LocalDate;

public class Tests {
	
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(Utilisateur.class);
			
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
	   }

//	Utilisateur u = new Utilisateur(LocalDate.of(1995, 3, 27), 1.79f, 87f, Sexe.homme, Activite.legere);

//	@Test
//	public void testAge() {
//
//		int age = u.get_Age();
//		Assert.assertTrue("devrait être vrai", age == 24);
//
//	}

}
