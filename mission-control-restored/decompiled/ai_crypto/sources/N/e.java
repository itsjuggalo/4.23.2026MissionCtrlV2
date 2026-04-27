package N;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f3907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3908e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3909f;

    public e(String str, String str2, String str3, List list) {
        this.f3904a = (String) P.f.g(str);
        this.f3905b = (String) P.f.g(str2);
        this.f3906c = (String) P.f.g(str3);
        this.f3907d = (List) P.f.g(list);
        this.f3909f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f3907d;
    }

    public int c() {
        return this.f3908e;
    }

    public String d() {
        return this.f3909f;
    }

    public String e() {
        return this.f3904a;
    }

    public String f() {
        return this.f3905b;
    }

    public String g() {
        return this.f3906c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f3904a + ", mProviderPackage: " + this.f3905b + ", mQuery: " + this.f3906c + ", mCertificates:");
        for (int i7 = 0; i7 < this.f3907d.size(); i7++) {
            sb.append(" [");
            List list = (List) this.f3907d.get(i7);
            for (int i8 = 0; i8 < list.size(); i8++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i8), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f3908e);
        return sb.toString();
    }
}
