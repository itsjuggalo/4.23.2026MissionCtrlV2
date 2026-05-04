package e6;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements Comparator {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        com.google.android.gms.common.internal.s.k(cVar);
        com.google.android.gms.common.internal.s.k(cVar2);
        int iR = cVar.R();
        int iR2 = cVar2.R();
        if (iR != iR2) {
            return iR >= iR2 ? 1 : -1;
        }
        int iS = cVar.S();
        int iS2 = cVar2.S();
        if (iS == iS2) {
            return 0;
        }
        return iS < iS2 ? -1 : 1;
    }
}
