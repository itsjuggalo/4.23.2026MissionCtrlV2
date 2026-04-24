package w5;

import com.google.android.gms.common.api.a;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import w6.C2792e;
import w6.C2795h;
import w6.InterfaceC2794g;
import w6.L;
import w6.Z;

/* JADX INFO: renamed from: w5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2783f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2795h f24984a = C2795h.j(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C2781d[] f24985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f24986c;

    /* JADX INFO: renamed from: w5.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f24987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2794g f24988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public C2781d[] f24991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f24992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f24993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f24994h;

        public a(int i7, Z z7) {
            this(i7, i7, z7);
        }

        public final void a() {
            int i7 = this.f24990d;
            int i8 = this.f24994h;
            if (i7 < i8) {
                if (i7 == 0) {
                    b();
                } else {
                    d(i8 - i7);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f24991e, (Object) null);
            this.f24992f = this.f24991e.length - 1;
            this.f24993g = 0;
            this.f24994h = 0;
        }

        public final int c(int i7) {
            return this.f24992f + 1 + i7;
        }

        public final int d(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f24991e.length;
                while (true) {
                    length--;
                    i8 = this.f24992f;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f24991e[length].f24978c;
                    i7 -= i10;
                    this.f24994h -= i10;
                    this.f24993g--;
                    i9++;
                }
                C2781d[] c2781dArr = this.f24991e;
                System.arraycopy(c2781dArr, i8 + 1, c2781dArr, i8 + 1 + i9, this.f24993g);
                this.f24992f += i9;
            }
            return i9;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f24987a);
            this.f24987a.clear();
            return arrayList;
        }

        public final C2795h f(int i7) throws IOException {
            if (i(i7)) {
                return AbstractC2783f.f24985b[i7].f24976a;
            }
            int iC = c(i7 - AbstractC2783f.f24985b.length);
            if (iC >= 0) {
                C2781d[] c2781dArr = this.f24991e;
                if (iC < c2781dArr.length) {
                    return c2781dArr[iC].f24976a;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        public void g(int i7) {
            this.f24989c = i7;
            this.f24990d = i7;
            a();
        }

        public final void h(int i7, C2781d c2781d) {
            this.f24987a.add(c2781d);
            int i8 = c2781d.f24978c;
            if (i7 != -1) {
                i8 -= this.f24991e[c(i7)].f24978c;
            }
            int i9 = this.f24990d;
            if (i8 > i9) {
                b();
                return;
            }
            int iD = d((this.f24994h + i8) - i9);
            if (i7 == -1) {
                int i10 = this.f24993g + 1;
                C2781d[] c2781dArr = this.f24991e;
                if (i10 > c2781dArr.length) {
                    C2781d[] c2781dArr2 = new C2781d[c2781dArr.length * 2];
                    System.arraycopy(c2781dArr, 0, c2781dArr2, c2781dArr.length, c2781dArr.length);
                    this.f24992f = this.f24991e.length - 1;
                    this.f24991e = c2781dArr2;
                }
                int i11 = this.f24992f;
                this.f24992f = i11 - 1;
                this.f24991e[i11] = c2781d;
                this.f24993g++;
            } else {
                this.f24991e[i7 + c(i7) + iD] = c2781d;
            }
            this.f24994h += i8;
        }

        public final boolean i(int i7) {
            return i7 >= 0 && i7 <= AbstractC2783f.f24985b.length - 1;
        }

        public final int j() {
            return this.f24988b.readByte() & 255;
        }

        public C2795h k() {
            int iJ = j();
            boolean z7 = (iJ & 128) == 128;
            int iN = n(iJ, 127);
            return z7 ? C2795h.A(C2785h.f().c(this.f24988b.Y(iN))) : this.f24988b.o(iN);
        }

        public void l() throws IOException {
            while (!this.f24988b.u()) {
                byte b7 = this.f24988b.readByte();
                int i7 = b7 & 255;
                if (i7 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b7 & 128) == 128) {
                    m(n(i7, 127) - 1);
                } else if (i7 == 64) {
                    p();
                } else if ((b7 & 64) == 64) {
                    o(n(i7, 63) - 1);
                } else if ((b7 & 32) == 32) {
                    int iN = n(i7, 31);
                    this.f24990d = iN;
                    if (iN < 0 || iN > this.f24989c) {
                        throw new IOException("Invalid dynamic table size update " + this.f24990d);
                    }
                    a();
                } else if (i7 == 16 || i7 == 0) {
                    r();
                } else {
                    q(n(i7, 15) - 1);
                }
            }
        }

        public final void m(int i7) throws IOException {
            if (i(i7)) {
                this.f24987a.add(AbstractC2783f.f24985b[i7]);
                return;
            }
            int iC = c(i7 - AbstractC2783f.f24985b.length);
            if (iC >= 0) {
                C2781d[] c2781dArr = this.f24991e;
                if (iC <= c2781dArr.length - 1) {
                    this.f24987a.add(c2781dArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        public int n(int i7, int i8) {
            int i9 = i7 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i8 + (iJ << i10);
                }
                i8 += (iJ & 127) << i10;
                i10 += 7;
            }
        }

        public final void o(int i7) {
            h(-1, new C2781d(f(i7), k()));
        }

        public final void p() {
            h(-1, new C2781d(AbstractC2783f.e(k()), k()));
        }

        public final void q(int i7) throws IOException {
            this.f24987a.add(new C2781d(f(i7), k()));
        }

        public final void r() throws IOException {
            this.f24987a.add(new C2781d(AbstractC2783f.e(k()), k()));
        }

        public a(int i7, int i8, Z z7) {
            this.f24987a = new ArrayList();
            this.f24991e = new C2781d[8];
            this.f24992f = r0.length - 1;
            this.f24993g = 0;
            this.f24994h = 0;
            this.f24989c = i7;
            this.f24990d = i8;
            this.f24988b = L.d(z7);
        }
    }

    /* JADX INFO: renamed from: w5.f$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2792e f24995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f24998d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f24999e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f25000f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public C2781d[] f25001g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f25002h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f25003i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f25004j;

        public b(C2792e c2792e) {
            this(4096, false, c2792e);
        }

        public final void a() {
            Arrays.fill(this.f25001g, (Object) null);
            this.f25003i = this.f25001g.length - 1;
            this.f25002h = 0;
            this.f25004j = 0;
        }

        public final int b(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f25001g.length;
                while (true) {
                    length--;
                    i8 = this.f25003i;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f25001g[length].f24978c;
                    i7 -= i10;
                    this.f25004j -= i10;
                    this.f25002h--;
                    i9++;
                }
                C2781d[] c2781dArr = this.f25001g;
                System.arraycopy(c2781dArr, i8 + 1, c2781dArr, i8 + 1 + i9, this.f25002h);
                this.f25003i += i9;
            }
            return i9;
        }

        public final void c(C2781d c2781d) {
            int i7 = c2781d.f24978c;
            int i8 = this.f25000f;
            if (i7 > i8) {
                a();
                return;
            }
            b((this.f25004j + i7) - i8);
            int i9 = this.f25002h + 1;
            C2781d[] c2781dArr = this.f25001g;
            if (i9 > c2781dArr.length) {
                C2781d[] c2781dArr2 = new C2781d[c2781dArr.length * 2];
                System.arraycopy(c2781dArr, 0, c2781dArr2, c2781dArr.length, c2781dArr.length);
                this.f25003i = this.f25001g.length - 1;
                this.f25001g = c2781dArr2;
            }
            int i10 = this.f25003i;
            this.f25003i = i10 - 1;
            this.f25001g[i10] = c2781d;
            this.f25002h++;
            this.f25004j += i7;
        }

        public void d(C2795h c2795h) throws IOException {
            if (!this.f24996b || C2785h.f().e(c2795h.M()) >= c2795h.H()) {
                f(c2795h.H(), 127, 0);
                this.f24995a.m(c2795h);
                return;
            }
            C2792e c2792e = new C2792e();
            C2785h.f().d(c2795h.M(), c2792e.r0());
            C2795h c2795hA0 = c2792e.A0();
            f(c2795hA0.H(), 127, 128);
            this.f24995a.m(c2795hA0);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e(java.util.List r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 245
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: w5.AbstractC2783f.b.e(java.util.List):void");
        }

        public void f(int i7, int i8, int i9) {
            if (i7 < i8) {
                this.f24995a.v(i7 | i9);
                return;
            }
            this.f24995a.v(i9 | i8);
            int i10 = i7 - i8;
            while (i10 >= 128) {
                this.f24995a.v(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.f24995a.v(i10);
        }

        public b(int i7, boolean z7, C2792e c2792e) {
            this.f24998d = a.e.API_PRIORITY_OTHER;
            this.f25001g = new C2781d[8];
            this.f25003i = r0.length - 1;
            this.f24997c = i7;
            this.f25000f = i7;
            this.f24996b = z7;
            this.f24995a = c2792e;
        }
    }

    static {
        C2781d c2781d = new C2781d(C2781d.f24973h, "");
        C2795h c2795h = C2781d.f24970e;
        C2781d c2781d2 = new C2781d(c2795h, "GET");
        C2781d c2781d3 = new C2781d(c2795h, "POST");
        C2795h c2795h2 = C2781d.f24971f;
        C2781d c2781d4 = new C2781d(c2795h2, "/");
        C2781d c2781d5 = new C2781d(c2795h2, "/index.html");
        C2795h c2795h3 = C2781d.f24972g;
        C2781d c2781d6 = new C2781d(c2795h3, "http");
        C2781d c2781d7 = new C2781d(c2795h3, "https");
        C2795h c2795h4 = C2781d.f24969d;
        f24985b = new C2781d[]{c2781d, c2781d2, c2781d3, c2781d4, c2781d5, c2781d6, c2781d7, new C2781d(c2795h4, "200"), new C2781d(c2795h4, "204"), new C2781d(c2795h4, "206"), new C2781d(c2795h4, "304"), new C2781d(c2795h4, "400"), new C2781d(c2795h4, "404"), new C2781d(c2795h4, "500"), new C2781d("accept-charset", ""), new C2781d("accept-encoding", "gzip, deflate"), new C2781d("accept-language", ""), new C2781d("accept-ranges", ""), new C2781d("accept", ""), new C2781d("access-control-allow-origin", ""), new C2781d("age", ""), new C2781d("allow", ""), new C2781d("authorization", ""), new C2781d("cache-control", ""), new C2781d("content-disposition", ""), new C2781d("content-encoding", ""), new C2781d("content-language", ""), new C2781d("content-length", ""), new C2781d("content-location", ""), new C2781d("content-range", ""), new C2781d("content-type", ""), new C2781d("cookie", ""), new C2781d("date", ""), new C2781d("etag", ""), new C2781d("expect", ""), new C2781d("expires", ""), new C2781d("from", ""), new C2781d(DiagnosticsTracker.HOST_KEY, ""), new C2781d("if-match", ""), new C2781d("if-modified-since", ""), new C2781d("if-none-match", ""), new C2781d("if-range", ""), new C2781d("if-unmodified-since", ""), new C2781d("last-modified", ""), new C2781d("link", ""), new C2781d("location", ""), new C2781d("max-forwards", ""), new C2781d("proxy-authenticate", ""), new C2781d("proxy-authorization", ""), new C2781d("range", ""), new C2781d("referer", ""), new C2781d("refresh", ""), new C2781d("retry-after", ""), new C2781d("server", ""), new C2781d("set-cookie", ""), new C2781d("strict-transport-security", ""), new C2781d("transfer-encoding", ""), new C2781d("user-agent", ""), new C2781d("vary", ""), new C2781d("via", ""), new C2781d("www-authenticate", "")};
        f24986c = f();
    }

    public static C2795h e(C2795h c2795h) throws IOException {
        int iH = c2795h.H();
        for (int i7 = 0; i7 < iH; i7++) {
            byte bL = c2795h.l(i7);
            if (bL >= 65 && bL <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c2795h.N());
            }
        }
        return c2795h;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f24985b.length);
        int i7 = 0;
        while (true) {
            C2781d[] c2781dArr = f24985b;
            if (i7 >= c2781dArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(c2781dArr[i7].f24976a)) {
                linkedHashMap.put(c2781dArr[i7].f24976a, Integer.valueOf(i7));
            }
            i7++;
        }
    }
}
