package f3;

import android.os.Bundle;
import e3.C1478g;
import g3.InterfaceC1635a;
import g3.InterfaceC1636b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: f3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1604d implements InterfaceC1602b, InterfaceC1636b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC1635a f14117a;

    public static String c(String str, Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // g3.InterfaceC1636b
    public void a(InterfaceC1635a interfaceC1635a) {
        this.f14117a = interfaceC1635a;
        C1478g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // f3.InterfaceC1602b
    public void b(String str, Bundle bundle) {
        InterfaceC1635a interfaceC1635a = this.f14117a;
        if (interfaceC1635a != null) {
            try {
                interfaceC1635a.a("$A$:" + c(str, bundle));
            } catch (JSONException unused) {
                C1478g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
