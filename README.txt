It's a small tool written in Java that will:
	a)	Recursively walks through specified path and copies out *.* files to a destination folder. 	
	b)	All files are copied into one destination folder, there are no subfolders in a destination folder.
	c)	All the files will be located in one flat structure - don't create any subfolders in target dir.
	d)	If a destination folder doesn't exist, it will be created. Any files already present in this 
		folder should be removed prior running this script.
	e)	All the files in a destination folder except *.dll files will have 0 byte size. 
	    Only *.dll files are left untouched by the script.
	f)	This tool will ask you to type in two arguments, input and output folder, eg:
			copyFiles C:\fileWalk\sampleFiles C:\OutputFiles