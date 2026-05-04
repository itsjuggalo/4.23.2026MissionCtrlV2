.class public Lj8/n$t$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lj8/n$t;->b(Lo8/i;Lj8/z;Lh8/g;Lj8/y$p;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lo8/i;

.field public final synthetic b:Lj8/y$p;

.field public final synthetic c:Lj8/n$t;


# direct methods
.method public constructor <init>(Lj8/n$t;Lo8/i;Lj8/y$p;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lj8/n$t$a;->c:Lj8/n$t;

    .line 2
    .line 3
    iput-object p2, p0, Lj8/n$t$a;->a:Lo8/i;

    .line 4
    .line 5
    iput-object p3, p0, Lj8/n$t$a;->b:Lj8/y$p;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
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
.end method


# virtual methods
.method public run()V
    .locals 3

    .line 1
    iget-object v0, p0, Lj8/n$t$a;->c:Lj8/n$t;

    .line 2
    .line 3
    iget-object v0, v0, Lj8/n$t;->a:Lj8/n;

    .line 4
    .line 5
    invoke-static {v0}, Lj8/n;->u(Lj8/n;)Lj8/u;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    iget-object v1, p0, Lj8/n$t$a;->a:Lo8/i;

    .line 10
    .line 11
    invoke-virtual {v1}, Lo8/i;->e()Lj8/l;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    invoke-virtual {v0, v1}, Lj8/u;->a(Lj8/l;)Lr8/n;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    invoke-interface {v0}, Lr8/n;->isEmpty()Z

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-nez v1, :cond_0

    .line 24
    .line 25
    iget-object v1, p0, Lj8/n$t$a;->c:Lj8/n$t;

    .line 26
    .line 27
    iget-object v1, v1, Lj8/n$t;->a:Lj8/n;

    .line 28
    .line 29
    invoke-static {v1}, Lj8/n;->x(Lj8/n;)Lj8/y;

    .line 30
    .line 31
    .line 32
    move-result-object v1

    .line 33
    iget-object v2, p0, Lj8/n$t$a;->a:Lo8/i;

    .line 34
    .line 35
    invoke-virtual {v2}, Lo8/i;->e()Lj8/l;

    .line 36
    .line 37
    .line 38
    move-result-object v2

    .line 39
    invoke-virtual {v1, v2, v0}, Lj8/y;->A(Lj8/l;Lr8/n;)Ljava/util/List;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    iget-object v1, p0, Lj8/n$t$a;->c:Lj8/n$t;

    .line 44
    .line 45
    iget-object v1, v1, Lj8/n$t;->a:Lj8/n;

    .line 46
    .line 47
    invoke-static {v1, v0}, Lj8/n;->y(Lj8/n;Ljava/util/List;)V

    .line 48
    .line 49
    .line 50
    iget-object v0, p0, Lj8/n$t$a;->b:Lj8/y$p;

    .line 51
    .line 52
    const/4 v1, 0x0

    .line 53
    invoke-interface {v0, v1}, Lj8/y$p;->c(Le8/c;)Ljava/util/List;

    .line 54
    .line 55
    .line 56
    :cond_0
    return-void
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method
