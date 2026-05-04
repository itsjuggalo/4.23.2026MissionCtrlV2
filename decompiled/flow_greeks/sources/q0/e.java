package q0;

import android.util.Base64;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f18718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f18719e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18720f;

    public e(String str, String str2, String str3, List list) {
        this.f18715a = (String) s0.f.d(str);
        this.f18716b = (String) s0.f.d(str2);
        this.f18717c = (String) s0.f.d(str3);
        this.f18718d = (List) s0.f.d(list);
        this.f18720f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f18718d;
    }

    public int c() {
        return this.f18719e;
    }

    public String d() {
        return this.f18720f;
    }

    public String e() {
        return this.f18715a;
    }

    public String f() {
        return this.f18716b;
    }

    public String g() {
        return this.f18717c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f18715a + ", mProviderPackage: " + this.f18716b + ", mQuery: " + this.f18717c + ", mCertificates:");
        for (int i10 = 0; i10 < this.f18718d.size(); i10++) {
            sb2.append(" [");
            List list = (List) this.f18718d.get(i10);
            for (int i11 = 0; i11 < list.size(); i11++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString((byte[]) list.get(i11), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f18719e);
        return sb2.toString();
    }
}
