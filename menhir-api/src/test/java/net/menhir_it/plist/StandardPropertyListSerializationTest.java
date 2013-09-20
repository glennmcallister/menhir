package net.menhir_it.plist;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import io.dropwizard.jackson.Jackson;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StandardPropertyListSerializationTest {
    private ObjectMapper mapper;
    
    @Before
    public final void setup() {
        mapper = Jackson.newObjectMapper();
    }
    
    @Test
    public final void propertyListProducesTheExpectedJson() throws Exception {
        PropertyList plist = new StandardPropertyList();
        plist.add("keyBoolean", true);
        plist.add("keyDouble", 1.0d);
        plist.add("keyFloat", 1.0f);
        plist.add("keyInteger", 1);
        plist.add("keyLong", 1L);
        plist.add("keyString", "yadda");
        
        
        String jsonStr = mapper.writeValueAsString(plist);
        String fixtureStr = mapper.writeValueAsString(
                mapper.readValue(
                        fixture("fixtures/plist.json"), JsonNode.class)
                        );
         
        
        assertThat(jsonStr).isEqualTo(fixtureStr);
    }
    
    /*
    @Test
    public final void propertyListConsumesTheExpectedJson() throws Exception {
        StandardPropertyList plist = new StandardPropertyList();
        plist.add("keyBoolean", true);
        plist.add("keyDouble", 1.0d);
        plist.add("keyFloat", 1.0f);
        plist.add("keyInteger", 1);
        plist.add("keyLong", 1L);
        plist.add("keyString", "yadda");
        
        StandardPropertyList fromJsonList = fromJson(jsonFixture("fixtures/plist.json"), 
                StandardPropertyList.class);
        
        String plistStr = plist.toString();
        String fromJsonListStr = fromJsonList.toString();
        
        assertThat(fromJsonList).containsAll(plist);
        //assertThat(plistStr).isEqualTo(fromJsonListStr);                            
    }
    */

}
