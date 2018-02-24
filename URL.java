package url;

public class URL {
	public String URL;
	
	public String getProtocol(){
		int protocolEnd = URL.indexOf("://");
		if(protocolEnd == -1 || protocolEnd == 0){
			return "http";
		}else{
			return URL.substring(0, protocolEnd);
		}
	}
	
	public String getHost(){
		int hostBegin = 0;
		int checkProtocol = URL.indexOf("://");
		if(checkProtocol == -1){
			hostBegin = 0;
		}else{
			hostBegin = checkProtocol+3;
		}
		int hostEnd = URL.indexOf(":", hostBegin);
		if(hostEnd != -1){
			return URL.substring(hostBegin, hostEnd);
		}else{
			hostEnd = URL.indexOf("/", hostBegin);
			if(hostEnd != -1){
				return URL.substring(hostBegin, hostEnd);
			}else{
				return URL.substring(hostBegin);
			}
		}
	}
	
	public String getPort(){
		int checkProtocol = URL.indexOf("://");
		int beginPort = 0;
		int endPort = 0;
		if(checkProtocol == -1){
			beginPort = URL.indexOf(":");
			if(beginPort == -1){
				return "80";
			}else{
				endPort = URL.indexOf("/", beginPort);
				return URL.substring(beginPort, endPort);
			}
		}else{
			beginPort = URL.indexOf(":", checkProtocol+1);
			if(beginPort == -1){
				return "80";
			}else{
				endPort = URL.indexOf("/", beginPort);
				return URL.substring(beginPort+1, endPort);
			}
		}
	}
	
	public String getPath(){
		int checkProtocol = URL.indexOf("://");
		if(checkProtocol == -1){
			return URL.substring(URL.indexOf("/"), URL.length());
		}else{
			int portBegin = URL.indexOf(":", checkProtocol+3);
			if(portBegin == -1){
				return URL.substring(URL.indexOf("/", checkProtocol+3), URL.length());
			}else{
				return URL.substring(URL.indexOf("/", portBegin), URL.length());
			}
		}
	}
	
	public static void main(String args[]){
		String testString = "https://www.testURL.com:2548/some/path/here.extension";
		URL testURL = new URL();
		testURL.URL = testString;
		System.out.println(testURL.getProtocol());
		System.out.println(testURL.getHost());
		System.out.println(testURL.getPort());
		System.out.println(testURL.getPath());
	}
}
