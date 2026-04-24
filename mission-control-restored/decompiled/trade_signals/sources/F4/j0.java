package F4;

import F4.X;
import io.flutter.plugins.firebase.database.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import v2.AbstractC2838d;
import v2.AbstractC2842h;
import v2.AbstractC2844j;
import v2.AbstractC2848n;
import v2.AbstractC2856v;

/* JADX INFO: loaded from: classes.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f1796d = g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j0 f1797e = b.OK.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j0 f1798f = b.CANCELLED.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final j0 f1799g = b.UNKNOWN.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final j0 f1800h = b.INVALID_ARGUMENT.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final j0 f1801i = b.DEADLINE_EXCEEDED.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j0 f1802j = b.NOT_FOUND.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final j0 f1803k = b.ALREADY_EXISTS.b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j0 f1804l = b.PERMISSION_DENIED.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j0 f1805m = b.UNAUTHENTICATED.b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final j0 f1806n = b.RESOURCE_EXHAUSTED.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j0 f1807o = b.FAILED_PRECONDITION.b();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final j0 f1808p = b.ABORTED.b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final j0 f1809q = b.OUT_OF_RANGE.b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final j0 f1810r = b.UNIMPLEMENTED.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final j0 f1811s = b.INTERNAL.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final j0 f1812t = b.UNAVAILABLE.b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final j0 f1813u = b.DATA_LOSS.b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final X.g f1814v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final X.j f1815w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final X.g f1816x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f1819c;

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1839b;

        b(int i8) {
            this.f1838a = i8;
            this.f1839b = Integer.toString(i8).getBytes(AbstractC2838d.f23751a);
        }

        public j0 b() {
            return (j0) j0.f1796d.get(this.f1838a);
        }

        public int g() {
            return this.f1838a;
        }

        public final byte[] i() {
            return this.f1839b;
        }
    }

    public static final class c implements X.j {
        public c() {
        }

        @Override // F4.X.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public j0 b(byte[] bArr) {
            return j0.j(bArr);
        }

        @Override // F4.X.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(j0 j0Var) {
            return j0Var.n().i();
        }
    }

    public static final class d implements X.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f1840a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b8) {
            return b8 < 32 || b8 >= 126 || b8 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i8 = 0;
            while (i8 < bArr.length) {
                if (bArr[i8] == 37 && i8 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i8 + 1, 2, AbstractC2838d.f23751a), 16));
                        i8 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i8]);
                        i8++;
                    }
                }
                byteBufferAllocate.put(bArr[i8]);
                i8++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), AbstractC2838d.f23753c);
        }

        public static byte[] g(byte[] bArr, int i8) {
            byte[] bArr2 = new byte[((bArr.length - i8) * 3) + i8];
            if (i8 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i8);
            }
            int i9 = i8;
            while (i8 < bArr.length) {
                byte b8 = bArr[i8];
                if (c(b8)) {
                    bArr2[i9] = 37;
                    byte[] bArr3 = f1840a;
                    bArr2[i9 + 1] = bArr3[(b8 >> 4) & 15];
                    bArr2[i9 + 2] = bArr3[b8 & 15];
                    i9 += 3;
                } else {
                    bArr2[i9] = b8;
                    i9++;
                }
                i8++;
            }
            return Arrays.copyOf(bArr2, i9);
        }

        @Override // F4.X.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i8 = 0; i8 < bArr.length; i8++) {
                byte b8 = bArr[i8];
                if (b8 < 32 || b8 >= 126 || (b8 == 37 && i8 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // F4.X.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(AbstractC2838d.f23753c);
            for (int i8 = 0; i8 < bytes.length; i8++) {
                if (c(bytes[i8])) {
                    return g(bytes, i8);
                }
            }
            return bytes;
        }
    }

    static {
        f1814v = X.g.g("grpc-status", false, new c());
        d dVar = new d();
        f1815w = dVar;
        f1816x = X.g.g("grpc-message", false, dVar);
    }

    public j0(b bVar) {
        this(bVar, null, null);
    }

    public static List g() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            j0 j0Var = (j0) treeMap.put(Integer.valueOf(bVar.g()), new j0(bVar));
            if (j0Var != null) {
                throw new IllegalStateException("Code value duplication between " + j0Var.n().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String h(j0 j0Var) {
        if (j0Var.f1818b == null) {
            return j0Var.f1817a.toString();
        }
        return j0Var.f1817a + ": " + j0Var.f1818b;
    }

    public static j0 i(int i8) {
        if (i8 >= 0) {
            List list = f1796d;
            if (i8 < list.size()) {
                return (j0) list.get(i8);
            }
        }
        return f1799g.r("Unknown code " + i8);
    }

    public static j0 j(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f1797e : k(bArr);
    }

    public static j0 k(byte[] bArr) {
        int i8;
        byte b8;
        int length = bArr.length;
        char c8 = 1;
        if (length != 1) {
            i8 = (length == 2 && (b8 = bArr[0]) >= 48 && b8 <= 57) ? (b8 - 48) * 10 : 0;
            return f1799g.r("Unknown code " + new String(bArr, AbstractC2838d.f23751a));
        }
        c8 = 0;
        byte b9 = bArr[c8];
        if (b9 >= 48 && b9 <= 57) {
            int i9 = i8 + (b9 - 48);
            List list = f1796d;
            if (i9 < list.size()) {
                return (j0) list.get(i9);
            }
        }
        return f1799g.r("Unknown code " + new String(bArr, AbstractC2838d.f23751a));
    }

    public static j0 l(Throwable th) {
        for (Throwable cause = (Throwable) AbstractC2848n.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof k0) {
                return ((k0) cause).a();
            }
            if (cause instanceof l0) {
                return ((l0) cause).a();
            }
        }
        return f1799g.q(th);
    }

    public k0 c() {
        return new k0(this);
    }

    public l0 d() {
        return new l0(this);
    }

    public l0 e(X x8) {
        return new l0(this, x8);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public j0 f(String str) {
        if (str == null) {
            return this;
        }
        if (this.f1818b == null) {
            return new j0(this.f1817a, str, this.f1819c);
        }
        return new j0(this.f1817a, this.f1818b + "\n" + str, this.f1819c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable m() {
        return this.f1819c;
    }

    public b n() {
        return this.f1817a;
    }

    public String o() {
        return this.f1818b;
    }

    public boolean p() {
        return b.OK == this.f1817a;
    }

    public j0 q(Throwable th) {
        return AbstractC2844j.a(this.f1819c, th) ? this : new j0(this.f1817a, this.f1818b, th);
    }

    public j0 r(String str) {
        return AbstractC2844j.a(this.f1818b, str) ? this : new j0(this.f1817a, str, this.f1819c);
    }

    public String toString() {
        AbstractC2842h.b bVarD = AbstractC2842h.b(this).d(Constants.ERROR_CODE, this.f1817a.name()).d(com.amazon.a.a.o.b.f14051c, this.f1818b);
        Throwable th = this.f1819c;
        Object objE = th;
        if (th != null) {
            objE = AbstractC2856v.e(th);
        }
        return bVarD.d("cause", objE).toString();
    }

    public j0(b bVar, String str, Throwable th) {
        this.f1817a = (b) AbstractC2848n.o(bVar, Constants.ERROR_CODE);
        this.f1818b = str;
        this.f1819c = th;
    }
}
