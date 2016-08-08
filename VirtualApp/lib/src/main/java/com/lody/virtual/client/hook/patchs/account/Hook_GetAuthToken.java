package com.lody.virtual.client.hook.patchs.account;

import java.lang.reflect.Method;

import com.lody.virtual.client.hook.base.Hook;
import com.lody.virtual.client.local.VAccountManager;

import android.accounts.Account;
import android.accounts.IAccountManagerResponse;
import android.os.Bundle;

/**
 * @author Lody
 *
 * @see android.accounts.IAccountManager#getAuthToken(IAccountManagerResponse,
 *      Account, String, boolean, boolean, Bundle)
 *
 */

public class Hook_GetAuthToken extends Hook {

	@Override
	public String getName() {
		return "getAuthToken";
	}

	@Override
	public Object onHook(Object who, Method method, Object... args) throws Throwable {
		IAccountManagerResponse response = (IAccountManagerResponse) args[0];
		Account account = (Account) args[1];
		String authTokenType = (String) args[2];
		boolean notifyOnAuthFailure = (boolean) args[3];
		boolean expectActivityLaunch = (boolean) args[4];
		Bundle options = (Bundle) args[5];
		VAccountManager.getInstance().getAuthToken(response, account, authTokenType, notifyOnAuthFailure,
				expectActivityLaunch, options);
		return 0;
	}
}
