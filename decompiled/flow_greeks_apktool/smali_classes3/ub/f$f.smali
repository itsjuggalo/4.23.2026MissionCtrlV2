.class public final Lub/f$f;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/u;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lub/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "f"
.end annotation


# instance fields
.field public final a:Ltb/p1;

.field public final b:Ljava/util/concurrent/Executor;

.field public final c:Ltb/p1;

.field public final d:Ljava/util/concurrent/ScheduledExecutorService;

.field public final e:Ltb/t2$b;

.field public final f:Ljavax/net/SocketFactory;

.field public final g:Ljavax/net/ssl/SSLSocketFactory;

.field public final h:Ljavax/net/ssl/HostnameVerifier;

.field public final i:Lvb/b;

.field public final j:I

.field public final k:Z

.field public final l:J

.field public final m:Ltb/g;

.field public final n:J

.field public final o:I

.field public final p:Z

.field public final q:I

.field public final r:Z

.field public s:Z


# direct methods
.method public constructor <init>(Ltb/p1;Ltb/p1;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lvb/b;IZJJIZILtb/t2$b;Z)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lub/f$f;->a:Ltb/p1;

    .line 4
    invoke-interface {p1}, Ltb/p1;->a()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/concurrent/Executor;

    iput-object p1, p0, Lub/f$f;->b:Ljava/util/concurrent/Executor;

    .line 5
    iput-object p2, p0, Lub/f$f;->c:Ltb/p1;

    .line 6
    invoke-interface {p2}, Ltb/p1;->a()Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ljava/util/concurrent/ScheduledExecutorService;

    iput-object p1, p0, Lub/f$f;->d:Ljava/util/concurrent/ScheduledExecutorService;

    .line 7
    iput-object p3, p0, Lub/f$f;->f:Ljavax/net/SocketFactory;

    .line 8
    iput-object p4, p0, Lub/f$f;->g:Ljavax/net/ssl/SSLSocketFactory;

    .line 9
    iput-object p5, p0, Lub/f$f;->h:Ljavax/net/ssl/HostnameVerifier;

    .line 10
    iput-object p6, p0, Lub/f$f;->i:Lvb/b;

    .line 11
    iput p7, p0, Lub/f$f;->j:I

    .line 12
    iput-boolean p8, p0, Lub/f$f;->k:Z

    .line 13
    iput-wide p9, p0, Lub/f$f;->l:J

    .line 14
    new-instance p1, Ltb/g;

    const-string p2, "keepalive time nanos"

    invoke-direct {p1, p2, p9, p10}, Ltb/g;-><init>(Ljava/lang/String;J)V

    iput-object p1, p0, Lub/f$f;->m:Ltb/g;

    .line 15
    iput-wide p11, p0, Lub/f$f;->n:J

    .line 16
    iput p13, p0, Lub/f$f;->o:I

    .line 17
    iput-boolean p14, p0, Lub/f$f;->p:Z

    .line 18
    iput p15, p0, Lub/f$f;->q:I

    move/from16 p1, p17

    .line 19
    iput-boolean p1, p0, Lub/f$f;->r:Z

    .line 20
    const-string p1, "transportTracerFactory"

    move-object/from16 p2, p16

    .line 21
    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Ltb/t2$b;

    iput-object p1, p0, Lub/f$f;->e:Ltb/t2$b;

    return-void
.end method

.method public synthetic constructor <init>(Ltb/p1;Ltb/p1;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lvb/b;IZJJIZILtb/t2$b;ZLub/f$a;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p17}, Lub/f$f;-><init>(Ltb/p1;Ltb/p1;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lvb/b;IZJJIZILtb/t2$b;Z)V

    return-void
.end method


# virtual methods
.method public I(Ljava/net/SocketAddress;Ltb/u$a;Lrb/f;)Ltb/w;
    .locals 16

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    iget-boolean v0, v1, Lub/f$f;->s:Z

    .line 4
    .line 5
    if-nez v0, :cond_1

    .line 6
    .line 7
    iget-object v0, v1, Lub/f$f;->m:Ltb/g;

    .line 8
    .line 9
    invoke-virtual {v0}, Ltb/g;->d()Ltb/g$b;

    .line 10
    .line 11
    .line 12
    move-result-object v8

    .line 13
    new-instance v7, Lub/f$f$a;

    .line 14
    .line 15
    invoke-direct {v7, v1, v8}, Lub/f$f$a;-><init>(Lub/f$f;Ltb/g$b;)V

    .line 16
    .line 17
    .line 18
    move-object/from16 v2, p1

    .line 19
    .line 20
    check-cast v2, Ljava/net/InetSocketAddress;

    .line 21
    .line 22
    new-instance v0, Lub/i;

    .line 23
    .line 24
    invoke-virtual/range {p2 .. p2}, Ltb/u$a;->a()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v3

    .line 28
    invoke-virtual/range {p2 .. p2}, Ltb/u$a;->d()Ljava/lang/String;

    .line 29
    .line 30
    .line 31
    move-result-object v4

    .line 32
    invoke-virtual/range {p2 .. p2}, Ltb/u$a;->b()Lrb/a;

    .line 33
    .line 34
    .line 35
    move-result-object v5

    .line 36
    invoke-virtual/range {p2 .. p2}, Ltb/u$a;->c()Lrb/d0;

    .line 37
    .line 38
    .line 39
    move-result-object v6

    .line 40
    invoke-direct/range {v0 .. v7}, Lub/i;-><init>(Lub/f$f;Ljava/net/InetSocketAddress;Ljava/lang/String;Ljava/lang/String;Lrb/a;Lrb/d0;Ljava/lang/Runnable;)V

    .line 41
    .line 42
    .line 43
    iget-boolean v2, v1, Lub/f$f;->k:Z

    .line 44
    .line 45
    if-eqz v2, :cond_0

    .line 46
    .line 47
    invoke-virtual {v8}, Ltb/g$b;->b()J

    .line 48
    .line 49
    .line 50
    move-result-wide v11

    .line 51
    iget-wide v13, v1, Lub/f$f;->n:J

    .line 52
    .line 53
    iget-boolean v15, v1, Lub/f$f;->p:Z

    .line 54
    .line 55
    const/4 v10, 0x1

    .line 56
    move-object v9, v0

    .line 57
    invoke-virtual/range {v9 .. v15}, Lub/i;->T(ZJJZ)V

    .line 58
    .line 59
    .line 60
    :cond_0
    return-object v0

    .line 61
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 62
    .line 63
    const-string v2, "The transport factory is closed."

    .line 64
    .line 65
    invoke-direct {v0, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 66
    .line 67
    .line 68
    throw v0
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

.method public Q()Ljava/util/concurrent/ScheduledExecutorService;
    .locals 1

    .line 1
    iget-object v0, p0, Lub/f$f;->d:Ljava/util/concurrent/ScheduledExecutorService;

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

.method public Y()Ljava/util/Collection;
    .locals 1

    .line 1
    invoke-static {}, Lub/f;->j()Ljava/util/Collection;

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
    .line 17
    .line 18
    .line 19
.end method

.method public close()V
    .locals 2

    .line 1
    iget-boolean v0, p0, Lub/f$f;->s:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    const/4 v0, 0x1

    .line 7
    iput-boolean v0, p0, Lub/f$f;->s:Z

    .line 8
    .line 9
    iget-object v0, p0, Lub/f$f;->a:Ltb/p1;

    .line 10
    .line 11
    iget-object v1, p0, Lub/f$f;->b:Ljava/util/concurrent/Executor;

    .line 12
    .line 13
    invoke-interface {v0, v1}, Ltb/p1;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    iget-object v0, p0, Lub/f$f;->c:Ltb/p1;

    .line 17
    .line 18
    iget-object v1, p0, Lub/f$f;->d:Ljava/util/concurrent/ScheduledExecutorService;

    .line 19
    .line 20
    invoke-interface {v0, v1}, Ltb/p1;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    .line 22
    .line 23
    return-void
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
.end method
