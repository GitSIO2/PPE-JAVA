
public class User {

	private int id ;
	private int level ;
	private String name ;
	private String password ;
	private String email ;

	public User(int id, int level, String name, String password, String email)
	{
		super();

		this.id=id;
		this.level=level;
		this.name=name;
		this.password=password;
		this.email=email;

	}
	
	public int getId() {
        return this.id;
    }
	
	
	public int getLevel() {
        return this.level;
    }
	
	public String getName() {
        return this.name;
    }
	
	public String getPassword() {
        return this.password;
    }
	
	public String getEmail() {
        return this.email;
    }
	
}

