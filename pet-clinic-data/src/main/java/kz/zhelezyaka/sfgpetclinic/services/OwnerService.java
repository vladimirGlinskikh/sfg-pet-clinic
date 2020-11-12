package kz.zhelezyaka.sfgpetclinic.services;

import kz.zhelezyaka.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
