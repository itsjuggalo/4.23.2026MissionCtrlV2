.class public final Ltb/q$d$b;
.super Ltb/y;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/q$d;->a(Ltb/p2$a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "b"
.end annotation


# instance fields
.field public final synthetic b:Lbc/b;

.field public final synthetic c:Ltb/p2$a;

.field public final synthetic d:Ltb/q$d;


# direct methods
.method public constructor <init>(Ltb/q$d;Lbc/b;Ltb/p2$a;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/q$d$b;->b:Lbc/b;

    .line 4
    .line 5
    iput-object p3, p0, Ltb/q$d$b;->c:Ltb/p2$a;

    .line 6
    .line 7
    iget-object p1, p1, Ltb/q$d;->c:Ltb/q;

    .line 8
    .line 9
    invoke-static {p1}, Ltb/q;->m(Ltb/q;)Lrb/r;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    invoke-direct {p0, p1}, Ltb/y;-><init>(Lrb/r;)V

    .line 14
    .line 15
    .line 16
    return-void
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

.method private b()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/q$d;->e(Ltb/q$d;)Lrb/k1;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    iget-object v0, p0, Ltb/q$d$b;->c:Ltb/p2$a;

    .line 10
    .line 11
    invoke-static {v0}, Ltb/r0;->e(Ltb/p2$a;)V

    .line 12
    .line 13
    .line 14
    return-void

    .line 15
    :cond_0
    :goto_0
    :try_start_0
    iget-object v0, p0, Ltb/q$d$b;->c:Ltb/p2$a;

    .line 16
    .line 17
    invoke-interface {v0}, Ltb/p2$a;->next()Ljava/io/InputStream;

    .line 18
    .line 19
    .line 20
    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 21
    if-eqz v0, :cond_1

    .line 22
    .line 23
    :try_start_1
    iget-object v1, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 24
    .line 25
    invoke-static {v1}, Ltb/q$d;->f(Ltb/q$d;)Lrb/g$a;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    iget-object v2, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 30
    .line 31
    iget-object v2, v2, Ltb/q$d;->c:Ltb/q;

    .line 32
    .line 33
    invoke-static {v2}, Ltb/q;->h(Ltb/q;)Lrb/z0;

    .line 34
    .line 35
    .line 36
    move-result-object v2

    .line 37
    invoke-virtual {v2, v0}, Lrb/z0;->i(Ljava/io/InputStream;)Ljava/lang/Object;

    .line 38
    .line 39
    .line 40
    move-result-object v2

    .line 41
    invoke-virtual {v1, v2}, Lrb/g$a;->c(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 42
    .line 43
    .line 44
    :try_start_2
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 45
    .line 46
    .line 47
    goto :goto_0

    .line 48
    :catchall_0
    move-exception v0

    .line 49
    goto :goto_1

    .line 50
    :catchall_1
    move-exception v1

    .line 51
    invoke-static {v0}, Ltb/r0;->d(Ljava/io/Closeable;)V

    .line 52
    .line 53
    .line 54
    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 55
    :cond_1
    return-void

    .line 56
    :goto_1
    iget-object v1, p0, Ltb/q$d$b;->c:Ltb/p2$a;

    .line 57
    .line 58
    invoke-static {v1}, Ltb/r0;->e(Ltb/p2$a;)V

    .line 59
    .line 60
    .line 61
    iget-object v1, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 62
    .line 63
    sget-object v2, Lrb/k1;->f:Lrb/k1;

    .line 64
    .line 65
    invoke-virtual {v2, v0}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 66
    .line 67
    .line 68
    move-result-object v0

    .line 69
    const-string v2, "Failed to read message."

    .line 70
    .line 71
    invoke-virtual {v0, v2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 72
    .line 73
    .line 74
    move-result-object v0

    .line 75
    invoke-static {v1, v0}, Ltb/q$d;->g(Ltb/q$d;Lrb/k1;)V

    .line 76
    .line 77
    .line 78
    return-void
    .line 79
    .line 80
    .line 81
    .line 82
.end method


# virtual methods
.method public a()V
    .locals 2

    .line 1
    const-string v0, "ClientCall$Listener.messagesAvailable"

    .line 2
    .line 3
    invoke-static {v0}, Lbc/c;->h(Ljava/lang/String;)Lbc/e;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    :try_start_0
    iget-object v1, p0, Ltb/q$d$b;->d:Ltb/q$d;

    .line 8
    .line 9
    iget-object v1, v1, Ltb/q$d;->c:Ltb/q;

    .line 10
    .line 11
    invoke-static {v1}, Ltb/q;->q(Ltb/q;)Lbc/d;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    invoke-static {v1}, Lbc/c;->a(Lbc/d;)V

    .line 16
    .line 17
    .line 18
    iget-object v1, p0, Ltb/q$d$b;->b:Lbc/b;

    .line 19
    .line 20
    invoke-static {v1}, Lbc/c;->e(Lbc/b;)V

    .line 21
    .line 22
    .line 23
    invoke-direct {p0}, Ltb/q$d$b;->b()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 24
    .line 25
    .line 26
    if-eqz v0, :cond_0

    .line 27
    .line 28
    invoke-virtual {v0}, Lbc/e;->close()V

    .line 29
    .line 30
    .line 31
    :cond_0
    return-void

    .line 32
    :catchall_0
    move-exception v1

    .line 33
    if-eqz v0, :cond_1

    .line 34
    .line 35
    :try_start_1
    invoke-virtual {v0}, Lbc/e;->close()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 36
    .line 37
    .line 38
    goto :goto_0

    .line 39
    :catchall_1
    move-exception v0

    .line 40
    invoke-virtual {v1, v0}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .line 41
    .line 42
    .line 43
    :cond_1
    :goto_0
    throw v1
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
