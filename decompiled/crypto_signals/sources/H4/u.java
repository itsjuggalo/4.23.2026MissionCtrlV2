package H4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class u implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f583d;
    public final /* synthetic */ v e;

    public u(v vVar) {
        this.e = vVar;
        this.f582c = vVar.f587d;
        this.f583d = vVar.f586c;
    }

    public final boolean a() {
        this.f580a = 3;
        int i = this.f582c;
        if (i == 0) {
            this.f580a = 2;
        } else {
            v vVar = this.e;
            Object[] objArr = vVar.f584a;
            int i6 = this.f583d;
            this.f581b = objArr[i6];
            this.f580a = 1;
            this.f583d = (i6 + 1) % vVar.f585b;
            this.f582c = i - 1;
        }
        return this.f580a == 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f580a;
        if (i == 0) {
            return a();
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f580a;
        if (i == 1) {
            this.f580a = 0;
            return this.f581b;
        }
        if (i == 2 || !a()) {
            throw new NoSuchElementException();
        }
        this.f580a = 0;
        return this.f581b;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
