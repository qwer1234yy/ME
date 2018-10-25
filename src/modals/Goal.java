package modals;

import java.sql.Date;

public class Goal {
	
	private String description;
	private String where;
	private Date when;
	private Date start;
	private Date end;
	private double cost;
	private User participant;
	private int priority;
	private String type;

	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goal(String description,String where, Date when, Date start, double cost, User participant, String type) {
		super();
		this.description = description;
		this.where = where;
		this.when = when;
		this.start = start;
		this.cost = cost;
		this.participant = participant;
		this.type = type;
	}
	public String getDescript() {
		return description;
	}

	public void setDescript(String description) {
		this.description = description;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
