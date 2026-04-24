'use client';

interface SouthParkAgentProps {
  name: string;
  status: 'online' | 'offline';
  activity: string;
  color?: string;
}

export function SouthParkAgent({ name, status, activity, color = '#4a9eff' }: SouthParkAgentProps) {
  const isOnline = status === 'online';
  
  // Simple South Park-style character using CSS
  return (
    <div className="flex flex-col items-center gap-2">
      {/* Character */}
      <div className={`relative ${isOnline ? 'animate-bounce' : ''}`} style={{ width: '60px', height: '80px' }}>
        {/* Head */}
        <div 
          className="absolute top-0 left-1/2 transform -translate-x-1/2 rounded-full border-2 border-black"
          style={{
            width: '40px',
            height: '50px',
            backgroundColor: '#f5deb3', // skin tone
          }}
        >
          {/* Eyes */}
          <div className="absolute top-[15px] left-[8px] w-[8px] h-[8px] bg-white rounded-full border border-black">
            <div className="absolute top-[2px] left-[2px] w-[4px] h-[4px] bg-black rounded-full"></div>
          </div>
          <div className="absolute top-[15px] right-[8px] w-[8px] h-[8px] bg-white rounded-full border border-black">
            <div className="absolute top-[2px] left-[2px] w-[4px] h-[4px] bg-black rounded-full"></div>
          </div>
          
          {/* Mouth */}
          <div 
            className="absolute bottom-[8px] left-1/2 transform -translate-x-1/2 w-[12px] h-[6px] bg-black rounded-b-full"
            style={{
              borderTop: isOnline ? '2px solid black' : 'none',
            }}
          ></div>
        </div>
        
        {/* Body */}
        <div 
          className="absolute bottom-0 left-1/2 transform -translate-x-1/2 border-2 border-black"
          style={{
            width: '30px',
            height: '25px',
            backgroundColor: color,
            borderRadius: '3px',
          }}
        ></div>
        
        {/* Status indicator */}
        {isOnline && (
          <div 
            className="absolute -top-1 -right-1 w-3 h-3 bg-green-400 rounded-full border-2 border-black animate-pulse"
          ></div>
        )}
      </div>
      
      {/* Name */}
      <div className="text-center">
        <div className="text-xs font-bold text-white px-2 py-0.5 rounded" style={{ backgroundColor: color }}>
          {name}
        </div>
        <div className="text-xs text-[#666] mt-1">
          {activity}
        </div>
      </div>
    </div>
  );
}
