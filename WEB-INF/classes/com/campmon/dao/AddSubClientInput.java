package com.campmon.dao;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSubClientInput {
	
	@JsonProperty("EmailAddress")
	String EmailAddress;
	@JsonProperty("Name")
	String Name;
	@JsonProperty("Resubscribe")
	boolean Resubscribe;
	@JsonProperty("RestartSubscriptionBasedAutoresponders")
	boolean RestartSubscriptionBasedAutoresponders;
	@JsonProperty("CustomFields")
	AddSubCustField[] CustomFields;
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isResubscribe() {
		return Resubscribe;
	}
	public void setResubscribe(boolean resubscribe) {
		Resubscribe = resubscribe;
	}
	public boolean isRestartSubscriptionBasedAutoresponders() {
		return RestartSubscriptionBasedAutoresponders;
	}
	public void setRestartSubscriptionBasedAutoresponders(
			boolean restartSubscriptionBasedAutoresponders) {
		RestartSubscriptionBasedAutoresponders = restartSubscriptionBasedAutoresponders;
	}
	public AddSubCustField[] getCustomFields() {
		return CustomFields;
	}
	public void setCustomFields(AddSubCustField[] customFields) {
		CustomFields = customFields;
	}
	
	@Override
	public String toString(){
		String toString = "EmailAddress: " + getEmailAddress()
				+ ", Name: " + getName()
				+ ", Resubscribe: " + isResubscribe()
				+ ", RestartSubscriptionBasedAutoresponders: " + isRestartSubscriptionBasedAutoresponders();
				
		for(int i = 0; i < CustomFields.length; i++){
			toString += ", CustomFields[" + i + "] : Key:" + CustomFields[i].Key + " Value: " + CustomFields[i].Value;
		}
		return toString;
	}

}
