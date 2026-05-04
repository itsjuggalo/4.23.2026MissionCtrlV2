.class public final Ln9/m;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ln9/m$a;,
        Ln9/m$b;
    }
.end annotation


# static fields
.field public static final b:Ln9/m$a;

.field public static final c:I

.field public static final d:Ljava/util/concurrent/Executor;


# instance fields
.field public a:Ln9/m$b;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 1
    new-instance v0, Ln9/m$a;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Ln9/m$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 5
    .line 6
    .line 7
    sput-object v0, Ln9/m;->b:Ln9/m$a;

    .line 8
    .line 9
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    invoke-virtual {v0}, Ljava/lang/Runtime;->availableProcessors()I

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    const/4 v1, 0x2

    .line 18
    invoke-static {v0, v1}, Lvd/l;->b(II)I

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    sput v0, Ln9/m;->c:I

    .line 23
    .line 24
    invoke-static {}, Lng/c1;->b()Lng/k0;

    .line 25
    .line 26
    .line 27
    move-result-object v1

    .line 28
    const-string v2, "firestore.BackgroundQueue"

    .line 29
    .line 30
    invoke-virtual {v1, v0, v2}, Lng/k0;->c0(ILjava/lang/String;)Lng/k0;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    invoke-static {v0}, Lng/r1;->a(Lng/k0;)Ljava/util/concurrent/Executor;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    sput-object v0, Ln9/m;->d:Ljava/util/concurrent/Executor;

    .line 39
    .line 40
    return-void
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

.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ln9/m$b$b;

    .line 5
    .line 6
    invoke-direct {v0}, Ln9/m$b$b;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Ln9/m;->a:Ln9/m$b;

    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public static synthetic a(Ljava/lang/Runnable;Ln9/m$b;)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Ln9/m;->d(Ljava/lang/Runnable;Ln9/m$b;)V

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

.method public static final d(Ljava/lang/Runnable;Ln9/m$b;)V
    .locals 0

    .line 1
    :try_start_0
    invoke-interface {p0}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2
    .line 3
    .line 4
    check-cast p1, Ln9/m$b$b;

    .line 5
    .line 6
    invoke-virtual {p1}, Ln9/m$b$b;->a()Ljava/util/concurrent/Semaphore;

    .line 7
    .line 8
    .line 9
    move-result-object p0

    .line 10
    invoke-virtual {p0}, Ljava/util/concurrent/Semaphore;->release()V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :catchall_0
    move-exception p0

    .line 15
    check-cast p1, Ln9/m$b$b;

    .line 16
    .line 17
    invoke-virtual {p1}, Ln9/m$b$b;->a()Ljava/util/concurrent/Semaphore;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    invoke-virtual {p1}, Ljava/util/concurrent/Semaphore;->release()V

    .line 22
    .line 23
    .line 24
    throw p0
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
.method public final b()V
    .locals 2

    .line 1
    iget-object v0, p0, Ln9/m;->a:Ln9/m$b;

    .line 2
    .line 3
    instance-of v1, v0, Ln9/m$b$b;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    sget-object v1, Ln9/m$b$a;->a:Ln9/m$b$a;

    .line 8
    .line 9
    iput-object v1, p0, Ln9/m;->a:Ln9/m$b;

    .line 10
    .line 11
    check-cast v0, Ln9/m$b$b;

    .line 12
    .line 13
    invoke-virtual {v0}, Ln9/m$b$b;->a()Ljava/util/concurrent/Semaphore;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-virtual {v0}, Ln9/m$b$b;->b()I

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    invoke-virtual {v1, v0}, Ljava/util/concurrent/Semaphore;->acquire(I)V

    .line 22
    .line 23
    .line 24
    return-void

    .line 25
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 26
    .line 27
    const-string v1, "drain() may not be called more than once"

    .line 28
    .line 29
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 30
    .line 31
    .line 32
    throw v0
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

.method public final c(Ljava/lang/Runnable;)V
    .locals 3

    .line 1
    const-string v0, "runnable"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ln9/m;->a:Ln9/m$b;

    .line 7
    .line 8
    instance-of v1, v0, Ln9/m$b$b;

    .line 9
    .line 10
    if-eqz v1, :cond_0

    .line 11
    .line 12
    move-object v1, v0

    .line 13
    check-cast v1, Ln9/m$b$b;

    .line 14
    .line 15
    invoke-virtual {v1}, Ln9/m$b$b;->b()I

    .line 16
    .line 17
    .line 18
    move-result v2

    .line 19
    add-int/lit8 v2, v2, 0x1

    .line 20
    .line 21
    invoke-virtual {v1, v2}, Ln9/m$b$b;->c(I)V

    .line 22
    .line 23
    .line 24
    sget-object v1, Ln9/m;->d:Ljava/util/concurrent/Executor;

    .line 25
    .line 26
    new-instance v2, Ln9/l;

    .line 27
    .line 28
    invoke-direct {v2, p1, v0}, Ln9/l;-><init>(Ljava/lang/Runnable;Ln9/m$b;)V

    .line 29
    .line 30
    .line 31
    invoke-interface {v1, v2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 32
    .line 33
    .line 34
    return-void

    .line 35
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 36
    .line 37
    const-string v0, "submit() may not be called after drain()"

    .line 38
    .line 39
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 40
    .line 41
    .line 42
    throw p1
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
.end method
