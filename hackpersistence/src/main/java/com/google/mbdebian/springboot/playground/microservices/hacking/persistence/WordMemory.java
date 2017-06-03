package com.google.mbdebian.springboot.playground.microservices.hacking.persistence;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Bernal Llinares
 *         Project: hackpersistence
 *         Package: com.google.mbdebian.springboot.playground.microservices.hacking.persistence
 *         Timestamp: 2017-06-03 9:17
 *         ---
 *         © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 *         All rights reserved.
 */
@Component
public class WordMemory {
    List<String> wordList = new ArrayList<>();

    public void addWord(String word) {
        wordList.add(word);
    }

    public List<String> getWords() {
        return wordList;
    }
}
