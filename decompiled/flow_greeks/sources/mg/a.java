package mg;

import cd.b0;
import java.io.Serializable;
import kg.z;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Comparable, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0292a f16432c = new C0292a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f16433d = new a(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16435b;

    /* JADX INFO: renamed from: mg.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0292a {
        public /* synthetic */ C0292a(k kVar) {
            this();
        }

        public final a a(long j10, long j11) {
            return (j10 == 0 && j11 == 0) ? b() : new a(j10, j11, null);
        }

        public final a b() {
            return a.f16433d;
        }

        public final a c(String uuidString) {
            t.f(uuidString, "uuidString");
            int length = uuidString.length();
            if (length == 32) {
                return b.b(uuidString);
            }
            if (length == 36) {
                return b.c(uuidString);
            }
            throw new IllegalArgumentException("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"" + c.g(uuidString, 64) + "\" of length " + uuidString.length());
        }

        public C0292a() {
        }
    }

    public /* synthetic */ a(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(a other) {
        t.f(other, "other");
        long j10 = this.f16434a;
        return j10 != other.f16434a ? Long.compare(b0.b(j10) ^ Long.MIN_VALUE, b0.b(other.f16434a) ^ Long.MIN_VALUE) : Long.compare(b0.b(this.f16435b) ^ Long.MIN_VALUE, b0.b(other.f16435b) ^ Long.MIN_VALUE);
    }

    public final String c() {
        byte[] bArr = new byte[36];
        b.a(this.f16434a, bArr, 0, 0, 4);
        bArr[8] = 45;
        b.a(this.f16434a, bArr, 9, 4, 6);
        bArr[13] = 45;
        b.a(this.f16434a, bArr, 14, 6, 8);
        bArr[18] = 45;
        b.a(this.f16435b, bArr, 19, 0, 2);
        bArr[23] = 45;
        b.a(this.f16435b, bArr, 24, 2, 8);
        return z.u(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f16434a == aVar.f16434a && this.f16435b == aVar.f16435b;
    }

    public int hashCode() {
        return Long.hashCode(this.f16434a ^ this.f16435b);
    }

    public String toString() {
        return c();
    }

    public a(long j10, long j11) {
        this.f16434a = j10;
        this.f16435b = j11;
    }
}
