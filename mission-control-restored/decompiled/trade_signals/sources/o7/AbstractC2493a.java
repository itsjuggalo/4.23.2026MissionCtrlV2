package o7;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2493a implements k7.b {
    public AbstractC2493a() {
    }

    public static /* synthetic */ void i(AbstractC2493a abstractC2493a, n7.c cVar, int i8, Object obj, boolean z7, int i9, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i9 & 8) != 0) {
            z7 = true;
        }
        abstractC2493a.h(cVar, i8, obj, z7);
    }

    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(Object obj, int i8);

    public abstract Iterator d(Object obj);

    @Override // k7.a
    public Object deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return f(decoder, null);
    }

    public abstract int e(Object obj);

    public final Object f(n7.e decoder, Object obj) {
        Object objA;
        AbstractC2304t.f(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        int iB = b(objA);
        n7.c cVarC = decoder.c(getDescriptor());
        if (!cVarC.w()) {
            while (true) {
                int iE = cVarC.E(getDescriptor());
                if (iE == -1) {
                    break;
                }
                i(this, cVarC, iB + iE, objA, false, 8, null);
            }
        } else {
            g(cVarC, objA, iB, j(cVarC, objA));
        }
        cVarC.d(getDescriptor());
        return l(objA);
    }

    public abstract void g(n7.c cVar, Object obj, int i8, int i9);

    public abstract void h(n7.c cVar, int i8, Object obj, boolean z7);

    public final int j(n7.c cVar, Object obj) {
        int iK = cVar.k(getDescriptor());
        c(obj, iK);
        return iK;
    }

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);

    public /* synthetic */ AbstractC2493a(AbstractC2296k abstractC2296k) {
        this();
    }
}
