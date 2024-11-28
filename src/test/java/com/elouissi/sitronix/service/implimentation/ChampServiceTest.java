package com.elouissi.sitronix.service.implimentation;

import com.elouissi.sitronix.domain.Champ;
import com.elouissi.sitronix.domain.Ferme;
import com.elouissi.sitronix.repository.ChampRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChampServiceTest {

    @Mock
    private ChampRepository champRepository;

    @Mock
    private ArbreService arbreService;

    @InjectMocks
    private ChampService champService;

    private Champ champ;
    private Ferme ferme;

    @BeforeEach
    void setUp() {
        ferme = new Ferme();
        ferme.setId(1);
        ferme.setSuperficie(100.0f);
        ferme.setChamps(new ArrayList<>());

        champ = new Champ();
        champ.setId(1);
        champ.setSuperficie(20.0f);
        champ.setFerme(ferme);
        champ.setArbres(new ArrayList<>());
    }

    @Test
    void testSave_Success() {
            when(champRepository.save(any(Champ.class))).thenReturn(champ);

        Champ savedChamp = champService.save(champ, ferme);


        assertNotNull(savedChamp);
        assertEquals(ferme, savedChamp.getFerme());
        assertTrue(ferme.getChamps().contains(savedChamp));
        verify(champRepository).save(champ);
    }

    @Test
    void testSave_NullFerme() {
        assertThrows(IllegalArgumentException.class, () -> {
            champService.save(champ, null);
        });
    }

    @Test
    void testGetChampId_Success() {
        when(champRepository.findById(1)).thenReturn(Optional.of(champ));

        Champ foundChamp = champService.getChampId(1);

        assertNotNull(foundChamp);
        assertEquals(1, foundChamp.getId());
        verify(champRepository).findById(1);
    }

    @Test
    void testGetChampId_NotFound() {
        when(champRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            champService.getChampId(999);
        });
    }

    @Test
    void testDelete_Success() {
        champService.delete(champ);

        verify(arbreService).deleteByChamp(champ);
        verify(champRepository).delete(champ);
    }

    @Test
    void testDelete_NullChamp() {
        assertThrows(IllegalArgumentException.class, () -> {
            champService.delete(null);
        });
    }

    @Test
    void testUpdate_Success() {
        Champ newChamp = new Champ();
        newChamp.setSuperficie(30.0f);

        when(champRepository.findById(1)).thenReturn(Optional.of(champ));
        when(champRepository.save(any(Champ.class))).thenReturn(champ);

        Champ updatedChamp = champService.update(newChamp, 1);

        assertNotNull(updatedChamp);
        assertEquals(30.0f, updatedChamp.getSuperficie());
        verify(champRepository).save(champ);
    }

    @Test
    void testUpdate_SuperficieDepasseMoitie() {
        Champ newChamp = new Champ();
        newChamp.setSuperficie(60.0f);

        when(champRepository.findById(1)).thenReturn(Optional.of(champ));

        assertThrows(RuntimeException.class, () -> {
            champService.update(newChamp, 1);
        });
    }

    @Test
    void testCalculerSommeSuperficiesChamps() {
        List<Champ> champs = new ArrayList<>();
        Champ champ1 = new Champ();
        champ1.setSuperficie(20.0f);
        Champ champ2 = new Champ();
        champ2.setSuperficie(30.0f);
        champs.add(champ1);
        champs.add(champ2);
        ferme.setChamps(champs);

        Float somme = ChampService.calculerSommeSuperficiesChamps(ferme);

        assertEquals(50.0f, somme);
    }

    @Test
    void testCalculerSommeSuperficiesChamps_NullFerme() {
        Float somme = ChampService.calculerSommeSuperficiesChamps(null);

        assertEquals(0f, somme);
    }
}