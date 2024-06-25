package com.munte.section3;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"name\":\"Ball\",\"id\":1,\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptSpaces() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"id\":1,\"price\":10,\"quantity\":100}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"name\":\"Ball\",\"id\":1,\"price\":10}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1, name: \"Ball\", price:10}";

        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

}
