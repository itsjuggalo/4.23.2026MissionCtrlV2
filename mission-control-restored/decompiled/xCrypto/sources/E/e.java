package E;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f342e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f343f;

    public e(String str, String str2, String str3, List list) {
        this.f338a = (String) G.e.b(str);
        this.f339b = (String) G.e.b(str2);
        this.f340c = (String) G.e.b(str3);
        this.f341d = (List) G.e.b(list);
        this.f343f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f341d;
    }

    public int c() {
        return this.f342e;
    }

    public String d() {
        return this.f343f;
    }

    public String e() {
        return this.f338a;
    }

    public String f() {
        return this.f339b;
    }

    public String g() {
        return this.f340c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f338a + ", mProviderPackage: " + this.f339b + ", mQuery: " + this.f340c + ", mCertificates:");
        for (int i4 = 0; i4 < this.f341d.size(); i4++) {
            sb.append(" [");
            List list = (List) this.f341d.get(i4);
            for (int i5 = 0; i5 < list.size(); i5++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i5), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f342e);
        return sb.toString();
    }
}
