package k3;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f14507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14508d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f14509i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f14510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ActivityManager f14511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f14512c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f14514e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f14513d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f14515f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f14516g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14517h = 4194304;

        static {
            f14509i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f14514e = f14509i;
            this.f14510a = context;
            this.f14511b = (ActivityManager) context.getSystemService("activity");
            this.f14512c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.e(this.f14511b)) {
                return;
            }
            this.f14514e = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f14518a;

        public b(DisplayMetrics displayMetrics) {
            this.f14518a = displayMetrics;
        }

        @Override // k3.i.c
        public int a() {
            return this.f14518a.heightPixels;
        }

        @Override // k3.i.c
        public int b() {
            return this.f14518a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f14507c = aVar.f14510a;
        int i10 = e(aVar.f14511b) ? aVar.f14517h / 2 : aVar.f14517h;
        this.f14508d = i10;
        int iC = c(aVar.f14511b, aVar.f14515f, aVar.f14516g);
        float fB = aVar.f14512c.b() * aVar.f14512c.a() * 4;
        int iRound = Math.round(aVar.f14514e * fB);
        int iRound2 = Math.round(fB * aVar.f14513d);
        int i11 = iC - i10;
        int i12 = iRound2 + iRound;
        if (i12 <= i11) {
            this.f14506b = iRound2;
            this.f14505a = iRound;
        } else {
            float f10 = i11;
            float f11 = aVar.f14514e;
            float f12 = aVar.f14513d;
            float f13 = f10 / (f11 + f12);
            this.f14506b = Math.round(f12 * f13);
            this.f14505a = Math.round(f13 * aVar.f14514e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f14506b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f14505a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            sb2.append(i12 > iC);
            sb2.append(", max size: ");
            sb2.append(f(iC));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f14511b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f14511b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    public static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    public static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.f14508d;
    }

    public int b() {
        return this.f14505a;
    }

    public int d() {
        return this.f14506b;
    }

    public final String f(int i10) {
        return Formatter.formatFileSize(this.f14507c, i10);
    }
}
