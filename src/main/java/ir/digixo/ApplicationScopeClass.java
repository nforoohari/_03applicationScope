package ir.digixo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class ApplicationScopeClass implements Serializable {
    private String name="mahsa";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
