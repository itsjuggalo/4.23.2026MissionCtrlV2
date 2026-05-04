.class public interface abstract Lio/flutter/plugin/common/MethodCodec;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# virtual methods
.method public abstract decodeEnvelope(Ljava/nio/ByteBuffer;)Ljava/lang/Object;
.end method

.method public abstract decodeMethodCall(Ljava/nio/ByteBuffer;)Lio/flutter/plugin/common/MethodCall;
.end method

.method public abstract encodeErrorEnvelope(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/nio/ByteBuffer;
.end method

.method public abstract encodeErrorEnvelopeWithStacktrace(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Ljava/nio/ByteBuffer;
.end method

.method public abstract encodeMethodCall(Lio/flutter/plugin/common/MethodCall;)Ljava/nio/ByteBuffer;
.end method

.method public abstract encodeSuccessEnvelope(Ljava/lang/Object;)Ljava/nio/ByteBuffer;
.end method
