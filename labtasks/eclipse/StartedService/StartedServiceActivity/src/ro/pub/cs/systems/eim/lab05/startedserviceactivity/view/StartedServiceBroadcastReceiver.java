package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    public StartedServiceBroadcastReceiver() { }
    

    @Override
    public void onReceive(Context context, Intent intent) {
        //extragere date din intent si afisare in TextView
    	String action = intent.getAction();
    	String data = null;
    	
    	if (Constants.ACTION_STRING.equals(action))
    		data = intent.getStringExtra(Constants.DATA).toString();
    	else if (Constants.ACTION_INTEGER.equals(action))
    		data = String.valueOf(intent.getIntExtra(Constants.DATA, 0));
    	else if (Constants.ACTION_ARRAY_LIST.equals(action))
    		data = intent.getStringArrayListExtra(Constants.DATA).toString();

        //restartam activitatea printr-o intentie pentru ca ea sa puna datele in TextView
    	Intent startedServiceActivityIntent = new Intent(context, StartedServiceActivity.class);
    	startedServiceActivityIntent.putExtra(Constants.MESSAGE, data);
    	startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    	context.startActivity(startedServiceActivityIntent);
    }

}
