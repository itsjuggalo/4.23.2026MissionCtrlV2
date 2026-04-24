package l4;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: l4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2174g extends AbstractC2177j implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f18378a = new ArrayList();

    @Override // l4.AbstractC2177j
    public boolean a() {
        return p().a();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C2174g) && ((C2174g) obj).f18378a.equals(this.f18378a));
    }

    @Override // l4.AbstractC2177j
    public String h() {
        return p().h();
    }

    public int hashCode() {
        return this.f18378a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f18378a.iterator();
    }

    public void n(AbstractC2177j abstractC2177j) {
        if (abstractC2177j == null) {
            abstractC2177j = l.f18379a;
        }
        this.f18378a.add(abstractC2177j);
    }

    public final AbstractC2177j p() {
        int size = this.f18378a.size();
        if (size == 1) {
            return (AbstractC2177j) this.f18378a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }
}
