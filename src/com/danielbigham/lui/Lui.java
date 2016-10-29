package com.danielbigham.lui;

import java.io.IOException;

import com.danielbigham.lui.hotkey.LuiHttpServer2;

public class Lui
{
	private LuiHttpServer2 hotkeyHttpServer;
	
	public Lui() throws IOException
	{
		hotkeyHttpServer = new LuiHttpServer2();
	}
	
	/**
	 * De-initialize Lui.
	 */
	public void stop()
	{
		hotkeyHttpServer.stop();
	}
	
	private static LuiHttpServer httpServer;
	public static void main(String[] args) throws IOException, InterruptedException
	{
		String dir = args[0];
		httpServer = new LuiHttpServer(dir);
		//ParserState state = ChartParser.parse(grammar, args[1]);
		//System.out.println(state.toWL());
		//System.exit(0);
	}
}
