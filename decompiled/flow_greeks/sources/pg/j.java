package pg;

import com.google.android.gms.common.api.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final g a(int i10, a aVar, pd.k kVar) {
        if (i10 == -2) {
            return aVar == a.f18621a ? new e(g.O.a(), kVar) : new s(1, aVar, kVar);
        }
        if (i10 != -1) {
            return i10 != 0 ? i10 != Integer.MAX_VALUE ? aVar == a.f18621a ? new e(i10, kVar) : new s(i10, aVar, kVar) : new e(a.e.API_PRIORITY_OTHER, kVar) : aVar == a.f18621a ? new e(0, kVar) : new s(1, aVar, kVar);
        }
        if (aVar == a.f18621a) {
            return new s(1, a.f18622b, kVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ g b(int i10, a aVar, pd.k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            aVar = a.f18621a;
        }
        if ((i11 & 4) != 0) {
            kVar = null;
        }
        return a(i10, aVar, kVar);
    }
}
