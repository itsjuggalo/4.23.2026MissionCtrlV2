package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements m, Serializable {
    private final int arity;

    public s(int i4) {
        this.arity = i4;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strH = G.h(this);
        r.e(strH, "renderLambdaToString(...)");
        return strH;
    }
}
