package com.perficient.password.service.impl ;


import static org.hamcrest.CoreMatchers.equalTo ;
import static org.junit.Assert.assertThat ;
import static org.junit.Assert.assertTrue ;

import java.util.Arrays ;
import java.util.Collection ;

import org.junit.Before ;
import org.junit.Test ;
import org.junit.runner.RunWith ;
import org.junit.runners.Parameterized ;
import org.junit.runners.Parameterized.Parameters ;


@RunWith(value = Parameterized.class)
public class PasswordScoreServiceImplTest {

	PasswordScoreServiceImpl	cut	= null ;


	@Parameters(name = "{index}: score[{0}]={1}")
	public static Collection<Object[]> data( ) {

		return Arrays.asList( new Object[][] { { "perficient", 50 }, { "cardinals", 45 }, { "1234567890", 100 },
		                { "Cardinal$15", 86 }, { "CArdinals", 45 }, { "p@s$w0r#", 78 }, { "jA(kBauer", 62 },
		                { "jellyfish", 43 }, { "jelly", 23 },
		                { "thisisareallylongpasswordthatshouldgenerateascoreof100", 100 } } ) ;
	}

	private String	password ;
	private int	   expected ;


	public PasswordScoreServiceImplTest(String password, int expected) {

		this.password = password ;
		this.expected = expected ;
	}


	@Before
	public void setup( ) {

		cut = new PasswordScoreServiceImpl() ;
	}


	@Test(expected = IllegalArgumentException.class)
	public void score_with_null( ) {

		cut.score( null ) ;
		assertTrue( false ) ;
	}


	@Test(expected = IllegalArgumentException.class)
	public void score_with_empty( ) {

		cut.score( "" ) ;
		assertTrue( false ) ;
	}


	@Test(expected = IllegalArgumentException.class)
	public void score_with_blank( ) {

		cut.score( " " ) ;
		assertTrue( false ) ;
	}


	@Test
	public void score( ) {

		int score = cut.score( this.password ) ;

		System.out.println( password + "\t" + score ) ;

		assertThat( score, equalTo( this.expected ) ) ;
	}

}
