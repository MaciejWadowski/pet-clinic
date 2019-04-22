package guru.springframework.petclinic.services;

import guru.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetService extends CrudRepository<Vet, Long> {
}
