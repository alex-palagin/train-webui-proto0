package train.ui.support;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by apalagin on 4/21/2017.
 */
public class QueryTest {
    @Test
    public void testQueryParse() {
        String str = "City";
        Query q = Query.parse(str);
        assertThat(q).isNotNull();
        assertThat(q.getRootTag()).isNotNull();
        assertThat(q.getRequestPath()).size().isEqualTo(1);
    }
}
