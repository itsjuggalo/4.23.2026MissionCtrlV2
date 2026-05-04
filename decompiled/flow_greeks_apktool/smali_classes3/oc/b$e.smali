.class public final Loc/b$e;
.super Lwc/f;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/i;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Loc/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "e"
.end annotation


# instance fields
.field public final i:Loc/b$f;

.field public j:J


# direct methods
.method public constructor <init>(Loc/b$f;)V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-direct {p0, v0}, Lwc/f;-><init>(Z)V

    .line 3
    .line 4
    .line 5
    iput-object p1, p0, Loc/b$e;->i:Loc/b$f;

    .line 6
    .line 7
    return-void
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
.method public b(Lkh/c;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Lwc/f;->g(Lkh/c;)V

    .line 2
    .line 3
    .line 4
    return-void
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public onComplete()V
    .locals 5

    .line 1
    iget-wide v0, p0, Loc/b$e;->j:J

    .line 2
    .line 3
    const-wide/16 v2, 0x0

    .line 4
    .line 5
    cmp-long v4, v0, v2

    .line 6
    .line 7
    if-eqz v4, :cond_0

    .line 8
    .line 9
    iput-wide v2, p0, Loc/b$e;->j:J

    .line 10
    .line 11
    invoke-virtual {p0, v0, v1}, Lwc/f;->f(J)V

    .line 12
    .line 13
    .line 14
    :cond_0
    iget-object v0, p0, Loc/b$e;->i:Loc/b$f;

    .line 15
    .line 16
    invoke-interface {v0}, Loc/b$f;->c()V

    .line 17
    .line 18
    .line 19
    return-void
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 5

    .line 1
    iget-wide v0, p0, Loc/b$e;->j:J

    .line 2
    .line 3
    const-wide/16 v2, 0x0

    .line 4
    .line 5
    cmp-long v4, v0, v2

    .line 6
    .line 7
    if-eqz v4, :cond_0

    .line 8
    .line 9
    iput-wide v2, p0, Loc/b$e;->j:J

    .line 10
    .line 11
    invoke-virtual {p0, v0, v1}, Lwc/f;->f(J)V

    .line 12
    .line 13
    .line 14
    :cond_0
    iget-object v0, p0, Loc/b$e;->i:Loc/b$f;

    .line 15
    .line 16
    invoke-interface {v0, p1}, Loc/b$f;->e(Ljava/lang/Throwable;)V

    .line 17
    .line 18
    .line 19
    return-void
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 4

    .line 1
    iget-wide v0, p0, Loc/b$e;->j:J

    .line 2
    .line 3
    const-wide/16 v2, 0x1

    .line 4
    .line 5
    add-long/2addr v0, v2

    .line 6
    iput-wide v0, p0, Loc/b$e;->j:J

    .line 7
    .line 8
    iget-object v0, p0, Loc/b$e;->i:Loc/b$f;

    .line 9
    .line 10
    invoke-interface {v0, p1}, Loc/b$f;->a(Ljava/lang/Object;)V

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
