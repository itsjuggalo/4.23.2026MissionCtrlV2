.class public abstract Lzb/c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lzb/c$a;
    }
.end annotation


# instance fields
.field public final a:Lrb/d;

.field public final b:Lrb/c;


# direct methods
.method public constructor <init>(Lrb/d;Lrb/c;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    const-string v0, "channel"

    .line 5
    .line 6
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    check-cast p1, Lrb/d;

    .line 11
    .line 12
    iput-object p1, p0, Lzb/c;->a:Lrb/d;

    .line 13
    .line 14
    const-string p1, "callOptions"

    .line 15
    .line 16
    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    check-cast p1, Lrb/c;

    .line 21
    .line 22
    iput-object p1, p0, Lzb/c;->b:Lrb/c;

    .line 23
    .line 24
    return-void
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
.method public abstract a(Lrb/d;Lrb/c;)Lzb/c;
.end method

.method public final b()Lrb/c;
    .locals 1

    .line 1
    iget-object v0, p0, Lzb/c;->b:Lrb/c;

    .line 2
    .line 3
    return-object v0
    .line 4
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
.end method

.method public final c()Lrb/d;
    .locals 1

    .line 1
    iget-object v0, p0, Lzb/c;->a:Lrb/d;

    .line 2
    .line 3
    return-object v0
    .line 4
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
.end method

.method public final d(Lrb/b;)Lzb/c;
    .locals 2

    .line 1
    iget-object v0, p0, Lzb/c;->a:Lrb/d;

    .line 2
    .line 3
    iget-object v1, p0, Lzb/c;->b:Lrb/c;

    .line 4
    .line 5
    invoke-virtual {v1, p1}, Lrb/c;->l(Lrb/b;)Lrb/c;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-virtual {p0, v0, p1}, Lzb/c;->a(Lrb/d;Lrb/c;)Lzb/c;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1
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

.method public final e(JLjava/util/concurrent/TimeUnit;)Lzb/c;
    .locals 2

    .line 1
    iget-object v0, p0, Lzb/c;->a:Lrb/d;

    .line 2
    .line 3
    iget-object v1, p0, Lzb/c;->b:Lrb/c;

    .line 4
    .line 5
    invoke-virtual {v1, p1, p2, p3}, Lrb/c;->n(JLjava/util/concurrent/TimeUnit;)Lrb/c;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-virtual {p0, v0, p1}, Lzb/c;->a(Lrb/d;Lrb/c;)Lzb/c;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1
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

.method public final f(Ljava/util/concurrent/Executor;)Lzb/c;
    .locals 2

    .line 1
    iget-object v0, p0, Lzb/c;->a:Lrb/d;

    .line 2
    .line 3
    iget-object v1, p0, Lzb/c;->b:Lrb/c;

    .line 4
    .line 5
    invoke-virtual {v1, p1}, Lrb/c;->o(Ljava/util/concurrent/Executor;)Lrb/c;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-virtual {p0, v0, p1}, Lzb/c;->a(Lrb/d;Lrb/c;)Lzb/c;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    return-object p1
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
