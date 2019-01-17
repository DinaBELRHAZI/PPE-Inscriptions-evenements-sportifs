package inscriptions;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestEquipe {
	
	
	Inscriptions inscriptions ;
    Personne personne1, personne2;
    Equipe equipe, equipe2; 
    Competition competition ;

 
	@Before
    public void setUp() {
		inscriptions = Inscriptions.getInscriptions();
		personne1 = inscriptions.createPersonne("toto", "toto", "mailtoto");
		personne2 = inscriptions.createPersonne("toto", "toto", "mailtoto");
		competition = inscriptions.createCompetition("nomcompetition",LocalDate.now().plusDays(30) , false);
		equipe = inscriptions.createEquipe("nomequipe");
		equipe2 = inscriptions.createEquipe("nomequipe");
    }



    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }

	
	@Test
	public void testgetMembres() {
		equipe.add(personne1);
		assertTrue(equipe.getMembres().contains(personne1));
	}

	

	@Test
	public void testadd() {
		equipe2.add(personne2);
		assertTrue(equipe2.getMembres().contains(personne2));
	}

	

	@Test
	public void remove() {
		equipe2.add(personne2);
		equipe2.remove(personne2);
		assertFalse(equipe2.getMembres().contains(personne2));
	}

	

//	@Test

//	public void testgetPersonnesAAjouter() {

//		equipetest.add(personnetest);

//		assertTrue(!equipetest2.getPersonnesAAjouter().contains(personnetest));

//	}

	

	@Test
	public void testdelete() {
		competition.add(personne2);
		equipe.add(personne2);
		personne2.delete();
		assertFalse(competition.getCandidats().contains(personne2));
		assertFalse(equipe.getMembres().contains(personne2));

	}

	@Test
	public void testtoString(){
		assertTrue(!personne1.toString().contentEquals(""));
	}
	
}
