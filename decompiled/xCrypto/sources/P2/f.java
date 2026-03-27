package P2;

import O3.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final O3.g f3483a = O3.g.g(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d[] f3484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f3485c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final O3.f f3487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3489d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d[] f3490e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3491f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f3492g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3493h;

        public a(int i4, t tVar) {
            this(i4, i4, tVar);
        }

        public final void a() {
            int i4 = this.f3489d;
            int i5 = this.f3493h;
            if (i4 < i5) {
                if (i4 == 0) {
                    b();
                } else {
                    d(i5 - i4);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f3490e, (Object) null);
            this.f3491f = this.f3490e.length - 1;
            this.f3492g = 0;
            this.f3493h = 0;
        }

        public final int c(int i4) {
            return this.f3491f + 1 + i4;
        }

        public final int d(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f3490e.length;
                while (true) {
                    length--;
                    i5 = this.f3491f;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    int i7 = this.f3490e[length].f3477c;
                    i4 -= i7;
                    this.f3493h -= i7;
                    this.f3492g--;
                    i6++;
                }
                d[] dVarArr = this.f3490e;
                System.arraycopy(dVarArr, i5 + 1, dVarArr, i5 + 1 + i6, this.f3492g);
                this.f3491f += i6;
            }
            return i6;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f3486a);
            this.f3486a.clear();
            return arrayList;
        }

        public final O3.g f(int i4) throws IOException {
            if (i(i4)) {
                return f.f3484b[i4].f3475a;
            }
            int iC = c(i4 - f.f3484b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f3490e;
                if (iC < dVarArr.length) {
                    return dVarArr[iC].f3475a;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        public void g(int i4) {
            this.f3488c = i4;
            this.f3489d = i4;
            a();
        }

        public final void h(int i4, d dVar) {
            this.f3486a.add(dVar);
            int i5 = dVar.f3477c;
            if (i4 != -1) {
                i5 -= this.f3490e[c(i4)].f3477c;
            }
            int i6 = this.f3489d;
            if (i5 > i6) {
                b();
                return;
            }
            int iD = d((this.f3493h + i5) - i6);
            if (i4 == -1) {
                int i7 = this.f3492g + 1;
                d[] dVarArr = this.f3490e;
                if (i7 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f3491f = this.f3490e.length - 1;
                    this.f3490e = dVarArr2;
                }
                int i8 = this.f3491f;
                this.f3491f = i8 - 1;
                this.f3490e[i8] = dVar;
                this.f3492g++;
            } else {
                this.f3490e[i4 + c(i4) + iD] = dVar;
            }
            this.f3493h += i5;
        }

        public final boolean i(int i4) {
            return i4 >= 0 && i4 <= f.f3484b.length - 1;
        }

        public final int j() {
            return this.f3487b.readByte() & 255;
        }

        public O3.g k() {
            int iJ = j();
            boolean z4 = (iJ & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 128;
            int iN = n(iJ, 127);
            return z4 ? O3.g.q(h.f().c(this.f3487b.L(iN))) : this.f3487b.j(iN);
        }

        public void l() throws IOException {
            while (!this.f3487b.r()) {
                byte b4 = this.f3487b.readByte();
                int i4 = b4 & 255;
                if (i4 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b4 & 128) == 128) {
                    m(n(i4, 127) - 1);
                } else if (i4 == 64) {
                    p();
                } else if ((b4 & 64) == 64) {
                    o(n(i4, 63) - 1);
                } else if ((b4 & 32) == 32) {
                    int iN = n(i4, 31);
                    this.f3489d = iN;
                    if (iN < 0 || iN > this.f3488c) {
                        throw new IOException("Invalid dynamic table size update " + this.f3489d);
                    }
                    a();
                } else if (i4 == 16 || i4 == 0) {
                    r();
                } else {
                    q(n(i4, 15) - 1);
                }
            }
        }

        public final void m(int i4) throws IOException {
            if (i(i4)) {
                this.f3486a.add(f.f3484b[i4]);
                return;
            }
            int iC = c(i4 - f.f3484b.length);
            if (iC >= 0) {
                d[] dVarArr = this.f3490e;
                if (iC <= dVarArr.length - 1) {
                    this.f3486a.add(dVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        public int n(int i4, int i5) {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int iJ = j();
                if ((iJ & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
                    return i5 + (iJ << i7);
                }
                i5 += (iJ & 127) << i7;
                i7 += 7;
            }
        }

        public final void o(int i4) {
            h(-1, new d(f(i4), k()));
        }

        public final void p() {
            h(-1, new d(f.e(k()), k()));
        }

        public final void q(int i4) throws IOException {
            this.f3486a.add(new d(f(i4), k()));
        }

        public final void r() throws IOException {
            this.f3486a.add(new d(f.e(k()), k()));
        }

        public a(int i4, int i5, t tVar) {
            this.f3486a = new ArrayList();
            this.f3490e = new d[8];
            this.f3491f = r0.length - 1;
            this.f3492g = 0;
            this.f3493h = 0;
            this.f3488c = i4;
            this.f3489d = i5;
            this.f3487b = O3.i.b(tVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final O3.d f3494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3495b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3497d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3498e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3499f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d[] f3500g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f3501h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3502i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f3503j;

        public b(O3.d dVar) {
            this(4096, false, dVar);
        }

        public final void a() {
            Arrays.fill(this.f3500g, (Object) null);
            this.f3502i = this.f3500g.length - 1;
            this.f3501h = 0;
            this.f3503j = 0;
        }

        public final int b(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f3500g.length;
                while (true) {
                    length--;
                    i5 = this.f3502i;
                    if (length < i5 || i4 <= 0) {
                        break;
                    }
                    int i7 = this.f3500g[length].f3477c;
                    i4 -= i7;
                    this.f3503j -= i7;
                    this.f3501h--;
                    i6++;
                }
                d[] dVarArr = this.f3500g;
                System.arraycopy(dVarArr, i5 + 1, dVarArr, i5 + 1 + i6, this.f3501h);
                this.f3502i += i6;
            }
            return i6;
        }

        public final void c(d dVar) {
            int i4 = dVar.f3477c;
            int i5 = this.f3499f;
            if (i4 > i5) {
                a();
                return;
            }
            b((this.f3503j + i4) - i5);
            int i6 = this.f3501h + 1;
            d[] dVarArr = this.f3500g;
            if (i6 > dVarArr.length) {
                d[] dVarArr2 = new d[dVarArr.length * 2];
                System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                this.f3502i = this.f3500g.length - 1;
                this.f3500g = dVarArr2;
            }
            int i7 = this.f3502i;
            this.f3502i = i7 - 1;
            this.f3500g[i7] = dVar;
            this.f3501h++;
            this.f3503j += i4;
        }

        public void d(O3.g gVar) throws IOException {
            if (!this.f3495b || h.f().e(gVar.y()) >= gVar.v()) {
                f(gVar.v(), 127, 0);
                this.f3494a.m0(gVar);
                return;
            }
            O3.d dVar = new O3.d();
            h.f().d(gVar.y(), dVar.J());
            O3.g gVarP = dVar.P();
            f(gVarP.v(), 127, UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            this.f3494a.m0(gVarP);
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
            throw new UnsupportedOperationException("Method not decompiled: P2.f.b.e(java.util.List):void");
        }

        public void f(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.f3494a.s(i4 | i6);
                return;
            }
            this.f3494a.s(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.f3494a.s(128 | (i7 & 127));
                i7 >>>= 7;
            }
            this.f3494a.s(i7);
        }

        public b(int i4, boolean z4, O3.d dVar) {
            this.f3497d = Integer.MAX_VALUE;
            this.f3500g = new d[8];
            this.f3502i = r0.length - 1;
            this.f3496c = i4;
            this.f3499f = i4;
            this.f3495b = z4;
            this.f3494a = dVar;
        }
    }

    static {
        d dVar = new d(d.f3472h, "");
        O3.g gVar = d.f3469e;
        d dVar2 = new d(gVar, "GET");
        d dVar3 = new d(gVar, "POST");
        O3.g gVar2 = d.f3470f;
        d dVar4 = new d(gVar2, RemoteSettings.FORWARD_SLASH_STRING);
        d dVar5 = new d(gVar2, "/index.html");
        O3.g gVar3 = d.f3471g;
        d dVar6 = new d(gVar3, "http");
        d dVar7 = new d(gVar3, "https");
        O3.g gVar4 = d.f3468d;
        f3484b = new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, new d(gVar4, "200"), new d(gVar4, "204"), new d(gVar4, "206"), new d(gVar4, "304"), new d(gVar4, "400"), new d(gVar4, "404"), new d(gVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d(Constants.MessagePayloadKeys.FROM, ""), new d(DiagnosticsTracker.HOST_KEY, ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d(FirebaseAnalytics.Param.LOCATION, ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f3485c = f();
    }

    public static O3.g e(O3.g gVar) throws IOException {
        int iV = gVar.v();
        for (int i4 = 0; i4 < iV; i4++) {
            byte bH = gVar.h(i4);
            if (bH >= 65 && bH <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + gVar.z());
            }
        }
        return gVar;
    }

    public static Map f() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f3484b.length);
        int i4 = 0;
        while (true) {
            d[] dVarArr = f3484b;
            if (i4 >= dVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(dVarArr[i4].f3475a)) {
                linkedHashMap.put(dVarArr[i4].f3475a, Integer.valueOf(i4));
            }
            i4++;
        }
    }
}
