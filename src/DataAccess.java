import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DataAccess {
	public Connection con;
	public Statement stat;
	public ResultSet res;
	
	public DataAccess(){
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
			stat = (Statement)con.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public boolean login(String name, String pass){
		String sql = "Select * from admin where id = '" + name + "' and password ='" + pass + "'";
		System.out.println(sql);
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addNewMember(String name, String id, int password) {
		String sql = "INSERT INTO `member`(`Name`, `ID`, `Password`) VALUES ('" + name + "','"+id+"','"+password+"')";
		System.out.println(sql);
		try{
			stat.executeUpdate(sql);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addNewBook(String bookId, String bookName, int bookAmount,int bookPrice) {
		String sql ="INSERT INTO `book`(`BookID`, `BookName`, `Amount`, `Price`) VALUES ('"+bookName+"','"+bookId+"','"+bookAmount+"','"+bookPrice+"')";
		System.out.println(sql);
		try{
			stat.executeUpdate(sql);
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	

	
	public ArrayList<User> GetUsers(String sql){
		ArrayList<User> list = new ArrayList<User>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				User u = new User();
				u.id=res.getString("id");
				u.name=res.getString("name");
				u.password=res.getString("password");
				list.add(u);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Book> GetBook(String sql){
		ArrayList<Book> list = new ArrayList<Book>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				Book b = new Book();
				b.bookId=res.getString("BookId");
				b.bookName=res.getString("BookName");
				b.bookAmount=res.getInt("Amount");
				b.bookPrice=res.getInt("Price");
				list.add(b);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Issue> GetIssue(String sql){
		ArrayList<Issue> list = new ArrayList<Issue>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				Issue b = new Issue();
				b.bookId=res.getString("BookId");
				b.bookName=res.getString("BookName");
				b.issueId=res.getString("Issue Id");
				b.issueDate=res.getString("Issue Date");
				b.period=res.getInt("Period");
				list.add(b);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean AllMembers() {
		String sql = "Select * from `member`";
		System.out.println(sql);
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean AllBook() {
		String sql = "Select * from `book`";
		System.out.println(sql);
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean issueBook() {
		String sql = "Select * from `issueBook`";
		System.out.println(sql);
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	
	
	public void insert(String sql){
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
