package javacoreAdvance.BaiLam.model;

import java.util.Date;

public class Message {
	private Integer id;
	private String value;
	private Date createdDate;

	public Message(Integer id, String value, Date createdDate) {
		super();
		this.id = id;
		this.value = value;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", value=" + value + ", createdDate=" + createdDate + "]";
	}

}
