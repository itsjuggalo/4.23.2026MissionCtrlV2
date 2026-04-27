package J5;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends d implements m {
    private final int arity;

    public l(int i7, H5.d dVar) {
        super(dVar);
        this.arity = i7;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.arity;
    }

    @Override // J5.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strG = H.g(this);
        r.e(strG, "renderLambdaToString(...)");
        return strG;
    }
}
