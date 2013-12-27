package com.perficient.password.service.impl ;


import static com.perficient.password.service.impl.ScoreUtils.scoreLettersOnly ;
import static com.perficient.password.service.impl.ScoreUtils.scoreLowerCaseLetter ;
import static com.perficient.password.service.impl.ScoreUtils.scoreNumberOfCharacters ;
import static com.perficient.password.service.impl.ScoreUtils.scoreNumbers ;
import static com.perficient.password.service.impl.ScoreUtils.scoreNumbersOnly ;
import static com.perficient.password.service.impl.ScoreUtils.scoreRepeatable ;
import static com.perficient.password.service.impl.ScoreUtils.scoreSymbols ;
import static com.perficient.password.service.impl.ScoreUtils.scoreUpperCaseLetters ;

import org.apache.commons.lang3.StringUtils ;


public class PasswordScoreServiceImpl {

	public int score( String password ) {

		if ( StringUtils.isBlank( password ) ) {
			throw new IllegalArgumentException( "password can not be blank" ) ;
		}

		int score = 0 ;

		String trimmedPassword = StringUtils.trim( password ) ;

		score += scoreNumberOfCharacters( trimmedPassword ) ;
		score += scoreUpperCaseLetters( trimmedPassword ) ;
		score += scoreLowerCaseLetter( trimmedPassword ) ;
		score += scoreNumbers( trimmedPassword ) ;
		score += scoreSymbols( trimmedPassword ) ;
		score -= scoreLettersOnly( trimmedPassword ) ;
		score -= scoreNumbersOnly( trimmedPassword ) ;
		score -= scoreRepeatable( trimmedPassword ) ;

		if ( score > 100 ) {
			score = 100 ;
		}

		return score ;
	}

}
