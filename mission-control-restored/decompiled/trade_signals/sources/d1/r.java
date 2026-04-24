package d1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import d1.l;
import d1.w;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import q1.AbstractC2624g;
import q1.AbstractC2628k;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final U0.g f16801f = U0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", U0.b.f8070c);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final U0.g f16802g = U0.g.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final U0.g f16803h = l.f16796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final U0.g f16804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final U0.g f16805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f16806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f16807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f16808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Queue f16809n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.d f16810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f16811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0.b f16812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f16813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v f16814e = v.b();

    public interface b {
        void a(X0.d dVar, Bitmap bitmap);

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f16804i = U0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f16805j = U0.g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f16806k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f16807l = new a();
        f16808m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f16809n = AbstractC2629l.f(0);
    }

    public r(List list, DisplayMetrics displayMetrics, X0.d dVar, X0.b bVar) {
        this.f16813d = list;
        this.f16811b = (DisplayMetrics) AbstractC2628k.d(displayMetrics);
        this.f16810a = (X0.d) AbstractC2628k.d(dVar);
        this.f16812c = (X0.b) AbstractC2628k.d(bVar);
    }

    public static int a(double d8) {
        int iL = l(d8);
        int iX = x(((double) iL) * d8);
        return x((d8 / ((double) (iX / iL))) * ((double) iX));
    }

    public static void c(ImageHeaderParser.ImageType imageType, w wVar, b bVar, X0.d dVar, l lVar, int i8, int i9, int i10, int i11, int i12, BitmapFactory.Options options) {
        int i13;
        int i14;
        int iFloor;
        int iFloor2;
        if (i9 <= 0 || i10 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i11 + "x" + i12 + "]");
                return;
            }
            return;
        }
        if (r(i8)) {
            i14 = i9;
            i13 = i10;
        } else {
            i13 = i9;
            i14 = i10;
        }
        float fB = lVar.b(i13, i14, i11, i12);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + lVar + ", source: [" + i9 + "x" + i10 + "], target: [" + i11 + "x" + i12 + "]");
        }
        l.g gVarA = lVar.a(i13, i14, i11, i12);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f8 = i13;
        float f9 = i14;
        int iX = i13 / x(fB * f8);
        int iX2 = i14 / x(fB * f9);
        l.g gVar = l.g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(gVarA == gVar ? Math.max(iX, iX2) : Math.min(iX, iX2)));
        if (gVarA == gVar && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            iFloor = (int) Math.ceil(f8 / fMin);
            iFloor2 = (int) Math.ceil(f9 / fMin);
            int i15 = iMax / 8;
            if (i15 > 0) {
                iFloor /= i15;
                iFloor2 /= i15;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f10 = iMax;
            iFloor = (int) Math.floor(f8 / f10);
            iFloor2 = (int) Math.floor(f9 / f10);
        } else if (imageType.isWebp()) {
            float f11 = iMax;
            iFloor = Math.round(f8 / f11);
            iFloor2 = Math.round(f9 / f11);
        } else if (i13 % iMax == 0 && i14 % iMax == 0) {
            iFloor = i13 / iMax;
            iFloor2 = i14 / iMax;
        } else {
            int[] iArrM = m(wVar, options, bVar, dVar);
            iFloor = iArrM[0];
            iFloor2 = iArrM[1];
        }
        double dB = lVar.b(iFloor, iFloor2, i11, i12);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i9 + "x" + i10 + "], degreesToRotate: " + i8 + ", target: [" + i11 + "x" + i12 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap i(d1.w r5, android.graphics.BitmapFactory.Options r6, d1.r.b r7, X0.d r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.b()
            r5.c()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = d1.D.c()
            r4.lock()
            android.graphics.Bitmap r5 = r5.b(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = d1.D.c()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L50
        L27:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L4f
            r8.c(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            java.util.concurrent.locks.Lock r6 = d1.D.c()
            r6.unlock()
            return r5
        L4e:
            throw r1     // Catch: java.lang.Throwable -> L25
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L25
        L50:
            java.util.concurrent.locks.Lock r6 = d1.D.c()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.r.i(d1.w, android.graphics.BitmapFactory$Options, d1.r$b, X0.d):android.graphics.Bitmap");
    }

    public static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        Queue queue = f16809n;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            w(options);
        }
        return options;
    }

    public static int l(double d8) {
        if (d8 > 1.0d) {
            d8 = 1.0d / d8;
        }
        return (int) Math.round(d8 * 2.147483647E9d);
    }

    public static int[] m(w wVar, BitmapFactory.Options options, b bVar, X0.d dVar) {
        options.inJustDecodeBounds = true;
        i(wVar, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i8) {
        return i8 == 90 || i8 == 270;
    }

    public static boolean s(BitmapFactory.Options options) {
        int i8;
        int i9 = options.inTargetDensity;
        return i9 > 0 && (i8 = options.inDensity) > 0 && i9 != i8;
    }

    public static void t(int i8, int i9, String str, BitmapFactory.Options options, Bitmap bitmap, int i10, int i11, long j8) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i8 + "x" + i9 + "] " + str + " with inBitmap " + n(options) + " for [" + i10 + "x" + i11 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + AbstractC2624g.a(j8));
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i8, int i9, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i8 + ", outHeight: " + i9 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = f16809n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d8) {
        return (int) (d8 + 0.5d);
    }

    public static void y(BitmapFactory.Options options, X0.d dVar, int i8, int i9) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = dVar.e(i8, i9, config);
    }

    public final void b(w wVar, U0.b bVar, boolean z7, boolean z8, BitmapFactory.Options options, int i8, int i9) {
        boolean zHasAlpha;
        if (this.f16814e.g(i8, i9, options, z7, z8)) {
            return;
        }
        if (bVar == U0.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = wVar.d().hasAlpha();
        } catch (IOException e8) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e8);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    public W0.v d(ParcelFileDescriptor parcelFileDescriptor, int i8, int i9, U0.h hVar) {
        return e(new w.c(parcelFileDescriptor, this.f16813d, this.f16812c), i8, i9, hVar, f16807l);
    }

    public final W0.v e(w wVar, int i8, int i9, U0.h hVar, b bVar) {
        byte[] bArr = (byte[]) this.f16812c.e(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        U0.b bVar2 = (U0.b) hVar.c(f16801f);
        U0.i iVar = (U0.i) hVar.c(f16802g);
        l lVar = (l) hVar.c(l.f16796h);
        boolean zBooleanValue = ((Boolean) hVar.c(f16804i)).booleanValue();
        U0.g gVar = f16805j;
        try {
            return C1618g.f(h(wVar, optionsK, lVar, bVar2, iVar, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), i8, i9, zBooleanValue, bVar), this.f16810a);
        } finally {
            v(optionsK);
            this.f16812c.d(bArr);
        }
    }

    public W0.v f(InputStream inputStream, int i8, int i9, U0.h hVar, b bVar) {
        return e(new w.b(inputStream, this.f16813d, this.f16812c), i8, i9, hVar, bVar);
    }

    public W0.v g(ByteBuffer byteBuffer, int i8, int i9, U0.h hVar) {
        return e(new w.a(byteBuffer, this.f16813d, this.f16812c), i8, i9, hVar, f16807l);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0172, code lost:
    
        if (r0 >= 26) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap h(d1.w r28, android.graphics.BitmapFactory.Options r29, d1.l r30, U0.b r31, U0.i r32, boolean r33, int r34, int r35, boolean r36, d1.r.b r37) {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.r.h(d1.w, android.graphics.BitmapFactory$Options, d1.l, U0.b, U0.i, boolean, int, int, boolean, d1.r$b):android.graphics.Bitmap");
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public class a implements b {
        @Override // d1.r.b
        public void b() {
        }

        @Override // d1.r.b
        public void a(X0.d dVar, Bitmap bitmap) {
        }
    }
}
