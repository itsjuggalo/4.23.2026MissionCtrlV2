.class public Lub/h;
.super Ltb/a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lub/h$b;,
        Lub/h$a;
    }
.end annotation


# static fields
.field public static final p:Lhh/d;


# instance fields
.field public final h:Lrb/z0;

.field public final i:Ljava/lang/String;

.field public final j:Ltb/n2;

.field public k:Ljava/lang/String;

.field public final l:Lub/h$b;

.field public final m:Lub/h$a;

.field public final n:Lrb/a;

.field public o:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lhh/d;

    .line 2
    .line 3
    invoke-direct {v0}, Lhh/d;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lub/h;->p:Lhh/d;

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
.end method

.method public constructor <init>(Lrb/z0;Lrb/y0;Lub/b;Lub/i;Lub/r;Ljava/lang/Object;IILjava/lang/String;Ljava/lang/String;Ltb/n2;Ltb/t2;Lrb/c;Z)V
    .locals 10

    .line 1
    new-instance v1, Lub/q;

    .line 2
    .line 3
    invoke-direct {v1}, Lub/q;-><init>()V

    .line 4
    .line 5
    .line 6
    const/4 v7, 0x0

    .line 7
    if-eqz p14, :cond_0

    .line 8
    .line 9
    invoke-virtual {p1}, Lrb/z0;->f()Z

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    const/4 v0, 0x1

    .line 16
    move v6, v0

    .line 17
    move-object v4, p2

    .line 18
    move-object/from16 v2, p11

    .line 19
    .line 20
    move-object/from16 v3, p12

    .line 21
    .line 22
    move-object/from16 v5, p13

    .line 23
    .line 24
    move-object v0, p0

    .line 25
    goto :goto_0

    .line 26
    :cond_0
    move v6, v7

    .line 27
    move-object v0, p0

    .line 28
    move-object v4, p2

    .line 29
    move-object/from16 v2, p11

    .line 30
    .line 31
    move-object/from16 v3, p12

    .line 32
    .line 33
    move-object/from16 v5, p13

    .line 34
    .line 35
    :goto_0
    invoke-direct/range {v0 .. v6}, Ltb/a;-><init>(Ltb/v2;Ltb/n2;Ltb/t2;Lrb/y0;Lrb/c;Z)V

    .line 36
    .line 37
    .line 38
    new-instance v0, Lub/h$a;

    .line 39
    .line 40
    invoke-direct {v0, p0}, Lub/h$a;-><init>(Lub/h;)V

    .line 41
    .line 42
    .line 43
    iput-object v0, p0, Lub/h;->m:Lub/h$a;

    .line 44
    .line 45
    iput-boolean v7, p0, Lub/h;->o:Z

    .line 46
    .line 47
    const-string v0, "statsTraceCtx"

    .line 48
    .line 49
    move-object/from16 v2, p11

    .line 50
    .line 51
    invoke-static {v2, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    .line 53
    .line 54
    move-result-object v0

    .line 55
    check-cast v0, Ltb/n2;

    .line 56
    .line 57
    iput-object v0, p0, Lub/h;->j:Ltb/n2;

    .line 58
    .line 59
    iput-object p1, p0, Lub/h;->h:Lrb/z0;

    .line 60
    .line 61
    move-object/from16 v3, p9

    .line 62
    .line 63
    iput-object v3, p0, Lub/h;->k:Ljava/lang/String;

    .line 64
    .line 65
    move-object/from16 v3, p10

    .line 66
    .line 67
    iput-object v3, p0, Lub/h;->i:Ljava/lang/String;

    .line 68
    .line 69
    invoke-virtual {p4}, Lub/i;->getAttributes()Lrb/a;

    .line 70
    .line 71
    .line 72
    move-result-object v3

    .line 73
    iput-object v3, p0, Lub/h;->n:Lrb/a;

    .line 74
    .line 75
    new-instance v0, Lub/h$b;

    .line 76
    .line 77
    invoke-virtual {p1}, Lrb/z0;->c()Ljava/lang/String;

    .line 78
    .line 79
    .line 80
    move-result-object v9

    .line 81
    move-object v1, p0

    .line 82
    move-object v5, p3

    .line 83
    move-object v7, p4

    .line 84
    move-object v6, p5

    .line 85
    move-object/from16 v4, p6

    .line 86
    .line 87
    move/from16 v8, p8

    .line 88
    .line 89
    move-object v3, v2

    .line 90
    move/from16 v2, p7

    .line 91
    .line 92
    invoke-direct/range {v0 .. v9}, Lub/h$b;-><init>(Lub/h;ILtb/n2;Ljava/lang/Object;Lub/b;Lub/r;Lub/i;ILjava/lang/String;)V

    .line 93
    .line 94
    .line 95
    iput-object v0, p0, Lub/h;->l:Lub/h$b;

    .line 96
    .line 97
    return-void
.end method

.method public static synthetic A(Lub/h;)Lrb/z0;
    .locals 0

    .line 1
    iget-object p0, p0, Lub/h;->h:Lrb/z0;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic B(Lub/h;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Lub/h;->o:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic C(Lub/h;)Ltb/t2;
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/a;->w()Ltb/t2;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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

.method public static synthetic D(Lub/h;Z)Z
    .locals 0

    .line 1
    iput-boolean p1, p0, Lub/h;->o:Z

    .line 2
    .line 3
    return p1
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

.method public static synthetic E(Lub/h;)Ltb/n2;
    .locals 0

    .line 1
    iget-object p0, p0, Lub/h;->j:Ltb/n2;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic F(Lub/h;)Ljava/lang/String;
    .locals 0

    .line 1
    iget-object p0, p0, Lub/h;->k:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic G(Lub/h;)Ljava/lang/String;
    .locals 0

    .line 1
    iget-object p0, p0, Lub/h;->i:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic H(Lub/h;)Lub/h$b;
    .locals 0

    .line 1
    iget-object p0, p0, Lub/h;->l:Lub/h$b;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic I()Lhh/d;
    .locals 1

    .line 1
    sget-object v0, Lub/h;->p:Lhh/d;

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

.method public static synthetic J(Lub/h;I)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/c;->s(I)V

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

.method public static synthetic K(Lub/h;)Ltb/t2;
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/a;->w()Ltb/t2;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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


# virtual methods
.method public L()Lrb/z0$d;
    .locals 1

    .line 1
    iget-object v0, p0, Lub/h;->h:Lrb/z0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/z0;->e()Lrb/z0$d;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public M()Lub/h$b;
    .locals 1

    .line 1
    iget-object v0, p0, Lub/h;->l:Lub/h$b;

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

.method public N()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Lub/h;->o:Z

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

.method public getAttributes()Lrb/a;
    .locals 1

    .line 1
    iget-object v0, p0, Lub/h;->n:Lrb/a;

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

.method public h(Ljava/lang/String;)V
    .locals 1

    .line 1
    const-string v0, "authority"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    check-cast p1, Ljava/lang/String;

    .line 8
    .line 9
    iput-object p1, p0, Lub/h;->k:Ljava/lang/String;

    .line 10
    .line 11
    return-void
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

.method public bridge synthetic t()Ltb/c$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lub/h;->M()Lub/h$b;

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

.method public bridge synthetic u()Ltb/a$b;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lub/h;->z()Lub/h$a;

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

.method public bridge synthetic y()Ltb/a$c;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lub/h;->M()Lub/h$b;

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

.method public z()Lub/h$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lub/h;->m:Lub/h$a;

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
