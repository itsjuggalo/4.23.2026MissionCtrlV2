package z4;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import u5.AbstractC1245b;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u5.j f11796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1473b[] f11797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f11798c;

    static {
        u5.j jVar = u5.j.f10527d;
        f11796a = AbstractC1245b.e(":");
        C1473b c1473b = new C1473b(C1473b.f11785h, "");
        u5.j jVar2 = C1473b.e;
        C1473b c1473b2 = new C1473b(jVar2, "GET");
        C1473b c1473b3 = new C1473b(jVar2, "POST");
        u5.j jVar3 = C1473b.f11783f;
        C1473b c1473b4 = new C1473b(jVar3, "/");
        C1473b c1473b5 = new C1473b(jVar3, "/index.html");
        u5.j jVar4 = C1473b.f11784g;
        C1473b c1473b6 = new C1473b(jVar4, "http");
        C1473b c1473b7 = new C1473b(jVar4, "https");
        u5.j jVar5 = C1473b.f11782d;
        C1473b[] c1473bArr = {c1473b, c1473b2, c1473b3, c1473b4, c1473b5, c1473b6, c1473b7, new C1473b(jVar5, "200"), new C1473b(jVar5, "204"), new C1473b(jVar5, "206"), new C1473b(jVar5, "304"), new C1473b(jVar5, "400"), new C1473b(jVar5, "404"), new C1473b(jVar5, "500"), new C1473b("accept-charset", ""), new C1473b("accept-encoding", "gzip, deflate"), new C1473b("accept-language", ""), new C1473b("accept-ranges", ""), new C1473b("accept", ""), new C1473b("access-control-allow-origin", ""), new C1473b("age", ""), new C1473b("allow", ""), new C1473b("authorization", ""), new C1473b("cache-control", ""), new C1473b("content-disposition", ""), new C1473b("content-encoding", ""), new C1473b("content-language", ""), new C1473b("content-length", ""), new C1473b("content-location", ""), new C1473b("content-range", ""), new C1473b("content-type", ""), new C1473b("cookie", ""), new C1473b("date", ""), new C1473b("etag", ""), new C1473b("expect", ""), new C1473b("expires", ""), new C1473b("from", ""), new C1473b("host", ""), new C1473b("if-match", ""), new C1473b("if-modified-since", ""), new C1473b("if-none-match", ""), new C1473b("if-range", ""), new C1473b("if-unmodified-since", ""), new C1473b("last-modified", ""), new C1473b("link", ""), new C1473b("location", ""), new C1473b("max-forwards", ""), new C1473b("proxy-authenticate", ""), new C1473b("proxy-authorization", ""), new C1473b("range", ""), new C1473b("referer", ""), new C1473b("refresh", ""), new C1473b("retry-after", ""), new C1473b("server", ""), new C1473b("set-cookie", ""), new C1473b("strict-transport-security", ""), new C1473b("transfer-encoding", ""), new C1473b("user-agent", ""), new C1473b("vary", ""), new C1473b("via", ""), new C1473b("www-authenticate", "")};
        f11797b = c1473bArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i = 0; i < 61; i++) {
            if (!linkedHashMap.containsKey(c1473bArr[i].f11786a)) {
                linkedHashMap.put(c1473bArr[i].f11786a, Integer.valueOf(i));
            }
        }
        f11798c = Collections.unmodifiableMap(linkedHashMap);
    }

    public static void a(u5.j jVar) throws IOException {
        int iD = jVar.d();
        for (int i = 0; i < iD; i++) {
            byte bI = jVar.i(i);
            if (bI >= 65 && bI <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(jVar.s()));
            }
        }
    }
}
