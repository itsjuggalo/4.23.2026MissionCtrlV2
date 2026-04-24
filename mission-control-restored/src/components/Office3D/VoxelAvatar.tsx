'use client';

import { useRef } from 'react';
import { useFrame } from '@react-three/fiber';
import { Box, Text } from '@react-three/drei';
import type { Group } from 'three';
import type { AgentConfig } from './agentsConfig';

interface VoxelAvatarProps {
  agent: AgentConfig;
  position: [number, number, number];
  isWorking?: boolean;
  isThinking?: boolean;
  isError?: boolean;
}

// South Park character skins
function getSkin(id: string) {
  switch (id) {
    case 'boba': // Cartman
      return {
        skinColor: '#ffd5a0',
        shirtColor: '#cc2222', // red jacket
        shirtAccent: '#ddaa00', // yellow stripe (belt area)
        pantsColor: '#6b4c2a', // brown pants
        shoeColor: '#1a1a1a',
        hatColor: '#3b82f6', // blue hat
        hatBrim: '#ddaa00', // yellow brim
        hatStyle: 'beanie' as const,
        hairColor: '#5d3a1a', // brown hair
        isChubby: true,
      };
    case 'jazzyhazzy': // Kyle
      return {
        skinColor: '#ffd5a0',
        shirtColor: '#dd6600', // orange jacket
        shirtAccent: '#dd6600',
        pantsColor: '#2d5a27', // dark green pants
        shoeColor: '#1a1a1a',
        hatColor: '#22aa44', // green ushanka
        hatBrim: '#22aa44',
        hatStyle: 'ushanka' as const,
        hairColor: '#cc4400', // red hair pokes out
        isChubby: false,
      };
    case 'orion': // Chef
      return {
        skinColor: '#5d3a1a', // dark skin
        shirtColor: '#cc2222', // red shirt
        shirtAccent: '#ffffff', // white apron front
        pantsColor: '#2a2a2a', // black pants
        shoeColor: '#1a1a1a',
        hatColor: '#ffffff', // white chef hat
        hatBrim: '#f0f0f0',
        hatStyle: 'chef' as const,
        hairColor: '#1a1a1a', // black hair/beard
        isChubby: true,
      };
    case 'groot': // Stan
      return {
        skinColor: '#ffd5a0',
        shirtColor: '#5d3a1a', // brown jacket
        shirtAccent: '#cc2222', // red collar
        pantsColor: '#2255cc', // blue jeans
        shoeColor: '#1a1a1a',
        hatColor: '#2255cc', // blue hat
        hatBrim: '#cc2222', // red pom-pom
        hatStyle: 'beanie' as const,
        hairColor: '#1a1a1a', // black hair
        isChubby: false,
      };
    case 'deepsheet': // Butters
      return {
        skinColor: '#ffd5a0',
        shirtColor: '#88ccee', // light blue jacket
        shirtAccent: '#88ccee',
        pantsColor: '#44aa44', // green pants
        shoeColor: '#1a1a1a',
        hatColor: '', // no hat
        hatBrim: '',
        hatStyle: 'none' as const,
        hairColor: '#ddb844', // blonde
        isChubby: false,
      };
    default:
      return {
        skinColor: '#ffd5a0',
        shirtColor: '#cc2222',
        shirtAccent: '#cc2222',
        pantsColor: '#2255cc',
        shoeColor: '#1a1a1a',
        hatColor: '#3b82f6',
        hatBrim: '#ddaa00',
        hatStyle: 'beanie' as const,
        hairColor: '#5d3a1a',
        isChubby: false,
      };
  }
}

export default function VoxelAvatar({
  agent,
  position,
  isWorking = false,
  isThinking = false,
  isError = false,
}: VoxelAvatarProps) {
  const groupRef = useRef<Group>(null);
  const leftArmRef = useRef<Group>(null);
  const rightArmRef = useRef<Group>(null);
  const headRef = useRef<Group>(null);

  const skin = getSkin(agent.id);

  useFrame((state) => {
    if (!groupRef.current) return;

    if (isWorking && leftArmRef.current && rightArmRef.current) {
      const time = state.clock.elapsedTime * 3;
      leftArmRef.current.rotation.x = Math.sin(time) * 0.3;
      rightArmRef.current.rotation.x = Math.sin(time + Math.PI) * 0.3;
    }

    if (isThinking && headRef.current) {
      headRef.current.position.y = 0.35 + Math.sin(state.clock.elapsedTime * 2) * 0.03;
      headRef.current.rotation.y = Math.sin(state.clock.elapsedTime) * 0.1;
    }

    if (isError && headRef.current) {
      headRef.current.rotation.x = Math.sin(state.clock.elapsedTime * 5) * 0.1;
      headRef.current.rotation.z = Math.sin(state.clock.elapsedTime * 4) * 0.15;
    }

    if (!isWorking && !isThinking && !isError) {
      groupRef.current.position.y = position[1] + Math.sin(state.clock.elapsedTime) * 0.01;
    }
  });

  const bodyWidth = skin.isChubby ? 0.28 : 0.2;
  const bodyDepth = skin.isChubby ? 0.18 : 0.12;

  return (
    <group ref={groupRef} position={position}>
      {/* HEAD */}
      <group ref={headRef} position={[0, 0.35, 0]}>
        {/* Head — South Park round-ish */}
        <Box args={[0.22, 0.22, 0.2]} castShadow>
          <meshStandardMaterial color={skin.skinColor} />
        </Box>

        {/* Eyes — South Park big white eyes */}
        <Box args={[0.07, 0.07, 0.02]} position={[-0.055, 0.02, 0.11]} castShadow>
          <meshStandardMaterial color="#ffffff" />
        </Box>
        <Box args={[0.07, 0.07, 0.02]} position={[0.055, 0.02, 0.11]} castShadow>
          <meshStandardMaterial color="#ffffff" />
        </Box>
        {/* Pupils */}
        <Box args={[0.03, 0.03, 0.02]} position={[-0.055, 0.02, 0.121]} castShadow>
          <meshStandardMaterial color="#1a1a1a" />
        </Box>
        <Box args={[0.03, 0.03, 0.02]} position={[0.055, 0.02, 0.121]} castShadow>
          <meshStandardMaterial color="#1a1a1a" />
        </Box>

        {/* Mouth */}
        {!isError ? (
          <Box args={[0.06, 0.015, 0.01]} position={[0, -0.05, 0.11]} castShadow>
            <meshStandardMaterial color="#1a1a1a" />
          </Box>
        ) : (
          /* Error: open mouth "O" */
          <mesh position={[0, -0.05, 0.11]}>
            <circleGeometry args={[0.03, 8]} />
            <meshStandardMaterial color="#1a1a1a" />
          </mesh>
        )}

        {/* === HATS === */}
        {skin.hatStyle === 'beanie' && (
          <group>
            {/* Beanie body */}
            <Box args={[0.24, 0.12, 0.22]} position={[0, 0.15, 0]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            {/* Brim / fold */}
            <Box args={[0.26, 0.04, 0.24]} position={[0, 0.1, 0]} castShadow>
              <meshStandardMaterial color={skin.hatBrim} />
            </Box>
            {/* Pom-pom (Stan/Cartman) */}
            <mesh position={[0, 0.22, 0]} castShadow>
              <sphereGeometry args={[0.03, 8, 8]} />
              <meshStandardMaterial color={skin.hatBrim} />
            </mesh>
          </group>
        )}

        {skin.hatStyle === 'ushanka' && (
          <group>
            {/* Main hat */}
            <Box args={[0.26, 0.14, 0.24]} position={[0, 0.15, 0]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            {/* Ear flaps */}
            <Box args={[0.06, 0.1, 0.08]} position={[-0.13, 0.05, 0]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            <Box args={[0.06, 0.1, 0.08]} position={[0.13, 0.05, 0]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            {/* Red hair poking out */}
            <Box args={[0.2, 0.04, 0.06]} position={[0, 0.04, 0.12]} castShadow>
              <meshStandardMaterial color={skin.hairColor} />
            </Box>
          </group>
        )}

        {skin.hatStyle === 'hood' && (
          <group>
            {/* Hood wrapping around face */}
            <Box args={[0.26, 0.24, 0.24]} position={[0, 0.08, -0.01]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            {/* Hood opening (cut-out illusion — skin-colored oval) */}
            <Box args={[0.14, 0.16, 0.02]} position={[0, 0.06, 0.12]} castShadow>
              <meshStandardMaterial color={skin.skinColor} />
            </Box>
            {/* Drawstrings */}
            <Box args={[0.02, 0.06, 0.02]} position={[-0.06, -0.04, 0.12]} castShadow>
              <meshStandardMaterial color={skin.hatBrim} />
            </Box>
            <Box args={[0.02, 0.06, 0.02]} position={[0.06, -0.04, 0.12]} castShadow>
              <meshStandardMaterial color={skin.hatBrim} />
            </Box>
          </group>
        )}

        {skin.hatStyle === 'chef' && (
          <group>
            {/* Chef hat base band */}
            <Box args={[0.26, 0.04, 0.24]} position={[0, 0.12, 0]} castShadow>
              <meshStandardMaterial color={skin.hatBrim} />
            </Box>
            {/* Chef hat tall poofy top */}
            <Box args={[0.22, 0.18, 0.2]} position={[0, 0.24, 0]} castShadow>
              <meshStandardMaterial color={skin.hatColor} />
            </Box>
            {/* Top puff */}
            <mesh position={[0, 0.35, 0]} castShadow>
              <sphereGeometry args={[0.12, 8, 8]} />
              <meshStandardMaterial color={skin.hatColor} />
            </mesh>
            {/* Beard */}
            <Box args={[0.18, 0.06, 0.06]} position={[0, -0.08, 0.09]} castShadow>
              <meshStandardMaterial color={skin.hairColor} />
            </Box>
            {/* Mustache */}
            <Box args={[0.12, 0.03, 0.02]} position={[0, -0.03, 0.11]} castShadow>
              <meshStandardMaterial color={skin.hairColor} />
            </Box>
          </group>
        )}

        {skin.hatStyle === 'none' && (
          /* Butters — blonde hair tuft */
          <Box args={[0.22, 0.06, 0.2]} position={[0, 0.13, 0]} castShadow>
            <meshStandardMaterial color={skin.hairColor} />
          </Box>
        )}

        {/* Thinking particles */}
        {isThinking && (
          <>
            <mesh position={[-0.15, 0.2, 0]}>
              <sphereGeometry args={[0.02]} />
              <meshBasicMaterial color="#3b82f6" transparent opacity={0.6} />
            </mesh>
            <mesh position={[-0.18, 0.26, 0]}>
              <sphereGeometry args={[0.03]} />
              <meshBasicMaterial color="#3b82f6" transparent opacity={0.5} />
            </mesh>
            <mesh position={[-0.22, 0.33, 0]}>
              <sphereGeometry args={[0.04]} />
              <meshBasicMaterial color="#3b82f6" transparent opacity={0.4} />
            </mesh>
          </>
        )}
      </group>

      {/* BODY */}
      <Box args={[bodyWidth, 0.25, bodyDepth]} position={[0, 0.125, 0]} castShadow>
        <meshStandardMaterial color={skin.shirtColor} />
      </Box>
      {/* Cartman yellow stripe / accent belt */}
      {skin.shirtAccent !== skin.shirtColor && (
        <Box args={[bodyWidth + 0.01, 0.04, bodyDepth + 0.01]} position={[0, 0.04, 0]} castShadow>
          <meshStandardMaterial color={skin.shirtAccent} />
        </Box>
      )}

      {/* ARMS */}
      <group ref={leftArmRef} position={[-(bodyWidth / 2 + 0.02), 0.18, 0]}>
        <Box args={[0.08, 0.2, 0.08]} position={[0, -0.1, 0]} castShadow>
          <meshStandardMaterial color={skin.shirtColor} />
        </Box>
        <Box args={[0.08, 0.06, 0.08]} position={[0, -0.23, 0]} castShadow>
          <meshStandardMaterial color={skin.skinColor} />
        </Box>
      </group>

      <group ref={rightArmRef} position={[(bodyWidth / 2 + 0.02), 0.18, 0]}>
        <Box args={[0.08, 0.2, 0.08]} position={[0, -0.1, 0]} castShadow>
          <meshStandardMaterial color={skin.shirtColor} />
        </Box>
        <Box args={[0.08, 0.06, 0.08]} position={[0, -0.23, 0]} castShadow>
          <meshStandardMaterial color={skin.skinColor} />
        </Box>
      </group>

      {/* LEGS */}
      <Box args={[0.09, 0.18, 0.09]} position={[-0.05, -0.09, 0]} castShadow>
        <meshStandardMaterial color={skin.pantsColor} />
      </Box>
      <Box args={[0.09, 0.18, 0.09]} position={[0.05, -0.09, 0]} castShadow>
        <meshStandardMaterial color={skin.pantsColor} />
      </Box>

      {/* SHOES */}
      <Box args={[0.09, 0.04, 0.12]} position={[-0.05, -0.2, 0.015]} castShadow>
        <meshStandardMaterial color={skin.shoeColor} />
      </Box>
      <Box args={[0.09, 0.04, 0.12]} position={[0.05, -0.2, 0.015]} castShadow>
        <meshStandardMaterial color={skin.shoeColor} />
      </Box>

      {/* Error sparks */}
      {isError && (
        <>
          <mesh position={[0.15, 0.3, 0]}>
            <boxGeometry args={[0.02, 0.02, 0.02]} />
            <meshBasicMaterial color="#ef4444" />
          </mesh>
          <mesh position={[-0.15, 0.25, 0]}>
            <boxGeometry args={[0.02, 0.02, 0.02]} />
            <meshBasicMaterial color="#f59e0b" />
          </mesh>
        </>
      )}
    </group>
  );
}
