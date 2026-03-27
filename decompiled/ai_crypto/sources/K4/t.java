package K4;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class t extends TextureView implements io.flutter.embedding.engine.renderer.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterRenderer f3640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Surface f3641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextureView.SurfaceTextureListener f3642e;

    public t(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i7, int i8) {
        if (this.f3640c == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        J4.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i7 + " x " + i8);
        this.f3640c.B(i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f3640c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f3641d;
        if (surface != null) {
            surface.release();
            this.f3641d = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f3641d = surface2;
        this.f3640c.z(surface2, this.f3639b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FlutterRenderer flutterRenderer = this.f3640c;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
        Surface surface = this.f3641d;
        if (surface != null) {
            surface.release();
            this.f3641d = null;
        }
    }

    private void o() {
        setSurfaceTextureListener(this.f3642e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return (this.f3640c == null || this.f3639b) ? false : true;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void a() {
        if (this.f3640c == null) {
            J4.b.g("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (p()) {
            J4.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m();
        }
        this.f3639b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void b(FlutterRenderer flutterRenderer) {
        J4.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f3640c != null) {
            J4.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f3640c.A();
        }
        this.f3640c = flutterRenderer;
        a();
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void c() {
        if (this.f3640c == null) {
            J4.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f3639b = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public void d() {
        if (this.f3640c == null) {
            J4.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            J4.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            n();
        }
        this.f3640c = null;
    }

    @Override // io.flutter.embedding.engine.renderer.n
    public FlutterRenderer getAttachedRenderer() {
        return this.f3640c;
    }

    public boolean p() {
        return this.f3638a;
    }

    public void setRenderSurface(Surface surface) {
        this.f3641d = surface;
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3638a = false;
        this.f3639b = false;
        this.f3642e = new a();
        o();
    }

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i7, int i8) {
            J4.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            t.this.f3638a = true;
            if (t.this.q()) {
                t.this.m();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            J4.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            t.this.f3638a = false;
            if (t.this.q()) {
                t.this.n();
            }
            if (t.this.f3641d == null) {
                return true;
            }
            t.this.f3641d.release();
            t.this.f3641d = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i7, int i8) {
            J4.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (t.this.q()) {
                t.this.l(i7, i8);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
