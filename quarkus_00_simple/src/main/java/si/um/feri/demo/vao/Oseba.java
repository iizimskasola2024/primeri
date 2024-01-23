package si.um.feri.demo.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.demo.dto.OsebaDto;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Oseba {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ime, priimek;
    private int starost;
    private LocalDateTime created = LocalDateTime.now();

    public Oseba(OsebaDto dto) {
        setIme(dto.ime());
        setPriimek(dto.priimek());
        setStarost(dto.starost());
    }

    public void updateFrom(OsebaDto dto) {
        setIme(dto.ime());
        setPriimek(dto.priimek());
        setStarost(dto.starost());
    }

    public OsebaDto toDto() {
        return new OsebaDto(id, ime, priimek, starost);
    }
}