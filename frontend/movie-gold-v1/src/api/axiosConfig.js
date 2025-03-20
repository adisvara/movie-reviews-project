import axios from 'axios';

// Get the base URL based on the environment
// For GitHub Pages deployment, we'll use a deployed backend URL
// For local development, we'll use localhost
const baseURL = process.env.NODE_ENV === 'production' 
  ? 'https://api.render.com/your-backend-url' // Replace with your actual backend deployment URL
  : 'http://localhost:8080';

export default axios.create({
    baseURL: baseURL,
    headers: {"ngrok-skip-browser-warning": "true"}
});