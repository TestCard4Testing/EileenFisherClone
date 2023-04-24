package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import stepDefinitions.CucumberHooks;

public class EmailableReportsClass {

	 	Email email;
	 	EmailAttachment attachment;

		public void simpleEmail() throws EmailException
		{
			email = new SimpleEmail();
			commonEmailBody();
			email.send();	
		}
		private void commonEmailBody() throws EmailException {
			email.setHostName("smtp.gmail.com");
			
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("sample@gmail.com", "AppPassword"));
			email.setSSLOnConnect(true);
			email.setFrom("sample@gmail.com");
			email.setSubject("ARC Automation Reports");
			email.setMsg("Hello Everyone, \n\nExecuted ARC scenarios and please go through the attachment for html reports. \n\nThanks\nB A Rajendra Prasad\nQA Automation Analyst");
			email.addTo("sample@gmail.com");//Mention an email to receive emailable reports
		}
		public void emailWithAttachment() throws EmailException
		{
			attachment=new EmailAttachment();
			String srcPath = System.getProperty("user.dir");
			attachment.setPath(CucumberHooks.path);
			attachment.setDisposition(EmailAttachment.INLINE);
			attachment.setDescription("HTML Report");
			attachment.setName("ExtentReports.html");	
		}
		public void multiPartEmailWithAttachment() throws EmailException {
			email=new MultiPartEmail();
			this.commonEmailBody();
			this.emailWithAttachment();
			MultiPartEmail multi=(MultiPartEmail)email;
			multi.attach(attachment);
			multi.send();
		}
		public void emailWithURLAttachment() throws MalformedURLException, EmailException
		{
			EmailAttachment attachment=new EmailAttachment();
			attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Apache Logo");
			attachment.setName("Apache Logo");
		}
}
