package r6;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: r6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2610a implements n6.b {
    public /* synthetic */ AbstractC2610a(AbstractC2148j abstractC2148j) {
        this();
    }

    public static /* synthetic */ void i(AbstractC2610a abstractC2610a, q6.c cVar, int i7, Object obj, boolean z7, int i8, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i8 & 8) != 0) {
            z7 = true;
        }
        abstractC2610a.h(cVar, i7, obj, z7);
    }

    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(Object obj, int i7);

    public abstract Iterator d(Object obj);

    @Override // n6.a
    public Object deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return f(decoder, null);
    }

    public abstract int e(Object obj);

    public final Object f(q6.e decoder, Object obj) {
        Object objA;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        int iB = b(objA);
        q6.c cVarC = decoder.c(getDescriptor());
        if (!cVarC.w()) {
            while (true) {
                int iQ = cVarC.q(getDescriptor());
                if (iQ == -1) {
                    break;
                }
                i(this, cVarC, iB + iQ, objA, false, 8, null);
            }
        } else {
            g(cVarC, objA, iB, j(cVarC, objA));
        }
        cVarC.b(getDescriptor());
        return l(objA);
    }

    public abstract void g(q6.c cVar, Object obj, int i7, int i8);

    public abstract void h(q6.c cVar, int i7, Object obj, boolean z7);

    public final int j(q6.c cVar, Object obj) {
        int iN = cVar.n(getDescriptor());
        c(obj, iN);
        return iN;
    }

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);

    public AbstractC2610a() {
    }
}
