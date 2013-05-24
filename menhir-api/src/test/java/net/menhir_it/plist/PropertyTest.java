package net.menhir_it.plist;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.EnumSet;

import org.junit.Test;

public class PropertyTest {

    @Test
    public void testGetKey() {
        Property<Integer> pint = new Property<>("key", 1);
        assertThat(pint.getKey(), is("key"));
    }

    @Test
    public void testGetValue() {
        Property<String> pstr = new Property<>("key", "yadda");
        assertThat(pstr.getValue(), is("yadda"));
    }

    @Test
    public void testSetValue() {
        Property<Long> plong = new Property<>("key", 10L);
        plong.setValue(Long.MAX_VALUE);
        
        assertThat(plong.getValue(), is(Long.MAX_VALUE));
    }

    @Test
    public void testGetPropertyOptions() {
        final EnumSet<PropertyOptions> expected = EnumSet.allOf(PropertyOptions.class);
        Property<Integer> pint = new Property<>("key", 1);
        
        final EnumSet<PropertyOptions> actual = pint.getPropertyOptions();
        
        assertThat(actual, is(expected));
    }

    @Test(expected=NullPointerException.class)
    public void testKeyCannotBeNull() {
        new Property<>(null, 10L);
    }
    
    @Test(expected=NullPointerException.class)
    public void testPropertyOptionsCannotBeNull() {
        new Property<>("key", 10, null);
    }
    
    @Test
    public void testReadOnlyProperty() {
        Property<Integer> pint = new Property<>("key", 1, EnumSet.of(PropertyOptions.CAN_DELETE));
        pint.setValue(100);
        
        assertThat(pint.getValue(), is(1));
    }
}
