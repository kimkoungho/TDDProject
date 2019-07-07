package securitymock;

public class SecurityService {

	private Window window;
	private Door door;
	
	public SecurityService(Window window, Door door) {
		this.window = window;
		this.door = door;
	}
	
	public void securityOn() {
		// 실제 환경에 대한 값 이라고 가정 
		String ready = "door";
		if(ready.equals("window")) {
			window.close();
		}else if(ready.equals("door")) {
			door.close();
		}
	}
}
