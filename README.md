# NappNuker
An Android Titanium module to nuke and leftover files and data after an aborted download queue from the [Android version of the NappDownloadManager](https://github.com/viezel/NappDownloadManager).  

NB: ***This will disable the ability to resume downloads on the next launch of the app***. (Many of us do not need this ability since it can complicate things a great deal!)

(For some reason I can't get a patched fork to build in Studio, so I created this extra module to do the job!)

The compiled module zip is in the /dist folder. 



#### Usage

**BEFORE** loading the main NappDownloadmanager module… Preferably in app.js 

```
if(Titanium.Platform.osname==='android'){
  var nappnuker = require('com.kosso.nappnuker');
  nappnuker.nukeNappDownloaderData();
  nappnuker = null;
}
```

That's it.



An [iOS version of the NappDownloadmanager](https://github.com/kosso/NappDownloadManager) has been patched with this built-in. i.e.: No resuming downloads. The iOS version will also clean up any partially/failed downloads caused by a crash/exit during a download queue. 



-----------

@kosso 2017