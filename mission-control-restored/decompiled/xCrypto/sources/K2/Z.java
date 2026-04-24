package K2;

import b2.AbstractC0862a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class Z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1095c = Logger.getLogger(Z.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f1096d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f1097e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0862a f1098f = AbstractC0862a.a().k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1100b;

    public class a implements e {
    }

    public static class c extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f1101f;

        public /* synthetic */ c(String str, boolean z4, d dVar, a aVar) {
            this(str, z4, dVar);
        }

        @Override // K2.Z.g
        public Object h(byte[] bArr) {
            return this.f1101f.b(new String(bArr, Z1.c.f5966a));
        }

        @Override // K2.Z.g
        public byte[] j(Object obj) {
            return ((String) Z1.m.o(this.f1101f.a(obj), "null marshaller.toAsciiString()")).getBytes(Z1.c.f5966a);
        }

        public c(String str, boolean z4, d dVar) {
            super(str, z4, dVar, null);
            Z1.m.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f1101f = (d) Z1.m.o(dVar, "marshaller");
        }
    }

    public interface d {
        String a(Object obj);

        Object b(String str);
    }

    public interface e {
    }

    public interface f {
    }

    public static abstract class g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final BitSet f1102e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f1105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f1106d;

        public /* synthetic */ g(String str, boolean z4, Object obj, a aVar) {
            this(str, z4, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c4 = '0'; c4 <= '9'; c4 = (char) (c4 + 1)) {
                bitSet.set(c4);
            }
            for (char c5 = 'a'; c5 <= 'z'; c5 = (char) (c5 + 1)) {
                bitSet.set(c5);
            }
            return bitSet;
        }

        public static g e(String str, d dVar) {
            return f(str, false, dVar);
        }

        public static g f(String str, boolean z4, d dVar) {
            return new c(str, z4, dVar, null);
        }

        public static g g(String str, boolean z4, j jVar) {
            return new i(str, z4, jVar, null);
        }

        public static String k(String str, boolean z4) {
            Z1.m.o(str, "name");
            Z1.m.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                Z.f1095c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i4 = 0; i4 < str.length(); i4++) {
                char cCharAt = str.charAt(i4);
                if (!z4 || cCharAt != ':' || i4 != 0) {
                    Z1.m.g(f1102e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f1105c;
        }

        public final Object c(Class cls) {
            if (cls.isInstance(this.f1106d)) {
                return cls.cast(this.f1106d);
            }
            return null;
        }

        public final String d() {
            return this.f1104b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1104b.equals(((g) obj).f1104b);
        }

        public abstract Object h(byte[] bArr);

        public final int hashCode() {
            return this.f1104b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(Object obj);

        public String toString() {
            return "Key{name='" + this.f1104b + "'}";
        }

        public g(String str, boolean z4, Object obj) {
            String str2 = (String) Z1.m.o(str, "name");
            this.f1103a = str2;
            String strK = k(str2.toLowerCase(Locale.ROOT), z4);
            this.f1104b = strK;
            this.f1105c = strK.getBytes(Z1.c.f5966a);
            this.f1106d = obj;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile byte[] f1108b;

        public h(f fVar, Object obj) {
            this.f1107a = obj;
        }

        public static h a(g gVar, Object obj) {
            b(gVar);
            android.support.v4.media.session.b.a(Z1.m.n(null));
            return new h(null, obj);
        }

        public static f b(g gVar) {
            android.support.v4.media.session.b.a(gVar.c(f.class));
            return null;
        }

        public byte[] c() {
            if (this.f1108b == null) {
                synchronized (this) {
                    try {
                        if (this.f1108b == null) {
                            this.f1108b = Z.r(e());
                        }
                    } finally {
                    }
                }
            }
            return this.f1108b;
        }

        public Object d(g gVar) {
            if (gVar.i()) {
                b(gVar);
            }
            return gVar.h(c());
        }

        public InputStream e() {
            throw null;
        }
    }

    public static final class i extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final j f1109f;

        public /* synthetic */ i(String str, boolean z4, j jVar, a aVar) {
            this(str, z4, jVar);
        }

        @Override // K2.Z.g
        public Object h(byte[] bArr) {
            return this.f1109f.b(bArr);
        }

        @Override // K2.Z.g
        public byte[] j(Object obj) {
            return (byte[]) Z1.m.o(this.f1109f.a(obj), "null marshaller.toAsciiString()");
        }

        public i(String str, boolean z4, j jVar) {
            super(str, z4, jVar, null);
            Z1.m.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f1109f = (j) Z1.m.o(jVar, "marshaller");
        }
    }

    public interface j {
        byte[] a(Object obj);

        Object b(byte[] bArr);
    }

    public Z(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public static byte[] r(InputStream inputStream) {
        try {
            return b2.b.d(inputStream);
        } catch (IOException e4) {
            throw new RuntimeException("failure reading serialized stream", e4);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f1099a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public void e(g gVar) {
        if (i()) {
            return;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f1100b; i5++) {
            if (!c(gVar.a(), o(i5))) {
                n(i4, o(i5));
                t(i4, s(i5));
                i4++;
            }
        }
        Arrays.fill(this.f1099a, i4 * 2, k(), (Object) null);
        this.f1100b = i4;
    }

    public final void f(int i4) {
        Object[] objArr = new Object[i4];
        if (!i()) {
            System.arraycopy(this.f1099a, 0, objArr, 0, k());
        }
        this.f1099a = objArr;
    }

    public Object g(g gVar) {
        for (int i4 = this.f1100b - 1; i4 >= 0; i4--) {
            if (c(gVar.a(), o(i4))) {
                return w(i4, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f1100b;
    }

    public final boolean i() {
        return this.f1100b == 0;
    }

    public Set j() {
        if (i()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(this.f1100b);
        for (int i4 = 0; i4 < this.f1100b; i4++) {
            hashSet.add(new String(o(i4), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final int k() {
        return this.f1100b * 2;
    }

    public final void l() {
        if (k() == 0 || k() == d()) {
            f(Math.max(k() * 2, 8));
        }
    }

    public void m(Z z4) {
        if (z4.i()) {
            return;
        }
        int iD = d() - k();
        if (i() || iD < z4.k()) {
            f(k() + z4.k());
        }
        System.arraycopy(z4.f1099a, 0, this.f1099a, k(), z4.k());
        this.f1100b += z4.f1100b;
    }

    public final void n(int i4, byte[] bArr) {
        this.f1099a[i4 * 2] = bArr;
    }

    public final byte[] o(int i4) {
        return (byte[]) this.f1099a[i4 * 2];
    }

    public void p(g gVar, Object obj) {
        Z1.m.o(gVar, "key");
        Z1.m.o(obj, "value");
        l();
        n(this.f1100b, gVar.a());
        if (gVar.i()) {
            t(this.f1100b, h.a(gVar, obj));
        } else {
            u(this.f1100b, gVar.j(obj));
        }
        this.f1100b++;
    }

    public byte[][] q() {
        byte[][] bArr = new byte[k()][];
        Object[] objArr = this.f1099a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, k());
            return bArr;
        }
        for (int i4 = 0; i4 < this.f1100b; i4++) {
            int i5 = i4 * 2;
            bArr[i5] = o(i4);
            bArr[i5 + 1] = v(i4);
        }
        return bArr;
    }

    public final Object s(int i4) {
        return this.f1099a[(i4 * 2) + 1];
    }

    public final void t(int i4, Object obj) {
        if (this.f1099a instanceof byte[][]) {
            f(d());
        }
        this.f1099a[(i4 * 2) + 1] = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i4 = 0; i4 < this.f1100b; i4++) {
            if (i4 != 0) {
                sb.append(',');
            }
            byte[] bArrO = o(i4);
            Charset charset = Z1.c.f5966a;
            String str = new String(bArrO, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(f1098f.e(v(i4)));
            } else {
                sb.append(new String(v(i4), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final void u(int i4, byte[] bArr) {
        this.f1099a[(i4 * 2) + 1] = bArr;
    }

    public final byte[] v(int i4) {
        Object objS = s(i4);
        return objS instanceof byte[] ? (byte[]) objS : ((h) objS).c();
    }

    public final Object w(int i4, g gVar) {
        Object objS = s(i4);
        return objS instanceof byte[] ? gVar.h((byte[]) objS) : ((h) objS).d(gVar);
    }

    public Z(int i4, byte[]... bArr) {
        this(i4, (Object[]) bArr);
    }

    public Z(int i4, Object[] objArr) {
        this.f1100b = i4;
        this.f1099a = objArr;
    }

    public Z() {
    }

    public class b implements d {
        @Override // K2.Z.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // K2.Z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }
}
