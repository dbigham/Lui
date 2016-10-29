package com.danielbigham.lui;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.danielbigham.lui.loading.GrammarFiles;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * A small HTTP server so that clients can request a parse.
 *  
 * @author danielb
 */
public class LuiHttpServer
{
	private final HttpServer server;
	private final Grammar grammar;
	@SuppressWarnings("unused")
	private final GrammarFiles grammarFiles;
	
	public LuiHttpServer(String dir) throws IOException
	{
		grammar = new Grammar();
		grammarFiles = GrammarFiles.create(dir, grammar);
		server = HttpServer.create(new InetSocketAddress(7897), 0);
		server.createContext("/parse", new MyHandler(grammar));
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
		private Grammar grammar;
		
		public MyHandler(Grammar grammar)
		{
			this.grammar = grammar;
		}
		
		@Override
		public void handle(HttpExchange t) throws IOException
		{
			Map<String, String> parms = LuiHttpServer.queryToMap(t.getRequestURI().getQuery());
			String input = parms.get("input");
			String response = ChartParser.parseToExpression(grammar, input);
			LuiHttpServer.response(t, response);
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
	
	static void response(HttpExchange t, String response) throws IOException
	{
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}	
}
