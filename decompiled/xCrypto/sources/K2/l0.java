package K2;

import K2.Z;
import Z1.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f1214d = f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l0 f1215e = b.OK.c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l0 f1216f = b.CANCELLED.c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l0 f1217g = b.UNKNOWN.c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l0 f1218h = b.INVALID_ARGUMENT.c();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l0 f1219i = b.DEADLINE_EXCEEDED.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l0 f1220j = b.NOT_FOUND.c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l0 f1221k = b.ALREADY_EXISTS.c();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l0 f1222l = b.PERMISSION_DENIED.c();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l0 f1223m = b.UNAUTHENTICATED.c();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l0 f1224n = b.RESOURCE_EXHAUSTED.c();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l0 f1225o = b.FAILED_PRECONDITION.c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final l0 f1226p = b.ABORTED.c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l0 f1227q = b.OUT_OF_RANGE.c();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l0 f1228r = b.UNIMPLEMENTED.c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l0 f1229s = b.INTERNAL.c();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l0 f1230t = b.UNAVAILABLE.c();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l0 f1231u = b.DATA_LOSS.c();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Z.g f1232v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Z.j f1233w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Z.g f1234x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f1237c;

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
        public final int f1256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1257b;

        b(int i4) {
            this.f1256a = i4;
            this.f1257b = Integer.toString(i4).getBytes(Z1.c.f5966a);
        }

        public l0 c() {
            return (l0) l0.f1214d.get(this.f1256a);
        }

        public int g() {
            return this.f1256a;
        }

        public final byte[] h() {
            return this.f1257b;
        }
    }

    public static final class c implements Z.j {
        public c() {
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public l0 b(byte[] bArr) {
            return l0.i(bArr);
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(l0 l0Var) {
            return l0Var.m().h();
        }
    }

    public static final class d implements Z.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte[] f1258a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d() {
        }

        public static boolean c(byte b4) {
            return b4 < 32 || b4 >= 126 || b4 == 37;
        }

        public static String e(byte[] bArr) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
            int i4 = 0;
            while (i4 < bArr.length) {
                if (bArr[i4] == 37 && i4 + 2 < bArr.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bArr, i4 + 1, 2, Z1.c.f5966a), 16));
                        i4 += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bArr[i4]);
                        i4++;
                    }
                }
                byteBufferAllocate.put(bArr[i4]);
                i4++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), Z1.c.f5968c);
        }

        public static byte[] g(byte[] bArr, int i4) {
            byte[] bArr2 = new byte[((bArr.length - i4) * 3) + i4];
            if (i4 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i4);
            }
            int i5 = i4;
            while (i4 < bArr.length) {
                byte b4 = bArr[i4];
                if (c(b4)) {
                    bArr2[i5] = 37;
                    byte[] bArr3 = f1258a;
                    bArr2[i5 + 1] = bArr3[(b4 >> 4) & 15];
                    bArr2[i5 + 2] = bArr3[b4 & 15];
                    i5 += 3;
                } else {
                    bArr2[i5] = b4;
                    i5++;
                }
                i4++;
            }
            return Arrays.copyOf(bArr2, i5);
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String b(byte[] bArr) {
            for (int i4 = 0; i4 < bArr.length; i4++) {
                byte b4 = bArr[i4];
                if (b4 < 32 || b4 >= 126 || (b4 == 37 && i4 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // K2.Z.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(Z1.c.f5968c);
            for (int i4 = 0; i4 < bytes.length; i4++) {
                if (c(bytes[i4])) {
                    return g(bytes, i4);
                }
            }
            return bytes;
        }
    }

    static {
        f1232v = Z.g.g("grpc-status", false, new c());
        d dVar = new d();
        f1233w = dVar;
        f1234x = Z.g.g("grpc-message", false, dVar);
    }

    public l0(b bVar) {
        this(bVar, null, null);
    }

    public static List f() {
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            l0 l0Var = (l0) treeMap.put(Integer.valueOf(bVar.g()), new l0(bVar));
            if (l0Var != null) {
                throw new IllegalStateException("Code value duplication between " + l0Var.m().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    public static String g(l0 l0Var) {
        if (l0Var.f1236b == null) {
            return l0Var.f1235a.toString();
        }
        return l0Var.f1235a + ": " + l0Var.f1236b;
    }

    public static l0 h(int i4) {
        if (i4 >= 0) {
            List list = f1214d;
            if (i4 < list.size()) {
                return (l0) list.get(i4);
            }
        }
        return f1217g.q("Unknown code " + i4);
    }

    public static l0 i(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f1215e : j(bArr);
    }

    public static l0 j(byte[] bArr) {
        int i4;
        byte b4;
        int length = bArr.length;
        char c4 = 1;
        if (length != 1) {
            i4 = (length == 2 && (b4 = bArr[0]) >= 48 && b4 <= 57) ? (b4 - 48) * 10 : 0;
            return f1217g.q("Unknown code " + new String(bArr, Z1.c.f5966a));
        }
        c4 = 0;
        byte b5 = bArr[c4];
        if (b5 >= 48 && b5 <= 57) {
            int i5 = i4 + (b5 - 48);
            List list = f1214d;
            if (i5 < list.size()) {
                return (l0) list.get(i5);
            }
        }
        return f1217g.q("Unknown code " + new String(bArr, Z1.c.f5966a));
    }

    public static l0 k(Throwable th) {
        for (Throwable cause = (Throwable) Z1.m.o(th, "t"); cause != null; cause = cause.getCause()) {
            if (cause instanceof m0) {
                return ((m0) cause).a();
            }
            if (cause instanceof n0) {
                return ((n0) cause).a();
            }
        }
        return f1217g.p(th);
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
        if (this.f1236b == null) {
            return new l0(this.f1235a, str, this.f1237c);
        }
        return new l0(this.f1235a, this.f1236b + "\n" + str, this.f1237c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable l() {
        return this.f1237c;
    }

    public b m() {
        return this.f1235a;
    }

    public String n() {
        return this.f1236b;
    }

    public boolean o() {
        return b.OK == this.f1235a;
    }

    public l0 p(Throwable th) {
        return Z1.i.a(this.f1237c, th) ? this : new l0(this.f1235a, this.f1236b, th);
    }

    public l0 q(String str) {
        return Z1.i.a(this.f1236b, str) ? this : new l0(this.f1235a, str, this.f1237c);
    }

    public String toString() {
        g.b bVarD = Z1.g.b(this).d("code", this.f1235a.name()).d(com.amazon.a.a.o.b.f8755c, this.f1236b);
        Throwable th = this.f1237c;
        Object objE = th;
        if (th != null) {
            objE = Z1.u.e(th);
        }
        return bVarD.d("cause", objE).toString();
    }

    public l0(b bVar, String str, Throwable th) {
        this.f1235a = (b) Z1.m.o(bVar, "code");
        this.f1236b = str;
        this.f1237c = th;
    }
}
