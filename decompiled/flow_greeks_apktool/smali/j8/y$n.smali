.class public Lj8/y$n;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lj8/y;->C(Lj8/z;)Ljava/util/List;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lj8/z;

.field public final synthetic b:Lj8/y;


# direct methods
.method public constructor <init>(Lj8/y;Lj8/z;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lj8/y$n;->b:Lj8/y;

    .line 2
    .line 3
    iput-object p2, p0, Lj8/y$n;->a:Lj8/z;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
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
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 4

    .line 1
    iget-object v0, p0, Lj8/y$n;->b:Lj8/y;

    .line 2
    .line 3
    iget-object v1, p0, Lj8/y$n;->a:Lj8/z;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lj8/y;->l(Lj8/y;Lj8/z;)Lo8/i;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    iget-object v1, p0, Lj8/y$n;->b:Lj8/y;

    .line 12
    .line 13
    invoke-static {v1}, Lj8/y;->c(Lj8/y;)Ll8/e;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-interface {v1, v0}, Ll8/e;->n(Lo8/i;)V

    .line 18
    .line 19
    .line 20
    new-instance v1, Lk8/b;

    .line 21
    .line 22
    invoke-virtual {v0}, Lo8/i;->d()Lo8/h;

    .line 23
    .line 24
    .line 25
    move-result-object v2

    .line 26
    invoke-static {v2}, Lk8/e;->a(Lo8/h;)Lk8/e;

    .line 27
    .line 28
    .line 29
    move-result-object v2

    .line 30
    invoke-static {}, Lj8/l;->G()Lj8/l;

    .line 31
    .line 32
    .line 33
    move-result-object v3

    .line 34
    invoke-direct {v1, v2, v3}, Lk8/b;-><init>(Lk8/e;Lj8/l;)V

    .line 35
    .line 36
    .line 37
    iget-object v2, p0, Lj8/y$n;->b:Lj8/y;

    .line 38
    .line 39
    invoke-static {v2, v0, v1}, Lj8/y;->m(Lj8/y;Lo8/i;Lk8/d;)Ljava/util/List;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    return-object v0

    .line 44
    :cond_0
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 45
    .line 46
    return-object v0
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
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lj8/y$n;->a()Ljava/util/List;

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
.end method
