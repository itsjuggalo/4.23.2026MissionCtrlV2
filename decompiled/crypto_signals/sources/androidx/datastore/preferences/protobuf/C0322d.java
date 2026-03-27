package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0322d implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4544a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0325g f4546c;

    public C0322d(C0325g c0325g) {
        this.f4546c = c0325g;
        this.f4545b = c0325g.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4544a < this.f4545b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f4544a;
        if (i >= this.f4545b) {
            throw new NoSuchElementException();
        }
        this.f4544a = i + 1;
        return Byte.valueOf(this.f4546c.k(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
