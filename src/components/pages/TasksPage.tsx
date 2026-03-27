import { taskBoard } from '@/lib/mock-data';
import type { Task } from '@/lib/types';

type ColKey = 'backlog' | 'inProgress' | 'review' | 'done';

const columns: { key: ColKey; label: string; dotColor: string }[] = [
  { key: 'backlog', label: 'Backlog', dotColor: '#5c5c72' },
  { key: 'inProgress', label: 'In Progress', dotColor: '#3498ff' },
  { key: 'review', label: 'Review', dotColor: '#ffa502' },
  { key: 'done', label: 'Done', dotColor: '#00d2a0' },
];

function priorityColor(p: Task['priority']) {
  return p === 'high' ? '#ff4757' : p === 'medium' ? '#ffa502' : '#5c5c72';
}

function TaskCard({ task }: { task: Task }) {
  return (
    <div
      style={{
        background: '#111118',
        border: '1px solid #1e1e2a',
        borderRadius: 8,
        padding: '12px',
        marginBottom: 8,
      }}
    >
      <div
        style={{
          fontSize: 10,
          fontFamily: "'JetBrains Mono', monospace",
          color: '#5c5c72',
          marginBottom: 6,
        }}
      >
        {task.id}
      </div>
      <div style={{ display: 'flex', alignItems: 'flex-start', gap: 8, marginBottom: 6 }}>
        <span
          style={{
            width: 6,
            height: 6,
            borderRadius: '50%',
            background: priorityColor(task.priority),
            marginTop: 4,
            flexShrink: 0,
          }}
        />
        <span
          style={{
            fontSize: 13,
            fontFamily: "'Inter', sans-serif",
            fontWeight: 600,
            color: '#e8e8ed',
            lineHeight: 1.4,
          }}
        >
          {task.title}
        </span>
      </div>
      <div
        style={{
          fontSize: 11,
          fontFamily: "'JetBrains Mono', monospace",
          color: '#5c5c72',
        }}
      >
        {task.agent}
      </div>
    </div>
  );
}

export function TasksPage() {
  return (
    <div style={{ display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: 16 }}>
      {columns.map(({ key, label, dotColor }) => {
        const tasks = taskBoard[key];
        return (
          <div key={key}>
            {/* Column header */}
            <div
              style={{
                display: 'flex',
                alignItems: 'center',
                gap: 8,
                marginBottom: 12,
                padding: '0 4px',
              }}
            >
              <span
                style={{
                  width: 8,
                  height: 8,
                  borderRadius: '50%',
                  background: dotColor,
                  flexShrink: 0,
                }}
              />
              <span
                style={{
                  fontSize: 13,
                  fontFamily: "'Inter', sans-serif",
                  fontWeight: 600,
                  color: '#e8e8ed',
                }}
              >
                {label}
              </span>
              <span
                style={{
                  fontSize: 11,
                  fontFamily: "'JetBrains Mono', monospace",
                  color: '#5c5c72',
                  marginLeft: 'auto',
                }}
              >
                {tasks.length}
              </span>
            </div>

            {/* Tasks */}
            <div>
              {tasks.map((task) => (
                <TaskCard key={task.id} task={task} />
              ))}
            </div>
          </div>
        );
      })}
    </div>
  );
}
