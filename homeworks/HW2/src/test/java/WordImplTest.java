import org.junit.Assert;
import org.junit.Test;



public class WordImplTest {

    @Test
    public void checkBulls() {

        WordImpl askedWordImpl = new WordImpl("testword".toCharArray());
        Assert.assertEquals(4, askedWordImpl.checkBulls("testaaaa".toCharArray()));
        Assert.assertEquals(3, askedWordImpl.checkBulls("tesaaaaa".toCharArray()));
        Assert.assertEquals(1, askedWordImpl.checkBulls("taaaaaaa".toCharArray()));
    }

    @Test
    public void checkDictionary(){



    }
}