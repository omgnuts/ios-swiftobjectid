//
//  ViewController.swift
//  HumanReadableObjectID
//
//  Created by Javan Tan on 16/7/15.
//  Copyright (c) 2015 MikiMedia. All rights reserved.
//

import Cocoa

class RootViewController: NSViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override var representedObject: AnyObject? {
        didSet {
        // Update the view, if already loaded.
        }
    }
    
    @IBAction func showFileChooser(sender: AnyObject) {
        
        
//        var openPanel = NSOpenPanel()
//        openPanel.title = "Select File"
//        openPanel.message = "Another piece of fuck"
//        openPanel.allowsMultipleSelection = false
//        openPanel.canChooseDirectories = false
//        openPanel.canCreateDirectories = false
//        openPanel.canChooseFiles = true
//        openPanel.showsHiddenFiles = false;
//        openPanel.allowedFileTypes = ["xib"]
//        openPanel.beginWithCompletionHandler { (result) -> Void in
//            if result == NSFileHandlingPanelOKButton {
//                //Do what you will
//                //If there's only one URL, surely 'openPanel.URL'
//                //but otherwise a for loop works
//            }
//        }
        openfiledialog("Tittites", message: "Some fuck", filetypelist: "xib")
        
    }
    
    func not (b: Bool) -> Bool {
        return (!b)
    }
    
    func suspendprocess (t: Int) {
        var secs: Int = Int(round(Double(t) * 0.001))
        var nanosecs: Int = Int((abs(t) - secs) * 1000000)
        var time = timespec(tv_sec: secs, tv_nsec: nanosecs)
        let result = nanosleep(&time, nil)
    }
    
    func openfiledialog (windowTitle: String, message: String, filetypelist: String) -> String {
        var path: String = ""
//        var finished: Bool = false
//        
//        suspendprocess (20) // Wait 20 ms., enough time to do screen updates regarding to the background job, which calls this function
//        dispatch_async(dispatch_get_main_queue())
//            {
                var myFiledialog: NSOpenPanel = NSOpenPanel()
                var fileTypeArray: [String] = filetypelist.componentsSeparatedByString(",")
                
                myFiledialog.prompt = "Open"
                myFiledialog.worksWhenModal = true
                myFiledialog.allowsMultipleSelection = false
                myFiledialog.canChooseDirectories = false
                myFiledialog.resolvesAliases = true
                myFiledialog.title = windowTitle
                myFiledialog.message = message
                myFiledialog.allowedFileTypes = fileTypeArray
                
                let void = myFiledialog.runModal()
                
                var chosenfile = myFiledialog.URL // Pathname of the file
                
                if (chosenfile != nil)
                {
                    path = chosenfile!.absoluteString!
                }
//                finished = true
//        }
//        
//        while not (finished) {
//             suspendprocess (1) // Wait 1 ms., loop until main thread finished
//        }
//
        return path;
    }
    
    
    
//    - (IBAction)selectFileButtonAction:(id)sender {
//    
//    //create open panel...
//    NSOpenPanel* openPanel = [NSOpenPanel openPanel];
//    // NSLog(@"Open Panel");
//    //set restrictions / allowances...
//    [openPanel setAllowsMultipleSelection: NO];
//    [openPanel setCanChooseDirectories:NO];
//    [openPanel setCanCreateDirectories:NO];
//    [openPanel setCanChooseFiles:YES];
//    //only allow images...
//    [openPanel setAllowedFileTypes:[NSImage imageFileTypes]];
//    //open panel as sheet on main window...
//    [openPanel beginWithCompletionHandler:^(NSInteger result)  {
//    if (result == NSFileHandlingPanelOKButton) {
//    
//    //get url (should only be one due to restrictions)...
//    for( NSURL* URL in [openPanel URLs] ) {
//    // self.roundClockView1.URL = URL ;
//    _thePath = URL;
//    currentSelectedFileName = [[URL path] lastPathComponent];
//    // [_roundClockView1 setNeedsDisplay:1];
//    [self openEditor];
//    }
//    
//    }
//    }];
}

