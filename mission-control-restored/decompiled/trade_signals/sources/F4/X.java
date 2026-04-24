package F4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import v2.AbstractC2838d;
import v2.AbstractC2848n;
import x2.AbstractC2954a;
import x2.AbstractC2955b;

/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1684c = Logger.getLogger(X.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f1685d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f1686e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC2954a f1687f = AbstractC2954a.b().l();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f1688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1689b;

    public class a implements e {
    }

    public static class c extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f1690f;

        public c(String str, boolean z7, d dVar) {
            super(str, z7, dVar, null);
            AbstractC2848n.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f1690f = (d) AbstractC2848n.o(dVar, "marshaller");
        }

        @Override // F4.X.g
        public Object h(byte[] bArr) {
            return this.f1690f.b(new String(bArr, AbstractC2838d.f23751a));
        }

        @Override // F4.X.g
        public byte[] j(Object obj) {
            return ((String) AbstractC2848n.o(this.f1690f.a(obj), "null marshaller.toAsciiString()")).getBytes(AbstractC2838d.f23751a);
        }

        public /* synthetic */ c(String str, boolean z7, d dVar, a aVar) {
            this(str, z7, dVar);
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
        public static final BitSet f1691e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f1694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f1695d;

        public g(String str, boolean z7, Object obj) {
            String str2 = (String) AbstractC2848n.o(str, "name");
            this.f1692a = str2;
            String strK = k(str2.toLowerCase(Locale.ROOT), z7);
            this.f1693b = strK;
            this.f1694c = strK.getBytes(AbstractC2838d.f23751a);
            this.f1695d = obj;
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c8 = '0'; c8 <= '9'; c8 = (char) (c8 + 1)) {
                bitSet.set(c8);
            }
            for (char c9 = 'a'; c9 <= 'z'; c9 = (char) (c9 + 1)) {
                bitSet.set(c9);
            }
            return bitSet;
        }

        public static g e(String str, d dVar) {
            return f(str, false, dVar);
        }

        public static g f(String str, boolean z7, d dVar) {
            return new c(str, z7, dVar, null);
        }

        public static g g(String str, boolean z7, j jVar) {
            return new i(str, z7, jVar, null);
        }

        public static String k(String str, boolean z7) {
            AbstractC2848n.o(str, "name");
            AbstractC2848n.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                X.f1684c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i8 = 0; i8 < str.length(); i8++) {
                char cCharAt = str.charAt(i8);
                if (!z7 || cCharAt != ':' || i8 != 0) {
                    AbstractC2848n.g(f1691e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f1694c;
        }

        public final Object c(Class cls) {
            if (cls.isInstance(this.f1695d)) {
                return cls.cast(this.f1695d);
            }
            return null;
        }

        public final String d() {
            return this.f1693b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1693b.equals(((g) obj).f1693b);
        }

        public abstract Object h(byte[] bArr);

        public final int hashCode() {
            return this.f1693b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(Object obj);

        public String toString() {
            return "Key{name='" + this.f1693b + "'}";
        }

        public /* synthetic */ g(String str, boolean z7, Object obj, a aVar) {
            this(str, z7, obj);
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile byte[] f1697b;

        public h(f fVar, Object obj) {
            this.f1696a = obj;
        }

        public static h a(g gVar, Object obj) {
            b(gVar);
            android.support.v4.media.session.b.a(AbstractC2848n.n(null));
            return new h(null, obj);
        }

        public static f b(g gVar) {
            android.support.v4.media.session.b.a(gVar.c(f.class));
            return null;
        }

        public byte[] c() {
            if (this.f1697b == null) {
                synchronized (this) {
                    try {
                        if (this.f1697b == null) {
                            this.f1697b = X.q(e());
                        }
                    } finally {
                    }
                }
            }
            return this.f1697b;
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
        public final j f1698f;

        public i(String str, boolean z7, j jVar) {
            super(str, z7, jVar, null);
            AbstractC2848n.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f1698f = (j) AbstractC2848n.o(jVar, "marshaller");
        }

        @Override // F4.X.g
        public Object h(byte[] bArr) {
            return this.f1698f.b(bArr);
        }

        @Override // F4.X.g
        public byte[] j(Object obj) {
            return (byte[]) AbstractC2848n.o(this.f1698f.a(obj), "null marshaller.toAsciiString()");
        }

        public /* synthetic */ i(String str, boolean z7, j jVar, a aVar) {
            this(str, z7, jVar);
        }
    }

    public interface j {
        byte[] a(Object obj);

        Object b(byte[] bArr);
    }

    public X() {
    }

    public static byte[] q(InputStream inputStream) {
        try {
            return AbstractC2955b.d(inputStream);
        } catch (IOException e8) {
            throw new RuntimeException("failure reading serialized stream", e8);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f1688a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public void e(g gVar) {
        if (i()) {
            return;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.f1689b; i9++) {
            if (!c(gVar.a(), n(i9))) {
                m(i8, n(i9));
                s(i8, r(i9));
                i8++;
            }
        }
        Arrays.fill(this.f1688a, i8 * 2, j(), (Object) null);
        this.f1689b = i8;
    }

    public final void f(int i8) {
        Object[] objArr = new Object[i8];
        if (!i()) {
            System.arraycopy(this.f1688a, 0, objArr, 0, j());
        }
        this.f1688a = objArr;
    }

    public Object g(g gVar) {
        for (int i8 = this.f1689b - 1; i8 >= 0; i8--) {
            if (c(gVar.a(), n(i8))) {
                return v(i8, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f1689b;
    }

    public final boolean i() {
        return this.f1689b == 0;
    }

    public final int j() {
        return this.f1689b * 2;
    }

    public final void k() {
        if (j() == 0 || j() == d()) {
            f(Math.max(j() * 2, 8));
        }
    }

    public void l(X x8) {
        if (x8.i()) {
            return;
        }
        int iD = d() - j();
        if (i() || iD < x8.j()) {
            f(j() + x8.j());
        }
        System.arraycopy(x8.f1688a, 0, this.f1688a, j(), x8.j());
        this.f1689b += x8.f1689b;
    }

    public final void m(int i8, byte[] bArr) {
        this.f1688a[i8 * 2] = bArr;
    }

    public final byte[] n(int i8) {
        return (byte[]) this.f1688a[i8 * 2];
    }

    public void o(g gVar, Object obj) {
        AbstractC2848n.o(gVar, "key");
        AbstractC2848n.o(obj, "value");
        k();
        m(this.f1689b, gVar.a());
        if (gVar.i()) {
            s(this.f1689b, h.a(gVar, obj));
        } else {
            t(this.f1689b, gVar.j(obj));
        }
        this.f1689b++;
    }

    public byte[][] p() {
        byte[][] bArr = new byte[j()][];
        Object[] objArr = this.f1688a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, j());
        } else {
            for (int i8 = 0; i8 < this.f1689b; i8++) {
                int i9 = i8 * 2;
                bArr[i9] = n(i8);
                bArr[i9 + 1] = u(i8);
            }
        }
        return bArr;
    }

    public final Object r(int i8) {
        return this.f1688a[(i8 * 2) + 1];
    }

    public final void s(int i8, Object obj) {
        if (this.f1688a instanceof byte[][]) {
            f(d());
        }
        this.f1688a[(i8 * 2) + 1] = obj;
    }

    public final void t(int i8, byte[] bArr) {
        this.f1688a[(i8 * 2) + 1] = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i8 = 0; i8 < this.f1689b; i8++) {
            if (i8 != 0) {
                sb.append(',');
            }
            byte[] bArrN = n(i8);
            Charset charset = AbstractC2838d.f23751a;
            String str = new String(bArrN, charset);
            sb.append(str);
            sb.append('=');
            sb.append(str.endsWith("-bin") ? f1687f.f(u(i8)) : new String(u(i8), charset));
        }
        sb.append(')');
        return sb.toString();
    }

    public final byte[] u(int i8) {
        Object objR = r(i8);
        return objR instanceof byte[] ? (byte[]) objR : ((h) objR).c();
    }

    public final Object v(int i8, g gVar) {
        Object objR = r(i8);
        return objR instanceof byte[] ? gVar.h((byte[]) objR) : ((h) objR).d(gVar);
    }

    public X(int i8, Object[] objArr) {
        this.f1689b = i8;
        this.f1688a = objArr;
    }

    public X(int i8, byte[]... bArr) {
        this(i8, (Object[]) bArr);
    }

    public X(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public class b implements d {
        @Override // F4.X.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // F4.X.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }
}
