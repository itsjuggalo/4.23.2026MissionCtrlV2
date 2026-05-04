package w;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final void a(b bVar, int i10) {
        t.f(bVar, "<this>");
        bVar.r(new int[i10]);
        bVar.q(new Object[i10]);
    }

    public static final int b(b bVar, int i10) {
        t.f(bVar, "<this>");
        try {
            return x.a.a(bVar.e(), bVar.g(), i10);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(b bVar, Object obj, int i10) {
        t.f(bVar, "<this>");
        int iG = bVar.g();
        if (iG == 0) {
            return -1;
        }
        int iB = b(bVar, i10);
        if (iB < 0 || t.b(obj, bVar.c()[iB])) {
            return iB;
        }
        int i11 = iB + 1;
        while (i11 < iG && bVar.e()[i11] == i10) {
            if (t.b(obj, bVar.c()[i11])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iB - 1; i12 >= 0 && bVar.e()[i12] == i10; i12--) {
            if (t.b(obj, bVar.c()[i12])) {
                return i12;
            }
        }
        return ~i11;
    }

    public static final int d(b bVar) {
        t.f(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
