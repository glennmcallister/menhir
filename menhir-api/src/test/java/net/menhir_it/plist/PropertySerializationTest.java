package net.menhir_it.plist;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;
import io.dropwizard.jackson.Jackson;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/intProperty.json"), Property.class);
        
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/longProperty.json"), Property.class);
        
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/boolProperty.json"), Property.class);
        
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/stringProperty.json"), Property.class);
        
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/floatProperty.json"), Property.class);
        
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
        Property<?> fromJson = mapper.readValue(fixture("fixtures/doubleProperty.json"), Property.class);
        
        assertThat(p1).isEqualTo(fromJson);    
    }
    
    @Test(expected=JsonParseException.class)
    public final void unsupportedTypeThrowsException() throws Exception {
        mapper.readValue(fixture("fixtures/badTypeProperty.json"), Property.class);
    }
    
}
