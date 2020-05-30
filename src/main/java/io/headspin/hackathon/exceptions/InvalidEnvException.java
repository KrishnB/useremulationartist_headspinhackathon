package io.headspin.hackathon.exceptions;

public class InvalidEnvException extends RuntimeException {

    public InvalidEnvException(String env) {
        super(String.format("Cannot load env %s. Supported envs are qa", env));
    }
}
