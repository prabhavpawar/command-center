package org.jpmorgan.helix.commandcenter.model;

public class EncryptedEvent {
    private String eventIdentifier;
    private String eventTypeCode;
    private String eventVersion;
    private String applicationIdentifier;
    private String applicationModule;
    private String eventCorrelationIdentifier;
    private String kmsUri;
    private String encryptedPayload;
    private String originatedTimestamp;
    private String publishedTimestamp;

}
