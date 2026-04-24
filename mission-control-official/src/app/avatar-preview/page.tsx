'use client';
import { useEffect, useRef, useState } from 'react';

export default function AvatarPreview() {
  const mountRef = useRef<HTMLDivElement>(null);
  const [status, setStatus] = useState('Loading 3D model…');
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    if (!mountRef.current) return;

    let renderer: any, animId: number;

    (async () => {
      try {
        const THREE = await import('three');
        const { OBJLoader } = await import('three/examples/jsm/loaders/OBJLoader.js');
        const { MTLLoader } = await import('three/examples/jsm/loaders/MTLLoader.js');
        const { OrbitControls } = await import('three/examples/jsm/controls/OrbitControls.js');

        const W = mountRef.current!.clientWidth || 600;
        const H = mountRef.current!.clientHeight || 600;

        // Scene
        const scene = new THREE.Scene();
        scene.background = new THREE.Color(0x0a0a12);

        // Camera
        const camera = new THREE.PerspectiveCamera(45, W / H, 0.01, 1000);
        camera.position.set(0, 4, 8);

        // Renderer
        renderer = new THREE.WebGLRenderer({ antialias: true });
        renderer.setSize(W, H);
        renderer.setPixelRatio(window.devicePixelRatio);
        renderer.shadowMap.enabled = true;
        mountRef.current!.appendChild(renderer.domElement);

        // Lights
        const ambient = new THREE.AmbientLight(0xffffff, 0.8);
        scene.add(ambient);
        const dir = new THREE.DirectionalLight(0xffffff, 1.2);
        dir.position.set(5, 10, 7);
        dir.castShadow = true;
        scene.add(dir);
        const fill = new THREE.DirectionalLight(0x8888ff, 0.4);
        fill.position.set(-5, 2, -5);
        scene.add(fill);

        // Controls
        const controls = new OrbitControls(camera, renderer.domElement);
        controls.enableDamping = true;
        controls.dampingFactor = 0.05;
        controls.minDistance = 2;
        controls.maxDistance = 20;
        controls.target.set(0, 3, 0);

        // Load MTL then OBJ
        setStatus('Loading textures…');
        const mtlLoader = new MTLLoader();
        mtlLoader.setPath('/avatars/');

        const materials = await new Promise<any>((res, rej) =>
          mtlLoader.load('eric-cartman.mtl', res, undefined, rej)
        );
        materials.preload();

        setStatus('Loading model…');
        const objLoader = new OBJLoader();
        objLoader.setMaterials(materials);
        objLoader.setPath('/avatars/');

        const obj = await new Promise<any>((res, rej) =>
          objLoader.load('eric-cartman.obj', res, (e: any) => {
            setStatus(`Loading… ${Math.round((e.loaded / e.total) * 100)}%`);
          }, rej)
        );

        // Center and scale
        const box = new THREE.Box3().setFromObject(obj);
        const center = box.getCenter(new THREE.Vector3());
        const size = box.getSize(new THREE.Vector3());
        const maxDim = Math.max(size.x, size.y, size.z);
        const scale = 5 / maxDim;
        obj.scale.setScalar(scale);
        obj.position.sub(center.multiplyScalar(scale));
        obj.position.y += 1;

        obj.traverse((child: any) => {
          if (child.isMesh) {
            child.castShadow = true;
            child.receiveShadow = true;
          }
        });

        scene.add(obj);
        setStatus('');

        // Slow auto-rotate
        let angle = 0;
        const animate = () => {
          animId = requestAnimationFrame(animate);
          angle += 0.005;
          obj.rotation.y = angle;
          controls.update();
          renderer.render(scene, camera);
        };
        animate();

        // Resize
        const onResize = () => {
          const w = mountRef.current?.clientWidth || W;
          const h = mountRef.current?.clientHeight || H;
          camera.aspect = w / h;
          camera.updateProjectionMatrix();
          renderer.setSize(w, h);
        };
        window.addEventListener('resize', onResize);

      } catch (e: any) {
        console.error(e);
        setError(e.message || 'Failed to load model');
        setStatus('');
      }
    })();

    return () => {
      cancelAnimationFrame(animId);
      renderer?.dispose();
      if (mountRef.current) {
        mountRef.current.innerHTML = '';
      }
    };
  }, []);

  return (
    <div className="min-h-screen bg-[#0a0a12] flex flex-col items-center justify-center p-6">
      <div className="mb-4 text-center">
        <h1 className="text-2xl font-bold text-[#f0f0f0]">Eric Cartman — Signal Filter</h1>
        <p className="text-sm text-[#555] mt-1">Drag to rotate · Scroll to zoom · Auto-rotating</p>
      </div>

      <div className="relative rounded-xl overflow-hidden border border-[#1e1e2a] shadow-2xl" style={{ width: 600, height: 600 }}>
        <div ref={mountRef} style={{ width: '100%', height: '100%' }} />

        {status && (
          <div className="absolute inset-0 flex items-center justify-center bg-[#0a0a12]/80">
            <div className="text-center">
              <div className="w-8 h-8 border-2 border-amber-400 border-t-transparent rounded-full animate-spin mx-auto mb-3" />
              <p className="text-sm text-amber-400">{status}</p>
            </div>
          </div>
        )}

        {error && (
          <div className="absolute inset-0 flex items-center justify-center bg-[#0a0a12]/90">
            <div className="text-center max-w-xs">
              <p className="text-red-400 text-sm font-medium mb-2">⚠️ 3D load failed</p>
              <p className="text-[#555] text-xs">{error}</p>
              <img src="/avatars/eric-shirt.png" alt="Eric fallback" className="mt-4 mx-auto h-32 object-contain opacity-60" />
            </div>
          </div>
        )}
      </div>

      <div className="mt-4 text-xs text-[#333] text-center">
        Textures: hat · skin · shirt · pants · eyes · mouth · chin<br />
        Files: eric-cartman.obj + eric-cartman.mtl
      </div>
    </div>
  );
}
