package Config;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDataSet {
    @DataProvider(name = "Registrationdata")
    public Object[][] getCSVData() throws IOException {
        List<Object[]> data=new ArrayList<>();
        CSVParser csvParser=new CSVParser(new FileReader("./src/test/resources/users.csv"), CSVFormat.DEFAULT.withFirstRecordAsHeader());
        for(CSVRecord user:csvParser)
        {
            String firstName=user.get("firstName");
            String lastName=user.get("lastName");
            String email= user.get("email");
            String password= user.get("password");
            String phoneNumber=user.get("phoneNumber");
            String address=user.get("address");
            data.add(new Object[]{firstName,lastName,email,password,phoneNumber,address});
        }
        return data.toArray(new Object[0][]);
    }
}
