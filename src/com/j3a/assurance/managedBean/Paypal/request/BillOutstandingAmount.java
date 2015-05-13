
package com.j3a.assurance.managedBean.Paypal.request;

import java.util.HashMap;
import java.util.Map;

import com.j3a.assurance.managedBean.Paypal.util.Validator;

public final class BillOutstandingAmount implements Request {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Method value of this request */
    private static final String METHOD_NAME = "BillOutstandingAmount";

    /** map that holds name value pair request values */
    private final Map<String, String> nvpRequest;

    /** map that holds name value pair response values */
    private Map<String, String> nvpResponse;

    public BillOutstandingAmount(String profileId)
            throws IllegalArgumentException {

        /* validation */
        if (profileId.length() != 14 || profileId.length() != 19) {
            throw new IllegalArgumentException("profileId can be 14 or 19 " +
                    "characters long.");
        }

        /* instance variables */
        nvpResponse = new HashMap<String, String>();
        nvpRequest  = new HashMap<String, String>();
        nvpRequest.put("METHOD", METHOD_NAME);

        nvpRequest.put("PROFILEID", profileId);
    }

    
    public void setAmount(String amount) throws IllegalArgumentException {

        if (!Validator.isValidAmount(amount)) {
            throw new IllegalArgumentException("Amount " + amount +
                    " is not valid. Amount has to have exactly two decimal "
                    + "places seaprated by \".\" - example: \"50.00\"");
        }

        /* values for this request */
        nvpRequest.put("AMT", amount);
    }

   
    public void setNote(String note) {

        nvpRequest.put("NOTE", note);
    }

    public Map<String, String> getNVPRequest() {
        return new HashMap(nvpRequest);
    }

    public void setNVPResponse(Map<String, String> nvpResponse) {
        this.nvpResponse = new HashMap<String, String>(nvpResponse);
    }

    public Map<String, String> getNVPResponse() {
        return new HashMap<String, String>(nvpResponse);
    }

    @Override
    public String toString() {

        StringBuffer str = new StringBuffer("instance of ");
        str.append("BillOutstandingAmount class with the vlues: nvpRequest - ");
        str.append(nvpRequest.toString());
		str.append("; nvpResponse - ");
		str.append(nvpResponse.toString());

		return str.toString();
    }
}
