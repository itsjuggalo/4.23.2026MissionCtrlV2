package o0;

import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import o0.C2285d;

/* JADX INFO: renamed from: o0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2287f implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f19970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f19971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f19975g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaMuxer f19977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C2285d f19978j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f19980l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19981m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19982n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f19976h = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f19979k = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f19983o = new ArrayList();

    /* JADX INFO: renamed from: o0.f$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C2287f.this.H();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: o0.f$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileDescriptor f19986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f19988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f19989e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19990f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19991g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19992h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19993i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19994j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Handler f19995k;

        public b(String str, int i7, int i8, int i9) {
            this(str, null, i7, i8, i9);
        }

        public C2287f a() {
            return new C2287f(this.f19985a, this.f19986b, this.f19987c, this.f19988d, this.f19994j, this.f19990f, this.f19991g, this.f19992h, this.f19993i, this.f19989e, this.f19995k);
        }

        public b b(int i7) {
            if (i7 > 0) {
                this.f19992h = i7;
                return this;
            }
            throw new IllegalArgumentException("Invalid maxImage: " + i7);
        }

        public b c(int i7) {
            if (i7 >= 0 && i7 <= 100) {
                this.f19991g = i7;
                return this;
            }
            throw new IllegalArgumentException("Invalid quality: " + i7);
        }

        public b(String str, FileDescriptor fileDescriptor, int i7, int i8, int i9) {
            this.f19990f = true;
            this.f19991g = 100;
            this.f19992h = 1;
            this.f19993i = 0;
            this.f19994j = 0;
            if (i7 <= 0 || i8 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + i7 + "x" + i8);
            }
            this.f19985a = str;
            this.f19986b = fileDescriptor;
            this.f19987c = i7;
            this.f19988d = i8;
            this.f19989e = i9;
        }
    }

    /* JADX INFO: renamed from: o0.f$c */
    public class c extends C2285d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19996a;

        public c() {
        }

        @Override // o0.C2285d.c
        public void a(C2285d c2285d) {
            e(null);
        }

        @Override // o0.C2285d.c
        public void b(C2285d c2285d, ByteBuffer byteBuffer) {
            if (this.f19996a) {
                return;
            }
            C2287f c2287f = C2287f.this;
            if (c2287f.f19980l == null) {
                e(new IllegalStateException("Output buffer received before format info"));
                return;
            }
            if (c2287f.f19981m < c2287f.f19974f * c2287f.f19972d) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0L, 0);
                C2287f c2287f2 = C2287f.this;
                c2287f2.f19977i.writeSampleData(c2287f2.f19980l[c2287f2.f19981m / c2287f2.f19972d], byteBuffer, bufferInfo);
            }
            C2287f c2287f3 = C2287f.this;
            int i7 = c2287f3.f19981m + 1;
            c2287f3.f19981m = i7;
            if (i7 == c2287f3.f19974f * c2287f3.f19972d) {
                e(null);
            }
        }

        @Override // o0.C2285d.c
        public void c(C2285d c2285d, MediaCodec.CodecException codecException) {
            e(codecException);
        }

        @Override // o0.C2285d.c
        public void d(C2285d c2285d, MediaFormat mediaFormat) {
            if (this.f19996a) {
                return;
            }
            if (C2287f.this.f19980l != null) {
                e(new IllegalStateException("Output format changed after muxer started"));
                return;
            }
            try {
                C2287f.this.f19972d = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
            } catch (ClassCastException | NullPointerException unused) {
                C2287f.this.f19972d = 1;
            }
            C2287f c2287f = C2287f.this;
            c2287f.f19980l = new int[c2287f.f19974f];
            if (c2287f.f19973e > 0) {
                Log.d("HeifWriter", "setting rotation: " + C2287f.this.f19973e);
                C2287f c2287f2 = C2287f.this;
                c2287f2.f19977i.setOrientationHint(c2287f2.f19973e);
            }
            int i7 = 0;
            while (true) {
                C2287f c2287f3 = C2287f.this;
                if (i7 >= c2287f3.f19980l.length) {
                    c2287f3.f19977i.start();
                    C2287f.this.f19979k.set(true);
                    C2287f.this.K();
                    return;
                } else {
                    mediaFormat.setInteger("is-default", i7 == c2287f3.f19975g ? 1 : 0);
                    C2287f c2287f4 = C2287f.this;
                    c2287f4.f19980l[i7] = c2287f4.f19977i.addTrack(mediaFormat);
                    i7++;
                }
            }
        }

        public final void e(Exception exc) {
            if (this.f19996a) {
                return;
            }
            this.f19996a = true;
            C2287f.this.f19976h.a(exc);
        }
    }

    /* JADX INFO: renamed from: o0.f$d */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Exception f19999b;

        public synchronized void a(Exception exc) {
            if (!this.f19998a) {
                this.f19998a = true;
                this.f19999b = exc;
                notifyAll();
            }
        }

        public synchronized void b(long j7) {
            if (j7 < 0) {
                throw new IllegalArgumentException("timeoutMs is negative");
            }
            if (j7 == 0) {
                while (!this.f19998a) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (!this.f19998a && j7 > 0) {
                    try {
                        wait(j7);
                    } catch (InterruptedException unused2) {
                    }
                    j7 -= System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
            if (!this.f19998a) {
                this.f19998a = true;
                this.f19999b = new TimeoutException("timed out waiting for result");
            }
            Exception exc = this.f19999b;
            if (exc != null) {
                throw exc;
            }
        }
    }

    public C2287f(String str, FileDescriptor fileDescriptor, int i7, int i8, int i9, boolean z7, int i10, int i11, int i12, int i13, Handler handler) {
        if (i12 >= i11) {
            throw new IllegalArgumentException("Invalid maxImages (" + i11 + ") or primaryIndex (" + i12 + ")");
        }
        MediaFormat.createVideoFormat("image/vnd.android.heic", i7, i8);
        this.f19972d = 1;
        this.f19973e = i9;
        this.f19969a = i13;
        this.f19974f = i11;
        this.f19975g = i12;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
            this.f19970b = handlerThread;
            handlerThread.start();
            looper = handlerThread.getLooper();
        } else {
            this.f19970b = null;
        }
        Handler handler2 = new Handler(looper);
        this.f19971c = handler2;
        this.f19977i = str != null ? new MediaMuxer(str, 3) : AbstractC2286e.a(fileDescriptor, 3);
        this.f19978j = new C2285d(i7, i8, z7, i10, i13, handler2, new c());
    }

    public final void A(boolean z7) {
        if (this.f19982n != z7) {
            throw new IllegalStateException("Already started");
        }
    }

    public final void G(int i7) {
        A(true);
        i(i7);
    }

    public void H() {
        MediaMuxer mediaMuxer = this.f19977i;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f19977i.release();
            this.f19977i = null;
        }
        C2285d c2285d = this.f19978j;
        if (c2285d != null) {
            c2285d.close();
            synchronized (this) {
                this.f19978j = null;
            }
        }
    }

    public void K() {
        Pair pair;
        if (!this.f19979k.get()) {
            return;
        }
        while (true) {
            synchronized (this.f19983o) {
                try {
                    if (this.f19983o.isEmpty()) {
                        return;
                    } else {
                        pair = (Pair) this.f19983o.remove(0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(((ByteBuffer) pair.second).position(), ((ByteBuffer) pair.second).remaining(), 0L, 16);
            this.f19977i.writeSampleData(this.f19980l[((Integer) pair.first).intValue()], (ByteBuffer) pair.second, bufferInfo);
        }
    }

    public void M() {
        A(false);
        this.f19982n = true;
        this.f19978j.V();
    }

    public void O(long j7) {
        A(true);
        synchronized (this) {
            try {
                C2285d c2285d = this.f19978j;
                if (c2285d != null) {
                    c2285d.X();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f19976h.b(j7);
        K();
        H();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f19971c.postAtFrontOfQueue(new a());
    }

    public void h(Bitmap bitmap) {
        G(2);
        synchronized (this) {
            try {
                C2285d c2285d = this.f19978j;
                if (c2285d != null) {
                    c2285d.i(bitmap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i(int i7) {
        if (this.f19969a == i7) {
            return;
        }
        throw new IllegalStateException("Not valid in input mode " + this.f19969a);
    }
}
