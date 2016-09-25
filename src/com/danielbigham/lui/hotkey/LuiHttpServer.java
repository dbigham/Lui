package com.danielbigham.lui.hotkey;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
//import com.wolfram.jlink.KernelLink;
//import com.wolfram.jlink.MathLinkException;
//import com.wolfram.jlink.StdLink;

/**
 * A small HTTP server so that when the user presses Ctrl-Q, the C#
 * application can make an HTTP connection to LUI and ask it to make
 * the LUI notebook visible and its input field have keyboard focus.
 *  
 * @author danielb
 */
public class LuiHttpServer
{
	private HttpServer server;
	
	public LuiHttpServer() throws IOException
	{
        server = HttpServer.create(new InetSocketAddress(7899), 0);
        server.createContext("/hotkey", new MyHandler());
        server.setExecutor(null);
        server.start();
	}
	
	/**
	 * Stop the web server.
	 */
	public void stop()
	{
		server.stop(0);
	}
	
	/**
	 * Called when http://127.0.0.1:7899/hotkey is visited.
	 * 
	 * Calls back to Wolfram Language kernel to call a function to
	 * instruct it to make the LUI notebook visible and to put the
	 * keyboard focus into its input field.
	 * 
	 * @author danielb
	 */
    static class MyHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange t) throws IOException
        {
        	wlShowLuiUI();
        	
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    /**
     * Call Wolfram Language code via JLink to tell Lui to display its user interface.
     */
	public static void wlShowLuiUI()
	{
//		final KernelLink link = StdLink.getLink();
//		if (link != null)
//		{
//			String command = "Lui`UI`FocusLuiUI[]";
//			try
//			{
//				link.evaluate(command);
//				link.discardAnswer();
//			}
//			catch (MathLinkException e2)
//			{
//				link.print("Unexpected problem displaying the Lui UI: " + e2.toString());
//			}
//		}
//		else
//		{
//			Out.print("ERROR: Couldn't find KernelLink via JLink");
//		}
	}    
}
