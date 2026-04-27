package Y0;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9512d;

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f9513i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f9514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ActivityManager f9515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f9516c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f9518e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f9517d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f9519f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f9520g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9521h = 4194304;

        static {
            f9513i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f9518e = f9513i;
            this.f9514a = context;
            this.f9515b = (ActivityManager) context.getSystemService("activity");
            this.f9516c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.e(this.f9515b)) {
                return;
            }
            this.f9518e = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DisplayMetrics f9522a;

        public b(DisplayMetrics displayMetrics) {
            this.f9522a = displayMetrics;
        }

        @Override // Y0.i.c
        public int a() {
            return this.f9522a.heightPixels;
        }

        @Override // Y0.i.c
        public int b() {
            return this.f9522a.widthPixels;
        }
    }

    public interface c {
        int a();

        int b();
    }

    public i(a aVar) {
        this.f9511c = aVar.f9514a;
        int i8 = e(aVar.f9515b) ? aVar.f9521h / 2 : aVar.f9521h;
        this.f9512d = i8;
        int iC = c(aVar.f9515b, aVar.f9519f, aVar.f9520g);
        float fB = aVar.f9516c.b() * aVar.f9516c.a() * 4;
        int iRound = Math.round(aVar.f9518e * fB);
        int iRound2 = Math.round(fB * aVar.f9517d);
        int i9 = iC - i8;
        int i10 = iRound2 + iRound;
        if (i10 <= i9) {
            this.f9510b = iRound2;
            this.f9509a = iRound;
        } else {
            float f8 = i9;
            float f9 = aVar.f9518e;
            float f10 = aVar.f9517d;
            float f11 = f8 / (f9 + f10);
            this.f9510b = Math.round(f10 * f11);
            this.f9509a = Math.round(f11 * aVar.f9518e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f9510b));
            sb.append(", pool size: ");
            sb.append(f(this.f9509a));
            sb.append(", byte array size: ");
            sb.append(f(i8));
            sb.append(", memory class limited? ");
            sb.append(i10 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.f9515b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f9515b));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public static int c(ActivityManager activityManager, float f8, float f9) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f8 = f9;
        }
        return Math.round(memoryClass * f8);
    }

    public static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    public int a() {
        return this.f9512d;
    }

    public int b() {
        return this.f9509a;
    }

    public int d() {
        return this.f9510b;
    }

    public final String f(int i8) {
        return Formatter.formatFileSize(this.f9511c, i8);
    }
}
