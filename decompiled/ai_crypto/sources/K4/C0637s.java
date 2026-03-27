package K4;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: renamed from: K4.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0637s extends SurfaceView implements io.flutter.embedding.engine.renderer.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterRenderer f3634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final P f3635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SurfaceHolder.Callback f3636f;

    /* JADX INFO: renamed from: K4.s$a */
    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i7, int i8, int i9) {
            J4.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (C0637s.this.o()) {
                C0637s.this.j(i8, i9);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            J4.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            C0637s.this.f3632b = true;
            if (C0637s.this.o()) {
                C0637s.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            J4.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            C0637s.this.f3632b = false;
            if (C0637s.this.o()) {
                C0637s.this.l();
            }
        }
    }

    public C0637s(Context context, boolean z7) {
        this(context, null, z7);
    }

    private void m() {
        if (this.f3631a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f3635e);
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void a() {
        if (this.f3634d == null) {
            J4.b.g("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f3635e.f();
        if (n()) {
            J4.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
        this.f3633c = false;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void b(FlutterRenderer flutterRenderer) {
        J4.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f3634d != null) {
            J4.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f3634d.A();
        }
        this.f3634d = flutterRenderer;
        this.f3635e.d(flutterRenderer);
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void c() {
        if (this.f3634d == null) {
            J4.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f3633c = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void d() {
        J4.b.f("FlutterSurfaceView", "Detaching from FlutterRenderer.");
        if (this.f3634d == null) {
            J4.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            J4.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        this.f3635e.e();
        this.f3634d = null;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i7 = iArr[0];
        region.op(i7, iArr[1], (getRight() + i7) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public FlutterRenderer getAttachedRenderer() {
        return this.f3634d;
    }

    public final void j(int i7, int i8) {
        if (this.f3634d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        J4.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i7 + " x " + i8);
        this.f3634d.B(i7, i8);
    }

    public final void k() {
        if (this.f3634d == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f3634d.z(getHolder().getSurface(), this.f3633c);
    }

    public final void l() {
        FlutterRenderer flutterRenderer = this.f3634d;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
    }

    public boolean n() {
        return this.f3632b;
    }

    public final boolean o() {
        return (this.f3634d == null || this.f3633c) ? false : true;
    }

    public C0637s(Context context, AttributeSet attributeSet, boolean z7) {
        super(context, attributeSet);
        this.f3632b = false;
        this.f3633c = false;
        a aVar = new a();
        this.f3636f = aVar;
        this.f3631a = z7;
        this.f3635e = new P(aVar, this, this.f3634d);
        m();
    }
}
