package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.services.map.PetTypeMapService;
import guru.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Autowired


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
        petTypeService = new PetTypeMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setType("dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setType("cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Weston");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Wojtek");
        owner1.setLastName("Wadio");

        ownerService.save(owner1);

        System.out.println("Loader owners...");

        Owner owner2 = new Owner();
        owner2.setId(3L);
        owner2.setFirstName("Fiodor");
        owner2.setLastName("Fetr");

        ownerService.save(owner2);

        Vet vet = new Vet();
        vet.setId(5L);
        vet.setFirstName("Kris");
        vet.setLastName("Sauc");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Momo");
        vet1.setLastName("Lele");

        vetService.save(vet1);

        System.out.println("Loaded vets...");
    }
}
