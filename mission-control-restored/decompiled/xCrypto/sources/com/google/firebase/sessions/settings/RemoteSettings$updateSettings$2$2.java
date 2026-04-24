package com.google.firebase.sessions.settings;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import android.util.Log;
import b3.InterfaceC0868f;
import b3.l;
import i3.o;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2", f = "RemoteSettings.kt", l = {}, m = "invokeSuspend")
public final class RemoteSettings$updateSettings$2$2 extends l implements o {
    /* synthetic */ Object L$0;
    int label;

    public RemoteSettings$updateSettings$2$2(e eVar) {
        super(2, eVar);
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(eVar);
        remoteSettings$updateSettings$2$2.L$0 = obj;
        return remoteSettings$updateSettings$2$2;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.b(obj);
        Log.e(RemoteSettings.TAG, "Error failing to fetch the remote configs: " + ((String) this.L$0));
        return E.f5463a;
    }

    @Override // i3.o
    public final Object invoke(String str, e eVar) {
        return ((RemoteSettings$updateSettings$2$2) create(str, eVar)).invokeSuspend(E.f5463a);
    }
}
