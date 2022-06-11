package com.gsnotes.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gsnotes.utils.export.ExcelHandlerException;
import com.gsnotes.web.models.InfoFileModel;

public interface IExcelDataService {

    List<ArrayList<Object>> getExcelDataAsList(String pFileName,int pSheet) throws FileNotFoundException, IOException, ExcelHandlerException;
    boolean removeFile(String Path) throws IOException;
	void saveExcelData(List<ArrayList<Object>> list);
}
