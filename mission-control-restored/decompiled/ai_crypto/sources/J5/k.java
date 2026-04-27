package J5;

import kotlin.jvm.internal.H;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3337a;

    public k(int i7, H5.d dVar) {
        super(dVar);
        this.f3337a = i7;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.f3337a;
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
