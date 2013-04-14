
public class Salle {

	private int id;
	private int disabled;
	private String area_id ;
	private String room_name;
	private String sort_key;
	private String description;
	private int capacity ;
	private String room_admin_email;
	private String custom_html  ;
	private int row ;

	public Salle(int id, int disabled, String area_id, String room_name, String sort_key, String description,  int capacity, String room_admin_email, String custom_html )
	{
		super();

		this.id=id;
		this.disabled=disabled;
		this.area_id=area_id;
		this.room_name=room_name;
		this.sort_key=sort_key;
		this.description=description;
		this.capacity=capacity;
		this.room_admin_email=room_admin_email;
		this.custom_html=custom_html;

	}
	
	public int getId() {
        return this.id;
    }
	
	public int getDisabled() {
        return this.disabled;
    }
	
	public String getArea_Id() {
        return this.area_id;
    }
	
	public String getRoom_Name() {
        return this.room_name;
    }
	
	public String getSort_Key() {
        return this.sort_key;
    }
	
	public String getDescription() {
        return this.description;
    }
	
	public int getCapacity() {
        return this.capacity;
    }
	
	public String getRoom_Admin_Email() {
        return this.room_admin_email;
    }
	
	public String getCustomHtml() {
        return this.custom_html;
    }
	
	 ///////////////
	
	public void setId(int id) {
         this.id=id;
    }
	
	public void setDisabled(int disabled) {
        this.disabled=disabled;
    }
	
	public void setArea_Id(String area_id) {
        this.area_id=area_id;
    }
	
	public void getRoom_Name(String room_name) {
        this.room_name=room_name;
    }
	
	public void setSort_Key(String sort_key) {
        this.sort_key=sort_key;
    }
	
	public void setDescription(String description ) {
        this.description=description;
    }
	
	public void setCapacity(int capacity) {
        this.capacity=capacity;
    }
	
	public void setRoom_Admin_Email(String room_admin_email) {
        this.room_admin_email=room_admin_email;
    }
	
	public void getCustomHtml(String custom_html) {
        this.custom_html=custom_html;
    }
	
	  

}

