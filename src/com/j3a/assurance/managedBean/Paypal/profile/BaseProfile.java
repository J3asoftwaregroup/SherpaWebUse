

package com.j3a.assurance.managedBean.Paypal.profile;

import java.util.HashMap;
import java.util.Map;

public final class BaseProfile implements Profile {

    /** user name obtained from paypal */
    private final String userName;

    /** password obtained from paypal */
    private final String password;

    /** If you use an API certificate, do not include this parameter */
    private final String signature;

    /** 
     * Email address of a PayPal account that has granted you permission to 
     * make this call.
     * Set this parameter only if you are calling an API on a different user’s 
     * behalf
     */
    private final String subject;

    /**
     * Builder class that constructs instance of BaseProfile class.
     * 
     * Example: 
     * BaseProfile usr = new BaseProfile.Builder(userName, pass).signature(sign).build();
     */
    public static class Builder {

        /* required parameters */
        private final String userName;
        private final String password;

        /* optional paramters */
        private String signature    = null;
        private String subject      = null;

        /**
         * Required parameters
         * 
         * @param userName user name obtained from paypal
         * @param password password obtained from paypal
         */
        public Builder(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        /**
         * Optional parameter 
         * If you use an API certificate, do not include this parameter
         * 
         * @param val signature
         * @return
         */
        public Builder signature(String val) {
            signature = val;
            return this;
        }

        /**
         * Optional parameter 
         * Email address of a PayPal account that has granted you permission to 
         * make this call.
         * Set this parameter only if you are calling an API on a different 
         * user’s behalf
         * 
         * @param val subject
         * @return
         */
        public Builder subject(String val) {
            subject = val;
            return this;
        }

        /**
         * Returns instance of BaseProfile class
         * 
         * @return 
         */
        public BaseProfile build() {
            return new BaseProfile(this);
        }
    }

    /**
     * Private constructor invoked by builder static class
     * 
     * @param builder
     */
    private BaseProfile(Builder builder) {

        userName    = builder.userName;
        password    = builder.password;
        signature   = builder.signature;
        subject     = builder.subject;
    }

    public Map<String, String> getNVPMap() {

        /* create and return map */
        Map<String, String> nvpMap = new HashMap<String, String>();
        nvpMap.put("USER", userName);
        nvpMap.put("PWD", password);
        if (signature != null) {
            nvpMap.put("SIGNATURE", signature);
        }
        if (subject != null) {
            nvpMap.put("SUBJECT", subject);
        }

        return nvpMap;
    }

    @Override
    public String toString() {

		return "instance of User class with values: userName - "
				+ userName + ", password: " + password + ", signature: " 
                + signature + ", subject: " + subject;
    }
}
