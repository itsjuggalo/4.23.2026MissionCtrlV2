package com.amazon.device.simplesignin.a.a.b;

import android.app.Activity;
import android.content.Intent;
import com.amazon.a.a.n.b.d;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14596d = "SSI_LinkUserAccount";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f14597e = "1.0";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14598f = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b f14599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a f14600c;

    public b(a aVar, LinkUserAccountRequest linkUserAccountRequest) {
        super(aVar, f14596d, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.f14567d, linkUserAccountRequest.getPartnerUserId());
        super.a(com.amazon.device.simplesignin.a.a.a.f14564a, linkUserAccountRequest.getIdentityProviderName());
        super.a(com.amazon.device.simplesignin.a.a.a.f14568e, linkUserAccountRequest.getUserLoginName());
        super.a(com.amazon.device.simplesignin.a.a.a.f14571h, com.amazon.device.simplesignin.a.a.a.f14572i);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", linkUserAccountRequest.getLinkToken().getToken());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.f14556E, linkUserAccountRequest.getLinkToken().getSchema());
            super.a(com.amazon.device.simplesignin.a.a.a.f14570g, jSONObject.toString());
            super.a(com.amazon.device.simplesignin.a.a.a.f14569f, linkUserAccountRequest.getLinkSigningKey());
        } catch (JSONException e8) {
            com.amazon.device.simplesignin.a.d.a.b(f14598f, "Unable to create linkToken json");
            throw new IllegalStateException("Unable to create linkToken json", e8);
        }
    }

    private void a(final Intent intent) {
        this.f14599b.b(d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.simplesignin.a.a.b.b.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity activityB = b.this.f14600c.b();
                    if (activityB == null) {
                        activityB = b.this.f14600c.a();
                    }
                    com.amazon.device.simplesignin.a.d.a.a(b.f14598f, "Consent activity is about to start: " + activityB);
                    activityB.startActivity(intent);
                } catch (Exception e8) {
                    com.amazon.device.simplesignin.a.d.a.a(b.f14598f, "Exception when starting consent activity: " + e8);
                }
            }
        });
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        if (!mapB.containsKey(com.amazon.device.simplesignin.a.a.a.f14573j) || mapB.get(com.amazon.device.simplesignin.a.a.a.f14573j) == null) {
            return super.a(mapB);
        }
        a((Intent) mapB.get(com.amazon.device.simplesignin.a.a.a.f14573j));
        return true;
    }
}
