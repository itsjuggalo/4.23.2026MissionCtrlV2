package P1;

import com.google.android.gms.common.api.Status;

/* JADX INFO: renamed from: P1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0504o {
    public static int a(int i4) {
        if ((i4 < 0 || i4 > 1) && (i4 < 1000 || i4 >= 1006)) {
            return 1;
        }
        return i4;
    }

    public static Status b(int i4) {
        if (i4 == 1) {
            i4 = 13;
        }
        return new Status(i4);
    }
}
