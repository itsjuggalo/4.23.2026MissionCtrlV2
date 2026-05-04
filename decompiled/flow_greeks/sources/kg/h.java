package kg;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements Iterator, qd.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f14904f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f14905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14909e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    public h(CharSequence string) {
        kotlin.jvm.internal.t.f(string, "string");
        this.f14905a = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f14906b = 0;
        int i10 = this.f14908d;
        int i11 = this.f14907c;
        this.f14907c = this.f14909e + i10;
        return this.f14905a.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f14906b;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.f14909e < 0) {
            this.f14906b = 2;
            return false;
        }
        int length = this.f14905a.length();
        int length2 = this.f14905a.length();
        for (int i13 = this.f14907c; i13 < length2; i13++) {
            char cCharAt = this.f14905a.charAt(i13);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i10 = (cCharAt == '\r' && (i11 = i13 + 1) < this.f14905a.length() && this.f14905a.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f14906b = 1;
                this.f14909e = i10;
                this.f14908d = length;
                return true;
            }
        }
        i10 = -1;
        this.f14906b = 1;
        this.f14909e = i10;
        this.f14908d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
