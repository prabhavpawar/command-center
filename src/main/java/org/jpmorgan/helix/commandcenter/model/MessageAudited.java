package org.jpmorgan.helix.commandcenter.model;

import lombok.Data;

@Data
public class MessageAudited {

    private String reconciledEventName;
    private String reconciliationSource;
    private String reconciliationDestination;
    private String messageCount;
    private String rollupWindowStartTime;
    private String rollupWindowEndTime;


}
