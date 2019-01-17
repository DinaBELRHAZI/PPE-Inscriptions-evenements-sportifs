package inscriptions;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInscriptions {

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
    
		
}
