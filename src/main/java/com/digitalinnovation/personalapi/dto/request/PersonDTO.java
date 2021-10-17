package com.digitalinnovation.personalapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    

        
        private Long id;
    
        @NotEmpty
        private String firstName;
    
        @NotEmpty
        @Size(min = 2, max = 100)
        private String lastName;
    
        @NotEmpty
        @CPF
        private String cpf;
    
        private LocalDate birthDate;

        @Valid
        @NotEmpty
        private List<PhoneDTO> phones;
    
}
