# AI Image Generator

An **AI-powered image generator** that allows users to create stunning AI-generated images from text prompts using various **Hugging Face models**. The web application provides an intuitive interface for selecting models, choosing aspect ratios, and generating multiple images at once.

---

## Features

**Dark/Light Mode Toggle** – Automatically detects system theme or allows manual switching.  
**AI Model Selection** – Supports multiple AI models including **Stable Diffusion**, **Openjourney**, and **FLUX.1**.  
**Customizable Image Output** – Users can select **aspect ratios** and **image counts**.  
**Random Prompt Generator** – Provides creative suggestions for inspiration.  
**Downloadable Images** – Easily save AI-generated images with a single click.  
**Smooth UI & Responsive Design** – Works well on both desktop and mobile.

---

## Project Structure

```
AI-Image-Generator
│── index.html        # Main HTML structure
│── style.css         # Styling and dark/light theme
│── script.js         # JavaScript logic for API calls and UI
└── README.md         # Project documentation
```

---

## Installation & Setup

### **1. Clone the Repository**

```sh
git clone https://github.com/yourusername/AI-Image-Generator.git
cd AI-Image-Generator
```

### **2. Get a Hugging Face API Key**

To use this project, you need a **free API key** from Hugging Face:

1. Go to [Hugging Face](https://huggingface.co/join) and create a free account.
2. Navigate to [Access Tokens](https://huggingface.co/settings/tokens).
3. Click **New Token** and generate a token with `read` access.
4. Copy the token and **replace** the `API_KEY` value in `script.js`:

```js
const API_KEY = "your_hugging_face_api_key_here";
```

**Do NOT expose your API key publicly!** Keep it private.

### **3. Run the Project**

Simply open `index.html` in your **browser**:

```sh
# On Windows
start index.html

# On macOS/Linux
open index.html
```

Alternatively, use **Live Server** in VS Code for automatic reloads.

### **4. Generate AI Images!**

- Enter a detailed text prompt.
- Choose a model, aspect ratio, and number of images.
- Click **Generate** and watch the magic happen!

---

## Supported AI Models

| Model Name                                 | Description                      |
| ------------------------------------------ | -------------------------------- |
| `stabilityai/stable-diffusion-x1-base-1.0` | High-quality AI image generation |
| `runwayml/stable-diffusion-v1-5`           | Classic Stable Diffusion model   |
| `stabilityai/stable-diffusion-3.5-large`   | Complex prompt model             |
| `black-forest-labs/FLUX.1-dev`             | Experimental AI model            |
| `black-forest-labs/FLUX.1-schnell`         | Faster AI image generation       |

---

## Troubleshooting

1. **API Not Working?**

   - Ensure you have a **valid Hugging Face API Key**.
   - Check if the selected model is **available and functional**.

2. **Images Not Generating?**

   - Verify that your API key is correctly **inserted in `script.js`**.
   - Some AI models may be **busy**; try again later or select another model.

3. **CORS Issues?**
   - If running on `file://`, try using **Live Server** or hosting locally.

---

## Contributing

Feel free to contribute by submitting a **pull request**! Open an issue if you encounter any bugs or have feature suggestions.

---

## Acknowledgments

- **Hugging Face** for their amazing AI models.
- **FontAwesome** for icons.
- **Google Fonts** for typography.

---

Enjoy generating AI-powered images! Happy coding!
