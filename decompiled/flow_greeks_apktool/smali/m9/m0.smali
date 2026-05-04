.class public Lm9/m0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public a:Lm9/h0;

.field public b:Lm9/o0;

.field public c:Lm9/y;

.field public d:Lm9/q;

.field public e:Lm9/n;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
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


# virtual methods
.method public a(Lg9/j$a;)Lm9/n;
    .locals 1

    .line 1
    new-instance v0, Lm9/j;

    .line 2
    .line 3
    iget-object p1, p1, Lg9/j$a;->a:Landroid/content/Context;

    .line 4
    .line 5
    invoke-direct {v0, p1}, Lm9/j;-><init>(Landroid/content/Context;)V

    .line 6
    .line 7
    .line 8
    return-object v0
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
.end method

.method public b(Lg9/j$a;)Lm9/q;
    .locals 3

    .line 1
    new-instance v0, Lm9/q;

    .line 2
    .line 3
    iget-object p1, p1, Lg9/j$a;->b:Ln9/g;

    .line 4
    .line 5
    invoke-virtual {p0}, Lm9/m0;->j()Lm9/o0;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-virtual {p0}, Lm9/m0;->h()Lm9/y;

    .line 10
    .line 11
    .line 12
    move-result-object v2

    .line 13
    invoke-direct {v0, p1, v1, v2}, Lm9/q;-><init>(Ln9/g;Lm9/o0;Lm9/y;)V

    .line 14
    .line 15
    .line 16
    return-object v0
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public c(Lg9/j$a;)Lm9/y;
    .locals 7

    .line 1
    new-instance v0, Lm9/y;

    .line 2
    .line 3
    iget-object v1, p1, Lg9/j$a;->b:Ln9/g;

    .line 4
    .line 5
    iget-object v2, p1, Lg9/j$a;->f:Le9/a;

    .line 6
    .line 7
    iget-object v3, p1, Lg9/j$a;->g:Le9/a;

    .line 8
    .line 9
    iget-object v4, p1, Lg9/j$a;->c:Lg9/l;

    .line 10
    .line 11
    invoke-virtual {v4}, Lg9/l;->a()Lj9/f;

    .line 12
    .line 13
    .line 14
    move-result-object v4

    .line 15
    iget-object v5, p1, Lg9/j$a;->h:Lm9/i0;

    .line 16
    .line 17
    invoke-virtual {p0}, Lm9/m0;->i()Lm9/h0;

    .line 18
    .line 19
    .line 20
    move-result-object v6

    .line 21
    invoke-direct/range {v0 .. v6}, Lm9/y;-><init>(Ln9/g;Le9/a;Le9/a;Lj9/f;Lm9/i0;Lm9/h0;)V

    .line 22
    .line 23
    .line 24
    return-object v0
.end method

.method public d(Lg9/j$a;)Lm9/h0;
    .locals 4

    .line 1
    new-instance v0, Lm9/u;

    .line 2
    .line 3
    iget-object v1, p1, Lg9/j$a;->f:Le9/a;

    .line 4
    .line 5
    iget-object v2, p1, Lg9/j$a;->g:Le9/a;

    .line 6
    .line 7
    invoke-direct {v0, v1, v2}, Lm9/u;-><init>(Le9/a;Le9/a;)V

    .line 8
    .line 9
    .line 10
    new-instance v1, Lm9/h0;

    .line 11
    .line 12
    iget-object v2, p1, Lg9/j$a;->b:Ln9/g;

    .line 13
    .line 14
    iget-object v3, p1, Lg9/j$a;->a:Landroid/content/Context;

    .line 15
    .line 16
    iget-object p1, p1, Lg9/j$a;->c:Lg9/l;

    .line 17
    .line 18
    invoke-direct {v1, v2, v3, p1, v0}, Lm9/h0;-><init>(Ln9/g;Landroid/content/Context;Lg9/l;Lrb/b;)V

    .line 19
    .line 20
    .line 21
    return-object v1
    .line 22
    .line 23
    .line 24
.end method

.method public e(Lg9/j$a;)Lm9/o0;
    .locals 1

    .line 1
    new-instance v0, Lm9/o0;

    .line 2
    .line 3
    iget-object p1, p1, Lg9/j$a;->c:Lg9/l;

    .line 4
    .line 5
    invoke-virtual {p1}, Lg9/l;->a()Lj9/f;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-direct {v0, p1}, Lm9/o0;-><init>(Lj9/f;)V

    .line 10
    .line 11
    .line 12
    return-object v0
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
.end method

.method public f()Lm9/n;
    .locals 3

    .line 1
    iget-object v0, p0, Lm9/m0;->e:Lm9/n;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "connectivityMonitor not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/n;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public g()Lm9/q;
    .locals 3

    .line 1
    iget-object v0, p0, Lm9/m0;->d:Lm9/q;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "datastore not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/q;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public h()Lm9/y;
    .locals 3

    .line 1
    iget-object v0, p0, Lm9/m0;->c:Lm9/y;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "firestoreChannel not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/y;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public i()Lm9/h0;
    .locals 3

    .line 1
    iget-object v0, p0, Lm9/m0;->a:Lm9/h0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "grpcCallProvider not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/h0;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public j()Lm9/o0;
    .locals 3

    .line 1
    iget-object v0, p0, Lm9/m0;->b:Lm9/o0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v1, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v2, "remoteSerializer not initialized yet"

    .line 7
    .line 8
    invoke-static {v0, v2, v1}, Ln9/b;->e(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lm9/o0;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public k(Lg9/j$a;)V
    .locals 1

    .line 1
    invoke-virtual {p0, p1}, Lm9/m0;->e(Lg9/j$a;)Lm9/o0;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iput-object v0, p0, Lm9/m0;->b:Lm9/o0;

    .line 6
    .line 7
    invoke-virtual {p0, p1}, Lm9/m0;->d(Lg9/j$a;)Lm9/h0;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    iput-object v0, p0, Lm9/m0;->a:Lm9/h0;

    .line 12
    .line 13
    invoke-virtual {p0, p1}, Lm9/m0;->c(Lg9/j$a;)Lm9/y;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    iput-object v0, p0, Lm9/m0;->c:Lm9/y;

    .line 18
    .line 19
    invoke-virtual {p0, p1}, Lm9/m0;->b(Lg9/j$a;)Lm9/q;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    iput-object v0, p0, Lm9/m0;->d:Lm9/q;

    .line 24
    .line 25
    invoke-virtual {p0, p1}, Lm9/m0;->a(Lg9/j$a;)Lm9/n;

    .line 26
    .line 27
    .line 28
    move-result-object p1

    .line 29
    iput-object p1, p0, Lm9/m0;->e:Lm9/n;

    .line 30
    .line 31
    return-void
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
.end method
