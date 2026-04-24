package r5;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
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

/* JADX INFO: loaded from: classes2.dex */
public final class Z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f22585c = Logger.getLogger(Z.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f22586d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f22587e = new b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final J2.a f22588f = J2.a.a().k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f22589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22590b;

    public class a implements e {
    }

    public static class c extends g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final d f22591f;

        public /* synthetic */ c(String str, boolean z7, d dVar, a aVar) {
            this(str, z7, dVar);
        }

        @Override // r5.Z.g
        public Object h(byte[] bArr) {
            return this.f22591f.b(new String(bArr, H2.c.f2591a));
        }

        @Override // r5.Z.g
        public byte[] j(Object obj) {
            return ((String) H2.m.o(this.f22591f.a(obj), "null marshaller.toAsciiString()")).getBytes(H2.c.f2591a);
        }

        public c(String str, boolean z7, d dVar) {
            super(str, z7, dVar, null);
            H2.m.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f22591f = (d) H2.m.o(dVar, "marshaller");
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
        public static final BitSet f22592e = b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f22594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f22595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f22596d;

        public /* synthetic */ g(String str, boolean z7, Object obj, a aVar) {
            this(str, z7, obj);
        }

        public static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c7 = '0'; c7 <= '9'; c7 = (char) (c7 + 1)) {
                bitSet.set(c7);
            }
            for (char c8 = 'a'; c8 <= 'z'; c8 = (char) (c8 + 1)) {
                bitSet.set(c8);
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
            H2.m.o(str, "name");
            H2.m.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                Z.f22585c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i7 = 0; i7 < str.length(); i7++) {
                char cCharAt = str.charAt(i7);
                if (!z7 || cCharAt != ':' || i7 != 0) {
                    H2.m.g(f22592e.get(cCharAt), "Invalid character '%s' in key name '%s'", cCharAt, str);
                }
            }
            return str;
        }

        public byte[] a() {
            return this.f22595c;
        }

        public final Object c(Class cls) {
            if (cls.isInstance(this.f22596d)) {
                return cls.cast(this.f22596d);
            }
            return null;
        }

        public final String d() {
            return this.f22594b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f22594b.equals(((g) obj).f22594b);
        }

        public abstract Object h(byte[] bArr);

        public final int hashCode() {
            return this.f22594b.hashCode();
        }

        public boolean i() {
            return false;
        }

        public abstract byte[] j(Object obj);

        public String toString() {
            return "Key{name='" + this.f22594b + "'}";
        }

        public g(String str, boolean z7, Object obj) {
            String str2 = (String) H2.m.o(str, "name");
            this.f22593a = str2;
            String strK = k(str2.toLowerCase(Locale.ROOT), z7);
            this.f22594b = strK;
            this.f22595c = strK.getBytes(H2.c.f2591a);
            this.f22596d = obj;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile byte[] f22598b;

        public h(f fVar, Object obj) {
            this.f22597a = obj;
        }

        public static h a(g gVar, Object obj) {
            b(gVar);
            android.support.v4.media.session.b.a(H2.m.n(null));
            return new h(null, obj);
        }

        public static f b(g gVar) {
            android.support.v4.media.session.b.a(gVar.c(f.class));
            return null;
        }

        public byte[] c() {
            if (this.f22598b == null) {
                synchronized (this) {
                    try {
                        if (this.f22598b == null) {
                            this.f22598b = Z.r(e());
                        }
                    } finally {
                    }
                }
            }
            return this.f22598b;
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
        public final j f22599f;

        public /* synthetic */ i(String str, boolean z7, j jVar, a aVar) {
            this(str, z7, jVar);
        }

        @Override // r5.Z.g
        public Object h(byte[] bArr) {
            return this.f22599f.b(bArr);
        }

        @Override // r5.Z.g
        public byte[] j(Object obj) {
            return (byte[]) H2.m.o(this.f22599f.a(obj), "null marshaller.toAsciiString()");
        }

        public i(String str, boolean z7, j jVar) {
            super(str, z7, jVar, null);
            H2.m.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f22599f = (j) H2.m.o(jVar, "marshaller");
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
            return J2.b.d(inputStream);
        } catch (IOException e7) {
            throw new RuntimeException("failure reading serialized stream", e7);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f22589a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public void e(g gVar) {
        if (i()) {
            return;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.f22590b; i8++) {
            if (!c(gVar.a(), o(i8))) {
                n(i7, o(i8));
                t(i7, s(i8));
                i7++;
            }
        }
        Arrays.fill(this.f22589a, i7 * 2, k(), (Object) null);
        this.f22590b = i7;
    }

    public final void f(int i7) {
        Object[] objArr = new Object[i7];
        if (!i()) {
            System.arraycopy(this.f22589a, 0, objArr, 0, k());
        }
        this.f22589a = objArr;
    }

    public Object g(g gVar) {
        for (int i7 = this.f22590b - 1; i7 >= 0; i7--) {
            if (c(gVar.a(), o(i7))) {
                return w(i7, gVar);
            }
        }
        return null;
    }

    public int h() {
        return this.f22590b;
    }

    public final boolean i() {
        return this.f22590b == 0;
    }

    public Set j() {
        if (i()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f22590b);
        for (int i7 = 0; i7 < this.f22590b; i7++) {
            hashSet.add(new String(o(i7), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final int k() {
        return this.f22590b * 2;
    }

    public final void l() {
        if (k() == 0 || k() == d()) {
            f(Math.max(k() * 2, 8));
        }
    }

    public void m(Z z7) {
        if (z7.i()) {
            return;
        }
        int iD = d() - k();
        if (i() || iD < z7.k()) {
            f(k() + z7.k());
        }
        System.arraycopy(z7.f22589a, 0, this.f22589a, k(), z7.k());
        this.f22590b += z7.f22590b;
    }

    public final void n(int i7, byte[] bArr) {
        this.f22589a[i7 * 2] = bArr;
    }

    public final byte[] o(int i7) {
        return (byte[]) this.f22589a[i7 * 2];
    }

    public void p(g gVar, Object obj) {
        H2.m.o(gVar, SubscriberAttributeKt.JSON_NAME_KEY);
        H2.m.o(obj, "value");
        l();
        n(this.f22590b, gVar.a());
        if (gVar.i()) {
            t(this.f22590b, h.a(gVar, obj));
        } else {
            u(this.f22590b, gVar.j(obj));
        }
        this.f22590b++;
    }

    public byte[][] q() {
        byte[][] bArr = new byte[k()][];
        Object[] objArr = this.f22589a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, k());
        } else {
            for (int i7 = 0; i7 < this.f22590b; i7++) {
                int i8 = i7 * 2;
                bArr[i8] = o(i7);
                bArr[i8 + 1] = v(i7);
            }
        }
        return bArr;
    }

    public final Object s(int i7) {
        return this.f22589a[(i7 * 2) + 1];
    }

    public final void t(int i7, Object obj) {
        if (this.f22589a instanceof byte[][]) {
            f(d());
        }
        this.f22589a[(i7 * 2) + 1] = obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i7 = 0; i7 < this.f22590b; i7++) {
            if (i7 != 0) {
                sb.append(',');
            }
            byte[] bArrO = o(i7);
            Charset charset = H2.c.f2591a;
            String str = new String(bArrO, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(f22588f.e(v(i7)));
            } else {
                sb.append(new String(v(i7), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final void u(int i7, byte[] bArr) {
        this.f22589a[(i7 * 2) + 1] = bArr;
    }

    public final byte[] v(int i7) {
        Object objS = s(i7);
        return objS instanceof byte[] ? (byte[]) objS : ((h) objS).c();
    }

    public final Object w(int i7, g gVar) {
        Object objS = s(i7);
        return objS instanceof byte[] ? gVar.h((byte[]) objS) : ((h) objS).d(gVar);
    }

    public Z(int i7, byte[]... bArr) {
        this(i7, (Object[]) bArr);
    }

    public Z(int i7, Object[] objArr) {
        this.f22590b = i7;
        this.f22589a = objArr;
    }

    public Z() {
    }

    public class b implements d {
        @Override // r5.Z.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // r5.Z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }
}
