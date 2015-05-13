
package com.j3a.assurance.managedBean.Paypal.request;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.j3a.assurance.managedBean.Paypal.util.Validator;

public final class AddressVerify implements Request {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Method value of this request */
    private static final String METHOD_NAME = "AddressVerify";

    /** map that holds name value pair request values */
    private final Map<String, String> nvpRequest;

    /** map that holds name value pair response values */
    private Map<String, String> nvpResponse;

   
    public AddressVerify(String email, String street, String zip)
            throws IllegalArgumentException {

        /* validation */
        if (!Validator.isValidEmail(email)) {
            throw new IllegalArgumentException("Email is not valid");
        }

        if (email.length() > 255) {
            throw new IllegalArgumentException("Email can by max 255 " +
                    "characters long");
        }

        /* street */
        if (street == null) {
            throw new IllegalArgumentException("Street cannot be null");
        }
        if (street.length() > 35) {
            throw new IllegalArgumentException("Street cannot be longer than "
                    + "35 characters");
        }
        String streetRegex = "^[0-9a-zA-Z\\s\\-,\\.'#\\\\]{1,35}$";
        Matcher streetMatcher = Pattern.compile(streetRegex).matcher(street);
        if (!streetMatcher.matches()) {
            throw new IllegalArgumentException("Street is not valid");
        }

        /* zip */
        if (zip == null) {
            throw new IllegalArgumentException("Zip cannot be null");
        }
        if (zip.length() > 16) {
            throw new IllegalArgumentException("Zip cannot be longer than 16 "
                    + "characters");
        }

        /* instance variables */
        nvpResponse = new HashMap<String, String>();
        nvpRequest  = new HashMap<String, String>();
        nvpRequest.put("METHOD", METHOD_NAME);

        nvpRequest.put("EMAIL", email);
        nvpRequest.put("STREET", street);
        nvpRequest.put("ZIP", zip);
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

        StringBuffer str = new StringBuffer("instance of AddressVerify");
        str.append("class with the vlues: nvpRequest - ");
        str.append(nvpRequest.toString());
		str.append("; nvpResponse - ");
		str.append(nvpResponse.toString());

		return str.toString();
    }
}
