#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <limits>
#include <algorithm>

using namespace std;

struct Course {
    string courseNumber;
    string courseTitle;
    vector<string> prerequisites;
};

vector<Course> courseList;

void loadCourses(const string& fileName);
void printCourseList();
void printCourseInfo();
void displayMenu();

string trim(const string& s) {
    size_t start = s.find_first_not_of(" \t\r\n");
    size_t end = s.find_last_not_of(" \t\r\n");
    return (start == string::npos) ? "" : s.substr(start, end - start + 1);
}

int main() {
    int choice = 0;
    string fileName;

    while (choice != 9) {
        displayMenu();

        if (!(cin >> choice)) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid option. Please enter a number.\n\n";
            continue;
        }

        switch (choice) {
        case 1:
            cout << "Enter file name: ";
            cin >> fileName;
            loadCourses(fileName);
            break;

        case 2:
            if (courseList.empty()) {
                cout << "Please load data first.\n";
            }
            else {
                printCourseList();
            }
            break;

        case 3:
            if (courseList.empty()) {
                cout << "Please load data first.\n";
            }
            else {
                printCourseInfo();
            }
            break;

        case 9:
            cout << "Thank you for using the course planner.\n";
            break;

        default:
            cout << "Invalid option. Please try again.\n";
        }
        cout << endl;
    }
    return 0;
}

void displayMenu() {
    cout << "Menu:\n";
    cout << "   1. Load Data Structure\n";
    cout << "   2. Print Course List\n";
    cout << "   3. Print Course\n";
    cout << "   9. Exit\n";
    cout << "Enter choice: ";
}

void loadCourses(const string& fileName) {
    ifstream file(fileName);

    if (!file.is_open()) {
        cout << "Error: Could not open file.\n";
        return;
    }

    courseList.clear();
    string line;

    while (getline(file, line)) {
        if (trim(line).empty()) continue;

        Course course;
        string token;
        stringstream ss(line);

        getline(ss, course.courseNumber, ',');
        getline(ss, course.courseTitle, ',');

        course.courseNumber = trim(course.courseNumber);
        course.courseTitle = trim(course.courseTitle);

        transform(course.courseNumber.begin(), course.courseNumber.end(),
            course.courseNumber.begin(), ::toupper);

        if (course.courseNumber.empty() || course.courseTitle.empty()) {
            cout << "Warning: Skipping malformed line.\n";
            continue;
        }

        while (getline(ss, token, ',')) {
            token = trim(token);
            if (!token.empty()) {
                transform(token.begin(), token.end(), token.begin(), ::toupper);
                course.prerequisites.push_back(token);
            }
        }

        courseList.push_back(course);
    }
    file.close();
    cout << "Data loaded successfully.\n";
}

void printCourseList() {
    cout << "Course List:\n";

    sort(courseList.begin(), courseList.end(),
        [](const Course& a, const Course& b) {
            return a.courseNumber < b.courseNumber;
        });

    for (const auto& course : courseList) {
        cout << course.courseNumber << ", " << course.courseTitle << endl;
    }
}

void printCourseInfo() {
    string courseNumber;
    cout << "Enter course number: ";
    cin >> courseNumber;

    transform(courseNumber.begin(), courseNumber.end(), courseNumber.begin(), ::toupper);

    auto it = find_if(courseList.begin(), courseList.end(),
        [&](const Course& c) { return c.courseNumber == courseNumber; });

    if (it == courseList.end()) {
        cout << "Course not found.\n";
        return;
    }

    const Course& course = *it;
    cout << course.courseNumber << ", " << course.courseTitle << endl;

    if (course.prerequisites.empty()) {
        cout << "Prerequisites: None\n";
    }
    else {
        cout << "Prerequisites: ";
        for (size_t i = 0; i < course.prerequisites.size(); i++) {
            auto pit = find_if(courseList.begin(), courseList.end(),
                [&](const Course& c) { return c.courseNumber == course.prerequisites[i]; });

            if (pit != courseList.end()) {
                cout << course.prerequisites[i] << " (" << pit->courseTitle << ")";
            }
            else {
                cout << course.prerequisites[i] << " (title unavailable)";
            }

            if (i < course.prerequisites.size() - 1) cout << ", ";
        }
        cout << endl;
    }
}