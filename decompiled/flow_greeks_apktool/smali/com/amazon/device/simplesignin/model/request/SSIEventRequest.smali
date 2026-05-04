.class public Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field private epochTimestamp:Ljava/lang/String;

.field private event:Lcom/amazon/device/simplesignin/model/SSIEvent;

.field private failureReason:Lcom/amazon/device/simplesignin/model/FailureReason;


# direct methods
.method public constructor <init>(Lcom/amazon/device/simplesignin/model/SSIEvent;)V
    .locals 2

    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->epochTimestamp:Ljava/lang/String;

    .line 7
    iput-object p1, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->event:Lcom/amazon/device/simplesignin/model/SSIEvent;

    const/4 p1, 0x0

    .line 8
    iput-object p1, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->failureReason:Lcom/amazon/device/simplesignin/model/FailureReason;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/simplesignin/model/SSIEvent;Lcom/amazon/device/simplesignin/model/FailureReason;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->epochTimestamp:Ljava/lang/String;

    .line 3
    iput-object p1, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->event:Lcom/amazon/device/simplesignin/model/SSIEvent;

    .line 4
    iput-object p2, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->failureReason:Lcom/amazon/device/simplesignin/model/FailureReason;

    return-void
.end method


# virtual methods
.method public getEpochTimestamp()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->epochTimestamp:Ljava/lang/String;

    .line 2
    .line 3
    return-object v0
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
.end method

.method public getEvent()Lcom/amazon/device/simplesignin/model/SSIEvent;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->event:Lcom/amazon/device/simplesignin/model/SSIEvent;

    .line 2
    .line 3
    return-object v0
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
.end method

.method public getFailureReason()Lcom/amazon/device/simplesignin/model/FailureReason;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/amazon/device/simplesignin/model/request/SSIEventRequest;->failureReason:Lcom/amazon/device/simplesignin/model/FailureReason;

    .line 2
    .line 3
    return-object v0
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
.end method
