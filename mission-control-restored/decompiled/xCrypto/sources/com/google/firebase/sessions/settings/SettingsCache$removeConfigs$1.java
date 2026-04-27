package com.google.firebase.sessions.settings;

import Z2.e;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0868f(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {109}, m = "removeConfigs$com_google_firebase_firebase_sessions")
public final class SettingsCache$removeConfigs$1 extends AbstractC0866d {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$1(SettingsCache settingsCache, e eVar) {
        super(eVar);
        this.this$0 = settingsCache;
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeConfigs$com_google_firebase_firebase_sessions(this);
    }
}
