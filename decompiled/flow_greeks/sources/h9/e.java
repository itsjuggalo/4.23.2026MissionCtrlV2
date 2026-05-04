package h9;

import j9.k;
import n9.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Comparable {
    public static e b(int i10, k kVar, byte[] bArr, byte[] bArr2) {
        return new a(i10, kVar, bArr, bArr2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int iCompare = Integer.compare(k(), eVar.k());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = i().compareTo(eVar.i());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i10 = g0.i(c(), eVar.c());
        return i10 != 0 ? i10 : g0.i(h(), eVar.h());
    }

    public abstract byte[] c();

    public abstract byte[] h();

    public abstract k i();

    public abstract int k();
}
