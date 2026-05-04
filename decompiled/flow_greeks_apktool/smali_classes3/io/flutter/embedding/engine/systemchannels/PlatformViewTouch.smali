.class public Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final action:I

.field public final buttonState:I

.field public final deviceId:I

.field public final downTime:Ljava/lang/Number;

.field public final edgeFlags:I

.field public final eventTime:Ljava/lang/Number;

.field public final flags:I

.field public final metaState:I

.field public final motionEventId:J

.field public final pointerCount:I

.field public final rawPointerCoords:Ljava/lang/Object;

.field public final rawPointerPropertiesList:Ljava/lang/Object;

.field public final source:I

.field public final viewId:I

.field public final xPrecision:F

.field public final yPrecision:F


# direct methods
.method public constructor <init>(ILjava/lang/Number;Ljava/lang/Number;IILjava/lang/Object;Ljava/lang/Object;IIFFIIIIJ)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput p1, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->viewId:I

    .line 3
    iput-object p2, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->downTime:Ljava/lang/Number;

    .line 4
    iput-object p3, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->eventTime:Ljava/lang/Number;

    .line 5
    iput p4, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->action:I

    .line 6
    iput p5, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->pointerCount:I

    .line 7
    iput-object p6, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->rawPointerPropertiesList:Ljava/lang/Object;

    .line 8
    iput-object p7, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->rawPointerCoords:Ljava/lang/Object;

    .line 9
    iput p8, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->metaState:I

    .line 10
    iput p9, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->buttonState:I

    .line 11
    iput p10, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->xPrecision:F

    .line 12
    iput p11, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->yPrecision:F

    .line 13
    iput p12, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->deviceId:I

    .line 14
    iput p13, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->edgeFlags:I

    .line 15
    iput p14, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->source:I

    .line 16
    iput p15, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->flags:I

    move-wide/from16 p1, p16

    .line 17
    iput-wide p1, p0, Lio/flutter/embedding/engine/systemchannels/PlatformViewTouch;->motionEventId:J

    return-void
.end method
