import { useState } from "react"; // Importing useState hook from React
import reactLogo from "./assets/react.svg"; // Importing React logo for display
import viteLogo from "/vite.svg"; // Importing Vite logo for display
import "./App.css"; // Importing CSS styles for the application
import toast from "react-hot-toast"; // Importing toast for notifications
import JoinCreateChat from "./components/JoinCreateChat"; // Importing JoinCreateChat component for chat functionality

/**
 * Main application component for the Room Chat Application.
 * This component renders the chat functionality.
 */
function App() {
  const [count, setCount] = useState(0);

  // Rendering the JoinCreateChat component
  return (
    <div>
      <JoinCreateChat />
    </div>
  );
}

export default App;
