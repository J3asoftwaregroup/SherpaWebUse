package com.j3a.assurance.managedBean;

import org.primefaces.event.FlowEvent;
import org.springframework.stereotype.Component;

@Component
public class DeclarationSinistreAuto {
	
	private boolean skip;
	
	
	
	
	
	
	
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }

}
