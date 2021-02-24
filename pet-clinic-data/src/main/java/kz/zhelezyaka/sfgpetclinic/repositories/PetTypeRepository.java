package kz.zhelezyaka.sfgpetclinic.repositories;

import kz.zhelezyaka.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
