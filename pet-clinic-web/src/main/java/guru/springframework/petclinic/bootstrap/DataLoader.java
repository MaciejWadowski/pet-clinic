package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
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
        vet.setId(1L);
        vet.setFirstName("Kris");
        vet.setLastName("Sauc");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet.setId(2L);
        vet.setFirstName("Momo");
        vet.setLastName("Lele");

        vetService.save(vet1);

        System.out.println("Loaded vets...");
    }
}
