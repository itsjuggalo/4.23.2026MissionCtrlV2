.class public Lrb/l1;
.super Ljava/lang/Exception;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Lrb/k1;

.field public final b:Lrb/y0;

.field public final c:Z


# direct methods
.method public constructor <init>(Lrb/k1;)V
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, p1, v0}, Lrb/l1;-><init>(Lrb/k1;Lrb/y0;)V

    return-void
.end method

.method public constructor <init>(Lrb/k1;Lrb/y0;)V
    .locals 1

    const/4 v0, 0x1

    .line 2
    invoke-direct {p0, p1, p2, v0}, Lrb/l1;-><init>(Lrb/k1;Lrb/y0;Z)V

    return-void
.end method

.method public constructor <init>(Lrb/k1;Lrb/y0;Z)V
    .locals 2

    .line 3
    invoke-static {p1}, Lrb/k1;->h(Lrb/k1;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lrb/k1;->m()Ljava/lang/Throwable;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 4
    iput-object p1, p0, Lrb/l1;->a:Lrb/k1;

    .line 5
    iput-object p2, p0, Lrb/l1;->b:Lrb/y0;

    .line 6
    iput-boolean p3, p0, Lrb/l1;->c:Z

    .line 7
    invoke-virtual {p0}, Lrb/l1;->fillInStackTrace()Ljava/lang/Throwable;

    return-void
.end method


# virtual methods
.method public final a()Lrb/k1;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/l1;->a:Lrb/k1;

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
    .line 17
    .line 18
    .line 19
.end method

.method public final b()Lrb/y0;
    .locals 1

    .line 1
    iget-object v0, p0, Lrb/l1;->b:Lrb/y0;

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
    .line 17
    .line 18
    .line 19
.end method

.method public declared-synchronized fillInStackTrace()Ljava/lang/Throwable;
    .locals 1

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-boolean v0, p0, Lrb/l1;->c:Z

    .line 3
    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    invoke-super {p0}, Ljava/lang/Throwable;->fillInStackTrace()Ljava/lang/Throwable;

    .line 7
    .line 8
    .line 9
    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 10
    goto :goto_0

    .line 11
    :catchall_0
    move-exception v0

    .line 12
    goto :goto_1

    .line 13
    :cond_0
    move-object v0, p0

    .line 14
    :goto_0
    monitor-exit p0

    .line 15
    return-object v0

    .line 16
    :goto_1
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 17
    throw v0
    .line 18
    .line 19
.end method
