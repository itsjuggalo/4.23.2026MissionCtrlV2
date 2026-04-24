package J4;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import u7.C2811d;
import u7.C2814g;
import u7.H;
import u7.InterfaceC2813f;
import u7.V;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2814g f4587a = C2814g.g(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d[] f4588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f4589c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f4590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2813f f4591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d[] f4594e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4597h;

        public a(int i8, int i9, V v8) {
            this.f4590a = new ArrayList();
            this.f4594e = new d[8];
            this.f4595f = r0.length - 1;
            this.f4596g = 0;
            this.f4597h = 0;
            this.f4592c = i8;
            this.f4593d = i9;
            this.f4591b = H.b(v8);
        }

        public final void a() {
            int i8 = this.f4593d;
            int i9 = this.f4597h;
            if (i8 < i9) {
                if (i8 == 0) {
                    b();
                } else {
                    d(i9 - i8);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f4594e, (Object) null);
            this.f4595f = this.f4594e.length - 1;
            this.f4596g = 0;
            this.f4597h = 0;
        }

        public final int c(int i8) {
            return this.f4595f + 1 + i8;
        }

        public final int d(int i8) {
            int i9;
            int i10 = 0;
            if (i8 > 0) {
                int length = this.f4594e.length;
                while (true) {
                    length--;
                    i9 = this.f4595f;
                    if (length < i9 || i8 <= 0) {
                        break;
                    }
                    int i11 = this.f4594e[length].f4581c;
                    i8 -= i11;
                    this.f4597h -= i11;
                    this.f4596g--;
                    i10++;
                }
                d[] dVarArr = this.f4594e;
                System.arraycopy(dVarArr, i9 + 1, dVarArr, i9 + 1 + i10, this.f4596g);
                this.f4595f += i10;
            }
            return i10;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f4590a);
            this.f4590a.clear();
            return arrayList;
        }

        public final C2814g f(int i8) throws IOException {
            d dVar;
            if (!i(i8)) {
                int iC = c(i8 - f.f4588b.length);
                if (iC >= 0) {
                    d[] dVarArr = this.f4594e;
                    if (iC < dVarArr.length) {
                        dVar = dVarArr[iC];
                    }
                }
                throw new IOException("Header index too large " + (i8 + 1));
            }
            dVar = f.f4588b[i8];
            return dVar.f4579a;
        }

        public void g(int i8) {
            this.f4592c = i8;
            this.f4593d = i8;
            a();
        }

        public final void h(int i8, d dVar) {
            this.f4590a.add(dVar);
            int i9 = dVar.f4581c;
            if (i8 != -1) {
                i9 -= this.f4594e[c(i8)].f4581c;
            }
            int i10 = this.f4593d;
            if (i9 > i10) {
                b();
                return;
            }
            int iD = d((this.f4597h + i9) - i10);
            if (i8 == -1) {
                int i11 = this.f4596g + 1;
                d[] dVarArr = this.f4594e;
                if (i11 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f4595f = this.f4594e.length - 1;
                    this.f4594e = dVarArr2;
                }
                int i12 = this.f4595f;
                this.f4595f = i12 - 1;
                this.f4594e[i12] = dVar;
                this.f4596g++;
            } else {
                this.f4594e[i8 + c(i8) + iD] = dVar;
            }
            this.f4597h += i9;
        }

        public final boolean i(int i8) {
            return i8 >= 0 && i8 <= f.f4588b.length - 1;
        }

        public final int j() {
            return this.f4591b.readByte() & 255;
        }

        public C2814g k() {
            int iJ = j();
            boolean z7 = (iJ & 128) == 128;
            int iN = n(iJ, 127);
            return z7 ? C2814g.M(h.f().c(this.f4591b.Y(iN))) : this.f4591b.p(iN);
        }

        public void l() throws IOException {
            while (!this.f4591b.w()) {
                byte b8 = this.f4591b.readByte();
                int i8 = b8 & 255;
                if (i8 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b8 & 128) == 128) {
                    m(n(i8, 127) - 1);
                } else if (i8 == 64) {
                    p();
                } else if ((b8 & 64) == 64) {
                    o(n(i8, 63) - 1);
                } else if ((b8 & 32) == 32) {
                    int iN = n(i8, 31);
                    this.f4593d = iN;
                    if (iN < 0 || iN > this.f4592c) {
                        throw new IOException("Invalid dynamic table size update " + this.f4593d);
                    }
                    a();
                } else if (i8 == 16 || i8 == 0) {
                    r();
                } else {
                    q(n(i8, 15) - 1);
                }
            }
        }

        public final void m(int i8) throws IOException {
            if (i(i8)) {
                this.f4590a.add(f.f4588b[i8]);
                return;
            }
            int iC = c(i8 - f.f4588b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f4594e;
                if (iC <= dVarArr.length - 1) {
                    this.f4590a.add(dVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i8 + 1));
        }

        public int n(int i8, int i9) {
            int i10 = i8 & i9;
            if (i10 < i9) {
                return i10;
            }
            int i11 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i9 + (iJ << i11);
                }
                i9 += (iJ & 127) << i11;
                i11 += 7;
            }
        }

        public final void o(int i8) {
            h(-1, new d(f(i8), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i8) throws IOException {
            this.f4590a.add(new d(f(i8), k()));
        }

        public final void r() throws IOException {
            this.f4590a.add(new d(f.e(k()), k()));
        }

        public a(int i8, V v8) {
            this(i8, i8, v8);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2811d f4598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4600c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4601d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4602e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4603f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d[] f4604g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4605h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4606i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4607j;

        public b(int i8, boolean z7, C2811d c2811d) {
            this.f4601d = Integer.MAX_VALUE;
            this.f4604g = new d[8];
            this.f4606i = r0.length - 1;
            this.f4600c = i8;
            this.f4603f = i8;
            this.f4599b = z7;
            this.f4598a = c2811d;
        }

        public final void a() {
            Arrays.fill(this.f4604g, (Object) null);
            this.f4606i = this.f4604g.length - 1;
            this.f4605h = 0;
            this.f4607j = 0;
        }

        public final int b(int i8) {
            int i9;
            int i10 = 0;
            if (i8 > 0) {
                int length = this.f4604g.length;
                while (true) {
                    length--;
                    i9 = this.f4606i;
                    if (length < i9 || i8 <= 0) {
                        break;
                    }
                    int i11 = this.f4604g[length].f4581c;
                    i8 -= i11;
                    this.f4607j -= i11;
                    this.f4605h--;
                    i10++;
                }
                d[] dVarArr = this.f4604g;
                System.arraycopy(dVarArr, i9 + 1, dVarArr, i9 + 1 + i10, this.f4605h);
                this.f4606i += i10;
            }
            return i10;
        }

        public final void c(d dVar) {
            int i8 = dVar.f4581c;
            int i9 = this.f4603f;
            if (i8 > i9) {
                a();
                return;
            }
            b((this.f4607j + i8) - i9);
            int i10 = this.f4605h + 1;
            d[] dVarArr = this.f4604g;
            if (i10 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f4606i = this.f4604g.length - 1;
                this.f4604g = dVarArr2;
            }
            int i11 = this.f4606i;
            this.f4606i = i11 - 1;
            this.f4604g[i11] = dVar;
            this.f4605h++;
            this.f4607j += i8;
        }

        public void d(C2814g c2814g) throws IOException {
            int iR;
            int i8;
            if (!this.f4599b || h.f().e(c2814g.W()) >= c2814g.R()) {
                iR = c2814g.R();
                i8 = 0;
            } else {
                C2811d c2811d = new C2811d();
                h.f().d(c2814g.W(), c2811d.q0());
                c2814g = c2811d.T();
                iR = c2814g.R();
                i8 = 128;
            }
            f(iR, 127, i8);
            this.f4598a.y0(c2814g);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e(java.util.List r14) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: J4.f.b.e(java.util.List):void");
        }

        public void f(int i8, int i9, int i10) {
            int i11;
            C2811d c2811d;
            if (i8 < i9) {
                c2811d = this.f4598a;
                i11 = i8 | i10;
            } else {
                this.f4598a.x(i10 | i9);
                i11 = i8 - i9;
                while (i11 >= 128) {
                    this.f4598a.x(128 | (i11 & 127));
                    i11 >>>= 7;
                }
                c2811d = this.f4598a;
            }
            c2811d.x(i11);
        }

        public b(C2811d c2811d) {
            this(4096, false, c2811d);
        }
    }

    static {
        d dVar = new d(d.f4576h, "");
        C2814g c2814g = d.f4573e;
        d dVar2 = new d(c2814g, "GET");
        d dVar3 = new d(c2814g, "POST");
        C2814g c2814g2 = d.f4574f;
        d dVar4 = new d(c2814g2, "/");
        d dVar5 = new d(c2814g2, "/index.html");
        C2814g c2814g3 = d.f4575g;
        d dVar6 = new d(c2814g3, "http");
        d dVar7 = new d(c2814g3, "https");
        C2814g c2814g4 = d.f4572d;
        f4588b = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, new d(c2814g4, "200"), new d(c2814g4, "204"), new d(c2814g4, "206"), new d(c2814g4, "304"), new d(c2814g4, "400"), new d(c2814g4, "404"), new d(c2814g4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d(DiagnosticsTracker.HOST_KEY, ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d(FirebaseAnalytics.Param.LOCATION, ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f4589c = f();
    }

    public static C2814g e(C2814g c2814g) throws IOException {
        int iR = c2814g.R();
        for (int i8 = 0; i8 < iR; i8++) {
            byte bK = c2814g.k(i8);
            if (bK >= 65 && bK <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c2814g.X());
            }
        }
        return c2814g;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f4588b.length);
        int i8 = 0;
        while (true) {
            d[] dVarArr = f4588b;
            if (i8 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i8].f4579a)) {
                linkedHashMap.put(dVarArr[i8].f4579a, Integer.valueOf(i8));
            }
            i8++;
        }
    }
}
