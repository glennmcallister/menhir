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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Simple implementation of a PropertyList.
 * 
 * @author gmcallister
 *
 */
public class StandardPropertyList implements PropertyList {
    private Map<String, Property<? extends Object>> properties = new LinkedHashMap<>();

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

}
