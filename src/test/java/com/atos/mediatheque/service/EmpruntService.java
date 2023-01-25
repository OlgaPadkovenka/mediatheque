//package com.atos.mediatheque.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import java.security.Principal;
//import java.util.Date;
//import java.util.Optional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.ui.Model;
//
//import com.atos.mediatheque.entity.CD;
//import com.atos.mediatheque.entity.Emprunt;
//import com.atos.mediatheque.entity.Item;
//import com.atos.mediatheque.entity.Utilisateur;
//import com.atos.mediatheque.repository.EmpruntRepository;
//import com.atos.mediatheque.repository.ItemRepository;
//import com.atos.mediatheque.repository.UtilisateurRerository;
//
//@ExtendWith(MockitoExtension.class)
//
//public class EmpruntService {
//    @Mock    
//    private EmpruntRepository empruntRepository;
//    
//    @Mock    
//    private UtilisateurRerository utilisateurRerository;
//    
//    @Mock    
//    private ItemRepository itemRepository;
//
//    @InjectMocks    
//    private EmpruntService empruntService;
//    
//    private CD item;
//    private Utilisateur utilisateur;
//    private Emprunt emprunt;
//    
//    @BeforeEach
//    public void setup() {
//        item = new CD();
//        item.setNombreDExemplaires(5);
//        utilisateur = new Utilisateur();
//        utilisateur.setEmail("test@test.com");
//        emprunt = new Emprunt();
//        emprunt.setUtilisateur(utilisateur);
//        emprunt.setDateEmprunt(new Date());
//    }
//    
//    @Test
//    public void testFaireEmprunt() {
//        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
//        when(principal.getName()).thenReturn("test@test.com");
//        when(utilisateurRerository.findByEmail("test@test.com")).thenReturn(utilisateur);
//        when(empruntRepository.save(emprunt)).thenReturn(emprunt);
//        empruntService.faireEmprunt(model, 1L, principal);
//        assertEquals(4, item.getNombreDExemplaires());
//        assertEquals(utilisateur, emprunt.getUtilisateur());
//    }
//
//	private void faireEmprunt(Model model, long l, Principal principal) {
//		// TODO Auto-generated method stub
//		
//	}
//}
