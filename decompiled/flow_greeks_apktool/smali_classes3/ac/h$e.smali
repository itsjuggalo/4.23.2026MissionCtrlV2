.class public Lac/h$e;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lac/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "e"
.end annotation


# instance fields
.field public a:Lac/h$g;

.field public b:Lrb/f;

.field public final synthetic c:Lac/h;


# direct methods
.method public constructor <init>(Lac/h;Lac/h$g;Lrb/f;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lac/h$e;->c:Lac/h;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Lac/h$e;->a:Lac/h$g;

    .line 7
    .line 8
    iput-object p3, p0, Lac/h$e;->b:Lrb/f;

    .line 9
    .line 10
    return-void
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


# virtual methods
.method public run()V
    .locals 6

    .line 1
    iget-object v0, p0, Lac/h$e;->c:Lac/h;

    .line 2
    .line 3
    invoke-static {v0}, Lac/h;->i(Lac/h;)Ltb/q2;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-interface {v1}, Ltb/q2;->a()J

    .line 8
    .line 9
    .line 10
    move-result-wide v1

    .line 11
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    invoke-static {v0, v1}, Lac/h;->h(Lac/h;Ljava/lang/Long;)Ljava/lang/Long;

    .line 16
    .line 17
    .line 18
    iget-object v0, p0, Lac/h$e;->c:Lac/h;

    .line 19
    .line 20
    iget-object v0, v0, Lac/h;->g:Lac/h$c;

    .line 21
    .line 22
    invoke-virtual {v0}, Lac/h$c;->i()V

    .line 23
    .line 24
    .line 25
    iget-object v0, p0, Lac/h$e;->a:Lac/h$g;

    .line 26
    .line 27
    iget-object v1, p0, Lac/h$e;->b:Lrb/f;

    .line 28
    .line 29
    invoke-static {v0, v1}, Lac/h$j;->b(Lac/h$g;Lrb/f;)Ljava/util/List;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 38
    .line 39
    .line 40
    move-result v1

    .line 41
    if-eqz v1, :cond_0

    .line 42
    .line 43
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 44
    .line 45
    .line 46
    move-result-object v1

    .line 47
    check-cast v1, Lac/h$j;

    .line 48
    .line 49
    iget-object v2, p0, Lac/h$e;->c:Lac/h;

    .line 50
    .line 51
    iget-object v3, v2, Lac/h;->g:Lac/h$c;

    .line 52
    .line 53
    invoke-static {v2}, Lac/h;->g(Lac/h;)Ljava/lang/Long;

    .line 54
    .line 55
    .line 56
    move-result-object v2

    .line 57
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    .line 58
    .line 59
    .line 60
    move-result-wide v4

    .line 61
    invoke-interface {v1, v3, v4, v5}, Lac/h$j;->a(Lac/h$c;J)V

    .line 62
    .line 63
    .line 64
    goto :goto_0

    .line 65
    :cond_0
    iget-object v0, p0, Lac/h$e;->c:Lac/h;

    .line 66
    .line 67
    iget-object v1, v0, Lac/h;->g:Lac/h$c;

    .line 68
    .line 69
    invoke-static {v0}, Lac/h;->g(Lac/h;)Ljava/lang/Long;

    .line 70
    .line 71
    .line 72
    move-result-object v0

    .line 73
    invoke-virtual {v1, v0}, Lac/h$c;->f(Ljava/lang/Long;)V

    .line 74
    .line 75
    .line 76
    return-void
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method
