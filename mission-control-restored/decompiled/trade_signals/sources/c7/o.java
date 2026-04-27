package c7;

import Y6.x0;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import o5.C2490r;
import s5.C2712j;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;
import u5.AbstractC2777d;
import u5.AbstractC2781h;
import u5.InterfaceC2778e;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends AbstractC2777d implements b7.e, InterfaceC2778e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.e f13602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2711i f13603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC2711i f13605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC2707e f13606e;

    public o(b7.e eVar, InterfaceC2711i interfaceC2711i) {
        super(l.f13597a, C2712j.f23116a);
        this.f13602a = eVar;
        this.f13603b = interfaceC2711i;
        this.f13604c = ((Number) interfaceC2711i.K(0, new B5.o() { // from class: c7.n
            @Override // B5.o
            public final Object invoke(Object obj, Object obj2) {
                return Integer.valueOf(o.j(((Integer) obj).intValue(), (InterfaceC2711i.b) obj2));
            }
        })).intValue();
    }

    public static final int j(int i8, InterfaceC2711i.b bVar) {
        return i8 + 1;
    }

    public final void c(InterfaceC2711i interfaceC2711i, InterfaceC2711i interfaceC2711i2, Object obj) {
        if (interfaceC2711i2 instanceof i) {
            n((i) interfaceC2711i2, obj);
        }
        r.b(this, interfaceC2711i);
    }

    @Override // b7.e
    public Object emit(Object obj, InterfaceC2707e interfaceC2707e) {
        try {
            Object objM = m(interfaceC2707e, obj);
            if (objM == AbstractC2751c.f()) {
                AbstractC2781h.c(interfaceC2707e);
            }
            return objM == AbstractC2751c.f() ? objM : C2470H.f21956a;
        } catch (Throwable th) {
            this.f13605d = new i(th, interfaceC2707e.getContext());
            throw th;
        }
    }

    @Override // u5.AbstractC2774a, u5.InterfaceC2778e
    public InterfaceC2778e getCallerFrame() {
        InterfaceC2707e interfaceC2707e = this.f13606e;
        if (interfaceC2707e instanceof InterfaceC2778e) {
            return (InterfaceC2778e) interfaceC2707e;
        }
        return null;
    }

    @Override // u5.AbstractC2777d, s5.InterfaceC2707e
    public InterfaceC2711i getContext() {
        InterfaceC2711i interfaceC2711i = this.f13605d;
        return interfaceC2711i == null ? C2712j.f23116a : interfaceC2711i;
    }

    @Override // u5.AbstractC2774a
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // u5.AbstractC2774a
    public Object invokeSuspend(Object obj) {
        Throwable thE = C2490r.e(obj);
        if (thE != null) {
            this.f13605d = new i(thE, getContext());
        }
        InterfaceC2707e interfaceC2707e = this.f13606e;
        if (interfaceC2707e != null) {
            interfaceC2707e.resumeWith(obj);
        }
        return AbstractC2751c.f();
    }

    public final Object m(InterfaceC2707e interfaceC2707e, Object obj) {
        InterfaceC2711i context = interfaceC2707e.getContext();
        x0.e(context);
        InterfaceC2711i interfaceC2711i = this.f13605d;
        if (interfaceC2711i != context) {
            c(context, interfaceC2711i, obj);
            this.f13605d = context;
        }
        this.f13606e = interfaceC2707e;
        B5.p pVar = p.f13607a;
        b7.e eVar = this.f13602a;
        AbstractC2304t.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        AbstractC2304t.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = pVar.invoke(eVar, obj, this);
        if (!AbstractC2304t.b(objInvoke, AbstractC2751c.f())) {
            this.f13606e = null;
        }
        return objInvoke;
    }

    public final void n(i iVar, Object obj) {
        throw new IllegalStateException(V6.t.i("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + iVar.f13596b + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // u5.AbstractC2777d, u5.AbstractC2774a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
