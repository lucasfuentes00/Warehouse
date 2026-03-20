# 📦 Warehouse JS

A simple, intuitive Warehouse management system built with **Vanilla JavaScript**. This project uses a **Tree Data Structure** to represent the hierarchical nature of a warehouse (Warehouse > Aisle > Shelf > Item) and includes built-in data persistence.

<img width="607" height="360" alt="Warehouse2" src="https://github.com/user-attachments/assets/88cac3f8-8abc-4bb2-88f2-20f528a3daeb" />



## 🚀 Features

* **Tree Structure:** Organize your inventory logically by nesting items within locations.
* **Data Persistence:** Automatically saves your warehouse state to `localStorage`, so your data remains even after refreshing the browser.
* **Dynamic UI:** Add, remove, or rename nodes in the warehouse tree in real-time.
* **Lightweight:** Built with pure JavaScript, HTML5, and CSS3—no heavy frameworks required.

## 🛠️ How It Works

The project treats the warehouse as a tree where:
- **Root:** The Warehouse itself.
- **Branches:** Categories, Aisles, or Shelves.
- **Leaves:** The actual products or stock items.

Each time a change is made (adding an item or moving a shelf), the updated tree object is stringified and stored.

## 📂 Project Structure

```text
Warehouse/
├── index.html       # The main interface
├── style.css        # Layout and tree styling
├── script.js        # Tree logic and storage handling
└── README.md        # Project documentation
