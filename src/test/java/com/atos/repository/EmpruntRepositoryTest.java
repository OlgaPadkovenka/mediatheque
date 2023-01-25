package com.atos.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.atos.mediatheque.entity.Emprunt;
import com.atos.mediatheque.entity.Utilisateur;
import com.atos.mediatheque.repository.EmpruntRepository;
import com.atos.mediatheque.repository.UtilisateurRerository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmpruntRepositoryTest {

    @Autowired
    private EmpruntRepository empruntRepository;
    
    @Autowired
    private UtilisateurRerository utilisateurRerository;

    @Test
    public void findEmpruntByUtilisateur_shouldReturnEmprunt() {
        // Given
        Utilisateur utilisateur = utilisateurRerository.findByEmail("olga@gmail.com");
        
//        // Set utilisateur attributes
//        empruntRepository.save(utilisateur);
//        
        // Here we need to save the utilisateur to the database
        // create an emprunt with the same utilisateur
        Emprunt emprunt = new Emprunt();
        emprunt.setUtilisateur(utilisateur);
        emprunt.setDateRetour(null);
        emprunt.setItems(null);
        empruntRepository.save(emprunt);

        // When
        List<Emprunt> result = empruntRepository.findEmpruntByUtilisateur(utilisateur);

        // Then
        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getUtilisateur()).isEqualTo(utilisateur);
        assertThat(result.get(0).getDateRetour()).isNull();
    }

}