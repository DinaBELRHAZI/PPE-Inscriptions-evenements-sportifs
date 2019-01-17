package inscriptions;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPersonne {

	Inscriptions inscriptions ;
    Personne personne1;
    Equipe equipe; 
    Competition competition ;

 
	@Before
    public void setUp() {
		inscriptions = Inscriptions.getInscriptions();
		personne1 = inscriptions.createPersonne("toto", "toto", "mailtoto");
		competition = inscriptions.createCompetition("nomcompetition",LocalDate.now().plusDays(30) , false);
		equipe = inscriptions.createEquipe("nomequipe");
    }



    @After
    public void tearDown() {
        Inscriptions.getInscriptions().reinitialiser();
    }

    
	@Test
	public void testgetPrenom(){		
		String getPrenom = personne1.getPrenom();
		assertEquals("getPrenom", getPrenom );
	 }


	@Test
	public void testsetprenom(){
		personne1.setPrenom("setprenom");

		String setprenom = personne1.getPrenom();
		assertEquals("setprenom", setprenom );
	}

	

	@Test
	public void testgetMail(){
		String mailget = personne1.getMail();
		assertEquals("mail", mailget );
	 }

	

	@Test
	public void testsetMail(){	
		personne1.setMail("testsetmail");
		String setMail = personne1.getMail();
		assertEquals("setmail", setMail);
	 }

	

	@Test
	public void testgeEquipes(){
		equipe.add(personne1);
		assertTrue(personne1.getEquipes().contains(equipe) );
	 }

	

	@Test
	public void testdelete() {
		personne1.delete();

		assertTrue(!inscriptions.getCandidats().contains(personne1));
		assertTrue(!equipe.getMembres().contains(personne1));
		assertTrue(!competition.getCandidats().contains(personne1));
	}

	
}