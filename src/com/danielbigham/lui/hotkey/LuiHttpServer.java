package com.danielbigham.lui.hotkey;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.danielbigham.Util;
import com.danielbigham.io.Out;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.wolfram.jlink.KernelLink;
import com.wolfram.jlink.MathLinkException;
import com.wolfram.jlink.StdLink;
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
		server.createContext("/define_linguistic", new DefineLinguistic());
		server.createContext("/create_notebook", new CreateNotebook());
		server.createContext("/EvaluateEvaluationTarget", new EvaluateEvaluationTarget());
		server.createContext("/SetEvaluationTarget", new SetEvaluationTarget());
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
			LuiHttpServer.defaultResponse(t);
		}
	}
	
	/**
	 * Associate a linguistic via hotkey. For example, select a URL in Chrome's address bar
	 * and press Ctrl-Alt-L.
	 * 
	 * @author Daniel
	 */
	static class DefineLinguistic implements HttpHandler
	{
		@Override
		public void handle(HttpExchange t) throws IOException
		{
			Map<String, String> parms = LuiHttpServer.queryToMap(t.getRequestURI().getQuery());			
			String title = parms.get("title");
			String selected = parms.get("selected");
			callWL(
				"Lui`UI`DefineLinguisticHotkey["  +
					"\"Title\" -> " + Util.createDoubleQuotedString(title) + "," +
					"\"Selected\" -> " + Util.createDoubleQuotedString(selected) +
				"]");
			LuiHttpServer.defaultResponse(t);
		}
	}
	
	/**
	 * Evaluate the designated cell.
	 * 
	 * @author Daniel
	 */
	static class EvaluateEvaluationTarget implements HttpHandler
	{
		@Override
		public void handle(HttpExchange t) throws IOException
		{			
			callWL(
				"EvaluateEvaluationTarget[]");
			LuiHttpServer.defaultResponse(t);
		}
	}
	
	/**
	 * Sets the evaluation target to the currently selected cell.
	 * 
	 * @author Daniel
	 */
	static class SetEvaluationTarget implements HttpHandler
	{
		@Override
		public void handle(HttpExchange t) throws IOException
		{			
			callWL(
				"SetEvaluationTarget[]");
			LuiHttpServer.defaultResponse(t);
		}
	}
	
	/**
	 * Create a new Mathematica notebook.
	 * 
	 * @author Daniel
	 */
	static class CreateNotebook implements HttpHandler
	{
		@Override
		public void handle(HttpExchange t) throws IOException
		{
			Map<String, String> parms = LuiHttpServer.queryToMap(t.getRequestURI().getQuery());			
			String name = parms.get("name");
			callWL(
				"CreateIssueNotebook["  +
					"\"Name\" -> " + Util.createDoubleQuotedString(name) +
				"]");
			LuiHttpServer.defaultResponse(t);
		}
	}
	
	  /**
	   * returns the url parameters in a map
	   * @param query
	   * @return map
	   */
	  public static Map<String, String> queryToMap(String query)
	  {
		Map<String, String> result = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=");
			if (pair.length > 1)
			{
				result.put(pair[0], pair[1]);
			}
			else
			{
				result.put(pair[0], "");
			}
		}
		return result;
	  }
	
	static void defaultResponse(HttpExchange t) throws IOException
	{
		String response = "This is the response";
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	
	/**
	 * Make a call to Wolfram Language and execute a command.
	 * 
	 * @param command		the command to execute.
	 */
	public static void callWL(String command)
	{
		final KernelLink link = StdLink.getLink();
		if (link != null)
		{
			try
			{
				link.evaluate(command);
				link.discardAnswer();
			}
			catch (MathLinkException e2)
			{
				link.print("Unexpected problem calling WL: " + e2.toString());
			}
		}
		else
		{
			Out.print("ERROR: Couldn't find KernelLink via JLink");
		}
	}	
	
	/**
	 * Call Wolfram Language code via JLink to tell Lui to display its user interface.
	 */
	public static void wlShowLuiUI()
	{
//		callWL["Lui`UI`FocusLuiUI[]"];
	}	
}
