package wb;

import com.google.android.gms.common.api.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import hh.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hh.g f23832a = hh.g.c(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d[] f23833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f23834c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f23835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final hh.f f23836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f23838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d[] f23839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23840f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f23841g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f23842h;

        public a(int i10, t tVar) {
            this(i10, i10, tVar);
        }

        public final void a() {
            int i10 = this.f23838d;
            int i11 = this.f23842h;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    d(i11 - i10);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f23839e, (Object) null);
            this.f23840f = this.f23839e.length - 1;
            this.f23841g = 0;
            this.f23842h = 0;
        }

        public final int c(int i10) {
            return this.f23840f + 1 + i10;
        }

        public final int d(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f23839e.length;
                while (true) {
                    length--;
                    i11 = this.f23840f;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f23839e[length].f23826c;
                    i10 -= i13;
                    this.f23842h -= i13;
                    this.f23841g--;
                    i12++;
                }
                d[] dVarArr = this.f23839e;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f23841g);
                this.f23840f += i12;
            }
            return i12;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f23835a);
            this.f23835a.clear();
            return arrayList;
        }

        public final hh.g f(int i10) throws IOException {
            if (i(i10)) {
                return f.f23833b[i10].f23824a;
            }
            int iC = c(i10 - f.f23833b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f23839e;
                if (iC < dVarArr.length) {
                    return dVarArr[iC].f23824a;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public void g(int i10) {
            this.f23837c = i10;
            this.f23838d = i10;
            a();
        }

        public final void h(int i10, d dVar) {
            this.f23835a.add(dVar);
            int i11 = dVar.f23826c;
            if (i10 != -1) {
                i11 -= this.f23839e[c(i10)].f23826c;
            }
            int i12 = this.f23838d;
            if (i11 > i12) {
                b();
                return;
            }
            int iD = d((this.f23842h + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f23841g + 1;
                d[] dVarArr = this.f23839e;
                if (i13 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f23840f = this.f23839e.length - 1;
                    this.f23839e = dVarArr2;
                }
                int i14 = this.f23840f;
                this.f23840f = i14 - 1;
                this.f23839e[i14] = dVar;
                this.f23841g++;
            } else {
                this.f23839e[i10 + c(i10) + iD] = dVar;
            }
            this.f23842h += i11;
        }

        public final boolean i(int i10) {
            return i10 >= 0 && i10 <= f.f23833b.length - 1;
        }

        public final int j() {
            return this.f23836b.readByte() & 255;
        }

        public hh.g k() {
            int iJ = j();
            boolean z10 = (iJ & 128) == 128;
            int iN = n(iJ, 127);
            return z10 ? hh.g.u(h.f().c(this.f23836b.J(iN))) : this.f23836b.k(iN);
        }

        public void l() throws IOException {
            while (!this.f23836b.q()) {
                byte b10 = this.f23836b.readByte();
                int i10 = b10 & 255;
                if (i10 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b10 & 128) == 128) {
                    m(n(i10, 127) - 1);
                } else if (i10 == 64) {
                    p();
                } else if ((b10 & 64) == 64) {
                    o(n(i10, 63) - 1);
                } else if ((b10 & 32) == 32) {
                    int iN = n(i10, 31);
                    this.f23838d = iN;
                    if (iN < 0 || iN > this.f23837c) {
                        throw new IOException("Invalid dynamic table size update " + this.f23838d);
                    }
                    a();
                } else if (i10 == 16 || i10 == 0) {
                    r();
                } else {
                    q(n(i10, 15) - 1);
                }
            }
        }

        public final void m(int i10) throws IOException {
            if (i(i10)) {
                this.f23835a.add(f.f23833b[i10]);
                return;
            }
            int iC = c(i10 - f.f23833b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f23839e;
                if (iC <= dVarArr.length - 1) {
                    this.f23835a.add(dVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        public int n(int i10, int i11) {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & 128) == 0) {
                    return i11 + (iJ << i13);
                }
                i11 += (iJ & 127) << i13;
                i13 += 7;
            }
        }

        public final void o(int i10) {
            h(-1, new d(f(i10), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i10) throws IOException {
            this.f23835a.add(new d(f(i10), k()));
        }

        public final void r() throws IOException {
            this.f23835a.add(new d(f.e(k()), k()));
        }

        public a(int i10, int i11, t tVar) {
            this.f23835a = new ArrayList();
            this.f23839e = new d[8];
            this.f23840f = r0.length - 1;
            this.f23841g = 0;
            this.f23842h = 0;
            this.f23837c = i10;
            this.f23838d = i11;
            this.f23836b = hh.i.b(tVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hh.d f23843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f23846d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f23847e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23848f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d[] f23849g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f23850h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f23851i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f23852j;

        public b(hh.d dVar) {
            this(4096, false, dVar);
        }

        public final void a() {
            Arrays.fill(this.f23849g, (Object) null);
            this.f23851i = this.f23849g.length - 1;
            this.f23850h = 0;
            this.f23852j = 0;
        }

        public final int b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f23849g.length;
                while (true) {
                    length--;
                    i11 = this.f23851i;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    int i13 = this.f23849g[length].f23826c;
                    i10 -= i13;
                    this.f23852j -= i13;
                    this.f23850h--;
                    i12++;
                }
                d[] dVarArr = this.f23849g;
                System.arraycopy(dVarArr, i11 + 1, dVarArr, i11 + 1 + i12, this.f23850h);
                this.f23851i += i12;
            }
            return i12;
        }

        public final void c(d dVar) {
            int i10 = dVar.f23826c;
            int i11 = this.f23848f;
            if (i10 > i11) {
                a();
                return;
            }
            b((this.f23852j + i10) - i11);
            int i12 = this.f23850h + 1;
            d[] dVarArr = this.f23849g;
            if (i12 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f23851i = this.f23849g.length - 1;
                this.f23849g = dVarArr2;
            }
            int i13 = this.f23851i;
            this.f23851i = i13 - 1;
            this.f23849g[i13] = dVar;
            this.f23850h++;
            this.f23852j += i10;
        }

        public void d(hh.g gVar) throws IOException {
            if (!this.f23844b || h.f().e(gVar.H()) >= gVar.B()) {
                f(gVar.B(), 127, 0);
                this.f23843a.j0(gVar);
                return;
            }
            hh.d dVar = new hh.d();
            h.f().d(gVar.H(), dVar.N());
            hh.g gVarR = dVar.R();
            f(gVarR.B(), 127, 128);
            this.f23843a.j0(gVarR);
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
            throw new UnsupportedOperationException("Method not decompiled: wb.f.b.e(java.util.List):void");
        }

        public void f(int i10, int i11, int i12) {
            if (i10 < i11) {
                this.f23843a.writeByte(i10 | i12);
                return;
            }
            this.f23843a.writeByte(i12 | i11);
            int i13 = i10 - i11;
            while (i13 >= 128) {
                this.f23843a.writeByte(128 | (i13 & 127));
                i13 >>>= 7;
            }
            this.f23843a.writeByte(i13);
        }

        public b(int i10, boolean z10, hh.d dVar) {
            this.f23846d = a.e.API_PRIORITY_OTHER;
            this.f23849g = new d[8];
            this.f23851i = r0.length - 1;
            this.f23845c = i10;
            this.f23848f = i10;
            this.f23844b = z10;
            this.f23843a = dVar;
        }
    }

    static {
        d dVar = new d(d.f23821h, "");
        hh.g gVar = d.f23818e;
        d dVar2 = new d(gVar, "GET");
        d dVar3 = new d(gVar, "POST");
        hh.g gVar2 = d.f23819f;
        d dVar4 = new d(gVar2, "/");
        d dVar5 = new d(gVar2, "/index.html");
        hh.g gVar3 = d.f23820g;
        d dVar6 = new d(gVar3, "http");
        d dVar7 = new d(gVar3, "https");
        hh.g gVar4 = d.f23817d;
        f23833b = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, new d(gVar4, "200"), new d(gVar4, "204"), new d(gVar4, "206"), new d(gVar4, "304"), new d(gVar4, "400"), new d(gVar4, "404"), new d(gVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d(DiagnosticsTracker.HOST_KEY, ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d(FirebaseAnalytics.Param.LOCATION, ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f23834c = f();
    }

    public static hh.g e(hh.g gVar) throws IOException {
        int iB = gVar.B();
        for (int i10 = 0; i10 < iB; i10++) {
            byte bH = gVar.h(i10);
            if (bH >= 65 && bH <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + gVar.K());
            }
        }
        return gVar;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f23833b.length);
        int i10 = 0;
        while (true) {
            d[] dVarArr = f23833b;
            if (i10 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i10].f23824a)) {
                linkedHashMap.put(dVarArr[i10].f23824a, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
