.class public abstract Loc/b$b;
.super Ljava/util/concurrent/atomic/AtomicInteger;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/i;
.implements Loc/b$f;
.implements Lkh/c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Loc/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "b"
.end annotation


# instance fields
.field public final a:Loc/b$e;

.field public final b:Lic/e;

.field public final c:I

.field public final d:I

.field public e:Lkh/c;

.field public f:I

.field public g:Llc/i;

.field public volatile h:Z

.field public volatile i:Z

.field public final j:Lxc/c;

.field public volatile k:Z

.field public l:I


# direct methods
.method public constructor <init>(Lic/e;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Loc/b$b;->b:Lic/e;

    .line 5
    .line 6
    iput p2, p0, Loc/b$b;->c:I

    .line 7
    .line 8
    shr-int/lit8 p1, p2, 0x2

    .line 9
    .line 10
    sub-int/2addr p2, p1

    .line 11
    iput p2, p0, Loc/b$b;->d:I

    .line 12
    .line 13
    new-instance p1, Loc/b$e;

    .line 14
    .line 15
    invoke-direct {p1, p0}, Loc/b$e;-><init>(Loc/b$f;)V

    .line 16
    .line 17
    .line 18
    iput-object p1, p0, Loc/b$b;->a:Loc/b$e;

    .line 19
    .line 20
    new-instance p1, Lxc/c;

    .line 21
    .line 22
    invoke-direct {p1}, Lxc/c;-><init>()V

    .line 23
    .line 24
    .line 25
    iput-object p1, p0, Loc/b$b;->j:Lxc/c;

    .line 26
    .line 27
    return-void
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
.method public final b(Lkh/c;)V
    .locals 3

    .line 1
    iget-object v0, p0, Loc/b$b;->e:Lkh/c;

    .line 2
    .line 3
    invoke-static {v0, p1}, Lwc/g;->m(Lkh/c;Lkh/c;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_2

    .line 8
    .line 9
    iput-object p1, p0, Loc/b$b;->e:Lkh/c;

    .line 10
    .line 11
    instance-of v0, p1, Llc/f;

    .line 12
    .line 13
    if-eqz v0, :cond_1

    .line 14
    .line 15
    move-object v0, p1

    .line 16
    check-cast v0, Llc/f;

    .line 17
    .line 18
    const/4 v1, 0x7

    .line 19
    invoke-interface {v0, v1}, Llc/e;->h(I)I

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    const/4 v2, 0x1

    .line 24
    if-ne v1, v2, :cond_0

    .line 25
    .line 26
    iput v1, p0, Loc/b$b;->l:I

    .line 27
    .line 28
    iput-object v0, p0, Loc/b$b;->g:Llc/i;

    .line 29
    .line 30
    iput-boolean v2, p0, Loc/b$b;->h:Z

    .line 31
    .line 32
    invoke-virtual {p0}, Loc/b$b;->g()V

    .line 33
    .line 34
    .line 35
    invoke-virtual {p0}, Loc/b$b;->f()V

    .line 36
    .line 37
    .line 38
    return-void

    .line 39
    :cond_0
    const/4 v2, 0x2

    .line 40
    if-ne v1, v2, :cond_1

    .line 41
    .line 42
    iput v1, p0, Loc/b$b;->l:I

    .line 43
    .line 44
    iput-object v0, p0, Loc/b$b;->g:Llc/i;

    .line 45
    .line 46
    invoke-virtual {p0}, Loc/b$b;->g()V

    .line 47
    .line 48
    .line 49
    iget v0, p0, Loc/b$b;->c:I

    .line 50
    .line 51
    int-to-long v0, v0

    .line 52
    invoke-interface {p1, v0, v1}, Lkh/c;->request(J)V

    .line 53
    .line 54
    .line 55
    return-void

    .line 56
    :cond_1
    new-instance v0, Ltc/a;

    .line 57
    .line 58
    iget v1, p0, Loc/b$b;->c:I

    .line 59
    .line 60
    invoke-direct {v0, v1}, Ltc/a;-><init>(I)V

    .line 61
    .line 62
    .line 63
    iput-object v0, p0, Loc/b$b;->g:Llc/i;

    .line 64
    .line 65
    invoke-virtual {p0}, Loc/b$b;->g()V

    .line 66
    .line 67
    .line 68
    iget v0, p0, Loc/b$b;->c:I

    .line 69
    .line 70
    int-to-long v0, v0

    .line 71
    invoke-interface {p1, v0, v1}, Lkh/c;->request(J)V

    .line 72
    .line 73
    .line 74
    :cond_2
    return-void
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

.method public final c()V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-boolean v0, p0, Loc/b$b;->k:Z

    .line 3
    .line 4
    invoke-virtual {p0}, Loc/b$b;->f()V

    .line 5
    .line 6
    .line 7
    return-void
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

.method public abstract f()V
.end method

.method public abstract g()V
.end method

.method public final onComplete()V
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    iput-boolean v0, p0, Loc/b$b;->h:Z

    .line 3
    .line 4
    invoke-virtual {p0}, Loc/b$b;->f()V

    .line 5
    .line 6
    .line 7
    return-void
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

.method public final onNext(Ljava/lang/Object;)V
    .locals 2

    .line 1
    iget v0, p0, Loc/b$b;->l:I

    .line 2
    .line 3
    const/4 v1, 0x2

    .line 4
    if-eq v0, v1, :cond_0

    .line 5
    .line 6
    iget-object v0, p0, Loc/b$b;->g:Llc/i;

    .line 7
    .line 8
    invoke-interface {v0, p1}, Llc/i;->offer(Ljava/lang/Object;)Z

    .line 9
    .line 10
    .line 11
    move-result p1

    .line 12
    if-nez p1, :cond_0

    .line 13
    .line 14
    iget-object p1, p0, Loc/b$b;->e:Lkh/c;

    .line 15
    .line 16
    invoke-interface {p1}, Lkh/c;->cancel()V

    .line 17
    .line 18
    .line 19
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 20
    .line 21
    const-string v0, "Queue full?!"

    .line 22
    .line 23
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    invoke-interface {p0, p1}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 27
    .line 28
    .line 29
    return-void

    .line 30
    :cond_0
    invoke-virtual {p0}, Loc/b$b;->f()V

    .line 31
    .line 32
    .line 33
    return-void
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
    .line 98
    .line 99
.end method
