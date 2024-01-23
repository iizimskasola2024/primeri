package si.um.feri.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public record OsebaDto(Long id, String ime, String priimek, int starost) {
}