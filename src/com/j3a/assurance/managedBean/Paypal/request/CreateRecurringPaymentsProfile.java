
package com.j3a.assurance.managedBean.Paypal.request;

import java.util.HashMap;
import java.util.Map;

import com.j3a.assurance.managedBean.Paypal.fields.ActivationDetails;
import com.j3a.assurance.managedBean.Paypal.fields.Address;
import com.j3a.assurance.managedBean.Paypal.fields.BillingPeriodDetails;
import com.j3a.assurance.managedBean.Paypal.fields.CreditCard;
import com.j3a.assurance.managedBean.Paypal.fields.PayerInformation;
import com.j3a.assurance.managedBean.Paypal.fields.PayerName;
import com.j3a.assurance.managedBean.Paypal.fields.RecurringPaymentsProfileDetails;
import com.j3a.assurance.managedBean.Paypal.fields.ScheduleDetails;
import com.j3a.assurance.managedBean.Paypal.fields.ShipToAddress;


public final class CreateRecurringPaymentsProfile implements Request {

    /** Method value of this request */
    private static final String METHOD_NAME = "CreateRecurringPaymentsProfile";

    /** map that holds name value pair request values */
    private final Map<String, String> nvpRequest;

    /** map that holds name value pair response values */
    private Map<String, String> nvpResponse;

    private CreateRecurringPaymentsProfile() {

        nvpResponse = new HashMap<String, String>();
        nvpRequest  = new HashMap<String, String>();

        nvpRequest.put("METHOD", METHOD_NAME);
    }

    
    public CreateRecurringPaymentsProfile(String token, ScheduleDetails details)
            throws IllegalArgumentException {

        this();

        if (token.length() != 20) {
            throw new IllegalArgumentException("Invalid token argument");
        }

        nvpRequest.put("TOKEN", token);
		nvpRequest.putAll(new HashMap<String, String>(details.getNVPRequest()));
    }

    /**
     *
     * @param card
     */
    public CreateRecurringPaymentsProfile(CreditCard card) {

        this();

		nvpRequest.putAll(new HashMap<String, String>(card.getNVPRequest()));
    }

    /**
     *
     * @param details
     */
    public void setRecurringPaymentsProfileDetails(
            RecurringPaymentsProfileDetails details) {

		nvpRequest.putAll(new HashMap<String, String>(details.getNVPRequest()));
    }

    /**
     *
     * @param details
     */
    public void setBillingPeriodDetails(BillingPeriodDetails details) {
		nvpRequest.putAll(new HashMap<String, String>(details.getNVPRequest()));
    }

    /**
     *
     * @param details
     */
    public void setActivationDetails(ActivationDetails details) {
		nvpRequest.putAll(new HashMap<String, String>(details.getNVPRequest()));
    }

    /**
     *
     * @param address
     */
    public void setShipToAddress(ShipToAddress address) {
		nvpRequest.putAll(new HashMap<String, String>(address.getNVPRequest()));
    }

    /**
     *
     * @param payer
     */
    public void setPayerInformation(PayerInformation payer) {
		nvpRequest.putAll(new HashMap<String, String>(payer.getNVPRequest()));
    }

    /**
     *
     * @param name
     */
    public void setPayerName(PayerName name) {
		nvpRequest.putAll(new HashMap<String, String>(name.getNVPRequest()));
    }

    /**
     *
     * @param address
     */
    public void setAddress(Address address) {
		nvpRequest.putAll(new HashMap<String, String>(address.getNVPRequest()));
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

        StringBuffer str =
                new StringBuffer("instance of CreateRecurringPaymentsProfile");
        str.append("class with the vlues: nvpRequest - ");
        str.append(nvpRequest.toString());
		str.append("; nvpResponse - ");
		str.append(nvpResponse.toString());

		return str.toString();
    }
}
