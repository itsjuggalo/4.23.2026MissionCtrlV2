package X0;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class k implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Bitmap.Config f9340k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f9341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f9342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f9344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f9346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9347g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9348h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f9349i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f9350j;

    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public k(long j8) {
        this(j8, l(), k());
    }

    public static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static Bitmap g(int i8, int i9, Bitmap.Config config) {
        if (config == null) {
            config = f9340k;
        }
        return Bitmap.createBitmap(i8, i9, config);
    }

    public static Set k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i8 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i8 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static l l() {
        return new o();
    }

    public static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    public static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    @Override // X0.d
    public void a(int i8) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i8);
        }
        if (i8 >= 40 || i8 >= 20) {
            b();
        } else if (i8 >= 20 || i8 == 15) {
            q(n() / 2);
        }
    }

    @Override // X0.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // X0.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f9341a.b(bitmap) <= this.f9345e && this.f9342b.contains(bitmap.getConfig())) {
                int iB = this.f9341a.b(bitmap);
                this.f9341a.c(bitmap);
                this.f9344d.b(bitmap);
                this.f9349i++;
                this.f9346f += (long) iB;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f9341a.e(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f9341a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f9342b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // X0.d
    public Bitmap d(int i8, int i9, Bitmap.Config config) {
        Bitmap bitmapM = m(i8, i9, config);
        if (bitmapM == null) {
            return g(i8, i9, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // X0.d
    public Bitmap e(int i8, int i9, Bitmap.Config config) {
        Bitmap bitmapM = m(i8, i9, config);
        return bitmapM == null ? g(i8, i9, config) : bitmapM;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f9347g + ", misses=" + this.f9348h + ", puts=" + this.f9349i + ", evictions=" + this.f9350j + ", currentSize=" + this.f9346f + ", maxSize=" + this.f9345e + "\nStrategy=" + this.f9341a);
    }

    public final void j() {
        q(this.f9345e);
    }

    public final synchronized Bitmap m(int i8, int i9, Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.f9341a.d(i8, i9, config != null ? config : f9340k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f9341a.a(i8, i9, config));
                }
                this.f9348h++;
            } else {
                this.f9347g++;
                this.f9346f -= (long) this.f9341a.b(bitmapD);
                this.f9344d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f9341a.a(i8, i9, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    public long n() {
        return this.f9345e;
    }

    public final synchronized void q(long j8) {
        while (this.f9346f > j8) {
            try {
                Bitmap bitmapRemoveLast = this.f9341a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f9346f = 0L;
                    return;
                }
                this.f9344d.a(bitmapRemoveLast);
                this.f9346f -= (long) this.f9341a.b(bitmapRemoveLast);
                this.f9350j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f9341a.e(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(long j8, l lVar, Set set) {
        this.f9343c = j8;
        this.f9345e = j8;
        this.f9341a = lVar;
        this.f9342b = set;
        this.f9344d = new b();
    }

    public static final class b implements a {
        @Override // X0.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // X0.k.a
        public void b(Bitmap bitmap) {
        }
    }
}
