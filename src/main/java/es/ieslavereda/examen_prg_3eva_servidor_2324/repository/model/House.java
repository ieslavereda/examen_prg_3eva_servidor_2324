package es.ieslavereda.examen_prg_3eva_servidor_2324.repository.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class House {

    private int id;
    private String name;
    private Integer points;

}
