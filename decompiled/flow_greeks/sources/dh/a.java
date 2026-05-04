package dh;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements zg.b {
    public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
        this();
    }

    public static /* synthetic */ void i(a aVar, ch.c cVar, int i10, Object obj, boolean z10, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readElement");
        }
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        aVar.h(cVar, i10, obj, z10);
    }

    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(Object obj, int i10);

    public abstract Iterator d(Object obj);

    @Override // zg.a
    public Object deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return f(decoder, null);
    }

    public abstract int e(Object obj);

    public final Object f(ch.e decoder, Object obj) {
        Object objA;
        kotlin.jvm.internal.t.f(decoder, "decoder");
        if (obj == null || (objA = k(obj)) == null) {
            objA = a();
        }
        Object obj2 = objA;
        int iB = b(obj2);
        ch.c cVarB = decoder.b(getDescriptor());
        if (!cVarB.z()) {
            while (true) {
                int iW = cVarB.w(getDescriptor());
                if (iW == -1) {
                    break;
                }
                i(this, cVarB, iB + iW, obj2, false, 8, null);
            }
        } else {
            g(cVarB, obj2, iB, j(cVarB, obj2));
        }
        cVarB.c(getDescriptor());
        return l(obj2);
    }

    public abstract void g(ch.c cVar, Object obj, int i10, int i11);

    public abstract void h(ch.c cVar, int i10, Object obj, boolean z10);

    public final int j(ch.c cVar, Object obj) {
        int iO = cVar.o(getDescriptor());
        c(obj, iO);
        return iO;
    }

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);

    public a() {
    }
}
