.class public abstract Lid/d;
.super Lid/a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field private final _context:Lgd/i;

.field private transient intercepted:Lgd/e;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lgd/e;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lgd/e;)V
    .locals 1

    if-eqz p1, :cond_0

    .line 3
    invoke-interface {p1}, Lgd/e;->getContext()Lgd/i;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-direct {p0, p1, v0}, Lid/d;-><init>(Lgd/e;Lgd/i;)V

    return-void
.end method

.method public constructor <init>(Lgd/e;Lgd/i;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lid/a;-><init>(Lgd/e;)V

    .line 2
    iput-object p2, p0, Lid/d;->_context:Lgd/i;

    return-void
.end method


# virtual methods
.method public getContext()Lgd/i;
    .locals 1

    .line 1
    iget-object v0, p0, Lid/d;->_context:Lgd/i;

    .line 2
    .line 3
    invoke-static {v0}, Lkotlin/jvm/internal/t;->c(Ljava/lang/Object;)V

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
    .line 17
    .line 18
    .line 19
.end method

.method public final intercepted()Lgd/e;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lgd/e;"
        }
    .end annotation

    .line 1
    iget-object v0, p0, Lid/d;->intercepted:Lgd/e;

    .line 2
    .line 3
    if-nez v0, :cond_2

    .line 4
    .line 5
    invoke-virtual {p0}, Lid/d;->getContext()Lgd/i;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    sget-object v1, Lgd/f;->K:Lgd/f$b;

    .line 10
    .line 11
    invoke-interface {v0, v1}, Lgd/i;->get(Lgd/i$c;)Lgd/i$b;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    check-cast v0, Lgd/f;

    .line 16
    .line 17
    if-eqz v0, :cond_0

    .line 18
    .line 19
    invoke-interface {v0, p0}, Lgd/f;->R(Lgd/e;)Lgd/e;

    .line 20
    .line 21
    .line 22
    move-result-object v0

    .line 23
    if-nez v0, :cond_1

    .line 24
    .line 25
    :cond_0
    move-object v0, p0

    .line 26
    :cond_1
    iput-object v0, p0, Lid/d;->intercepted:Lgd/e;

    .line 27
    .line 28
    :cond_2
    return-object v0
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

.method public releaseIntercepted()V
    .locals 3

    .line 1
    iget-object v0, p0, Lid/d;->intercepted:Lgd/e;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    if-eq v0, p0, :cond_0

    .line 6
    .line 7
    invoke-virtual {p0}, Lid/d;->getContext()Lgd/i;

    .line 8
    .line 9
    .line 10
    move-result-object v1

    .line 11
    sget-object v2, Lgd/f;->K:Lgd/f$b;

    .line 12
    .line 13
    invoke-interface {v1, v2}, Lgd/i;->get(Lgd/i$c;)Lgd/i$b;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-static {v1}, Lkotlin/jvm/internal/t;->c(Ljava/lang/Object;)V

    .line 18
    .line 19
    .line 20
    check-cast v1, Lgd/f;

    .line 21
    .line 22
    invoke-interface {v1, v0}, Lgd/f;->O(Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :cond_0
    sget-object v0, Lid/c;->a:Lid/c;

    .line 26
    .line 27
    iput-object v0, p0, Lid/d;->intercepted:Lgd/e;

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
