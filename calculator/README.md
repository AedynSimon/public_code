# Simple Web Calculator

## Project Description

This project is a **simple, responsive web calculator** built using **HTML, CSS, and JavaScript**. It allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, and division.

---

## Features

- Responsive and centered calculator layout
- Supports the following operations:
  - Addition (`+`)
  - Subtraction (`-`)
  - Multiplication (`*`)
  - Division (`/`)
- Includes:
  - Number keys (0-9)
  - Decimal point (`.`)
  - Clear button (`C`)
  - Equals button (`=`) to evaluate expressions
- Styled with a modern dark theme using HSL color values
- Hover and active states for all buttons
- Operators styled differently for easy recognition

---

## Technologies Used

- **HTML**: Structure and layout of the calculator
- **CSS**: Styling and responsive design
- **JavaScript**: Interactive logic for handling input and calculations

---

## Layout Overview

- A display input field shows the current expression or result
- Buttons are laid out in a 4-column grid
- Operators (`+`, `-`, `*`, `/`, `C`) are visually highlighted
- Calculator fits neatly within the center of the screen on all viewports

---

## How It Works

1. User clicks number and operator buttons to build a mathematical expression.
2. The expression is shown in the display area.
3. Pressing the `=` button evaluates the expression using JavaScript and shows the result.
4. Pressing `C` clears the display.

---

## Future Improvements

- Add keyboard support
- Implement parentheses and more advanced operations
- Use a safer alternative to `eval()` (e.g., math.js)
- Add history of previous calculations
