package com.google.firebase.firestore.local;

import com.google.protobuf.AbstractC1062i;

/* JADX INFO: loaded from: classes.dex */
final class MemoryGlobalsCache implements GlobalsCache {
    private AbstractC1062i sessionToken = AbstractC1062i.f11025b;

    @Override // com.google.firebase.firestore.local.GlobalsCache
    public AbstractC1062i getSessionsToken() {
        return this.sessionToken;
    }

    @Override // com.google.firebase.firestore.local.GlobalsCache
    public void setSessionToken(AbstractC1062i abstractC1062i) {
        this.sessionToken = abstractC1062i;
    }
}
