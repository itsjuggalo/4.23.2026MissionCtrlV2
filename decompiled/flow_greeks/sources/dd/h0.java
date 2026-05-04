package dd;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements Iterable, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f8007a;

    public h0(Function0 iteratorFactory) {
        kotlin.jvm.internal.t.f(iteratorFactory, "iteratorFactory");
        this.f8007a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new i0((Iterator) this.f8007a.invoke());
    }
}
