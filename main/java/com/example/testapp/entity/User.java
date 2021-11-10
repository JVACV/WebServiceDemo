package com.example.testapp.entity;

public class User {

    private String user_phone_no;

    private String password;

    private String user_email_id;

    private String user_firstname;

    private String user_lastname;

    private String user_address;

    private String user_village;

    private String user_district;

    public String getUser_phone_no ()
    {
        return user_phone_no;
    }

    public void setUser_phone_no (String user_phone_no)
    {
        this.user_phone_no = user_phone_no;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getUser_email_id ()
    {
        return user_email_id;
    }

    public void setUser_email_id (String user_email_id)
    {
        this.user_email_id = user_email_id;
    }

    public String getUser_firstname ()
    {
        return user_firstname;
    }

    public void setUser_firstname (String user_firstname)
    {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname ()
    {
        return user_lastname;
    }

    public void setUser_lastname (String user_lastname)
    {
        this.user_lastname = user_lastname;
    }

    public String getUser_address ()
    {
        return user_address;
    }

    public void setUser_address (String user_address)
    {
        this.user_address = user_address;
    }

    public String getUser_village ()
    {
        return user_village;
    }

    public void setUser_village (String user_village)
    {
        this.user_village = user_village;
    }

    public String getUser_district ()
    {
        return user_district;
    }

    public void setUser_district (String user_district)
    {
        this.user_district = user_district;
    }

    @Override
    public String toString()
    {
        return "User [user_phone_no = "+user_phone_no+", password = "+password+", user_email_id = "+user_email_id+", user_firstname = "+user_firstname+", user_lastname = "+user_lastname+", user_address = "+user_address+", user_village = "+user_village+", user_district = "+user_district+"]";
    }


}
