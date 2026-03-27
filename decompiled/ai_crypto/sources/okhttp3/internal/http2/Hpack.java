package okhttp3.internal.http2;

import com.google.android.gms.common.api.a;
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

/* JADX INFO: loaded from: classes2.dex */
final class Hpack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Header[] f20901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f20902b;

    public static final class Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f20903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2794g f20904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f20905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20906d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Header[] f20907e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f20908f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f20909g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20910h;

        public Reader(int i7, Z z7) {
            this(i7, i7, z7);
        }

        public final void a() {
            int i7 = this.f20906d;
            int i8 = this.f20910h;
            if (i7 < i8) {
                if (i7 == 0) {
                    b();
                } else {
                    d(i8 - i7);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f20907e, (Object) null);
            this.f20908f = this.f20907e.length - 1;
            this.f20909g = 0;
            this.f20910h = 0;
        }

        public final int c(int i7) {
            return this.f20908f + 1 + i7;
        }

        public final int d(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f20907e.length;
                while (true) {
                    length--;
                    i8 = this.f20908f;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f20907e[length].f20900c;
                    i7 -= i10;
                    this.f20910h -= i10;
                    this.f20909g--;
                    i9++;
                }
                Header[] headerArr = this.f20907e;
                System.arraycopy(headerArr, i8 + 1, headerArr, i8 + 1 + i9, this.f20909g);
                this.f20908f += i9;
            }
            return i9;
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f20903a);
            this.f20903a.clear();
            return arrayList;
        }

        public final C2795h f(int i7) throws IOException {
            if (h(i7)) {
                return Hpack.f20901a[i7].f20898a;
            }
            int iC = c(i7 - Hpack.f20901a.length);
            if (iC >= 0) {
                Header[] headerArr = this.f20907e;
                if (iC < headerArr.length) {
                    return headerArr[iC].f20898a;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        public final void g(int i7, Header header) {
            this.f20903a.add(header);
            int i8 = header.f20900c;
            if (i7 != -1) {
                i8 -= this.f20907e[c(i7)].f20900c;
            }
            int i9 = this.f20906d;
            if (i8 > i9) {
                b();
                return;
            }
            int iD = d((this.f20910h + i8) - i9);
            if (i7 == -1) {
                int i10 = this.f20909g + 1;
                Header[] headerArr = this.f20907e;
                if (i10 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f20908f = this.f20907e.length - 1;
                    this.f20907e = headerArr2;
                }
                int i11 = this.f20908f;
                this.f20908f = i11 - 1;
                this.f20907e[i11] = header;
                this.f20909g++;
            } else {
                this.f20907e[i7 + c(i7) + iD] = header;
            }
            this.f20910h += i8;
        }

        public final boolean h(int i7) {
            return i7 >= 0 && i7 <= Hpack.f20901a.length - 1;
        }

        public final int i() {
            return this.f20904b.readByte() & 255;
        }

        public C2795h j() {
            int i7 = i();
            boolean z7 = (i7 & 128) == 128;
            int iM = m(i7, 127);
            return z7 ? C2795h.A(Huffman.f().c(this.f20904b.Y(iM))) : this.f20904b.o(iM);
        }

        public void k() throws IOException {
            while (!this.f20904b.u()) {
                byte b7 = this.f20904b.readByte();
                int i7 = b7 & 255;
                if (i7 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b7 & 128) == 128) {
                    l(m(i7, 127) - 1);
                } else if (i7 == 64) {
                    o();
                } else if ((b7 & 64) == 64) {
                    n(m(i7, 63) - 1);
                } else if ((b7 & 32) == 32) {
                    int iM = m(i7, 31);
                    this.f20906d = iM;
                    if (iM < 0 || iM > this.f20905c) {
                        throw new IOException("Invalid dynamic table size update " + this.f20906d);
                    }
                    a();
                } else if (i7 == 16 || i7 == 0) {
                    q();
                } else {
                    p(m(i7, 15) - 1);
                }
            }
        }

        public final void l(int i7) throws IOException {
            if (h(i7)) {
                this.f20903a.add(Hpack.f20901a[i7]);
                return;
            }
            int iC = c(i7 - Hpack.f20901a.length);
            if (iC >= 0) {
                Header[] headerArr = this.f20907e;
                if (iC < headerArr.length) {
                    this.f20903a.add(headerArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i7 + 1));
        }

        public int m(int i7, int i8) {
            int i9 = i7 & i8;
            if (i9 < i8) {
                return i9;
            }
            int i10 = 0;
            while (true) {
                int i11 = i();
                if ((i11 & 128) == 0) {
                    return i8 + (i11 << i10);
                }
                i8 += (i11 & 127) << i10;
                i10 += 7;
            }
        }

        public final void n(int i7) {
            g(-1, new Header(f(i7), j()));
        }

        public final void o() {
            g(-1, new Header(Hpack.a(j()), j()));
        }

        public final void p(int i7) throws IOException {
            this.f20903a.add(new Header(f(i7), j()));
        }

        public final void q() throws IOException {
            this.f20903a.add(new Header(Hpack.a(j()), j()));
        }

        public Reader(int i7, int i8, Z z7) {
            this.f20903a = new ArrayList();
            this.f20907e = new Header[8];
            this.f20908f = r0.length - 1;
            this.f20909g = 0;
            this.f20910h = 0;
            this.f20905c = i7;
            this.f20906d = i8;
            this.f20904b = L.d(z7);
        }
    }

    public static final class Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2792e f20911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f20912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f20914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f20916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Header[] f20917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f20919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f20920j;

        public Writer(C2792e c2792e) {
            this(4096, true, c2792e);
        }

        public final void a() {
            int i7 = this.f20916f;
            int i8 = this.f20920j;
            if (i7 < i8) {
                if (i7 == 0) {
                    b();
                } else {
                    c(i8 - i7);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f20917g, (Object) null);
            this.f20918h = this.f20917g.length - 1;
            this.f20919i = 0;
            this.f20920j = 0;
        }

        public final int c(int i7) {
            int i8;
            int i9 = 0;
            if (i7 > 0) {
                int length = this.f20917g.length;
                while (true) {
                    length--;
                    i8 = this.f20918h;
                    if (length < i8 || i7 <= 0) {
                        break;
                    }
                    int i10 = this.f20917g[length].f20900c;
                    i7 -= i10;
                    this.f20920j -= i10;
                    this.f20919i--;
                    i9++;
                }
                Header[] headerArr = this.f20917g;
                System.arraycopy(headerArr, i8 + 1, headerArr, i8 + 1 + i9, this.f20919i);
                Header[] headerArr2 = this.f20917g;
                int i11 = this.f20918h;
                Arrays.fill(headerArr2, i11 + 1, i11 + 1 + i9, (Object) null);
                this.f20918h += i9;
            }
            return i9;
        }

        public final void d(Header header) {
            int i7 = header.f20900c;
            int i8 = this.f20916f;
            if (i7 > i8) {
                b();
                return;
            }
            c((this.f20920j + i7) - i8);
            int i9 = this.f20919i + 1;
            Header[] headerArr = this.f20917g;
            if (i9 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f20918h = this.f20917g.length - 1;
                this.f20917g = headerArr2;
            }
            int i10 = this.f20918h;
            this.f20918h = i10 - 1;
            this.f20917g[i10] = header;
            this.f20919i++;
            this.f20920j += i7;
        }

        public void e(int i7) {
            this.f20915e = i7;
            int iMin = Math.min(i7, 16384);
            int i8 = this.f20916f;
            if (i8 == iMin) {
                return;
            }
            if (iMin < i8) {
                this.f20913c = Math.min(this.f20913c, iMin);
            }
            this.f20914d = true;
            this.f20916f = iMin;
            a();
        }

        public void f(C2795h c2795h) {
            if (!this.f20912b || Huffman.f().e(c2795h) >= c2795h.H()) {
                h(c2795h.H(), 127, 0);
                this.f20911a.m(c2795h);
                return;
            }
            C2792e c2792e = new C2792e();
            Huffman.f().d(c2795h, c2792e);
            C2795h c2795hA0 = c2792e.A0();
            h(c2795hA0.H(), 127, 128);
            this.f20911a.m(c2795hA0);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void g(java.util.List r14) {
            /*
                Method dump skipped, instruction units count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.g(java.util.List):void");
        }

        public void h(int i7, int i8, int i9) {
            if (i7 < i8) {
                this.f20911a.v(i7 | i9);
                return;
            }
            this.f20911a.v(i9 | i8);
            int i10 = i7 - i8;
            while (i10 >= 128) {
                this.f20911a.v(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.f20911a.v(i10);
        }

        public Writer(int i7, boolean z7, C2792e c2792e) {
            this.f20913c = a.e.API_PRIORITY_OTHER;
            this.f20917g = new Header[8];
            this.f20918h = r0.length - 1;
            this.f20919i = 0;
            this.f20920j = 0;
            this.f20915e = i7;
            this.f20916f = i7;
            this.f20912b = z7;
            this.f20911a = c2792e;
        }
    }

    static {
        Header header = new Header(Header.f20897i, "");
        C2795h c2795h = Header.f20894f;
        Header header2 = new Header(c2795h, "GET");
        Header header3 = new Header(c2795h, "POST");
        C2795h c2795h2 = Header.f20895g;
        Header header4 = new Header(c2795h2, "/");
        Header header5 = new Header(c2795h2, "/index.html");
        C2795h c2795h3 = Header.f20896h;
        Header header6 = new Header(c2795h3, "http");
        Header header7 = new Header(c2795h3, "https");
        C2795h c2795h4 = Header.f20893e;
        f20901a = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(c2795h4, "200"), new Header(c2795h4, "204"), new Header(c2795h4, "206"), new Header(c2795h4, "304"), new Header(c2795h4, "400"), new Header(c2795h4, "404"), new Header(c2795h4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(DiagnosticsTracker.HOST_KEY, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f20902b = b();
    }

    private Hpack() {
    }

    public static C2795h a(C2795h c2795h) throws IOException {
        int iH = c2795h.H();
        for (int i7 = 0; i7 < iH; i7++) {
            byte bL = c2795h.l(i7);
            if (bL >= 65 && bL <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + c2795h.N());
            }
        }
        return c2795h;
    }

    public static Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f20901a.length);
        int i7 = 0;
        while (true) {
            Header[] headerArr = f20901a;
            if (i7 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i7].f20898a)) {
                linkedHashMap.put(headerArr[i7].f20898a, Integer.valueOf(i7));
            }
            i7++;
        }
    }
}
