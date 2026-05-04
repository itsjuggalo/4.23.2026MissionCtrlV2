package jf;

import fe.k1;
import fe.y0;
import fe.z;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14335a = new l();

    public static Integer b(fe.m mVar, fe.m mVar2) {
        int iC = c(mVar2) - c(mVar);
        if (iC != 0) {
            return Integer.valueOf(iC);
        }
        if (i.B(mVar) && i.B(mVar2)) {
            return 0;
        }
        int iCompareTo = mVar.getName().compareTo(mVar2.getName());
        if (iCompareTo != 0) {
            return Integer.valueOf(iCompareTo);
        }
        return null;
    }

    public static int c(fe.m mVar) {
        if (i.B(mVar)) {
            return 8;
        }
        if (mVar instanceof fe.l) {
            return 7;
        }
        if (mVar instanceof y0) {
            return ((y0) mVar).k0() == null ? 6 : 5;
        }
        if (mVar instanceof z) {
            return ((z) mVar).k0() == null ? 4 : 3;
        }
        if (mVar instanceof fe.e) {
            return 2;
        }
        return mVar instanceof k1 ? 1 : 0;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(fe.m mVar, fe.m mVar2) {
        Integer numB = b(mVar, mVar2);
        if (numB != null) {
            return numB.intValue();
        }
        return 0;
    }
}
