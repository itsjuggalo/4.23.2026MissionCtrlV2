.class public final Lrc/d$a;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lfc/b;
.implements Lcc/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrc/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrc/d$a$a;
    }
.end annotation


# instance fields
.field public final a:Lcc/c;

.field public final b:Lxc/c;

.field public final c:Lic/e;

.field public final d:Z

.field public final e:Lfc/a;

.field public f:Lfc/b;

.field public volatile g:Z


# direct methods
.method public constructor <init>(Lcc/c;Lic/e;Z)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lrc/d$a;->a:Lcc/c;

    .line 5
    .line 6
    iput-object p2, p0, Lrc/d$a;->c:Lic/e;

    .line 7
    .line 8
    iput-boolean p3, p0, Lrc/d$a;->d:Z

    .line 9
    .line 10
    new-instance p1, Lxc/c;

    .line 11
    .line 12
    invoke-direct {p1}, Lxc/c;-><init>()V

    .line 13
    .line 14
    .line 15
    iput-object p1, p0, Lrc/d$a;->b:Lxc/c;

    .line 16
    .line 17
    new-instance p1, Lfc/a;

    .line 18
    .line 19
    invoke-direct {p1}, Lfc/a;-><init>()V

    .line 20
    .line 21
    .line 22
    iput-object p1, p0, Lrc/d$a;->e:Lfc/a;

    .line 23
    .line 24
    const/4 p1, 0x1

    .line 25
    invoke-virtual {p0, p1}, Ljava/util/concurrent/atomic/AtomicInteger;->lazySet(I)V

    .line 26
    .line 27
    .line 28
    return-void
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
.end method


# virtual methods
.method public a(Lfc/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/d$a;->f:Lfc/b;

    .line 2
    .line 3
    invoke-static {v0, p1}, Ljc/b;->m(Lfc/b;Lfc/b;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    iput-object p1, p0, Lrc/d$a;->f:Lfc/b;

    .line 10
    .line 11
    iget-object p1, p0, Lrc/d$a;->a:Lcc/c;

    .line 12
    .line 13
    invoke-interface {p1, p0}, Lcc/c;->a(Lfc/b;)V

    .line 14
    .line 15
    .line 16
    :cond_0
    return-void
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

.method public b(Lrc/d$a$a;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/d$a;->e:Lfc/a;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lfc/a;->b(Lfc/b;)Z

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0}, Lrc/d$a;->onComplete()V

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
.end method

.method public c()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/d$a;->f:Lfc/b;

    .line 2
    .line 3
    invoke-interface {v0}, Lfc/b;->c()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public d(Lrc/d$a$a;Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/d$a;->e:Lfc/a;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lfc/a;->b(Lfc/b;)Z

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0, p2}, Lrc/d$a;->onError(Ljava/lang/Throwable;)V

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

.method public dispose()V
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    iput-boolean v0, p0, Lrc/d$a;->g:Z

    .line 3
    .line 4
    iget-object v0, p0, Lrc/d$a;->f:Lfc/b;

    .line 5
    .line 6
    invoke-interface {v0}, Lfc/b;->dispose()V

    .line 7
    .line 8
    .line 9
    iget-object v0, p0, Lrc/d$a;->e:Lfc/a;

    .line 10
    .line 11
    invoke-virtual {v0}, Lfc/a;->dispose()V

    .line 12
    .line 13
    .line 14
    return-void
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public onComplete()V
    .locals 2

    .line 1
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-nez v0, :cond_1

    .line 6
    .line 7
    iget-object v0, p0, Lrc/d$a;->b:Lxc/c;

    .line 8
    .line 9
    invoke-virtual {v0}, Lxc/c;->b()Ljava/lang/Throwable;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    iget-object v1, p0, Lrc/d$a;->a:Lcc/c;

    .line 16
    .line 17
    invoke-interface {v1, v0}, Lcc/c;->onError(Ljava/lang/Throwable;)V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :cond_0
    iget-object v0, p0, Lrc/d$a;->a:Lcc/c;

    .line 22
    .line 23
    invoke-interface {v0}, Lcc/c;->onComplete()V

    .line 24
    .line 25
    .line 26
    :cond_1
    return-void
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

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/d$a;->b:Lxc/c;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lxc/c;->a(Ljava/lang/Throwable;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_2

    .line 8
    .line 9
    iget-boolean p1, p0, Lrc/d$a;->d:Z

    .line 10
    .line 11
    if-eqz p1, :cond_0

    .line 12
    .line 13
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 14
    .line 15
    .line 16
    move-result p1

    .line 17
    if-nez p1, :cond_1

    .line 18
    .line 19
    iget-object p1, p0, Lrc/d$a;->b:Lxc/c;

    .line 20
    .line 21
    invoke-virtual {p1}, Lxc/c;->b()Ljava/lang/Throwable;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    iget-object v0, p0, Lrc/d$a;->a:Lcc/c;

    .line 26
    .line 27
    invoke-interface {v0, p1}, Lcc/c;->onError(Ljava/lang/Throwable;)V

    .line 28
    .line 29
    .line 30
    return-void

    .line 31
    :cond_0
    invoke-virtual {p0}, Lrc/d$a;->dispose()V

    .line 32
    .line 33
    .line 34
    const/4 p1, 0x0

    .line 35
    invoke-virtual {p0, p1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndSet(I)I

    .line 36
    .line 37
    .line 38
    move-result p1

    .line 39
    if-lez p1, :cond_1

    .line 40
    .line 41
    iget-object p1, p0, Lrc/d$a;->b:Lxc/c;

    .line 42
    .line 43
    invoke-virtual {p1}, Lxc/c;->b()Ljava/lang/Throwable;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    iget-object v0, p0, Lrc/d$a;->a:Lcc/c;

    .line 48
    .line 49
    invoke-interface {v0, p1}, Lcc/c;->onError(Ljava/lang/Throwable;)V

    .line 50
    .line 51
    .line 52
    :cond_1
    return-void

    .line 53
    :cond_2
    invoke-static {p1}, Lyc/a;->q(Ljava/lang/Throwable;)V

    .line 54
    .line 55
    .line 56
    return-void
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

.method public onNext(Ljava/lang/Object;)V
    .locals 2

    .line 1
    :try_start_0
    iget-object v0, p0, Lrc/d$a;->c:Lic/e;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lic/e;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    const-string v0, "The mapper returned a null CompletableSource"

    .line 8
    .line 9
    invoke-static {p1, v0}, Lkc/b;->d(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    check-cast p1, Lcc/d;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 14
    .line 15
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    .line 16
    .line 17
    .line 18
    new-instance v0, Lrc/d$a$a;

    .line 19
    .line 20
    invoke-direct {v0, p0}, Lrc/d$a$a;-><init>(Lrc/d$a;)V

    .line 21
    .line 22
    .line 23
    iget-boolean v1, p0, Lrc/d$a;->g:Z

    .line 24
    .line 25
    if-nez v1, :cond_0

    .line 26
    .line 27
    iget-object v1, p0, Lrc/d$a;->e:Lfc/a;

    .line 28
    .line 29
    invoke-virtual {v1, v0}, Lfc/a;->d(Lfc/b;)Z

    .line 30
    .line 31
    .line 32
    move-result v1

    .line 33
    if-eqz v1, :cond_0

    .line 34
    .line 35
    invoke-interface {p1, v0}, Lcc/d;->a(Lcc/c;)V

    .line 36
    .line 37
    .line 38
    :cond_0
    return-void

    .line 39
    :catchall_0
    move-exception p1

    .line 40
    invoke-static {p1}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 41
    .line 42
    .line 43
    iget-object v0, p0, Lrc/d$a;->f:Lfc/b;

    .line 44
    .line 45
    invoke-interface {v0}, Lfc/b;->dispose()V

    .line 46
    .line 47
    .line 48
    invoke-virtual {p0, p1}, Lrc/d$a;->onError(Ljava/lang/Throwable;)V

    .line 49
    .line 50
    .line 51
    return-void
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
