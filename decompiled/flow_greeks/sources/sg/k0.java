package sg;

import gd.i;
import ng.u2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f20405a = new d0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final pd.o f20406b = new pd.o() { // from class: sg.h0
        @Override // pd.o
        public final Object invoke(Object obj, Object obj2) {
            return k0.d(obj, (i.b) obj2);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pd.o f20407c = new pd.o() { // from class: sg.i0
        @Override // pd.o
        public final Object invoke(Object obj, Object obj2) {
            return k0.e((u2) obj, (i.b) obj2);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final pd.o f20408d = new pd.o() { // from class: sg.j0
        @Override // pd.o
        public final Object invoke(Object obj, Object obj2) {
            return k0.h((o0) obj, (i.b) obj2);
        }
    };

    public static final Object d(Object obj, i.b bVar) {
        if (!(bVar instanceof u2)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
    }

    public static final u2 e(u2 u2Var, i.b bVar) {
        if (u2Var != null) {
            return u2Var;
        }
        if (bVar instanceof u2) {
            return (u2) bVar;
        }
        return null;
    }

    public static final void f(gd.i iVar, Object obj) {
        if (obj == f20405a) {
            return;
        }
        if (obj instanceof o0) {
            ((o0) obj).b(iVar);
            return;
        }
        Object objFold = iVar.fold(null, f20407c);
        kotlin.jvm.internal.t.d(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((u2) objFold).e(iVar, obj);
    }

    public static final Object g(gd.i iVar) {
        Object objFold = iVar.fold(0, f20406b);
        kotlin.jvm.internal.t.c(objFold);
        return objFold;
    }

    public static final o0 h(o0 o0Var, i.b bVar) {
        if (bVar instanceof u2) {
            u2 u2Var = (u2) bVar;
            o0Var.a(u2Var, u2Var.u(o0Var.f20415a));
        }
        return o0Var;
    }

    public static final Object i(gd.i iVar, Object obj) {
        if (obj == null) {
            obj = g(iVar);
        }
        if (obj == 0) {
            return f20405a;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new o0(iVar, ((Number) obj).intValue()), f20408d);
        }
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((u2) obj).u(iVar);
    }
}
