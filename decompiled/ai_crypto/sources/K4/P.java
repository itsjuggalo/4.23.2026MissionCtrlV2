package K4;

import android.os.Build;
import android.view.SurfaceHolder;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class P implements SurfaceHolder.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0637s f3573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FlutterRenderer f3574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SurfaceHolder.Callback f3575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.m f3576d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f3578f;

    public interface c {
        void a();

        void b(FlutterRenderer flutterRenderer);

        void c();
    }

    public class e implements c {
        public e() {
        }

        @Override // K4.P.c
        public void a() {
            if (P.this.f3574b != null) {
                P.this.f3574b.i(P.this.f3576d);
            }
        }

        @Override // K4.P.c
        public void b(FlutterRenderer flutterRenderer) {
            if (P.this.f3574b != null) {
                P.this.f3574b.t(P.this.f3576d);
            }
            P.this.f3574b = flutterRenderer;
        }

        @Override // K4.P.c
        public void c() {
            P.this.f3573a.setAlpha(0.0f);
            if (P.this.f3574b != null) {
                P.this.f3574b.t(P.this.f3576d);
            }
            P.this.f3574b = null;
        }
    }

    public P(SurfaceHolder.Callback callback, C0637s c0637s, FlutterRenderer flutterRenderer) {
        boolean z7 = Build.VERSION.SDK_INT < 26;
        this.f3577e = z7;
        this.f3578f = z7 ? new e() : new d();
        this.f3575c = callback;
        this.f3574b = flutterRenderer;
        this.f3573a = c0637s;
        J4.b.f("SurfaceHolderCallbackCompat", "SurfaceHolderCallbackCompat()");
        if (z7) {
            c0637s.setAlpha(0.0f);
        }
    }

    public void d(FlutterRenderer flutterRenderer) {
        this.f3578f.b(flutterRenderer);
    }

    public void e() {
        this.f3578f.c();
    }

    public void f() {
        this.f3578f.a();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i7, int i8, int i9) {
        SurfaceHolder.Callback callback = this.f3575c;
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i7, i8, i9);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f3575c;
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SurfaceHolder.Callback callback = this.f3575c;
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
        J4.b.f("SurfaceHolderCallbackCompat", "SurfaceHolder.Callback2.surfaceRedrawNeeded()");
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        J4.b.f("SurfaceHolderCallbackCompat", "SurfaceHolder.Callback2.surfaceRedrawNeededAsync()");
        FlutterRenderer flutterRenderer = this.f3574b;
        if (flutterRenderer == null) {
            return;
        }
        flutterRenderer.i(new b(runnable));
    }

    public class a implements io.flutter.embedding.engine.renderer.m {
        public a() {
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void e() {
            J4.b.f("SurfaceHolderCallbackCompat", "onFlutterUiDisplayed()");
            P.this.f3573a.setAlpha(1.0f);
            if (P.this.f3574b != null) {
                P.this.f3574b.t(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void c() {
        }
    }

    public class b implements io.flutter.embedding.engine.renderer.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f3580a;

        public b(Runnable runnable) {
            this.f3580a = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void e() {
            this.f3580a.run();
            if (P.this.f3574b != null) {
                P.this.f3574b.t(this);
            }
        }

        @Override // io.flutter.embedding.engine.renderer.m
        public void c() {
        }
    }

    public class d implements c {
        public d() {
        }

        @Override // K4.P.c
        public void b(FlutterRenderer flutterRenderer) {
            P.this.f3574b = flutterRenderer;
        }

        @Override // K4.P.c
        public void c() {
            P.this.f3574b = null;
        }

        @Override // K4.P.c
        public void a() {
        }
    }
}
