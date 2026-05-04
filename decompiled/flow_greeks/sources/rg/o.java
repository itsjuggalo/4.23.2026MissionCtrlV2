package rg;

import cd.h0;
import gd.i;
import ng.b2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends id.d implements qg.e, id.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qg.e f19907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gd.i f19908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gd.i f19910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gd.e f19911e;

    public o(qg.e eVar, gd.i iVar) {
        super(l.f19902a, gd.j.f10531a);
        this.f19907a = eVar;
        this.f19908b = iVar;
        this.f19909c = ((Number) iVar.fold(0, new pd.o() { // from class: rg.n
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(o.n(((Integer) obj).intValue(), (i.b) obj2));
            }
        })).intValue();
    }

    public static final int n(int i10, i.b bVar) {
        return i10 + 1;
    }

    @Override // qg.e
    public Object emit(Object obj, gd.e eVar) {
        try {
            Object objO = o(eVar, obj);
            if (objO == hd.c.f()) {
                id.h.c(eVar);
            }
            return objO == hd.c.f() ? objO : h0.f3852a;
        } catch (Throwable th) {
            this.f19910d = new i(th, eVar.getContext());
            throw th;
        }
    }

    @Override // id.a, id.e
    public id.e getCallerFrame() {
        gd.e eVar = this.f19911e;
        if (eVar instanceof id.e) {
            return (id.e) eVar;
        }
        return null;
    }

    @Override // id.d, gd.e
    public gd.i getContext() {
        gd.i iVar = this.f19910d;
        return iVar == null ? gd.j.f10531a : iVar;
    }

    @Override // id.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // id.a
    public Object invokeSuspend(Object obj) {
        Throwable thE = cd.r.e(obj);
        if (thE != null) {
            this.f19910d = new i(thE, getContext());
        }
        gd.e eVar = this.f19911e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return hd.c.f();
    }

    public final void l(gd.i iVar, gd.i iVar2, Object obj) {
        if (iVar2 instanceof i) {
            q((i) iVar2, obj);
        }
        r.b(this, iVar);
    }

    public final Object o(gd.e eVar, Object obj) {
        gd.i context = eVar.getContext();
        b2.g(context);
        gd.i iVar = this.f19910d;
        if (iVar != context) {
            l(context, iVar, obj);
            this.f19910d = context;
        }
        this.f19911e = eVar;
        pd.p pVar = p.f19912a;
        qg.e eVar2 = this.f19907a;
        kotlin.jvm.internal.t.d(eVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.t.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = pVar.invoke(eVar2, obj, this);
        if (!kotlin.jvm.internal.t.b(objInvoke, hd.c.f())) {
            this.f19911e = null;
        }
        return objInvoke;
    }

    public final void q(i iVar, Object obj) {
        throw new IllegalStateException(kg.s.i("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f19901b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // id.d, id.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
