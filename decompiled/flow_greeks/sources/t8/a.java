package t8;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f20836b;

    public a(String str, Map map) {
        this.f20835a = str;
        this.f20836b = map;
    }

    public static a c(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map mapA = b.a(str.substring(6));
            return new a((String) mapA.get("token"), (Map) mapA.get("auth"));
        } catch (IOException e10) {
            throw new RuntimeException("Failed to parse gauth token", e10);
        }
    }

    public Map a() {
        return this.f20836b;
    }

    public String b() {
        return this.f20835a;
    }
}
