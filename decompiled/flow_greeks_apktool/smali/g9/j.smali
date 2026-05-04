.class public abstract Lg9/j;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lg9/j$a;
    }
.end annotation


# instance fields
.field public final a:Lcom/google/firebase/firestore/g;

.field public b:Lm9/m0;

.field public c:Li9/h1;

.field public d:Li9/k0;

.field public e:Lg9/f1;

.field public f:Lm9/s0;

.field public g:Lg9/o;

.field public h:Li9/l;

.field public i:Li9/l4;


# direct methods
.method public constructor <init>(Lcom/google/firebase/firestore/g;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Lm9/m0;

    .line 5
    .line 6
    invoke-direct {v0}, Lm9/m0;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Lg9/j;->b:Lm9/m0;

    .line 10
    .line 11
    iput-object p1, p0, Lg9/j;->a:Lcom/google/firebase/firestore/g;

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
.end method

.method public static h(Lcom/google/firebase/firestore/g;)Lg9/j;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lcom/google/firebase/firestore/g;->i()Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    new-instance v0, Lg9/e1;

    .line 8
    .line 9
    invoke-direct {v0, p0}, Lg9/e1;-><init>(Lcom/google/firebase/firestore/g;)V

    .line 10
    .line 11
    .line 12
    return-object v0

    .line 13
    :cond_0
    new-instance v0, Lg9/x0;

    .line 14
    .line 15
    invoke-direct {v0, p0}, Lg9/x0;-><init>(Lcom/google/firebase/firestore/g;)V

    .line 16
    .line 17
    .line 18
    return-object v0
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public abstract a(Lg9/j$a;)Lg9/o;
.end method

.method public abstract b(Lg9/j$a;)Li9/l4;
.end method

.method public abstract c(Lg9/j$a;)Li9/l;
.end method

.method public abstract d(Lg9/j$a;)Li9/k0;
.end method

.method public abstract e(Lg9/j$a;)Li9/h1;
.end method

.method public abstract f(Lg9/j$a;)Lm9/s0;
.end method

.method public abstract g(Lg9/j$a;)Lg9/f1;
.end method

.method public i()Lm9/n;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->b:Lm9/m0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lm9/m0;->f()Lm9/n;

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
.end method

.method public j()Lm9/q;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->b:Lm9/m0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lm9/m0;->g()Lm9/q;

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
.end method

.method public k()Lg9/o;
    .locals 3

    .line 1
    iget-object v0, p0, Lg9/j;->g:Lg9/o;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "eventManager not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lg9/o;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public l()Li9/l4;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->i:Li9/l4;

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
.end method

.method public m()Li9/l;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->h:Li9/l;

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
.end method

.method public n()Li9/k0;
    .locals 3

    .line 1
    iget-object v0, p0, Lg9/j;->d:Li9/k0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "localStore not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Li9/k0;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public o()Li9/h1;
    .locals 3

    .line 1
    iget-object v0, p0, Lg9/j;->c:Li9/h1;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "persistence not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Li9/h1;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public p()Lm9/o0;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->b:Lm9/m0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lm9/m0;->j()Lm9/o0;

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
.end method

.method public q()Lm9/s0;
    .locals 3

    .line 1
    iget-object v0, p0, Lg9/j;->f:Lm9/s0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "remoteStore not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/s0;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public r()Lg9/f1;
    .locals 3

    .line 1
    iget-object v0, p0, Lg9/j;->e:Lg9/f1;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "syncEngine not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lg9/f1;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public s(Lg9/j$a;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/j;->b:Lm9/m0;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lm9/m0;->k(Lg9/j$a;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p0, p1}, Lg9/j;->e(Lg9/j$a;)Li9/h1;

    .line 7
    .line 8
    .line 9
    move-result-object v0

    .line 10
    iput-object v0, p0, Lg9/j;->c:Li9/h1;

    .line 11
    .line 12
    invoke-virtual {v0}, Li9/h1;->n()V

    .line 13
    .line 14
    .line 15
    invoke-virtual {p0, p1}, Lg9/j;->d(Lg9/j$a;)Li9/k0;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    iput-object v0, p0, Lg9/j;->d:Li9/k0;

    .line 20
    .line 21
    invoke-virtual {p0, p1}, Lg9/j;->f(Lg9/j$a;)Lm9/s0;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    iput-object v0, p0, Lg9/j;->f:Lm9/s0;

    .line 26
    .line 27
    invoke-virtual {p0, p1}, Lg9/j;->g(Lg9/j$a;)Lg9/f1;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    iput-object v0, p0, Lg9/j;->e:Lg9/f1;

    .line 32
    .line 33
    invoke-virtual {p0, p1}, Lg9/j;->a(Lg9/j$a;)Lg9/o;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    iput-object v0, p0, Lg9/j;->g:Lg9/o;

    .line 38
    .line 39
    iget-object v0, p0, Lg9/j;->d:Li9/k0;

    .line 40
    .line 41
    invoke-virtual {v0}, Li9/k0;->Y()V

    .line 42
    .line 43
    .line 44
    iget-object v0, p0, Lg9/j;->f:Lm9/s0;

    .line 45
    .line 46
    invoke-virtual {v0}, Lm9/s0;->N()V

    .line 47
    .line 48
    .line 49
    invoke-virtual {p0, p1}, Lg9/j;->b(Lg9/j$a;)Li9/l4;

    .line 50
    .line 51
    .line 52
    move-result-object v0

    .line 53
    iput-object v0, p0, Lg9/j;->i:Li9/l4;

    .line 54
    .line 55
    invoke-virtual {p0, p1}, Lg9/j;->c(Lg9/j$a;)Li9/l;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    iput-object p1, p0, Lg9/j;->h:Li9/l;

    .line 60
    .line 61
    return-void
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
.end method
