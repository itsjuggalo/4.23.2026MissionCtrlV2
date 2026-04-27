package d1;

import U0.g;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class G implements U0.j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final U0.g f16761d = U0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final U0.g f16762e = U0.g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f16763f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f16764g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f16765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.d f16766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f16767c;

    public class a implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16768a = ByteBuffer.allocate(8);

        @Override // U0.g.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l8, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f16768a) {
                this.f16768a.position(0);
                messageDigest.update(this.f16768a.putLong(l8.longValue()).array());
            }
        }
    }

    public class b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16769a = ByteBuffer.allocate(4);

        @Override // U0.g.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f16769a) {
                this.f16769a.position(0);
                messageDigest.update(this.f16769a.putInt(num.intValue()).array());
            }
        }
    }

    public static final class c implements e {
        public c() {
        }

        @Override // d1.G.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // d1.G.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public interface e {
        void a(MediaExtractor mediaExtractor, Object obj);

        void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    public static class f {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public static final class g implements e {
        @Override // d1.G.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // d1.G.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public static final class h extends RuntimeException {
        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public G(X0.d dVar, e eVar) {
        this(dVar, eVar, f16763f);
    }

    public static U0.j c(X0.d dVar) {
        return new G(dVar, new c(null));
    }

    public static U0.j d(X0.d dVar) {
        return new G(dVar, new d());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (!j()) {
            return bitmap;
        }
        try {
            if (i(mediaMetadataRetriever)) {
                if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
            }
        }
        return bitmap;
    }

    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8) {
        return mediaMetadataRetriever.getFrameAtTime(j8, i8);
    }

    public static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8, int i9, int i10, l lVar) {
        try {
            int i11 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i12 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i13 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i13 == 90 || i13 == 270) {
                i12 = i11;
                i11 = i12;
            }
            float fB = lVar.b(i11, i12, i9, i10);
            return mediaMetadataRetriever.getScaledFrameAtTime(j8, i8, Math.round(i11 * fB), Math.round(fB * i12));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static boolean i(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i8 = Integer.parseInt(strExtractMetadata);
        return (i8 == 7 || i8 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    public static boolean j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return k();
        }
        int i8 = Build.VERSION.SDK_INT;
        return i8 >= 30 && i8 < 33;
    }

    public static boolean k() {
        Iterator it = f16764g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static U0.j m(X0.d dVar) {
        return new G(dVar, new g());
    }

    @Override // U0.j
    public W0.v a(Object obj, int i8, int i9, U0.h hVar) throws IOException {
        long jLongValue = ((Long) hVar.c(f16761d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) hVar.c(f16762e);
        if (num == null) {
            num = 2;
        }
        l lVar = (l) hVar.c(l.f16796h);
        if (lVar == null) {
            lVar = l.f16795g;
        }
        l lVar2 = lVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f16767c.a();
        try {
            this.f16765a.b(mediaMetadataRetrieverA, obj);
            return C1618g.f(f(obj, mediaMetadataRetrieverA, jLongValue, num.intValue(), i8, i9, lVar2), this.f16766b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetrieverA.release();
            } else {
                mediaMetadataRetrieverA.release();
            }
        }
    }

    @Override // U0.j
    public boolean b(Object obj, U0.h hVar) {
        return true;
    }

    public final Bitmap f(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j8, int i8, int i9, int i10, l lVar) {
        if (l(obj, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapH = (Build.VERSION.SDK_INT < 27 || i9 == Integer.MIN_VALUE || i10 == Integer.MIN_VALUE || lVar == l.f16794f) ? null : h(mediaMetadataRetriever, j8, i8, i9, i10, lVar);
        if (bitmapH == null) {
            bitmapH = g(mediaMetadataRetriever, j8, i8);
        }
        Bitmap bitmapE = e(mediaMetadataRetriever, bitmapH);
        if (bitmapE != null) {
            return bitmapE;
        }
        throw new h();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x0053, B:25:0x0059), top: B:40:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(java.lang.Object r6, android.media.MediaMetadataRetriever r7) {
        /*
            r5 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L6d
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L6d
            r1 = 12
            r3 = 0
            java.lang.String r7 = r7.extractMetadata(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "video/webm"
            boolean r7 = r1.equals(r7)     // Catch: java.lang.Throwable -> L51
            if (r7 != 0) goto L1f
            return r2
        L1f:
            android.media.MediaExtractor r7 = new android.media.MediaExtractor     // Catch: java.lang.Throwable -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L51
            d1.G$e r1 = r5.f16765a     // Catch: java.lang.Throwable -> L4a
            r1.a(r7, r6)     // Catch: java.lang.Throwable -> L4a
            int r6 = r7.getTrackCount()     // Catch: java.lang.Throwable -> L4a
            r1 = r2
        L2e:
            if (r1 >= r6) goto L4d
            android.media.MediaFormat r3 = r7.getTrackFormat(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "mime"
            java.lang.String r3 = r3.getString(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = "video/x-vnd.on2.vp8"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L47
            r7.release()
            r6 = 1
            return r6
        L47:
            int r1 = r1 + 1
            goto L2e
        L4a:
            r6 = move-exception
            r3 = r7
            goto L52
        L4d:
            r7.release()
            goto L66
        L51:
            r6 = move-exception
        L52:
            r7 = 3
            boolean r7 = android.util.Log.isLoggable(r0, r7)     // Catch: java.lang.Throwable -> L5f
            if (r7 == 0) goto L61
            java.lang.String r7 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r7, r6)     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r6 = move-exception
            goto L67
        L61:
            if (r3 == 0) goto L66
            r3.release()
        L66:
            return r2
        L67:
            if (r3 == 0) goto L6c
            r3.release()
        L6c:
            throw r6
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.G.l(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    public G(X0.d dVar, e eVar, f fVar) {
        this.f16766b = dVar;
        this.f16765a = eVar;
        this.f16767c = fVar;
    }

    public static final class d implements e {
        public final MediaDataSource c(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // d1.G.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        @Override // d1.G.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }

        public class a extends MediaDataSource {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f16770a;

            public a(ByteBuffer byteBuffer) {
                this.f16770a = byteBuffer;
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f16770a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j8, byte[] bArr, int i8, int i9) {
                if (j8 >= this.f16770a.limit()) {
                    return -1;
                }
                this.f16770a.position((int) j8);
                int iMin = Math.min(i9, this.f16770a.remaining());
                this.f16770a.get(bArr, i8, iMin);
                return iMin;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }
}
