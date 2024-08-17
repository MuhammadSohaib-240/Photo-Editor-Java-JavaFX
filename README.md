# Photo Editor - JavaFX & OpenCV

## Description

This project is a user-friendly and simple photo editor built using Java, JavaFX, and OpenCV. It showcases my problem-solving skills as well as my expertise in software design and architecture. The photo editor allows users to perform basic image manipulation tasks and is designed with a focus on clean code, maintainability, and performance.

## Features

- **User-Friendly Interface:** A simple and intuitive UI built with JavaFX, ensuring ease of use for all users.
- **Image Manipulation:** Basic image editing capabilities like cropping, rotating, and applying filters using the power of OpenCV.
- **Cross-Platform Compatibility:** Runs smoothly on any system that supports Java, ensuring a wide reach and usability.

## Setup and Installation

### Prerequisites

Before you can run the project, ensure you have the following installed:

- **Java Development Kit (JDK):** Version 8 or later.
- **JavaFX:** The project is built using JavaFX, which is bundled with JDK 8. For later versions, ensure you have JavaFX set up properly.
- **OpenCV (Java):** You must use the official version of OpenCV for Java from the [OpenCV website](https://opencv.org/releases/). Third-party distributions or Maven/Gradle dependencies are not recommended for this project.

### OpenCV Setup Instructions

1. **Download OpenCV:**
   - Visit the [OpenCV releases page](https://opencv.org/releases/) and download the latest stable version of OpenCV.

2. **Extract and Add to Project:**
   - Extract the downloaded OpenCV archive.
   - Navigate to the `opencv/build/java` directory and locate the `.jar` file.
   - Add the `.jar` file to your project’s classpath.
   - Locate the `opencv/build/java/x64` (or `x86`, depending on your system) directory and find the `.dll` files.
   - Ensure these `.dll` files are accessible by your project (e.g., by adding them to your system’s PATH or specifying them in your project settings).

3. **Configure Your IDE:**
   - If you're using an IDE like IntelliJ IDEA or Eclipse, configure the project to include the OpenCV `.jar` in the library and ensure the `.dll` files are correctly linked.

### Running the Project

After setting up the prerequisites, you can run the project through your IDE by executing the main class. The application should launch, allowing you to start editing photos.

## Usage

1. **Open the application.**
2. **Load an image** using the file chooser.
3. **Apply edits** such as cropping, rotating, or applying filters.
4. **Save your edited image** to your desired location.

## Technologies Used

- **Java:** Core programming language.
- **JavaFX:** Used for building the graphical user interface.
- **OpenCV:** Used for image processing tasks.

## Acknowledgments

- Thanks to the OpenCV community for providing robust tools for computer vision tasks.
- Special thanks to Java and JavaFX communities for extensive documentation and support.

## Contact

For any questions or further information, please feel free to contact me through my [GitHub profile](https://github.com/MuhammadSohaib-240).
