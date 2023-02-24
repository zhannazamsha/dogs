package com.learn.dogs.dogs

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service

@Service
@Primary
class DogBreedServiceImpl(val dogBreedRepository: DogBreedRepository, val dogBreedTypeRepository: DogBreedTypeRepository) : DogBreedService {
    override suspend fun findAll(): Iterable<DogBreed>? {
        return dogBreedRepository.findAllDogs()
    }

    override suspend fun findById(dogId: Long): DogBreed? {
        return dogBreedRepository.findById(dogId)

        /*public Mono<Parent> findParent(String parentName) {
    return parentRepository.findOneByName(parentName)
      .map(parent -> {
            Flux<Child> children = childRepository.findAllByParentId(parent.getId())
            children.subscribe();
            return parent.setChildren(children );
        });
}*/
    }

    override suspend fun post(dogBreed: Map<String, Array<String>>) {

        dogBreed.forEach { it ->
            val dog = DogBreed(0, it.key)
                dogBreedRepository.save(dog)
            it.value.forEach { i ->
                dogBreedTypeRepository.save(DogBreedType(0, i, dog.id))
            }

        }
    }
}

/*parentRepository.findById(parentId)
    .map(p -> p.withChildren(childRepository.findAllByParentId(parentId)));*/



