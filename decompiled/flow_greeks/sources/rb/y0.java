package rb;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f19745c = Logger.getLogger(y0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f19746d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f19747e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r6.a f19748f = r6.a.b().l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f19749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19750b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements e {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f19751f;

        public /* synthetic */ c(String str, boolean z10, d dVar, a aVar) {
            this(str, z10, dVar);
        }

        @Override // rb.y0.g
        public Object h(byte[] bArr) {
            return this.f19751f.b(new String(bArr, p6.d.f18311a));
        }

        @Override // rb.y0.g
        public byte[] j(Object obj) {
            return ((String) p6.n.o(this.f19751f.a(obj), "null marshaller.toAsciiString()")).getBytes(p6.d.f18311a);
        }

        public c(String str, boolean z10, d dVar) {
            super(str, z10, dVar, null);
            p6.n.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f19751f = (d) p6.n.o(dVar, "marshaller");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        String a(Object obj);

        Object b(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface f {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final BitSet f19752e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f19753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f19755c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f19756d;

        public /* synthetic */ g(String str, boolean z10, Object obj, a aVar) {
            this(str, z10, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            for (char c11 = 'a'; c11 <= 'z'; c11 = (char) (c11 + 1)) {
                bitSet.set(c11);
            }
            return bitSet;
        }

        public static g e(String str, d dVar) {
            return f(str, false, dVar);
        }

        public static g f(String str, boolean z10, d dVar) {
            return new c(str, z10, dVar, null);
        }

        public static g g(String str, boolean z10, j jVar) {
            return new i(str, z10, jVar, null);
        }

        public static String k(String str, boolean z10) {
            p6.n.o(str, "name");
            p6.n.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                y0.f19745c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char cCharAt = str.charAt(i10);
                if (!z10 || cCharAt != ':' || i10 != 0) {
                    p6.n.g(f19752e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f19755c;
        }

        public final Object c(Class cls) {
            if (cls.isInstance(this.f19756d)) {
                return cls.cast(this.f19756d);
            }
            return null;
        }

        public final String d() {
            return this.f19754b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f19754b.equals(((g) obj).f19754b);
        }

        public abstract Object h(byte[] bArr);

        public final int hashCode() {
            return this.f19754b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(Object obj);

        public String toString() {
            return "Key{name='" + this.f19754b + "'}";
        }

        public g(String str, boolean z10, Object obj) {
            String str2 = (String) p6.n.o(str, "name");
            this.f19753a = str2;
            String strK = k(str2.toLowerCase(Locale.ROOT), z10);
            this.f19754b = strK;
            this.f19755c = strK.getBytes(p6.d.f18311a);
            this.f19756d = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f19757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile byte[] f19758b;

        public h(f fVar, Object obj) {
            this.f19757a = obj;
        }

        public static h a(g gVar, Object obj) {
            b(gVar);
            android.support.v4.media.session.b.a(p6.n.n(null));
            return new h(null, obj);
        }

        public static f b(g gVar) {
            android.support.v4.media.session.b.a(gVar.c(f.class));
            return null;
        }

        public byte[] c() {
            if (this.f19758b == null) {
                synchronized (this) {
                    try {
                        if (this.f19758b == null) {
                            this.f19758b = y0.r(e());
                        }
                    } finally {
                    }
                }
            }
            return this.f19758b;
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final j f19759f;

        public /* synthetic */ i(String str, boolean z10, j jVar, a aVar) {
            this(str, z10, jVar);
        }

        @Override // rb.y0.g
        public Object h(byte[] bArr) {
            return this.f19759f.b(bArr);
        }

        @Override // rb.y0.g
        public byte[] j(Object obj) {
            return (byte[]) p6.n.o(this.f19759f.a(obj), "null marshaller.toAsciiString()");
        }

        public i(String str, boolean z10, j jVar) {
            super(str, z10, jVar, null);
            p6.n.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f19759f = (j) p6.n.o(jVar, "marshaller");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface j {
        byte[] a(Object obj);

        Object b(byte[] bArr);
    }

    public y0(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public static byte[] r(InputStream inputStream) {
        try {
            return r6.b.d(inputStream);
        } catch (IOException e10) {
            throw new RuntimeException("failure reading serialized stream", e10);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f19749a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public void e(g gVar) {
        if (i()) {
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f19750b; i11++) {
            if (!c(gVar.a(), o(i11))) {
                n(i10, o(i11));
                t(i10, s(i11));
                i10++;
            }
        }
        Arrays.fill(this.f19749a, i10 * 2, k(), (Object) null);
        this.f19750b = i10;
    }

    public final void f(int i10) {
        Object[] objArr = new Object[i10];
        if (!i()) {
            System.arraycopy(this.f19749a, 0, objArr, 0, k());
        }
        this.f19749a = objArr;
    }

    public Object g(g gVar) {
        for (int i10 = this.f19750b - 1; i10 >= 0; i10--) {
            if (c(gVar.a(), o(i10))) {
                return w(i10, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f19750b;
    }

    public final boolean i() {
        return this.f19750b == 0;
    }

    public Set j() {
        if (i()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(this.f19750b);
        for (int i10 = 0; i10 < this.f19750b; i10++) {
            hashSet.add(new String(o(i10), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final int k() {
        return this.f19750b * 2;
    }

    public final void l() {
        if (k() == 0 || k() == d()) {
            f(Math.max(k() * 2, 8));
        }
    }

    public void m(y0 y0Var) {
        if (y0Var.i()) {
            return;
        }
        int iD = d() - k();
        if (i() || iD < y0Var.k()) {
            f(k() + y0Var.k());
        }
        System.arraycopy(y0Var.f19749a, 0, this.f19749a, k(), y0Var.k());
        this.f19750b += y0Var.f19750b;
    }

    public final void n(int i10, byte[] bArr) {
        this.f19749a[i10 * 2] = bArr;
    }

    public final byte[] o(int i10) {
        return (byte[]) this.f19749a[i10 * 2];
    }

    public void p(g gVar, Object obj) {
        p6.n.o(gVar, "key");
        p6.n.o(obj, "value");
        l();
        n(this.f19750b, gVar.a());
        if (gVar.i()) {
            t(this.f19750b, h.a(gVar, obj));
        } else {
            u(this.f19750b, gVar.j(obj));
        }
        this.f19750b++;
    }

    public byte[][] q() {
        byte[][] bArr = new byte[k()][];
        Object[] objArr = this.f19749a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, k());
            return bArr;
        }
        for (int i10 = 0; i10 < this.f19750b; i10++) {
            int i11 = i10 * 2;
            bArr[i11] = o(i10);
            bArr[i11 + 1] = v(i10);
        }
        return bArr;
    }

    public final Object s(int i10) {
        return this.f19749a[(i10 * 2) + 1];
    }

    public final void t(int i10, Object obj) {
        if (this.f19749a instanceof byte[][]) {
            f(d());
        }
        this.f19749a[(i10 * 2) + 1] = obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.f19750b; i10++) {
            if (i10 != 0) {
                sb2.append(',');
            }
            byte[] bArrO = o(i10);
            Charset charset = p6.d.f18311a;
            String str = new String(bArrO, charset);
            sb2.append(str);
            sb2.append('=');
            if (str.endsWith("-bin")) {
                sb2.append(f19748f.f(v(i10)));
            } else {
                sb2.append(new String(v(i10), charset));
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    public final void u(int i10, byte[] bArr) {
        this.f19749a[(i10 * 2) + 1] = bArr;
    }

    public final byte[] v(int i10) {
        Object objS = s(i10);
        return objS instanceof byte[] ? (byte[]) objS : ((h) objS).c();
    }

    public final Object w(int i10, g gVar) {
        Object objS = s(i10);
        return objS instanceof byte[] ? gVar.h((byte[]) objS) : ((h) objS).d(gVar);
    }

    public y0(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    public y0(int i10, Object[] objArr) {
        this.f19750b = i10;
        this.f19749a = objArr;
    }

    public y0() {
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements d {
        @Override // rb.y0.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // rb.y0.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }
}
