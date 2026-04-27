package Z;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d implements AutoCloseable, SurfaceTexture.OnFrameAvailableListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Z.a f5686A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int f5687B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MediaCodec f5689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f5690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerThread f5691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f5692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f5693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f5696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f5697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f5701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f5704p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f5705q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ByteBuffer f5706r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e f5710v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SurfaceTexture f5711w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Surface f5712x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Surface f5713y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Z.b f5714z;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f5707s = new ArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f5708t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f5709u = new ArrayList();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final float[] f5688C = new float[16];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.G();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.S();
        }
    }

    public static abstract class c {
        public abstract void a(d dVar);

        public abstract void b(d dVar, ByteBuffer byteBuffer);

        public abstract void c(d dVar, MediaCodec.CodecException codecException);

        public abstract void d(d dVar, MediaFormat mediaFormat);
    }

    /* JADX INFO: renamed from: Z.d$d, reason: collision with other inner class name */
    public class C0079d extends MediaCodec.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5717a;

        public C0079d() {
        }

        public final void a(MediaCodec.CodecException codecException) {
            d.this.S();
            if (codecException == null) {
                d dVar = d.this;
                dVar.f5690b.a(dVar);
            } else {
                d dVar2 = d.this;
                dVar2.f5690b.c(dVar2, codecException);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            if (mediaCodec != d.this.f5689a) {
                return;
            }
            Log.e("HeifEncoder", "onError: " + codecException);
            a(codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i4) {
            d dVar = d.this;
            if (mediaCodec != dVar.f5689a || dVar.f5703o) {
                return;
            }
            dVar.f5709u.add(Integer.valueOf(i4));
            d.this.G();
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i4, MediaCodec.BufferInfo bufferInfo) {
            if (mediaCodec != d.this.f5689a || this.f5717a) {
                return;
            }
            if (bufferInfo.size > 0 && (bufferInfo.flags & 2) == 0) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i4);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                e eVar = d.this.f5710v;
                if (eVar != null) {
                    eVar.e(bufferInfo.presentationTimeUs);
                }
                d dVar = d.this;
                dVar.f5690b.b(dVar, outputBuffer);
            }
            this.f5717a = ((bufferInfo.flags & 4) != 0) | this.f5717a;
            mediaCodec.releaseOutputBuffer(i4, false);
            if (this.f5717a) {
                a(null);
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            if (mediaCodec != d.this.f5689a) {
                return;
            }
            if (!"image/vnd.android.heic".equals(mediaFormat.getString("mime"))) {
                mediaFormat.setString("mime", "image/vnd.android.heic");
                mediaFormat.setInteger("width", d.this.f5694f);
                mediaFormat.setInteger("height", d.this.f5695g);
                d dVar = d.this;
                if (dVar.f5701m) {
                    mediaFormat.setInteger("tile-width", dVar.f5696h);
                    mediaFormat.setInteger("tile-height", d.this.f5697i);
                    mediaFormat.setInteger("grid-rows", d.this.f5698j);
                    mediaFormat.setInteger("grid-cols", d.this.f5699k);
                }
            }
            d dVar2 = d.this;
            dVar2.f5690b.d(dVar2, mediaFormat);
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f5719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5720b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5721c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5722d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5723e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5724f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f5725g;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaCodec mediaCodec = d.this.f5689a;
                if (mediaCodec != null) {
                    mediaCodec.signalEndOfInputStream();
                }
            }
        }

        public e(boolean z4) {
            this.f5719a = z4;
        }

        public final void a() {
            d.this.f5692d.post(new a());
            this.f5725g = true;
        }

        public final void b() {
            if (this.f5725g) {
                return;
            }
            if (this.f5722d < 0) {
                long j4 = this.f5720b;
                if (j4 >= 0 && this.f5721c >= j4) {
                    long j5 = this.f5723e;
                    if (j5 < 0) {
                        a();
                        return;
                    }
                    this.f5722d = j5;
                }
            }
            long j6 = this.f5722d;
            if (j6 < 0 || j6 > this.f5724f) {
                return;
            }
            a();
        }

        public synchronized void c(long j4) {
            try {
                if (this.f5719a) {
                    if (this.f5720b < 0) {
                        this.f5720b = j4;
                    }
                } else if (this.f5722d < 0) {
                    this.f5722d = j4 / 1000;
                }
                b();
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean d(long j4, long j5) {
            boolean z4;
            try {
                long j6 = this.f5720b;
                z4 = j6 < 0 || j4 <= j6;
                if (z4) {
                    this.f5723e = j5;
                }
                this.f5721c = j4;
                b();
            } catch (Throwable th) {
                throw th;
            }
            return z4;
        }

        public synchronized void e(long j4) {
            this.f5724f = j4;
            b();
        }
    }

    public d(int i4, int i5, boolean z4, int i6, int i7, Handler handler, c cVar) throws IOException {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        boolean z5;
        int i8;
        boolean z6;
        int i9;
        int i10;
        if (i4 < 0 || i5 < 0 || i6 < 0 || i6 > 100) {
            throw new IllegalArgumentException("invalid encoder inputs");
        }
        int i11 = 512;
        boolean z7 = z4 & (i4 > 512 || i5 > 512);
        try {
            MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("image/vnd.android.heic");
            this.f5689a = mediaCodecCreateEncoderByType;
            capabilitiesForType = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType("image/vnd.android.heic");
            if (!capabilitiesForType.getVideoCapabilities().isSizeSupported(i4, i5)) {
                this.f5689a.release();
                this.f5689a = null;
                throw new Exception();
            }
            z5 = true;
        } catch (Exception unused) {
            MediaCodec mediaCodecCreateEncoderByType2 = MediaCodec.createEncoderByType("video/hevc");
            this.f5689a = mediaCodecCreateEncoderByType2;
            capabilitiesForType = mediaCodecCreateEncoderByType2.getCodecInfo().getCapabilitiesForType("video/hevc");
            z7 |= !capabilitiesForType.getVideoCapabilities().isSizeSupported(i4, i5);
            z5 = false;
        }
        this.f5693e = i7;
        this.f5690b = cVar;
        Looper looper = handler != null ? handler.getLooper() : null;
        if (looper == null) {
            HandlerThread handlerThread = new HandlerThread("HeifEncoderThread", -2);
            this.f5691c = handlerThread;
            handlerThread.start();
            looper = handlerThread.getLooper();
        } else {
            this.f5691c = null;
        }
        Handler handler2 = new Handler(looper);
        this.f5692d = handler2;
        boolean z8 = i7 == 1 || i7 == 2;
        int i12 = z8 ? 2130708361 : 2135033992;
        this.f5694f = i4;
        this.f5695g = i5;
        this.f5701m = z7;
        if (z7) {
            i10 = (i5 + 511) / 512;
            z6 = z7;
            i9 = (i4 + 511) / 512;
            i8 = 512;
        } else {
            i11 = i4;
            i8 = i5;
            z6 = z7;
            i9 = 1;
            i10 = 1;
        }
        MediaFormat mediaFormatCreateVideoFormat = z5 ? MediaFormat.createVideoFormat("image/vnd.android.heic", i4, i5) : MediaFormat.createVideoFormat("video/hevc", i11, i8);
        if (z6) {
            mediaFormatCreateVideoFormat.setInteger("tile-width", i11);
            mediaFormatCreateVideoFormat.setInteger("tile-height", i8);
            mediaFormatCreateVideoFormat.setInteger("grid-cols", i9);
            mediaFormatCreateVideoFormat.setInteger("grid-rows", i10);
        }
        if (z5) {
            this.f5696h = i4;
            this.f5697i = i5;
            this.f5698j = 1;
            this.f5699k = 1;
        } else {
            this.f5696h = i11;
            this.f5697i = i8;
            this.f5698j = i10;
            this.f5699k = i9;
        }
        int i13 = this.f5698j * this.f5699k;
        this.f5700l = i13;
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 0);
        mediaFormatCreateVideoFormat.setInteger("color-format", i12);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", i13);
        mediaFormatCreateVideoFormat.setInteger("capture-rate", i13 * 30);
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
        if (encoderCapabilities.isBitrateModeSupported(0)) {
            Log.d("HeifEncoder", "Setting bitrate mode to constant quality");
            Range qualityRange = encoderCapabilities.getQualityRange();
            Log.d("HeifEncoder", "Quality range: " + qualityRange);
            mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 0);
            mediaFormatCreateVideoFormat.setInteger("quality", (int) (((double) ((Integer) qualityRange.getLower()).intValue()) + (((double) ((((Integer) qualityRange.getUpper()).intValue() - ((Integer) qualityRange.getLower()).intValue()) * i6)) / 100.0d)));
        } else {
            if (encoderCapabilities.isBitrateModeSupported(2)) {
                Log.d("HeifEncoder", "Setting bitrate mode to constant bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 2);
            } else {
                Log.d("HeifEncoder", "Setting bitrate mode to variable bitrate");
                mediaFormatCreateVideoFormat.setInteger("bitrate-mode", 1);
            }
            mediaFormatCreateVideoFormat.setInteger("bitrate", (int) (((((((double) (i4 * i5)) * 1.5d) * 8.0d) * 0.25d) * ((double) i6)) / 100.0d));
        }
        this.f5689a.setCallback(new C0079d(), handler2);
        this.f5689a.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        if (z8) {
            this.f5713y = this.f5689a.createInputSurface();
            boolean z9 = (z6 && !z5) || i7 == 2;
            this.f5710v = new e(z9);
            if (z9) {
                Z.b bVar = new Z.b(this.f5713y);
                this.f5714z = bVar;
                bVar.f();
                Z.a aVar = new Z.a(new g(i7 == 2 ? 0 : 1), i4, i5);
                this.f5686A = aVar;
                this.f5687B = aVar.c();
                if (i7 == 1) {
                    SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5687B, true);
                    this.f5711w = surfaceTexture;
                    surfaceTexture.setOnFrameAvailableListener(this);
                    this.f5711w.setDefaultBufferSize(i4, i5);
                    this.f5712x = new Surface(this.f5711w);
                }
                this.f5714z.g();
            } else {
                this.f5712x = this.f5713y;
            }
        } else {
            for (int i14 = 0; i14 < 2; i14++) {
                this.f5707s.add(ByteBuffer.allocateDirect(((this.f5694f * this.f5695g) * 3) / 2));
            }
        }
        this.f5705q = new Rect(0, 0, this.f5696h, this.f5697i);
        this.f5704p = new Rect();
    }

    public static void x(ByteBuffer byteBuffer, Image image, int i4, int i5, Rect rect, Rect rect2) {
        int i6;
        int i7;
        if (rect.width() != rect2.width() || rect.height() != rect2.height()) {
            throw new IllegalArgumentException("src and dst rect size are different!");
        }
        if (i4 % 2 == 0 && i5 % 2 == 0) {
            int i8 = 2;
            if (rect.left % 2 == 0 && rect.top % 2 == 0 && rect.right % 2 == 0 && rect.bottom % 2 == 0 && rect2.left % 2 == 0 && rect2.top % 2 == 0 && rect2.right % 2 == 0 && rect2.bottom % 2 == 0) {
                Image.Plane[] planes = image.getPlanes();
                int i9 = 0;
                while (i9 < planes.length) {
                    ByteBuffer buffer = planes[i9].getBuffer();
                    int pixelStride = planes[i9].getPixelStride();
                    int iMin = Math.min(rect.width(), i4 - rect.left);
                    int iMin2 = Math.min(rect.height(), i5 - rect.top);
                    if (i9 > 0) {
                        i7 = ((i4 * i5) * (i9 + 3)) / 4;
                        i6 = i8;
                    } else {
                        i6 = 1;
                        i7 = 0;
                    }
                    for (int i10 = 0; i10 < iMin2 / i6; i10++) {
                        byteBuffer.position(((((rect.top / i6) + i10) * i4) / i6) + i7 + (rect.left / i6));
                        buffer.position((((rect2.top / i6) + i10) * planes[i9].getRowStride()) + ((rect2.left * pixelStride) / i6));
                        int i11 = 0;
                        while (true) {
                            int i12 = iMin / i6;
                            if (i11 < i12) {
                                buffer.put(byteBuffer.get());
                                if (pixelStride > 1 && i11 != i12 - 1) {
                                    buffer.position((buffer.position() + pixelStride) - 1);
                                }
                                i11++;
                            }
                        }
                    }
                    i9++;
                    i8 = 2;
                }
                return;
            }
        }
        throw new IllegalArgumentException("src or dst are not aligned!");
    }

    public final void A() {
        GLES20.glViewport(0, 0, this.f5696h, this.f5697i);
        for (int i4 = 0; i4 < this.f5698j; i4++) {
            for (int i5 = 0; i5 < this.f5699k; i5++) {
                int i6 = this.f5696h;
                int i7 = i5 * i6;
                int i8 = this.f5697i;
                int i9 = i4 * i8;
                this.f5704p.set(i7, i9, i6 + i7, i8 + i9);
                this.f5686A.a(this.f5687B, g.f5760i, this.f5704p);
                Z.b bVar = this.f5714z;
                int i10 = this.f5702n;
                this.f5702n = i10 + 1;
                bVar.i(p(i10) * 1000);
                this.f5714z.j();
            }
        }
    }

    public final ByteBuffer E() {
        if (!this.f5703o && this.f5706r == null) {
            synchronized (this.f5708t) {
                this.f5706r = this.f5708t.isEmpty() ? null : (ByteBuffer) this.f5708t.remove(0);
            }
        }
        if (this.f5703o) {
            return null;
        }
        return this.f5706r;
    }

    public void G() {
        while (true) {
            ByteBuffer byteBufferE = E();
            if (byteBufferE == null || this.f5709u.isEmpty()) {
                return;
            }
            int iIntValue = ((Integer) this.f5709u.remove(0)).intValue();
            boolean z4 = this.f5702n % this.f5700l == 0 && byteBufferE.remaining() == 0;
            if (!z4) {
                Image inputImage = this.f5689a.getInputImage(iIntValue);
                int i4 = this.f5696h;
                int i5 = this.f5702n;
                int i6 = this.f5699k;
                int i7 = (i5 % i6) * i4;
                int i8 = this.f5697i;
                int i9 = ((i5 / i6) % this.f5698j) * i8;
                this.f5704p.set(i7, i9, i4 + i7, i8 + i9);
                x(byteBufferE, inputImage, this.f5694f, this.f5695g, this.f5704p, this.f5705q);
            }
            MediaCodec mediaCodec = this.f5689a;
            int iCapacity = z4 ? 0 : mediaCodec.getInputBuffer(iIntValue).capacity();
            int i10 = this.f5702n;
            this.f5702n = i10 + 1;
            mediaCodec.queueInputBuffer(iIntValue, 0, iCapacity, p(i10), z4 ? 4 : 0);
            if (z4 || this.f5702n % this.f5700l == 0) {
                J(z4);
            }
        }
    }

    public final void J(boolean z4) {
        synchronized (this.f5707s) {
            this.f5703o = z4 | this.f5703o;
            this.f5707s.add(this.f5706r);
            this.f5707s.notifyAll();
        }
        this.f5706r = null;
    }

    public void K() {
        this.f5689a.start();
    }

    public void P() {
        int i4 = this.f5693e;
        if (i4 == 2) {
            this.f5710v.c(0L);
        } else if (i4 == 0) {
            g(null);
        }
    }

    public void S() {
        MediaCodec mediaCodec = this.f5689a;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f5689a.release();
            this.f5689a = null;
        }
        synchronized (this.f5707s) {
            this.f5703o = true;
            this.f5707s.notifyAll();
        }
        synchronized (this) {
            try {
                Z.a aVar = this.f5686A;
                if (aVar != null) {
                    aVar.e(false);
                    this.f5686A = null;
                }
                Z.b bVar = this.f5714z;
                if (bVar != null) {
                    bVar.h();
                    this.f5714z = null;
                }
                SurfaceTexture surfaceTexture = this.f5711w;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.f5711w = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        synchronized (this.f5707s) {
            this.f5703o = true;
            this.f5707s.notifyAll();
        }
        this.f5692d.postAtFrontOfQueue(new b());
    }

    public final ByteBuffer e() {
        ByteBuffer byteBuffer;
        synchronized (this.f5707s) {
            while (!this.f5703o && this.f5707s.isEmpty()) {
                try {
                    this.f5707s.wait();
                } catch (InterruptedException unused) {
                }
            }
            byteBuffer = this.f5703o ? null : (ByteBuffer) this.f5707s.remove(0);
        }
        return byteBuffer;
    }

    public void f(Bitmap bitmap) {
        if (this.f5693e != 2) {
            throw new IllegalStateException("addBitmap is only allowed in bitmap input mode");
        }
        if (this.f5710v.d(p(this.f5702n) * 1000, p((this.f5702n + this.f5700l) - 1))) {
            synchronized (this) {
                try {
                    Z.b bVar = this.f5714z;
                    if (bVar == null) {
                        return;
                    }
                    bVar.f();
                    this.f5686A.d(this.f5687B, bitmap);
                    A();
                    this.f5714z.g();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g(byte[] bArr) {
        ByteBuffer byteBufferE = e();
        if (byteBufferE == null) {
            return;
        }
        byteBufferE.clear();
        if (bArr != null) {
            byteBufferE.put(bArr);
        }
        byteBufferE.flip();
        synchronized (this.f5708t) {
            this.f5708t.add(byteBufferE);
        }
        this.f5692d.post(new a());
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            try {
                Z.b bVar = this.f5714z;
                if (bVar == null) {
                    return;
                }
                bVar.f();
                surfaceTexture.updateTexImage();
                surfaceTexture.getTransformMatrix(this.f5688C);
                if (this.f5710v.d(surfaceTexture.getTimestamp(), p((this.f5702n + this.f5700l) - 1))) {
                    A();
                }
                surfaceTexture.releaseTexImage();
                this.f5714z.g();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final long p(int i4) {
        return ((((long) i4) * 1000000) / ((long) this.f5700l)) + 132;
    }
}
