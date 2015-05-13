

package com.j3a.assurance.managedBean.Paypal.core;

import java.io.Serializable;
import java.net.MalformedURLException;

/**
 * Used for sending request and returning response
 *
 * @author Pete Reisinger <p.reisinger@gmail.com>
 */
interface Transport extends Serializable {
	String getResponse(String urlString, String msg)
			throws MalformedURLException;
}
