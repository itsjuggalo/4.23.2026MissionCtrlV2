export interface AgentConfig {
  id: string;
  name: string;
  emoji: string;
  position: [number, number, number];
  color: string;
  role: string;
}

export const AGENTS: AgentConfig[] = [
  {
    id: "boba",
    name: "Boba",
    emoji: "🧋",
    position: [0, 0, 0],
    color: "#4fc3f7",
    role: "Commander · Claude Sonnet 4-6",
  },
  {
    id: "jazzyhazzy",
    name: "JazzyHazzy",
    emoji: "🎷",
    position: [-4, 0, -3],
    color: "#66bb6a",
    role: "Research · GPT-4o-mini",
  },
  {
    id: "orion",
    name: "Orion",
    emoji: "⭐",
    position: [4, 0, -3],
    color: "#ce93d8",
    role: "Scanner · Gemini 2.5 Flash",
  },
  {
    id: "groot",
    name: "Groot",
    emoji: "🌳",
    position: [-4, 0, 3],
    color: "#ff9800",
    role: "Analyst · Grok",
  },
  {
    id: "deepsheet",
    name: "DeepSheet",
    emoji: "🧠",
    position: [4, 0, 3],
    color: "#ef5350",
    role: "Strategist · DeepSeek",
  },
];

export type AgentStatus = "idle" | "working" | "thinking" | "error";

export interface AgentState {
  id: string;
  status: AgentStatus;
  currentTask?: string;
  model?: string;
  tokensPerHour?: number;
  tasksInQueue?: number;
  uptime?: number;
}
