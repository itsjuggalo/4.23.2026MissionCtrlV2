package b3;

import kotlin.jvm.internal.G;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8291a;

    public k(int i4, Z2.e eVar) {
        super(eVar);
        this.f8291a = i4;
    }

    @Override // kotlin.jvm.internal.m
    public int getArity() {
        return this.f8291a;
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
