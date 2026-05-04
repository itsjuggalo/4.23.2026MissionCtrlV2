.class public final Lpc/o$a;
.super Ljava/util/concurrent/atomic/AtomicReference;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/l;
.implements Lfc/b;
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lpc/o;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lcc/l;

.field public final b:Lcc/r;

.field public c:Ljava/lang/Object;

.field public d:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>(Lcc/l;Lcc/r;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lpc/o$a;->a:Lcc/l;

    .line 5
    .line 6
    iput-object p2, p0, Lpc/o$a;->b:Lcc/r;

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
.method public a(Lfc/b;)V
    .locals 0

    .line 1
    invoke-static {p0, p1}, Ljc/b;->l(Ljava/util/concurrent/atomic/AtomicReference;Lfc/b;)Z

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    iget-object p1, p0, Lpc/o$a;->a:Lcc/l;

    .line 8
    .line 9
    invoke-interface {p1, p0}, Lcc/l;->a(Lfc/b;)V

    .line 10
    .line 11
    .line 12
    :cond_0
    return-void
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
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    check-cast v0, Lfc/b;

    .line 6
    .line 7
    invoke-static {v0}, Ljc/b;->b(Lfc/b;)Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    return v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public dispose()V
    .locals 0

    .line 1
    invoke-static {p0}, Ljc/b;->a(Ljava/util/concurrent/atomic/AtomicReference;)Z

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
.end method

.method public onComplete()V
    .locals 1

    .line 1
    iget-object v0, p0, Lpc/o$a;->b:Lcc/r;

    .line 2
    .line 3
    invoke-virtual {v0, p0}, Lcc/r;->c(Ljava/lang/Runnable;)Lfc/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-static {p0, v0}, Ljc/b;->h(Ljava/util/concurrent/atomic/AtomicReference;Lfc/b;)Z

    .line 8
    .line 9
    .line 10
    return-void
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

.method public onError(Ljava/lang/Throwable;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lpc/o$a;->d:Ljava/lang/Throwable;

    .line 2
    .line 3
    iget-object p1, p0, Lpc/o$a;->b:Lcc/r;

    .line 4
    .line 5
    invoke-virtual {p1, p0}, Lcc/r;->c(Ljava/lang/Runnable;)Lfc/b;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-static {p0, p1}, Ljc/b;->h(Ljava/util/concurrent/atomic/AtomicReference;Lfc/b;)Z

    .line 10
    .line 11
    .line 12
    return-void
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

.method public onSuccess(Ljava/lang/Object;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lpc/o$a;->c:Ljava/lang/Object;

    .line 2
    .line 3
    iget-object p1, p0, Lpc/o$a;->b:Lcc/r;

    .line 4
    .line 5
    invoke-virtual {p1, p0}, Lcc/r;->c(Ljava/lang/Runnable;)Lfc/b;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-static {p0, p1}, Ljc/b;->h(Ljava/util/concurrent/atomic/AtomicReference;Lfc/b;)Z

    .line 10
    .line 11
    .line 12
    return-void
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

.method public run()V
    .locals 2

    .line 1
    iget-object v0, p0, Lpc/o$a;->d:Ljava/lang/Throwable;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    iput-object v1, p0, Lpc/o$a;->d:Ljava/lang/Throwable;

    .line 7
    .line 8
    iget-object v1, p0, Lpc/o$a;->a:Lcc/l;

    .line 9
    .line 10
    invoke-interface {v1, v0}, Lcc/l;->onError(Ljava/lang/Throwable;)V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :cond_0
    iget-object v0, p0, Lpc/o$a;->c:Ljava/lang/Object;

    .line 15
    .line 16
    if-eqz v0, :cond_1

    .line 17
    .line 18
    iput-object v1, p0, Lpc/o$a;->c:Ljava/lang/Object;

    .line 19
    .line 20
    iget-object v1, p0, Lpc/o$a;->a:Lcc/l;

    .line 21
    .line 22
    invoke-interface {v1, v0}, Lcc/l;->onSuccess(Ljava/lang/Object;)V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :cond_1
    iget-object v0, p0, Lpc/o$a;->a:Lcc/l;

    .line 27
    .line 28
    invoke-interface {v0}, Lcc/l;->onComplete()V

    .line 29
    .line 30
    .line 31
    return-void
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
