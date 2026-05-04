.class public final Llf/s$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Llf/s;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Llf/s$a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lxf/r0;)Llf/g;
    .locals 5

    .line 1
    const-string v0, "argumentType"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-static {p1}, Lxf/v0;->a(Lxf/r0;)Z

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    const/4 v1, 0x0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    return-object v1

    .line 14
    :cond_0
    const/4 v0, 0x0

    .line 15
    move-object v2, p1

    .line 16
    move v3, v0

    .line 17
    :goto_0
    invoke-static {v2}, Lce/i;->d0(Lxf/r0;)Z

    .line 18
    .line 19
    .line 20
    move-result v4

    .line 21
    if-eqz v4, :cond_1

    .line 22
    .line 23
    invoke-virtual {v2}, Lxf/r0;->L0()Ljava/util/List;

    .line 24
    .line 25
    .line 26
    move-result-object v2

    .line 27
    invoke-static {v2}, Ldd/a0;->v0(Ljava/util/List;)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v2

    .line 31
    check-cast v2, Lxf/a2;

    .line 32
    .line 33
    invoke-interface {v2}, Lxf/a2;->getType()Lxf/r0;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    add-int/lit8 v3, v3, 0x1

    .line 38
    .line 39
    goto :goto_0

    .line 40
    :cond_1
    invoke-virtual {v2}, Lxf/r0;->N0()Lxf/u1;

    .line 41
    .line 42
    .line 43
    move-result-object v2

    .line 44
    invoke-interface {v2}, Lxf/u1;->b()Lfe/h;

    .line 45
    .line 46
    .line 47
    move-result-object v2

    .line 48
    instance-of v4, v2, Lfe/e;

    .line 49
    .line 50
    if-eqz v4, :cond_3

    .line 51
    .line 52
    invoke-static {v2}, Lnf/e;->n(Lfe/h;)Lef/b;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    if-nez v0, :cond_2

    .line 57
    .line 58
    new-instance v0, Llf/s;

    .line 59
    .line 60
    new-instance v1, Llf/s$b$a;

    .line 61
    .line 62
    invoke-direct {v1, p1}, Llf/s$b$a;-><init>(Lxf/r0;)V

    .line 63
    .line 64
    .line 65
    invoke-direct {v0, v1}, Llf/s;-><init>(Llf/s$b;)V

    .line 66
    .line 67
    .line 68
    return-object v0

    .line 69
    :cond_2
    new-instance p1, Llf/s;

    .line 70
    .line 71
    invoke-direct {p1, v0, v3}, Llf/s;-><init>(Lef/b;I)V

    .line 72
    .line 73
    .line 74
    return-object p1

    .line 75
    :cond_3
    instance-of p1, v2, Lfe/l1;

    .line 76
    .line 77
    if-eqz p1, :cond_4

    .line 78
    .line 79
    new-instance p1, Llf/s;

    .line 80
    .line 81
    sget-object v1, Lef/b;->d:Lef/b$a;

    .line 82
    .line 83
    sget-object v2, Lce/o$a;->b:Lef/d;

    .line 84
    .line 85
    invoke-virtual {v2}, Lef/d;->m()Lef/c;

    .line 86
    .line 87
    .line 88
    move-result-object v2

    .line 89
    invoke-virtual {v1, v2}, Lef/b$a;->c(Lef/c;)Lef/b;

    .line 90
    .line 91
    .line 92
    move-result-object v1

    .line 93
    invoke-direct {p1, v1, v0}, Llf/s;-><init>(Lef/b;I)V

    .line 94
    .line 95
    .line 96
    return-object p1

    .line 97
    :cond_4
    return-object v1
    .line 98
    .line 99
.end method
