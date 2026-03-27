package com.amazon.device.simplesignin.a.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.request.SSIEventRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b implements com.amazon.device.simplesignin.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14593a = "b";

    @Override // com.amazon.device.simplesignin.a.b
    public void a(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(a.f14577n);
        if (stringExtra == null) {
            com.amazon.device.simplesignin.a.d.a.b(f14593a, "Invalid response type: null");
            return;
        }
        com.amazon.device.simplesignin.a.d.a.a(f14593a, "Found response type: " + stringExtra);
        if (a.f14586w.equals(stringExtra)) {
            new com.amazon.device.simplesignin.a.a.b.a.b(new RequestId(intent.getStringExtra(com.amazon.a.a.o.b.f14024B))).d();
        }
        if (a.f14587x.equals(stringExtra)) {
            new com.amazon.device.simplesignin.a.a.d.a.a(new RequestId(intent.getStringExtra(com.amazon.a.a.o.b.f14024B))).d();
        }
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest) {
        new com.amazon.device.simplesignin.a.a.b.a(requestId, linkUserAccountRequest).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, SSIEventRequest sSIEventRequest) {
        new com.amazon.device.simplesignin.a.a.c.a(requestId, sSIEventRequest).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, String str) {
        new com.amazon.device.simplesignin.a.a.a.a(requestId, str).d();
    }

    @Override // com.amazon.device.simplesignin.a.b
    public void a(RequestId requestId, Map<String, String> map) {
        new com.amazon.device.simplesignin.a.a.d.a(requestId, map).d();
    }
}
