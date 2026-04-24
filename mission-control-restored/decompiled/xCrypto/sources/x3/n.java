package x3;

import W2.E;
import Z2.i;
import a3.AbstractC0787c;
import b3.AbstractC0866d;
import b3.InterfaceC0867e;
import t3.A0;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends AbstractC0866d implements w3.e, InterfaceC0867e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w3.e f15778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Z2.i f15779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Z2.i f15781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Z2.e f15782e;

    public static final class a extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15783a = new a();

        public a() {
            super(2);
        }

        public final Integer a(int i4, i.b bVar) {
            return Integer.valueOf(i4 + 1);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (i.b) obj2);
        }
    }

    public n(w3.e eVar, Z2.i iVar) {
        super(l.f15773a, Z2.j.f6012a);
        this.f15778a = eVar;
        this.f15779b = iVar;
        this.f15780c = ((Number) iVar.fold(0, a.f15783a)).intValue();
    }

    public final void b(Z2.i iVar, Z2.i iVar2, Object obj) {
        if (iVar2 instanceof i) {
            d((i) iVar2, obj);
        }
        p.a(this, iVar);
    }

    public final Object c(Z2.e eVar, Object obj) {
        Z2.i context = eVar.getContext();
        A0.h(context);
        Z2.i iVar = this.f15781d;
        if (iVar != context) {
            b(context, iVar, obj);
            this.f15781d = context;
        }
        this.f15782e = eVar;
        i3.p pVar = o.f15784a;
        w3.e eVar2 = this.f15778a;
        kotlin.jvm.internal.r.d(eVar2, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.r.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = pVar.invoke(eVar2, obj, this);
        if (!kotlin.jvm.internal.r.b(objInvoke, AbstractC0787c.e())) {
            this.f15782e = null;
        }
        return objInvoke;
    }

    public final void d(i iVar, Object obj) {
        throw new IllegalStateException(r3.q.i("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f15771a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // w3.e
    public Object emit(Object obj, Z2.e eVar) {
        try {
            Object objC = c(eVar, obj);
            if (objC == AbstractC0787c.e()) {
                b3.h.c(eVar);
            }
            return objC == AbstractC0787c.e() ? objC : E.f5463a;
        } catch (Throwable th) {
            this.f15781d = new i(th, eVar.getContext());
            throw th;
        }
    }

    @Override // b3.AbstractC0863a, b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.f15782e;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    @Override // b3.AbstractC0866d, Z2.e
    public Z2.i getContext() {
        Z2.i iVar = this.f15781d;
        return iVar == null ? Z2.j.f6012a : iVar;
    }

    @Override // b3.AbstractC0863a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // b3.AbstractC0863a
    public Object invokeSuspend(Object obj) {
        Throwable thE = W2.p.e(obj);
        if (thE != null) {
            this.f15781d = new i(thE, getContext());
        }
        Z2.e eVar = this.f15782e;
        if (eVar != null) {
            eVar.resumeWith(obj);
        }
        return AbstractC0787c.e();
    }

    @Override // b3.AbstractC0866d, b3.AbstractC0863a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
