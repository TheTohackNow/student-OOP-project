package database;

import java.sql.Connection;
import gymSys.member;
public class TestConnection {
    public static void main(String[] args) {
        // Create staff object
        member m = new member("furion",20,false, "+777",false);
        // Insert into database
        memberDAO dao = new memberDAO();
        dao.insertMember(m);
        dao.getAllStaff();
        // Check in pgAdmin or psql:
        // SELECT * FROM staff;
    }

}
