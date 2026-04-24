package q1;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import m1.AbstractC2342a;

/* JADX INFO: renamed from: q1.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2629l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f22538a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f22539b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Handler f22540c;

    /* JADX INFO: renamed from: q1.l$a */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22541a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f22541a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22541a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22541a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22541a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f22541a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!r()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean b(AbstractC2342a abstractC2342a, AbstractC2342a abstractC2342a2) {
        return abstractC2342a == null ? abstractC2342a2 == null : abstractC2342a.D(abstractC2342a2);
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static String e(byte[] bArr, char[] cArr) {
        for (int i8 = 0; i8 < bArr.length; i8++) {
            byte b8 = bArr[i8];
            int i9 = i8 * 2;
            char[] cArr2 = f22538a;
            cArr[i9] = cArr2[(b8 & 255) >>> 4];
            cArr[i9 + 1] = cArr2[b8 & 15];
        }
        return new String(cArr);
    }

    public static Queue f(int i8) {
        return new ArrayDeque(i8);
    }

    public static int g(int i8, int i9, Bitmap.Config config) {
        return i8 * i9 * i(config);
    }

    public static int h(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i8 = a.f22541a[config.ordinal()];
        if (i8 == 1) {
            return 1;
        }
        if (i8 == 2 || i8 == 3) {
            return 2;
        }
        return i8 != 4 ? 4 : 8;
    }

    public static List j(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler k() {
        if (f22540c == null) {
            synchronized (AbstractC2629l.class) {
                try {
                    if (f22540c == null) {
                        f22540c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f22540c;
    }

    public static int l(float f8) {
        return m(f8, 17);
    }

    public static int m(float f8, int i8) {
        return n(Float.floatToIntBits(f8), i8);
    }

    public static int n(int i8, int i9) {
        return (i9 * 31) + i8;
    }

    public static int o(Object obj, int i8) {
        return n(obj == null ? 0 : obj.hashCode(), i8);
    }

    public static int p(boolean z7, int i8) {
        return n(z7 ? 1 : 0, i8);
    }

    public static boolean q() {
        return !r();
    }

    public static boolean r() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean s(int i8) {
        return i8 > 0 || i8 == Integer.MIN_VALUE;
    }

    public static boolean t(int i8, int i9) {
        return s(i8) && s(i9);
    }

    public static void u(Runnable runnable) {
        k().post(runnable);
    }

    public static void v(Runnable runnable) {
        k().removeCallbacks(runnable);
    }

    public static String w(byte[] bArr) {
        String strE;
        char[] cArr = f22539b;
        synchronized (cArr) {
            strE = e(bArr, cArr);
        }
        return strE;
    }
}
