.class public final Luc/b$a;
.super Lcc/r$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Luc/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Ljc/d;

.field public final b:Lfc/a;

.field public final c:Ljc/d;

.field public final d:Luc/b$c;

.field public volatile e:Z


# direct methods
.method public constructor <init>(Luc/b$c;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Lcc/r$b;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Luc/b$a;->d:Luc/b$c;

    .line 5
    .line 6
    new-instance p1, Ljc/d;

    .line 7
    .line 8
    invoke-direct {p1}, Ljc/d;-><init>()V

    .line 9
    .line 10
    .line 11
    iput-object p1, p0, Luc/b$a;->a:Ljc/d;

    .line 12
    .line 13
    new-instance v0, Lfc/a;

    .line 14
    .line 15
    invoke-direct {v0}, Lfc/a;-><init>()V

    .line 16
    .line 17
    .line 18
    iput-object v0, p0, Luc/b$a;->b:Lfc/a;

    .line 19
    .line 20
    new-instance v1, Ljc/d;

    .line 21
    .line 22
    invoke-direct {v1}, Ljc/d;-><init>()V

    .line 23
    .line 24
    .line 25
    iput-object v1, p0, Luc/b$a;->c:Ljc/d;

    .line 26
    .line 27
    invoke-virtual {v1, p1}, Ljc/d;->d(Lfc/b;)Z

    .line 28
    .line 29
    .line 30
    invoke-virtual {v1, v0}, Ljc/d;->d(Lfc/b;)Z

    .line 31
    .line 32
    .line 33
    return-void
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


# virtual methods
.method public b(Ljava/lang/Runnable;)Lfc/b;
    .locals 6

    .line 1
    iget-boolean v0, p0, Luc/b$a;->e:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    sget-object p1, Ljc/c;->a:Ljc/c;

    .line 6
    .line 7
    return-object p1

    .line 8
    :cond_0
    iget-object v0, p0, Luc/b$a;->d:Luc/b$c;

    .line 9
    .line 10
    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 11
    .line 12
    iget-object v5, p0, Luc/b$a;->a:Ljc/d;

    .line 13
    .line 14
    const-wide/16 v2, 0x0

    .line 15
    .line 16
    move-object v1, p1

    .line 17
    invoke-virtual/range {v0 .. v5}, Luc/e;->e(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;Ljc/a;)Luc/h;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    return-object p1
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public c()Z
    .locals 1

    .line 1
    iget-boolean v0, p0, Luc/b$a;->e:Z

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
    .line 17
    .line 18
    .line 19
.end method

.method public d(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lfc/b;
    .locals 6

    .line 1
    iget-boolean v0, p0, Luc/b$a;->e:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    sget-object p1, Ljc/c;->a:Ljc/c;

    .line 6
    .line 7
    return-object p1

    .line 8
    :cond_0
    iget-object v0, p0, Luc/b$a;->d:Luc/b$c;

    .line 9
    .line 10
    iget-object v5, p0, Luc/b$a;->b:Lfc/a;

    .line 11
    .line 12
    move-object v1, p1

    .line 13
    move-wide v2, p2

    .line 14
    move-object v4, p4

    .line 15
    invoke-virtual/range {v0 .. v5}, Luc/e;->e(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;Ljc/a;)Luc/h;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    return-object p1
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

.method public dispose()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Luc/b$a;->e:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x1

    .line 6
    iput-boolean v0, p0, Luc/b$a;->e:Z

    .line 7
    .line 8
    iget-object v0, p0, Luc/b$a;->c:Ljc/d;

    .line 9
    .line 10
    invoke-virtual {v0}, Ljc/d;->dispose()V

    .line 11
    .line 12
    .line 13
    :cond_0
    return-void
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
