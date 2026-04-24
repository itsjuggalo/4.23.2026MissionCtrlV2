import type { Config } from 'tailwindcss'
const config: Config = {
  content: ['./src/**/*.{js,ts,jsx,tsx,mdx}'],
  theme: {
    extend: {
      colors: {
        bg: '#0a0a0a',
        surface: '#111111',
        border: '#1f1f1f',
        'text-primary': '#f0f0f0',
        'text-secondary': '#888888',
      }
    }
  },
  plugins: [],
}
export default config
