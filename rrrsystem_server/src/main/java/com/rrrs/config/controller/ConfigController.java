package com.rrrs.config.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rrrs.config.model.MapInfo;
import com.rrrs.config.service.JdbcConfigService;
import com.rrrs.util.ConfigUtils;

@RestController
@RequestMapping(value = "/api/config")
public class ConfigController {

	private Logger LOGGER = LoggerFactory.getLogger(ConfigController.class);
	@Value("${config.dir}")
	private String configDirectory;
	private JdbcConfigService jdbcConfigService;

	@Autowired
	public ConfigController(JdbcConfigService jdbcConfigService) {
		this.jdbcConfigService = jdbcConfigService;
	}

	@PostMapping(value = {"/excel"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getExcelCols(@RequestBody MultipartFile file){
		List<MapInfo> map = new ArrayList<>();
		StringBuilder directoryBuilder =  new StringBuilder(configDirectory) .append( File.separator).append(ConfigUtils.currentDateString());
		StringBuilder fileDirectory = new StringBuilder(directoryBuilder);

		
		
		System.out.println("file-name="+file.getOriginalFilename());
		
		return null;
		//return new ResponseEntity<>();
	}
	/*
	 * @GetMapping("/download/{formatId}") public String
	 * downloadFormatDtls(@PathVariable(name = "formatId") int formatId) throws
	 * IOException { //creating path object
	 * 
	 * //FormatDtls=jdbcConfigService.downloadFormatDtls(formatId); Path
	 * path=Paths.get("F:\\ExcelDataDownload\\exampleData.xlsx"); Workbook
	 * workbook=new SXSSFWorkbook(); SXSSFSheet
	 * sheet=(SXSSFSheet)workbook.createSheet("Example-1"); for(int i=0;i<10;i++) {
	 * Row row=sheet.createRow(i); for(int j=0;j<5;j++) { Cell
	 * cell=row.createCell(j); cell.setCellValue("column-"+j); } } FileOutputStream
	 * out = new FileOutputStream(path.toFile()); workbook.write(out); out.close();
	 * workbook.close();
	 * 
	 * 
	 * Session session = entityManager.unwrap(Session.class); String
	 * query="from RRR_MODULE_LIST"; Query createQuery = session.createQuery(query);
	 * List<Integer> data= createQuery.list();
	 * System.out.println("total count--"+data); return new
	 * ResponseEntity<>(data,HttpStatus.OK);
	 * 
	 * return "Done !!!"; }
	 */

}
