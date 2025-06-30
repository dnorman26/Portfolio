//Daniel Norman
#include <iostream>
#include <iomanip>

using namespace std;

void HandleMenuInput() {
    //Prints Menu
	cout << "             " << "**************************" << endl;
	cout << "             " << "* 1 - Add One Hour       *" << endl;
	cout << endl;
	cout << "             " << "* 2 - Add One Minute     *" << endl;
	cout << endl;
	cout << "             " << "* 3 - Add One Second     *" << endl;
	cout << endl;
	cout << "             " << "* 4 - Exit Program       *" << endl;
	cout << "             " << "**************************" << endl;
}
void PrintClocks(int hour12, int min, int sec, string meridiem, int hour24) {
    //Prints Clock Display
	cout << "**************************" << "   " << "**************************" << endl;
	cout << "*      12-Hour Clock     *" << "   " << "*      24-Hour Clock     *" << endl;
	cout << endl;
	cout << "*      " << setfill('0') << setw(2) << hour12 << ":" << setfill('0') << setw(2) << min << ":" << setfill('0') << setw(2) << sec << " " << meridiem << "      *";
	cout << "   ";
	cout << "*        " << setfill('0') << setw(2) << hour24 << ":" << setfill('0') << setw(2) << min << ":" << setfill('0') << setw(2) << sec << "        *" << endl;
	cout << "**************************" << "   " << "**************************" << endl;
}
void AddOneHour(int& hour24) {
    //Adds an hour 
    hour24 = (hour24 + 1) % 24;
}

void AddOneMinute(int& hour24, int& min) {
    //Adds a minute 
    min++;
    if (min >= 60) {
        min = 0;
        AddOneHour(hour24);
    }
}

void AddOneSecond(int& hour24, int& min, int& sec) {
    //Adds a second 
    sec++;
    if (sec >= 60) {
        sec = 0;
        AddOneMinute(hour24, min);
    }
}

int GetUserChoice() {
    //Gets input from user
    HandleMenuInput();
    int choice;
    cout << "Enter your choice: ";
    cin >> choice;
    return choice;
}


void DisplayClocks(int hour24, int min, int sec) {
    //Handles the 12 hour clock and prints the clock
    int hour12 = hour24 % 12;
    if (hour12 == 0) hour12 = 12;
    string meridiem = (hour24 < 12) ? "A M" : "P M";
    PrintClocks(hour12, min, sec, meridiem, hour24);
}


int Time() {
    //Handles the user input
    int hour24 = 0;
    int min = 0;
    int sec = 0;
    int menuSel = 0;

    while (menuSel != 4) {
        system("cls"); 
        DisplayClocks(hour24, min, sec);
        menuSel = GetUserChoice();

        switch (menuSel) {
        case 1:
            AddOneHour(hour24);
            break;
        case 2:
            AddOneMinute(hour24, min);
            break;
        case 3:
            AddOneSecond(hour24, min, sec);
            break;
        case 4:
            cout << "Exiting program." << endl;
            break;
        default:
            cout << "Invalid option. Try again." << endl;
            break;
        }
    }
    return 0;
}




int main() {
	Time();
}