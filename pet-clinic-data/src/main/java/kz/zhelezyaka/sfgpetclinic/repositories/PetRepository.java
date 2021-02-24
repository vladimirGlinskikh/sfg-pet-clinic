package kz.zhelezyaka.sfgpetclinic.repositories;

import kz.zhelezyaka.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
