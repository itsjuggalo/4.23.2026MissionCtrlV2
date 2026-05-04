.class public final Lac/f;
.super Lac/c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lac/f$a;
    }
.end annotation


# instance fields
.field public final a:Lrb/r0$e;


# direct methods
.method public constructor <init>(Lrb/r0$e;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Lac/c;-><init>()V

    .line 2
    .line 3
    .line 4
    const-string v0, "helper"

    .line 5
    .line 6
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    check-cast p1, Lrb/r0$e;

    .line 11
    .line 12
    iput-object p1, p0, Lac/f;->a:Lrb/r0$e;

    .line 13
    .line 14
    return-void
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
.method public a(Lrb/r0$b;)Lrb/r0$i;
    .locals 3

    .line 1
    sget-object v0, Lrb/r0;->c:Lrb/r0$b$b;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Lrb/r0$b;->c(Lrb/r0$b$b;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lrb/r0$k;

    .line 8
    .line 9
    invoke-super {p0, p1}, Lac/c;->a(Lrb/r0$b;)Lrb/r0$i;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    invoke-virtual {p1}, Lrb/r0$i;->c()Lrb/a;

    .line 16
    .line 17
    .line 18
    move-result-object v1

    .line 19
    sget-object v2, Lrb/r0;->d:Lrb/a$c;

    .line 20
    .line 21
    invoke-virtual {v1, v2}, Lrb/a;->b(Lrb/a$c;)Ljava/lang/Object;

    .line 22
    .line 23
    .line 24
    move-result-object v1

    .line 25
    if-nez v1, :cond_0

    .line 26
    .line 27
    new-instance v1, Lac/f$a;

    .line 28
    .line 29
    invoke-direct {v1, p1, v0}, Lac/f$a;-><init>(Lrb/r0$i;Lrb/r0$k;)V

    .line 30
    .line 31
    .line 32
    return-object v1

    .line 33
    :cond_0
    return-object p1
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

.method public g()Lrb/r0$e;
    .locals 1

    .line 1
    iget-object v0, p0, Lac/f;->a:Lrb/r0$e;

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
