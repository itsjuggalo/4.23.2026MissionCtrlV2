package com.google.firebase.encoders;

/* JADX INFO: loaded from: classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d4);

    ValueEncoderContext add(float f4);

    ValueEncoderContext add(int i4);

    ValueEncoderContext add(long j4);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z4);

    ValueEncoderContext add(byte[] bArr);
}
