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
 * @author gmcallister
 *
 */
public enum PropertyOptions {
    READ_WRITE,
    CAN_DELETE,
    CAN_ENNUMERATE;
    
    public static final EnumSet<PropertyOptions> DEFAULT_OPTIONS = 
            EnumSet.of(READ_WRITE, CAN_DELETE, CAN_ENNUMERATE);
}