

package com.j3a.assurance.managedBean.Paypal.fields;

import java.util.HashMap;
import java.util.Map;


public final class Secure3D implements RequestFields {

    /** map that holds name value pair request values */
    private final Map<String, String> nvpRequest;

    public Secure3D() {
        this.nvpRequest = new HashMap<String, String>();
    }

	/**
	 * A value returned by the Cardinal Centinel. If the cmpi_lookup request
	 * returns Y for Enrolled, set this field to the PAResStatus value returned
	 * by cmpi_authenticate; otherwise, set this field to blank.
	 *
	 * @param status
	 */
	public void setStatus3D(String status) {
		nvpRequest.put("AUTHSTATUS3D", status);
	}

	/**
	 * A value returned by the Cardinal Centinel. Set this field to the Enrolled
	 * value returned by cmpi_lookup.
	 *
	 * @param mpi
	 */
	public void setMpiVendor3D(String mpi) {
		nvpRequest.put("MPIVENDOR3DS", mpi);
	}

	/**
	 * A value returned by the Cardinal Centinel. If the cmpi_lookup request
	 * returns Y for Enrolled, set this field to the Cavv value returned by
	 * cmpi_authenticate; otherwise, set this field to blank.
	 *
	 * @param caav
	 */
	public void setCaav(String caav) {
		nvpRequest.put("CAVV", caav);
	}

	/**
	 * A value returned by the Cardinal Centinel. If the cmpi_lookup request
	 * returns Y for Enrolled, set this field to the EciFlag value returned
	 * by cmpi_authenticate; otherwise, set this field to the EciFlag value
	 * returned by cmpi_lookup.
	 *
	 * @param eci
	 */
	public void setEci(String eci) {
		nvpRequest.put("ECI3DS", eci);
	}

	/**
	 * A value returned by the Cardinal Centinel. If the cmpi_lookup request
	 * returns Y for Enrolled, set this field to the Xid value returned by
	 * cmpi_authenticate; otherwise set this field to blank.
	 *
	 * @param xid
	 */
	public void setXid(String xid) {
		nvpRequest.put("XID", xid);
	}

    public Map<String, String> getNVPRequest() {
        return new HashMap<String, String>(nvpRequest);
    }

    @Override
    public String toString() {

        return "instance of Secure3D class with the values: "
                + "nvpRequest: " + nvpRequest.toString();
    }
}
