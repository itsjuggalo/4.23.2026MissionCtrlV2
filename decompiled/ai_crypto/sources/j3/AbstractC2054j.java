package j3;

import k3.AbstractC2074F;
import org.json.JSONObject;
import v3.InterfaceC2765a;
import x3.C2823d;

/* JADX INFO: renamed from: j3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2054j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InterfaceC2765a f17419a = new C2823d().j(C2045a.f17370a).i();

    public static AbstractC2054j a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static AbstractC2054j b(String str, String str2, String str3, String str4, long j7) {
        return new C2046b(str, str2, i(str3), str4, j7);
    }

    public static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public AbstractC2074F.e.d.AbstractC0285e h() {
        return AbstractC2074F.e.d.AbstractC0285e.a().d(AbstractC2074F.e.d.AbstractC0285e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
