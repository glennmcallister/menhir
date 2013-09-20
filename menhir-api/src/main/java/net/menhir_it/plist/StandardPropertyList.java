/**
 *  Copyright 2013 Glenn McAllister
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */

package net.menhir_it.plist;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;


/**
 * Simple implementation of a PropertyList.
 * 
 * @author gmcallister
 *
 */
public class StandardPropertyList implements PropertyList, Iterable<Property<?>> {
    @JsonProperty("plist")
    private final Map<String, Property<?>> properties = new TreeMap<String, Property<?>>();

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, boolean)
     */
    @Override
    public void add(String key, boolean value) {
        Property<Boolean> pbool = new Property<>(key, value, Boolean.class);
        add(key, pbool);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, int)
     */
    @Override
    public void add(String key, int value) {
        Property<Integer> pint = new Property<>(key, value, Integer.class);
        add(key, pint);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, long)
     */
    @Override
    public void add(String key, long value) {
        Property<Long> plong = new Property<>(key, value, Long.class);
        add(key, plong);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, float)
     */
    @Override
    public void add(String key, float value) {
        Property<Float> pflt = new Property<>(key, value, Float.class);
        add(key, pflt);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, double)
     */
    @Override
    public void add(String key, double value) {
        Property<Double> pdbl = new Property<>(key, value, Double.class);
        add(key, pdbl);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, java.lang.String)
     */
    @Override
    public void add(String key, String value) {
        Property<String> pstr = new Property<>(key, value, String.class);
        add(key, pstr);
    }

    /* (non-Javadoc)
     * @see net.menhir_it.plist.PropertyList#add(java.lang.String, net.menhir_it.plist.Property)
     */
    @Override
    public void add(String key, Property<?> value) {
        checkNotNull(key);
        checkNotNull(value);
        
        properties.put(key, value);
    }

    @Override
    public Property<? extends Object> get(String key) {
        return properties.get(key);
    }

    @Override
    public Iterator<Property<?>> iterator() {
        return Iterators.filter(properties.values().iterator(),
                new Predicate<Property<?>>() {

                    @Override
                    public boolean apply(@Nullable Property<?> input) {
                        return input.getPropertyOptions().contains(PropertyOptions.CAN_ENUMERATE);
                    }
                });
    }

    @Override
    public Property<?> remove(String key) {
        Property<?> candidate = properties.get(key);
        
        if (candidate != null &&
            candidate.getPropertyOptions().contains(PropertyOptions.CAN_DELETE)) {
            return properties.remove(key);
        }
        
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(properties);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StandardPropertyList other = (StandardPropertyList) obj;
        
        return Objects.equal(properties, other.properties);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(StandardPropertyList.class)
                .add("properties", properties)
                .toString();
    }
}
