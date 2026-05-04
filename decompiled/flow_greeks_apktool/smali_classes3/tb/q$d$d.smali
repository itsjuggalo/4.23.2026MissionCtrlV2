.class public final Ltb/q$d$d;
.super Ltb/y;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/q$d;->b()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "d"
.end annotation


# instance fields
.field public final synthetic b:Lbc/b;

.field public final synthetic c:Ltb/q$d;


# direct methods
.method public constructor <init>(Ltb/q$d;Lbc/b;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/q$d$d;->c:Ltb/q$d;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/q$d$d;->b:Lbc/b;

    .line 4
    .line 5
    iget-object p1, p1, Ltb/q$d;->c:Ltb/q;

    .line 6
    .line 7
    invoke-static {p1}, Ltb/q;->m(Ltb/q;)Lrb/r;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    invoke-direct {p0, p1}, Ltb/y;-><init>(Lrb/r;)V

    .line 12
    .line 13
    .line 14
    return-void
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

.method private b()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/q$d$d;->c:Ltb/q$d;

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
    return-void

    .line 10
    :cond_0
    :try_start_0
    iget-object v0, p0, Ltb/q$d$d;->c:Ltb/q$d;

    .line 11
    .line 12
    invoke-static {v0}, Ltb/q$d;->f(Ltb/q$d;)Lrb/g$a;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    invoke-virtual {v0}, Lrb/g$a;->d()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :catchall_0
    move-exception v0

    .line 21
    iget-object v1, p0, Ltb/q$d$d;->c:Ltb/q$d;

    .line 22
    .line 23
    sget-object v2, Lrb/k1;->f:Lrb/k1;

    .line 24
    .line 25
    invoke-virtual {v2, v0}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    const-string v2, "Failed to call onReady."

    .line 30
    .line 31
    invoke-virtual {v0, v2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    invoke-static {v1, v0}, Ltb/q$d;->g(Ltb/q$d;Lrb/k1;)V

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
.end method


# virtual methods
.method public a()V
    .locals 2

    .line 1
    const-string v0, "ClientCall$Listener.onReady"

    .line 2
    .line 3
    invoke-static {v0}, Lbc/c;->h(Ljava/lang/String;)Lbc/e;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    :try_start_0
    iget-object v1, p0, Ltb/q$d$d;->c:Ltb/q$d;

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
    iget-object v1, p0, Ltb/q$d$d;->b:Lbc/b;

    .line 19
    .line 20
    invoke-static {v1}, Lbc/c;->e(Lbc/b;)V

    .line 21
    .line 22
    .line 23
    invoke-direct {p0}, Ltb/q$d$d;->b()V
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
