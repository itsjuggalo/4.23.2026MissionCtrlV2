package com.google.firebase.firestore.local;

import com.google.protobuf.ByteString;

/* JADX INFO: loaded from: classes2.dex */
interface GlobalsCache {
    ByteString getSessionsToken();

    void setSessionToken(ByteString byteString);
}
