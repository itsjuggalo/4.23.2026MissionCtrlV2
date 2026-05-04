.class public final Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00082\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u000c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a8\u0006\u000f"
    }
    d2 = {
        "toBackendEvent",
        "Lcom/revenuecat/purchases/common/events/BackendEvent;",
        "Lcom/revenuecat/purchases/common/events/BackendStoredEvent;",
        "toBackendStoredEvent",
        "Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;",
        "appUserID",
        "",
        "appSessionID",
        "Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;",
        "Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;",
        "Lcom/revenuecat/purchases/ads/events/AdEvent$Open;",
        "Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;",
        "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;",
        "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;",
        "Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;",
        "purchases_defaultsBc8Release"
    }
    k = 0x2
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static final toBackendEvent(Lcom/revenuecat/purchases/common/events/BackendStoredEvent;)Lcom/revenuecat/purchases/common/events/BackendEvent;
    .locals 1

    .line 1
    const-string v0, "<this>"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    instance-of v0, p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    check-cast p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;

    .line 11
    .line 12
    invoke-virtual {p0}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;->getEvent()Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;

    .line 13
    .line 14
    .line 15
    move-result-object p0

    .line 16
    return-object p0

    .line 17
    :cond_0
    instance-of v0, p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;

    .line 18
    .line 19
    if-eqz v0, :cond_1

    .line 20
    .line 21
    check-cast p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;

    .line 22
    .line 23
    invoke-virtual {p0}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;->getEvent()Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    .line 24
    .line 25
    .line 26
    move-result-object p0

    .line 27
    return-object p0

    .line 28
    :cond_1
    instance-of v0, p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 29
    .line 30
    if-eqz v0, :cond_2

    .line 31
    .line 32
    check-cast p0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 33
    .line 34
    invoke-virtual {p0}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;->getEvent()Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 35
    .line 36
    .line 37
    move-result-object p0

    .line 38
    return-object p0

    .line 39
    :cond_2
    new-instance p0, Lcd/o;

    .line 40
    .line 41
    invoke-direct {p0}, Lcd/o;-><init>()V

    .line 42
    .line 43
    .line 44
    throw p0
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 20

    const-string v0, "<this>"

    move-object/from16 v1, p0

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v12, p1

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v13, p2

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 52
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 53
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 54
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getId()Ljava/lang/String;

    move-result-object v2

    .line 55
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getEventVersion()I

    move-result v3

    .line 56
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getType()Lcom/revenuecat/purchases/ads/events/AdEventType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/ads/events/AdEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 57
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getTimestamp()J

    move-result-wide v5

    .line 58
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getNetworkName()Ljava/lang/String;

    move-result-object v7

    .line 59
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getMediatorName-GyoM_N4()Ljava/lang/String;

    move-result-object v8

    .line 60
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getPlacement()Ljava/lang/String;

    move-result-object v9

    .line 61
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getAdUnitId()Ljava/lang/String;

    move-result-object v10

    .line 62
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;->getImpressionId()Ljava/lang/String;

    move-result-object v11

    const/16 v18, 0x7800

    const/16 v19, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    .line 63
    invoke-direct/range {v1 .. v19}, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;-><init>(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 64
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 20

    const-string v0, "<this>"

    move-object/from16 v1, p0

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v12, p1

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v13, p2

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 94
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 95
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 96
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getId()Ljava/lang/String;

    move-result-object v2

    .line 97
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getEventVersion()I

    move-result v3

    .line 98
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getType()Lcom/revenuecat/purchases/ads/events/AdEventType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/ads/events/AdEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 99
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getTimestamp()J

    move-result-wide v5

    .line 100
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getNetworkName()Ljava/lang/String;

    move-result-object v7

    .line 101
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getMediatorName-GyoM_N4()Ljava/lang/String;

    move-result-object v8

    .line 102
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getPlacement()Ljava/lang/String;

    move-result-object v9

    .line 103
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getAdUnitId()Ljava/lang/String;

    move-result-object v10

    .line 104
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getImpressionId()Ljava/lang/String;

    move-result-object v11

    .line 105
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;->getMediatorErrorCode()Ljava/lang/Integer;

    move-result-object v17

    const/16 v18, 0x3800

    const/16 v19, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    .line 106
    invoke-direct/range {v1 .. v19}, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;-><init>(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 107
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 20

    const-string v0, "<this>"

    move-object/from16 v1, p0

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v12, p1

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v13, p2

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 81
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 82
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 83
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getId()Ljava/lang/String;

    move-result-object v2

    .line 84
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getEventVersion()I

    move-result v3

    .line 85
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getType()Lcom/revenuecat/purchases/ads/events/AdEventType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/ads/events/AdEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 86
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getTimestamp()J

    move-result-wide v5

    .line 87
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getNetworkName()Ljava/lang/String;

    move-result-object v7

    .line 88
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getMediatorName-GyoM_N4()Ljava/lang/String;

    move-result-object v8

    .line 89
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getPlacement()Ljava/lang/String;

    move-result-object v9

    .line 90
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getAdUnitId()Ljava/lang/String;

    move-result-object v10

    .line 91
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;->getImpressionId()Ljava/lang/String;

    move-result-object v11

    const/16 v18, 0x7800

    const/16 v19, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    .line 92
    invoke-direct/range {v1 .. v19}, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;-><init>(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 93
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Open;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 20

    const-string v0, "<this>"

    move-object/from16 v1, p0

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v12, p1

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v13, p2

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 40
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 41
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getId()Ljava/lang/String;

    move-result-object v2

    .line 42
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getEventVersion()I

    move-result v3

    .line 43
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getType()Lcom/revenuecat/purchases/ads/events/AdEventType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/ads/events/AdEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 44
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getTimestamp()J

    move-result-wide v5

    .line 45
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getNetworkName()Ljava/lang/String;

    move-result-object v7

    .line 46
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getMediatorName-GyoM_N4()Ljava/lang/String;

    move-result-object v8

    .line 47
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getPlacement()Ljava/lang/String;

    move-result-object v9

    .line 48
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getAdUnitId()Ljava/lang/String;

    move-result-object v10

    .line 49
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;->getImpressionId()Ljava/lang/String;

    move-result-object v11

    const/16 v18, 0x7800

    const/16 v19, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    const/16 v17, 0x0

    .line 50
    invoke-direct/range {v1 .. v19}, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;-><init>(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 51
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 20

    const-string v0, "<this>"

    move-object/from16 v1, p0

    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v12, p1

    invoke-static {v12, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v13, p2

    invoke-static {v13, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 65
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;

    .line 66
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;

    .line 67
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getId()Ljava/lang/String;

    move-result-object v2

    .line 68
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getEventVersion()I

    move-result v3

    .line 69
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getType()Lcom/revenuecat/purchases/ads/events/AdEventType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/ads/events/AdEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 70
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getTimestamp()J

    move-result-wide v5

    .line 71
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getNetworkName()Ljava/lang/String;

    move-result-object v7

    .line 72
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getMediatorName-GyoM_N4()Ljava/lang/String;

    move-result-object v8

    .line 73
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getPlacement()Ljava/lang/String;

    move-result-object v9

    .line 74
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getAdUnitId()Ljava/lang/String;

    move-result-object v10

    .line 75
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getImpressionId()Ljava/lang/String;

    move-result-object v11

    .line 76
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getRevenueMicros()J

    move-result-wide v14

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    .line 77
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getCurrency()Ljava/lang/String;

    move-result-object v15

    .line 78
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;->getPrecision-rAcPn4k()Ljava/lang/String;

    move-result-object v16

    const/16 v18, 0x4000

    const/16 v19, 0x0

    const/16 v17, 0x0

    .line 79
    invoke-direct/range {v1 .. v19}, Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;-><init>(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 80
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Ad;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 15

    const-string v0, "<this>"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v5, p1

    invoke-static {v5, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v6, p2

    invoke-static {v6, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;

    .line 15
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    .line 16
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getCreationData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$CreationData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$CreationData;->getId()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "creationData.id.toString()"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 17
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getRevisionID()I

    move-result v3

    .line 18
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getType()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;

    move-result-object v4

    .line 19
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object v7

    invoke-virtual {v7}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getTimestamp()Ljava/util/Date;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    .line 20
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object v9

    invoke-virtual {v9}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getDarkMode()Z

    move-result v9

    .line 21
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object v10

    invoke-virtual {v10}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getLocale()Ljava/lang/String;

    move-result-object v10

    .line 22
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;

    move-result-object p0

    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent$Data;->getDisplayMode()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;

    move-result-object v11

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v12, 0x0

    .line 23
    invoke-direct/range {v1 .. v14}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 15

    const-string v0, "<this>"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    move-object/from16 v5, p1

    invoke-static {v5, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appSessionID"

    move-object/from16 v6, p2

    invoke-static {v6, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 25
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;

    .line 26
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;

    .line 27
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getCreationData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$CreationData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$CreationData;->getId()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "creationData.id.toString()"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 28
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getRevisionID()I

    move-result v3

    .line 29
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v4

    invoke-virtual {v4}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getType()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;

    move-result-object v4

    .line 30
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v7

    invoke-virtual {v7}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getTimestamp()Ljava/util/Date;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v7

    .line 31
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v9

    invoke-virtual {v9}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getDarkMode()Z

    move-result v9

    .line 32
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v10

    invoke-virtual {v10}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getLocale()Ljava/lang/String;

    move-result-object v10

    .line 33
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v11

    invoke-virtual {v11}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getDisplayMode()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;

    move-result-object v11

    .line 34
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v12

    invoke-virtual {v12}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getPath()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;

    move-result-object v12

    .line 35
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object v13

    invoke-virtual {v13}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getUrl()Ljava/lang/String;

    move-result-object v13

    .line 36
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;->getData()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;

    move-result-object p0

    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent$Data;->getSurveyOptionID()Ljava/lang/String;

    move-result-object v14

    .line 37
    invoke-direct/range {v1 .. v14}, Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$CustomerCenter;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;)V

    return-object v0
.end method

.method public static final synthetic toBackendStoredEvent(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;
    .locals 14

    const-string v0, "<this>"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "appUserID"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;

    .line 2
    new-instance v1, Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;

    .line 3
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getCreationData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;->getId()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "creationData.id.toString()"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getType()Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEventType;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 5
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getSessionIdentifier()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v3, "data.sessionIdentifier.toString()"

    invoke-static {v6, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getOfferingIdentifier()Ljava/lang/String;

    move-result-object v7

    .line 7
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getPaywallRevision()I

    move-result v8

    .line 8
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getCreationData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$CreationData;->getDate()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v9

    .line 9
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getDisplayMode()Ljava/lang/String;

    move-result-object v11

    .line 10
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object v3

    invoke-virtual {v3}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getDarkMode()Z

    move-result v12

    .line 11
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;->getData()Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;

    move-result-object p0

    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent$Data;->getLocaleIdentifier()Ljava/lang/String;

    move-result-object v13

    const/4 v3, 0x1

    move-object v5, p1

    .line 12
    invoke-direct/range {v1 .. v13}, Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;)V

    .line 13
    invoke-direct {v0, v1}, Lcom/revenuecat/purchases/common/events/BackendStoredEvent$Paywalls;-><init>(Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;)V

    return-object v0
.end method
