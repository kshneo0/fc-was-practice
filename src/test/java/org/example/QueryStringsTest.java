package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author :  sanghoonkim
 * date : 2022/12/28
 */
class QueryStringsTest {
    @Test
    void createTest() {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55"); //List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}