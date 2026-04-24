package o0;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: renamed from: o0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2285d implements AutoCloseable, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public C2282a f19927A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f19928B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f19930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f19931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerThread f19932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f19933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f19936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f19937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f19938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f19939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f19940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f19941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f19942m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f19943n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19944o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f19945p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f19946q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ByteBuffer f19947r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f19951v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SurfaceTexture f19952w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Surface f19953x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Surface f19954y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public C2283b f19955z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f19948s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f19949t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f19950u = new ArrayList();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final float[] f19929C = new float[16];

    /* JADX INFO: renamed from: o0.d$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2285d.this.O();
        }
    }

    /* JADX INFO: renamed from: o0.d$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2285d.this.c0();
        }
    }

    /* JADX INFO: renamed from: o0.d$c */
    public static abstract class c {
        public abstract void a(C2285d c2285d);

        public abstract void b(C2285d c2285d, ByteBuffer byteBuffer);

        public abstract void c(C2285d c2285d, MediaCodec.CodecException codecException);

        public abstract void d(C2285d c2285d, MediaFormat mediaFormat);
    }

    /* JADX INFO: renamed from: o0.d$d, reason: collision with other inner class name */
    public class C0329d extends MediaCodec.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19958a;

        public C0329d() {
        }

        public final void a(MediaCodec.CodecException codecException) {
            C2285d.this.c0();
            if (codecException == null) {
                C2285d c2285d = C2285d.this;
                c2285d.f19931b.a(c2285d);
            } else {
                C2285d c2285d2 = C2285d.this;
                c2285d2.f19931b.c(c2285d2, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec != C2285d.this.f19930a) {
                return;
            }
            Log.e("HeifEncoder", "onError: " + codecException);
            a(codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i7) {
            C2285d c2285d = C2285d.this;
            if (mediaCodec != c2285d.f19930a || c2285d.f19944o) {
                return;
            }
            c2285d.f19950u.add(Integer.valueOf(i7));
            C2285d.this.O();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i7, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec != C2285d.this.f19930a || this.f19958a) {
                return;
            }
            if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i7);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                e eVar = C2285d.this.f19951v;
                if (eVar != null) {
                    eVar.e(bufferInfo.presentationTimeUs);
                }
                C2285d c2285d = C2285d.this;
                c2285d.f19931b.b(c2285d, outputBuffer);
            }
            this.f19958a = ((bufferInfo.flags & 4) != 0) | this.f19958a;
            mediaCodec.releaseOutputBuffer(i7, false);
            if (this.f19958a) {
                a(null);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec != C2285d.this.f19930a) {
                return;
            }
            if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
                mediaFormat.setString("mime", "image/vnd.android.heic");
                mediaFormat.setInteger("width", C2285d.this.f19935f);
                mediaFormat.setInteger("height", C2285d.this.f19936g);
                C2285d c2285d = C2285d.this;
                if (c2285d.f19942m) {
                    mediaFormat.setInteger("tile-width", c2285d.f19937h);
                    mediaFormat.setInteger("tile-height", C2285d.this.f19938i);
                    mediaFormat.setInteger("grid-rows", C2285d.this.f19939j);
                    mediaFormat.setInteger("grid-cols", C2285d.this.f19940k);
                }
            }
            C2285d c2285d2 = C2285d.this;
            c2285d2.f19931b.d(c2285d2, mediaFormat);
        }
    }

    /* JADX INFO: renamed from: o0.d$e */
    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f19960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19961b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f19962c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19963d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f19964e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f19965f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19966g;

        /* JADX INFO: renamed from: o0.d$e$a */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaCodec mediaCodec = C2285d.this.f19930a;
                if (mediaCodec != null) {
                    mediaCodec.signalEndOfInputStream();
                }
            }
        }

        public e(boolean z7) {
            this.f19960a = z7;
        }

        public final void a() {
            C2285d.this.f19933d.post(new a());
            this.f19966g = true;
        }

        public final void b() {
            if (this.f19966g) {
                return;
            }
            if (this.f19963d < 0) {
                long j7 = this.f19961b;
                if (j7 >= 0 && this.f19962c >= j7) {
                    long j8 = this.f19964e;
                    if (j8 < 0) {
                        a();
                        return;
                    }
                    this.f19963d = j8;
                }
            }
            long j9 = this.f19963d;
            if (j9 < 0 || j9 > this.f19965f) {
                return;
            }
            a();
        }

        public synchronized void c(long j7) {
            try {
                if (this.f19960a) {
                    if (this.f19961b < 0) {
                        this.f19961b = j7;
                    }
                } else if (this.f19963d < 0) {
                    this.f19963d = j7 / 1000;
                }
                b();
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean d(long j7, long j8) {
            boolean z7;
            try {
                long j9 = this.f19961b;
                z7 = j9 < 0 || j7 <= j9;
                if (z7) {
                    this.f19964e = j8;
                }
                this.f19962c = j7;
                b();
            } catch (Throwable th) {
                throw th;
            }
            return z7;
        }

        public synchronized void e(long j7) {
            this.f19965f = j7;
            b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C2285d(int r20, int r21, boolean r22, int r23, int r24, android.os.Handler r25, o0.C2285d.c r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.C2285d.<init>(int, int, boolean, int, int, android.os.Handler, o0.d$c):void");
    }

    public static void H(ByteBuffer byteBuffer, Image image, int i7, int i8, Rect rect, Rect rect2) {
        int i9;
        int i10;
        if (rect.width() != rect2.width() || rect.height() != rect2.height()) {
            throw new IllegalArgumentException("src and dst rect size are different!");
        }
        if (i7 % 2 == 0 && i8 % 2 == 0) {
            int i11 = 2;
            if (rect.left % 2 == 0 && rect.top % 2 == 0 && rect.right % 2 == 0 && rect.bottom % 2 == 0 && rect2.left % 2 == 0 && rect2.top % 2 == 0 && rect2.right % 2 == 0 && rect2.bottom % 2 == 0) {
                Image.Plane[] planes = image.getPlanes();
                int i12 = 0;
                while (i12 < planes.length) {
                    ByteBuffer buffer = planes[i12].getBuffer();
                    int pixelStride = planes[i12].getPixelStride();
                    int iMin = Math.min(rect.width(), i7 - rect.left);
                    int iMin2 = Math.min(rect.height(), i8 - rect.top);
                    if (i12 > 0) {
                        i10 = ((i7 * i8) * (i12 + 3)) / 4;
                        i9 = i11;
                    } else {
                        i9 = 1;
                        i10 = 0;
                    }
                    for (int i13 = 0; i13 < iMin2 / i9; i13++) {
                        byteBuffer.position(((((rect.top / i9) + i13) * i7) / i9) + i10 + (rect.left / i9));
                        buffer.position((((rect2.top / i9) + i13) * planes[i12].getRowStride()) + ((rect2.left * pixelStride) / i9));
                        int i14 = 0;
                        while (true) {
                            int i15 = iMin / i9;
                            if (i14 < i15) {
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i14 != i15 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i14++;
                            }
                        }
                    }
                    i12++;
                    i11 = 2;
                }
                return;
            }
        }
        throw new IllegalArgumentException("src or dst are not aligned!");
    }

    public final void A(byte[] bArr) {
        ByteBuffer byteBufferH = h();
        if (byteBufferH == null) {
            return;
        }
        byteBufferH.clear();
        if (bArr != null) {
            byteBufferH.put(bArr);
        }
        byteBufferH.flip();
        synchronized (this.f19949t) {
            this.f19949t.add(byteBufferH);
        }
        this.f19933d.post(new a());
    }

    public final long G(int i7) {
        return ((((long) i7) * 1000000) / ((long) this.f19941l)) + 132;
    }

    public final void K() {
        GLES20.glViewport(0, 0, this.f19937h, this.f19938i);
        for (int i7 = 0; i7 < this.f19939j; i7++) {
            for (int i8 = 0; i8 < this.f19940k; i8++) {
                int i9 = this.f19937h;
                int i10 = i8 * i9;
                int i11 = this.f19938i;
                int i12 = i7 * i11;
                this.f19945p.set(i10, i12, i9 + i10, i11 + i12);
                this.f19927A.a(this.f19928B, C2288g.f20001i, this.f19945p);
                C2283b c2283b = this.f19955z;
                int i13 = this.f19943n;
                this.f19943n = i13 + 1;
                c2283b.i(G(i13) * 1000);
                this.f19955z.j();
            }
        }
    }

    public final ByteBuffer M() {
        if (!this.f19944o && this.f19947r == null) {
            synchronized (this.f19949t) {
                this.f19947r = this.f19949t.isEmpty() ? null : (ByteBuffer) this.f19949t.remove(0);
            }
        }
        if (this.f19944o) {
            return null;
        }
        return this.f19947r;
    }

    public void O() {
        while (true) {
            ByteBuffer byteBufferM = M();
            if (byteBufferM == null || this.f19950u.isEmpty()) {
                return;
            }
            int iIntValue = ((Integer) this.f19950u.remove(0)).intValue();
            boolean z7 = this.f19943n % this.f19941l == 0 && byteBufferM.remaining() == 0;
            if (!z7) {
                Image inputImage = this.f19930a.getInputImage(iIntValue);
                int i7 = this.f19937h;
                int i8 = this.f19943n;
                int i9 = this.f19940k;
                int i10 = (i8 % i9) * i7;
                int i11 = this.f19938i;
                int i12 = ((i8 / i9) % this.f19939j) * i11;
                this.f19945p.set(i10, i12, i7 + i10, i11 + i12);
                H(byteBufferM, inputImage, this.f19935f, this.f19936g, this.f19945p, this.f19946q);
            }
            MediaCodec mediaCodec = this.f19930a;
            int iCapacity = z7 ? 0 : mediaCodec.getInputBuffer(iIntValue).capacity();
            int i13 = this.f19943n;
            this.f19943n = i13 + 1;
            mediaCodec.queueInputBuffer(iIntValue, 0, iCapacity, G(i13), z7 ? 4 : 0);
            if (z7 || this.f19943n % this.f19941l == 0) {
                T(z7);
            }
        }
    }

    public final void T(boolean z7) {
        synchronized (this.f19948s) {
            this.f19944o = z7 | this.f19944o;
            this.f19948s.add(this.f19947r);
            this.f19948s.notifyAll();
        }
        this.f19947r = null;
    }

    public void V() {
        this.f19930a.start();
    }

    public void X() {
        int i7 = this.f19934e;
        if (i7 == 2) {
            this.f19951v.c(0L);
        } else if (i7 == 0) {
            A(null);
        }
    }

    public void c0() {
        MediaCodec mediaCodec = this.f19930a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f19930a.release();
            this.f19930a = null;
        }
        synchronized (this.f19948s) {
            this.f19944o = true;
            this.f19948s.notifyAll();
        }
        synchronized (this) {
            try {
                C2282a c2282a = this.f19927A;
                if (c2282a != null) {
                    c2282a.e(false);
                    this.f19927A = null;
                }
                C2283b c2283b = this.f19955z;
                if (c2283b != null) {
                    c2283b.h();
                    this.f19955z = null;
                }
                SurfaceTexture surfaceTexture = this.f19952w;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.f19952w = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.f19948s) {
            this.f19944o = true;
            this.f19948s.notifyAll();
        }
        this.f19933d.postAtFrontOfQueue(new b());
    }

    public final ByteBuffer h() {
        ByteBuffer byteBuffer;
        synchronized (this.f19948s) {
            while (!this.f19944o && this.f19948s.isEmpty()) {
                try {
                    this.f19948s.wait();
                } catch (InterruptedException unused) {
                }
            }
            byteBuffer = this.f19944o ? null : (ByteBuffer) this.f19948s.remove(0);
        }
        return byteBuffer;
    }

    public void i(Bitmap bitmap) {
        if (this.f19934e != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        }
        if (this.f19951v.d(G(this.f19943n) * 1000, G((this.f19943n + this.f19941l) - 1))) {
            synchronized (this) {
                try {
                    C2283b c2283b = this.f19955z;
                    if (c2283b == null) {
                        return;
                    }
                    c2283b.f();
                    this.f19927A.d(this.f19928B, bitmap);
                    K();
                    this.f19955z.g();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            try {
                C2283b c2283b = this.f19955z;
                if (c2283b == null) {
                    return;
                }
                c2283b.f();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.f19929C);
                if (this.f19951v.d(surfaceTexture.getTimestamp(), G((this.f19943n + this.f19941l) - 1))) {
                    K();
                }
                surfaceTexture.releaseTexImage();
                this.f19955z.g();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
