import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by vidyachandasekhar on 5/31/17.
 */
public class JerksonParserTest {

    private JerksonParser jerksonParser;

    @Before
    public void setUp() {
        jerksonParser = new JerksonParser();
    }

    //replace '##' with  ','
    @Test
    public void parse() throws Exception {
        //when
        String actualString = jerksonParser.parse("naMe@MilK;price^1.23;type:Food;expiration:4/25/2016##");
        //then
        Assert.assertEquals("the Strings are  not matching", "naMe:MilK;price:1.23;type:Food;expiration:4/25/2016,", actualString);
    }

    @Test
    public void parseTestSpelling() throws Exception {
        //when
        String actualString = jerksonParser.parse("naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##");
        //then
        Assert.assertEquals("the Strings are  not matching", "naMe:CookieS;pRice:2.25;type:Food;expiration:1/25/2016,", actualString);
    }



}