.class public interface abstract Lorg/chromium/support_lib_boundary/WebMessageBoundaryInterface;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lorg/chromium/support_lib_boundary/FeatureFlagHolderBoundaryInterface;


# virtual methods
.method public abstract getData()Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract getMessagePayload()Ljava/lang/reflect/InvocationHandler;
.end method

.method public abstract getPorts()[Ljava/lang/reflect/InvocationHandler;
.end method
