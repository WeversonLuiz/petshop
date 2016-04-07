package br.com.senaigo.security;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.omg.PortableServer.ThreadPolicyOperations;

import com.sun.jna.Callback;

public class SecurityLoginModule implements LoginModule {
	
	private static final String TEST_USERNAME = "weverson";
	private static final String TEST_PASSWORD = "password";
	private CallbackHandler callbackHandler = null;
	private boolean authenticationSuccessFlag = false;

	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.callbackHandler = callbackHandler;
	}

	public boolean login() throws LoginException {
		Callback[] callbackArray = new Callback[2];
		callbackArray[0] = (Callback) new NameCallback("User Name : ");
		callbackArray[1] = (Callback) new PasswordCallback("Password", false);
		try {
			callbackHandler.handle((javax.security.auth.callback.Callback[]) callbackArray);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		
		String name = ((NameCallback) callbackArray[0]).getName();
		String password = new String(((PasswordCallback) callbackArray[1]).getPassword());
		
		if (TEST_USERNAME.equals(name) && TEST_PASSWORD.equals(password)) {
			System.out.println("Authentication sucess...");
			authenticationSuccessFlag = true;
		}else{
			authenticationSuccessFlag = false;
			throw new FailedLoginException("Authentication filure...");
		}
		return authenticationSuccessFlag;
	}

	public boolean commit() throws LoginException {
		return authenticationSuccessFlag;
	}

	public boolean abort() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean logout() throws LoginException {
		// TODO Auto-generated method stub
		return false;
	}

}
