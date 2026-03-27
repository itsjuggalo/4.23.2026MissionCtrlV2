package q;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: q.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0917i implements Iterator, Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9128a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0909a f9131d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9130c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9129b = -1;

    public C0917i(C0909a c0909a) {
        this.f9131d = c0909a;
        this.f9128a = c0909a.d() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.f9130c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.f9129b;
        C0909a c0909a = this.f9131d;
        Object objB = c0909a.b(i, 0);
        if (key != objB && (key == null || !key.equals(objB))) {
            return false;
        }
        Object value = entry.getValue();
        Object objB2 = c0909a.b(this.f9129b, 1);
        return value == objB2 || (value != null && value.equals(objB2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.f9130c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f9131d.b(this.f9129b, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.f9130c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.f9131d.b(this.f9129b, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9129b < this.f9128a;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.f9130c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.f9129b;
        C0909a c0909a = this.f9131d;
        Object objB = c0909a.b(i, 0);
        Object objB2 = c0909a.b(this.f9129b, 1);
        return (objB == null ? 0 : objB.hashCode()) ^ (objB2 != null ? objB2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9129b++;
        this.f9130c = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f9130c) {
            throw new IllegalStateException();
        }
        this.f9131d.g(this.f9129b);
        this.f9129b--;
        this.f9128a--;
        this.f9130c = false;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!this.f9130c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        C0909a c0909a = this.f9131d;
        int i = this.f9129b;
        switch (c0909a.f9105d) {
            case 0:
                int i6 = (i << 1) + 1;
                Object[] objArr = ((C0910b) c0909a.e).f9137b;
                Object obj2 = objArr[i6];
                objArr[i6] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
