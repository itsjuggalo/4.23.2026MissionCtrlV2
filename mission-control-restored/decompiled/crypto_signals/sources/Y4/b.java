package Y4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterator, S4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3693d;
    public int e;

    public b(String string) {
        kotlin.jvm.internal.j.e(string, "string");
        this.f3690a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i6;
        int i7 = this.f3691b;
        if (i7 != 0) {
            return i7 == 1;
        }
        if (this.e < 0) {
            this.f3691b = 2;
            return false;
        }
        String str = this.f3690a;
        int length = str.length();
        int length2 = str.length();
        for (int i8 = this.f3692c; i8 < length2; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i6 = i8 + 1) < str.length() && str.charAt(i6) == '\n') ? 2 : 1;
                length = i8;
                this.f3691b = 1;
                this.e = i;
                this.f3693d = length;
                return true;
            }
        }
        i = -1;
        this.f3691b = 1;
        this.e = i;
        this.f3693d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f3691b = 0;
        int i = this.f3693d;
        int i6 = this.f3692c;
        this.f3692c = this.e + i;
        return this.f3690a.subSequence(i6, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
