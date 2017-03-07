// This is a test harness for your module
// You should do something interesting in this harness
// to test out the module and to provide instructions
// to users on how to use it by example.


// open a single window
var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel({test:'NAPP NUKEM! Android only!'});
win.add(label);
win.open();


var os = Titanium.Platform.osname;
if(os==='android'){
	// Due to attempts to resume downloads in the NappDownloadManager module and leftover files, a module has been created to clean up the .dat files 
	// The files are stored in a private location accessible by the package (app) context. For some reason the Ti app cannot access them to delete them normally.
	// So, this will nuke the .dat files created by any previous download session. 
	var nappnuker = require('com.kosso.nappnuker');
	Ti.API.info("module is => " + nappnuker);
	nappnuker.nukeNappDownloaderData();
	nappnuker = null;
}

