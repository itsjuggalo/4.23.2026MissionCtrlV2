package com.google.firebase.encoders;

/* JADX INFO: loaded from: classes.dex */
public interface ObjectEncoderContext {
    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d4);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f4);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i4);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j4);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj);

    ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z4);

    @Deprecated
    ObjectEncoderContext add(String str, double d4);

    @Deprecated
    ObjectEncoderContext add(String str, int i4);

    @Deprecated
    ObjectEncoderContext add(String str, long j4);

    @Deprecated
    ObjectEncoderContext add(String str, Object obj);

    @Deprecated
    ObjectEncoderContext add(String str, boolean z4);

    ObjectEncoderContext inline(Object obj);

    ObjectEncoderContext nested(FieldDescriptor fieldDescriptor);

    ObjectEncoderContext nested(String str);
}
