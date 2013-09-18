package net.menhir_it.plist;

import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static com.yammer.dropwizard.testing.JsonHelpers.jsonFixture;
import static com.yammer.dropwizard.testing.JsonHelpers.fromJson;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

public class PropertySerializationTest {
    
    @Test
    public final void intPropertyProducesTheExpectedJson() throws Exception {
        Property<Integer> p1 = new Property<>("key1", 100, Integer.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/intProperty.json"));
    }
    
    @Test
    public final void intPropertyConsumesTheExpectedJson() throws Exception {
        Property<Integer> p1 = new Property<>("key1", 100, Integer.class);
        TypeReference<Property<Integer>> ref = new TypeReference<Property<Integer>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/intProperty.json"), ref));
    }
    
    @Test
    public final void longPropertyProducesTheExpectedJson() throws Exception {
        Property<Long> p1 = new Property<>("key1", 100L, Long.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/longProperty.json"));
    }
    
    @Test
    public final void longPropertyConsumesTheExpectedJson() throws Exception {
        Property<Long> p1 = new Property<>("key1", 100L, Long.class);
        TypeReference<Property<Long>> ref = new TypeReference<Property<Long>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/longProperty.json"), ref));
    }

    @Test
    public final void boolPropertyProducesTheExpectedJson() throws Exception {
        Property<Boolean> p1 = new Property<>("key1", true, Boolean.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/boolProperty.json"));
    }
    
    @Test
    public final void boolPropertyConsumesTheExpectedJson() throws Exception {
        Property<Boolean> p1 = new Property<>("key1", true, Boolean.class);
        TypeReference<Property<Boolean>> ref = new TypeReference<Property<Boolean>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/boolProperty.json"), ref));
    }
    
    @Test
    public final void stringPropertyProducesTheExpectedJson() throws Exception {
        Property<String> p1 = new Property<>("key1", "yadda", String.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/stringProperty.json"));
    }
    
    @Test
    public final void stringPropertyConsumesTheExpectedJson() throws Exception {
        Property<String> p1 = new Property<>("key1", "yadda", String.class);
        TypeReference<Property<String>> ref = new TypeReference<Property<String>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/stringProperty.json"), ref));
    }
    
    @Test
    public final void floatPropertyProducesTheExpectedJson() throws Exception {
        Property<Float> p1 = new Property<>("key1", 10.0f, Float.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/floatProperty.json"));
    }
    
    @Test
    public final void floatPropertyConsumesTheExpectedJson() throws Exception {
        Property<Float> p1 = new Property<>("key1", 10.0f, Float.class);
        TypeReference<Property<Float>> ref = new TypeReference<Property<Float>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/floatProperty.json"), ref));
    }
    
    @Test
    public final void doublePropertyProducesTheExpectedJson() throws Exception {
        Property<Double> p1 = new Property<>("key1", 10.0d, Double.class);
        
        assertThat(asJson(p1)).isEqualTo(jsonFixture("fixtures/doubleProperty.json"));
    }
    
    @Test
    public final void doublePropertyConsumesTheExpectedJson() throws Exception {
        Property<Double> p1 = new Property<>("key1", 10.0d, Double.class);
        TypeReference<Property<Double>> ref = new TypeReference<Property<Double>>() {};
        
        assertThat(p1).isEqualTo(fromJson(jsonFixture("fixtures/doubleProperty.json"), ref));
    }
}
