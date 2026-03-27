package V6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: V6.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0982h implements Iterator, C5.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f9002f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f9003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9007e;

    /* JADX INFO: renamed from: V6.h$a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public C0982h(CharSequence string) {
        AbstractC2304t.f(string, "string");
        this.f9003a = string;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9004b = 0;
        int i8 = this.f9006d;
        int i9 = this.f9005c;
        this.f9005c = this.f9007e + i8;
        return this.f9003a.subSequence(i9, i8).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i8;
        int i9;
        int i10 = this.f9004b;
        if (i10 != 0) {
            return i10 == 1;
        }
        if (this.f9007e < 0) {
            this.f9004b = 2;
            return false;
        }
        int length = this.f9003a.length();
        int length2 = this.f9003a.length();
        for (int i11 = this.f9005c; i11 < length2; i11++) {
            char cCharAt = this.f9003a.charAt(i11);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i8 = (cCharAt == '\r' && (i9 = i11 + 1) < this.f9003a.length() && this.f9003a.charAt(i9) == '\n') ? 2 : 1;
                length = i11;
                this.f9004b = 1;
                this.f9007e = i8;
                this.f9006d = length;
                return true;
            }
        }
        i8 = -1;
        this.f9004b = 1;
        this.f9007e = i8;
        this.f9006d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
