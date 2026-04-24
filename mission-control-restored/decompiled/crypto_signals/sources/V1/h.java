package V1;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class h extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3207b;

    public h(Object obj) {
        this.f3207b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f3206a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3206a) {
            throw new NoSuchElementException();
        }
        this.f3206a = true;
        return this.f3207b;
    }
}
