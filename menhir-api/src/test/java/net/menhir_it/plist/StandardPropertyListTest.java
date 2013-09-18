package net.menhir_it.plist;

import static net.menhir_it.plist.PropertyAssert.assertThat;
import static org.assertj.core.api.Assertions.*;

import java.util.EnumSet;

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
    
    @Test
    public final void testIterateProperty() {
        plist.add("key1", 1);
        plist.add("key2", 2);
        
        Property<Integer> p1 = new Property<>("key1", 1, Integer.class);
        Property<Integer> p2 = new Property<>("key2", 2, Integer.class);
        
        assertThat(plist.iterator())
            .hasSize(2)
            .containsOnly(p1, p2);
    }
    
    @Test
    public final void testEmptyIterator() {
        assertThat(plist.iterator())
            .isEmpty();
    }
    
    @Test
    public final void testDoNotIterateProperty() {
        Property<Integer> p1 = new Property<>("key1", 1, Integer.class, 
                EnumSet.of(PropertyOptions.CAN_DELETE, PropertyOptions.CAN_WRITE));
        Property<Integer> p2 = new Property<>("key2", 2, Integer.class);
        
        plist.add(p1.getKey(), p1);
        plist.add(p2.getKey(), p2);
        
        assertThat(plist.iterator())
            .hasSize(1)
            .containsOnly(p2);
    }
    
    @Test
    public final void testCanDeleteProperty() {
        plist.add("key1", 1);
        plist.add("key2", 2);
        
        Property<?> p1 = plist.remove("key1");
        
        assertThat(plist.iterator())
            .hasSize(1)
            .containsOnly(new Property<>("key2", 2, Integer.class));
        
        assertThat(p1).hasKey("key1").hasValue(1);
    }
    
    @Test
    public final void testCannotDeleteProperty() {
        Property<Integer> p1 = new Property<>("key1", 1, Integer.class, 
                EnumSet.of(PropertyOptions.CAN_ENUMERATE));
        Property<Integer> p2 = new Property<>("key2", 2, Integer.class);
        
        plist.add(p1.getKey(), p1);
        plist.add(p2.getKey(), p2);
        
        Property<?> removed = plist.remove("key1");
        
        assertThat(plist.iterator())
            .hasSize(2)
            .containsOnly(p1, p2);
        
        assertThat(removed).isNull();
    }
}
