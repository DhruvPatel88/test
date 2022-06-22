package com.springhow.examples.springboot.pdfdemo.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.springhow.examples.springboot.pdfdemo.OrderHelper;
import com.springhow.examples.springboot.pdfdemo.pojo.BillData;
import com.springhow.examples.springboot.pdfdemo.pojo.Order;
import com.springhow.examples.springboot.pdfdemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/orders")
public class PDFController {

	@Autowired
	ServletContext servletContext;

	private final TemplateEngine templateEngine;
	private EmailService emailService;

	public PDFController(TemplateEngine templateEngine, EmailService emailService) {
		this.templateEngine = templateEngine;
		this.emailService = emailService;
	}

	/*
	 * @RequestMapping(path = "/") public String getOrderPage(Model model) { Order
	 * order = OrderHelper.getOrder(); model.addAttribute("orderEntry", order);
	 * return "order"; }
	 */

	@RequestMapping(path = "/")
	public String getOrderPage(Model model) {
		// Order order = OrderHelper.getOrder();

		List<BillData> list = new ArrayList<>();
		BillData billData = new BillData("dhruv", "21515", "15484", "2/5/2000", "5154541", "kahsiahshasuag8 jiaSUI",
				"hsiugyu nmgashga", "565656", "bnkjkjl", "sasassa", "aasassas", "assasass", "adsaSASDAS");
		model.addAttribute("bill", billData);
		return "kishan";
	}

	/*
	 * @RequestMapping(path = "/pdf") public ResponseEntity<?>
	 * getPDF(HttpServletRequest request, HttpServletResponse response) throws
	 * IOException {
	 * 
	 * Do Business Logic
	 * 
	 * Order order = OrderHelper.getOrder();
	 * 
	 * Create HTML using Thymeleaf template Engine
	 * 
	 * WebContext context = new WebContext(request, response, servletContext);
	 * context.setVariable("orderEntry", order); String orderHtml =
	 * templateEngine.process("order", context);
	 * 
	 * Setup Source and target I/O streams
	 * 
	 * ByteArrayOutputStream target = new ByteArrayOutputStream();
	 * ConverterProperties converterProperties = new ConverterProperties();
	 * converterProperties.setBaseUri("http://localhost:8080"); Call convert method
	 * HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
	 * 
	 * extract output as bytes byte[] bytes = target.toByteArray();
	 * 
	 * 
	 * Send the response as downloadable PDF
	 * 
	 * return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=order.pdf") .contentType(MediaType.APPLICATION_PDF)
	 * .body(bytes);
	 * 
	 * }
	 */

	@RequestMapping(path = "/pdf")
	public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

		BillData billData = new BillData("kishan", "21515", "15484", "2/5/2000", "5154541", "kahsiahshasuag8 jiaSUI",
				"hsiugyu nmgashga", "565656", "bnkjkjl", "sasassa", "aasassas", "assasass", "adsaSASDAS");
		WebContext context = new WebContext(request, response, servletContext);
		context.setVariable("bill", billData);
		String billHTML = templateEngine.process("kishan", context);
		ByteArrayOutputStream target = new ByteArrayOutputStream();
		ConverterProperties converterProperties = new ConverterProperties();
		converterProperties.setBaseUri("http://localhost:8080");
		HtmlConverter.convertToPdf(billHTML, target, converterProperties);
		byte[] bytes = target.toByteArray();
		try (FileOutputStream fos = new FileOutputStream("bill.pdf")) {
			fos.write(bytes);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		emailService.sendMailWithAttachment("kishan.davda333@gmail.com","sdsd","sdsd","bill.pdf");
		/* Send the response as downloadable PDF */
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=bill.pdf")
				.contentType(MediaType.APPLICATION_PDF).body(bytes);

	}

	/*@RequestMapping(path = "/formate", method = RequestMethod.GET)
	public void getNumber(@RequestParam("amount") float amount) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
		System.out.println(formatter.format(amount));
		//return formatter.format(amount);
	}*/

}
