package e6;

import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o {
    public static int a(int i10) {
        if ((i10 < 0 || i10 > 1) && (i10 < 1000 || i10 >= 1006)) {
            return 1;
        }
        return i10;
    }

    public static Status b(int i10) {
        if (i10 == 1) {
            i10 = 13;
        }
        return new Status(i10);
    }
}
