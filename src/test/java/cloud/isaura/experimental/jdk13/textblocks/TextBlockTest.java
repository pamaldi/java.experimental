package cloud.isaura.experimental.jdk13.textblocks;

import cloud.isaura.experimental.jdk13.textblocks.TextBlock;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TextBlockTest {

    @Test
    public void when_assert_equals_between_same_string_as_text_block_than_ok()
    {
        String query = TextBlock.getQuery();
        Assert.assertThat(query,  CoreMatchers.is(CoreMatchers.equalTo("select *\n" +
                "from dummy\n" +
                "where dummy.field =12")));
    }

}
