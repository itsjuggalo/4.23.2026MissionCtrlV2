.class public final Ltb/g1$t;
.super Lrb/b1$d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "t"
.end annotation


# instance fields
.field public final a:Ltb/g1$s;

.field public final b:Lrb/b1;

.field public final synthetic c:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;Ltb/g1$s;Lrb/b1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 2
    .line 3
    invoke-direct {p0}, Lrb/b1$d;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string p1, "helperImpl"

    .line 7
    .line 8
    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    check-cast p1, Ltb/g1$s;

    .line 13
    .line 14
    iput-object p1, p0, Ltb/g1$t;->a:Ltb/g1$s;

    .line 15
    .line 16
    const-string p1, "resolver"

    .line 17
    .line 18
    invoke-static {p3, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    check-cast p1, Lrb/b1;

    .line 23
    .line 24
    iput-object p1, p0, Ltb/g1$t;->b:Lrb/b1;

    .line 25
    .line 26
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

.method public static synthetic c(Ltb/g1$t;Lrb/k1;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1$t;->d(Lrb/k1;)V

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
.method public a(Lrb/k1;)V
    .locals 2

    .line 1
    invoke-virtual {p1}, Lrb/k1;->p()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    xor-int/lit8 v0, v0, 0x1

    .line 6
    .line 7
    const-string v1, "the error status must not be OK"

    .line 8
    .line 9
    invoke-static {v0, v1}, Lp6/n;->e(ZLjava/lang/Object;)V

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 13
    .line 14
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 15
    .line 16
    new-instance v1, Ltb/g1$t$a;

    .line 17
    .line 18
    invoke-direct {v1, p0, p1}, Ltb/g1$t$a;-><init>(Ltb/g1$t;Lrb/k1;)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 22
    .line 23
    .line 24
    return-void
    .line 25
    .line 26
.end method

.method public b(Lrb/b1$e;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 4
    .line 5
    new-instance v1, Ltb/g1$t$b;

    .line 6
    .line 7
    invoke-direct {v1, p0, p1}, Ltb/g1$t$b;-><init>(Ltb/g1$t;Lrb/b1$e;)V

    .line 8
    .line 9
    .line 10
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 11
    .line 12
    .line 13
    return-void
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

.method public final d(Lrb/k1;)V
    .locals 5

    .line 1
    sget-object v0, Ltb/g1;->m0:Ljava/util/logging/Logger;

    .line 2
    .line 3
    sget-object v1, Ljava/util/logging/Level;->WARNING:Ljava/util/logging/Level;

    .line 4
    .line 5
    iget-object v2, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 6
    .line 7
    invoke-virtual {v2}, Ltb/g1;->f()Lrb/k0;

    .line 8
    .line 9
    .line 10
    move-result-object v2

    .line 11
    filled-new-array {v2, p1}, [Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v2

    .line 15
    const-string v3, "[{0}] Failed to resolve name. status={1}"

    .line 16
    .line 17
    invoke-virtual {v0, v1, v3, v2}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 21
    .line 22
    invoke-static {v0}, Ltb/g1;->o0(Ltb/g1;)Ltb/g1$u;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    invoke-virtual {v0}, Ltb/g1$u;->m()V

    .line 27
    .line 28
    .line 29
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 30
    .line 31
    invoke-static {v0}, Ltb/g1;->i0(Ltb/g1;)Ltb/g1$v;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    sget-object v1, Ltb/g1$v;->c:Ltb/g1$v;

    .line 36
    .line 37
    if-eq v0, v1, :cond_0

    .line 38
    .line 39
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 40
    .line 41
    invoke-static {v0}, Ltb/g1;->z(Ltb/g1;)Lrb/f;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    sget-object v2, Lrb/f$a;->c:Lrb/f$a;

    .line 46
    .line 47
    const-string v3, "Failed to resolve name: {0}"

    .line 48
    .line 49
    filled-new-array {p1}, [Ljava/lang/Object;

    .line 50
    .line 51
    .line 52
    move-result-object v4

    .line 53
    invoke-virtual {v0, v2, v3, v4}, Lrb/f;->b(Lrb/f$a;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 54
    .line 55
    .line 56
    iget-object v0, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 57
    .line 58
    invoke-static {v0, v1}, Ltb/g1;->j0(Ltb/g1;Ltb/g1$v;)Ltb/g1$v;

    .line 59
    .line 60
    .line 61
    :cond_0
    iget-object v0, p0, Ltb/g1$t;->a:Ltb/g1$s;

    .line 62
    .line 63
    iget-object v1, p0, Ltb/g1$t;->c:Ltb/g1;

    .line 64
    .line 65
    invoke-static {v1}, Ltb/g1;->w0(Ltb/g1;)Ltb/g1$s;

    .line 66
    .line 67
    .line 68
    move-result-object v1

    .line 69
    if-eq v0, v1, :cond_1

    .line 70
    .line 71
    return-void

    .line 72
    :cond_1
    iget-object v0, p0, Ltb/g1$t;->a:Ltb/g1$s;

    .line 73
    .line 74
    iget-object v0, v0, Ltb/g1$s;->a:Ltb/i$b;

    .line 75
    .line 76
    invoke-virtual {v0, p1}, Ltb/i$b;->b(Lrb/k1;)V

    .line 77
    .line 78
    .line 79
    return-void
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
