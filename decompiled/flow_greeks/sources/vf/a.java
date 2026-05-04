package vf;

import ge.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ge.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f23410b = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wf.i f23411a;

    public a(wf.n storageManager, Function0 compute) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(compute, "compute");
        this.f23411a = storageManager.e(compute);
    }

    private final List a() {
        return (List) wf.m.a(this.f23411a, this, f23410b[0]);
    }

    @Override // ge.h
    public boolean E(ef.c cVar) {
        return h.b.b(this, cVar);
    }

    @Override // ge.h
    public ge.c b(ef.c cVar) {
        return h.b.a(this, cVar);
    }

    @Override // ge.h
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return a().iterator();
    }
}
