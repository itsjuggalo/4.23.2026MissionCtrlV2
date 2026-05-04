.class public final Ltb/g1$x$a;
.super Ltb/y0$j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/g1$x;->h(Lrb/r0$k;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "a"
.end annotation


# instance fields
.field public final synthetic a:Lrb/r0$k;

.field public final synthetic b:Ltb/g1$x;


# direct methods
.method public constructor <init>(Ltb/g1$x;Lrb/r0$k;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/g1$x$a;->a:Lrb/r0$k;

    .line 4
    .line 5
    invoke-direct {p0}, Ltb/y0$j;-><init>()V

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
.method public a(Ltb/y0;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 4
    .line 5
    iget-object v0, v0, Ltb/g1;->j0:Ltb/w0;

    .line 6
    .line 7
    const/4 v1, 0x1

    .line 8
    invoke-virtual {v0, p1, v1}, Ltb/w0;->e(Ljava/lang/Object;Z)V

    .line 9
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

.method public b(Ltb/y0;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 4
    .line 5
    iget-object v0, v0, Ltb/g1;->j0:Ltb/w0;

    .line 6
    .line 7
    const/4 v1, 0x0

    .line 8
    invoke-virtual {v0, p1, v1}, Ltb/w0;->e(Ljava/lang/Object;Z)V

    .line 9
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

.method public c(Ltb/y0;Lrb/q;)V
    .locals 1

    .line 1
    iget-object p1, p0, Ltb/g1$x$a;->a:Lrb/r0$k;

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    const/4 p1, 0x1

    .line 6
    goto :goto_0

    .line 7
    :cond_0
    const/4 p1, 0x0

    .line 8
    :goto_0
    const-string v0, "listener is null"

    .line 9
    .line 10
    invoke-static {p1, v0}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 11
    .line 12
    .line 13
    iget-object p1, p0, Ltb/g1$x$a;->a:Lrb/r0$k;

    .line 14
    .line 15
    invoke-interface {p1, p2}, Lrb/r0$k;->a(Lrb/q;)V

    .line 16
    .line 17
    .line 18
    return-void
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

.method public d(Ltb/y0;)V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 4
    .line 5
    invoke-static {v0}, Ltb/g1;->k0(Ltb/g1;)Ljava/util/Set;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 13
    .line 14
    iget-object v0, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 15
    .line 16
    invoke-static {v0}, Ltb/g1;->b0(Ltb/g1;)Lrb/e0;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    invoke-virtual {v0, p1}, Lrb/e0;->k(Lrb/j0;)V

    .line 21
    .line 22
    .line 23
    iget-object p1, p0, Ltb/g1$x$a;->b:Ltb/g1$x;

    .line 24
    .line 25
    iget-object p1, p1, Ltb/g1$x;->j:Ltb/g1;

    .line 26
    .line 27
    invoke-static {p1}, Ltb/g1;->c0(Ltb/g1;)V

    .line 28
    .line 29
    .line 30
    return-void
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
    .line 98
    .line 99
.end method
