package id;

import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k extends j implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12289a;

    public k(int i10, gd.e eVar) {
        super(eVar);
        this.f12289a = i10;
    }

    @Override // kotlin.jvm.internal.o
    public int getArity() {
        return this.f12289a;
    }

    @Override // id.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strI = n0.i(this);
        t.e(strI, "renderLambdaToString(...)");
        return strI;
    }
}
