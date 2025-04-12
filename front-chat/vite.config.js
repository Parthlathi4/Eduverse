import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
/**
 * Vite configuration for the Room Chat Application.
 * This configuration enables support for React features.
 */
export default defineConfig({
  plugins: [react()],
})
