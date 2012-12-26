package com.example.qrcode_test;

import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;

public class referenceParser {

	private static final String LOG_TAG = "referenceParser";
	private static final String QUERY_PARAMETER = "a";
	private static final String GAME_ID = "981";


	static Tiket parcer(String input) {
		// Check if reference is valid
		if (URLUtil.isValidUrl(input)) {
			Uri uri = Uri.parse(input);
			// String tiketID = uri.getQueryParameter(QUERY_PARAMETER);
			int pos = uri.getQuery().indexOf("=");
			String tiketID = uri.getQuery().substring(pos + 1, pos + 10);
			Log.d(LOG_TAG, "tiketID = " + tiketID);
			String gameID = uri.getLastPathSegment().substring(1);
			Log.d(LOG_TAG, "gameID = " + gameID);

			if ((tiketID != null) & tiketID.matches("[a-zA-Z]+")
					& gameID.matches("[0-9]+") /* & (gameID.equals(GAME_ID)) */) {
			
				return new Tiket(tiketID.toUpperCase(), gameID);

			}

		}
		Log.d(LOG_TAG, "invalid reference");
		return new Tiket("", "");
	}

}
