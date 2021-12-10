package com.google.gson;
import junit.framework.TestCase;
import java.math.BigInteger;

/**
 * Unit test for issue 1994
 *
 * @author qiao jiang (qiaoj2)
 */
public class Issue1994 extends TestCase {
    /**
     * same as the failure proposal by issue1994
     */

    public void testConvertionLongToIntIssue() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("foo", 10000000000L);

        try{
            jsonObject.get("foo").getAsInt();
            fail();
        }catch (NumberFormatException expected){
        }
    }

    public void testConvertionIntMax() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_int", Integer.MAX_VALUE + 100L);

        try {
            jsonObject.get("max_int").getAsInt();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testConvertionIntMin() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_int", Integer.MIN_VALUE - 100L);

        try {
            jsonObject.get("min_int").getAsInt();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
    public void testConvertionShortMax() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_short", Short.MAX_VALUE+18);

        try {
            jsonObject.get("max_short").getAsShort();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testConvertionShortMin() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_short", Short.MIN_VALUE-18);

        try {
            jsonObject.get("min_short").getAsShort();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testConvertionByteMax() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_byte", Byte.MAX_VALUE+18);

        try {
            jsonObject.get("max_byte").getAsByte();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testConvertionByteMin() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_byte", Byte.MIN_VALUE-18);

        try {
            jsonObject.get("min_byte").getAsByte();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
    public void testconvertionLongMax() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_long", BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(100L)));

        try {
            jsonObject.get("max_long").getAsLong();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertionLongMin() {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_long", BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.valueOf(100L)));

        try {
            jsonObject.get("min_long").getAsLong();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
}
