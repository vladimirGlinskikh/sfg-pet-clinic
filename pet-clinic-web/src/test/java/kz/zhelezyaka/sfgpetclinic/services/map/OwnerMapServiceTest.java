package kz.zhelezyaka.sfgpetclinic.services.map;

import kz.zhelezyaka.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {
    OwnerMapService ownerMapService;

    final Long ownerId = 1L;
    final String lastName = "Vlad";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(1, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        final long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner saveOwner = ownerMapService.save(owner2);
        assertEquals(id, saveOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner saveOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner vlad = ownerMapService.findByLastName(lastName);
        assertNotNull(vlad);
        assertEquals(ownerId, vlad.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner vlad = ownerMapService.findByLastName("Vladimir");
        assertNull(vlad);
    }
}