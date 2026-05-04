.class public final Loc/f$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/i;
.implements Lfc/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Loc/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lcc/l;

.field public final b:J

.field public c:Lkh/c;

.field public d:J

.field public e:Z


# direct methods
.method public constructor <init>(Lcc/l;J)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Loc/f$a;->a:Lcc/l;

    .line 5
    .line 6
    iput-wide p2, p0, Loc/f$a;->b:J

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
    iget-object v0, p0, Loc/f$a;->c:Lkh/c;

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
    iput-object p1, p0, Loc/f$a;->c:Lkh/c;

    .line 10
    .line 11
    iget-object v0, p0, Loc/f$a;->a:Lcc/l;

    .line 12
    .line 13
    invoke-interface {v0, p0}, Lcc/l;->a(Lfc/b;)V

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
    iget-object v0, p0, Loc/f$a;->c:Lkh/c;

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
    iget-object v0, p0, Loc/f$a;->c:Lkh/c;

    .line 2
    .line 3
    invoke-interface {v0}, Lkh/c;->cancel()V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 7
    .line 8
    iput-object v0, p0, Loc/f$a;->c:Lkh/c;

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
    .locals 1

    .line 1
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 2
    .line 3
    iput-object v0, p0, Loc/f$a;->c:Lkh/c;

    .line 4
    .line 5
    iget-boolean v0, p0, Loc/f$a;->e:Z

    .line 6
    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    const/4 v0, 0x1

    .line 10
    iput-boolean v0, p0, Loc/f$a;->e:Z

    .line 11
    .line 12
    iget-object v0, p0, Loc/f$a;->a:Lcc/l;

    .line 13
    .line 14
    invoke-interface {v0}, Lcc/l;->onComplete()V

    .line 15
    .line 16
    .line 17
    :cond_0
    return-void
    .line 18
    .line 19
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Loc/f$a;->e:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-static {p1}, Lyc/a;->q(Ljava/lang/Throwable;)V

    .line 6
    .line 7
    .line 8
    return-void

    .line 9
    :cond_0
    const/4 v0, 0x1

    .line 10
    iput-boolean v0, p0, Loc/f$a;->e:Z

    .line 11
    .line 12
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 13
    .line 14
    iput-object v0, p0, Loc/f$a;->c:Lkh/c;

    .line 15
    .line 16
    iget-object v0, p0, Loc/f$a;->a:Lcc/l;

    .line 17
    .line 18
    invoke-interface {v0, p1}, Lcc/l;->onError(Ljava/lang/Throwable;)V

    .line 19
    .line 20
    .line 21
    return-void
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 4

    .line 1
    iget-boolean v0, p0, Loc/f$a;->e:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget-wide v0, p0, Loc/f$a;->d:J

    .line 7
    .line 8
    iget-wide v2, p0, Loc/f$a;->b:J

    .line 9
    .line 10
    cmp-long v2, v0, v2

    .line 11
    .line 12
    if-nez v2, :cond_1

    .line 13
    .line 14
    const/4 v0, 0x1

    .line 15
    iput-boolean v0, p0, Loc/f$a;->e:Z

    .line 16
    .line 17
    iget-object v0, p0, Loc/f$a;->c:Lkh/c;

    .line 18
    .line 19
    invoke-interface {v0}, Lkh/c;->cancel()V

    .line 20
    .line 21
    .line 22
    sget-object v0, Lwc/g;->a:Lwc/g;

    .line 23
    .line 24
    iput-object v0, p0, Loc/f$a;->c:Lkh/c;

    .line 25
    .line 26
    iget-object v0, p0, Loc/f$a;->a:Lcc/l;

    .line 27
    .line 28
    invoke-interface {v0, p1}, Lcc/l;->onSuccess(Ljava/lang/Object;)V

    .line 29
    .line 30
    .line 31
    return-void

    .line 32
    :cond_1
    const-wide/16 v2, 0x1

    .line 33
    .line 34
    add-long/2addr v0, v2

    .line 35
    iput-wide v0, p0, Loc/f$a;->d:J

    .line 36
    .line 37
    return-void
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
