package f2;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: f2.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1589o {
    public static int a(int i7) {
        if ((i7 < 0 || i7 > 1) && (i7 < 1000 || i7 >= 1006)) {
            return 1;
        }
        return i7;
    }

    public static Status b(int i7) {
        if (i7 == 1) {
            i7 = 13;
        }
        return new Status(i7);
    }
}
