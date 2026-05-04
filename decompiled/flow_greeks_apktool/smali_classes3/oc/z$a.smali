.class public final Loc/z$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/i;
.implements Lfc/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Loc/z;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lcc/t;

.field public b:Lkh/c;

.field public c:Ljava/util/Collection;


# direct methods
.method public constructor <init>(Lcc/t;Ljava/util/Collection;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Loc/z$a;->a:Lcc/t;

    .line 5
    .line 6
    iput-object p2, p0, Loc/z$a;->c:Ljava/util/Collection;

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
.method public b(Lkh/c;)V
    .locals 2

    .line 1
    iget-object v0, p0, Loc/z$a;->b:Lkh/c;

    .line 2
    .line 3
    invoke-static {v0, p1}, Lwc/g;->m(Lkh/c;Lkh/c;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    iput-object p1, p0, Loc/z$a;->b:Lkh/c;

    .line 10
    .line 11
    iget-object v0, p0, Loc/z$a;->a:Lcc/t;

    .line 12
    .line 13
    invoke-interface {v0, p0}, Lcc/t;->a(Lfc/b;)V

    .line 14
    .line 15
    .line 16
    const-wide v0, 0x7fffffffffffffffL

    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    invoke-interface {p1, v0, v1}, Lkh/c;->request(J)V

    .line 22
    .line 23
    .line 24
    :cond_0
    return-void
    .line 25
    .line 26
.end method

.method public c()Z
    .locals 2

    .line 1
    iget-object v0, p0, Loc/z$a;->b:Lkh/c;

    .line 2
    .line 3
    sget-object v1, Lwc/g;->a:Lwc/g;

    .line 4
    .line 5
    if-ne v0, v1, :cond_0

    .line 6
    .line 7
    const/4 v0, 0x1

    .line 8
    return v0

    .line 9
    :cond_0
    const/4 v0, 0x0

    .line 10
    return v0
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
    iget-object v0, p0, Loc/z$a;->b:Lkh/c;

    .line 2
    .line 3
    invoke-interface {v0}, Lkh/c;->cancel()V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 7
    .line 8
    iput-object v0, p0, Loc/z$a;->b:Lkh/c;

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
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 2
    .line 3
    iput-object v0, p0, Loc/z$a;->b:Lkh/c;

    .line 4
    .line 5
    iget-object v0, p0, Loc/z$a;->a:Lcc/t;

    .line 6
    .line 7
    iget-object v1, p0, Loc/z$a;->c:Ljava/util/Collection;

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
    const/4 v0, 0x0

    .line 2
    iput-object v0, p0, Loc/z$a;->c:Ljava/util/Collection;

    .line 3
    .line 4
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 5
    .line 6
    iput-object v0, p0, Loc/z$a;->b:Lkh/c;

    .line 7
    .line 8
    iget-object v0, p0, Loc/z$a;->a:Lcc/t;

    .line 9
    .line 10
    invoke-interface {v0, p1}, Lcc/t;->onError(Ljava/lang/Throwable;)V

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

.method public onNext(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget-object v0, p0, Loc/z$a;->c:Ljava/util/Collection;

    .line 2
    .line 3
    invoke-interface {v0, p1}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

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
