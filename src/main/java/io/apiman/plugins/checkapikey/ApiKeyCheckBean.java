package io.apiman.plugins.checkapikey;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


/**
 * Configuration for the ApiKey Check Policy.
 *
 * @author Gabriel Owoeye {@literal <owoeye.g.o@gmail.com>}
 */
public class ApiKeyCheckBean implements Serializable {

    @JsonProperty
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
