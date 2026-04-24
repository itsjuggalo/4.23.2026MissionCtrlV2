interface CardProps {
  children: React.ReactNode;
  hover?: boolean;
  className?: string;
  style?: React.CSSProperties;
  onClick?: () => void;
}

export function Card({ children, hover = false, className = '', style, onClick }: CardProps) {
  return (
    <div
      onClick={onClick}
      className={`rounded-[10px] border p-4 transition-colors ${
        hover
          ? 'cursor-pointer border-mc-border hover:border-mc-border-light hover:bg-mc-bg-card-hover'
          : 'border-mc-border'
      } bg-mc-bg-card ${className}`}
      style={style}
    >
      {children}
    </div>
  );
}
