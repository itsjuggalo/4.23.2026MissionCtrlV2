.class public final Lrc/i$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/q;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrc/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lcc/q;

.field public final b:Lcc/p;

.field public final c:Ljc/e;

.field public d:Z


# direct methods
.method public constructor <init>(Lcc/q;Lcc/p;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lrc/i$a;->a:Lcc/q;

    .line 5
    .line 6
    iput-object p2, p0, Lrc/i$a;->b:Lcc/p;

    .line 7
    .line 8
    const/4 p1, 0x1

    .line 9
    iput-boolean p1, p0, Lrc/i$a;->d:Z

    .line 10
    .line 11
    new-instance p1, Ljc/e;

    .line 12
    .line 13
    invoke-direct {p1}, Ljc/e;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object p1, p0, Lrc/i$a;->c:Ljc/e;

    .line 17
    .line 18
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
.end method


# virtual methods
.method public a(Lfc/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/i$a;->c:Ljc/e;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ljc/e;->b(Lfc/b;)Z

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

.method public onComplete()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lrc/i$a;->d:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    iput-boolean v0, p0, Lrc/i$a;->d:Z

    .line 7
    .line 8
    iget-object v0, p0, Lrc/i$a;->b:Lcc/p;

    .line 9
    .line 10
    invoke-interface {v0, p0}, Lcc/p;->b(Lcc/q;)V

    .line 11
    .line 12
    .line 13
    return-void

    .line 14
    :cond_0
    iget-object v0, p0, Lrc/i$a;->a:Lcc/q;

    .line 15
    .line 16
    invoke-interface {v0}, Lcc/q;->onComplete()V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lrc/i$a;->a:Lcc/q;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Lcc/q;->onError(Ljava/lang/Throwable;)V

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

.method public onNext(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Lrc/i$a;->d:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    iput-boolean v0, p0, Lrc/i$a;->d:Z

    .line 7
    .line 8
    :cond_0
    iget-object v0, p0, Lrc/i$a;->a:Lcc/q;

    .line 9
    .line 10
    invoke-interface {v0, p1}, Lcc/q;->onNext(Ljava/lang/Object;)V

    .line 11
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
.end method
