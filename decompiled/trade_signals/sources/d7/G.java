package d7;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class G {
    public static final int a(String str, int i8, int i9, int i10) {
        return (int) E.c(str, i8, i9, i10);
    }

    public static final long b(String str, long j8, long j9, long j10) {
        String strD = E.d(str);
        if (strD == null) {
            return j8;
        }
        Long lP = V6.z.p(strD);
        if (lP == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strD + '\'').toString());
        }
        long jLongValue = lP.longValue();
        if (j9 <= jLongValue && jLongValue <= j10) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j9 + ".." + j10 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String c(String str, String str2) {
        String strD = E.d(str);
        return strD == null ? str2 : strD;
    }

    public static final boolean d(String str, boolean z7) {
        String strD = E.d(str);
        return strD != null ? Boolean.parseBoolean(strD) : z7;
    }

    public static /* synthetic */ int e(String str, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i9 = 1;
        }
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return E.b(str, i8, i9, i10);
    }

    public static /* synthetic */ long f(String str, long j8, long j9, long j10, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            j9 = 1;
        }
        long j11 = j9;
        if ((i8 & 8) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return E.c(str, j8, j11, j10);
    }
}
