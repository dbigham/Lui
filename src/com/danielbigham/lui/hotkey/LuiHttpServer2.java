package com.danielbigham.lui.hotkey;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.danielbigham.Util;
import com.danielbigham.Util2;
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
public class LuiHttpServer2
{
	private HttpServer server;
	
	public LuiHttpServer2() throws IOException
	{
		server = HttpServer.create(new InetSocketAddress(7899), 0);
		server.createContext("/hotkey", new MyHandler());
		server.createContext("/define_linguistic", new DefineLinguistic());
		server.createContext("/create_notebook", new CreateNotebook());
		server.createContext("/EvaluateEvaluationTarget", new EvaluateEvaluationTarget());
		server.createContext("/SetEvaluationTarget", new SetEvaluationTarget());
		server.createContext("/CreateLuiLink", new CreateLuiLink());
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
			LuiHttpServer2.defaultResponse(t);
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
			Map<String, String> parms = LuiHttpServer2.queryToMap(t.getRequestURI().getQuery());			
			String title = parms.get("title");
			String selected = parms.get("selected");
			String process = parms.get("process");
			Util2.callWL(
				"Lui`UI`DefineLinguisticHotkey["  +
					"\"Title\" -> " + Util.createDoubleQuotedString(title) + "," +
					"\"Selected\" -> " + Util.createDoubleQuotedString(selected) + "," +
					"\"Process\" -> " + Util.createDoubleQuotedString(process) +
				"]");
			LuiHttpServer2.defaultResponse(t);
		}
	}
	
	/**
	 * Create a new LUI link cell in the current notebook.
	 * 
	 * @author Daniel
	 */
	static class CreateLuiLink implements HttpHandler
	{
		@Override
		public void handle(HttpExchange t) throws IOException
		{
			Map<String, String> parms = LuiHttpServer2.queryToMap(t.getRequestURI().getQuery());			
			String text = parms.get("text");
			Util2.callWL(
				"CreateLuiLink["  +
					Util.createDoubleQuotedString(text) +
				"]");
			LuiHttpServer2.defaultResponse(t);
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
			Util2.callWL(
				"WUtils`WUtils`EvaluateEvaluationTarget[]");
			LuiHttpServer2.defaultResponse(t);
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
			Util2.callWL(
				"WUtils`WUtils`SetEvaluationTarget[]");
			LuiHttpServer2.defaultResponse(t);
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
			Map<String, String> parms = LuiHttpServer2.queryToMap(t.getRequestURI().getQuery());			
			String name = parms.get("name");
			Util2.callWL(
				"WUtils`WUtils`CreateIssueNotebook["  +
					"\"Name\" -> " + Util.createDoubleQuotedString(name) +
				"]");
			LuiHttpServer2.defaultResponse(t);
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
	 * Call Wolfram Language code via JLink to tell Lui to display its user interface.
	 */
	public static void wlShowLuiUI()
	{
//		callWL["Lui`UI`FocusLuiUI[]"];
	}	
}
