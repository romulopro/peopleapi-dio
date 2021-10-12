package com.digitalinnovation.personalapi.mapper;

import com.digitalinnovation.personalapi.dto.request.PersonDTO;
import com.digitalinnovation.personalapi.entity.Person;
import com.digitalinnovation.personalapi.entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-11T22:37:57-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person toModel(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        Person person = new Person();

        person.setBirthDate( personDTO.getBirthDate() );
        person.setId( personDTO.getId() );
        person.setFirstName( personDTO.getFirstName() );
        person.setLastName( personDTO.getLastName() );
        person.setCpf( personDTO.getCpf() );
        List<Phone> list = personDTO.getPhones();
        if ( list != null ) {
            person.setPhones( new ArrayList<Phone>( list ) );
        }

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( person.getId() );
        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setCpf( person.getCpf() );
        personDTO.setBirthDate( person.getBirthDate() );
        List<Phone> list = person.getPhones();
        if ( list != null ) {
            personDTO.setPhones( new ArrayList<Phone>( list ) );
        }

        return personDTO;
    }
}
