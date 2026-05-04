.class public Li9/q0$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Li9/l4;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Li9/q0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "a"
.end annotation


# instance fields
.field public final a:Ln9/g;

.field public final b:Li9/k0;

.field public c:Z

.field public d:Ln9/g$b;

.field public final synthetic e:Li9/q0;


# direct methods
.method public constructor <init>(Li9/q0;Ln9/g;Li9/k0;)V
    .locals 0

    .line 1
    iput-object p1, p0, Li9/q0$a;->e:Li9/q0;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    const/4 p1, 0x0

    .line 7
    iput-boolean p1, p0, Li9/q0$a;->c:Z

    .line 8
    .line 9
    iput-object p2, p0, Li9/q0$a;->a:Ln9/g;

    .line 10
    .line 11
    iput-object p3, p0, Li9/q0$a;->b:Li9/k0;

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

.method public static synthetic a(Li9/q0$a;)V
    .locals 2

    .line 1
    iget-object v0, p0, Li9/q0$a;->b:Li9/k0;

    .line 2
    .line 3
    iget-object v1, p0, Li9/q0$a;->e:Li9/q0;

    .line 4
    .line 5
    invoke-virtual {v0, v1}, Li9/k0;->z(Li9/q0;)Li9/q0$c;

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x1

    .line 9
    iput-boolean v0, p0, Li9/q0$a;->c:Z

    .line 10
    .line 11
    invoke-virtual {p0}, Li9/q0$a;->b()V

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
.end method


# virtual methods
.method public final b()V
    .locals 5

    .line 1
    iget-boolean v0, p0, Li9/q0$a;->c:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-static {}, Li9/q0;->c()J

    .line 6
    .line 7
    .line 8
    move-result-wide v0

    .line 9
    goto :goto_0

    .line 10
    :cond_0
    invoke-static {}, Li9/q0;->d()J

    .line 11
    .line 12
    .line 13
    move-result-wide v0

    .line 14
    :goto_0
    iget-object v2, p0, Li9/q0$a;->a:Ln9/g;

    .line 15
    .line 16
    sget-object v3, Ln9/g$d;->h:Ln9/g$d;

    .line 17
    .line 18
    new-instance v4, Li9/p0;

    .line 19
    .line 20
    invoke-direct {v4, p0}, Li9/p0;-><init>(Li9/q0$a;)V

    .line 21
    .line 22
    .line 23
    invoke-virtual {v2, v3, v0, v1, v4}, Ln9/g;->k(Ln9/g$d;JLjava/lang/Runnable;)Ln9/g$b;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    iput-object v0, p0, Li9/q0$a;->d:Ln9/g$b;

    .line 28
    .line 29
    return-void
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
.end method

.method public start()V
    .locals 4

    .line 1
    iget-object v0, p0, Li9/q0$a;->e:Li9/q0;

    .line 2
    .line 3
    invoke-static {v0}, Li9/q0;->b(Li9/q0;)Li9/q0$b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-wide v0, v0, Li9/q0$b;->a:J

    .line 8
    .line 9
    const-wide/16 v2, -0x1

    .line 10
    .line 11
    cmp-long v0, v0, v2

    .line 12
    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    invoke-virtual {p0}, Li9/q0$a;->b()V

    .line 16
    .line 17
    .line 18
    :cond_0
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
.end method

.method public stop()V
    .locals 1

    .line 1
    iget-object v0, p0, Li9/q0$a;->d:Ln9/g$b;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Ln9/g$b;->c()V

    .line 6
    .line 7
    .line 8
    :cond_0
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
