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

package net.menhir_it;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * The core Menhir service, which ties all the issue tracker capabilities
 * together.
 * 
 * @author gmcallister
 * 
 */
public class MenhirService extends Application<MenhirConfiguration> {

    public static void main(String[] args) throws Exception {
        new MenhirService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MenhirConfiguration> bootstrap) {
        // TODO Auto-generated method stub        
    }

    @Override
    public void run(MenhirConfiguration configuration, Environment environment)
            throws Exception {
        // TODO Auto-generated method stub
    }

}
