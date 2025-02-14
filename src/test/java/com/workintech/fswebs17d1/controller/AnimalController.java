package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap<>();


    @GetMapping
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping

    public void addAnimal(@RequestBody Animal animal) {
       animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")

    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal updateAnimal) {
        animals.replace(id, updateAnimal);
        return animals.get(id);

    }

    @DeleteMapping("/{id}")

    public String deleteAnimal(@PathVariable int id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
            return "Animal deleted successfully!";
        }
        return "Animal not found!";
    }
}
