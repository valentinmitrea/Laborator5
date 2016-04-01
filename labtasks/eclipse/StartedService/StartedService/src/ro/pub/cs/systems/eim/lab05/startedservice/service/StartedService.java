package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;


public class StartedService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method was invoked");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constants.TAG, "onStartCommand() method was invoked");
        //pornire thread ProcessingThread
        new ProcessingThread(getApplicationContext()).start();

        return START_REDELIVER_INTENT;
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method was invoked");
        return null;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.TAG, "onUnbind() method was invoked");
        return true;
    }


    @Override
    public void onRebind(Intent intent) {
        Log.d(Constants.TAG, "onRebind() method was invoked");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }


    class ProcessingThread extends Thread {
    	
    	private Context context;
    	
    	
    	public ProcessingThread(Context context) {
    		this.context = context;
    	}
    	
    	
    	@Override
    	public void run() {
    		Log.d(Constants.TAG, "Thread.run() was invoked, PID:" + android.os.Process.myPid() + " TID:" + android.os.Process.myTid());
    		
    		//intentie cu difuzare pentru sir de caractere
    		Intent intent = new Intent();
    		intent.setAction(Constants.ACTION_STRING);
    		intent.putExtra(Constants.DATA, Constants.STRING_DATA);
    		context.sendBroadcast(intent);
    		
    		try {
				Thread.sleep(Constants.SLEEP_TIME);
			}
    		catch (InterruptedException e) {
				e.printStackTrace();
			}
    		
    		//intentie cu difuzare pentru numar intreg
    		intent = new Intent();
    		intent.setAction(Constants.ACTION_INTEGER);
    		intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
    		context.sendBroadcast(intent);
    		
    		try {
				Thread.sleep(Constants.SLEEP_TIME);
			}
    		catch (InterruptedException e) {
				e.printStackTrace();
			}
    		
    		//intentie cu difuzare pentru ArrayList
    		intent = new Intent();
    		intent.setAction(Constants.ACTION_ARRAY_LIST);
    		intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
    		context.sendBroadcast(intent);
    		
    		try {
				Thread.sleep(Constants.SLEEP_TIME);
			}
    		catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	
    }

}
