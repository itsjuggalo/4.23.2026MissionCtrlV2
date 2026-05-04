.class public final Loc/c;
.super Lcc/f;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Loc/c$f;,
        Loc/c$c;,
        Loc/c$e;,
        Loc/c$d;,
        Loc/c$h;,
        Loc/c$g;,
        Loc/c$b;
    }
.end annotation


# instance fields
.field public final b:Lcc/h;

.field public final c:Lcc/a;


# direct methods
.method public constructor <init>(Lcc/h;Lcc/a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcc/f;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Loc/c;->b:Lcc/h;

    .line 5
    .line 6
    iput-object p2, p0, Loc/c;->c:Lcc/a;

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
.method public I(Lkh/b;)V
    .locals 2

    .line 1
    sget-object v0, Loc/c$a;->a:[I

    .line 2
    .line 3
    iget-object v1, p0, Loc/c;->c:Lcc/a;

    .line 4
    .line 5
    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    aget v0, v0, v1

    .line 10
    .line 11
    const/4 v1, 0x1

    .line 12
    if-eq v0, v1, :cond_3

    .line 13
    .line 14
    const/4 v1, 0x2

    .line 15
    if-eq v0, v1, :cond_2

    .line 16
    .line 17
    const/4 v1, 0x3

    .line 18
    if-eq v0, v1, :cond_1

    .line 19
    .line 20
    const/4 v1, 0x4

    .line 21
    if-eq v0, v1, :cond_0

    .line 22
    .line 23
    new-instance v0, Loc/c$c;

    .line 24
    .line 25
    invoke-static {}, Lcc/f;->b()I

    .line 26
    .line 27
    .line 28
    move-result v1

    .line 29
    invoke-direct {v0, p1, v1}, Loc/c$c;-><init>(Lkh/b;I)V

    .line 30
    .line 31
    .line 32
    goto :goto_0

    .line 33
    :cond_0
    new-instance v0, Loc/c$f;

    .line 34
    .line 35
    invoke-direct {v0, p1}, Loc/c$f;-><init>(Lkh/b;)V

    .line 36
    .line 37
    .line 38
    goto :goto_0

    .line 39
    :cond_1
    new-instance v0, Loc/c$d;

    .line 40
    .line 41
    invoke-direct {v0, p1}, Loc/c$d;-><init>(Lkh/b;)V

    .line 42
    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_2
    new-instance v0, Loc/c$e;

    .line 46
    .line 47
    invoke-direct {v0, p1}, Loc/c$e;-><init>(Lkh/b;)V

    .line 48
    .line 49
    .line 50
    goto :goto_0

    .line 51
    :cond_3
    new-instance v0, Loc/c$g;

    .line 52
    .line 53
    invoke-direct {v0, p1}, Loc/c$g;-><init>(Lkh/b;)V

    .line 54
    .line 55
    .line 56
    :goto_0
    invoke-interface {p1, v0}, Lkh/b;->b(Lkh/c;)V

    .line 57
    .line 58
    .line 59
    :try_start_0
    iget-object p1, p0, Loc/c;->b:Lcc/h;

    .line 60
    .line 61
    invoke-interface {p1, v0}, Lcc/h;->a(Lcc/g;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 62
    .line 63
    .line 64
    return-void

    .line 65
    :catchall_0
    move-exception p1

    .line 66
    invoke-static {p1}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 67
    .line 68
    .line 69
    invoke-virtual {v0, p1}, Loc/c$b;->d(Ljava/lang/Throwable;)V

    .line 70
    .line 71
    .line 72
    return-void
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
