.class public final Lpc/l$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/l;
.implements Lfc/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lpc/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lcc/t;

.field public b:Lfc/b;


# direct methods
.method public constructor <init>(Lcc/t;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lpc/l$a;->a:Lcc/t;

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
.method public a(Lfc/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 2
    .line 3
    invoke-static {v0, p1}, Ljc/b;->m(Lfc/b;Lfc/b;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    iput-object p1, p0, Lpc/l$a;->b:Lfc/b;

    .line 10
    .line 11
    iget-object p1, p0, Lpc/l$a;->a:Lcc/t;

    .line 12
    .line 13
    invoke-interface {p1, p0}, Lcc/t;->a(Lfc/b;)V

    .line 14
    .line 15
    .line 16
    :cond_0
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
.end method

.method public c()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 2
    .line 3
    invoke-interface {v0}, Lfc/b;->c()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
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

.method public dispose()V
    .locals 1

    .line 1
    iget-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 2
    .line 3
    invoke-interface {v0}, Lfc/b;->dispose()V

    .line 4
    .line 5
    .line 6
    sget-object v0, Ljc/b;->a:Ljc/b;

    .line 7
    .line 8
    iput-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 9
    .line 10
    return-void
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

.method public onComplete()V
    .locals 2

    .line 1
    sget-object v0, Ljc/b;->a:Ljc/b;

    .line 2
    .line 3
    iput-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 4
    .line 5
    iget-object v0, p0, Lpc/l$a;->a:Lcc/t;

    .line 6
    .line 7
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 8
    .line 9
    invoke-interface {v0, v1}, Lcc/t;->onSuccess(Ljava/lang/Object;)V

    .line 10
    .line 11
    .line 12
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    sget-object v0, Ljc/b;->a:Ljc/b;

    .line 2
    .line 3
    iput-object v0, p0, Lpc/l$a;->b:Lfc/b;

    .line 4
    .line 5
    iget-object v0, p0, Lpc/l$a;->a:Lcc/t;

    .line 6
    .line 7
    invoke-interface {v0, p1}, Lcc/t;->onError(Ljava/lang/Throwable;)V

    .line 8
    .line 9
    .line 10
    return-void
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

.method public onSuccess(Ljava/lang/Object;)V
    .locals 1

    .line 1
    sget-object p1, Ljc/b;->a:Ljc/b;

    .line 2
    .line 3
    iput-object p1, p0, Lpc/l$a;->b:Lfc/b;

    .line 4
    .line 5
    iget-object p1, p0, Lpc/l$a;->a:Lcc/t;

    .line 6
    .line 7
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 8
    .line 9
    invoke-interface {p1, v0}, Lcc/t;->onSuccess(Ljava/lang/Object;)V

    .line 10
    .line 11
    .line 12
    return-void
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
