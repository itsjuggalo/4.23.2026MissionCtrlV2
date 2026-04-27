package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: renamed from: kotlin.jvm.internal.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2306v implements InterfaceC2300o, Serializable {
    private final int arity;

    public AbstractC2306v(int i8) {
        this.arity = i8;
    }

    @Override // kotlin.jvm.internal.InterfaceC2300o
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strJ = O.j(this);
        AbstractC2304t.e(strJ, "renderLambdaToString(...)");
        return strJ;
    }
}
