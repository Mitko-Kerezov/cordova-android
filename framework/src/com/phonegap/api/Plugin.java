package com.phonegap.api;

import org.json.JSONArray;
import com.phonegap.DroidGap;
import android.content.Intent;
import android.webkit.WebView;

/**
 * Plugin interface must be implemented by any plugin classes.
 *
 * The execute method is called by the PluginManager.
 */
public abstract class Plugin implements IPlugin {

    public WebView webView;					// WebView object
    public DroidGap ctx;						// DroidGap object

	/**
	 * Executes the request and returns PluginResult.
	 * 
	 * @param action 	The action to execute.
	 * @param args 		JSONArry of arguments for the plugin.
	 * @return 			A PluginResult object with a status and message.
	 */
	public abstract PluginResult execute(String action, JSONArray args);

	/**
	 * Identifies if action to be executed returns a value and should be run synchronously.
	 * 
	 * @param action	The action to execute
	 * @return			T=returns value
	 */
	public boolean isSynch(String action) {
		return false;
	}

	/**
	 * Sets the context of the Plugin. This can then be used to do things like
	 * get file paths associated with the Activity.
	 * 
	 * @param ctx The context of the main Activity.
	 */
	public void setContext(DroidGap ctx) {
		this.ctx = ctx;
	}

	/**
	 * Sets the main View of the application, this is the WebView within which 
	 * a PhoneGap app runs.
	 * 
	 * @param webView The PhoneGap WebView
	 */
	public void setView(WebView webView) {
		this.webView = webView;
	}
		
    /**
     * Called when the system is about to start resuming a previous activity. 
     */
    public void onPause() {
    }

    /**
     * Called when the activity will start interacting with the user. 
     */
    public void onResume() {
    }
    
    /**
     * The final call you receive before your activity is destroyed. 
     */
    public void onDestroy() {
    }
	
    /**
     * Called when an activity you launched exits, giving you the requestCode you started it with,
     * the resultCode it returned, and any additional data from it. 
     * 
     * @param requestCode		The request code originally supplied to startActivityForResult(), 
     * 							allowing you to identify who this result came from.
     * @param resultCode		The integer result code returned by the child activity through its setResult().
     * @param data				An Intent, which can return result data to the caller (various data can be attached to Intent "extras").
     */
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    }

    /**
     * Send JavaScript statement back to JavaScript.
     * 
     * @param statement
     */
    public void sendJavascript(String statement) {
    	this.ctx.callbackServer.sendJavascript(statement);
    }

}
