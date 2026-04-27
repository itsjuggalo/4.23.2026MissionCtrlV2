package J3;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: J3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0324a implements F3.b {
    public /* synthetic */ AbstractC0324a(AbstractC1585j abstractC1585j) {
        this();
    }

    public static /* synthetic */ void i(AbstractC0324a abstractC0324a, I3.c cVar, int i4, Object obj, boolean z4, int i5, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i5 & 8) != 0) {
            z4 = true;
        }
        abstractC0324a.h(cVar, i4, obj, z4);
    }

    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(Object obj, int i4);

    public abstract Iterator d(Object obj);

    @Override // F3.a
    public Object deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return f(decoder, null);
    }

    public abstract int e(Object obj);

    public final Object f(I3.e decoder, Object obj) {
        Object objA;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        Object obj2 = objA;
        int iB = b(obj2);
        I3.c cVarD = decoder.d(getDescriptor());
        if (!cVarD.w()) {
            while (true) {
                int i4 = cVarD.i(getDescriptor());
                if (i4 == -1) {
                    break;
                }
                i(this, cVarD, iB + i4, obj2, false, 8, null);
            }
        } else {
            g(cVarD, obj2, iB, j(cVarD, obj2));
        }
        cVarD.c(getDescriptor());
        return l(obj2);
    }

    public abstract void g(I3.c cVar, Object obj, int i4, int i5);

    public abstract void h(I3.c cVar, int i4, Object obj, boolean z4);

    public final int j(I3.c cVar, Object obj) {
        int iB = cVar.B(getDescriptor());
        c(obj, iB);
        return iB;
    }

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);

    public AbstractC0324a() {
    }
}
