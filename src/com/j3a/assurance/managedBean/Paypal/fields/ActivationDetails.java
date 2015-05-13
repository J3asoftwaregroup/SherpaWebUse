

package com.j3a.assurance.managedBean.Paypal.fields;

import java.util.HashMap;
import java.util.Map;

import com.j3a.assurance.managedBean.Paypal.util.Validator;

/**
 * Activation Details Fields
 *
 * @author Pete Reisinger <p.reisinger@gmail.com>
 */
public final class ActivationDetails implements RequestFields {

    /** map that holds name value pair request values */
    private final Map<String, String> nvpRequest;

    public ActivationDetails() {
        nvpRequest = new HashMap<String, String>();
    }

   
    public void setInitialAmount(String amount)
            throws IllegalArgumentException {

        if (!Validator.isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount has to have exactly two "
					+ "decimal places seaprated by \".\" - example: \"50.00\"");
        }

        nvpRequest.put("INITAMT", amount);
    }

    
    public void setFailedInitialAmountAction(boolean continueOnFailure) {

        String value = (continueOnFailure) ? "ContinueOnFailure" : "CancelOnFailure";
        nvpRequest.put("FAILEDINITAMTACTION", value);
    }

    public Map<String, String> getNVPRequest() {
        return new HashMap<String, String>(nvpRequest);
    }

    @Override
    public String toString() {

        return "instance of ActivationDetails class with the values: "
                + "nvpRequest: " + nvpRequest.toString();
    }
}
