package E3;

import G3.k;
import K3.I;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Comparable {
    public static e b(int i7, k kVar, byte[] bArr, byte[] bArr2) {
        return new a(i7, kVar, bArr, bArr2);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(e eVar) {
        int iCompare = Integer.compare(j(), eVar.j());
        if (iCompare != 0) {
            return iCompare;
        }
        int iCompareTo = i().compareTo(eVar.i());
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i7 = I.i(c(), eVar.c());
        return i7 != 0 ? i7 : I.i(h(), eVar.h());
    }

    public abstract byte[] c();

    public abstract byte[] h();

    public abstract k i();

    public abstract int j();
}
