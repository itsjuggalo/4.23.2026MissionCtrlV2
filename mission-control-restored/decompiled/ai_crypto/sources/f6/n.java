package f6;

import E5.E;
import H5.g;
import b6.A0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends J5.d implements e6.e, J5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e6.e f14212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H5.g f14213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public H5.g f14215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public H5.d f14216e;

    public static final class a extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14217a = new a();

        public a() {
            super(2);
        }

        public final Integer a(int i7, g.b bVar) {
            return Integer.valueOf(i7 + 1);
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public n(e6.e eVar, H5.g gVar) {
        super(l.f14207a, H5.h.f2671a);
        this.f14212a = eVar;
        this.f14213b = gVar;
        this.f14214c = ((Number) gVar.fold(0, a.f14217a)).intValue();
    }

    @Override // e6.e
    public Object d(Object obj, H5.d dVar) {
        try {
            Object objJ = j(dVar, obj);
            if (objJ == I5.c.e()) {
                J5.h.c(dVar);
            }
            return objJ == I5.c.e() ? objJ : E.f1657a;
        } catch (Throwable th) {
            this.f14215d = new i(th, dVar.getContext());
            throw th;
        }
    }

    @Override // J5.a, J5.e
    public J5.e getCallerFrame() {
        H5.d dVar = this.f14216e;
        if (dVar instanceof J5.e) {
            return (J5.e) dVar;
        }
        return null;
    }

    @Override // J5.d, H5.d
    public H5.g getContext() {
        H5.g gVar = this.f14215d;
        return gVar == null ? H5.h.f2671a : gVar;
    }

    @Override // J5.a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h(H5.g gVar, H5.g gVar2, Object obj) {
        if (gVar2 instanceof i) {
            k((i) gVar2, obj);
        }
        p.a(this, gVar);
    }

    @Override // J5.a
    public Object invokeSuspend(Object obj) {
        Throwable thE = E5.p.e(obj);
        if (thE != null) {
            this.f14215d = new i(thE, getContext());
        }
        H5.d dVar = this.f14216e;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return I5.c.e();
    }

    public final Object j(H5.d dVar, Object obj) {
        H5.g context = dVar.getContext();
        A0.h(context);
        H5.g gVar = this.f14215d;
        if (gVar != context) {
            h(context, gVar, obj);
            this.f14215d = context;
        }
        this.f14216e = dVar;
        Q5.p pVar = o.f14218a;
        e6.e eVar = this.f14212a;
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = pVar.invoke(eVar, obj, this);
        if (!kotlin.jvm.internal.r.b(objInvoke, I5.c.e())) {
            this.f14216e = null;
        }
        return objInvoke;
    }

    public final void k(i iVar, Object obj) {
        throw new IllegalStateException(Z5.m.e("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f14205a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // J5.d, J5.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
