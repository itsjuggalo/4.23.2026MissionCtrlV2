.class public interface abstract Lac/h$j;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lac/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "j"
.end annotation


# direct methods
.method public static b(Lac/h$g;Lrb/f;)Ljava/util/List;
    .locals 2

    .line 1
    invoke-static {}, Lq6/k;->r()Lq6/k$a;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget-object v1, p0, Lac/h$g;->e:Lac/h$g$c;

    .line 6
    .line 7
    if-eqz v1, :cond_0

    .line 8
    .line 9
    new-instance v1, Lac/h$k;

    .line 10
    .line 11
    invoke-direct {v1, p0, p1}, Lac/h$k;-><init>(Lac/h$g;Lrb/f;)V

    .line 12
    .line 13
    .line 14
    invoke-virtual {v0, v1}, Lq6/k$a;->h(Ljava/lang/Object;)Lq6/k$a;

    .line 15
    .line 16
    .line 17
    :cond_0
    iget-object v1, p0, Lac/h$g;->f:Lac/h$g$b;

    .line 18
    .line 19
    if-eqz v1, :cond_1

    .line 20
    .line 21
    new-instance v1, Lac/h$f;

    .line 22
    .line 23
    invoke-direct {v1, p0, p1}, Lac/h$f;-><init>(Lac/h$g;Lrb/f;)V

    .line 24
    .line 25
    .line 26
    invoke-virtual {v0, v1}, Lq6/k$a;->h(Ljava/lang/Object;)Lq6/k$a;

    .line 27
    .line 28
    .line 29
    :cond_1
    invoke-virtual {v0}, Lq6/k$a;->k()Lq6/k;

    .line 30
    .line 31
    .line 32
    move-result-object p0

    .line 33
    return-object p0
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
.method public abstract a(Lac/h$c;J)V
.end method
