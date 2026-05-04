package pf;

import kotlin.jvm.internal.t;
import wf.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable f18619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wf.b f18620b;

    public b(n storageManager, Iterable samWithReceiverResolvers) {
        t.f(storageManager, "storageManager");
        t.f(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f18619a = samWithReceiverResolvers;
        this.f18620b = storageManager.b();
    }
}
