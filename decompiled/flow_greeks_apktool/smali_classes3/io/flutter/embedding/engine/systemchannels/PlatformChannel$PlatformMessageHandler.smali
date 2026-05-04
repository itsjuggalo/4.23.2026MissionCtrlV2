.class public interface abstract Lio/flutter/embedding/engine/systemchannels/PlatformChannel$PlatformMessageHandler;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/embedding/engine/systemchannels/PlatformChannel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PlatformMessageHandler"
.end annotation


# virtual methods
.method public abstract clipboardHasStrings()Z
.end method

.method public abstract getClipboardData(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$ClipboardContentFormat;)Ljava/lang/CharSequence;
.end method

.method public abstract playSystemSound(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SoundType;)V
.end method

.method public abstract popSystemNavigator()V
.end method

.method public abstract restoreSystemUiOverlays()V
.end method

.method public abstract setApplicationSwitcherDescription(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$AppSwitcherDescription;)V
.end method

.method public abstract setClipboardData(Ljava/lang/String;)V
.end method

.method public setFrameworkHandlesBack(Z)V
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

.method public abstract setPreferredOrientations(I)V
.end method

.method public abstract setSystemUiChangeListener()V
.end method

.method public abstract setSystemUiOverlayStyle(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemChromeStyle;)V
.end method

.method public abstract share(Ljava/lang/String;)V
.end method

.method public abstract showSystemOverlays(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiOverlay;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract showSystemUiMode(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$SystemUiMode;)V
.end method

.method public abstract vibrateHapticFeedback(Lio/flutter/embedding/engine/systemchannels/PlatformChannel$HapticFeedbackType;)V
.end method
