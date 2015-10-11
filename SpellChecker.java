package org.meltwater.java.dataStructures;

import java.io.*;
import java.util.*;

public class SpellChecker {
/**
 * A basic spell checker
 * How it works
 * $ java SpellChecker document.txt dictionary
 * Accepts two inputs: document and dictionary
 * where document may contain spelling mistakes
 * dictionary file contains all the words in the language of the document
 * After successfully running your program
 * a corrected version of document is written to a file called document-corrected.txt
 */
	public static void main(String[] args) {
//		Check that all required files are passed in
//		if (args.length != 2) {
//			System.out.println("You need to pass the document.txt and dictionary");
//			System.out.println("Usage: $ java SpellChecker document.txt dictionary");
//			System.exit(1);
//		}
		File inputFile = null;
		Scanner scan = null;
		String docFile = args[0];
		String dictFile = args[1];
		
//		Load data from the dictionary file
		inputFile = new File(dictFile);
		try {
			scan = new Scanner(inputFile);
//			ArrayList<String> dictList = new ArrayList<String>();
//			while (scan.nextLine() != null) {
//				dictList.add(scan.nextLine());
//			}
//			scan.close();
//			System.out.print(dictList);
		} catch (Exception e) {
			 System.out.println(e);
			 System.exit(1);
		}
		int wordCount = 0;
		while (scan.hasNextLine()) {
			String word = scan.nextLine();
			LinearSearch.addWord(word);			
		}
		scan.close();
		
//		Loop through file to correct
		inputFile = new File(docFile);
        try {
            scan = new Scanner(inputFile);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        int lineNumber = 1;
        System.err.format("Checking spelling for %s.\n\n", docFile);
        System.err.println("=== Misspelled words ===");        
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            ArrayList<String> wordsInLine = getWordsFromString(line);
//            for (String word : wordsInLine) {
//                if (!dictionary.hasWord(word)) {
//                    System.out.format("[%d] %s\n", lineNumber, word);
//                }
//            }
            lineNumber++;
        }
        scan.close();
	}
	String dictionary = "dictionary.text";
	String filename = "Words.txt";
	String correctedDoc = "document-corrected.txt";
	
	public static ArrayList<String> getWordsFromString(String s) {
        ArrayList<String> wordList = new ArrayList<String>();
        String word = "";
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            if (Character.isLetter(ch) || ch == '\'') {
                word += ch;
            } else if (word.length() > 0) {
                wordList.add(word);
                word = "";
            }
        }

        // If s ends with a word, then we haven't added it yet.
        if (word.length() > 0) {
            wordList.add(word);
        }

        return wordList;
    }
	//	TO-DO: Accept working documents, Read them, and write a third.
	
}
