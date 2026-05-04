.class public final Lfe/e1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lfe/e1$a;
    }
.end annotation


# static fields
.field public static final e:Lfe/e1$a;

.field public static final synthetic f:[Lwd/m;


# instance fields
.field public final a:Lfe/e;

.field public final b:Lpd/k;

.field public final c:Lyf/g;

.field public final d:Lwf/i;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .line 1
    new-instance v0, Lkotlin/jvm/internal/g0;

    .line 2
    .line 3
    const-class v1, Lfe/e1;

    .line 4
    .line 5
    const-string v2, "scopeForOwnerModule"

    .line 6
    .line 7
    const-string v3, "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"

    .line 8
    .line 9
    const/4 v4, 0x0

    .line 10
    invoke-direct {v0, v1, v2, v3, v4}, Lkotlin/jvm/internal/g0;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V

    .line 11
    .line 12
    .line 13
    invoke-static {v0}, Lkotlin/jvm/internal/n0;->g(Lkotlin/jvm/internal/f0;)Lwd/o;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    const/4 v1, 0x1

    .line 18
    new-array v1, v1, [Lwd/m;

    .line 19
    .line 20
    aput-object v0, v1, v4

    .line 21
    .line 22
    sput-object v1, Lfe/e1;->f:[Lwd/m;

    .line 23
    .line 24
    new-instance v0, Lfe/e1$a;

    .line 25
    .line 26
    const/4 v1, 0x0

    .line 27
    invoke-direct {v0, v1}, Lfe/e1$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 28
    .line 29
    .line 30
    sput-object v0, Lfe/e1;->e:Lfe/e1$a;

    .line 31
    .line 32
    return-void
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
.end method

.method public constructor <init>(Lfe/e;Lwf/n;Lpd/k;Lyf/g;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lfe/e1;->a:Lfe/e;

    .line 4
    iput-object p3, p0, Lfe/e1;->b:Lpd/k;

    .line 5
    iput-object p4, p0, Lfe/e1;->c:Lyf/g;

    .line 6
    new-instance p1, Lfe/c1;

    invoke-direct {p1, p0}, Lfe/c1;-><init>(Lfe/e1;)V

    invoke-interface {p2, p1}, Lwf/n;->e(Lkotlin/jvm/functions/Function0;)Lwf/i;

    move-result-object p1

    iput-object p1, p0, Lfe/e1;->d:Lwf/i;

    return-void
.end method

.method public synthetic constructor <init>(Lfe/e;Lwf/n;Lpd/k;Lyf/g;Lkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3, p4}, Lfe/e1;-><init>(Lfe/e;Lwf/n;Lpd/k;Lyf/g;)V

    return-void
.end method

.method public static synthetic a(Lfe/e1;)Lqf/k;
    .locals 0

    .line 1
    invoke-static {p0}, Lfe/e1;->f(Lfe/e1;)Lqf/k;

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

.method public static synthetic b(Lfe/e1;Lyf/g;)Lqf/k;
    .locals 0

    .line 1
    invoke-static {p0, p1}, Lfe/e1;->d(Lfe/e1;Lyf/g;)Lqf/k;

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

.method public static final d(Lfe/e1;Lyf/g;)Lqf/k;
    .locals 0

    .line 1
    iget-object p0, p0, Lfe/e1;->b:Lpd/k;

    .line 2
    .line 3
    invoke-interface {p0, p1}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lqf/k;

    .line 8
    .line 9
    return-object p0
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

.method public static final f(Lfe/e1;)Lqf/k;
    .locals 1

    .line 1
    iget-object v0, p0, Lfe/e1;->b:Lpd/k;

    .line 2
    .line 3
    iget-object p0, p0, Lfe/e1;->c:Lyf/g;

    .line 4
    .line 5
    invoke-interface {v0, p0}, Lpd/k;->invoke(Ljava/lang/Object;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    check-cast p0, Lqf/k;

    .line 10
    .line 11
    return-object p0
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
.method public final c(Lyf/g;)Lqf/k;
    .locals 2

    .line 1
    const-string v0, "kotlinTypeRefiner"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lfe/e1;->a:Lfe/e;

    .line 7
    .line 8
    invoke-static {v0}, Lnf/e;->s(Lfe/m;)Lfe/h0;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-virtual {p1, v0}, Lyf/g;->d(Lfe/h0;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-nez v0, :cond_0

    .line 17
    .line 18
    invoke-virtual {p0}, Lfe/e1;->e()Lqf/k;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    return-object p1

    .line 23
    :cond_0
    iget-object v0, p0, Lfe/e1;->a:Lfe/e;

    .line 24
    .line 25
    invoke-interface {v0}, Lfe/h;->k()Lxf/u1;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    const-string v1, "getTypeConstructor(...)"

    .line 30
    .line 31
    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {p1, v0}, Lyf/g;->e(Lxf/u1;)Z

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    if-nez v0, :cond_1

    .line 39
    .line 40
    invoke-virtual {p0}, Lfe/e1;->e()Lqf/k;

    .line 41
    .line 42
    .line 43
    move-result-object p1

    .line 44
    return-object p1

    .line 45
    :cond_1
    iget-object v0, p0, Lfe/e1;->a:Lfe/e;

    .line 46
    .line 47
    new-instance v1, Lfe/d1;

    .line 48
    .line 49
    invoke-direct {v1, p0, p1}, Lfe/d1;-><init>(Lfe/e1;Lyf/g;)V

    .line 50
    .line 51
    .line 52
    invoke-virtual {p1, v0, v1}, Lyf/g;->c(Lfe/e;Lkotlin/jvm/functions/Function0;)Lqf/k;

    .line 53
    .line 54
    .line 55
    move-result-object p1

    .line 56
    return-object p1
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

.method public final e()Lqf/k;
    .locals 3

    .line 1
    iget-object v0, p0, Lfe/e1;->d:Lwf/i;

    .line 2
    .line 3
    sget-object v1, Lfe/e1;->f:[Lwd/m;

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    aget-object v1, v1, v2

    .line 7
    .line 8
    invoke-static {v0, p0, v1}, Lwf/m;->a(Lwf/i;Ljava/lang/Object;Lwd/m;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    check-cast v0, Lqf/k;

    .line 13
    .line 14
    return-object v0
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
