package N2;

import K2.M;
import K2.Z;
import M2.S0;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3096a = Logger.getLogger(s.class.getName());

    public static Z a(List list) {
        return M.c(b(list));
    }

    public static byte[][] b(List list) {
        byte[][] bArr = new byte[list.size() * 2][];
        Iterator it = list.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            P2.d dVar = (P2.d) it.next();
            int i5 = i4 + 1;
            bArr[i4] = dVar.f3475a.y();
            i4 += 2;
            bArr[i5] = dVar.f3476b.y();
        }
        return S0.e(bArr);
    }

    public static Z c(List list) {
        return M.c(b(list));
    }
}
