package testDataPackage


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CustomTestDataKeywords {


	@Keyword
	def int findRowByIdAndIndex(String strDataFileName, String strCaseId, String strIndex) {

		int intRowIndex = -1
		int intNumberOfRows = findTestData(strDataFileName).getRowNumbers()

		for(def iRow : 1..intNumberOfRows){
			String strCombinedTestCase = strCaseId + '-' + strIndex;
			String strActualTestCaseId = findTestData(strDataFileName).getValue(1, iRow)

			if(strCombinedTestCase.equalsIgnoreCase(strActualTestCaseId)) {
				intRowIndex = iRow;
				println "Located Test Case Id: "+ strCaseId  +" @ Row: " + intRowIndex;
				break;
			}
		}
		return intRowIndex
	}

	@Keyword
	def  retrieveRowByIdAndIndex(String strDataFileName, String strCaseId, String strIndex) {

		String strDataFilePath = strDataFileName;
		int intRowIndex = findRowByIdAndIndex(strDataFilePath, strCaseId, strIndex);
		String[] Columnnames=findTestData(strDataFilePath).getColumnNames();
		HashMap<String, String> hash_map = new HashMap<String, String>();
		for(String str in Columnnames) {
			if(str != null && !str.equalsIgnoreCase("TestCaseId") ) {
				hash_map.put(str, findTestData(strDataFilePath).getValue(str, intRowIndex))
			}
		}
		return hash_map;
	}
}
