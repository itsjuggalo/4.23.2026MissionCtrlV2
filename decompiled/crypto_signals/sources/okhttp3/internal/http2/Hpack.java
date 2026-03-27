package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
final class Hpack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Header[] f8861a;

    public static final class Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Header[] f8863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8865d;
        public int e;

        public final int a(int i) {
            int i6;
            int i7 = 0;
            if (i > 0) {
                int length = this.f8863b.length;
                while (true) {
                    length--;
                    i6 = this.f8864c;
                    if (length < i6 || i <= 0) {
                        break;
                    }
                    int i8 = this.f8863b[length].f8860c;
                    i -= i8;
                    this.e -= i8;
                    this.f8865d--;
                    i7++;
                }
                Header[] headerArr = this.f8863b;
                System.arraycopy(headerArr, i6 + 1, headerArr, i6 + 1 + i7, this.f8865d);
                this.f8864c += i7;
            }
            return i7;
        }

        public final j b(int i) throws IOException {
            if (i >= 0) {
                Header[] headerArr = Hpack.f8861a;
                if (i <= headerArr.length - 1) {
                    return headerArr[i].f8858a;
                }
            }
            int length = this.f8864c + 1 + (i - Hpack.f8861a.length);
            if (length >= 0) {
                Header[] headerArr2 = this.f8863b;
                if (length < headerArr2.length) {
                    return headerArr2[length].f8858a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        public final void c(Header header) {
            throw null;
        }

        public final j d() {
            throw null;
        }

        public final int e(int i, int i6) {
            int i7 = i & i6;
            if (i7 < i6) {
                return i7;
            }
            throw null;
        }
    }

    public static final class Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8869d;
        public int e;

        public final void a(int i) {
            if (i > 0) {
                throw null;
            }
        }
    }

    static {
        Header header = new Header(Header.f8857h, "");
        j jVar = Header.e;
        Header header2 = new Header(jVar, "GET");
        Header header3 = new Header(jVar, "POST");
        j jVar2 = Header.f8855f;
        Header header4 = new Header(jVar2, "/");
        Header header5 = new Header(jVar2, "/index.html");
        j jVar3 = Header.f8856g;
        Header header6 = new Header(jVar3, "http");
        Header header7 = new Header(jVar3, "https");
        j jVar4 = Header.f8854d;
        Header[] headerArr = {header, header2, header3, header4, header5, header6, header7, new Header(jVar4, "200"), new Header(jVar4, "204"), new Header(jVar4, "206"), new Header(jVar4, "304"), new Header(jVar4, "400"), new Header(jVar4, "404"), new Header(jVar4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f8861a = headerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        for (int i = 0; i < headerArr.length; i++) {
            if (!linkedHashMap.containsKey(headerArr[i].f8858a)) {
                linkedHashMap.put(headerArr[i].f8858a, Integer.valueOf(i));
            }
        }
        Collections.unmodifiableMap(linkedHashMap);
    }

    private Hpack() {
    }

    public static void a(j jVar) throws IOException {
        int iD = jVar.d();
        for (int i = 0; i < iD; i++) {
            byte bI = jVar.i(i);
            if (bI >= 65 && bI <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(jVar.s()));
            }
        }
    }
}
