package io.apiman.plugins.checkapikey;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;


/**
 * Configuration for the ApiKey Check Policy.
 *
 * @author Gabriel Owoeye {@literal <owoeye.g.o@gmail.com>}
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({"errorMessage"})
public class ApiKeyCheckBean implements Serializable {

    @JsonProperty("errorMessage")
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
