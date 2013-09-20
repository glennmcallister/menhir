package net.menhir_it.plist;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumSet;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

public class IterableStandardPropertyListTest {
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
        
        assertThat(p1.getKey()).isEqualTo("key1");
        assertThat(p1.getValue()).isEqualTo(1);
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
