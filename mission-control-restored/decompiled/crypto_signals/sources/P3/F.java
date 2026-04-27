package P3;

import android.os.Build;
import android.view.SurfaceHolder;

/* JADX INFO: loaded from: classes.dex */
public final class F implements SurfaceHolder.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.k f2515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0230e f2517d = new C0230e(this, 2);
    public final E e;

    public F(i iVar, j jVar, io.flutter.embedding.engine.renderer.k kVar) {
        boolean z6 = Build.VERSION.SDK_INT < 26;
        this.e = z6 ? new Q3.h(this, 16) : new E.l(this, 15);
        this.f2516c = iVar;
        this.f2515b = kVar;
        this.f2514a = jVar;
        if (z6) {
            jVar.setAlpha(0.0f);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i6, int i7) {
        i iVar = this.f2516c;
        if (iVar != null) {
            iVar.surfaceChanged(surfaceHolder, i, i6, i7);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        i iVar = this.f2516c;
        if (iVar != null) {
            iVar.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        i iVar = this.f2516c;
        if (iVar != null) {
            iVar.surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        io.flutter.embedding.engine.renderer.k kVar = this.f2515b;
        if (kVar == null) {
            return;
        }
        kVar.a(new D(this, runnable));
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }
}
