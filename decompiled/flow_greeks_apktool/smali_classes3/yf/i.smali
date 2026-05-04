.class public final Lyf/i;
.super Lxf/c1;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lbg/d;


# instance fields
.field public final b:Lbg/b;

.field public final c:Lyf/n;

.field public final d:Lxf/l2;

.field public final e:Lxf/q1;

.field public final f:Z

.field public final g:Z


# direct methods
.method public constructor <init>(Lbg/b;Lxf/l2;Lxf/a2;Lfe/l1;)V
    .locals 10

    const-string v0, "captureStatus"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "projection"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "typeParameter"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 10
    new-instance v1, Lyf/n;

    const/4 v6, 0x6

    const/4 v7, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    move-object v2, p3

    move-object v5, p4

    invoke-direct/range {v1 .. v7}, Lyf/n;-><init>(Lxf/a2;Lkotlin/jvm/functions/Function0;Lyf/n;Lfe/l1;ILkotlin/jvm/internal/k;)V

    const/16 v8, 0x38

    const/4 v9, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object v2, p1

    move-object v4, p2

    move-object v3, v1

    move-object v1, p0

    invoke-direct/range {v1 .. v9}, Lyf/i;-><init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZILkotlin/jvm/internal/k;)V

    return-void
.end method

.method public constructor <init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZ)V
    .locals 1

    const-string v0, "captureStatus"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "constructor"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "attributes"

    invoke-static {p4, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    invoke-direct {p0}, Lxf/c1;-><init>()V

    .line 4
    iput-object p1, p0, Lyf/i;->b:Lbg/b;

    .line 5
    iput-object p2, p0, Lyf/i;->c:Lyf/n;

    .line 6
    iput-object p3, p0, Lyf/i;->d:Lxf/l2;

    .line 7
    iput-object p4, p0, Lyf/i;->e:Lxf/q1;

    .line 8
    iput-boolean p5, p0, Lyf/i;->f:Z

    .line 9
    iput-boolean p6, p0, Lyf/i;->g:Z

    return-void
.end method

.method public synthetic constructor <init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZILkotlin/jvm/internal/k;)V
    .locals 7

    and-int/lit8 p8, p7, 0x8

    if-eqz p8, :cond_0

    .line 1
    sget-object p4, Lxf/q1;->b:Lxf/q1$a;

    invoke-virtual {p4}, Lxf/q1$a;->k()Lxf/q1;

    move-result-object p4

    :cond_0
    move-object v4, p4

    and-int/lit8 p4, p7, 0x10

    const/4 p8, 0x0

    if-eqz p4, :cond_1

    move v5, p8

    goto :goto_0

    :cond_1
    move v5, p5

    :goto_0
    and-int/lit8 p4, p7, 0x20

    if-eqz p4, :cond_2

    move v6, p8

    :goto_1
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    goto :goto_2

    :cond_2
    move v6, p6

    goto :goto_1

    .line 2
    :goto_2
    invoke-direct/range {v0 .. v6}, Lyf/i;-><init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZ)V

    return-void
.end method


# virtual methods
.method public L0()Ljava/util/List;
    .locals 1

    .line 1
    invoke-static {}, Ldd/r;->k()Ljava/util/List;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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

.method public M0()Lxf/q1;
    .locals 1

    .line 1
    iget-object v0, p0, Lyf/i;->e:Lxf/q1;

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

.method public bridge synthetic N0()Lxf/u1;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lyf/i;->X0()Lyf/n;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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

.method public O0()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lyf/i;->f:Z

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

.method public bridge synthetic P0(Lyf/g;)Lxf/r0;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lyf/i;->b1(Lyf/g;)Lyf/i;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public bridge synthetic R0(Z)Lxf/l2;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lyf/i;->a1(Z)Lyf/i;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public bridge synthetic S0(Lyf/g;)Lxf/l2;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lyf/i;->b1(Lyf/g;)Lyf/i;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public bridge synthetic T0(Lxf/q1;)Lxf/l2;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lyf/i;->V0(Lxf/q1;)Lxf/c1;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public bridge synthetic U0(Z)Lxf/c1;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lyf/i;->a1(Z)Lyf/i;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
.end method

.method public V0(Lxf/q1;)Lxf/c1;
    .locals 8

    .line 1
    const-string v0, "newAttributes"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    new-instance v1, Lyf/i;

    .line 7
    .line 8
    iget-object v2, p0, Lyf/i;->b:Lbg/b;

    .line 9
    .line 10
    invoke-virtual {p0}, Lyf/i;->X0()Lyf/n;

    .line 11
    .line 12
    .line 13
    move-result-object v3

    .line 14
    iget-object v4, p0, Lyf/i;->d:Lxf/l2;

    .line 15
    .line 16
    invoke-virtual {p0}, Lyf/i;->O0()Z

    .line 17
    .line 18
    .line 19
    move-result v6

    .line 20
    iget-boolean v7, p0, Lyf/i;->g:Z

    .line 21
    .line 22
    move-object v5, p1

    .line 23
    invoke-direct/range {v1 .. v7}, Lyf/i;-><init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZ)V

    .line 24
    .line 25
    .line 26
    return-object v1
.end method

.method public final W0()Lbg/b;
    .locals 1

    .line 1
    iget-object v0, p0, Lyf/i;->b:Lbg/b;

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

.method public X0()Lyf/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lyf/i;->c:Lyf/n;

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

.method public final Y0()Lxf/l2;
    .locals 1

    .line 1
    iget-object v0, p0, Lyf/i;->d:Lxf/l2;

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

.method public final Z0()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lyf/i;->g:Z

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

.method public a1(Z)Lyf/i;
    .locals 9

    .line 1
    new-instance v0, Lyf/i;

    .line 2
    .line 3
    iget-object v1, p0, Lyf/i;->b:Lbg/b;

    .line 4
    .line 5
    invoke-virtual {p0}, Lyf/i;->X0()Lyf/n;

    .line 6
    .line 7
    .line 8
    move-result-object v2

    .line 9
    iget-object v3, p0, Lyf/i;->d:Lxf/l2;

    .line 10
    .line 11
    invoke-virtual {p0}, Lyf/i;->M0()Lxf/q1;

    .line 12
    .line 13
    .line 14
    move-result-object v4

    .line 15
    const/16 v7, 0x20

    .line 16
    .line 17
    const/4 v8, 0x0

    .line 18
    const/4 v6, 0x0

    .line 19
    move v5, p1

    .line 20
    invoke-direct/range {v0 .. v8}, Lyf/i;-><init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZILkotlin/jvm/internal/k;)V

    .line 21
    .line 22
    .line 23
    return-object v0
    .line 24
    .line 25
    .line 26
.end method

.method public b1(Lyf/g;)Lyf/i;
    .locals 10

    .line 1
    const-string v0, "kotlinTypeRefiner"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v2, p0, Lyf/i;->b:Lbg/b;

    .line 7
    .line 8
    invoke-virtual {p0}, Lyf/i;->X0()Lyf/n;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-virtual {v0, p1}, Lyf/n;->q(Lyf/g;)Lyf/n;

    .line 13
    .line 14
    .line 15
    move-result-object v3

    .line 16
    iget-object v0, p0, Lyf/i;->d:Lxf/l2;

    .line 17
    .line 18
    if-eqz v0, :cond_0

    .line 19
    .line 20
    invoke-virtual {p1, v0}, Lyf/g;->h(Lbg/i;)Lxf/r0;

    .line 21
    .line 22
    .line 23
    move-result-object p1

    .line 24
    invoke-virtual {p1}, Lxf/r0;->Q0()Lxf/l2;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    :goto_0
    move-object v4, p1

    .line 29
    goto :goto_1

    .line 30
    :cond_0
    const/4 p1, 0x0

    .line 31
    goto :goto_0

    .line 32
    :goto_1
    invoke-virtual {p0}, Lyf/i;->M0()Lxf/q1;

    .line 33
    .line 34
    .line 35
    move-result-object v5

    .line 36
    invoke-virtual {p0}, Lyf/i;->O0()Z

    .line 37
    .line 38
    .line 39
    move-result v6

    .line 40
    new-instance v1, Lyf/i;

    .line 41
    .line 42
    const/4 v7, 0x0

    .line 43
    const/16 v8, 0x20

    .line 44
    .line 45
    const/4 v9, 0x0

    .line 46
    invoke-direct/range {v1 .. v9}, Lyf/i;-><init>(Lbg/b;Lyf/n;Lxf/l2;Lxf/q1;ZZILkotlin/jvm/internal/k;)V

    .line 47
    .line 48
    .line 49
    return-object v1
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

.method public q()Lqf/k;
    .locals 3

    .line 1
    sget-object v0, Lzf/h;->b:Lzf/h;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/String;

    .line 5
    .line 6
    const/4 v2, 0x1

    .line 7
    invoke-static {v0, v2, v1}, Lzf/l;->a(Lzf/h;Z[Ljava/lang/String;)Lzf/g;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    return-object v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
