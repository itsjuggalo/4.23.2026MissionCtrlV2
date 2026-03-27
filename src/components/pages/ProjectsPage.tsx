import { Badge } from '../ui/Badge';
import { ProgressBar } from '../ui/ProgressBar';
import { projects } from '@/lib/mock-data';

export function ProjectsPage() {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 14 }}>
      {projects.map((project, i) => {
        const progressColor =
          project.progress > 75 ? '#00d2a0' : project.progress > 50 ? '#ffa502' : '#5c5c72';

        return (
          <div
            key={i}
            style={{
              background: '#111118',
              border: '1px solid #1e1e2a',
              borderRadius: 10,
              padding: '16px',
              cursor: 'pointer',
              transition: 'border-color 0.15s, background 0.15s',
            }}
            onMouseEnter={(e) => {
              (e.currentTarget as HTMLElement).style.background = '#16161f';
              (e.currentTarget as HTMLElement).style.borderColor = '#2a2a3a';
            }}
            onMouseLeave={(e) => {
              (e.currentTarget as HTMLElement).style.background = '#111118';
              (e.currentTarget as HTMLElement).style.borderColor = '#1e1e2a';
            }}
          >
            <div
              style={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'space-between',
                marginBottom: 10,
              }}
            >
              <div style={{ display: 'flex', alignItems: 'center', gap: 10 }}>
                <span
                  style={{
                    fontSize: 15,
                    fontFamily: "'Inter', sans-serif",
                    fontWeight: 700,
                    color: '#e8e8ed',
                  }}
                >
                  {project.name}
                </span>
                <Badge color={project.status === 'active' ? '#00d2a0' : '#ffa502'}>
                  {project.status}
                </Badge>
              </div>
              <span
                style={{
                  fontSize: 24,
                  fontFamily: "'JetBrains Mono', monospace",
                  fontWeight: 700,
                  color: progressColor,
                }}
              >
                {project.progress}%
              </span>
            </div>
            <ProgressBar value={project.progress} max={100} color={progressColor} height={6} />
            <div
              style={{
                marginTop: 8,
                fontSize: 12,
                fontFamily: "'JetBrains Mono', monospace",
                color: '#5c5c72',
              }}
            >
              {project.completed}/{project.tasks} tasks completed
            </div>
          </div>
        );
      })}
    </div>
  );
}
