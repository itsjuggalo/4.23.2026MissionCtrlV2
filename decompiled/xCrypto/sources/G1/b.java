package G1;

import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static boolean a(int[] iArr, int i4) {
        if (iArr != null) {
            for (int i5 : iArr) {
                if (i5 == i4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            if (!AbstractC0939q.b(objArr[i4], obj)) {
                i4++;
            } else if (i4 >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void c(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(dArr[i4]);
        }
    }

    public static void d(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(fArr[i4]);
        }
    }

    public static void e(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(iArr[i4]);
        }
    }

    public static void f(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(jArr[i4]);
        }
    }

    public static void g(StringBuilder sb, Object[] objArr) {
        int length = objArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(objArr[i4]);
        }
    }

    public static void h(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append(zArr[i4]);
        }
    }

    public static void i(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != 0) {
                sb.append(com.amazon.a.a.o.b.f.f8804a);
            }
            sb.append("\"");
            sb.append(strArr[i4]);
            sb.append("\"");
        }
    }
}
