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

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class MovieBean {

    private HashMap<Integer, Movie> movieCatalog;


    @PostConstruct
    public void movieBean() {
        movieCatalog = new HashMap();
    }

    public void addMovie(Movie newMovie) {
        movieCatalog.put(newMovie.getId(), newMovie);
    }

    public void deleteMovie(int id) {
        movieCatalog.remove(id);
    }

    public void updateMovie(Movie updatedMovie) {
        movieCatalog.put(updatedMovie.getId(), updatedMovie);
    }

    public Movie getMovie(int id) {
        return movieCatalog.get(id);
    }

    public List getMovies() {
        Collection<Movie> movies = movieCatalog.values();
        return new ArrayList<Movie>(movies);

    }

}
