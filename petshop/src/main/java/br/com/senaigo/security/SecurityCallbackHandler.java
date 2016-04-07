package br.com.senaigo.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class SecurityCallbackHandler implements CallbackHandler {
	
	private String user = null;
	private String password = null;
	
	public SecurityCallbackHandler(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public void handle(Callback[] callbackArray) throws IOException, UnsupportedCallbackException {
		int counter = 0;
		while (counter < callbackArray.length) {
			if (callbackArray[counter] instanceof NameCallback) {
				NameCallback nameCallback = (NameCallback) callbackArray[counter++];
				nameCallback.setName(user);
			}else if(callbackArray[counter] instanceof PasswordCallback){
				PasswordCallback passwordCallback = (PasswordCallback) callbackArray[counter++];
				passwordCallback.setPassword(password.toCharArray());
			}
		}

	}

}
