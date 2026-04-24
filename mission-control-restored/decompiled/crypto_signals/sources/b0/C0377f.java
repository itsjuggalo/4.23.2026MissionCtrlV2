package b0;

import P3.u;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0377f implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4852d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaMuxer f4853f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C0376e f4854k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f4856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4857n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4858o;
    public final u e = new u(2);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f4855l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f4859p = new ArrayList();

    public C0377f(int i, int i6, int i7, String str) {
        MediaFormat.createVideoFormat("image/vnd.android.heic", i, i6);
        this.f4851c = 1;
        this.f4849a = 2;
        this.f4852d = 1;
        HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f4850b = handler;
        this.f4853f = new MediaMuxer(str, 3);
        this.f4854k = new C0376e(i, i6, i7, handler, new u(this));
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f4850b.postAtFrontOfQueue(new A.b(this, 16));
    }

    public final void d() {
        MediaMuxer mediaMuxer = this.f4853f;
        if (mediaMuxer != null) {
            mediaMuxer.stop();
            this.f4853f.release();
            this.f4853f = null;
        }
        C0376e c0376e = this.f4854k;
        if (c0376e != null) {
            c0376e.close();
            synchronized (this) {
                this.f4854k = null;
            }
        }
    }

    public final void f() {
        Pair pair;
        if (!this.f4855l.get()) {
            return;
        }
        while (true) {
            synchronized (this.f4859p) {
                try {
                    if (this.f4859p.isEmpty()) {
                        return;
                    } else {
                        pair = (Pair) this.f4859p.remove(0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(((ByteBuffer) pair.second).position(), ((ByteBuffer) pair.second).remaining(), 0L, 16);
            this.f4853f.writeSampleData(this.f4856m[((Integer) pair.first).intValue()], (ByteBuffer) pair.second, bufferInfo);
        }
    }
}
