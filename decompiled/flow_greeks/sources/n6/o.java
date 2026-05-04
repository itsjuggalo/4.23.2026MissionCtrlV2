package n6;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class o extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16666b;

    public o(int i10, int i11) {
        m.b(i11, i10, FirebaseAnalytics.Param.INDEX);
        this.f16665a = i10;
        this.f16666b = i11;
    }

    public abstract Object b(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f16666b < this.f16665a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f16666b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f16666b;
        this.f16666b = i10 + 1;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f16666b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f16666b - 1;
        this.f16666b = i10;
        return b(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f16666b - 1;
    }
}
