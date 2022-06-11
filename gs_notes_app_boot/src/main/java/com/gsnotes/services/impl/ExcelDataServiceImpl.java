package com.gsnotes.services.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.Enseignant;
import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.services.IElementInscriptionService;
import com.gsnotes.services.IExcelDataService;
import com.gsnotes.utils.export.ExcelHandlerException;
import com.gsnotes.web.models.InfoFileModel;

@Service
@Transactional
public class ExcelDataServiceImpl implements IExcelDataService{
	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	ElementInscriptionServiceImpl ele;
	
	@Override
	public List<ArrayList<Object>> getExcelDataAsList(String pFileName, int pSheet) throws IOException, ExcelHandlerException {
		
		List<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

		try {
			try {
				Workbook workbook = null;
				try {
					FileInputStream excelFile = new FileInputStream(new File(pFileName));
					workbook = new XSSFWorkbook(excelFile);
					Sheet datatypeSheet = workbook.getSheetAt(pSheet);
					Iterator<Row> iterator = datatypeSheet.iterator();

					while (iterator.hasNext()) {

						ArrayList<Object> rowValues = new ArrayList<Object>();

						Row currentRow = iterator.next();
						Iterator<Cell> cellIterator = currentRow.iterator();

						while (cellIterator.hasNext()) {

							Cell currentCell = cellIterator.next();

							if (currentCell.getCellType() == CellType.STRING) {

								rowValues.add(currentCell.getStringCellValue());

							} else if (currentCell.getCellType() == CellType.NUMERIC) {
								rowValues.add(currentCell.getNumericCellValue());
							}

						}

						data.add(rowValues);

					}
				} finally {
					if (workbook != null) {
						workbook.close();
					}
				}
			} catch (Exception ex) {
				throw new ExcelHandlerException("Error while importing an excel file", ex);
			}
		} catch (ExcelHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
    @Override
	public boolean removeFile(String filePath) throws IOException {
		File file = new File(filePath);
		return file.delete();
	}
	@Override
	public void saveExcelData(List<ArrayList<Object>> tab) {

		for(int i=3;i<tab.size();i++) {
			InscriptionMatiere im=new InscriptionMatiere();
			if(tab.get(1).get(3).equals("Normale")) {
			
				im.setNoteSN(i);
			}
            ele.addElement(im);			
		}
	}

}
