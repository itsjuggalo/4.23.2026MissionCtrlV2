package com.google.firebase.sessions.settings;

import V.c;
import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import i3.o;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
public final class SettingsCache$removeConfigs$2 extends l implements o {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$2(SettingsCache settingsCache, e eVar) {
        super(2, eVar);
        this.this$0 = settingsCache;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        SettingsCache$removeConfigs$2 settingsCache$removeConfigs$2 = new SettingsCache$removeConfigs$2(this.this$0, eVar);
        settingsCache$removeConfigs$2.L$0 = obj;
        return settingsCache$removeConfigs$2;
    }

    @Override // i3.o
    public final Object invoke(c cVar, e eVar) {
        return ((SettingsCache$removeConfigs$2) create(cVar, eVar)).invokeSuspend(E.f5463a);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.b(obj);
        c cVar = (c) this.L$0;
        cVar.f();
        this.this$0.updateSessionConfigs(cVar);
        return E.f5463a;
    }
}
