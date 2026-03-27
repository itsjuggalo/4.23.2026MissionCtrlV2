package H4;

import F4.K;
import F4.X;
import G4.S0;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f3953a = Logger.getLogger(s.class.getName());

    public static X a(List list) {
        return K.c(b(list));
    }

    public static byte[][] b(List list) {
        byte[][] bArr = new byte[list.size() * 2][];
        Iterator it = list.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            J4.d dVar = (J4.d) it.next();
            int i9 = i8 + 1;
            bArr[i8] = dVar.f4579a.W();
            i8 += 2;
            bArr[i9] = dVar.f4580b.W();
        }
        return S0.e(bArr);
    }

    public static X c(List list) {
        return K.c(b(list));
    }
}
