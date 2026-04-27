package r3;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: renamed from: r3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2674a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f22913b;

    public C2674a(String str, Map map) {
        this.f22912a = str;
        this.f22913b = map;
    }

    public static C2674a c(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map mapA = AbstractC2675b.a(str.substring(6));
            return new C2674a((String) mapA.get("token"), (Map) mapA.get("auth"));
        } catch (IOException e8) {
            throw new RuntimeException("Failed to parse gauth token", e8);
        }
    }

    public Map a() {
        return this.f22913b;
    }

    public String b() {
        return this.f22912a;
    }
}
