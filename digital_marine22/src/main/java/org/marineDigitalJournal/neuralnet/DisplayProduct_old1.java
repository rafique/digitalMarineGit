package org.marineDigitalJournal.neuralnet;

import java.awt.Component;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;

import org.marineDigitalJournal.DigitalMarineApplication;
import org.marineDigitalJournal.SendEmail;
import org.marineDigitalJournal.utils.RetrieveEmail;
import org.python.util.PythonInterpreter;

public class DisplayProduct_old1 {

	public void display() {
		
		RetrieveEmail retrieveEmail=new RetrieveEmail();
		

		PythonInterpreter interpreter = new PythonInterpreter();
		try {

			ProcessBuilder pb = new ProcessBuilder("python",
					"/application/pi/eclipse-workspace/blueMaritimeDigitalJournal/src/main/java/org/marineDigitalJournal/neuralnet/use_model.py");

			Process p = pb.start();

			p.waitFor();

			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = br.readLine();
			
			while (line != null) {

				if (line.contains("forecastVAlue")) {

					DigitalMarineApplication.limit_CHL= "-1";//line.substring(13, 15);

				}

				line = br.readLine();
			}
			
			//retrieveEmail.retrieveEmail();
			
			
			
			SendEmail sendEmail = new SendEmail();
			sendEmail.send("isaacdura@gmail.com");
			
			/*ArrayList email=retrieveEmail.retrieveEmail();
			
			for(int i=0;i<email.size();i++) {
				
				
				if(((String) email.get(i)).contains("@")) {
			
			if (DigitalMarineApplication.limit_CHL == "-1") {

				sendEmail.send(email.get(i).toString());
			}}

			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
