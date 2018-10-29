package modals;

import java.util.List;

public class UserBox {
private List<User> users;

public UserBox(List<User> users) {
	super();
	this.users = users;
}

public UserBox() {
	super();
	// TODO Auto-generated constructor stub
}

public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}

}
