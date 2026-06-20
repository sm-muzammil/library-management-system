# library-management-system
A console-based Library Management System in Java that allows users to add, remove, search, and list books with persistent file storage.

---

## Features

- Add a new book (Title, Author, Genre, Year)
- Remove a book by ID
- Search books by ID, Title, or Author
- List all available books
- Data saved to file — persists after program closes
- Input validation and error handling throughout
- Press `0` at any point to return to the main menu

---

## Tech Stack

- Language: Java
- Storage: File I/O (FileHandler)
- IDE: Apache NetBeans (Maven Project)

---

## Project Structure

```

LibraryManagementSystem/
│
├── src/main/java/com/mycompany/librarymanagementsystem/
│   ├── LibraryManagementSystem.java   ← Main entry point
│   ├── LibraryManager.java            ← Core logic
│   ├── Book.java                      ← Book model
│   └── FileHandler.java               ← File save/load
│
└── README.md
```

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/library-management-system.git
   ```
2. Open in NetBeans or any Java IDE
3. Build and run `LibraryManagementSystem.java`

---

## Menu Options

| Option | Action |
|--------|--------|
| 1 | Add Book |
| 2 | Remove Book |
| 3 | Search Book |
| 4 | List All Books |
| 0 | Exit / Go Back |

---

## License
MIT License — free to use and modify.
