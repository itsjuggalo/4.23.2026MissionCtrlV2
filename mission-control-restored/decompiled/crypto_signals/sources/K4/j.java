package K4;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends c implements kotlin.jvm.internal.g {
    private final int arity;

    public j(int i, I4.d dVar) {
        super(dVar);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // K4.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        t.f7935a.getClass();
        String strA = u.a(this);
        kotlin.jvm.internal.j.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
