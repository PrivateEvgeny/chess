package org.eclipse.swt.internal.mozilla;
/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mozilla Communicator client code, released March 31, 1998.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by Netscape are Copyright (C) 1998-1999
 * Netscape Communications Corporation.  All Rights Reserved.
 *
 * Contributor(s):
 *
 * IBM
 * -  Binding to permit interfacing between Mozilla and SWT
 * -  Copyright (C) 2003, 2008 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */


public class nsICookieService extends nsISupports {

	static final int LAST_METHOD_ID = nsISupports.LAST_METHOD_ID + 5;

	public static final String NS_ICOOKIESERVICE_IID_STR =
		"011c3190-1434-11d6-a618-0010a401eb10";

	public static final nsID NS_ICOOKIESERVICE_IID =
		new nsID(NS_ICOOKIESERVICE_IID_STR);

	public nsICookieService(int /*long*/ address) {
		super(address);
	}

	public int GetCookieString(int /*long*/ aURI, int /*long*/ aChannel, int /*long*/[] _retval) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 1, getAddress(), aURI, aChannel, _retval);
	}

	public int GetCookieStringFromHttp(int /*long*/ aURI, int /*long*/ aFirstURI, int /*long*/ aChannel, int /*long*/[] _retval) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 2, getAddress(), aURI, aFirstURI, aChannel, _retval);
	}

	public int SetCookieString(int /*long*/ aURI, int /*long*/ aPrompt, byte[] aCookie, int /*long*/ aChannel) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 3, getAddress(), aURI, aPrompt, aCookie, aChannel);
	}

	public int SetCookieStringFromHttp(int /*long*/ aURI, int /*long*/ aFirstURI, int /*long*/ aPrompt, byte[] aCookie, byte[] aServerTime, int /*long*/ aChannel) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 4, getAddress(), aURI, aFirstURI, aPrompt, aCookie, aServerTime, aChannel);
	}

	public int GetCookieIconIsVisible(int[] aCookieIconIsVisible) {
		return XPCOM.VtblCall(nsISupports.LAST_METHOD_ID + 5, getAddress(), aCookieIconIsVisible);
	}
}
