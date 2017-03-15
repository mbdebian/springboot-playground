package com.google.mbdebian.springboot.playground;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootPlaytestApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringbootPlaytestApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctxt = SpringApplication.run(SpringbootPlaytestApplication.class, args);

		logger.info("Hello Spring World!");
		logger.info("Getting instance of MapDB");

		DB db = DBMaker.memoryDB()
				.closeOnJvmShutdown()
				.make();

		HTreeMap<Integer, String> map = db.hashMap("enteros")
				.keySerializer(Serializer.INTEGER)
				.valueSerializer(Serializer.STRING)
				.create();

		logger.info("Rellenando el mapa de MapDB");
		new Random().ints(1000, 1, 2000).parallel().forEach(value -> map.put(value, new Integer(value).toString()));
		logger.info(map.size() + " random numbers stored in MapDB HashMap");
		logger.info("["
		+ map.entrySet()
		.stream()
		.map(entry -> "(" + Integer.toString(((Map.Entry<Integer, String>) entry).getKey()) + "," + ((Map.Entry<Integer, String>) entry).getValue() + ")")
		.collect(Collectors.joining(","))
		+ "]");
	}
}
