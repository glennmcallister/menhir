package net.menhir_it.plist.ser;

import java.io.IOException;
import java.util.EnumSet;

import net.menhir_it.plist.Property;
import net.menhir_it.plist.PropertyOptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class PropertyDeserializer extends JsonDeserializer<Property<?>> {

    @Override
    public Property<?> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode object = mapper.readTree(jp);
        
        String key = object.get("key").asText();
        ArrayNode optionArray = object.withArray("options");
        EnumSet<PropertyOptions> options = EnumSet.noneOf(PropertyOptions.class);
        for(JsonNode optionNode : optionArray) {
            options.add(PropertyOptions.valueOf(optionNode.asText()));
        }
        
        Property<?> prop = null;
        
        // This is where life gets annoying...
        String clazz = object.get("type").asText();
        switch (clazz) {
            case "Integer" : {
                int val = object.get("value").asInt();
                prop = new Property<Integer>(key, val, Integer.class, options);
                break;
            }
            case "Long" : {
                long val = object.get("value").asLong();
                prop = new Property<Long>(key, val, Long.class, options);
                break;
            }
            case "Float" : {
                float val = object.get("value").floatValue();
                prop = new Property<Float>(key, val, Float.class, options);
                break;
            }
            case "Double" : {
                double val = object.get("value").asDouble();
                prop = new Property<Double>(key, val, Double.class, options);
                break;
            }
            case "Boolean" : {
                boolean val = object.get("value").asBoolean();
                prop = new Property<Boolean>(key, val, Boolean.class, options);
                break;
            }
            case "String" : {
                String val = object.get("value").asText();
                prop = new Property<String>(key, val, String.class, options);
                break;
            }
            default : {
                throw new JsonParseException("Unknown Property type " + clazz, jp.getCurrentLocation());
            }
        }
        
        return prop;
    }
}
