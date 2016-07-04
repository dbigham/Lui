package com.danielbigham.lui;

import java.io.IOException;

import com.danielbigham.lui.hotkey.LuiHttpServer;

public class Lui
{
	private LuiHttpServer hotkeyHttpServer;
	
	public Lui() throws IOException
	{
		hotkeyHttpServer = new LuiHttpServer();
	}
	
	/**
	 * De-initialize Lui.
	 */
	public void stop()
	{
		hotkeyHttpServer.stop();
	}
	
    public static void main(String[] args) throws IOException, InterruptedException
    {
        @SuppressWarnings("unused")
		Lui lui = new Lui();
        
        System.console().readLine();
    }
}
