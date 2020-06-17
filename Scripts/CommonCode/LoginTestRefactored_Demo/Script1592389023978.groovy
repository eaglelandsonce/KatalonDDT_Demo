import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


def hash_map = CustomKeywords.'testDataPackage.CustomTestDataKeywords.retrieveRowByIdAndIndex'(DataFile, TestCaseId, strIndex)

if ((hash_map.get('usn') != null) && (hash_map.get('usn').length() > 0)) {
	
	WebUI.setText(findTestObject('Page_CURA Healthcare Service/input_Username_username'), hash_map.get('usn'))
	
	}

if ((hash_map.get('pwd') != null) && (hash_map.get('pwd').length() > 0)) {
	
	WebUI.setEncryptedText(findTestObject('Page_CURA Healthcare Service/input_Password_password'), hash_map.get('pwd'))
	
	}

Thread.sleep(3000)
