package com.grammer.frames;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.grammer.dao.PersonalDaoImpl;
import com.grammer.entity.Laptop;

public class LeerExcel {
	
	Laptop laptop = new Laptop();
	PersonalDaoImpl laptopDao = new PersonalDaoImpl();
	
	List<Laptop> laptopList = new ArrayList<Laptop>();

	public LeerExcel(File fileName) {
		List cellData = new ArrayList();
		try {
			FileInputStream fileInputStream = new FileInputStream( fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
			XSSFSheet hssfSheet = workBook.getSheetAt(0);
			Iterator rowIterator = hssfSheet.rowIterator();
			
			while (rowIterator.hasNext()) {
				XSSFRow hssfRow = (XSSFRow) rowIterator.next();
				Iterator iterator = hssfRow.cellIterator();
				List cellTemp = new ArrayList();
				
				while(iterator.hasNext()) {
					XSSFCell hssfCell = (XSSFCell) iterator.next();
					cellTemp.add(hssfCell);
				}
				cellData.add(cellTemp);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		obtener(cellData);
		
	}
	
	public void obtener(List cellDataList) {
		laptopList = new ArrayList<Laptop>();
		Laptop laptopAux = new Laptop();
		Laptop vacacionesAux = new Laptop();
		System.out.println("CellData = "+cellDataList.size());
		
		for (int i = 1 ; i< cellDataList.size(); i ++) {
			laptop = new Laptop(); 
			laptopAux = new Laptop();
			List cellTempList = (List) cellDataList.get(i);
			
			
			for (int j = 0;j< cellTempList.size();j++) {
				
				XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
				String stringCellValue = hssfCell.toString();
				System.out.println(stringCellValue+"");	
				
				if (j==0) {
					laptop.setIdLaptop("LAP"+Integer.parseInt(stringCellValue.replace(".0", ""))+"");
					laptop.setCantidad(Integer.parseInt(stringCellValue.replace(".0", "")));}
				if (j==1) {laptop.setUsuario(null != stringCellValue ? stringCellValue : "" );}
				if (j==2) {laptop.setArea(null != stringCellValue ? stringCellValue : "" );}
				if (j==3) {laptop.setLugar(null != stringCellValue ? stringCellValue : "" );}
				if (j==4) {laptop.setNombreEquipo(null != stringCellValue ? stringCellValue : "" );}
				if (j==5) {laptop.setNoSerie(null != stringCellValue ? stringCellValue : "" );}
				if (j==6) {laptop.setModelo(null != stringCellValue ? stringCellValue : "" );}
				if (j==7) {laptop.setMarca(null != stringCellValue ? stringCellValue : "" );}
				if (j==8) {laptop.setEquipo(null != stringCellValue ? stringCellValue : "" );}
				if (j==9) {laptop.setObservaciones(null != stringCellValue ? stringCellValue : "" );}
				
			}
			
			laptopAux=laptopDao.getAllPersonalById(laptop.getIdLaptop());
			
			System.out.println("Auxiliar"+laptopAux+"\n"+i);
			
			if (null != laptopAux) {
				laptop.setIdLaptop(laptopAux.getIdLaptop());
				laptopDao.actualizarPersonal(laptop);
			} else {
				laptopDao.crearPersonal(laptop);
			}
			
			System.out.println();
		}
	}
	
	public String mascaraQuantity(String qty) {

		if (qty.length() == 1){ qty = "0000000" + qty; }
		if (qty.length() == 2){ qty = "000000" + qty; }
		if (qty.length() == 3){ qty = "00000" + qty; }
		if (qty.length() == 4){ qty = "0000" + qty; }
		if (qty.length() == 5){ qty = "000" + qty; }
		if (qty.length() == 6){ qty = "00" + qty; }
		if (qty.length() == 7){ qty = "0" + qty; }
		
		return qty;
	}
}
