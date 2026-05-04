package m7;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f15968b;

    public c0(String str, Map map) {
        this.f15967a = str;
        this.f15968b = map;
    }

    public long a() {
        return h("auth_time");
    }

    public Map b() {
        return this.f15968b;
    }

    public long c() {
        return h("exp");
    }

    public long d() {
        return h("iat");
    }

    public String e() {
        Map map = (Map) this.f15968b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    public String f() {
        Map map = (Map) this.f15968b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    public String g() {
        return this.f15967a;
    }

    public final long h(String str) {
        Integer num = (Integer) this.f15968b.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }
}
