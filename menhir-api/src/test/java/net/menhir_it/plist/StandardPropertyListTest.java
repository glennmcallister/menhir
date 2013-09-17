package net.menhir_it.plist;

import static net.menhir_it.plist.PropertyAssert.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class StandardPropertyListTest {
    private PropertyList plist;
    
    @Before
    public final void setUp() {
        plist = new StandardPropertyList();
    }
    
    @After
    public final void tearDown() {
        plist = null;
    }

    @Test
    public final void testAddStringBoolean() {        
        plist.add("key1", true);
        Property<?> v1 = plist.get("key1");
        
        assertThat(v1).hasKey("key1").hasValue(true);
    }

    @Test
    public final void testAddStringInt() {
        plist.add("keyInt", 10);
        Property<?> p1 = plist.get("keyInt");
        
        assertThat(p1).hasKey("keyInt").hasValue(10);
    }
    
    @Test
    public final void testAddStringLong() {
        plist.add("keyLong", 100L);
        Property<?> p1 = plist.get("keyLong");
        
        assertThat(p1).hasKey("keyLong").hasValue(100L);
    }
    
    @Test
    public final void testAddStringFloat() {
        plist.add("keyFloat", 1.0F);
        Property<?> p1 = plist.get("keyFloat");
        
        assertThat(p1).hasKey("keyFloat").hasValue(1.0F);
    }
    
    @Test
    public final void testAddStringDouble() {
        plist.add("keyDouble", 1.0d);
        Property<?> p1 = plist.get("keyDouble");
        
        assertThat(p1).hasKey("keyDouble").hasValue(1.0d);
    }
    
    @Test
    public final void testAddStringString() {
        plist.add("keyString", "blah");
        Property<?> p1 = plist.get("keyString");
        
        assertThat(p1).hasKey("keyString").hasValue("blah");
    }
    
    @Test
    public final void testAddProperty() {
        Property<Integer> pint = new Property<>("key", 100, Integer.class);
        plist.add("key", pint);
        
        final Property<?> p = plist.get("key");
        
        assertThat(p).hasKey("key").hasValue(100).hasValueType(Integer.class);
    }
}
