package Q;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f6610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6611e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f6612f;

    public e(String str, String str2, String str3, List list) {
        this.f6607a = (String) S.g.d(str);
        this.f6608b = (String) S.g.d(str2);
        this.f6609c = (String) S.g.d(str3);
        this.f6610d = (List) S.g.d(list);
        this.f6612f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f6610d;
    }

    public int c() {
        return this.f6611e;
    }

    public String d() {
        return this.f6612f;
    }

    public String e() {
        return this.f6607a;
    }

    public String f() {
        return this.f6608b;
    }

    public String g() {
        return this.f6609c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f6607a + ", mProviderPackage: " + this.f6608b + ", mQuery: " + this.f6609c + ", mCertificates:");
        for (int i8 = 0; i8 < this.f6610d.size(); i8++) {
            sb.append(" [");
            List list = (List) this.f6610d.get(i8);
            for (int i9 = 0; i9 < list.size(); i9++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i9), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f6611e);
        return sb.toString();
    }
}
