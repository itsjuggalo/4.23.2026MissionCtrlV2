package S1;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class G implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f3956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H f3957b;

    public G(H h4) {
        Objects.requireNonNull(h4);
        this.f3957b = h4;
        this.f3956a = h4.p().keySet().iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.f3956a.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3956a.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
