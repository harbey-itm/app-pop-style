package edu.itm.especializacion.sofware.apppopstyle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class RespuestaDto {

    private boolean ok;
    private String error;

    public RespuestaDto() {
        this.ok = true;
        this.error = "Proceso realizado correctamente";
    }
}
