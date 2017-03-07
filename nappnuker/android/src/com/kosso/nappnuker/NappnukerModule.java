package com.kosso.nappnuker;

import java.io.File;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

import android.content.Context;


@Kroll.module(name="Nappnuker", id="com.kosso.nappnuker")
public class NappnukerModule extends KrollModule
{
	private static final String LCAT = "NappnukerModule";	
	private static Context appContext;
	
	public NappnukerModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		appContext = TiApplication.getInstance();
	}

	// Methods
	@Kroll.method
	public void nukeNappDownloaderData()
	{
		// List files private to this package/app
		String[] files = appContext.fileList();
		// List NappDownloadManager queue and batch data files
		for (String s: files) {       
			Log.i(LCAT, "FILE: " + s); 
			if(s.equals("DownloadQueue.dat")){
				if(appContext.deleteFile(s)){
					Log.i(LCAT, "deleted: " + s); 					
				}
			}
			if(s.equals("DownloadBatches.dat")){
				if(appContext.deleteFile(s)){
					Log.i(LCAT, "deleted: " + s); 					
				}
			}
			if(s.equals("DownloadItemCatalog.dat")){
				if(appContext.deleteFile(s)){
					Log.i(LCAT, "deleted: " + s); 					
				}
			}	
			if(s.equals("DownloadBatchCatalog.dat")){
				if(appContext.deleteFile(s)){
					Log.i(LCAT, "deleted: " + s); 					
				}
			}
		}
		files = null;
		Log.i(LCAT, "NappDownloadManager was nuked!"); 
	}
}

