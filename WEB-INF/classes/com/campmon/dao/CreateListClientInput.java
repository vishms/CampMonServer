package com.campmon.dao;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;


// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
// Isn't that cool?
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateListClientInput {
		@JsonProperty("Title")
        private String Title;
		@JsonProperty("UnsubscribePage")
        private String UnsubscribePage;
		@JsonProperty("UnsubscribeSetting")
        private String UnsubscribeSetting;
		@JsonProperty("ConfirmedOptIn")
        private boolean ConfirmedOptIn;
		@JsonProperty("ConfirmationSuccessPage")
        private String ConfirmationSuccessPage;
        
        
		public String getTitle() {
			return Title;
		}
		
		public void setTitle(String title) {
			Title = title;
		}
		public String getUnsubscribePage() {
			return UnsubscribePage;
		}
		public void setUnsubscribePage(String unsubscribePage) {
			UnsubscribePage = unsubscribePage;
		}
		public String getUnsubscribeSetting() {
			return UnsubscribeSetting;
		}
		public void setUnsubscribeSetting(String unsubscribeSetting) {
			UnsubscribeSetting = unsubscribeSetting;
		}
		public boolean isConfirmedOptIn() {
			return ConfirmedOptIn;
		}
		public void setConfirmedOptIn(boolean confirmedOptIn) {
			ConfirmedOptIn = confirmedOptIn;
		}
		public String getConfirmationSuccessPage() {
			return ConfirmationSuccessPage;
		}
		public void setConfirmationSuccessPage(String confirmationSuccessPage) {
			ConfirmationSuccessPage = confirmationSuccessPage;
		}
		
		@Override
		public String toString(){
			return "Title: " + getTitle() 
					+ ", UnsubscribePage: " + getUnsubscribePage()
					+ ", UnsubscribeSetting: " + getUnsubscribeSetting()
					+ ", ConfirmedOptIn: " + isConfirmedOptIn()
					+ ", ConfirmationSuccessPage: " + getConfirmationSuccessPage();
		}
        
	
}
