package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.R;
import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;


public class StartedServiceActivity extends Activity {
	
    private TextView messageTextView;
    private StartedServiceBroadcastReceiver startedServiceBroadcastReceiver;
    private Intent intent;
    private IntentFilter startedServiceIntentFilter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_started_service);
		
        messageTextView = (TextView)findViewById(R.id.message_text_view);

        //creare instanta BroadcastReceiver
        //startedServiceBroadcastReceiver = new StartedServiceBroadcastReceiver(messageTextView);

        //creare instanta IntentFilter la care se seteaza actiunile ce se doresc a fi ascultate
        startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction(Constants.ACTION_STRING);
        startedServiceIntentFilter.addAction(Constants.ACTION_INTEGER);
        startedServiceIntentFilter.addAction(Constants.ACTION_ARRAY_LIST);

        //start service
        intent = new Intent();
        intent.setComponent(new ComponentName("ro.pub.cs.systems.eim.lab05.startedservice", "ro.pub.cs.systems.eim.lab05.startedservice.service.StartedService"));
        startService(intent);
	}


    @Override
    protected void onResume() {
        super.onResume();
        
        //registerReceiver(startedServiceBroadcastReceiver, startedServiceIntentFilter);
    }


    @Override
    protected void onPause() {
    	//unregisterReceiver(startedServiceBroadcastReceiver);
    	
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        //stop service
    	stopService(intent);

        super.onDestroy();
    }


    @Override
    protected void onNewIntent(Intent intent) {
    	super.onNewIntent(intent);
    	
    	String message = intent.getStringExtra(Constants.MESSAGE);
    	messageTextView.setText(messageTextView.getText().toString() + "\n" + message);
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.started, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
			return true;
		
		return super.onOptionsItemSelected(item);
	}
	
}
