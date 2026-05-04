.class final Lcom/revenuecat/purchases/common/events/EventsManager$track$1;
.super Lkotlin/jvm/internal/v;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/revenuecat/purchases/common/events/EventsManager;->track(Lcom/revenuecat/purchases/common/events/FeatureEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/v;",
        "Lkotlin/jvm/functions/Function0;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\u0008\u0001\u0010\u0002"
    }
    d2 = {
        "Lcd/h0;",
        "invoke",
        "()V",
        "<anonymous>"
    }
    k = 0x3
    mv = {
        0x1,
        0x8,
        0x0
    }
.end annotation


# instance fields
.field final synthetic $event:Lcom/revenuecat/purchases/common/events/FeatureEvent;

.field final synthetic this$0:Lcom/revenuecat/purchases/common/events/EventsManager;


# direct methods
.method public constructor <init>(Lcom/revenuecat/purchases/common/events/FeatureEvent;Lcom/revenuecat/purchases/common/events/EventsManager;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->$event:Lcom/revenuecat/purchases/common/events/FeatureEvent;

    .line 2
    .line 3
    iput-object p2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    .line 4
    .line 5
    const/4 p1, 0x0

    .line 6
    invoke-direct {p0, p1}, Lkotlin/jvm/internal/v;-><init>(I)V

    .line 7
    .line 8
    .line 9
    return-void
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
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->invoke()V

    sget-object v0, Lcd/h0;->a:Lcd/h0;

    return-object v0
.end method

.method public final invoke()V
    .locals 8

    .line 2
    iget-object v0, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->$event:Lcom/revenuecat/purchases/common/events/FeatureEvent;

    .line 3
    sget-object v1, Lcom/revenuecat/purchases/LogLevel;->DEBUG:Lcom/revenuecat/purchases/LogLevel;

    invoke-static {}, Lcom/revenuecat/purchases/common/LogWrapperKt;->getCurrentLogHandler()Lcom/revenuecat/purchases/LogHandler;

    move-result-object v2

    .line 4
    sget-object v3, Lcom/revenuecat/purchases/common/Config;->INSTANCE:Lcom/revenuecat/purchases/common/Config;

    invoke-virtual {v3}, Lcom/revenuecat/purchases/common/Config;->getLogLevel()Lcom/revenuecat/purchases/LogLevel;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    move-result v4

    const-string v5, "[Purchases] - "

    if-gtz v4, :cond_0

    .line 5
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 6
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Tracking event: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 7
    invoke-interface {v2, v4, v0}, Lcom/revenuecat/purchases/LogHandler;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 8
    :cond_0
    iget-object v0, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->$event:Lcom/revenuecat/purchases/common/events/FeatureEvent;

    .line 9
    instance-of v2, v0, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;

    if-eqz v2, :cond_1

    check-cast v0, Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;

    .line 10
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 11
    invoke-static {v0, v2}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/paywalls/events/PaywallEvent;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto/16 :goto_0

    .line 12
    :cond_1
    instance-of v2, v0, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;

    const-string v4, "appSessionID.toString()"

    if-eqz v2, :cond_2

    check-cast v0, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;

    .line 13
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 14
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/customercenter/events/CustomerCenterImpressionEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto/16 :goto_0

    .line 16
    :cond_2
    instance-of v2, v0, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;

    if-eqz v2, :cond_3

    check-cast v0, Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;

    .line 17
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 18
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 19
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/customercenter/events/CustomerCenterSurveyOptionChosenEvent;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto/16 :goto_0

    .line 20
    :cond_3
    instance-of v2, v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;

    if-eqz v2, :cond_4

    check-cast v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;

    .line 21
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 22
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 23
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Displayed;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto/16 :goto_0

    .line 24
    :cond_4
    instance-of v2, v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;

    if-eqz v2, :cond_5

    check-cast v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Open;

    .line 25
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 26
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Open;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto :goto_0

    .line 28
    :cond_5
    instance-of v2, v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;

    if-eqz v2, :cond_6

    check-cast v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;

    .line 29
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 30
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 31
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Revenue;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto :goto_0

    .line 32
    :cond_6
    instance-of v2, v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;

    if-eqz v2, :cond_7

    check-cast v0, Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;

    .line 33
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 34
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 35
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$Loaded;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto :goto_0

    .line 36
    :cond_7
    instance-of v2, v0, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;

    if-eqz v2, :cond_8

    check-cast v0, Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;

    .line 37
    iget-object v2, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v2}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getIdentityManager$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/identity/IdentityManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/revenuecat/purchases/identity/IdentityManager;->getCurrentAppUserID()Ljava/lang/String;

    move-result-object v2

    .line 38
    iget-object v6, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v6}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getAppSessionID$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 39
    invoke-static {v0, v2, v6}, Lcom/revenuecat/purchases/common/events/BackendStoredEventKt;->toBackendStoredEvent(Lcom/revenuecat/purchases/ads/events/AdEvent$FailedToLoad;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendStoredEvent;

    move-result-object v0

    goto :goto_0

    :cond_8
    const/4 v0, 0x0

    :goto_0
    if-eqz v0, :cond_9

    .line 40
    iget-object v1, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v1}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$checkFileSizeAndClearIfNeeded(Lcom/revenuecat/purchases/common/events/EventsManager;)V

    .line 41
    iget-object v1, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->this$0:Lcom/revenuecat/purchases/common/events/EventsManager;

    invoke-static {v1}, Lcom/revenuecat/purchases/common/events/EventsManager;->access$getFileHelper$p(Lcom/revenuecat/purchases/common/events/EventsManager;)Lcom/revenuecat/purchases/utils/EventsFileHelper;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/revenuecat/purchases/utils/EventsFileHelper;->appendEvent(Lcom/revenuecat/purchases/utils/Event;)V

    return-void

    .line 42
    :cond_9
    iget-object v0, p0, Lcom/revenuecat/purchases/common/events/EventsManager$track$1;->$event:Lcom/revenuecat/purchases/common/events/FeatureEvent;

    .line 43
    invoke-static {}, Lcom/revenuecat/purchases/common/LogWrapperKt;->getCurrentLogHandler()Lcom/revenuecat/purchases/LogHandler;

    move-result-object v2

    .line 44
    invoke-virtual {v3}, Lcom/revenuecat/purchases/common/Config;->getLogLevel()Lcom/revenuecat/purchases/LogLevel;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/Enum;->compareTo(Ljava/lang/Enum;)I

    move-result v3

    if-gtz v3, :cond_a

    .line 45
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/Enum;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 46
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Backend event not implemented for: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 47
    invoke-interface {v2, v1, v0}, Lcom/revenuecat/purchases/LogHandler;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_a
    return-void
.end method
