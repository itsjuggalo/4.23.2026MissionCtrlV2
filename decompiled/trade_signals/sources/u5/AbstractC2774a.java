package u5;

import java.io.Serializable;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2490r;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;

/* JADX INFO: renamed from: u5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2774a implements InterfaceC2707e, InterfaceC2778e, Serializable {
    private final InterfaceC2707e completion;

    public AbstractC2774a(InterfaceC2707e interfaceC2707e) {
        this.completion = interfaceC2707e;
    }

    public InterfaceC2707e create(Object obj, InterfaceC2707e completion) {
        AbstractC2304t.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public InterfaceC2778e getCallerFrame() {
        InterfaceC2707e interfaceC2707e = this.completion;
        if (interfaceC2707e instanceof InterfaceC2778e) {
            return (InterfaceC2778e) interfaceC2707e;
        }
        return null;
    }

    public final InterfaceC2707e getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return AbstractC2780g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // s5.InterfaceC2707e
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        InterfaceC2707e interfaceC2707e = this;
        while (true) {
            AbstractC2781h.b(interfaceC2707e);
            AbstractC2774a abstractC2774a = (AbstractC2774a) interfaceC2707e;
            InterfaceC2707e interfaceC2707e2 = abstractC2774a.completion;
            AbstractC2304t.c(interfaceC2707e2);
            try {
                objInvokeSuspend = abstractC2774a.invokeSuspend(obj);
            } catch (Throwable th) {
                C2490r.a aVar = C2490r.f21981b;
                obj = C2490r.b(AbstractC2491s.a(th));
            }
            if (objInvokeSuspend == AbstractC2751c.f()) {
                return;
            }
            obj = C2490r.b(objInvokeSuspend);
            abstractC2774a.releaseIntercepted();
            if (!(interfaceC2707e2 instanceof AbstractC2774a)) {
                interfaceC2707e2.resumeWith(obj);
                return;
            }
            interfaceC2707e = interfaceC2707e2;
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

    public InterfaceC2707e create(InterfaceC2707e completion) {
        AbstractC2304t.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
