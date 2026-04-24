package U2;

import V2.F;
import org.json.JSONObject;
import w3.InterfaceC2922a;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2922a f8141a = new y3.d().j(a.f8092a).i();

    public static j a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static j b(String str, String str2, String str3, String str4, long j8) {
        return new b(str, str2, i(str3), str4, j8);
    }

    public static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public F.e.d.AbstractC0138e h() {
        return F.e.d.AbstractC0138e.a().d(F.e.d.AbstractC0138e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
