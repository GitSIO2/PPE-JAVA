
public class Reserver {

	int id ;
	int  disabled ;
	String area_name  ;
	String area_admin_email	 ;
	int resolution	;
	int default_duration;
	int morningstarts;
	int morningstarts_minutes;
	int eveningends;
	int eveningends_minutes	;
	int private_enabled;
	int private_default;
	int private_mandatory ;
	String private_override ;
	int min_book_ahead_enabled	  ;
	int min_book_ahead_secs	  ;
	int max_book_ahead_enabled ;
	int max_book_ahead_secs	  ;
	int custom_html	;
	int approval_enabled  ;
	int reminders_enabled	;
	int enable_periods	 ;
	int confirmation_enabled;
	int confirmed_default;

	public Reserver(int id ,int disabled, String area_name, String area_admin_email, int resolution, int default_duration,	int morningstarts,	int morningstarts_minutes, int eveningends, int eveningends_minutes, int private_enabled, int private_default, int private_mandatory, String private_override, int min_book_ahead_enabled, int min_book_ahead_secs, int max_book_ahead_enabled, int max_book_ahead_secs, int custom_html, int approval_enabled, int reminders_enabled, int enable_periods, int confirmation_enabled, int  confirmed_default)
	{
		super();

		this.id=id;
		this.disabled=disabled;
		this.area_name=area_name;
		this.area_admin_email=area_admin_email;
		this.resolution=resolution;
		this.default_duration=default_duration;
		this.morningstarts=morningstarts;
		this.morningstarts_minutes=morningstarts_minutes;
		this.eveningends=eveningends;
		this.eveningends_minutes=eveningends_minutes;
		this.private_enabled=private_enabled;
		this.private_default=private_default;
		this.private_mandatory=private_mandatory;
		this.private_override=private_override;
		this.min_book_ahead_enabled=min_book_ahead_enabled;
		this.min_book_ahead_secs=min_book_ahead_secs;
		this.max_book_ahead_enabled=max_book_ahead_enabled;
		this.max_book_ahead_secs=max_book_ahead_secs;
		this.custom_html=custom_html;
		this.approval_enabled=approval_enabled;
		this.reminders_enabled=reminders_enabled;
		this.enable_periods=enable_periods;
		this.confirmation_enabled=confirmation_enabled;
		this.confirmed_default=confirmed_default;
	}
	
	public int getId() {
        return this.id;
    }
	
	
	public int getDisabled() {
        return this.disabled;
    }
	
	public String getArea_Name() {
        return this.area_name;
    }
	
	public String getAreaAdminEmail() {
        return this.area_admin_email;
    }
	
	public int getResolution() {
        return this.resolution;
    }
	
	public int getDefaultDuration() {
        return this.default_duration;
    }
	
	public int getMorningStarts() {
        return this.morningstarts;
    }
	public int getMorningStartsMinutes() {
        return this.morningstarts_minutes;
    }
	
	public int getEveningEnds() {
        return this.eveningends;
    }
	
	public int getEveningEndsMinutes() {
        return this.eveningends_minutes;
    }
	public int getPrivateEnabled() {
        return this.private_enabled;
    }
	public int getPrivateDefault() {
        return this.private_default;
    }
	public int getPrivateMandatory() {
        return this.private_mandatory;
    }
	public String getPrivateOverride() {
        return this.private_override;
    }
	public int getMinBookAheadEnabled() {
        return this.min_book_ahead_enabled;
    }
	public int getMaxBookAheadEnabled() {
        return this.max_book_ahead_enabled;
    }
	public int getMinBookAheadSecs() {
        return this.min_book_ahead_secs;
    }
	public int getMaxBookAheadSecs() {
        return this.max_book_ahead_secs;
    }
	public int getCustomHtml() {
        return this.custom_html;
    }
	
	public int getApprovalEnabled() {
        return this.approval_enabled;
    }
	
	public int getRemindersEnabled() {
        return this.reminders_enabled;
    }
	
	public int getEnablePeriods() {
        return this.enable_periods;
    }
	
	public int getConfirmationEnabled() {
        return this.confirmation_enabled;
    }
	public int getConfirmedDefault() {
        return this.confirmed_default;
    }
	  

}

