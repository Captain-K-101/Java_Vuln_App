import java.io.Serializable;

public class Serializations implements Serializable{
	public String Name;
	public String rank;
	public Serializations(String username,String b) {
		this.Name=username;
		this.rank=b;
	}
}
