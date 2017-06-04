package com.google.mbdebian.springboot.playground.microservices.hacking.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HackpersistenceApplication {

	@Autowired
	private WordMemory wordMemory;

	@RequestMapping("/add")
	public String addWord(@RequestParam(value = "word", defaultValue = "defaultWord") String word) {
		wordMemory.addWord(word);
		return String.format("Word '%s' added to the list of words (%d words now on the list)", word, wordMemory.getWords().size());
	}

	@RequestMapping("/get_words")
	public String getWords() {
		return wordMemory.getWords().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(HackpersistenceApplication.class, args);
	}
}
