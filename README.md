# Chess Moves Guessing Project

## Overview
The **Chess Moves Guessing Project** is a Java-based application designed to predict the next best move in a chess game. The project combines foundational chess logic, a user-friendly graphical interface, and options for further integration with AI and IoT systems, such as Bolt IoT, for enhanced interactivity and features.

---

## Features
- **Chessboard Representation:** A 2D array is used to model the chessboard and initialize the game with standard chess rules.
- **Move Prediction Logic:** Implements basic rules to predict the next move for a player (currently using simple heuristics).
- **Graphical User Interface:** A JavaFX-based interface to visualize the chessboard and display predicted moves.
- **Data Persistence:** Integration with Spring Data JPA for storing game moves and history (optional).
- **Bolt IoT Integration:** Optional hardware connection to track moves or display predictions on IoT-enabled devices.

---

## Prerequisites
- **Java Development Kit (JDK)** 11 or higher
- **JavaFX** (for GUI development)
- **Spring Boot** (for database integration)
- **Bolt IoT** (optional for IoT features)
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred IDE

---

## Project Structure
```
chess-moves-guessing
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── Chessboard.java         # Represents the chessboard
│   │   │   ├── ChessMovePredictor.java # Logic for move prediction
│   │   │   ├── ChessGameApp.java       # Main GUI application
│   │   │   ├── entity
│   │   │   │   └── ChessMove.java      # Entity for storing moves
│   │   └── resources
│   │       └── application.properties  # Spring Boot config
├── README.md                           # Project documentation
└── pom.xml                              # Maven configuration
```

---

## Getting Started
### 1. Clone the Repository
```bash
git clone https://github.com/your-repo/chess-moves-guessing.git
cd chess-moves-guessing
```

### 2. Build and Run the Project
1. Compile and run the project:
   ```bash
   mvn clean install
   mvn javafx:run
   ```
2. Ensure that JavaFX is set up correctly in your environment.

### 3. Using the Application
- The application starts with a visual representation of the chessboard.
- Click "Predict Move" to display the next move suggested by the algorithm.

---

## Future Enhancements
1. **Advanced AI Integration:** Use Stockfish or another chess engine for more accurate move predictions.
2. **Legal Move Validation:** Implement move legality checks to avoid invalid moves.
3. **Multiplayer Support:** Allow two players to play against each other using the app.
4. **IoT Features:** Use Bolt IoT to:
   - Track physical chessboard moves using sensors.
   - Display move predictions on an external device.
5. **Game History:** Maintain a detailed history of moves in a database using Spring Data JPA.

---

## Contributing
Feel free to contribute to this project by:
- Reporting bugs.
- Suggesting new features.
- Submitting pull requests.

---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

---

# Java API Service Starter

This is a minimal Java API service starter based on [Google Cloud Run Quickstart](https://cloud.google.com/run/docs/quickstarts/build-and-deploy/deploy-java-service).

## Getting Started

Server should run automatically when starting a workspace. To run manually, run:
```sh
mvn spring-boot:run
```
