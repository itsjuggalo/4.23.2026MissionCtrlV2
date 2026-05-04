package ub;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import rb.m0;
import rb.y0;
import tb.r2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f22907a = Logger.getLogger(s.class.getName());

    public static y0 a(List list) {
        return m0.c(b(list));
    }

    public static byte[][] b(List list) {
        byte[][] bArr = new byte[list.size() * 2][];
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            wb.d dVar = (wb.d) it.next();
            int i11 = i10 + 1;
            bArr[i10] = dVar.f23824a.H();
            i10 += 2;
            bArr[i11] = dVar.f23825b.H();
        }
        return r2.e(bArr);
    }

    public static y0 c(List list) {
        return m0.c(b(list));
    }
}
