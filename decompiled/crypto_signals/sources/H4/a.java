package H4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class a implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f563a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f565c;

    public a(Object[] array) {
        kotlin.jvm.internal.j.e(array, "array");
        this.f565c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f563a) {
            case 0:
                if (this.f564b < ((d) this.f565c).a()) {
                }
                break;
            default:
                if (this.f564b < ((Object[]) this.f565c).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f563a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.f564b;
                this.f564b = i + 1;
                return ((d) this.f565c).get(i);
            default:
                try {
                    Object[] objArr = (Object[]) this.f565c;
                    int i6 = this.f564b;
                    this.f564b = i6 + 1;
                    return objArr[i6];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f564b--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f563a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public a(d dVar) {
        this.f565c = dVar;
    }
}
