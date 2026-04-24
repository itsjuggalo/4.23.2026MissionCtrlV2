package Z;

import Z.d;
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

/* JADX INFO: loaded from: classes.dex */
public final class f implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f5729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f5730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5734g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MediaMuxer f5736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Z.d f5737j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f5739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f5740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5741n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f5735h = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f5738k = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f5742o = new ArrayList();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.x();
            } catch (Exception unused) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FileDescriptor f5745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f5748e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5751h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f5752i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f5753j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Handler f5754k;

        public b(String str, int i4, int i5, int i6) {
            this(str, null, i4, i5, i6);
        }

        public f a() {
            return new f(this.f5744a, this.f5745b, this.f5746c, this.f5747d, this.f5753j, this.f5749f, this.f5750g, this.f5751h, this.f5752i, this.f5748e, this.f5754k);
        }

        public b b(int i4) {
            if (i4 > 0) {
                this.f5751h = i4;
                return this;
            }
            throw new IllegalArgumentException("Invalid maxImage: " + i4);
        }

        public b c(int i4) {
            if (i4 >= 0 && i4 <= 100) {
                this.f5750g = i4;
                return this;
            }
            throw new IllegalArgumentException("Invalid quality: " + i4);
        }

        public b(String str, FileDescriptor fileDescriptor, int i4, int i5, int i6) {
            this.f5749f = true;
            this.f5750g = 100;
            this.f5751h = 1;
            this.f5752i = 0;
            this.f5753j = 0;
            if (i4 <= 0 || i5 <= 0) {
                throw new IllegalArgumentException("Invalid image size: " + i4 + "x" + i5);
            }
            this.f5744a = str;
            this.f5745b = fileDescriptor;
            this.f5746c = i4;
            this.f5747d = i5;
            this.f5748e = i6;
        }
    }

    public class c extends d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5755a;

        public c() {
        }

        @Override // Z.d.c
        public void a(Z.d dVar) {
            e(null);
        }

        @Override // Z.d.c
        public void b(Z.d dVar, ByteBuffer byteBuffer) {
            if (this.f5755a) {
                return;
            }
            f fVar = f.this;
            if (fVar.f5739l == null) {
                e(new IllegalStateException("Output buffer received before format info"));
                return;
            }
            if (fVar.f5740m < fVar.f5733f * fVar.f5731d) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                bufferInfo.set(byteBuffer.position(), byteBuffer.remaining(), 0L, 0);
                f fVar2 = f.this;
                fVar2.f5736i.writeSampleData(fVar2.f5739l[fVar2.f5740m / fVar2.f5731d], byteBuffer, bufferInfo);
            }
            f fVar3 = f.this;
            int i4 = fVar3.f5740m + 1;
            fVar3.f5740m = i4;
            if (i4 == fVar3.f5733f * fVar3.f5731d) {
                e(null);
            }
        }

        @Override // Z.d.c
        public void c(Z.d dVar, MediaCodec.CodecException codecException) {
            e(codecException);
        }

        @Override // Z.d.c
        public void d(Z.d dVar, MediaFormat mediaFormat) {
            if (this.f5755a) {
                return;
            }
            if (f.this.f5739l != null) {
                e(new IllegalStateException("Output format changed after muxer started"));
                return;
            }
            try {
                f.this.f5731d = mediaFormat.getInteger("grid-rows") * mediaFormat.getInteger("grid-cols");
            } catch (ClassCastException | NullPointerException unused) {
                f.this.f5731d = 1;
            }
            f fVar = f.this;
            fVar.f5739l = new int[fVar.f5733f];
            if (fVar.f5732e > 0) {
                Log.d("HeifWriter", "setting rotation: " + f.this.f5732e);
                f fVar2 = f.this;
                fVar2.f5736i.setOrientationHint(fVar2.f5732e);
            }
            int i4 = 0;
            while (true) {
                f fVar3 = f.this;
                if (i4 >= fVar3.f5739l.length) {
                    fVar3.f5736i.start();
                    f.this.f5738k.set(true);
                    f.this.A();
                    return;
                } else {
                    mediaFormat.setInteger("is-default", i4 == fVar3.f5734g ? 1 : 0);
                    f fVar4 = f.this;
                    fVar4.f5739l[i4] = fVar4.f5736i.addTrack(mediaFormat);
                    i4++;
                }
            }
        }

        public final void e(Exception exc) {
            if (this.f5755a) {
                return;
            }
            this.f5755a = true;
            f.this.f5735h.a(exc);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Exception f5758b;

        public synchronized void a(Exception exc) {
            if (!this.f5757a) {
                this.f5757a = true;
                this.f5758b = exc;
                notifyAll();
            }
        }

        public synchronized void b(long j4) {
            if (j4 < 0) {
                throw new IllegalArgumentException("timeoutMs is negative");
            }
            if (j4 == 0) {
                while (!this.f5757a) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                while (!this.f5757a && j4 > 0) {
                    try {
                        wait(j4);
                    } catch (InterruptedException unused2) {
                    }
                    j4 -= System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
            if (!this.f5757a) {
                this.f5757a = true;
                this.f5758b = new TimeoutException("timed out waiting for result");
            }
            Exception exc = this.f5758b;
            if (exc != null) {
                throw exc;
            }
        }
    }

    public f(String str, FileDescriptor fileDescriptor, int i4, int i5, int i6, boolean z4, int i7, int i8, int i9, int i10, Handler handler) {
        if (i9 >= i8) {
            throw new IllegalArgumentException("Invalid maxImages (" + i8 + ") or primaryIndex (" + i9 + ")");
        }
        MediaFormat.createVideoFormat("image/vnd.android.heic", i4, i5);
        this.f5731d = 1;
        this.f5732e = i6;
        this.f5728a = i10;
        this.f5733f = i8;
        this.f5734g = i9;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
            this.f5729b = handlerThread;
            handlerThread.start();
            looper = handlerThread.getLooper();
        } else {
            this.f5729b = null;
        }
        Handler handler2 = new Handler(looper);
        this.f5730c = handler2;
        this.f5736i = str != null ? new MediaMuxer(str, 3) : e.a(fileDescriptor, 3);
        this.f5737j = new Z.d(i4, i5, z4, i7, i10, handler2, new c());
    }

    public void A() {
        Pair pair;
        if (!this.f5738k.get()) {
            return;
        }
        while (true) {
            synchronized (this.f5742o) {
                try {
                    if (this.f5742o.isEmpty()) {
                        return;
                    } else {
                        pair = (Pair) this.f5742o.remove(0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(((ByteBuffer) pair.second).position(), ((ByteBuffer) pair.second).remaining(), 0L, 16);
            this.f5736i.writeSampleData(this.f5739l[((Integer) pair.first).intValue()], (ByteBuffer) pair.second, bufferInfo);
        }
    }

    public void E() {
        g(false);
        this.f5741n = true;
        this.f5737j.K();
    }

    public void G(long j4) {
        g(true);
        synchronized (this) {
            try {
                Z.d dVar = this.f5737j;
                if (dVar != null) {
                    dVar.P();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5735h.b(j4);
        A();
        x();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f5730c.postAtFrontOfQueue(new a());
    }

    public void e(Bitmap bitmap) {
        p(2);
        synchronized (this) {
            try {
                Z.d dVar = this.f5737j;
                if (dVar != null) {
                    dVar.f(bitmap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(int i4) {
        if (this.f5728a == i4) {
            return;
        }
        throw new IllegalStateException("Not valid in input mode " + this.f5728a);
    }

    public final void g(boolean z4) {
        if (this.f5741n != z4) {
            throw new IllegalStateException("Already started");
        }
    }

    public final void p(int i4) {
        g(true);
        f(i4);
    }

    public void x() {
        MediaMuxer mediaMuxer = this.f5736i;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f5736i.release();
            this.f5736i = null;
        }
        Z.d dVar = this.f5737j;
        if (dVar != null) {
            dVar.close();
            synchronized (this) {
                this.f5737j = null;
            }
        }
    }
}
