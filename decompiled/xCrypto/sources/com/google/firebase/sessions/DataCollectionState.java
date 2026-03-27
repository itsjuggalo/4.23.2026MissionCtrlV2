package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;

/* JADX INFO: loaded from: classes.dex */
public enum DataCollectionState implements NumberedEnum {
    COLLECTION_UNKNOWN(0),
    COLLECTION_SDK_NOT_INSTALLED(1),
    COLLECTION_ENABLED(2),
    COLLECTION_DISABLED(3),
    COLLECTION_DISABLED_REMOTE(4),
    COLLECTION_SAMPLED(5);

    private final int number;

    DataCollectionState(int i4) {
        this.number = i4;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
