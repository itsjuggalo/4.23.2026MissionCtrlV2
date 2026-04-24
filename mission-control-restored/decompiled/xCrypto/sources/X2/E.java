package X2;

import j3.InterfaceC1564a;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class E implements Iterable, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f5582a;

    public E(Function0 iteratorFactory) {
        kotlin.jvm.internal.r.f(iteratorFactory, "iteratorFactory");
        this.f5582a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new F((Iterator) this.f5582a.invoke());
    }
}
