package ir.digixo;

import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
public class ApplicationScopeClass implements Serializable {

    private String name="Bita";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
