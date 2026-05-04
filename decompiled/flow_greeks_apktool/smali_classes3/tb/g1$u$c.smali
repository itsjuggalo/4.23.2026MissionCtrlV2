.class public final Ltb/g1$u$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/g1$u;->o()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "c"
.end annotation


# instance fields
.field public final synthetic a:Ltb/g1$u;


# direct methods
.method public constructor <init>(Ltb/g1$u;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
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
    .line 25
    .line 26
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

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
    const/4 v2, 0x0

    .line 16
    if-ne v0, v1, :cond_0

    .line 17
    .line 18
    iget-object v0, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

    .line 19
    .line 20
    invoke-static {v0}, Ltb/g1$u;->i(Ltb/g1$u;)Ljava/util/concurrent/atomic/AtomicReference;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    invoke-virtual {v0, v2}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    :cond_0
    iget-object v0, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

    .line 28
    .line 29
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 30
    .line 31
    invoke-static {v0}, Ltb/g1;->L(Ltb/g1;)Ljava/util/Collection;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    if-eqz v0, :cond_1

    .line 36
    .line 37
    iget-object v0, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

    .line 38
    .line 39
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 40
    .line 41
    invoke-static {v0}, Ltb/g1;->L(Ltb/g1;)Ljava/util/Collection;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    .line 46
    .line 47
    .line 48
    move-result-object v0

    .line 49
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 50
    .line 51
    .line 52
    move-result v1

    .line 53
    if-eqz v1, :cond_1

    .line 54
    .line 55
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 56
    .line 57
    .line 58
    move-result-object v1

    .line 59
    check-cast v1, Ltb/g1$u$g;

    .line 60
    .line 61
    const-string v3, "Channel is forcefully shutdown"

    .line 62
    .line 63
    invoke-virtual {v1, v3, v2}, Ltb/a0;->a(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 64
    .line 65
    .line 66
    goto :goto_0

    .line 67
    :cond_1
    iget-object v0, p0, Ltb/g1$u$c;->a:Ltb/g1$u;

    .line 68
    .line 69
    iget-object v0, v0, Ltb/g1$u;->d:Ltb/g1;

    .line 70
    .line 71
    invoke-static {v0}, Ltb/g1;->y(Ltb/g1;)Ltb/g1$y;

    .line 72
    .line 73
    .line 74
    move-result-object v0

    .line 75
    sget-object v1, Ltb/g1;->o0:Lrb/k1;

    .line 76
    .line 77
    invoke-virtual {v0, v1}, Ltb/g1$y;->c(Lrb/k1;)V

    .line 78
    .line 79
    .line 80
    return-void
    .line 81
    .line 82
.end method
