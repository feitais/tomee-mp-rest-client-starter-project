/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.superbiz.rest;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class MovieResourceTest {

    @Deployment()
    public static WebArchive createDeployment() {
        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(ApplicationConfig.class.getPackage())
                .addAsWebInfResource(new StringAsset("<beans/>"), "beans.xml")
                .addAsResource("META-INF/microprofile-config.properties");
        return webArchive;
    }


    //Injection point MP Rest Client
    @Inject
    @RestClient
    private MovieResourceClient mpClient;

    @Test()
    public void testServerStatus() {
        assertTrue(mpClient.status().equalsIgnoreCase("ok"));
    }

    @Test
    public void tesMovieResource() {

        //POST
        mpClient.addMovie(new Movie(1, "TomEE MicroProfile Adventures"));
        mpClient.addMovie(new Movie(2, "Top 10 Tomee Configuraiton Tips"));

        //GET
        assertTrue(mpClient.getListOfMovies().size() == 2);
        assertTrue(mpClient.getMovie(1).getName().equalsIgnoreCase("TomEE MicroProfile Adventures"));

        //DELETE
        mpClient.deleteMovie(1);
        assertTrue(mpClient.getListOfMovies().size() == 1);
        assertTrue(mpClient.getMovie(2).getName().equalsIgnoreCase("Top 10 Tomee Configuraiton Tips"));

        //UPDATE
        mpClient.updateMovie(new Movie(2, "Top 3 Tomee Configuraiton Tips"));
        assertTrue(mpClient.getListOfMovies().size() == 1);
        assertTrue(mpClient.getMovie(2).getName().equalsIgnoreCase("Top 3 Tomee Configuraiton Tips"));
    }

}
