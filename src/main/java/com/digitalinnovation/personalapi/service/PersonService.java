package com.digitalinnovation.personalapi.service;

import java.util.stream.Collectors;
import javax.validation.Valid;

import java.util.List;

import com.digitalinnovation.personalapi.dto.request.PersonDTO;
import com.digitalinnovation.personalapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personalapi.entity.Person;
import com.digitalinnovation.personalapi.exception.PersonNotFoundException;
import com.digitalinnovation.personalapi.mapper.PersonMapper;
import com.digitalinnovation.personalapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
    }

    public PersonDTO findById(long id) throws PersonNotFoundException {
        // Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {

        verifyIfExists(id);

        personRepository.deleteById(id);
        return;
    }

    public MessageResponseDTO updateById(Long id, @Valid PersonDTO personDTO)throws PersonNotFoundException{
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse(updatedPerson.getId(), "Updated person with ID");
        
   
    }
    private Person verifyIfExists(long id) throws PersonNotFoundException {
        return personRepository
        .findById(id)
        .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(long id, String message){
        return MessageResponseDTO
        .builder()
        .message(message + " " + id)
        .build();
    }
}
