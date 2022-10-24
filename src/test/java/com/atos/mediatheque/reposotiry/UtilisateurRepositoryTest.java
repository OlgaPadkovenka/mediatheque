package com.atos.mediatheque.reposotiry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.UtilisateurRerository;

@DataJpaTest
public class UtilisateurRepositoryTest {

	@Autowired
	public UtilisateurRerository utilisateurRerository;
	
	@Test
	public void testCreactionUtilisateur() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("Pad");
		utilisateur.setPrenom("Olga");
		utilisateur.setEmail("olga@gmailcom");
		utilisateur.setMotDePasse("olga");
		utilisateurRerository.save(utilisateur);
	}
}
