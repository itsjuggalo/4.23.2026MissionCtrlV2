.class public final Lcom/revenuecat/purchases/utils/RateLimiter;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0016\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\u0008\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\u0008\u00a2\u0006\u0004\u0008\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\u000c\n\u0004\u0008\u0003\u0010\u000b\u001a\u0004\u0008\u000c\u0010\rR\u001d\u0010\u0005\u001a\u00020\u00048\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u000c\n\u0004\u0008\u0005\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\u0008\u0011\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\u0008\u0015\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008\u00a1\u001e0\u0001\n\u0002\u0008!\u00a8\u0006\u0016"
    }
    d2 = {
        "Lcom/revenuecat/purchases/utils/RateLimiter;",
        "",
        "",
        "maxCallsInPeriod",
        "Llg/a;",
        "periodSeconds",
        "<init>",
        "(IJLkotlin/jvm/internal/k;)V",
        "",
        "shouldProceed",
        "()Z",
        "I",
        "getMaxCallsInPeriod",
        "()I",
        "J",
        "getPeriodSeconds-UwyO8pc",
        "()J",
        "maxCallInclusive",
        "",
        "callTimestamps",
        "[J",
        "index",
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
.field private final callTimestamps:[J

.field private index:I

.field private final maxCallInclusive:I

.field private final maxCallsInPeriod:I

.field private final periodSeconds:J


# direct methods
.method private constructor <init>(IJ)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->maxCallsInPeriod:I

    iput-wide p2, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->periodSeconds:J

    add-int/lit8 p1, p1, 0x1

    .line 3
    iput p1, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->maxCallInclusive:I

    .line 4
    new-array p1, p1, [J

    iput-object p1, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->callTimestamps:[J

    return-void
.end method

.method public synthetic constructor <init>(IJLkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Lcom/revenuecat/purchases/utils/RateLimiter;-><init>(IJ)V

    return-void
.end method


# virtual methods
.method public final getMaxCallsInPeriod()I
    .locals 1

    .line 1
    iget v0, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->maxCallsInPeriod:I

    .line 2
    .line 3
    return v0
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
.end method

.method public final getPeriodSeconds-UwyO8pc()J
    .locals 2

    .line 1
    iget-wide v0, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->periodSeconds:J

    .line 2
    .line 3
    return-wide v0
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
.end method

.method public final declared-synchronized shouldProceed()Z
    .locals 9

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    .line 3
    .line 4
    .line 5
    move-result-wide v0

    .line 6
    iget v2, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->index:I

    .line 7
    .line 8
    const/4 v3, 0x1

    .line 9
    add-int/2addr v2, v3

    .line 10
    iget v4, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->maxCallInclusive:I

    .line 11
    .line 12
    rem-int/2addr v2, v4

    .line 13
    iget-object v4, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->callTimestamps:[J

    .line 14
    .line 15
    aget-wide v5, v4, v2

    .line 16
    .line 17
    const-wide/16 v7, 0x0

    .line 18
    .line 19
    cmp-long v4, v5, v7

    .line 20
    .line 21
    if-eqz v4, :cond_1

    .line 22
    .line 23
    sub-long v4, v0, v5

    .line 24
    .line 25
    iget-wide v6, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->periodSeconds:J

    .line 26
    .line 27
    invoke-static {v6, v7}, Llg/a;->w(J)J

    .line 28
    .line 29
    .line 30
    move-result-wide v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 31
    cmp-long v4, v4, v6

    .line 32
    .line 33
    if-lez v4, :cond_0

    .line 34
    .line 35
    goto :goto_0

    .line 36
    :cond_0
    monitor-exit p0

    .line 37
    const/4 v0, 0x0

    .line 38
    return v0

    .line 39
    :catchall_0
    move-exception v0

    .line 40
    goto :goto_1

    .line 41
    :cond_1
    :goto_0
    :try_start_1
    iget-object v4, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->callTimestamps:[J

    .line 42
    .line 43
    iget v5, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->index:I

    .line 44
    .line 45
    aput-wide v0, v4, v5

    .line 46
    .line 47
    iput v2, p0, Lcom/revenuecat/purchases/utils/RateLimiter;->index:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 48
    .line 49
    monitor-exit p0

    .line 50
    return v3

    .line 51
    :goto_1
    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 52
    throw v0
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
.end method
