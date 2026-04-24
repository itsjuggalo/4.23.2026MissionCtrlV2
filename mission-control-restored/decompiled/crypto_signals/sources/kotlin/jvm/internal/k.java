package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class k implements g, Serializable {
    private final int arity;

    public k(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        t.f7935a.getClass();
        String strA = u.a(this);
        j.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
