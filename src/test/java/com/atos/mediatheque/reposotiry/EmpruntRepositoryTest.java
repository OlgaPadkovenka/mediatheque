package com.atos.mediatheque.reposotiry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;

@DataJpaTest
public class EmpruntRepositoryTest {
	
	@Autowired
	public EmpruntRepository empruntRepository;
	
//	@Test
//	public void getEmpruntTest(Utilisateur utilisateur) {
//		List<Emprunt> emprunts = empruntRepository.findEmpruntByUtilisateur(utilisateur);
//		assertEquals(3, emprunts.size());
//	}

}
