.class public Li3/k;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Li3/m;
.implements Lk3/h$a;
.implements Li3/p$a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Li3/k$b;,
        Li3/k$a;,
        Li3/k$c;,
        Li3/k$d;
    }
.end annotation


# static fields
.field public static final i:Z


# instance fields
.field public final a:Li3/s;

.field public final b:Li3/o;

.field public final c:Lk3/h;

.field public final d:Li3/k$b;

.field public final e:Li3/y;

.field public final f:Li3/k$c;

.field public final g:Li3/k$a;

.field public final h:Li3/a;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-string v0, "Engine"

    .line 2
    .line 3
    const/4 v1, 0x2

    .line 4
    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    sput-boolean v0, Li3/k;->i:Z

    .line 9
    .line 10
    return-void
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public constructor <init>(Lk3/h;Lk3/a$a;Ll3/b;Ll3/b;Ll3/b;Ll3/b;Li3/s;Li3/o;Li3/a;Li3/k$b;Li3/k$a;Li3/y;Z)V
    .locals 8

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Li3/k;->c:Lk3/h;

    .line 4
    new-instance v0, Li3/k$c;

    invoke-direct {v0, p2}, Li3/k$c;-><init>(Lk3/a$a;)V

    iput-object v0, p0, Li3/k;->f:Li3/k$c;

    if-nez p9, :cond_0

    .line 5
    new-instance p2, Li3/a;

    move/from16 v1, p13

    invoke-direct {p2, v1}, Li3/a;-><init>(Z)V

    goto :goto_0

    :cond_0
    move-object/from16 p2, p9

    .line 6
    :goto_0
    iput-object p2, p0, Li3/k;->h:Li3/a;

    .line 7
    invoke-virtual {p2, p0}, Li3/a;->f(Li3/p$a;)V

    if-nez p8, :cond_1

    .line 8
    new-instance p2, Li3/o;

    invoke-direct {p2}, Li3/o;-><init>()V

    goto :goto_1

    :cond_1
    move-object/from16 p2, p8

    .line 9
    :goto_1
    iput-object p2, p0, Li3/k;->b:Li3/o;

    if-nez p7, :cond_2

    .line 10
    new-instance p7, Li3/s;

    invoke-direct {p7}, Li3/s;-><init>()V

    .line 11
    :cond_2
    iput-object p7, p0, Li3/k;->a:Li3/s;

    if-nez p10, :cond_3

    .line 12
    new-instance v1, Li3/k$b;

    move-object v7, p0

    move-object v6, p0

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v1 .. v7}, Li3/k$b;-><init>(Ll3/b;Ll3/b;Ll3/b;Ll3/b;Li3/m;Li3/p$a;)V

    goto :goto_2

    :cond_3
    move-object/from16 v1, p10

    .line 13
    :goto_2
    iput-object v1, p0, Li3/k;->d:Li3/k$b;

    if-nez p11, :cond_4

    .line 14
    new-instance p2, Li3/k$a;

    invoke-direct {p2, v0}, Li3/k$a;-><init>(Li3/h$e;)V

    goto :goto_3

    :cond_4
    move-object/from16 p2, p11

    .line 15
    :goto_3
    iput-object p2, p0, Li3/k;->g:Li3/k$a;

    if-nez p12, :cond_5

    .line 16
    new-instance p2, Li3/y;

    invoke-direct {p2}, Li3/y;-><init>()V

    goto :goto_4

    :cond_5
    move-object/from16 p2, p12

    .line 17
    :goto_4
    iput-object p2, p0, Li3/k;->e:Li3/y;

    .line 18
    invoke-interface {p1, p0}, Lk3/h;->e(Lk3/h$a;)V

    return-void
.end method

.method public constructor <init>(Lk3/h;Lk3/a$a;Ll3/b;Ll3/b;Ll3/b;Ll3/b;Z)V
    .locals 14

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    move-object/from16 v5, p5

    move-object/from16 v6, p6

    move/from16 v13, p7

    .line 1
    invoke-direct/range {v0 .. v13}, Li3/k;-><init>(Lk3/h;Lk3/a$a;Ll3/b;Ll3/b;Ll3/b;Ll3/b;Li3/s;Li3/o;Li3/a;Li3/k$b;Li3/k$a;Li3/y;Z)V

    return-void
.end method

.method public static j(Ljava/lang/String;JLg3/f;)V
    .locals 1

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 7
    .line 8
    .line 9
    const-string p0, " in "

    .line 10
    .line 11
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 12
    .line 13
    .line 14
    invoke-static {p1, p2}, Lc4/g;->a(J)D

    .line 15
    .line 16
    .line 17
    move-result-wide p0

    .line 18
    invoke-virtual {v0, p0, p1}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    .line 19
    .line 20
    .line 21
    const-string p0, "ms, key: "

    .line 22
    .line 23
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 24
    .line 25
    .line 26
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 27
    .line 28
    .line 29
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object p0

    .line 33
    const-string p1, "Engine"

    .line 34
    .line 35
    invoke-static {p1, p0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    .line 37
    .line 38
    return-void
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
.method public a(Lg3/f;Li3/p;)V
    .locals 1

    .line 1
    iget-object v0, p0, Li3/k;->h:Li3/a;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Li3/a;->d(Lg3/f;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p2}, Li3/p;->f()Z

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    iget-object v0, p0, Li3/k;->c:Lk3/h;

    .line 13
    .line 14
    invoke-interface {v0, p1, p2}, Lk3/h;->d(Lg3/f;Li3/v;)Li3/v;

    .line 15
    .line 16
    .line 17
    return-void

    .line 18
    :cond_0
    iget-object p1, p0, Li3/k;->e:Li3/y;

    .line 19
    .line 20
    const/4 v0, 0x0

    .line 21
    invoke-virtual {p1, p2, v0}, Li3/y;->a(Li3/v;Z)V

    .line 22
    .line 23
    .line 24
    return-void
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

.method public declared-synchronized b(Li3/l;Lg3/f;Li3/p;)V
    .locals 1

    .line 1
    monitor-enter p0

    .line 2
    if-eqz p3, :cond_0

    .line 3
    .line 4
    :try_start_0
    invoke-virtual {p3}, Li3/p;->f()Z

    .line 5
    .line 6
    .line 7
    move-result v0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Li3/k;->h:Li3/a;

    .line 11
    .line 12
    invoke-virtual {v0, p2, p3}, Li3/a;->a(Lg3/f;Li3/p;)V

    .line 13
    .line 14
    .line 15
    goto :goto_0

    .line 16
    :catchall_0
    move-exception p1

    .line 17
    goto :goto_1

    .line 18
    :cond_0
    :goto_0
    iget-object p3, p0, Li3/k;->a:Li3/s;

    .line 19
    .line 20
    invoke-virtual {p3, p2, p1}, Li3/s;->d(Lg3/f;Li3/l;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    .line 22
    .line 23
    monitor-exit p0

    .line 24
    return-void

    .line 25
    :goto_1
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 26
    throw p1
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

.method public declared-synchronized c(Li3/l;Lg3/f;)V
    .locals 1

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-object v0, p0, Li3/k;->a:Li3/s;

    .line 3
    .line 4
    invoke-virtual {v0, p2, p1}, Li3/s;->d(Lg3/f;Li3/l;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 5
    .line 6
    .line 7
    monitor-exit p0

    .line 8
    return-void

    .line 9
    :catchall_0
    move-exception p1

    .line 10
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 11
    throw p1
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

.method public d(Li3/v;)V
    .locals 2

    .line 1
    iget-object v0, p0, Li3/k;->e:Li3/y;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    invoke-virtual {v0, p1, v1}, Li3/y;->a(Li3/v;Z)V

    .line 5
    .line 6
    .line 7
    return-void
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

.method public final e(Lg3/f;)Li3/p;
    .locals 7

    .line 1
    iget-object v0, p0, Li3/k;->c:Lk3/h;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lk3/h;->c(Lg3/f;)Li3/v;

    .line 4
    .line 5
    .line 6
    move-result-object v2

    .line 7
    if-nez v2, :cond_0

    .line 8
    .line 9
    const/4 p1, 0x0

    .line 10
    return-object p1

    .line 11
    :cond_0
    instance-of v0, v2, Li3/p;

    .line 12
    .line 13
    if-eqz v0, :cond_1

    .line 14
    .line 15
    check-cast v2, Li3/p;

    .line 16
    .line 17
    return-object v2

    .line 18
    :cond_1
    new-instance v1, Li3/p;

    .line 19
    .line 20
    const/4 v3, 0x1

    .line 21
    const/4 v4, 0x1

    .line 22
    move-object v6, p0

    .line 23
    move-object v5, p1

    .line 24
    invoke-direct/range {v1 .. v6}, Li3/p;-><init>(Li3/v;ZZLg3/f;Li3/p$a;)V

    .line 25
    .line 26
    .line 27
    return-object v1
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
.end method

.method public f(Lcom/bumptech/glide/d;Ljava/lang/Object;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZLg3/h;ZZZZLy3/g;Ljava/util/concurrent/Executor;)Li3/k$d;
    .locals 25

    move-object/from16 v2, p0

    .line 1
    sget-boolean v0, Li3/k;->i:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lc4/g;->b()J

    move-result-wide v0

    goto :goto_0

    :cond_0
    const-wide/16 v0, 0x0

    .line 2
    :goto_0
    iget-object v3, v2, Li3/k;->b:Li3/o;

    move-object/from16 v4, p2

    move-object/from16 v5, p3

    move/from16 v6, p4

    move/from16 v7, p5

    move-object/from16 v9, p6

    move-object/from16 v10, p7

    move-object/from16 v8, p10

    move-object/from16 v11, p13

    .line 3
    invoke-virtual/range {v3 .. v11}, Li3/o;->a(Ljava/lang/Object;Lg3/f;IILjava/util/Map;Ljava/lang/Class;Ljava/lang/Class;Lg3/h;)Li3/n;

    move-result-object v3

    .line 4
    monitor-enter p0

    move/from16 v4, p14

    .line 5
    :try_start_0
    invoke-virtual {v2, v3, v4, v0, v1}, Li3/k;->i(Li3/n;ZJ)Li3/p;

    move-result-object v5

    if-nez v5, :cond_1

    move-object/from16 v5, p3

    move/from16 v6, p4

    move/from16 v7, p5

    move-object/from16 v8, p6

    move-object/from16 v9, p7

    move-object/from16 v10, p8

    move-object/from16 v11, p9

    move-object/from16 v12, p10

    move/from16 v13, p11

    move/from16 v14, p12

    move-object/from16 v15, p13

    move/from16 v17, p15

    move/from16 v18, p16

    move/from16 v19, p17

    move-object/from16 v20, p18

    move-object/from16 v21, p19

    move-wide/from16 v23, v0

    move-object/from16 v22, v3

    move/from16 v16, v4

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    .line 6
    invoke-virtual/range {v2 .. v24}, Li3/k;->l(Lcom/bumptech/glide/d;Ljava/lang/Object;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZLg3/h;ZZZZLy3/g;Ljava/util/concurrent/Executor;Li3/n;J)Li3/k$d;

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    goto :goto_1

    :cond_1
    move-object v0, v5

    .line 7
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 8
    sget-object v1, Lg3/a;->e:Lg3/a;

    const/4 v2, 0x0

    move-object/from16 v3, p18

    invoke-interface {v3, v0, v1, v2}, Ly3/g;->c(Li3/v;Lg3/a;Z)V

    const/4 v0, 0x0

    return-object v0

    .line 9
    :goto_1
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public final g(Lg3/f;)Li3/p;
    .locals 1

    .line 1
    iget-object v0, p0, Li3/k;->h:Li3/a;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Li3/a;->e(Lg3/f;)Li3/p;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    invoke-virtual {p1}, Li3/p;->a()V

    .line 10
    .line 11
    .line 12
    :cond_0
    return-object p1
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

.method public final h(Lg3/f;)Li3/p;
    .locals 2

    .line 1
    invoke-virtual {p0, p1}, Li3/k;->e(Lg3/f;)Li3/p;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    invoke-virtual {v0}, Li3/p;->a()V

    .line 8
    .line 9
    .line 10
    iget-object v1, p0, Li3/k;->h:Li3/a;

    .line 11
    .line 12
    invoke-virtual {v1, p1, v0}, Li3/a;->a(Lg3/f;Li3/p;)V

    .line 13
    .line 14
    .line 15
    :cond_0
    return-object v0
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

.method public final i(Li3/n;ZJ)Li3/p;
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    if-nez p2, :cond_0

    .line 3
    .line 4
    return-object v0

    .line 5
    :cond_0
    invoke-virtual {p0, p1}, Li3/k;->g(Lg3/f;)Li3/p;

    .line 6
    .line 7
    .line 8
    move-result-object p2

    .line 9
    if-eqz p2, :cond_2

    .line 10
    .line 11
    sget-boolean v0, Li3/k;->i:Z

    .line 12
    .line 13
    if-eqz v0, :cond_1

    .line 14
    .line 15
    const-string v0, "Loaded resource from active resources"

    .line 16
    .line 17
    invoke-static {v0, p3, p4, p1}, Li3/k;->j(Ljava/lang/String;JLg3/f;)V

    .line 18
    .line 19
    .line 20
    :cond_1
    return-object p2

    .line 21
    :cond_2
    invoke-virtual {p0, p1}, Li3/k;->h(Lg3/f;)Li3/p;

    .line 22
    .line 23
    .line 24
    move-result-object p2

    .line 25
    if-eqz p2, :cond_4

    .line 26
    .line 27
    sget-boolean v0, Li3/k;->i:Z

    .line 28
    .line 29
    if-eqz v0, :cond_3

    .line 30
    .line 31
    const-string v0, "Loaded resource from cache"

    .line 32
    .line 33
    invoke-static {v0, p3, p4, p1}, Li3/k;->j(Ljava/lang/String;JLg3/f;)V

    .line 34
    .line 35
    .line 36
    :cond_3
    return-object p2

    .line 37
    :cond_4
    return-object v0
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

.method public k(Li3/v;)V
    .locals 1

    .line 1
    instance-of v0, p1, Li3/p;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    check-cast p1, Li3/p;

    .line 6
    .line 7
    invoke-virtual {p1}, Li3/p;->g()V

    .line 8
    .line 9
    .line 10
    return-void

    .line 11
    :cond_0
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 12
    .line 13
    const-string v0, "Cannot release anything but an EngineResource"

    .line 14
    .line 15
    invoke-direct {p1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 16
    .line 17
    .line 18
    throw p1
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public final l(Lcom/bumptech/glide/d;Ljava/lang/Object;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZLg3/h;ZZZZLy3/g;Ljava/util/concurrent/Executor;Li3/n;J)Li3/k$d;
    .locals 20

    move-object/from16 v0, p0

    move-object/from16 v1, p18

    move-object/from16 v2, p19

    move-object/from16 v4, p20

    move-wide/from16 v9, p21

    .line 1
    iget-object v3, v0, Li3/k;->a:Li3/s;

    move/from16 v8, p17

    invoke-virtual {v3, v4, v8}, Li3/s;->a(Lg3/f;Z)Li3/l;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 2
    invoke-virtual {v3, v1, v2}, Li3/l;->b(Ly3/g;Ljava/util/concurrent/Executor;)V

    .line 3
    sget-boolean v2, Li3/k;->i:Z

    if-eqz v2, :cond_0

    .line 4
    const-string v2, "Added to existing load"

    invoke-static {v2, v9, v10, v4}, Li3/k;->j(Ljava/lang/String;JLg3/f;)V

    .line 5
    :cond_0
    new-instance v2, Li3/k$d;

    invoke-direct {v2, v0, v1, v3}, Li3/k$d;-><init>(Li3/k;Ly3/g;Li3/l;)V

    return-object v2

    .line 6
    :cond_1
    iget-object v3, v0, Li3/k;->d:Li3/k$b;

    move/from16 v5, p14

    move/from16 v6, p15

    move/from16 v7, p16

    .line 7
    invoke-virtual/range {v3 .. v8}, Li3/k$b;->a(Lg3/f;ZZZZ)Li3/l;

    move-result-object v19

    .line 8
    iget-object v3, v0, Li3/k;->g:Li3/k$a;

    move-object/from16 v4, p1

    move-object/from16 v5, p2

    move-object/from16 v7, p3

    move/from16 v8, p4

    move/from16 v9, p5

    move-object/from16 v10, p6

    move-object/from16 v11, p7

    move-object/from16 v12, p8

    move-object/from16 v13, p9

    move-object/from16 v14, p10

    move/from16 v15, p11

    move/from16 v16, p12

    move-object/from16 v18, p13

    move/from16 v17, p17

    move-object/from16 v6, p20

    .line 9
    invoke-virtual/range {v3 .. v19}, Li3/k$a;->a(Lcom/bumptech/glide/d;Ljava/lang/Object;Li3/n;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZZLg3/h;Li3/h$b;)Li3/h;

    move-result-object v3

    move-object v4, v6

    move-object/from16 v5, v19

    .line 10
    iget-object v6, v0, Li3/k;->a:Li3/s;

    invoke-virtual {v6, v4, v5}, Li3/s;->c(Lg3/f;Li3/l;)V

    .line 11
    invoke-virtual {v5, v1, v2}, Li3/l;->b(Ly3/g;Ljava/util/concurrent/Executor;)V

    .line 12
    invoke-virtual {v5, v3}, Li3/l;->s(Li3/h;)V

    .line 13
    sget-boolean v2, Li3/k;->i:Z

    if-eqz v2, :cond_2

    .line 14
    const-string v2, "Started new load"

    move-wide/from16 v9, p21

    invoke-static {v2, v9, v10, v4}, Li3/k;->j(Ljava/lang/String;JLg3/f;)V

    .line 15
    :cond_2
    new-instance v2, Li3/k$d;

    invoke-direct {v2, v0, v1, v5}, Li3/k$d;-><init>(Li3/k;Ly3/g;Li3/l;)V

    return-object v2
.end method
