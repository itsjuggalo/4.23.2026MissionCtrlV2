package com.google.firebase.sessions.settings;

import W2.E;
import Z2.e;
import b3.InterfaceC0868f;
import b3.l;
import i3.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {132, 135, 138, 140, 141, 143}, m = "invokeSuspend")
public final class RemoteSettings$updateSettings$2$1 extends l implements o {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, e eVar) {
        super(2, eVar);
        this.this$0 = remoteSettings;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, eVar);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0154, code lost:
    
        if (r13.updateSessionCacheDuration(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0195, code lost:
    
        if (r13.updateSessionCacheUpdatedTime(r0, r12) == r4) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015d  */
    @Override // b3.AbstractC0863a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // i3.o
    public final Object invoke(JSONObject jSONObject, e eVar) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, eVar)).invokeSuspend(E.f5463a);
    }
}
