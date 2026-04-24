package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* JADX INFO: loaded from: classes2.dex */
public class a0 implements InterfaceC2018o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextureRegistry.SurfaceTextureEntry f16726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f16727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f16728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16729d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16730e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f16731f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextureRegistry.b f16732g;

    public class a implements TextureRegistry.b {
        public a() {
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i7) {
            if (i7 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            a0.this.f16731f = true;
        }
    }

    public a0(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        a aVar = new a();
        this.f16732g = aVar;
        this.f16726a = surfaceTextureEntry;
        this.f16727b = surfaceTextureEntry.surfaceTexture();
        surfaceTextureEntry.setOnTrimMemoryListener(aVar);
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void a(int i7, int i8) {
        this.f16729d = i7;
        this.f16730e = i8;
        SurfaceTexture surfaceTexture = this.f16727b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i7, i8);
        }
    }

    public Surface c() {
        return new Surface(this.f16727b);
    }

    public final void d() {
        Surface surface = this.f16728c;
        if (surface == null || this.f16731f) {
            if (surface != null) {
                surface.release();
                this.f16728c = null;
            }
            this.f16728c = c();
            this.f16731f = false;
        }
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getHeight() {
        return this.f16730e;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public long getId() {
        return this.f16726a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public Surface getSurface() {
        d();
        SurfaceTexture surfaceTexture = this.f16727b;
        if (surfaceTexture == null || surfaceTexture.isReleased()) {
            return null;
        }
        return this.f16728c;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getWidth() {
        return this.f16729d;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void release() {
        this.f16727b = null;
        Surface surface = this.f16728c;
        if (surface != null) {
            surface.release();
            this.f16728c = null;
        }
    }
}
