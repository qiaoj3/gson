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

    public void testconvertion_long_to_int_issue() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("foo", 10000000000L);

        try{
            jsonObject.get("foo").getAsInt();
            fail();
        }catch (NumberFormatException expected){
        }
    }

    public void testconvertion_int_max() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_int", Integer.MAX_VALUE + 100L);

        try {
            jsonObject.get("max_int").getAsInt();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertion_int_min() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_int", Integer.MIN_VALUE - 100L);

        try {
            jsonObject.get("min_int").getAsInt();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
    public void testconvertion_short_max() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_short", Short.MAX_VALUE+18);

        try {
            jsonObject.get("max_short").getAsShort();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertion_short_min() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_short", Short.MIN_VALUE-18);

        try {
            jsonObject.get("min_short").getAsShort();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertion_byte_max() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_byte", Byte.MAX_VALUE+18);

        try {
            jsonObject.get("max_byte").getAsByte();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertion_byte_min() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_byte", Byte.MIN_VALUE-18);

        try {
            jsonObject.get("min_byte").getAsByte();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
    public void testconvertion_long_max() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max_long", BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.valueOf(100L)));

        try {
            jsonObject.get("max_long").getAsLong();
            fail();
        } catch (NumberFormatException expected) {
        }

    }

    public void testconvertion_long_min() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("min_long", BigInteger.valueOf(Long.MIN_VALUE).subtract(BigInteger.valueOf(100L)));

        try {
            jsonObject.get("min_long").getAsLong();
            fail();
        } catch (NumberFormatException expected) {
        }

    }
}
