.class public Lac/h$d;
.super Lac/c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lac/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "d"
.end annotation


# instance fields
.field public a:Lrb/r0$e;

.field public final synthetic b:Lac/h;


# direct methods
.method public constructor <init>(Lac/h;Lrb/r0$e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lac/h$d;->b:Lac/h;

    .line 2
    .line 3
    invoke-direct {p0}, Lac/c;-><init>()V

    .line 4
    .line 5
    .line 6
    new-instance p1, Lac/f;

    .line 7
    .line 8
    invoke-direct {p1, p2}, Lac/f;-><init>(Lrb/r0$e;)V

    .line 9
    .line 10
    .line 11
    iput-object p1, p0, Lac/h$d;->a:Lrb/r0$e;

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
.method public a(Lrb/r0$b;)Lrb/r0$i;
    .locals 4

    .line 1
    new-instance v0, Lac/h$i;

    .line 2
    .line 3
    iget-object v1, p0, Lac/h$d;->b:Lac/h;

    .line 4
    .line 5
    iget-object v2, p0, Lac/h$d;->a:Lrb/r0$e;

    .line 6
    .line 7
    invoke-direct {v0, v1, p1, v2}, Lac/h$i;-><init>(Lac/h;Lrb/r0$b;Lrb/r0$e;)V

    .line 8
    .line 9
    .line 10
    invoke-virtual {p1}, Lrb/r0$b;->a()Ljava/util/List;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    invoke-static {p1}, Lac/h;->j(Ljava/util/List;)Z

    .line 15
    .line 16
    .line 17
    move-result v1

    .line 18
    if-eqz v1, :cond_0

    .line 19
    .line 20
    iget-object v1, p0, Lac/h$d;->b:Lac/h;

    .line 21
    .line 22
    iget-object v1, v1, Lac/h;->g:Lac/h$c;

    .line 23
    .line 24
    const/4 v2, 0x0

    .line 25
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 26
    .line 27
    .line 28
    move-result-object v3

    .line 29
    check-cast v3, Lrb/x;

    .line 30
    .line 31
    invoke-virtual {v3}, Lrb/x;->a()Ljava/util/List;

    .line 32
    .line 33
    .line 34
    move-result-object v3

    .line 35
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 36
    .line 37
    .line 38
    move-result-object v3

    .line 39
    invoke-virtual {v1, v3}, Lq6/g;->containsKey(Ljava/lang/Object;)Z

    .line 40
    .line 41
    .line 42
    move-result v1

    .line 43
    if-eqz v1, :cond_0

    .line 44
    .line 45
    iget-object v1, p0, Lac/h$d;->b:Lac/h;

    .line 46
    .line 47
    iget-object v1, v1, Lac/h;->g:Lac/h$c;

    .line 48
    .line 49
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 50
    .line 51
    .line 52
    move-result-object p1

    .line 53
    check-cast p1, Lrb/x;

    .line 54
    .line 55
    invoke-virtual {p1}, Lrb/x;->a()Ljava/util/List;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 60
    .line 61
    .line 62
    move-result-object p1

    .line 63
    invoke-virtual {v1, p1}, Lq6/g;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    .line 65
    .line 66
    move-result-object p1

    .line 67
    check-cast p1, Lac/h$b;

    .line 68
    .line 69
    invoke-virtual {p1, v0}, Lac/h$b;->b(Lac/h$i;)Z

    .line 70
    .line 71
    .line 72
    invoke-static {p1}, Lac/h$b;->a(Lac/h$b;)Ljava/lang/Long;

    .line 73
    .line 74
    .line 75
    move-result-object p1

    .line 76
    if-eqz p1, :cond_0

    .line 77
    .line 78
    invoke-virtual {v0}, Lac/h$i;->n()V

    .line 79
    .line 80
    .line 81
    :cond_0
    return-object v0
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

.method public f(Lrb/p;Lrb/r0$j;)V
    .locals 3

    .line 1
    iget-object v0, p0, Lac/h$d;->a:Lrb/r0$e;

    .line 2
    .line 3
    new-instance v1, Lac/h$h;

    .line 4
    .line 5
    iget-object v2, p0, Lac/h$d;->b:Lac/h;

    .line 6
    .line 7
    invoke-direct {v1, v2, p2}, Lac/h$h;-><init>(Lac/h;Lrb/r0$j;)V

    .line 8
    .line 9
    .line 10
    invoke-virtual {v0, p1, v1}, Lrb/r0$e;->f(Lrb/p;Lrb/r0$j;)V

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

.method public g()Lrb/r0$e;
    .locals 1

    .line 1
    iget-object v0, p0, Lac/h$d;->a:Lrb/r0$e;

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
