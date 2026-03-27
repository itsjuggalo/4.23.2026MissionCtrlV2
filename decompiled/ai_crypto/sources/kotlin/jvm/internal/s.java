package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s implements m, Serializable {
    private final int arity;

    public s(int i7) {
        this.arity = i7;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strH = H.h(this);
        r.e(strH, "renderLambdaToString(...)");
        return strH;
    }
}
