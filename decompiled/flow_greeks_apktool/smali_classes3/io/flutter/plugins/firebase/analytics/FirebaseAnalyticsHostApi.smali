.class public interface abstract Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi$Companion;
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\r\u0008f\u0018\u0000 $2\u00020\u0001:\u0001$J?\u0010\t\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00022\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\t\u0010\nJ3\u0010\u000c\u001a\u00020\u00072\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u000c\u0010\rJ;\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00032\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u0010\u0010\u0011J1\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u0014\u0010\u0015J)\u0010\u0016\u001a\u00020\u00072\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u0016\u0010\u0017J1\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u001a\u0010\u001bJ?\u0010\u001d\u001a\u00020\u00072\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00022\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u001d\u0010\nJA\u0010\u001f\u001a\u00020\u00072\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008\u001f\u0010\nJ+\u0010 \u001a\u00020\u00072\u001a\u0010\u0008\u001a\u0016\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008 \u0010\u0017J+\u0010!\u001a\u00020\u00072\u001a\u0010\u0008\u001a\u0016\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008!\u0010\u0017J?\u0010#\u001a\u00020\u00072\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0018\u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&\u00a2\u0006\u0004\u0008#\u0010\n\u00a8\u0006%"
    }
    d2 = {
        "Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi;",
        "",
        "",
        "",
        "event",
        "Lkotlin/Function1;",
        "Lcd/r;",
        "Lcd/h0;",
        "callback",
        "logEvent",
        "(Ljava/util/Map;Lpd/k;)V",
        "userId",
        "setUserId",
        "(Ljava/lang/String;Lpd/k;)V",
        "name",
        "value",
        "setUserProperty",
        "(Ljava/lang/String;Ljava/lang/String;Lpd/k;)V",
        "",
        "enabled",
        "setAnalyticsCollectionEnabled",
        "(ZLpd/k;)V",
        "resetAnalyticsData",
        "(Lpd/k;)V",
        "",
        "timeout",
        "setSessionTimeoutDuration",
        "(JLpd/k;)V",
        "consent",
        "setConsent",
        "parameters",
        "setDefaultEventParameters",
        "getAppInstanceId",
        "getSessionId",
        "arguments",
        "initiateOnDeviceConversionMeasurement",
        "Companion",
        "firebase_analytics_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x1,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final Companion:Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi$Companion;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    sget-object v0, Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi$Companion;->$$INSTANCE:Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi$Companion;

    .line 2
    .line 3
    sput-object v0, Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi;->Companion:Lio/flutter/plugins/firebase/analytics/FirebaseAnalyticsHostApi$Companion;

    .line 4
    .line 5
    return-void
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
.end method


# virtual methods
.method public abstract getAppInstanceId(Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract getSessionId(Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract initiateOnDeviceConversionMeasurement(Ljava/util/Map;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract logEvent(Ljava/util/Map;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "+",
            "Ljava/lang/Object;",
            ">;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract resetAnalyticsData(Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setAnalyticsCollectionEnabled(ZLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setConsent(Ljava/util/Map;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Boolean;",
            ">;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setDefaultEventParameters(Ljava/util/Map;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "+",
            "Ljava/lang/Object;",
            ">;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setSessionTimeoutDuration(JLpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setUserId(Ljava/lang/String;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method

.method public abstract setUserProperty(Ljava/lang/String;Ljava/lang/String;Lpd/k;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lpd/k;",
            ")V"
        }
    .end annotation
.end method
