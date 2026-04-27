package G6;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class T extends C0564a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(H6.n storageManager, Function0 compute) {
        super(storageManager, compute);
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(compute, "compute");
    }

    @Override // G6.C0564a, S5.h
    public boolean isEmpty() {
        return false;
    }
}
