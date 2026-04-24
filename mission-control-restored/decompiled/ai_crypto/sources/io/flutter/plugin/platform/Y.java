package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;

/* JADX INFO: loaded from: classes2.dex */
public class Y implements InterfaceC2018o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextureRegistry.SurfaceProducer f16724a;

    public Y(TextureRegistry.SurfaceProducer surfaceProducer) {
        this.f16724a = surfaceProducer;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void a(int i7, int i8) {
        this.f16724a.setSize(i7, i8);
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getHeight() {
        return this.f16724a.getHeight();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public long getId() {
        return this.f16724a.id();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public Surface getSurface() {
        return this.f16724a.getSurface();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public int getWidth() {
        return this.f16724a.getWidth();
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void release() {
        this.f16724a.release();
        this.f16724a = null;
    }

    @Override // io.flutter.plugin.platform.InterfaceC2018o
    public void scheduleFrame() {
        this.f16724a.scheduleFrame();
    }
}
