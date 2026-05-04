.class public final Ltb/g0;
.super Ltb/o1;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public b:Z

.field public final c:Lrb/k1;

.field public final d:Ltb/s$a;

.field public final e:[Lrb/k;


# direct methods
.method public constructor <init>(Lrb/k1;Ltb/s$a;[Lrb/k;)V
    .locals 2

    .line 2
    invoke-direct {p0}, Ltb/o1;-><init>()V

    .line 3
    invoke-virtual {p1}, Lrb/k1;->p()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    const-string v1, "error must not be OK"

    invoke-static {v0, v1}, Lp6/n;->e(ZLjava/lang/Object;)V

    .line 4
    iput-object p1, p0, Ltb/g0;->c:Lrb/k1;

    .line 5
    iput-object p2, p0, Ltb/g0;->d:Ltb/s$a;

    .line 6
    iput-object p3, p0, Ltb/g0;->e:[Lrb/k;

    return-void
.end method

.method public constructor <init>(Lrb/k1;[Lrb/k;)V
    .locals 1

    .line 1
    sget-object v0, Ltb/s$a;->a:Ltb/s$a;

    invoke-direct {p0, p1, v0, p2}, Ltb/g0;-><init>(Lrb/k1;Ltb/s$a;[Lrb/k;)V

    return-void
.end method


# virtual methods
.method public j(Ltb/s;)V
    .locals 5

    .line 1
    iget-boolean v0, p0, Ltb/g0;->b:Z

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    xor-int/2addr v0, v1

    .line 5
    const-string v2, "already started"

    .line 6
    .line 7
    invoke-static {v0, v2}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 8
    .line 9
    .line 10
    iput-boolean v1, p0, Ltb/g0;->b:Z

    .line 11
    .line 12
    iget-object v0, p0, Ltb/g0;->e:[Lrb/k;

    .line 13
    .line 14
    array-length v1, v0

    .line 15
    const/4 v2, 0x0

    .line 16
    :goto_0
    if-ge v2, v1, :cond_0

    .line 17
    .line 18
    aget-object v3, v0, v2

    .line 19
    .line 20
    iget-object v4, p0, Ltb/g0;->c:Lrb/k1;

    .line 21
    .line 22
    invoke-virtual {v3, v4}, Lrb/n1;->i(Lrb/k1;)V

    .line 23
    .line 24
    .line 25
    add-int/lit8 v2, v2, 0x1

    .line 26
    .line 27
    goto :goto_0

    .line 28
    :cond_0
    iget-object v0, p0, Ltb/g0;->c:Lrb/k1;

    .line 29
    .line 30
    iget-object v1, p0, Ltb/g0;->d:Ltb/s$a;

    .line 31
    .line 32
    new-instance v2, Lrb/y0;

    .line 33
    .line 34
    invoke-direct {v2}, Lrb/y0;-><init>()V

    .line 35
    .line 36
    .line 37
    invoke-interface {p1, v0, v1, v2}, Ltb/s;->d(Lrb/k1;Ltb/s$a;Lrb/y0;)V

    .line 38
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

.method public l(Ltb/x0;)V
    .locals 2

    .line 1
    const-string v0, "error"

    .line 2
    .line 3
    iget-object v1, p0, Ltb/g0;->c:Lrb/k1;

    .line 4
    .line 5
    invoke-virtual {p1, v0, v1}, Ltb/x0;->b(Ljava/lang/String;Ljava/lang/Object;)Ltb/x0;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    const-string v0, "progress"

    .line 10
    .line 11
    iget-object v1, p0, Ltb/g0;->d:Ltb/s$a;

    .line 12
    .line 13
    invoke-virtual {p1, v0, v1}, Ltb/x0;->b(Ljava/lang/String;Ljava/lang/Object;)Ltb/x0;

    .line 14
    .line 15
    .line 16
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
