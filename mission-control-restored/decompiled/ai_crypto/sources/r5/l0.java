package r5;

import H2.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import r5.Z;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f22704d = f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l0 f22705e = b.OK.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l0 f22706f = b.CANCELLED.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l0 f22707g = b.UNKNOWN.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l0 f22708h = b.INVALID_ARGUMENT.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l0 f22709i = b.DEADLINE_EXCEEDED.b();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l0 f22710j = b.NOT_FOUND.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l0 f22711k = b.ALREADY_EXISTS.b();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l0 f22712l = b.PERMISSION_DENIED.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l0 f22713m = b.UNAUTHENTICATED.b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l0 f22714n = b.RESOURCE_EXHAUSTED.b();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l0 f22715o = b.FAILED_PRECONDITION.b();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final l0 f22716p = b.ABORTED.b();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l0 f22717q = b.OUT_OF_RANGE.b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l0 f22718r = b.UNIMPLEMENTED.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l0 f22719s = b.INTERNAL.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l0 f22720t = b.UNAVAILABLE.b();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l0 f22721u = b.DATA_LOSS.b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Z.g f22722v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Z.j f22723w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Z.g f22724x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f22725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f22727c;

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
        public final int f22746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f22747b;

        b(int i7) {
            this.f22746a = i7;
            this.f22747b = Integer.toString(i7).getBytes(H2.c.f2591a);
        }

        public l0 b() {
            return (l0) l0.f22704d.get(this.f22746a);
        }

        public int c() {
            return this.f22746a;
        }

        public final byte[] h() {
            return this.f22747b;
        }
    }

    public static final class c implements Z.j {
        public c() {
        }

        @Override // r5.Z.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l0 b(byte[] bArr) {
            return l0.i(bArr);
        }

        @Override // r5.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(l0 l0Var) {
            return l0Var.m().h();
        }
    }

    public static final class d implements Z.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f22748a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b7) {
            return b7 < 32 || b7 >= 126 || b7 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i7 = 0;
            while (i7 < bArr.length) {
                if (bArr[i7] == 37 && i7 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i7 + 1, 2, H2.c.f2591a), 16));
                        i7 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i7]);
                        i7++;
                    }
                }
                byteBufferAllocate.put(bArr[i7]);
                i7++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), H2.c.f2593c);
        }

        public static byte[] g(byte[] bArr, int i7) {
            byte[] bArr2 = new byte[((bArr.length - i7) * 3) + i7];
            if (i7 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i7);
            }
            int i8 = i7;
            while (i7 < bArr.length) {
                byte b7 = bArr[i7];
                if (c(b7)) {
                    bArr2[i8] = 37;
                    byte[] bArr3 = f22748a;
                    bArr2[i8 + 1] = bArr3[(b7 >> 4) & 15];
                    bArr2[i8 + 2] = bArr3[b7 & 15];
                    i8 += 3;
                } else {
                    bArr2[i8] = b7;
                    i8++;
                }
                i7++;
            }
            return Arrays.copyOf(bArr2, i8);
        }

        @Override // r5.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i7 = 0; i7 < bArr.length; i7++) {
                byte b7 = bArr[i7];
                if (b7 < 32 || b7 >= 126 || (b7 == 37 && i7 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // r5.Z.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(H2.c.f2593c);
            for (int i7 = 0; i7 < bytes.length; i7++) {
                if (c(bytes[i7])) {
                    return g(bytes, i7);
                }
            }
            return bytes;
        }
    }

    static {
        f22722v = Z.g.g("grpc-status", false, new c());
        d dVar = new d();
        f22723w = dVar;
        f22724x = Z.g.g("grpc-message", false, dVar);
    }

    public l0(b bVar) {
        this(bVar, null, null);
    }

    public static List f() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            l0 l0Var = (l0) treeMap.put(Integer.valueOf(bVar.c()), new l0(bVar));
            if (l0Var != null) {
                throw new IllegalStateException("Code value duplication between " + l0Var.m().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String g(l0 l0Var) {
        if (l0Var.f22726b == null) {
            return l0Var.f22725a.toString();
        }
        return l0Var.f22725a + ": " + l0Var.f22726b;
    }

    public static l0 h(int i7) {
        if (i7 >= 0) {
            List list = f22704d;
            if (i7 < list.size()) {
                return (l0) list.get(i7);
            }
        }
        return f22707g.q("Unknown code " + i7);
    }

    public static l0 i(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f22705e : j(bArr);
    }

    public static l0 j(byte[] bArr) {
        int i7;
        byte b7;
        int length = bArr.length;
        char c7 = 1;
        if (length != 1) {
            i7 = (length == 2 && (b7 = bArr[0]) >= 48 && b7 <= 57) ? (b7 - 48) * 10 : 0;
            return f22707g.q("Unknown code " + new String(bArr, H2.c.f2591a));
        }
        c7 = 0;
        byte b8 = bArr[c7];
        if (b8 >= 48 && b8 <= 57) {
            int i8 = i7 + (b8 - 48);
            List list = f22704d;
            if (i8 < list.size()) {
                return (l0) list.get(i8);
            }
        }
        return f22707g.q("Unknown code " + new String(bArr, H2.c.f2591a));
    }

    public static l0 k(Throwable th) {
        for (Throwable cause = (Throwable) H2.m.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof m0) {
                return ((m0) cause).a();
            }
            if (cause instanceof n0) {
                return ((n0) cause).a();
            }
        }
        return f22707g.p(th);
    }

    public m0 c() {
        return new m0(this);
    }

    public n0 d() {
        return new n0(this);
    }

    public l0 e(String str) {
        if (str == null) {
            return this;
        }
        if (this.f22726b == null) {
            return new l0(this.f22725a, str, this.f22727c);
        }
        return new l0(this.f22725a, this.f22726b + "\n" + str, this.f22727c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable l() {
        return this.f22727c;
    }

    public b m() {
        return this.f22725a;
    }

    public String n() {
        return this.f22726b;
    }

    public boolean o() {
        return b.OK == this.f22725a;
    }

    public l0 p(Throwable th) {
        return H2.i.a(this.f22727c, th) ? this : new l0(this.f22725a, this.f22726b, th);
    }

    public l0 q(String str) {
        return H2.i.a(this.f22726b, str) ? this : new l0(this.f22725a, str, this.f22727c);
    }

    public String toString() {
        g.b bVarD = H2.g.b(this).d("code", this.f22725a.name()).d(com.amazon.a.a.o.b.f9940c, this.f22726b);
        Throwable th = this.f22727c;
        Object objE = th;
        if (th != null) {
            objE = H2.u.e(th);
        }
        return bVarD.d("cause", objE).toString();
    }

    public l0(b bVar, String str, Throwable th) {
        this.f22725a = (b) H2.m.o(bVar, "code");
        this.f22726b = str;
        this.f22727c = th;
    }
}
