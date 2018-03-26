package com.example.demo.services;

import org.springframework.stereotype.Service;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
@Service
public class SmsServieces {

	 public static final String ACCOUNT_SID = "AC41c890773203cea30815213fa05c2b0e";
	 public static final String AUTH_TOKEN = "a2cff47cab237ba3a13763b8ad08af7c";
	 public static final String TWILIO_NUMBER = "+12068232817";
	 
	 
	 
	 public void sendSMS(int otp) {
		    try {
		        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		 
		        // Build a filter for the MessageList
		        List<NameValuePair> params = new ArrayList<NameValuePair>();
		        params.add(new BasicNameValuePair("Body", "your Otp Is= "+otp));
		        params.add(new BasicNameValuePair("To", "+918826668781")); //Add real number here
		        params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

		        MessageFactory messageFactory = client.getAccount().getMessageFactory();
		        Message message = messageFactory.create(params);
		        System.out.println(message.getSid());
		    } 
		    catch (TwilioRestException e) {
		        System.out.println(e.getErrorMessage());
		    }
		}
}
