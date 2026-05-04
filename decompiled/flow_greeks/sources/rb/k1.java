package rb;

import io.flutter.plugins.firebase.database.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import p6.h;
import rb.y0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f19591d = g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k1 f19592e = b.OK.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final k1 f19593f = b.CANCELLED.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k1 f19594g = b.UNKNOWN.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final k1 f19595h = b.INVALID_ARGUMENT.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k1 f19596i = b.DEADLINE_EXCEEDED.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final k1 f19597j = b.NOT_FOUND.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final k1 f19598k = b.ALREADY_EXISTS.b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final k1 f19599l = b.PERMISSION_DENIED.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final k1 f19600m = b.UNAUTHENTICATED.b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final k1 f19601n = b.RESOURCE_EXHAUSTED.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final k1 f19602o = b.FAILED_PRECONDITION.b();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final k1 f19603p = b.ABORTED.b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final k1 f19604q = b.OUT_OF_RANGE.b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final k1 f19605r = b.UNIMPLEMENTED.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final k1 f19606s = b.INTERNAL.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final k1 f19607t = b.UNAVAILABLE.b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final k1 f19608u = b.DATA_LOSS.b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final y0.g f19609v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final y0.j f19610w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final y0.g f19611x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f19612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f19614c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        public final int f19633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f19634b;

        b(int i10) {
            this.f19633a = i10;
            this.f19634b = Integer.toString(i10).getBytes(p6.d.f18311a);
        }

        public k1 b() {
            return (k1) k1.f19591d.get(this.f19633a);
        }

        public int c() {
            return this.f19633a;
        }

        public final byte[] h() {
            return this.f19634b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements y0.j {
        public c() {
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public k1 b(byte[] bArr) {
            return k1.j(bArr);
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(k1 k1Var) {
            return k1Var.n().h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements y0.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f19635a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b10) {
            return b10 < 32 || b10 >= 126 || b10 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i10 = 0;
            while (i10 < bArr.length) {
                if (bArr[i10] == 37 && i10 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i10 + 1, 2, p6.d.f18311a), 16));
                        i10 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i10]);
                        i10++;
                    }
                }
                byteBufferAllocate.put(bArr[i10]);
                i10++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), p6.d.f18313c);
        }

        public static byte[] g(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[((bArr.length - i10) * 3) + i10];
            if (i10 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i10);
            }
            int i11 = i10;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (c(b10)) {
                    bArr2[i11] = 37;
                    byte[] bArr3 = f19635a;
                    bArr2[i11 + 1] = bArr3[(b10 >> 4) & 15];
                    bArr2[i11 + 2] = bArr3[b10 & 15];
                    i11 += 3;
                } else {
                    bArr2[i11] = b10;
                    i11++;
                }
                i10++;
            }
            return Arrays.copyOf(bArr2, i11);
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                if (b10 < 32 || b10 >= 126 || (b10 == 37 && i10 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // rb.y0.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(p6.d.f18313c);
            for (int i10 = 0; i10 < bytes.length; i10++) {
                if (c(bytes[i10])) {
                    return g(bytes, i10);
                }
            }
            return bytes;
        }
    }

    static {
        f19609v = y0.g.g("grpc-status", false, new c());
        d dVar = new d();
        f19610w = dVar;
        f19611x = y0.g.g("grpc-message", false, dVar);
    }

    public k1(b bVar) {
        this(bVar, null, null);
    }

    public static List g() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            k1 k1Var = (k1) treeMap.put(Integer.valueOf(bVar.c()), new k1(bVar));
            if (k1Var != null) {
                throw new IllegalStateException("Code value duplication between " + k1Var.n().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String h(k1 k1Var) {
        if (k1Var.f19613b == null) {
            return k1Var.f19612a.toString();
        }
        return k1Var.f19612a + ": " + k1Var.f19613b;
    }

    public static k1 i(int i10) {
        if (i10 >= 0) {
            List list = f19591d;
            if (i10 < list.size()) {
                return (k1) list.get(i10);
            }
        }
        return f19594g.r("Unknown code " + i10);
    }

    public static k1 j(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f19592e : k(bArr);
    }

    public static k1 k(byte[] bArr) {
        int i10;
        byte b10;
        int length = bArr.length;
        char c10 = 0;
        if (length != 1) {
            if (length == 2 && (b10 = bArr[0]) >= 48 && b10 <= 57) {
                i10 = (b10 - 48) * 10;
                c10 = 1;
            }
            return f19594g.r("Unknown code " + new String(bArr, p6.d.f18311a));
        }
        i10 = 0;
        byte b11 = bArr[c10];
        if (b11 >= 48 && b11 <= 57) {
            int i11 = i10 + (b11 - 48);
            List list = f19591d;
            if (i11 < list.size()) {
                return (k1) list.get(i11);
            }
        }
        return f19594g.r("Unknown code " + new String(bArr, p6.d.f18311a));
    }

    public static k1 l(Throwable th) {
        for (Throwable cause = (Throwable) p6.n.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof l1) {
                return ((l1) cause).a();
            }
            if (cause instanceof m1) {
                return ((m1) cause).a();
            }
        }
        return f19594g.q(th);
    }

    public l1 c() {
        return new l1(this);
    }

    public m1 d() {
        return new m1(this);
    }

    public m1 e(y0 y0Var) {
        return new m1(this, y0Var);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public k1 f(String str) {
        if (str == null) {
            return this;
        }
        if (this.f19613b == null) {
            return new k1(this.f19612a, str, this.f19614c);
        }
        return new k1(this.f19612a, this.f19613b + "\n" + str, this.f19614c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable m() {
        return this.f19614c;
    }

    public b n() {
        return this.f19612a;
    }

    public String o() {
        return this.f19613b;
    }

    public boolean p() {
        return b.OK == this.f19612a;
    }

    public k1 q(Throwable th) {
        return p6.j.a(this.f19614c, th) ? this : new k1(this.f19612a, this.f19613b, th);
    }

    public k1 r(String str) {
        return p6.j.a(this.f19613b, str) ? this : new k1(this.f19612a, str, this.f19614c);
    }

    public String toString() {
        h.b bVarD = p6.h.b(this).d(Constants.ERROR_CODE, this.f19612a.name()).d(com.amazon.a.a.o.b.f4549c, this.f19613b);
        Throwable th = this.f19614c;
        Object objE = th;
        if (th != null) {
            objE = p6.v.e(th);
        }
        return bVarD.d("cause", objE).toString();
    }

    public k1(b bVar, String str, Throwable th) {
        this.f19612a = (b) p6.n.o(bVar, Constants.ERROR_CODE);
        this.f19613b = str;
        this.f19614c = th;
    }
}
