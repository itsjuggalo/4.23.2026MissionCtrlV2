package p5;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2578G implements Iterable, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f22367a;

    public C2578G(Function0 iteratorFactory) {
        AbstractC2304t.f(iteratorFactory, "iteratorFactory");
        this.f22367a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new H((Iterator) this.f22367a.invoke());
    }
}
