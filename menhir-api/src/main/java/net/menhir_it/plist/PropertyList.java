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

import java.util.Iterator;


/**
 * Unordered list of Property instances; acts more like a dictionary than
 * a list, but the standard nomenclature for this sturcture is a 'plist'. 
 * 
 * Note that this is *not* an implementation of the OSX plist format.
 * 
 * @author gmcallister
 *
 */
public interface PropertyList {
    public void add(String key, boolean value);
    public void add(String key, int value);
    public void add(String key, long value);
    public void add(String key, float value);
    public void add(String key, double value);
    public void add(String key, String value);
    public void add(String key, Property<?> value);
    public Property<?> get(String key);
    public Iterator<Property<?>> iterator();
    public Property<?> remove(String key);
}
