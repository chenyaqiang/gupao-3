package com.gupao.peter.showme.v2.generatemybatis.bean;

import java.util.List;

public class PeterUserInfo {
    private Integer id;

    private String uname;

    private Integer unumber;

//    private List<String> hobby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getUnumber() {
        return unumber;
    }

    public void setUnumber(Integer unumber) {
        this.unumber = unumber;
    }

//    public List<String> getHobby() {
//        return hobby;
//    }
//
//	public void setHobby(List<String> hobby) {
//		this.hobby = hobby;
//	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", uname=" + uname + ", unumber=" + unumber + ", hobby=" +  "]";
	}
}