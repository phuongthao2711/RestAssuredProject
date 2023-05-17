package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    String path = System.getProperty("user.dir") + "//testData//userData.xlsx";

    @DataProvider(name = "data")
    public Object[][] getAllData() throws IOException {
//        XLUtility xl = new XLUtility(path);
//        int rowNum = xl.getRowCount("Sheet1");
//        int colNum = xl.getCellCount("Sheet1", 1);
//        String APIData[][] = new String[rowNum][colNum];
//        for (int i = 1; i <= rowNum; i++) {
//            for (int j = 0; j <= colNum; j++) {
//                APIData[i-1][j] = xl.getCellData("Sheet1", i, j);
//            }
//        }

        ExcelHelper excel = new ExcelHelper();
        Object APIData[][] = excel.getTestData("Sheet1", path);

        return APIData;
    }

    @DataProvider(name = "userNames")
    public Object[] getUserNames() throws IOException {
        XLUtility xl = new XLUtility(path);
        int rowNum = xl.getRowCount("Sheet1");

        String APIData[] = new String[rowNum];

        for (int i = 1; i <= rowNum; i++) {
                APIData[i-1] = xl.getCellData("Sheet1", i, 1);

        }
        return APIData;
    }
}
