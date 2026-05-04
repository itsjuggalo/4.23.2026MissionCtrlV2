.class public final Lzd/l1;
.super Lzd/d2;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lwd/k;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lzd/l1$a;
    }
.end annotation


# instance fields
.field public final q:Lcd/k;


# direct methods
.method public constructor <init>(Lzd/c1;Lfe/y0;)V
    .locals 1

    const-string v0, "container"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "descriptor"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 3
    invoke-direct {p0, p1, p2}, Lzd/d2;-><init>(Lzd/c1;Lfe/y0;)V

    .line 4
    sget-object p1, Lcd/n;->b:Lcd/n;

    new-instance p2, Lzd/k1;

    invoke-direct {p2, p0}, Lzd/k1;-><init>(Lzd/l1;)V

    invoke-static {p1, p2}, Lcd/l;->a(Lcd/n;Lkotlin/jvm/functions/Function0;)Lcd/k;

    move-result-object p1

    iput-object p1, p0, Lzd/l1;->q:Lcd/k;

    return-void
.end method

.method public constructor <init>(Lzd/c1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1

    const-string v0, "container"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "name"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "signature"

    invoke-static {p3, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-direct {p0, p1, p2, p3, p4}, Lzd/d2;-><init>(Lzd/c1;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 2
    sget-object p1, Lcd/n;->b:Lcd/n;

    new-instance p2, Lzd/k1;

    invoke-direct {p2, p0}, Lzd/k1;-><init>(Lzd/l1;)V

    invoke-static {p1, p2}, Lcd/l;->a(Lcd/n;Lkotlin/jvm/functions/Function0;)Lcd/k;

    move-result-object p1

    iput-object p1, p0, Lzd/l1;->q:Lcd/k;

    return-void
.end method

.method public static final m0(Lzd/l1;)Lzd/l1$a;
    .locals 1

    .line 1
    new-instance v0, Lzd/l1$a;

    .line 2
    .line 3
    invoke-direct {v0, p0}, Lzd/l1$a;-><init>(Lzd/l1;)V

    .line 4
    .line 5
    .line 6
    return-object v0
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

.method public static synthetic n0(Lzd/l1;)Lzd/l1$a;
    .locals 0

    .line 1
    invoke-static {p0}, Lzd/l1;->m0(Lzd/l1;)Lzd/l1$a;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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


# virtual methods
.method public bridge synthetic g()Lwd/i$a;
    .locals 1

    .line 1
    invoke-virtual {p0}, Lzd/l1;->o0()Lzd/l1$a;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic g()Lwd/k$a;
    .locals 1

    .line 2
    invoke-virtual {p0}, Lzd/l1;->o0()Lzd/l1$a;

    move-result-object v0

    return-object v0
.end method

.method public o0()Lzd/l1$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lzd/l1;->q:Lcd/k;

    .line 2
    .line 3
    invoke-interface {v0}, Lcd/k;->getValue()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lzd/l1$a;

    .line 8
    .line 9
    return-object v0
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

.method public p0(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Lzd/l1;->o0()Lzd/l1$a;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    filled-new-array {p1, p2}, [Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-virtual {v0, p1}, Lzd/a0;->call([Ljava/lang/Object;)Ljava/lang/Object;

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
