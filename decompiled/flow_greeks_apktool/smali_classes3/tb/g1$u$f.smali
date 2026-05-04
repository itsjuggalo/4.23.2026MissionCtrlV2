.class public Ltb/g1$u$f;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/g1$u;->e(Lrb/z0;Lrb/c;)Lrb/g;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ltb/g1$u$g;

.field public final synthetic b:Ltb/g1$u;


# direct methods
.method public constructor <init>(Ltb/g1$u;Ltb/g1$u$g;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/g1$u$f;->a:Ltb/g1$u$g;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
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


# virtual methods
.method public run()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1$u;->i(Ltb/g1$u;)Ljava/util/concurrent/atomic/AtomicReference;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    invoke-static {}, Ltb/g1;->F()Lrb/g0;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    if-ne v0, v1, :cond_1

    .line 16
    .line 17
    iget-object v0, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 18
    .line 19
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 20
    .line 21
    invoke-static {v0}, Ltb/g1;->L(Ltb/g1;)Ljava/util/Collection;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    if-nez v0, :cond_0

    .line 26
    .line 27
    iget-object v0, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 28
    .line 29
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 30
    .line 31
    new-instance v1, Ljava/util/LinkedHashSet;

    .line 32
    .line 33
    invoke-direct {v1}, Ljava/util/LinkedHashSet;-><init>()V

    .line 34
    .line 35
    .line 36
    invoke-static {v0, v1}, Ltb/g1;->M(Ltb/g1;Ljava/util/Collection;)Ljava/util/Collection;

    .line 37
    .line 38
    .line 39
    iget-object v0, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 40
    .line 41
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 42
    .line 43
    iget-object v1, v0, Ltb/g1;->j0:Ltb/w0;

    .line 44
    .line 45
    invoke-static {v0}, Ltb/g1;->O(Ltb/g1;)Ljava/lang/Object;

    .line 46
    .line 47
    .line 48
    move-result-object v0

    .line 49
    const/4 v2, 0x1

    .line 50
    invoke-virtual {v1, v0, v2}, Ltb/w0;->e(Ljava/lang/Object;Z)V

    .line 51
    .line 52
    .line 53
    :cond_0
    iget-object v0, p0, Ltb/g1$u$f;->b:Ltb/g1$u;

    .line 54
    .line 55
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 56
    .line 57
    invoke-static {v0}, Ltb/g1;->L(Ltb/g1;)Ljava/util/Collection;

    .line 58
    .line 59
    .line 60
    move-result-object v0

    .line 61
    iget-object v1, p0, Ltb/g1$u$f;->a:Ltb/g1$u$g;

    .line 62
    .line 63
    invoke-interface {v0, v1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 64
    .line 65
    .line 66
    return-void

    .line 67
    :cond_1
    iget-object v0, p0, Ltb/g1$u$f;->a:Ltb/g1$u$g;

    .line 68
    .line 69
    invoke-virtual {v0}, Ltb/g1$u$g;->r()V

    .line 70
    .line 71
    .line 72
    return-void
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
