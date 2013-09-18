package net.menhir_it.plist;

import static net.menhir_it.plist.PropertyAssert.assertThat;

import java.util.EnumSet;

import org.junit.Test;

public class PropertyTest {
    private static final PropertyOptions DEFAULT_PROPERTY_OPTIONS[] = {
        PropertyOptions.CAN_DELETE,
        PropertyOptions.CAN_ENUMERATE,
        PropertyOptions.CAN_WRITE
    };

    @Test
    public void testGetKey() {
        Property<Integer> pint = new Property<>("key", 1, Integer.class);
        
        assertThat(pint).hasKey("key")
            .hasValue(1)
            .hasValueType(Integer.class)
            .hasPropertyOptions(DEFAULT_PROPERTY_OPTIONS);
    }

    @Test
    public void testGetValue() {
        Property<String> pstr = new Property<>("key", "yadda", String.class);
        
        assertThat(pstr).hasKey("key")
            .hasValue("yadda")
            .hasValueType(String.class)
            .hasPropertyOptions(DEFAULT_PROPERTY_OPTIONS);
    }

    @Test
    public void testSetValue() {
        Property<Long> plong = new Property<>("key", 10L, Long.class);
        plong.setValue(Long.MAX_VALUE);
        
        assertThat(plong).hasKey("key")
            .hasValue(Long.MAX_VALUE)
            .hasValueType(Long.class)
            .hasPropertyOptions(DEFAULT_PROPERTY_OPTIONS);
    }

    
    @Test(expected=NullPointerException.class)
    public void testKeyCannotBeNull() {
        new Property<Long>(null, 10L, Long.class);
    }
    
    @Test(expected=NullPointerException.class)
    public void testPropertyOptionsCannotBeNull() {
        new Property<>("key", 10, Integer.class, null);
    }
    
    @Test
    public void testReadOnlyProperty() {
        Property<Integer> pint = new Property<>("key", 1, Integer.class, EnumSet.of(PropertyOptions.CAN_DELETE));
        pint.setValue(100);
        
        assertThat(pint).hasValue(1).hasPropertyOptions(PropertyOptions.CAN_DELETE);
    }
}
