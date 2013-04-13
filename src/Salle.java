
public class Salle {

	private int id;
	private String area_id ;
	private String room_name;
	private String sort_key;
	private String description;
	private int capacity ;
	private String room_admin_email;
	private String custom_html  ;
	private int row ;

	public Salle(int id, String area_id, String room_name, String sort_key, String description,  int capacity, String room_admin_email, String custom_html )
	{
		super();

		this.id=id;
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
	
	public String getRoom_Admin_Eamil() {
        return this.room_admin_email;
    }
	
	public String getCustomHtml() {
        return this.custom_html;
    }
	  

}

