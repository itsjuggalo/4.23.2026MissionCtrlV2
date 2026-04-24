package com.google.firebase.sessions.settings;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.settings.RemoteSettings$clearCachedSettings$1", f = "RemoteSettings.kt", l = {158}, m = "invokeSuspend")
public final class RemoteSettings$clearCachedSettings$1 extends l implements o {
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteSettings$clearCachedSettings$1(RemoteSettings remoteSettings, e eVar) {
        super(2, eVar);
        this.this$0 = remoteSettings;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new RemoteSettings$clearCachedSettings$1(this.this$0, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = AbstractC0787c.e();
        int i4 = this.label;
        if (i4 == 0) {
            q.b(obj);
            SettingsCache settingsCache = this.this$0.getSettingsCache();
            this.label = 1;
            if (settingsCache.removeConfigs$com_google_firebase_firebase_sessions(this) == objE) {
                return objE;
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
        }
        return E.f5463a;
    }

    @Override // i3.o
    public final Object invoke(L l4, e eVar) {
        return ((RemoteSettings$clearCachedSettings$1) create(l4, eVar)).invokeSuspend(E.f5463a);
    }
}
