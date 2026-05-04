.class public final Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;
.super Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault<",
        "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;",
        ">;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u00c0\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"
    }
    d2 = {
        "Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;",
        "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;",
        "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride$Condition;",
        "()V",
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


# static fields
.field public static final INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer;

    .line 7
    .line 8
    return-void
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

.method private constructor <init>()V
    .locals 8

    .line 1
    const-string v0, "compact"

    .line 2
    .line 3
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$1;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$1;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 6
    .line 7
    .line 8
    move-result-object v2

    .line 9
    const-string v0, "medium"

    .line 10
    .line 11
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$2;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$2;

    .line 12
    .line 13
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 14
    .line 15
    .line 16
    move-result-object v3

    .line 17
    const-string v0, "expanded"

    .line 18
    .line 19
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$3;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$3;

    .line 20
    .line 21
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 22
    .line 23
    .line 24
    move-result-object v4

    .line 25
    const-string v0, "intro_offer"

    .line 26
    .line 27
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$4;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$4;

    .line 28
    .line 29
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 30
    .line 31
    .line 32
    move-result-object v5

    .line 33
    const-string v0, "multiple_intro_offers"

    .line 34
    .line 35
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$5;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$5;

    .line 36
    .line 37
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 38
    .line 39
    .line 40
    move-result-object v6

    .line 41
    const-string v0, "selected"

    .line 42
    .line 43
    sget-object v1, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$6;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$6;

    .line 44
    .line 45
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 46
    .line 47
    .line 48
    move-result-object v7

    .line 49
    filled-new-array/range {v2 .. v7}, [Lcd/q;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    invoke-static {v0}, Ldd/o0;->l([Lcd/q;)Ljava/util/Map;

    .line 54
    .line 55
    .line 56
    move-result-object v3

    .line 57
    sget-object v4, Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$7;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/ConditionSerializer$7;

    .line 58
    .line 59
    const/16 v6, 0x8

    .line 60
    .line 61
    const/4 v7, 0x0

    .line 62
    const-string v2, "Condition"

    .line 63
    .line 64
    const/4 v5, 0x0

    .line 65
    move-object v1, p0

    .line 66
    invoke-direct/range {v1 .. v7}, Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;-><init>(Ljava/lang/String;Ljava/util/Map;Lpd/k;Ljava/lang/String;ILkotlin/jvm/internal/k;)V

    .line 67
    .line 68
    .line 69
    return-void
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
.end method
