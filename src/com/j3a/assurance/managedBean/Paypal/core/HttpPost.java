
package com.j3a.assurance.managedBean.Paypal.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

 
final class HttpPost implements Transport {

	
	public String getResponse(String urlString, String msg)
			throws MalformedURLException {

        //System.out.println(urlString);
        //System.out.println(msg);

		/* write request */
		URL url = new URL(urlString);
        URLConnection connection;
        StringBuffer response = new StringBuffer();

        try {
            connection = url.openConnection();
            connection.setDoOutput(true);

            /* write request */
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(msg);
            writer.flush();
            writer.close();

            /* read response */
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                //System.out.println(line);
                response.append(line);
            }
            reader.close();

        } catch (IOException ex) {
            Logger.getLogger(HttpPost.class.getName()).log(Level.SEVERE, null, ex);
        }

		/* return response */
		return response.toString();
	}

    @Override
    public String toString() {
        return "instance of HttpPost class";
    }
}
