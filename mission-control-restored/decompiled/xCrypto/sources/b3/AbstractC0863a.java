package b3;

import W2.p;
import W2.q;
import a3.AbstractC0787c;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: b3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0863a implements Z2.e, InterfaceC0867e, Serializable {
    private final Z2.e completion;

    public AbstractC0863a(Z2.e eVar) {
        this.completion = eVar;
    }

    public Z2.e create(Z2.e completion) {
        r.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // b3.InterfaceC0867e
    public InterfaceC0867e getCallerFrame() {
        Z2.e eVar = this.completion;
        if (eVar instanceof InterfaceC0867e) {
            return (InterfaceC0867e) eVar;
        }
        return null;
    }

    public final Z2.e getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // Z2.e
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        Z2.e eVar = this;
        while (true) {
            h.b(eVar);
            AbstractC0863a abstractC0863a = (AbstractC0863a) eVar;
            Z2.e eVar2 = abstractC0863a.completion;
            r.c(eVar2);
            try {
                objInvokeSuspend = abstractC0863a.invokeSuspend(obj);
            } catch (Throwable th) {
                p.a aVar = p.f5487b;
                obj = p.b(q.a(th));
            }
            if (objInvokeSuspend == AbstractC0787c.e()) {
                return;
            }
            obj = p.b(objInvokeSuspend);
            abstractC0863a.releaseIntercepted();
            if (!(eVar2 instanceof AbstractC0863a)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Z2.e create(Object obj, Z2.e completion) {
        r.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
