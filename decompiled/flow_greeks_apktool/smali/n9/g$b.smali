.class public Ln9/g$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ln9/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "b"
.end annotation


# instance fields
.field public final a:Ln9/g$d;

.field public final b:J

.field public final c:Ljava/lang/Runnable;

.field public d:Ljava/util/concurrent/ScheduledFuture;

.field public final synthetic e:Ln9/g;


# direct methods
.method public constructor <init>(Ln9/g;Ln9/g$d;JLjava/lang/Runnable;)V
    .locals 0

    .line 2
    iput-object p1, p0, Ln9/g$b;->e:Ln9/g;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p2, p0, Ln9/g$b;->a:Ln9/g$d;

    .line 4
    iput-wide p3, p0, Ln9/g$b;->b:J

    .line 5
    iput-object p5, p0, Ln9/g$b;->c:Ljava/lang/Runnable;

    return-void
.end method

.method public synthetic constructor <init>(Ln9/g;Ln9/g$d;JLjava/lang/Runnable;Ln9/g$a;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p5}, Ln9/g$b;-><init>(Ln9/g;Ln9/g$d;JLjava/lang/Runnable;)V

    return-void
.end method

.method public static synthetic a(Ln9/g$b;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ln9/g$b;->d()V

    .line 2
    .line 3
    .line 4
    return-void
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
.end method

.method public static synthetic b(Ln9/g$b;J)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1, p2}, Ln9/g$b;->f(J)V

    .line 2
    .line 3
    .line 4
    return-void
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
.end method


# virtual methods
.method public c()V
    .locals 2

    .line 1
    iget-object v0, p0, Ln9/g$b;->e:Ln9/g;

    .line 2
    .line 3
    invoke-virtual {v0}, Ln9/g;->t()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ln9/g$b;->d:Ljava/util/concurrent/ScheduledFuture;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    const/4 v1, 0x0

    .line 11
    invoke-interface {v0, v1}, Ljava/util/concurrent/Future;->cancel(Z)Z

    .line 12
    .line 13
    .line 14
    invoke-virtual {p0}, Ln9/g$b;->e()V

    .line 15
    .line 16
    .line 17
    :cond_0
    return-void
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
.end method

.method public final d()V
    .locals 1

    .line 1
    iget-object v0, p0, Ln9/g$b;->e:Ln9/g;

    .line 2
    .line 3
    invoke-virtual {v0}, Ln9/g;->t()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ln9/g$b;->d:Ljava/util/concurrent/ScheduledFuture;

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    invoke-virtual {p0}, Ln9/g$b;->e()V

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Ln9/g$b;->c:Ljava/lang/Runnable;

    .line 14
    .line 15
    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 16
    .line 17
    .line 18
    :cond_0
    return-void
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
.end method

.method public final e()V
    .locals 3

    .line 1
    iget-object v0, p0, Ln9/g$b;->d:Ljava/util/concurrent/ScheduledFuture;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    const/4 v0, 0x1

    .line 7
    goto :goto_0

    .line 8
    :cond_0
    move v0, v1

    .line 9
    :goto_0
    const-string v2, "Caller should have verified scheduledFuture is non-null."

    .line 10
    .line 11
    new-array v1, v1, [Ljava/lang/Object;

    .line 12
    .line 13
    invoke-static {v0, v2, v1}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 14
    .line 15
    .line 16
    const/4 v0, 0x0

    .line 17
    iput-object v0, p0, Ln9/g$b;->d:Ljava/util/concurrent/ScheduledFuture;

    .line 18
    .line 19
    iget-object v0, p0, Ln9/g$b;->e:Ln9/g;

    .line 20
    .line 21
    invoke-static {v0, p0}, Ln9/g;->f(Ln9/g;Ln9/g$b;)V

    .line 22
    .line 23
    .line 24
    return-void
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
.end method

.method public final f(J)V
    .locals 3

    .line 1
    iget-object v0, p0, Ln9/g$b;->e:Ln9/g;

    .line 2
    .line 3
    invoke-static {v0}, Ln9/g;->e(Ln9/g;)Ln9/g$c;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    new-instance v1, Ln9/h;

    .line 8
    .line 9
    invoke-direct {v1, p0}, Ln9/h;-><init>(Ln9/g$b;)V

    .line 10
    .line 11
    .line 12
    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 13
    .line 14
    invoke-static {v0, v1, p1, p2, v2}, Ln9/g$c;->e(Ln9/g$c;Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    iput-object p1, p0, Ln9/g$b;->d:Ljava/util/concurrent/ScheduledFuture;

    .line 19
    .line 20
    return-void
    .line 21
    .line 22
    .line 23
    .line 24
.end method
