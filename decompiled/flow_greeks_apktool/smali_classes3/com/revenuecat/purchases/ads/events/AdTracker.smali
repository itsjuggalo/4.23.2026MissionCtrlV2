.class public final Lcom/revenuecat/purchases/ads/events/AdTracker;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation build Lcom/revenuecat/purchases/InternalRevenueCatAPI;
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\u000c\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u000b\u00a2\u0006\u0004\u0008\u000c\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u000e\u00a2\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0011\u00a2\u0006\u0004\u0008\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0014\u00a2\u0006\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\u0008\u0003\u0010\u0017\u00a8\u0006\u0018"
    }
    d2 = {
        "Lcom/revenuecat/purchases/ads/events/AdTracker;",
        "",
        "Lcom/revenuecat/purchases/common/events/EventsManager;",
        "eventsManager",
        "<init>",
        "(Lcom/revenuecat/purchases/common/events/EventsManager;)V",
        "Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;",
        "data",
        "Lcd/h0;",
        "trackAdDisplayed",
        "(Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;)V",
        "Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;",
        "trackAdOpened",
        "(Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;)V",
        "Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;",
        "trackAdRevenue",
        "(Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;)V",
        "Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;",
        "trackAdLoaded",
        "(Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;)V",
        "Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;",
        "trackAdFailedToLoad",
        "(Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;)V",
        "Lcom/revenuecat/purchases/common/events/EventsManager;",
        "purchases_defaultsBc8Release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field private final eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;


# direct methods
.method public constructor <init>(Lcom/revenuecat/purchases/common/events/EventsManager;)V
    .locals 1

    .line 1
    const-string v0, "eventsManager"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object p1, p0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 10
    .line 11
    return-void
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


# virtual methods
.method public final trackAdDisplayed(Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;)V
    .locals 14

    .line 1
    const-string v0, "data"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 7
    .line 8
    new-instance v1, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;->getNetworkName()Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v7

    .line 14
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;->getMediatorName-GyoM_N4()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v8

    .line 18
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;->getPlacement()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v9

    .line 22
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;->getAdUnitId()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v10

    .line 26
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;->getImpressionId()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v11

    .line 30
    const/16 v12, 0xf

    .line 31
    .line 32
    const/4 v13, 0x0

    .line 33
    const/4 v2, 0x0

    .line 34
    const/4 v3, 0x0

    .line 35
    const/4 v4, 0x0

    .line 36
    const-wide/16 v5, 0x0

    .line 37
    .line 38
    invoke-direct/range {v1 .. v13}, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/k;)V

    .line 39
    .line 40
    .line 41
    invoke-virtual {v0, v1}, Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V

    .line 42
    .line 43
    .line 44
    return-void
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

.method public final trackAdFailedToLoad(Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;)V
    .locals 17

    .line 1
    const-string v0, "data"

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    move-object/from16 v0, p0

    .line 9
    .line 10
    iget-object v2, v0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 11
    .line 12
    new-instance v3, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;

    .line 13
    .line 14
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;->getNetworkName()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v9

    .line 18
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;->getMediatorName-GyoM_N4()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v10

    .line 22
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;->getPlacement()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v11

    .line 26
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;->getAdUnitId()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v12

    .line 30
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;->getMediatorErrorCode()Ljava/lang/Integer;

    .line 31
    .line 32
    .line 33
    move-result-object v14

    .line 34
    const/16 v15, 0xf

    .line 35
    .line 36
    const/16 v16, 0x0

    .line 37
    .line 38
    const/4 v4, 0x0

    .line 39
    const/4 v5, 0x0

    .line 40
    const/4 v6, 0x0

    .line 41
    const-wide/16 v7, 0x0

    .line 42
    .line 43
    const/4 v13, 0x0

    .line 44
    invoke-direct/range {v3 .. v16}, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/jvm/internal/k;)V

    .line 45
    .line 46
    .line 47
    invoke-virtual {v2, v3}, Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V

    .line 48
    .line 49
    .line 50
    return-void
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

.method public final trackAdLoaded(Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;)V
    .locals 14

    .line 1
    const-string v0, "data"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 7
    .line 8
    new-instance v1, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;->getNetworkName()Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v7

    .line 14
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;->getMediatorName-GyoM_N4()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v8

    .line 18
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;->getPlacement()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v9

    .line 22
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;->getAdUnitId()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v10

    .line 26
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;->getImpressionId()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v11

    .line 30
    const/16 v12, 0xf

    .line 31
    .line 32
    const/4 v13, 0x0

    .line 33
    const/4 v2, 0x0

    .line 34
    const/4 v3, 0x0

    .line 35
    const/4 v4, 0x0

    .line 36
    const-wide/16 v5, 0x0

    .line 37
    .line 38
    invoke-direct/range {v1 .. v13}, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/k;)V

    .line 39
    .line 40
    .line 41
    invoke-virtual {v0, v1}, Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V

    .line 42
    .line 43
    .line 44
    return-void
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

.method public final trackAdOpened(Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;)V
    .locals 14

    .line 1
    const-string v0, "data"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 7
    .line 8
    new-instance v1, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;

    .line 9
    .line 10
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;->getNetworkName()Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v7

    .line 14
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;->getMediatorName-GyoM_N4()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v8

    .line 18
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;->getPlacement()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v9

    .line 22
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;->getAdUnitId()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v10

    .line 26
    invoke-virtual {p1}, Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;->getImpressionId()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v11

    .line 30
    const/16 v12, 0xf

    .line 31
    .line 32
    const/4 v13, 0x0

    .line 33
    const/4 v2, 0x0

    .line 34
    const/4 v3, 0x0

    .line 35
    const/4 v4, 0x0

    .line 36
    const-wide/16 v5, 0x0

    .line 37
    .line 38
    invoke-direct/range {v1 .. v13}, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/k;)V

    .line 39
    .line 40
    .line 41
    invoke-virtual {v0, v1}, Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V

    .line 42
    .line 43
    .line 44
    return-void
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

.method public final trackAdRevenue(Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;)V
    .locals 20

    .line 1
    const-string v0, "data"

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    move-object/from16 v0, p0

    .line 9
    .line 10
    iget-object v2, v0, Lcom/revenuecat/purchases/ads/events/AdTracker;->eventsManager:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 11
    .line 12
    new-instance v3, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;

    .line 13
    .line 14
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getNetworkName()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v9

    .line 18
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getMediatorName-GyoM_N4()Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v10

    .line 22
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getPlacement()Ljava/lang/String;

    .line 23
    .line 24
    .line 25
    move-result-object v11

    .line 26
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getAdUnitId()Ljava/lang/String;

    .line 27
    .line 28
    .line 29
    move-result-object v12

    .line 30
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getImpressionId()Ljava/lang/String;

    .line 31
    .line 32
    .line 33
    move-result-object v13

    .line 34
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getRevenueMicros()J

    .line 35
    .line 36
    .line 37
    move-result-wide v14

    .line 38
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getCurrency()Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    move-result-object v16

    .line 42
    invoke-virtual {v1}, Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;->getPrecision-rAcPn4k()Ljava/lang/String;

    .line 43
    .line 44
    .line 45
    move-result-object v17

    .line 46
    const/16 v18, 0xf

    .line 47
    .line 48
    const/16 v19, 0x0

    .line 49
    .line 50
    const/4 v4, 0x0

    .line 51
    const/4 v5, 0x0

    .line 52
    const/4 v6, 0x0

    .line 53
    const-wide/16 v7, 0x0

    .line 54
    .line 55
    invoke-direct/range {v3 .. v19}, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;-><init>(Ljava/lang/String;ILcom/revenuecat/purchases/ads/events/AdEventType;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/k;)V

    .line 56
    .line 57
    .line 58
    invoke-virtual {v2, v3}, Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V

    .line 59
    .line 60
    .line 61
    return-void
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
