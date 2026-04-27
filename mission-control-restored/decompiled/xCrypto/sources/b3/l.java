package b3;

import kotlin.jvm.internal.G;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends AbstractC0866d implements m {
    private final int arity;

    public l(int i4, Z2.e eVar) {
        super(eVar);
        this.arity = i4;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    @Override // b3.AbstractC0863a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strG = G.g(this);
        r.e(strG, "renderLambdaToString(...)");
        return strG;
    }
}
