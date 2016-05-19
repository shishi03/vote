package com.yc.vote.entity;

public class Subject {
    private Long vsid;

    private String vstitle;

    private Integer vsType;

    public Long getVsid() {
        return vsid;
    }

    public void setVsid(Long vsid) {
        this.vsid = vsid;
    }

    public String getVstitle() {
        return vstitle;
    }

    public void setVstitle(String vstitle) {
        this.vstitle = vstitle == null ? null : vstitle.trim();
    }

    public Integer getVsType() {
        return vsType;
    }

    public void setVsType(Integer vsType) {
        this.vsType = vsType;
    }

	@Override
	public String toString() {
		return "\nSubject [vsid=" + vsid + ", vstitle=" + vstitle + ", vsType="
				+ vsType + "]";
	}
    
    
}