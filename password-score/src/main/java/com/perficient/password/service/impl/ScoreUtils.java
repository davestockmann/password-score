package com.perficient.password.service.impl ;


import java.util.regex.Matcher ;
import java.util.regex.Pattern ;


public class ScoreUtils {

	private static final int	NUM_CHARACTERS_POINTS	= 4 ;
	private static final int	CASE_POINTS	          = 2 ;
	private static final int	NUMERIC_POINTS	      = 4 ;
	private static final int	SYMBOL_POINTS	      = 6 ;
	private static final int	REPEAT_POINTS	      = 2 ;


	public static int scoreRepeatable( String password ) {

		// (n*2)
		return countRepeatCharacters( password ) * REPEAT_POINTS ;
	}


	public static int scoreLettersOnly( String password ) {

		// check for anything that is not a-z or A-Z
		String pattern = "[^a-zA-Z]" ;
		int score = 0 ;

		int count = regexCount( password, pattern ) ;

		if ( count == 0 ) {
			score = password.length() ;
		}

		return score ;
	}


	public static int scoreNumbersOnly( String password ) {

		// check for anything other than 0-9
		String pattern = "[^0-9]" ;
		int score = 0 ;

		int count = regexCount( password, pattern ) ;

		if ( count == 0 ) {
			score = password.length() ;
		}

		return score ;
	}


	public static int scoreNumberOfCharacters( String password ) {

		// (n*4)
		return password.length() * NUM_CHARACTERS_POINTS ;
	}


	public static int scoreUpperCaseLetters( String password ) {

		// ((len-n)*2)
		return ( password.length() - regexCount( password, "[A-Z]" ) ) * CASE_POINTS ;
	}


	public static int scoreLowerCaseLetter( String password ) {

		// ((len-n)*2)
		return ( password.length() - regexCount( password, "[a-z]" ) ) * CASE_POINTS ;
	}


	public static int scoreNumbers( String password ) {

		// (n*4)
		return regexCount( password, "[0-9]" ) * NUMERIC_POINTS ;
	}


	public static int scoreSymbols( String password ) {

		// (n*6)
		return regexCount( password, "[^a-zA-Z0-9 ]" ) * SYMBOL_POINTS ;

	}


	public static int regexCount( String s, String pattern ) {

		int count = 0 ;
		Pattern re = Pattern.compile( pattern ) ;
		Matcher m = re.matcher( s ) ;
		while ( m.find() ) {
			for ( int groupIdx = 0; groupIdx < m.groupCount() + 1; groupIdx++ ) {
				count++ ;
			}
		}

		return count ;
	}


	public static int countRepeatCharacters( String s ) {

		int count = 0 ;
		int len = s.length() ;
		for ( int i = 0; i < len - 1; i++ ) {
			if ( s.charAt( i ) == s.charAt( i + 1 ) )
				count++ ;
		}
		return count ;
	}

}
