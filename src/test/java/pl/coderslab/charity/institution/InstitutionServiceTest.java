package pl.coderslab.charity.institution;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InstitutionServiceTest {

    @Mock
    private InstitutionRepository institutionRepository;
    private InstitutionService underTest;

    @BeforeEach
    void setUp() {
        underTest = new InstitutionService(institutionRepository);
    }


    @Test
    void shouldGetAllInstitutions() {
        // when
        underTest.getAllInstitutions();
        // then
        verify(institutionRepository).findAll();
    }

    @Test
    void shouldFindInstitutionById() {
        // given
        Long institutionId = 1L;
        // when
        underTest.findById(institutionId);
        // then
        verify(institutionRepository).findById(institutionId);
    }

    @Test
    void shouldSaveInstitution() {
        // given
        Institution institution = new Institution("Test institution", "Test description");
        // when
        underTest.saveInstitution(institution);
        // then
        ArgumentCaptor<Institution> institutionArgumentCaptor = ArgumentCaptor.forClass(Institution.class);
        verify(institutionRepository).save(institutionArgumentCaptor.capture());

        Institution capturedInstitution = institutionArgumentCaptor.getValue();

        assertThat(capturedInstitution).isEqualTo(institution);
    }

    @Test
    void shouldThrowWhenInstitutionNameIsTaken() {
        // given
        Institution institution = new Institution("Test institution", "Test description");
        given(institutionRepository.existsByName(anyString())).willReturn(true);
        // when
        // then
        assertThatThrownBy(() -> underTest.saveInstitution(institution))
                .isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("Institution " + institution.getName() + " already exists");

        verify(institutionRepository, never()).save(any());
    }

    @Test
    void shouldDeleteInstitutionById() {
        // given
        Long id = 12L;
        given(institutionRepository.existsById(id)).willReturn(true);
        // when
        underTest.deleteInstitutionById(id);
        // then
        verify(institutionRepository).deleteById(id);
    }

    @Test
    void shouldThrowWhenDeleteInstitutionNotFound() {
        // given
        Long id = 11L;
        given(institutionRepository.existsById(id)).willReturn(false);
        // when
        //then
        assertThatThrownBy(() -> underTest.deleteInstitutionById(id))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Institution with given id does not exist");
        verify(institutionRepository, never()).deleteById(any());

    }


    @Test
    void shouldUpdateInstitutionCorrectly() {
        // Given
        Long institutionId = 1L;
        String newName = "New Name";
        String newDescription = "New Description";

        Institution institution = new Institution();
        institution.setId(institutionId);
        institution.setName("Old Name");
        institution.setDescription("Old Description");

        given(institutionRepository.findById(institutionId))
                .willReturn(Optional.of(institution));

        // When
        underTest.updateInstitution(institutionId, newName, newDescription);

        // Then
        verify(institutionRepository).findById(institutionId);

        assertEquals(newName, institution.getName());
        assertEquals(newDescription, institution.getDescription());

        verify(institutionRepository).save(institution);
    }

    @Test
    void updateInstitution_shouldThrowExceptionWhenInstitutionNotFound() {
        // Given
        Long institutionId = 1L;
        String name = "New Name";
        String description = "New Description";

        given(institutionRepository.findById(institutionId))
                .willReturn(Optional.empty());

        // When + Then
        assertThrows(IllegalStateException.class, () -> {
            underTest.updateInstitution(institutionId, name, description);
        });

        verify(institutionRepository, never()).save(any());
    }
}