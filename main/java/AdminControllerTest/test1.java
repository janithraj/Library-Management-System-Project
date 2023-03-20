package AdminControllerTest;

import java.sql.SQLException;

import com.qsp.adminDAO.AdminDAO;
import com.qsp.adminDTO.AdminDTO;

public class test1 {

	public static void main(String[] args) throws SQLException {
		AdminDTO adto =new AdminDTO(1,"book1","janith",20.0,2);
AdminDAO dao =new AdminDAO();
		
		System.out.println(dao.addbookitems(adto));
		
		
	}
	
	
	
}
