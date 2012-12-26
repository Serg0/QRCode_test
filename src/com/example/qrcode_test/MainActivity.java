package com.example.qrcode_test;

//import com.google.zxing.integration.android.IntentIntegrator;
//import com.google.zxing.integration.android.IntentResult;
//import com.google.zxing.client.*;

import com.google.zxing.integration.android.IntentIntegrator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView scanQRcodeResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		scanQRcodeResult = (TextView) findViewById(R.id.scanQRcodeResult);
		Button scanQRcode = (Button) findViewById(R.id.scanQRcode);
		scanQRcode.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// IntentIntegrator integrator = new
				// IntentIntegrator(MainActivity.this);
				// integrator.initiateScan();

				Intent intent = new Intent(
						"com.google.zxing.client.android.SCAN");
				intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
				startActivityForResult(intent, 0);

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// IntentResult scanResult =
		// IntentIntegrator.parseActivityResult(requestCode, resultCode,
		// intent);
		// if (scanResult != null) {
		// // handle scan result
		// Toast.makeText(getApplicationContext(),
		// scanResult.getContents().toString(), Toast.LENGTH_LONG).show();
		// }
		// else continue with any other code you need in the method

		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				// String contents2 = intent.hasExtra("ENTER_CODE_MANUALLY");
				if (intent.hasExtra("ENTER_CODE_MANUALLY")) {
					Toast.makeText(this, "Enter code manually",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, contents, Toast.LENGTH_LONG).show();
					scanQRcodeResult.setText(contents);

					Tiket tiket = referenceParser.parcer(contents);
					// if (tiket != null){
					scanQRcodeResult.append("\nGame ID is " + tiket.getGameID()
							+ "\n " + "Tiket ID is " + tiket.getTiketID());
				}
				// }
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
