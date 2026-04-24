package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;

/* JADX INFO: loaded from: classes.dex */
public enum EventType implements NumberedEnum {
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);

    private final int number;

    EventType(int i4) {
        this.number = i4;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int getNumber() {
        return this.number;
    }
}
