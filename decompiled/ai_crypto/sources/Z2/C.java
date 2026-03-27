package Z2;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f5706b;

    public C(String str, Map map) {
        this.f5705a = str;
        this.f5706b = map;
    }

    public long a() {
        return h("auth_time");
    }

    public Map b() {
        return this.f5706b;
    }

    public long c() {
        return h("exp");
    }

    public long d() {
        return h("iat");
    }

    public String e() {
        Map map = (Map) this.f5706b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String f() {
        Map map = (Map) this.f5706b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    public String g() {
        return this.f5705a;
    }

    public final long h(String str) {
        Integer num = (Integer) this.f5706b.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }
}
