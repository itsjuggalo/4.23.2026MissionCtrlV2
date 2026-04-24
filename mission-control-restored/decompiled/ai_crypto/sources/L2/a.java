package L2;

import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends b {
    public static int a(long j7) {
        if (j7 > 2147483647L) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (j7 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j7;
    }
}
