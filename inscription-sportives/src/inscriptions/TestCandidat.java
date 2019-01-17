package inscriptions;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCandidat {
	Inscriptions inscriptions;
    Personne personne1;
    Personne personne2;
    Equipe equipe; 
    Competition competition;

 
	@Before
    public void setUp() {
		inscriptions = Inscriptions.getInscriptions();
		personne1 = inscriptions.createPersonne("toto", "toto", "mailtoto");
		personne2 = inscriptions.createPersonne("toto", "toto", "mailtoto");
		competition = inscriptions.createCompetition("nomcompetition",LocalDate.now().plusDays(30) , false);
		equipe = inscriptions.createEquipe("nomequipe");
    }



    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }
	
    @Test
	public void testgetNom(){
		String getNom = personne1.getNom();
		assertEquals("getNom", getNom );
	 }


	@Test
	public void testsetNom(){
		personne1.setNom("setNom");

		String setNom = personne1.getNom();
		assertEquals("setNom", setNom );
	}
	
	
	@Test
	public void testgetCompetition(){
		competition.add(personne1);
		equipe.add(personne1);
		assertTrue(personne1.getCompetitions().contains(competition));

	}

	

	@Test
	public void testdelate(){
		personne1.delete();
//		assertTrue(!inscriptions.getCandidats().contains(personne2));
		assertTrue(!inscriptions.getCandidats().contains(personne1));
	}

	

	@Test
	public void testcompareTopersonne(){
//		Personne personnetestbis = inscriptions.createPersonne("nomtest", "prenomtest", "mailtest");
		assertEquals(0, personne1.compareTo(personne2) );
	}

	

	@Test
	public void testtoString(){
		assertTrue(!personne1.toString().contentEquals(""));
	}
}
