package com.google.firebase.sessions;

import java.util.UUID;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UuidGeneratorImpl implements UuidGenerator {
    public static final UuidGeneratorImpl INSTANCE = new UuidGeneratorImpl();

    private UuidGeneratorImpl() {
    }

    @Override // com.google.firebase.sessions.UuidGenerator
    public UUID next() {
        UUID uuidRandomUUID = UUID.randomUUID();
        r.e(uuidRandomUUID, "randomUUID()");
        return uuidRandomUUID;
    }
}
