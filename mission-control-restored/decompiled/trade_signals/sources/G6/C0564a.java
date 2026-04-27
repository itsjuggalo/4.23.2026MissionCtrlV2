package G6;

import S5.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: G6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0564a implements S5.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f3299b = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(C0564a.class, "annotations", "getAnnotations()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H6.i f3300a;

    public C0564a(H6.n storageManager, Function0 compute) {
        AbstractC2304t.f(storageManager, "storageManager");
        AbstractC2304t.f(compute, "compute");
        this.f3300a = storageManager.e(compute);
    }

    public final List a() {
        return (List) H6.m.a(this.f3300a, this, f3299b[0]);
    }

    @Override // S5.h
    public S5.c b(q6.c cVar) {
        return h.b.a(this, cVar);
    }

    @Override // S5.h
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return a().iterator();
    }

    @Override // S5.h
    public boolean r(q6.c cVar) {
        return h.b.b(this, cVar);
    }
}
