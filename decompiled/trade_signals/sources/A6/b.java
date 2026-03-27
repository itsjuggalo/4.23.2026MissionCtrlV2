package A6;

import H6.n;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f99a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H6.b f100b;

    public b(n storageManager, Iterable samWithReceiverResolvers) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f99a = samWithReceiverResolvers;
        this.f100b = storageManager.a();
    }
}
