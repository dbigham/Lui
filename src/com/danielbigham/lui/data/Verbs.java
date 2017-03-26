package com.danielbigham.lui.data;

import how.How;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.danielbigham.lui.Grammar;

public class Verbs
{
	/**
	 * Load the verbs file and populate the appropriate global alternatives
	 * in the grammar.
	 * 
	 * @param file			The file to load.
	 * @param grammar		The grammar.
	 * 
	 * @throws IOException
	 */
	public static void load(File file, Grammar grammar) throws IOException
	{
		List<String[]> records = How.parseSpaceDelimitedFile(file.toString());
		for (String[] record : records) {
			String baseForm = record[0];
			String ingForm = record[1];
			
			if (grammar.hasWord(baseForm)) {
				grammar.addGlobalAlternative(baseForm, ingForm);
			} else {
				//Out.print("Skipping verb; doesn't appear in grammar: " + baseForm);
			}
		}
	}
}
