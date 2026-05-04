.class public final Lpc/c;
.super Lcc/j;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lpc/c$a;
    }
.end annotation


# instance fields
.field public final a:Lcc/m;


# direct methods
.method public constructor <init>(Lcc/m;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lcc/j;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lpc/c;->a:Lcc/m;

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
.method public u(Lcc/l;)V
    .locals 1

    .line 1
    new-instance v0, Lpc/c$a;

    .line 2
    .line 3
    invoke-direct {v0, p1}, Lpc/c$a;-><init>(Lcc/l;)V

    .line 4
    .line 5
    .line 6
    invoke-interface {p1, v0}, Lcc/l;->a(Lfc/b;)V

    .line 7
    .line 8
    .line 9
    :try_start_0
    iget-object p1, p0, Lpc/c;->a:Lcc/m;

    .line 10
    .line 11
    invoke-interface {p1, v0}, Lcc/m;->a(Lcc/k;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 12
    .line 13
    .line 14
    return-void

    .line 15
    :catchall_0
    move-exception p1

    .line 16
    invoke-static {p1}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {v0, p1}, Lpc/c$a;->onError(Ljava/lang/Throwable;)V

    .line 20
    .line 21
    .line 22
    return-void
    .line 23
    .line 24
    .line 25
    .line 26
.end method
