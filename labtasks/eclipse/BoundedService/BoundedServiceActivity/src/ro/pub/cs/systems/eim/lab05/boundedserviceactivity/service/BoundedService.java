package ro.pub.cs.systems.eim.lab05.boundedserviceactivity.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import ro.pub.cs.systems.eim.lab05.boundedserviceactivity.general.Constants;


public class BoundedService extends Service {

    final private IBinder boundedServiceBinder = new BoundedServiceBinder();


    public class BoundedServiceBinder extends Binder {
    	
    	public BoundedService getService() {
    		return BoundedService.this;
    	}
    	
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method from service was invoked");
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method from service was invoked");
        return boundedServiceBinder;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.TAG, "onUnbind() method from service was invoked");
        return super.onUnbind(intent);
    }


    @Override
    public void onDestroy() {
        Log.d(Constants.TAG, "onDestroy() method from service was invoked");
        super.onDestroy();
    }


    public String getMessage() {
        if (Math.random() < 0.5)
        	return Constants.MESSAGES.get(0);
        else
        	return Constants.MESSAGES.get(1);
    }

}
