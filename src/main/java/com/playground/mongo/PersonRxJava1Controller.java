/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.playground.mongo;

import com.playground.Person;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sebastien Deleuze
 * @author Mark Paluch
 */
@Profile("mongo")
@RestController
public class PersonRxJava1Controller {

	private final PersonRxJava2CrudRepository repository;

	public PersonRxJava1Controller(PersonRxJava2CrudRepository repository) {
		this.repository = repository;
	}

	@PostMapping("/rxjava/mongo")
	Mono<Person> create(@RequestBody Person personStream) {
		return this.repository.save(personStream);
	}

	@GetMapping("/rxjava/mongo")
	Flux<Person> list() {
		return this.repository.findAll();
	}

	@GetMapping("/rxjava/mongo/{id}")
	Mono<Person> findById(@PathVariable String id) {
		return this.repository.findById(id);
	}

}
