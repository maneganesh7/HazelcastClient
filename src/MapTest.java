import java.util.HashMap;
import java.util.Map;


public class MapTest {
	String n;
	int i;
	MapTest(int id,String name){
		i = id;
		n = name;
	}
	public void setN(String n) {
		this.n = n;
	}
	public static void main(String s[]){
		MapTest m1=new MapTest(1, "Test1");
		m1.setN("Test2");
		MapTest m2=new MapTest(1, "Test1");
		Map map = new HashMap();
		map.put(m1, "Test11");
		map.put(m2, "Test21");
		System.out.println(map);
	}
}
