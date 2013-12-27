package com.perficient.password.service.impl ;


import static org.hamcrest.CoreMatchers.equalTo ;
import static org.junit.Assert.assertThat ;

import org.junit.Test ;


public class ScoreUtilsTest {

	@Test
	public void score_repeat( ) {

		String password = "jellyd99" ;
		int score = ScoreUtils.scoreRepeatable( password ) ;
		assertThat( "score is 4", score, equalTo( 4 ) ) ;
	}


	@Test
	public void score_repeat_expect_zero( ) {

		String password = "perficient" ;
		int score = ScoreUtils.scoreRepeatable( password ) ;
		assertThat( "score is 0", score, equalTo( 0 ) ) ;
	}


	@Test
	public void numberOfCharacters( ) {

		String password = "jelly" ;
		int score = ScoreUtils.scoreNumberOfCharacters( password ) ;
		assertThat( "score is 20", score, equalTo( 20 ) ) ;
	}


	@Test
	public void upperCase( ) {

		// ((len-n)*2)
		String password = "jElLy" ;
		int score = ScoreUtils.scoreUpperCaseLetters( password ) ;
		assertThat( "score is 6", score, equalTo( 6 ) ) ;
	}


	@Test
	public void lowerCase( ) {

		// ((len-n)*2)
		String password = "jElLy" ;
		int score = ScoreUtils.scoreLowerCaseLetter( password ) ;
		assertThat( "score is 4", score, equalTo( 4 ) ) ;
	}


	@Test
	public void numeric( ) {

		String password = "1elly5" ;
		int score = ScoreUtils.scoreNumbers( password ) ;
		assertThat( "score is 8", score, equalTo( 8 ) ) ;

	}


	@Test
	public void symbols( ) {

		String password = "!perf*cient%" ;
		int score = ScoreUtils.scoreSymbols( password ) ;
		assertThat( "score is 18", score, equalTo( 18 ) ) ;
	}


	@Test
	public void letters_only( ) {

		String password = "perficient" ;
		int score = ScoreUtils.scoreLettersOnly( password ) ;
		assertThat( "score is lenght of password", score, equalTo( password.length() ) ) ;
	}


	@Test
	public void letters_only_should_be_zero( ) {

		String password = "perficient4@" ;
		int score = ScoreUtils.scoreLettersOnly( password ) ;
		assertThat( "score should be 0", score, equalTo( 0 ) ) ;
	}


	@Test
	public void numbers_only( ) {

		String password = "1234567890" ;
		int score = ScoreUtils.scoreNumbersOnly( password ) ;
		assertThat( "score is lenght of password", score, equalTo( password.length() ) ) ;
	}


	@Test
	public void numbers_only_expect_zero( ) {

		String password = "perficient" ;
		int score = ScoreUtils.scoreNumbersOnly( password ) ;
		assertThat( "score is 0", score, equalTo( 0 ) ) ;
	}


	@Test
	public void numbers_only_should_be_zero( ) {

		String password = "perficient4" ;
		int score = ScoreUtils.scoreLettersOnly( password ) ;
		assertThat( "score should be 0", score, equalTo( 0 ) ) ;
	}


	@Test
	public void count_repeat_characters( ) {

		String password = "pperfiicent" ;
		int count = ScoreUtils.countRepeatCharacters( password ) ;
		assertThat( "count should be 2", count, equalTo( 2 ) ) ;
	}
}
