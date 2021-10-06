/**
 * 
 */
package com.jgsudhakar.spring.batch.itemreader;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.jgsudhakar.spring.batch.dto.StudentResponseDto;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File   : com.jgsudhakar.spring.batch.itemreader.StudentItemReader.java
 * @Date   : 2021-10-05
 */
@Log4j2
@Component
public class StudentItemReader implements ItemReader<StudentResponseDto>{
	
	List<StudentResponseDto> asList = Arrays.asList(new StudentResponseDto(1l, "Sudhakar", "735", "10"),
			new StudentResponseDto(2l, "Sailu", "736", "9"), new StudentResponseDto(3l, "Sanvi", "737", "1"),
			new StudentResponseDto(4l, "Sriyaan", "738", "UKG"));
	
	private AtomicInteger atomicInteger  = new AtomicInteger();

	@Override
	public StudentResponseDto read()throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info(":: Reading the Student Item Reader :: ");
		if (atomicInteger.get() < asList.size()) {
			return asList.get(atomicInteger.getAndIncrement());
		} 
		return null;
	}

}
