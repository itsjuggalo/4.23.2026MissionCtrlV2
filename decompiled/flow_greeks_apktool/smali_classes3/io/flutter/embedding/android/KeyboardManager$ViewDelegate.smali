.class public interface abstract Lio/flutter/embedding/android/KeyboardManager$ViewDelegate;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/embedding/android/KeyboardManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "ViewDelegate"
.end annotation


# virtual methods
.method public abstract getBinaryMessenger()Lio/flutter/plugin/common/BinaryMessenger;
.end method

.method public abstract onTextInputKeyEvent(Landroid/view/KeyEvent;)Z
.end method

.method public abstract redispatch(Landroid/view/KeyEvent;)V
.end method
