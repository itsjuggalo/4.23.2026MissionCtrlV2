package J5;

import E5.p;
import E5.q;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements H5.d, e, Serializable {
    private final H5.d completion;

    public a(H5.d dVar) {
        this.completion = dVar;
    }

    public H5.d create(H5.d completion) {
        r.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // J5.e
    public e getCallerFrame() {
        H5.d dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final H5.d getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // H5.d
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        H5.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            H5.d dVar2 = aVar.completion;
            r.c(dVar2);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                p.a aVar2 = p.f1681b;
                obj = p.b(q.a(th));
            }
            if (objInvokeSuspend == I5.c.e()) {
                return;
            }
            obj = p.b(objInvokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
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

    public H5.d create(Object obj, H5.d completion) {
        r.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
