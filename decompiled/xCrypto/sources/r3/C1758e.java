package r3;

import j3.InterfaceC1564a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: r3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1758e implements Iterator, InterfaceC1564a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f14579f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14584e;

    /* JADX INFO: renamed from: r3.e$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    public C1758e(CharSequence string) {
        kotlin.jvm.internal.r.f(string, "string");
        this.f14580a = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f14581b = 0;
        int i4 = this.f14583d;
        int i5 = this.f14582c;
        this.f14582c = this.f14584e + i4;
        return this.f14580a.subSequence(i5, i4).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i4;
        int i5;
        int i6 = this.f14581b;
        if (i6 != 0) {
            return i6 == 1;
        }
        if (this.f14584e < 0) {
            this.f14581b = 2;
            return false;
        }
        int length = this.f14580a.length();
        int length2 = this.f14580a.length();
        for (int i7 = this.f14582c; i7 < length2; i7++) {
            char cCharAt = this.f14580a.charAt(i7);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i4 = (cCharAt == '\r' && (i5 = i7 + 1) < this.f14580a.length() && this.f14580a.charAt(i5) == '\n') ? 2 : 1;
                length = i7;
                this.f14581b = 1;
                this.f14584e = i4;
                this.f14583d = length;
                return true;
            }
        }
        i4 = -1;
        this.f14581b = 1;
        this.f14584e = i4;
        this.f14583d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
