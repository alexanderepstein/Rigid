# Rigid


Web applications like Gmail, Facebook, Soundcloud and Pandora are becoming more and more like desktop applications every day. Running each of these web apps in a separate tab in your browser can be a real pain.

This is where Rigid comes in, it creates an application on your computer that points to the web app of your choice. Each of these applications will run on their own seperate process so they will not interfere with one another. Similar to the fluid application for MacOS yet unlike its UNIX counterpart this program is entirely open sourced.

## Install/Run
**First:** Install the dependencies!

**Second:** Download the latest zip of this folder here: http://www.mediafire.com/file/mqhys6bzcxjzbl8/Rigid.zip or if you have git run 
    
    git clone https://github.com/alexanderepstein/Rigid
  
  **Last:** Run the Rigid.exe or Rigid.jar either will work
  
  **Actually Last:** Now in the specified directory there should be a file with the name you specified with the python file extension with a double click it will run the web app if step one has been done correctly. 
  
  **Note** The first time you double click a .py file it might ask you to associate this with a program after choosing the python interpreter once this should not occur again 

## Known Bugs
 * The batch file still has a batch icon and not the icon of the website.
 * URL's must start with http://www. or https://www.
 * If cloned the jar or exe cannot leave the folder or it won't run (this occurs because it doesnt know where the icon images are stored)
 * If downloading the zip the exe cannot leave the Rigid folder or else the application wont run (this occurs because it doesnt know where the icon images are stored)
 

    
## Dependencies

**Chrome:** Google Chrome is the browser used to actually render your application if you have the 64bit version make sure a  version also exists in Program Files (x86) https://www.google.com/chrome/browser/desktop/

**Jave Runtime Enviornment:** Not tested yet but I believe that even if the file being run is an exe it still points to a runnable jar which needs a jvm. http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
