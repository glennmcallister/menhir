package net.menhir_it.plist;

import static io.dropwizard.testing.FixtureHelpers.*;
import io.dropwizard.jackson.Jackson;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PropertySerializationTest {
    
    private ObjectMapper mapper;
    
    @Before
    public final void setup() {
        mapper = Jackson.newObjectMapper();
    }
    
    @Test
    public final void intPropertyProducesTheExpectedJson() throws Exception {
        Property<Integer> p1 = new Property<>("key1", 100, Integer.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/intProperty.json"), JsonNode.class)
                        );
        
        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
        
    @Test
    public final void intPropertyConsumesTheExpectedJson() throws Exception {
        Property<Integer> p1 = new Property<>("key1", 100, Integer.class);
        TypeReference<Property<Integer>> ref = new TypeReference<Property<Integer>>() {};
        
        Property<Integer> fromJson = mapper.readValue(fixture("fixtures/intProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);
    }
    
    @Test
    public final void longPropertyProducesTheExpectedJson() throws Exception {
        Property<Long> p1 = new Property<>("key1", 100L, Long.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/longProperty.json"), JsonNode.class)
                        );
        
        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
    
    @Test
    public final void longPropertyConsumesTheExpectedJson() throws Exception {
        Property<Long> p1 = new Property<>("key1", 100L, Long.class);
        TypeReference<Property<Long>> ref = new TypeReference<Property<Long>>() {};
        
        Property<Long> fromJson = mapper.readValue(fixture("fixtures/longProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);
    }

    @Test
    public final void boolPropertyProducesTheExpectedJson() throws Exception {
        Property<Boolean> p1 = new Property<>("key1", true, Boolean.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/boolProperty.json"), JsonNode.class)
                        );
        
        assertThat(jsonStr).isEqualTo(fixtureStr);
    }

    @Test
    public final void boolPropertyConsumesTheExpectedJson() throws Exception {
        Property<Boolean> p1 = new Property<>("key1", true, Boolean.class);
        TypeReference<Property<Boolean>> ref = new TypeReference<Property<Boolean>>() {};
        
        Property<Boolean> fromJson = mapper.readValue(fixture("fixtures/boolProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);
    }
    
    @Test
    public final void stringPropertyProducesTheExpectedJson() throws Exception {
        Property<String> p1 = new Property<>("key1", "yadda", String.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/stringProperty.json"), JsonNode.class)
                        );

        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
    
    @Test
    public final void stringPropertyConsumesTheExpectedJson() throws Exception {
        Property<String> p1 = new Property<>("key1", "yadda", String.class);
        TypeReference<Property<String>> ref = new TypeReference<Property<String>>() {};
        
        Property<String> fromJson = mapper.readValue(fixture("fixtures/stringProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);
    }
    
    @Test
    public final void floatPropertyProducesTheExpectedJson() throws Exception {
        Property<Float> p1 = new Property<>("key1", 10.0f, Float.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/floatProperty.json"), JsonNode.class)
                        );

        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
    
    @Test
    public final void floatPropertyConsumesTheExpectedJson() throws Exception {
        Property<Float> p1 = new Property<>("key1", 10.0f, Float.class);
        TypeReference<Property<Float>> ref = new TypeReference<Property<Float>>() {};
        
        Property<String> fromJson = mapper.readValue(fixture("fixtures/floatProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);
    }
    
    @Test
    public final void doublePropertyProducesTheExpectedJson() throws Exception {
        Property<Double> p1 = new Property<>("key1", 10.0d, Double.class);
        
        String jsonStr = mapper.writeValueAsString(p1);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/doubleProperty.json"), JsonNode.class)
                        );

        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
    
    @Test
    public final void doublePropertyConsumesTheExpectedJson() throws Exception {
        Property<Double> p1 = new Property<>("key1", 10.0d, Double.class);
        TypeReference<Property<Double>> ref = new TypeReference<Property<Double>>() {};
        
        Property<String> fromJson = mapper.readValue(fixture("fixtures/doubleProperty.json"), ref);
        
        assertThat(p1).isEqualTo(fromJson);    
    }
}
