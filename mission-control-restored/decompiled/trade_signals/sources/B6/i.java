package B6;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H6.i f214b;

    public i(H6.n storageManager, Function0 getScope) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(getScope, "getScope");
        this.f214b = storageManager.e(new h(getScope));
    }

    public static final k k(Function0 function0) {
        k kVar = (k) function0.invoke();
        return kVar instanceof a ? ((a) kVar).h() : kVar;
    }

    @Override // B6.a
    public k i() {
        return (k) this.f214b.invoke();
    }

    public /* synthetic */ i(H6.n nVar, Function0 function0, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? H6.f.f3979e : nVar, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public i(Function0 getScope) {
        this(null, getScope, 1, 0 == true ? 1 : 0);
        AbstractC2304t.f(getScope, "getScope");
    }
}
