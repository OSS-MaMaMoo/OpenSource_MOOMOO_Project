*************************************
**
** JOpenChart
**
** README.txt
**
** http://jopenchart.sourceforge.net
** http://www.sourceforge.net/projects/jopenchart
**
*************************************



Description
===========

JOpenChart is a library and toolkit for rendering various kinds of charts.
Additionally it includes several nifty mathematical features like plotting
functions, interpolating discrete data using different algorithms etc.
There are detailed API docs available on the sourceforge page and an 
additional tutorial is always online at jopenchart.sourceforge.net.
The library is centered around the DefaultChart class, this is what you should
start with. It implements the Chart interface, like ChartPanel does too.
That means you can create a chart image using DefaultChart just like you
can embed a chart into a Swing application via ChartPanel. 
You can define the look of the title and legend, and also of the coordinate system.
All chart types are implemented as ChartRenderer instances. Currently, there
are ChartRenderers available for plot, line, bar, radar and pie charts and there is
a ChartRenderer that implements a curve fitting algorithm (Neville-Aitken) to
interpolate discrete data. You can combine multiple renderers (e.g. plot, line, 
interpolation) to create more complex charts.

License
=======
JOpenChart is published under the LGPL. Please see the LICENSE.txt file for 
further information.

Installation
============

Required files and packages:

 -encoding libraries
	No libraries are needed for encoding. By now, this is done
        through the JDK 1.4 Advanced Imaging API

 -jep Java Expression Parser
	available at jep.sourceforge.net
        Please note, that JOpenChart requires a patched version of JEP
        which is part of the charting-xxx.lib.zip file on the sourceforge
        project page.

These libraries are available in the charting-xxx.lib.zip distribution
package on sourceforge. You will also get them if you check out the complete
JOpenChart tree from cvs.jopenchart.sourceforge.net. Instructions for accessing
projects via CVS are given on the sourceforge.net site.

You can build the source release via the build.xml Ant script. Calling
it using Ant, will create a bin and dist directory, containing the binaries
and the distribution files. Additionally, it will call the TestChart class
which creates several example PNG images in your home directory.
Please note, that you must download and unpack the needed libraries first.
Ant is available at http://jakarta.apache.org/ant/index.html
You have to point Ant to the installed libraries on your system. The build file
contains one line where have to enter the path on your system.

In order to install the example web applications copy the dist/charting-xxx.war
file as charting.war to the Tomcat webapps directory. So far, this only works
with Tomcat 3.xx. If anybody could offer help to get it running under Tomcat 4
I'd be very happy. 
After starting Tomcat (or whatever
you use) the web examples are available at 
http://serverhome/charting/ChartPage.jsp and 
http://serverhome/charting/FunctionPlot.jsp.