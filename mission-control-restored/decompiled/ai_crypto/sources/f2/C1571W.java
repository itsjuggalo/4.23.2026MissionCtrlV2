package f2;

import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Comparator;

/* JADX INFO: renamed from: f2.W, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1571W implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C1577c c1577c = (C1577c) obj;
        C1577c c1577c2 = (C1577c) obj2;
        AbstractC1207s.k(c1577c);
        AbstractC1207s.k(c1577c2);
        int iA = c1577c.A();
        int iA2 = c1577c2.A();
        if (iA != iA2) {
            return iA >= iA2 ? 1 : -1;
        }
        int iB = c1577c.B();
        int iB2 = c1577c2.B();
        if (iB == iB2) {
            return 0;
        }
        return iB < iB2 ? -1 : 1;
    }
}
