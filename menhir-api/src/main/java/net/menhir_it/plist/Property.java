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

import static net.menhir_it.plist.PropertyOptions.*;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.EnumSet;

import com.google.common.base.Objects;

/**
 * A generic property type.
 * 
 * @author gmcallister
 *
 * @param <T>
 */
public class Property<T> {
    private final String key;
    private T value;
    private Class<T> valueType;
    private EnumSet<PropertyOptions> propertyOptions;
    
    public Property(String key, T value, Class<T> valueType, EnumSet<PropertyOptions> propertyOptions) {
        this.key = checkNotNull(key);
        this.value = value;
        this.valueType = valueType;
        this.propertyOptions = checkNotNull(propertyOptions);
    }
    
    public Property(String key, T value, Class<T> valueType) {
        this(key, value, valueType, DEFAULT_OPTIONS);
    }
    
    public String getKey() {
        return key;
    }
    
    public T getValue() {
        return value;
    }
    
    public void setValue(T value) {
        if (propertyOptions.contains(CAN_WRITE)) {
            this.value = value;
        }
    }
    
    public EnumSet<PropertyOptions> getPropertyOptions() {
        return propertyOptions.clone();
    }
    
    public Class<T> getValueType() {
        return valueType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(key, value, propertyOptions);
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
        Property<?> other = (Property<?>) obj;
        
        return Objects.equal(key, other.key)
                && Objects.equal(value, other.value)
                && Objects.equal(valueType, other.valueType)
                && Objects.equal(propertyOptions, other.propertyOptions);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("key", key)
                .add("value", value)
                .add("valueType", valueType)
                .add("options", propertyOptions)
                .toString();
    }
    
}
