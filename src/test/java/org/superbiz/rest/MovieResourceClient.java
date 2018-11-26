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


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.Dependent;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//@Dependent
@RegisterRestClient
@Path("/test/api/catalog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MovieResourceClient {

    @GET
    String status();

    @POST
    @Path("/movies")
    void addMovie(Movie newMovie);

    @DELETE
    @Path("/movies/{id}")
    void deleteMovie(@PathParam("id") int id);

    @PUT
    @Path("/movies")
    void updateMovie(Movie updatedMovie);

    @GET
    @Path("/movies/{id}")
    Movie getMovie(@PathParam("id") int id);

    @GET
    @Path("/movies")
    List<Movie> getListOfMovies();

}
