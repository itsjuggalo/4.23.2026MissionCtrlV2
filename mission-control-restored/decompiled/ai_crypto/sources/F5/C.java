package F5;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public final class C implements Iterable, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f2344a;

    public C(Function0 iteratorFactory) {
        kotlin.jvm.internal.r.f(iteratorFactory, "iteratorFactory");
        this.f2344a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new D((Iterator) this.f2344a.invoke());
    }
}
