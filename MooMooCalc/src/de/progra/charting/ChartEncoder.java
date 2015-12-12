/*
    JOpenChart Java Charting Library and Toolkit
    Copyright (C) 2001  Sebastian Müller
    http://jopenchart.sourceforge.net

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

    ChartEncoder.java
    Created on 11. November 2001, 18:23
 */

package de.progra.charting;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.IOException;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.bigfoot.bugar.image.PNGEncoder;

/**
 * The ChartEncoder class provides several static methods to encode
 * charts to an OutputStream. This version is part of the JOpenChart branch
 * meant for pre Java 1.4 users. As such, it doesn't use the Java Advanced
 * Imaging library and only supports PNG and JPEG images. Switching from this
 * version to the Java 1.4 version doesn't require a rewrite. The method members
 * are compatible.
 * @author mueller
 * @version 1.0
 */
public class ChartEncoder {
    
    /** Prints the JPEG encoded image to an output stream.
     * @param os the OutputStream where the image will be printed to.
     * @param chart the Chart which will be printed to the output stream
     * @throws EncodingException if an error occurred accessing the Stream
     */
    public static void createJPEG(OutputStream os, Chart chart) throws EncodingException {
        try {
            Rectangle r = chart.getBounds();
            JPEGImageEncoder enc = JPEGCodec.createJPEGEncoder(os);
            BufferedImage img = new BufferedImage((int)r.getWidth(), 
                                                  (int)r.getHeight(), 
                                                  BufferedImage.TYPE_INT_RGB);
            Graphics2D grafx = img.createGraphics();
            chart.render(grafx);
            enc.encode(img);
            enc.getOutputStream().flush();
        } catch(Throwable t) {
            throw new EncodingException(t.getMessage(), t);
        }
    }
    
    /** Prints the GIF encoded image to an output stream.
     * @param os the OutputStream where the image will be printed to.
     * @param chart the Chart which will be printed to the output stream
     * @throws EncodingException if an error occurred accessing the Stream
     * @deprecated GIF encoding is no longer supported, use PNG instead
     */
    public static void createGIF(OutputStream os, Chart chart) throws EncodingException {

    }
    
    /** Prints the PNG encoded image to an output stream.
     * @param os the OutputStream where the image will be printed to.
     * @param chart the Chart which will be printed to the output stream
     * @throws EncodingException if an error occurred accessing the Stream
     */
    public static void createPNG(OutputStream os, Chart chart) throws EncodingException {
        try {
            Rectangle r = chart.getBounds();
            BufferedImage img = new BufferedImage((int)r.getWidth(), 
                                                  (int)r.getHeight(), 
                                                  BufferedImage.TYPE_INT_RGB);
            Graphics2D grafx = img.createGraphics();
            chart.render(grafx);

            PNGEncoder encoder = new PNGEncoder( img, os);
            encoder.encodeImage();
            os.flush();
        } catch(Throwable t) {
            throw new EncodingException(t.getMessage(), t);
        }
    }
    
        
    /** Prints the encoded image to an output stream.
     * @param os the OutputStream where the image will be printed to.
     * @param chart the Chart which will be printed to the output stream
     * @param format the informal format name ("png" or "jpg")
     * @throws EncodingException if an error occurred accessing the Stream
     */
    public static void createEncodedImage(OutputStream os, Chart chart, String format) throws EncodingException {
        if(format.equals("jpg"))
            createJPEG(os, chart);
        else if(format.equals("png"))
            createPNG(os, chart);
        else
            throw new EncodingException("No matching Encoder found. Only PNG and JPG supported.");
    }
    
    /** Returns a String array containing the informal format names for 
     * all supported image encodings.
     */
    public static String[] getSupportedFormats() {
       return new String[] {"jpg", "png"};
    }
}
