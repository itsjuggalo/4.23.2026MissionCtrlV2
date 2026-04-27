package u5;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import r5.M;
import r5.Z;
import t5.S0;
import w5.C2781d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f24688a = Logger.getLogger(s.class.getName());

    public static Z a(List list) {
        return M.c(b(list));
    }

    public static byte[][] b(List list) {
        byte[][] bArr = new byte[list.size() * 2][];
        Iterator it = list.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            C2781d c2781d = (C2781d) it.next();
            int i8 = i7 + 1;
            bArr[i7] = c2781d.f24976a.M();
            i7 += 2;
            bArr[i8] = c2781d.f24977b.M();
        }
        return S0.e(bArr);
    }

    public static Z c(List list) {
        return M.c(b(list));
    }
}
