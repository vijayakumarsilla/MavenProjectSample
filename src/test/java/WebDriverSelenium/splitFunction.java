package WebDriverSelenium;

public class splitFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "$123.23";
		String arr[] = str.split("\\$");
		System.out.println(arr[1]);
	}

}
