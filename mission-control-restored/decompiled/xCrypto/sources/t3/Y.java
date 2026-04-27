package t3;

import W2.AbstractC0737e;
import W2.p;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import y3.C1956j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Y extends A3.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14971c;

    public Y(int i4) {
        this.f14971c = i4;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract Z2.e c();

    public Throwable d(Object obj) {
        C c4 = obj instanceof C ? (C) obj : null;
        if (c4 != null) {
            return c4.f14907a;
        }
        return null;
    }

    public final void f(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC0737e.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.r.c(th);
        K.a(c().getContext(), new O("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object k();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objB;
        Object objB2;
        A3.i iVar = this.f92b;
        try {
            Z2.e eVarC = c();
            kotlin.jvm.internal.r.d(eVarC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C1956j c1956j = (C1956j) eVarC;
            Z2.e eVar = c1956j.f15985e;
            Object obj = c1956j.f15987g;
            Z2.i context = eVar.getContext();
            Object objC = y3.J.c(context, obj);
            Z0 z0G = objC != y3.J.f15961a ? H.g(eVar, context, objC) : null;
            try {
                Z2.i context2 = eVar.getContext();
                Object objK = k();
                Throwable thD = d(objK);
                InterfaceC1846w0 interfaceC1846w0 = (thD == null && Z.b(this.f14971c)) ? (InterfaceC1846w0) context2.get(InterfaceC1846w0.f15039M) : null;
                if (interfaceC1846w0 != null && !interfaceC1846w0.isActive()) {
                    CancellationException cancellationException = interfaceC1846w0.getCancellationException();
                    a(objK, cancellationException);
                    p.a aVar = W2.p.f5487b;
                    eVar.resumeWith(W2.p.b(W2.q.a(cancellationException)));
                } else if (thD != null) {
                    p.a aVar2 = W2.p.f5487b;
                    eVar.resumeWith(W2.p.b(W2.q.a(thD)));
                } else {
                    p.a aVar3 = W2.p.f5487b;
                    eVar.resumeWith(W2.p.b(e(objK)));
                }
                W2.E e4 = W2.E.f5463a;
                if (z0G == null || z0G.O0()) {
                    y3.J.a(context, objC);
                }
                try {
                    iVar.a();
                    objB2 = W2.p.b(W2.E.f5463a);
                } catch (Throwable th) {
                    p.a aVar4 = W2.p.f5487b;
                    objB2 = W2.p.b(W2.q.a(th));
                }
                f(null, W2.p.e(objB2));
            } catch (Throwable th2) {
                if (z0G == null || z0G.O0()) {
                    y3.J.a(context, objC);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                p.a aVar5 = W2.p.f5487b;
                iVar.a();
                objB = W2.p.b(W2.E.f5463a);
            } catch (Throwable th4) {
                p.a aVar6 = W2.p.f5487b;
                objB = W2.p.b(W2.q.a(th4));
            }
            f(th3, W2.p.e(objB));
        }
    }

    public Object e(Object obj) {
        return obj;
    }
}
