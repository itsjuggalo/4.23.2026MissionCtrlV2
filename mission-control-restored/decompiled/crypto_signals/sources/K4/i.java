package K4;

import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class i extends h implements kotlin.jvm.internal.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1017a;

    public i(int i, I4.d dVar) {
        super(dVar);
        this.f1017a = i;
    }

    @Override // kotlin.jvm.internal.g
    public final int getArity() {
        return this.f1017a;
    }

    @Override // K4.a
    public final String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        t.f7935a.getClass();
        String strA = u.a(this);
        kotlin.jvm.internal.j.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
