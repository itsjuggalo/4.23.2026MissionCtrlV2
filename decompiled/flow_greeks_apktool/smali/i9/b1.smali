.class public final Li9/b1;
.super Li9/h1;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final c:Li9/v0;

.field public final d:Ljava/util/Map;

.field public final e:Ljava/util/Map;

.field public final f:Li9/w0;

.field public final g:Li9/d1;

.field public final h:Li9/s0;

.field public final i:Li9/c1;

.field public j:Li9/m1;

.field public k:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Li9/h1;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Li9/v0;

    .line 5
    .line 6
    invoke-direct {v0}, Li9/v0;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Li9/b1;->c:Li9/v0;

    .line 10
    .line 11
    new-instance v0, Ljava/util/HashMap;

    .line 12
    .line 13
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Li9/b1;->d:Ljava/util/Map;

    .line 17
    .line 18
    new-instance v0, Li9/w0;

    .line 19
    .line 20
    invoke-direct {v0}, Li9/w0;-><init>()V

    .line 21
    .line 22
    .line 23
    iput-object v0, p0, Li9/b1;->f:Li9/w0;

    .line 24
    .line 25
    new-instance v0, Li9/d1;

    .line 26
    .line 27
    invoke-direct {v0, p0}, Li9/d1;-><init>(Li9/b1;)V

    .line 28
    .line 29
    .line 30
    iput-object v0, p0, Li9/b1;->g:Li9/d1;

    .line 31
    .line 32
    new-instance v0, Li9/s0;

    .line 33
    .line 34
    invoke-direct {v0}, Li9/s0;-><init>()V

    .line 35
    .line 36
    .line 37
    iput-object v0, p0, Li9/b1;->h:Li9/s0;

    .line 38
    .line 39
    new-instance v0, Li9/c1;

    .line 40
    .line 41
    invoke-direct {v0}, Li9/c1;-><init>()V

    .line 42
    .line 43
    .line 44
    iput-object v0, p0, Li9/b1;->i:Li9/c1;

    .line 45
    .line 46
    new-instance v0, Ljava/util/HashMap;

    .line 47
    .line 48
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 49
    .line 50
    .line 51
    iput-object v0, p0, Li9/b1;->e:Ljava/util/Map;

    .line 52
    .line 53
    return-void
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
    .line 61
.end method

.method public static o()Li9/b1;
    .locals 2

    .line 1
    new-instance v0, Li9/b1;

    .line 2
    .line 3
    invoke-direct {v0}, Li9/b1;-><init>()V

    .line 4
    .line 5
    .line 6
    new-instance v1, Li9/u0;

    .line 7
    .line 8
    invoke-direct {v1, v0}, Li9/u0;-><init>(Li9/b1;)V

    .line 9
    .line 10
    .line 11
    invoke-virtual {v0, v1}, Li9/b1;->u(Li9/m1;)V

    .line 12
    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
.end method

.method public static p(Li9/q0$b;Li9/p;)Li9/b1;
    .locals 2

    .line 1
    new-instance v0, Li9/b1;

    .line 2
    .line 3
    invoke-direct {v0}, Li9/b1;-><init>()V

    .line 4
    .line 5
    .line 6
    new-instance v1, Li9/y0;

    .line 7
    .line 8
    invoke-direct {v1, v0, p0, p1}, Li9/y0;-><init>(Li9/b1;Li9/q0$b;Li9/p;)V

    .line 9
    .line 10
    .line 11
    invoke-virtual {v0, v1}, Li9/b1;->u(Li9/m1;)V

    .line 12
    .line 13
    .line 14
    return-object v0
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
.method public a()Li9/a;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->h:Li9/s0;

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

.method public b(Le9/j;)Li9/b;
    .locals 2

    .line 1
    iget-object v0, p0, Li9/b1;->e:Ljava/util/Map;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Li9/t0;

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    new-instance v0, Li9/t0;

    .line 12
    .line 13
    invoke-direct {v0}, Li9/t0;-><init>()V

    .line 14
    .line 15
    .line 16
    iget-object v1, p0, Li9/b1;->e:Ljava/util/Map;

    .line 17
    .line 18
    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    :cond_0
    return-object v0
    .line 22
    .line 23
    .line 24
.end method

.method public c()Li9/g;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->c:Li9/v0;

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

.method public bridge synthetic d(Le9/j;)Li9/m;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Li9/b1;->q(Le9/j;)Li9/w0;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    return-object p1
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public e(Le9/j;Li9/m;)Li9/e1;
    .locals 1

    .line 1
    iget-object p2, p0, Li9/b1;->d:Ljava/util/Map;

    .line 2
    .line 3
    invoke-interface {p2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p2

    .line 7
    check-cast p2, Li9/z0;

    .line 8
    .line 9
    if-nez p2, :cond_0

    .line 10
    .line 11
    new-instance p2, Li9/z0;

    .line 12
    .line 13
    invoke-direct {p2, p0, p1}, Li9/z0;-><init>(Li9/b1;Le9/j;)V

    .line 14
    .line 15
    .line 16
    iget-object v0, p0, Li9/b1;->d:Ljava/util/Map;

    .line 17
    .line 18
    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 19
    .line 20
    .line 21
    :cond_0
    return-object p2
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

.method public f()Li9/f1;
    .locals 1

    .line 1
    new-instance v0, Li9/a1;

    .line 2
    .line 3
    invoke-direct {v0}, Li9/a1;-><init>()V

    .line 4
    .line 5
    .line 6
    return-object v0
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

.method public g()Li9/m1;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->j:Li9/m1;

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

.method public bridge synthetic h()Li9/o1;
    .locals 1

    .line 1
    invoke-virtual {p0}, Li9/b1;->s()Li9/c1;

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

.method public bridge synthetic i()Li9/m4;
    .locals 1

    .line 1
    invoke-virtual {p0}, Li9/b1;->t()Li9/d1;

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

.method public j()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Li9/b1;->k:Z

    .line 2
    .line 3
    return v0
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

.method public k(Ljava/lang/String;Ln9/y;)Ljava/lang/Object;
    .locals 0

    .line 1
    iget-object p1, p0, Li9/b1;->j:Li9/m1;

    .line 2
    .line 3
    invoke-interface {p1}, Li9/m1;->g()V

    .line 4
    .line 5
    .line 6
    :try_start_0
    invoke-interface {p2}, Ln9/y;->get()Ljava/lang/Object;

    .line 7
    .line 8
    .line 9
    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 10
    iget-object p2, p0, Li9/b1;->j:Li9/m1;

    .line 11
    .line 12
    invoke-interface {p2}, Li9/m1;->onTransactionCommitted()V

    .line 13
    .line 14
    .line 15
    return-object p1

    .line 16
    :catchall_0
    move-exception p1

    .line 17
    iget-object p2, p0, Li9/b1;->j:Li9/m1;

    .line 18
    .line 19
    invoke-interface {p2}, Li9/m1;->onTransactionCommitted()V

    .line 20
    .line 21
    .line 22
    throw p1
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

.method public l(Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 0

    .line 1
    iget-object p1, p0, Li9/b1;->j:Li9/m1;

    .line 2
    .line 3
    invoke-interface {p1}, Li9/m1;->g()V

    .line 4
    .line 5
    .line 6
    :try_start_0
    invoke-interface {p2}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 7
    .line 8
    .line 9
    iget-object p1, p0, Li9/b1;->j:Li9/m1;

    .line 10
    .line 11
    invoke-interface {p1}, Li9/m1;->onTransactionCommitted()V

    .line 12
    .line 13
    .line 14
    return-void

    .line 15
    :catchall_0
    move-exception p1

    .line 16
    iget-object p2, p0, Li9/b1;->j:Li9/m1;

    .line 17
    .line 18
    invoke-interface {p2}, Li9/m1;->onTransactionCommitted()V

    .line 19
    .line 20
    .line 21
    throw p1
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

.method public m()V
    .locals 4

    .line 1
    iget-boolean v0, p0, Li9/b1;->k:Z

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    new-array v2, v1, [Ljava/lang/Object;

    .line 5
    .line 6
    const-string v3, "MemoryPersistence shutdown without start"

    .line 7
    .line 8
    invoke-static {v0, v3, v2}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 9
    .line 10
    .line 11
    iput-boolean v1, p0, Li9/b1;->k:Z

    .line 12
    .line 13
    return-void
    .line 14
    .line 15
    .line 16
.end method

.method public n()V
    .locals 4

    .line 1
    iget-boolean v0, p0, Li9/b1;->k:Z

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    xor-int/2addr v0, v1

    .line 5
    const/4 v2, 0x0

    .line 6
    new-array v2, v2, [Ljava/lang/Object;

    .line 7
    .line 8
    const-string v3, "MemoryPersistence double-started!"

    .line 9
    .line 10
    invoke-static {v0, v3, v2}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 11
    .line 12
    .line 13
    iput-boolean v1, p0, Li9/b1;->k:Z

    .line 14
    .line 15
    return-void
    .line 16
.end method

.method public q(Le9/j;)Li9/w0;
    .locals 0

    .line 1
    iget-object p1, p0, Li9/b1;->f:Li9/w0;

    .line 2
    .line 3
    return-object p1
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public r()Ljava/lang/Iterable;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->d:Ljava/util/Map;

    .line 2
    .line 3
    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

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

.method public s()Li9/c1;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->i:Li9/c1;

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

.method public t()Li9/d1;
    .locals 1

    .line 1
    iget-object v0, p0, Li9/b1;->g:Li9/d1;

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

.method public final u(Li9/m1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Li9/b1;->j:Li9/m1;

    .line 2
    .line 3
    return-void
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
