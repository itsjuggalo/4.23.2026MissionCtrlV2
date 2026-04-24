package f4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final JSONObject f14143m;

    public k(e4.h hVar, Q2.g gVar, JSONObject jSONObject) {
        super(hVar, gVar);
        this.f14143m = jSONObject;
        G("X-HTTP-Method-Override", "PATCH");
    }

    @Override // f4.e
    public String e() {
        return "PUT";
    }

    @Override // f4.e
    public JSONObject g() {
        return this.f14143m;
    }
}
