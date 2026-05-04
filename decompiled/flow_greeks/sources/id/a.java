package id;

import cd.r;
import cd.s;
import java.io.Serializable;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements gd.e, e, Serializable {
    private final gd.e completion;

    public a(gd.e eVar) {
        this.completion = eVar;
    }

    public gd.e create(gd.e completion) {
        t.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // id.e
    public e getCallerFrame() {
        gd.e eVar = this.completion;
        if (eVar instanceof e) {
            return (e) eVar;
        }
        return null;
    }

    public final gd.e getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // gd.e
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        gd.e eVar = this;
        while (true) {
            h.b(eVar);
            a aVar = (a) eVar;
            gd.e eVar2 = aVar.completion;
            t.c(eVar2);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                r.a aVar2 = r.f3870b;
                obj = r.b(s.a(th));
            }
            if (objInvokeSuspend == hd.c.f()) {
                return;
            }
            obj = r.b(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(eVar2 instanceof a)) {
                eVar2.resumeWith(obj);
                return;
            }
            eVar = eVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public gd.e create(Object obj, gd.e completion) {
        t.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
