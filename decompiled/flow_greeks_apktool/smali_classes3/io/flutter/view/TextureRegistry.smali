.class public interface abstract Lio/flutter/view/TextureRegistry;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/view/TextureRegistry$SurfaceLifecycle;,
        Lio/flutter/view/TextureRegistry$SurfaceProducer;,
        Lio/flutter/view/TextureRegistry$GLTextureConsumer;,
        Lio/flutter/view/TextureRegistry$ImageConsumer;,
        Lio/flutter/view/TextureRegistry$OnTrimMemoryListener;,
        Lio/flutter/view/TextureRegistry$OnFrameConsumedListener;,
        Lio/flutter/view/TextureRegistry$ImageTextureEntry;,
        Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;,
        Lio/flutter/view/TextureRegistry$TextureEntry;
    }
.end annotation


# virtual methods
.method public abstract createImageTexture()Lio/flutter/view/TextureRegistry$ImageTextureEntry;
.end method

.method public createSurfaceProducer()Lio/flutter/view/TextureRegistry$SurfaceProducer;
    .locals 1

    .line 1
    sget-object v0, Lio/flutter/view/TextureRegistry$SurfaceLifecycle;->manual:Lio/flutter/view/TextureRegistry$SurfaceLifecycle;

    invoke-interface {p0, v0}, Lio/flutter/view/TextureRegistry;->createSurfaceProducer(Lio/flutter/view/TextureRegistry$SurfaceLifecycle;)Lio/flutter/view/TextureRegistry$SurfaceProducer;

    move-result-object v0

    return-object v0
.end method

.method public abstract createSurfaceProducer(Lio/flutter/view/TextureRegistry$SurfaceLifecycle;)Lio/flutter/view/TextureRegistry$SurfaceProducer;
.end method

.method public abstract createSurfaceTexture()Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;
.end method

.method public onTrimMemory(I)V
    .locals 0

    .line 1
    return-void
    .line 2
    .line 3
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public abstract registerSurfaceTexture(Landroid/graphics/SurfaceTexture;)Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;
.end method
