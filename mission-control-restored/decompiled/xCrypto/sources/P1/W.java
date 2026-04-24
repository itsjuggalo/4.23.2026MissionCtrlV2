package P1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class W implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        C0492c c0492c = (C0492c) obj;
        C0492c c0492c2 = (C0492c) obj2;
        AbstractC0940s.k(c0492c);
        AbstractC0940s.k(c0492c2);
        int i4 = c0492c.i();
        int i5 = c0492c2.i();
        if (i4 != i5) {
            return i4 >= i5 ? 1 : -1;
        }
        int iK = c0492c.k();
        int iK2 = c0492c2.k();
        if (iK == iK2) {
            return 0;
        }
        return iK < iK2 ? -1 : 1;
    }
}
