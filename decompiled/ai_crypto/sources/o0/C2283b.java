package o0;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: renamed from: o0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2283b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EGLDisplay f19920a = EGL14.EGL_NO_DISPLAY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EGLContext f19921b = EGL14.EGL_NO_CONTEXT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EGLSurface f19922c = EGL14.EGL_NO_SURFACE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EGLConfig[] f19923d = new EGLConfig[1];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Surface f19924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19926g;

    public C2283b(Surface surface) {
        surface.getClass();
        this.f19924e = surface;
        c();
    }

    public final void a(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public final void b() {
        this.f19922c = EGL14.eglCreateWindowSurface(this.f19920a, this.f19923d[0], this.f19924e, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (this.f19922c == null) {
            throw new RuntimeException("surface was null");
        }
    }

    public final void c() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.f19920a = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f19920a, iArr, 0, iArr, 1)) {
            this.f19920a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLDisplay eGLDisplay = this.f19920a;
        EGLConfig[] eGLConfigArr = this.f19923d;
        if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.f19921b = EGL14.eglCreateContext(this.f19920a, this.f19923d[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        a("eglCreateContext");
        if (this.f19921b == null) {
            throw new RuntimeException("null context");
        }
        b();
        this.f19925f = e();
        this.f19926g = d();
    }

    public int d() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f19920a, this.f19922c, 12374, iArr, 0);
        return iArr[0];
    }

    public int e() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f19920a, this.f19922c, 12375, iArr, 0);
        return iArr[0];
    }

    public void f() {
        EGLDisplay eGLDisplay = this.f19920a;
        EGLSurface eGLSurface = this.f19922c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f19921b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void g() {
        EGLDisplay eGLDisplay = this.f19920a;
        EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h() {
        if (!Objects.equals(this.f19920a, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglDestroySurface(this.f19920a, this.f19922c);
            EGL14.eglDestroyContext(this.f19920a, this.f19921b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f19920a);
        }
        this.f19924e.release();
        this.f19920a = EGL14.EGL_NO_DISPLAY;
        this.f19921b = EGL14.EGL_NO_CONTEXT;
        this.f19922c = EGL14.EGL_NO_SURFACE;
        this.f19924e = null;
    }

    public void i(long j7) {
        EGLExt.eglPresentationTimeANDROID(this.f19920a, this.f19922c, j7);
    }

    public boolean j() {
        return EGL14.eglSwapBuffers(this.f19920a, this.f19922c);
    }
}
