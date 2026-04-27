package i2;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: i2.G, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1747G implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f15115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1748H f15116b;

    public C1747G(C1748H c1748h) {
        Objects.requireNonNull(c1748h);
        this.f15116b = c1748h;
        this.f15115a = c1748h.G().keySet().iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.f15115a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f15115a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
