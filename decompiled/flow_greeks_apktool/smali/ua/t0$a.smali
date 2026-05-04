.class public final Lua/t0$a;
.super Lid/m;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lpd/o;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lua/t0;-><init>(Lxa/j;Lua/n0;Lua/k0;Lua/w0;Ll1/i;Lua/w;Lgd/i;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public a:I

.field public final synthetic b:Lua/t0;


# direct methods
.method public constructor <init>(Lua/t0;Lgd/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lua/t0$a;->b:Lua/t0;

    .line 2
    .line 3
    const/4 p1, 0x2

    .line 4
    invoke-direct {p0, p1, p2}, Lid/m;-><init>(ILgd/e;)V

    .line 5
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
.end method


# virtual methods
.method public final create(Ljava/lang/Object;Lgd/e;)Lgd/e;
    .locals 1

    .line 1
    new-instance p1, Lua/t0$a;

    .line 2
    .line 3
    iget-object v0, p0, Lua/t0$a;->b:Lua/t0;

    .line 4
    .line 5
    invoke-direct {p1, v0, p2}, Lua/t0$a;-><init>(Lua/t0;Lgd/e;)V

    .line 6
    .line 7
    .line 8
    return-object p1
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
.end method

.method public bridge synthetic invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    .line 1
    check-cast p1, Lng/n0;

    check-cast p2, Lgd/e;

    invoke-virtual {p0, p1, p2}, Lua/t0$a;->invoke(Lng/n0;Lgd/e;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invoke(Lng/n0;Lgd/e;)Ljava/lang/Object;
    .locals 0

    .line 2
    invoke-virtual {p0, p1, p2}, Lua/t0$a;->create(Ljava/lang/Object;Lgd/e;)Lgd/e;

    move-result-object p1

    check-cast p1, Lua/t0$a;

    sget-object p2, Lcd/h0;->a:Lcd/h0;

    invoke-virtual {p1, p2}, Lua/t0$a;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    return-object p1
.end method

.method public final invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5

    .line 1
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget v1, p0, Lua/t0$a;->a:I

    .line 6
    .line 7
    const/4 v2, 0x1

    .line 8
    if-eqz v1, :cond_1

    .line 9
    .line 10
    if-ne v1, v2, :cond_0

    .line 11
    .line 12
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 13
    .line 14
    .line 15
    goto :goto_0

    .line 16
    :cond_0
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 17
    .line 18
    const-string v0, "call to \'resume\' before \'invoke\' with coroutine"

    .line 19
    .line 20
    invoke-direct {p1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 21
    .line 22
    .line 23
    throw p1

    .line 24
    :cond_1
    invoke-static {p1}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    iget-object p1, p0, Lua/t0$a;->b:Lua/t0;

    .line 28
    .line 29
    invoke-static {p1}, Lua/t0;->e(Lua/t0;)Ll1/i;

    .line 30
    .line 31
    .line 32
    move-result-object p1

    .line 33
    invoke-interface {p1}, Ll1/i;->getData()Lqg/d;

    .line 34
    .line 35
    .line 36
    move-result-object p1

    .line 37
    new-instance v1, Lua/t0$a$a;

    .line 38
    .line 39
    iget-object v3, p0, Lua/t0$a;->b:Lua/t0;

    .line 40
    .line 41
    const/4 v4, 0x0

    .line 42
    invoke-direct {v1, v3, v4}, Lua/t0$a$a;-><init>(Lua/t0;Lgd/e;)V

    .line 43
    .line 44
    .line 45
    invoke-static {p1, v1}, Lqg/f;->d(Lqg/d;Lpd/p;)Lqg/d;

    .line 46
    .line 47
    .line 48
    move-result-object p1

    .line 49
    new-instance v1, Lua/t0$a$b;

    .line 50
    .line 51
    iget-object v3, p0, Lua/t0$a;->b:Lua/t0;

    .line 52
    .line 53
    invoke-direct {v1, v3}, Lua/t0$a$b;-><init>(Lua/t0;)V

    .line 54
    .line 55
    .line 56
    iput v2, p0, Lua/t0$a;->a:I

    .line 57
    .line 58
    invoke-interface {p1, v1, p0}, Lqg/d;->collect(Lqg/e;Lgd/e;)Ljava/lang/Object;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    if-ne p1, v0, :cond_2

    .line 63
    .line 64
    return-object v0

    .line 65
    :cond_2
    :goto_0
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 66
    .line 67
    return-object p1
    .line 68
    .line 69
    .line 70
    .line 71
.end method
