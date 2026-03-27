package g6;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class I {
    public static final int a(String str, int i7, int i8, int i9) {
        return (int) G.c(str, i7, i8, i9);
    }

    public static final long b(String str, long j7, long j8, long j9) {
        String strD = G.d(str);
        if (strD == null) {
            return j7;
        }
        Long lK = Z5.s.k(strD);
        if (lK == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lK.longValue();
        if (j8 <= jLongValue && jLongValue <= j9) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j8 + ".." + j9 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = G.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z7) {
        String strD = G.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z7;
    }

    public static /* synthetic */ int e(String str, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            i8 = 1;
        }
        if ((i10 & 8) != 0) {
            i9 = a.e.API_PRIORITY_OTHER;
        }
        return G.b(str, i7, i8, i9);
    }

    public static /* synthetic */ long f(String str, long j7, long j8, long j9, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            j8 = 1;
        }
        long j10 = j8;
        if ((i7 & 8) != 0) {
            j9 = Long.MAX_VALUE;
        }
        return G.c(str, j7, j10, j9);
    }
}
