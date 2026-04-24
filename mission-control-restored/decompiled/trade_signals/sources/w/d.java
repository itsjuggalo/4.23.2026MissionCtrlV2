package w;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.AbstractC2304t;
import x.AbstractC2939a;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final void a(b bVar, int i8) {
        AbstractC2304t.f(bVar, "<this>");
        bVar.F(new int[i8]);
        bVar.C(new Object[i8]);
    }

    public static final int b(b bVar, int i8) {
        AbstractC2304t.f(bVar, "<this>");
        try {
            return AbstractC2939a.a(bVar.e(), bVar.h(), i8);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final int c(b bVar, Object obj, int i8) {
        AbstractC2304t.f(bVar, "<this>");
        int iH = bVar.h();
        if (iH == 0) {
            return -1;
        }
        int iB = b(bVar, i8);
        if (iB < 0 || AbstractC2304t.b(obj, bVar.d()[iB])) {
            return iB;
        }
        int i9 = iB + 1;
        while (i9 < iH && bVar.e()[i9] == i8) {
            if (AbstractC2304t.b(obj, bVar.d()[i9])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iB - 1; i10 >= 0 && bVar.e()[i10] == i8; i10--) {
            if (AbstractC2304t.b(obj, bVar.d()[i10])) {
                return i10;
            }
        }
        return ~i9;
    }

    public static final int d(b bVar) {
        AbstractC2304t.f(bVar, "<this>");
        return c(bVar, null, 0);
    }
}
