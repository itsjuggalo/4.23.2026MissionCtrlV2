.class public final Loc/z;
.super Lcc/s;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Llc/b;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Loc/z$a;
    }
.end annotation


# instance fields
.field public final a:Lcc/f;

.field public final b:Ljava/util/concurrent/Callable;


# direct methods
.method public constructor <init>(Lcc/f;)V
    .locals 1

    .line 1
    invoke-static {}, Lxc/b;->b()Ljava/util/concurrent/Callable;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Loc/z;-><init>(Lcc/f;Ljava/util/concurrent/Callable;)V

    return-void
.end method

.method public constructor <init>(Lcc/f;Ljava/util/concurrent/Callable;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Lcc/s;-><init>()V

    .line 3
    iput-object p1, p0, Loc/z;->a:Lcc/f;

    .line 4
    iput-object p2, p0, Loc/z;->b:Ljava/util/concurrent/Callable;

    return-void
.end method


# virtual methods
.method public c()Lcc/f;
    .locals 3

    .line 1
    new-instance v0, Loc/y;

    .line 2
    .line 3
    iget-object v1, p0, Loc/z;->a:Lcc/f;

    .line 4
    .line 5
    iget-object v2, p0, Loc/z;->b:Ljava/util/concurrent/Callable;

    .line 6
    .line 7
    invoke-direct {v0, v1, v2}, Loc/y;-><init>(Lcc/f;Ljava/util/concurrent/Callable;)V

    .line 8
    .line 9
    .line 10
    invoke-static {v0}, Lyc/a;->k(Lcc/f;)Lcc/f;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    return-object v0
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public j(Lcc/t;)V
    .locals 3

    .line 1
    :try_start_0
    iget-object v0, p0, Loc/z;->b:Ljava/util/concurrent/Callable;

    .line 2
    .line 3
    invoke-interface {v0}, Ljava/util/concurrent/Callable;->call()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."

    .line 8
    .line 9
    invoke-static {v0, v1}, Lkc/b;->d(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    check-cast v0, Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 14
    .line 15
    iget-object v1, p0, Loc/z;->a:Lcc/f;

    .line 16
    .line 17
    new-instance v2, Loc/z$a;

    .line 18
    .line 19
    invoke-direct {v2, p1, v0}, Loc/z$a;-><init>(Lcc/t;Ljava/util/Collection;)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {v1, v2}, Lcc/f;->H(Lcc/i;)V

    .line 23
    .line 24
    .line 25
    return-void

    .line 26
    :catchall_0
    move-exception v0

    .line 27
    invoke-static {v0}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 28
    .line 29
    .line 30
    invoke-static {v0, p1}, Ljc/c;->o(Ljava/lang/Throwable;Lcc/t;)V

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
