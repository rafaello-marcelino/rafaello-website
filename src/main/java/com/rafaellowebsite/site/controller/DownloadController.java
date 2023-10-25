package com.rafaellowebsite.site.controller;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/download")
public class DownloadController {
	private static final String RESUME_NAME = "Rafaello Marcelino - Software Developer.pdf";
	private static final Logger LOGGER = 
		    LoggerFactory.getLogger(DownloadController.class);
		 
	@Autowired
	private ResourceLoader resourceLoader;
		 
	@GetMapping
	public void downloadSampleCSV(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		LOGGER.info("Inside the download controller," +
		        " resource fileName =" + RESUME_NAME);
		Resource resource = resourceLoader
			.getResource("classpath:" + RESUME_NAME);
		if (resource.exists()) {
			LOGGER.info("Resource exists!");
			response.setContentType("text/csv");
			response.setHeader("Content-Disposition",
					String.format("attachment; filename=" +resource.getFilename()));
		   response.setContentLength((int) resource.contentLength());
		   InputStream inputStream = resource.getInputStream();
		   FileCopyUtils.copy(inputStream, response.getOutputStream());
		  }
		 }
}
