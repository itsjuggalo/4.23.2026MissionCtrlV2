package u4;

import java.util.Comparator;
import x4.C1412h;

/* JADX INFO: loaded from: classes.dex */
public final class S implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i;
        Q q6 = (Q) obj2;
        ((C1412h) ((Q) obj)).getClass();
        int i6 = 3;
        try {
            Class.forName("android.app.Application", false, C1412h.class.getClassLoader());
            i = 8;
        } catch (Exception unused) {
            i = 3;
        }
        ((C1412h) q6).getClass();
        try {
            Class.forName("android.app.Application", false, C1412h.class.getClassLoader());
            i6 = 8;
        } catch (Exception unused2) {
        }
        return i - i6;
    }
}
