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

import java.util.EnumSet;

/**
 * PropertyOptions describe how a Property can be used.
 * 
 * @author gmcallister
 *
 */
public enum PropertyOptions {
    /**
     * The {@code CAN_WRITE} option allows the value of a {@link Property} 
     * to be modified after it is created. Without this option, a Property is 
     * read-only.
     */
    CAN_WRITE,
    
    /**
     * The {@code CAN_DELETE} option allows a {@link Property} to be removed 
     * from a {@link PropertyList}. Without this option, once a Property has 
     * been added to a list, it cannot be removed from that list.
     */
    CAN_DELETE,
    
    /**
     * The {@code CAN_ENNUMERATE} option allows a {@link Property} that is 
     * part of a {@link PropertyList} to be enumerated. Without this option, if 
     * a Property is in a list, it will be skipped over in an iterator.
     */
    CAN_ENUMERATE;
    
    /**
     * This {@link EnumSet} provides the default set of options that a 
     * Property will have unless otherwise provided by the {@link Property}
     * creator.
     */
    public static final EnumSet<PropertyOptions> DEFAULT_OPTIONS = 
            EnumSet.of(CAN_WRITE, CAN_DELETE, CAN_ENUMERATE);
}
