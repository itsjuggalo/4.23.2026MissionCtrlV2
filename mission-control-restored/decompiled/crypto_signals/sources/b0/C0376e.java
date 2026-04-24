package b0;

import P3.u;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.view.Surface;
import e3.w;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: b0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0376e implements AutoCloseable, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public w f4825A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public C0372a f4826B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int f4827C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f4829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f4830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f4831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4832d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f4833f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f4834k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f4835l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f4836m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f4837n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f4838o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f4839p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f4840q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4841r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f4842s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f4843t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ByteBuffer f4844u;
    public final C0375d y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SurfaceTexture f4848z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f4845v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList f4846w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f4847x = new ArrayList();

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final float[] f4828D = new float[16];

    public C0376e(int i, int i6, int i7, Handler handler, u uVar) throws IOException {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z6;
        int i8;
        int i9;
        int i10;
        int iGlCreateProgram;
        int iC;
        boolean z7 = false;
        if (i < 0 || i6 < 0 || i7 < 0 || i7 > 100) {
            throw new IllegalArgumentException("invalid encoder inputs");
        }
        int i11 = 512;
        boolean z8 = i > 512 || i6 > 512;
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("image/vnd.android.heic");
            this.f4829a = mediaCodecCreateEncoderByType;
            capabilitiesForType = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType("image/vnd.android.heic");
            if (!capabilitiesForType.getVideoCapabilities().isSizeSupported(i, i6)) {
                this.f4829a.release();
                this.f4829a = null;
                throw new Exception();
            }
            z6 = true;
        } catch (Exception unused) {
            MediaCodec mediaCodecCreateEncoderByType2 = MediaCodec.createEncoderByType("video/hevc");
            this.f4829a = mediaCodecCreateEncoderByType2;
            capabilitiesForType = mediaCodecCreateEncoderByType2.getCodecInfo().getCapabilitiesForType("video/hevc");
            z8 |= !capabilitiesForType.getVideoCapabilities().isSizeSupported(i, i6);
            z6 = false;
        }
        this.f4832d = 2;
        this.f4830b = uVar;
        Looper looper = handler.getLooper();
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
            handlerThread.start();
            looper = handlerThread.getLooper();
        }
        Handler handler2 = new Handler(looper);
        this.f4831c = handler2;
        this.e = i;
        this.f4833f = i6;
        this.f4839p = z8;
        if (z8) {
            i9 = (i + 511) / 512;
            i10 = (i6 + 511) / 512;
            i8 = 512;
        } else {
            i11 = i;
            i8 = i6;
            i9 = 1;
            i10 = 1;
        }
        MediaFormat mediaFormatCreateVideoFormat = z6 ? MediaFormat.createVideoFormat("image/vnd.android.heic", i, i6) : MediaFormat.createVideoFormat("video/hevc", i11, i8);
        if (z8) {
            mediaFormatCreateVideoFormat.setInteger("tile-width", i11);
            mediaFormatCreateVideoFormat.setInteger("tile-height", i8);
            mediaFormatCreateVideoFormat.setInteger("grid-cols", i9);
            mediaFormatCreateVideoFormat.setInteger("grid-rows", i10);
        }
        if (z6) {
            this.f4834k = i;
            this.f4835l = i6;
            this.f4836m = 1;
            this.f4837n = 1;
        } else {
            this.f4834k = i11;
            this.f4835l = i8;
            this.f4836m = i10;
            this.f4837n = i9;
        }
        int i12 = this.f4836m * this.f4837n;
        this.f4838o = i12;
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 0);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", i12);
        mediaFormatCreateVideoFormat.setInteger("capture-rate", i12 * 30);
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
        if (encoderCapabilities.isBitrateModeSupported(0)) {
            Log.d("HeifEncoder", "Setting bitrate mode to constant quality");
            Range qualityRange = encoderCapabilities.getQualityRange();
            Log.d("HeifEncoder", "Quality range: " + qualityRange);
            mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 0);
            mediaFormatCreateVideoFormat.setInteger("quality", (int) ((((double) ((((Integer) qualityRange.getUpper()).intValue() - ((Integer) qualityRange.getLower()).intValue()) * i7)) / 100.0d) + ((double) ((Integer) qualityRange.getLower()).intValue())));
        } else {
            if (encoderCapabilities.isBitrateModeSupported(2)) {
                Log.d("HeifEncoder", "Setting bitrate mode to constant bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 2);
            } else {
                Log.d("HeifEncoder", "Setting bitrate mode to variable bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 1);
            }
            mediaFormatCreateVideoFormat.setInteger("bitrate", (int) (((((((double) (i * i6)) * 1.5d) * 8.0d) * 0.25d) * ((double) i7)) / 100.0d));
        }
        this.f4829a.setCallback(new C0374c(this), handler2);
        this.f4829a.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        Surface surfaceCreateInputSurface = this.f4829a.createInputSurface();
        this.y = new C0375d(this, true);
        w wVar = new w(14, z7);
        wVar.f6191b = EGL14.EGL_NO_DISPLAY;
        wVar.f6192c = EGL14.EGL_NO_CONTEXT;
        wVar.f6193d = EGL14.EGL_NO_SURFACE;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        surfaceCreateInputSurface.getClass();
        wVar.e = surfaceCreateInputSurface;
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        wVar.f6191b = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize((EGLDisplay) wVar.f6191b, iArr, 0, iArr, 1)) {
            wVar.f6191b = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if (!EGL14.eglChooseConfig((EGLDisplay) wVar.f6191b, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        wVar.f6192c = EGL14.eglCreateContext((EGLDisplay) wVar.f6191b, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        w.h("eglCreateContext");
        if (((EGLContext) wVar.f6192c) == null) {
            throw new RuntimeException("null context");
        }
        wVar.f6193d = EGL14.eglCreateWindowSurface((EGLDisplay) wVar.f6191b, eGLConfigArr[0], (Surface) wVar.e, new int[]{12344}, 0);
        w.h("eglCreateWindowSurface");
        EGLSurface eGLSurface = (EGLSurface) wVar.f6193d;
        if (eGLSurface == null) {
            throw new RuntimeException("surface was null");
        }
        EGL14.eglQuerySurface((EGLDisplay) wVar.f6191b, eGLSurface, 12375, new int[1], 0);
        EGL14.eglQuerySurface((EGLDisplay) wVar.f6191b, (EGLSurface) wVar.f6193d, 12374, new int[1], 0);
        this.f4825A = wVar;
        wVar.A();
        C0378g c0378g = new C0378g();
        c0378g.f4866f = 3553;
        int iC2 = C0378g.c(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n");
        if (iC2 == 0 || (iC = C0378g.c(35632, "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n")) == 0) {
            iGlCreateProgram = 0;
        } else {
            iGlCreateProgram = GLES20.glCreateProgram();
            C0378g.a("glCreateProgram");
            if (iGlCreateProgram == 0) {
                Log.e("Texture2dProgram", "Could not create program");
            }
            GLES20.glAttachShader(iGlCreateProgram, iC2);
            C0378g.a("glAttachShader");
            GLES20.glAttachShader(iGlCreateProgram, iC);
            C0378g.a("glAttachShader");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr2 = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
            if (iArr2[0] != 1) {
                Log.e("Texture2dProgram", "Could not link program: ");
                Log.e("Texture2dProgram", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                iGlCreateProgram = 0;
            }
        }
        c0378g.f4862a = iGlCreateProgram;
        if (iGlCreateProgram == 0) {
            throw new RuntimeException("Unable to create program");
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(iGlCreateProgram, "aPosition");
        c0378g.f4865d = iGlGetAttribLocation;
        C0378g.b(iGlGetAttribLocation, "aPosition");
        int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(c0378g.f4862a, "aTextureCoord");
        c0378g.e = iGlGetAttribLocation2;
        C0378g.b(iGlGetAttribLocation2, "aTextureCoord");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(c0378g.f4862a, "uMVPMatrix");
        c0378g.f4863b = iGlGetUniformLocation;
        C0378g.b(iGlGetUniformLocation, "uMVPMatrix");
        int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(c0378g.f4862a, "uTexMatrix");
        c0378g.f4864c = iGlGetUniformLocation2;
        C0378g.b(iGlGetUniformLocation2, "uTexMatrix");
        C0372a c0372a = new C0372a(c0378g, i, i6);
        this.f4826B = c0372a;
        C0378g c0378g2 = c0372a.e;
        c0378g2.getClass();
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        C0378g.a("glGenTextures");
        int i13 = iArr3[0];
        int i14 = c0378g2.f4866f;
        GLES20.glBindTexture(i14, i13);
        C0378g.a("glBindTexture " + i13);
        GLES20.glTexParameterf(i14, 10241, 9728.0f);
        GLES20.glTexParameterf(i14, 10240, i14 != 3553 ? 9729.0f : 9728.0f);
        GLES20.glTexParameteri(i14, 10242, 33071);
        GLES20.glTexParameteri(i14, 10243, 33071);
        C0378g.a("glTexParameter");
        this.f4827C = i13;
        this.f4825A.C();
        this.f4843t = new Rect(0, 0, this.f4834k, this.f4835l);
        this.f4842s = new Rect();
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f4845v) {
            this.f4841r = true;
            this.f4845v.notifyAll();
        }
        this.f4831c.postAtFrontOfQueue(new RunnableC0373b(this, 1));
    }

    public final void d(Bitmap bitmap) {
        if (this.f4832d != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        }
        if (this.y.b(f(this.f4840q) * 1000, f((this.f4840q + this.f4838o) - 1))) {
            synchronized (this) {
                try {
                    w wVar = this.f4825A;
                    if (wVar == null) {
                        return;
                    }
                    wVar.A();
                    C0372a c0372a = this.f4826B;
                    int i = this.f4827C;
                    int i6 = c0372a.e.f4866f;
                    GLES20.glBindTexture(i6, i);
                    GLUtils.texImage2D(i6, 0, bitmap, 0);
                    g();
                    this.f4825A.C();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final long f(int i) {
        return ((((long) i) * 1000000) / ((long) this.f4838o)) + 132;
    }

    public final void g() {
        int i = this.f4834k;
        int i6 = this.f4835l;
        GLES20.glViewport(0, 0, i, i6);
        for (int i7 = 0; i7 < this.f4836m; i7++) {
            for (int i8 = 0; i8 < this.f4837n; i8++) {
                int i9 = i8 * i;
                int i10 = i7 * i6;
                Rect rect = this.f4842s;
                rect.set(i9, i10, i9 + i, i10 + i6);
                C0372a c0372a = this.f4826B;
                float[] fArr = C0378g.f4861h;
                c0372a.getClass();
                float f6 = rect.left;
                float f7 = c0372a.f4812c;
                float f8 = f6 / f7;
                float[] fArr2 = c0372a.f4810a;
                fArr2[0] = f8;
                float f9 = rect.bottom;
                float f10 = c0372a.f4813d;
                float f11 = 1.0f - (f9 / f10);
                fArr2[1] = f11;
                float f12 = rect.right / f7;
                fArr2[2] = f12;
                fArr2[3] = f11;
                fArr2[4] = f8;
                float f13 = 1.0f - (rect.top / f10);
                fArr2[5] = f13;
                fArr2[6] = f12;
                fArr2[7] = f13;
                FloatBuffer floatBuffer = c0372a.f4811b;
                floatBuffer.put(fArr2);
                floatBuffer.position(0);
                C0378g c0378g = c0372a.e;
                float[] fArr3 = C0378g.f4860g;
                c0378g.getClass();
                C0378g.a("draw start");
                GLES20.glUseProgram(c0378g.f4862a);
                C0378g.a("glUseProgram");
                GLES20.glActiveTexture(33984);
                int i11 = c0378g.f4866f;
                GLES20.glBindTexture(i11, this.f4827C);
                GLES20.glUniformMatrix4fv(c0378g.f4863b, 1, false, fArr3, 0);
                C0378g.a("glUniformMatrix4fv");
                GLES20.glUniformMatrix4fv(c0378g.f4864c, 1, false, fArr, 0);
                C0378g.a("glUniformMatrix4fv");
                int i12 = c0378g.f4865d;
                GLES20.glEnableVertexAttribArray(i12);
                C0378g.a("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(c0378g.f4865d, 2, 5126, false, 8, (Buffer) C0372a.f4809f);
                C0378g.a("glVertexAttribPointer");
                int i13 = c0378g.e;
                GLES20.glEnableVertexAttribArray(i13);
                C0378g.a("glEnableVertexAttribArray");
                GLES20.glVertexAttribPointer(c0378g.e, 2, 5126, false, 8, (Buffer) c0372a.f4811b);
                C0378g.a("glVertexAttribPointer");
                GLES20.glDrawArrays(5, 0, 4);
                C0378g.a("glDrawArrays");
                GLES20.glDisableVertexAttribArray(i12);
                GLES20.glDisableVertexAttribArray(i13);
                GLES20.glBindTexture(i11, 0);
                GLES20.glUseProgram(0);
                w wVar = this.f4825A;
                int i14 = this.f4840q;
                this.f4840q = i14 + 1;
                EGLExt.eglPresentationTimeANDROID((EGLDisplay) wVar.f6191b, (EGLSurface) wVar.f6193d, f(i14) * 1000);
                w wVar2 = this.f4825A;
                EGL14.eglSwapBuffers((EGLDisplay) wVar2.f6191b, (EGLSurface) wVar2.f6193d);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0178, code lost:
    
        throw new java.lang.IllegalArgumentException("src and dst rect size are different!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instruction units count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.C0376e.h():void");
    }

    public final void i() {
        ByteBuffer byteBuffer;
        int i = this.f4832d;
        if (i == 2) {
            C0375d c0375d = this.y;
            synchronized (c0375d) {
                try {
                    if (c0375d.f4818a) {
                        if (c0375d.f4819b < 0) {
                            c0375d.f4819b = 0L;
                        }
                    } else if (c0375d.f4821d < 0) {
                        c0375d.f4821d = 0L;
                    }
                    c0375d.a();
                } finally {
                }
            }
            return;
        }
        if (i == 0) {
            synchronized (this.f4845v) {
                while (!this.f4841r && this.f4845v.isEmpty()) {
                    try {
                        this.f4845v.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                byteBuffer = this.f4841r ? null : (ByteBuffer) this.f4845v.remove(0);
            }
            if (byteBuffer == null) {
                return;
            }
            byteBuffer.clear();
            byteBuffer.flip();
            synchronized (this.f4846w) {
                this.f4846w.add(byteBuffer);
            }
            this.f4831c.post(new RunnableC0373b(this, 0));
        }
    }

    public final void j() {
        MediaCodec mediaCodec = this.f4829a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f4829a.release();
            this.f4829a = null;
        }
        synchronized (this.f4845v) {
            this.f4841r = true;
            this.f4845v.notifyAll();
        }
        synchronized (this) {
            try {
                C0372a c0372a = this.f4826B;
                if (c0372a != null) {
                    if (c0372a.e != null) {
                        c0372a.e = null;
                    }
                    this.f4826B = null;
                }
                w wVar = this.f4825A;
                if (wVar != null) {
                    wVar.I();
                    this.f4825A = null;
                }
                SurfaceTexture surfaceTexture = this.f4848z;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.f4848z = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            try {
                w wVar = this.f4825A;
                if (wVar == null) {
                    return;
                }
                wVar.A();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.f4828D);
                if (this.y.b(surfaceTexture.getTimestamp(), f((this.f4840q + this.f4838o) - 1))) {
                    g();
                }
                surfaceTexture.releaseTexImage();
                this.f4825A.C();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
