package I6;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class Y extends O0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H6.n f4402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f4403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.i f4404d;

    public Y(H6.n storageManager, Function0 computation) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(computation, "computation");
        this.f4402b = storageManager;
        this.f4403c = computation;
        this.f4404d = storageManager.e(computation);
    }

    public static final S W0(J6.g gVar, Y y7) {
        return gVar.a((M6.i) y7.f4403c.invoke());
    }

    @Override // I6.O0
    public S S0() {
        return (S) this.f4404d.invoke();
    }

    @Override // I6.O0
    public boolean T0() {
        return this.f4404d.e();
    }

    @Override // I6.S
    /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
    public Y Y0(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new Y(this.f4402b, new X(kotlinTypeRefiner, this));
    }
}
