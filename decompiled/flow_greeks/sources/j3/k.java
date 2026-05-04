package j3;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k implements d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Bitmap.Config f13853k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f13854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f13855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f13856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f13857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13860g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13861h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13862i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13863j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    public k(long j10, l lVar, Set set) {
        this.f13856c = j10;
        this.f13858e = j10;
        this.f13854a = lVar;
        this.f13855b = set;
        this.f13857d = new b();
    }

    public static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    public static Bitmap g(int i10, int i11, Bitmap.Config config) {
        if (config == null) {
            config = f13853k;
        }
        return Bitmap.createBitmap(i10, i11, config);
    }

    public static Set k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i10 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i10 >= 26) {
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

    @Override // j3.d
    public void a(int i10) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i10);
        }
        if (i10 >= 40 || i10 >= 20) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            q(n() / 2);
        }
    }

    @Override // j3.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // j3.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f13854a.b(bitmap) <= this.f13858e && this.f13855b.contains(bitmap.getConfig())) {
                int iB = this.f13854a.b(bitmap);
                this.f13854a.c(bitmap);
                this.f13857d.b(bitmap);
                this.f13862i++;
                this.f13859f += (long) iB;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f13854a.e(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f13854a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f13855b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // j3.d
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        if (bitmapM == null) {
            return g(i10, i11, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // j3.d
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapM = m(i10, i11, config);
        return bitmapM == null ? g(i10, i11, config) : bitmapM;
    }

    public final void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f13860g + ", misses=" + this.f13861h + ", puts=" + this.f13862i + ", evictions=" + this.f13863j + ", currentSize=" + this.f13859f + ", maxSize=" + this.f13858e + "\nStrategy=" + this.f13854a);
    }

    public final void j() {
        q(this.f13858e);
    }

    public final synchronized Bitmap m(int i10, int i11, Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.f13854a.d(i10, i11, config != null ? config : f13853k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f13854a.a(i10, i11, config));
                }
                this.f13861h++;
            } else {
                this.f13860g++;
                this.f13859f -= (long) this.f13854a.b(bitmapD);
                this.f13857d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f13854a.a(i10, i11, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    public long n() {
        return this.f13858e;
    }

    public final synchronized void q(long j10) {
        while (this.f13859f > j10) {
            try {
                Bitmap bitmapRemoveLast = this.f13854a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f13859f = 0L;
                    return;
                }
                this.f13857d.a(bitmapRemoveLast);
                this.f13859f -= (long) this.f13854a.b(bitmapRemoveLast);
                this.f13863j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f13854a.e(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(long j10) {
        this(j10, l(), k());
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements a {
        @Override // j3.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // j3.k.a
        public void b(Bitmap bitmap) {
        }
    }
}
