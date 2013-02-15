/*
 * Copyright 2002-2013 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.data.examples.quizzo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.util.Assert;

/**
 * @author David Turanski
 *
 */
public class Quiz {
	private final String id;
	private final String title;
	private List<MultipleChoiceQuestion> questions;

	@PersistenceConstructor
	public Quiz(String id, String title,List<MultipleChoiceQuestion> questions) {
		Assert.notNull(questions, "questions list cannot be null");
		Assert.notNull(id,"id cannot be null or blank");
		this.id = id;
		this.title = title;
		this.questions = questions;
	}
	
	public Quiz(String id, String title) {
		this(id,title,new ArrayList<MultipleChoiceQuestion>());
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the questions
	 */
	public List<MultipleChoiceQuestion> getQuestions() {
		return questions;
	}
	
	public void addQuestion(MultipleChoiceQuestion question) {
		Assert.notNull(question, "question cannot be null");
		this.questions.add(question);
	}

}
