.class public interface abstract Lio/flutter/embedding/engine/systemchannels/AccessibilityChannel$AccessibilityMessageHandler;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lio/flutter/embedding/engine/FlutterJNI$AccessibilityDelegate;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/embedding/engine/systemchannels/AccessibilityChannel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "AccessibilityMessageHandler"
.end annotation


# virtual methods
.method public abstract announce(Ljava/lang/String;)V
    .annotation runtime Ljava/lang/Deprecated;
        since = "Android API level 36"
    .end annotation
.end method

.method public abstract onFocus(I)V
.end method

.method public abstract onLongPress(I)V
.end method

.method public abstract onTap(I)V
.end method

.method public abstract onTooltip(Ljava/lang/String;)V
.end method
