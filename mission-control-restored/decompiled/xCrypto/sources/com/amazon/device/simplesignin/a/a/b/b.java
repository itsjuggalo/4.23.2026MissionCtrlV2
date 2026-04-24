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
    private static final String f9300d = "SSI_LinkUserAccount";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f9301e = "1.0";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9302f = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.n.b f9303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.amazon.a.a.k.a
    protected com.amazon.a.a.a.a f9304c;

    public b(a aVar, LinkUserAccountRequest linkUserAccountRequest) {
        super(aVar, f9300d, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.f9271d, linkUserAccountRequest.getPartnerUserId());
        super.a(com.amazon.device.simplesignin.a.a.a.f9268a, linkUserAccountRequest.getIdentityProviderName());
        super.a(com.amazon.device.simplesignin.a.a.a.f9272e, linkUserAccountRequest.getUserLoginName());
        super.a(com.amazon.device.simplesignin.a.a.a.f9275h, com.amazon.device.simplesignin.a.a.a.f9276i);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", linkUserAccountRequest.getLinkToken().getToken());
            jSONObject.put(com.amazon.device.simplesignin.a.a.a.f9260E, linkUserAccountRequest.getLinkToken().getSchema());
            super.a(com.amazon.device.simplesignin.a.a.a.f9274g, jSONObject.toString());
            super.a(com.amazon.device.simplesignin.a.a.a.f9273f, linkUserAccountRequest.getLinkSigningKey());
        } catch (JSONException e4) {
            com.amazon.device.simplesignin.a.d.a.b(f9302f, "Unable to create linkToken json");
            throw new IllegalStateException("Unable to create linkToken json", e4);
        }
    }

    private void a(final Intent intent) {
        this.f9303b.b(d.FOREGROUND, new com.amazon.a.a.n.a() { // from class: com.amazon.device.simplesignin.a.a.b.b.1
            @Override // com.amazon.a.a.n.a
            public void a() {
                try {
                    Activity activityB = b.this.f9304c.b();
                    if (activityB == null) {
                        activityB = b.this.f9304c.a();
                    }
                    com.amazon.device.simplesignin.a.d.a.a(b.f9302f, "Consent activity is about to start: " + activityB);
                    activityB.startActivity(intent);
                } catch (Exception e4) {
                    com.amazon.device.simplesignin.a.d.a.a(b.f9302f, "Exception when starting consent activity: " + e4);
                }
            }
        });
    }

    @Override // com.amazon.a.a.n.a.h
    public boolean b(j jVar) {
        Map mapB = jVar.b();
        if (!mapB.containsKey(com.amazon.device.simplesignin.a.a.a.f9277j) || mapB.get(com.amazon.device.simplesignin.a.a.a.f9277j) == null) {
            return super.a(mapB);
        }
        a((Intent) mapB.get(com.amazon.device.simplesignin.a.a.a.f9277j));
        return true;
    }
}
