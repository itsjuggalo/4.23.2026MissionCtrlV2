.class public final Ltb/r1$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lrb/r0$k;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/r1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "c"
.end annotation


# instance fields
.field public a:Lrb/q;

.field public b:Ltb/r1$g;

.field public final synthetic c:Ltb/r1;


# direct methods
.method public constructor <init>(Ltb/r1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/r1$c;->c:Ltb/r1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    sget-object p1, Lrb/p;->d:Lrb/p;

    invoke-static {p1}, Lrb/q;->a(Lrb/p;)Lrb/q;

    move-result-object p1

    iput-object p1, p0, Ltb/r1$c;->a:Lrb/q;

    return-void
.end method

.method public synthetic constructor <init>(Ltb/r1;Ltb/r1$a;)V
    .locals 0

    .line 3
    invoke-direct {p0, p1}, Ltb/r1$c;-><init>(Ltb/r1;)V

    return-void
.end method

.method public static synthetic b(Ltb/r1$c;)Lrb/q;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/r1$c;->a:Lrb/q;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic c(Ltb/r1$c;Lrb/q;)Lrb/q;
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/r1$c;->a:Lrb/q;

    .line 2
    .line 3
    return-object p1
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

.method public static synthetic d(Ltb/r1$c;Ltb/r1$g;)Ltb/r1$g;
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/r1$c;->b:Ltb/r1$g;

    .line 2
    .line 3
    return-object p1
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
.method public a(Lrb/q;)V
    .locals 4

    .line 1
    invoke-static {}, Ltb/r1;->h()Ljava/util/logging/Logger;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    sget-object v1, Ljava/util/logging/Level;->FINE:Ljava/util/logging/Level;

    .line 6
    .line 7
    iget-object v2, p0, Ltb/r1$c;->b:Ltb/r1$g;

    .line 8
    .line 9
    invoke-static {v2}, Ltb/r1$g;->d(Ltb/r1$g;)Lrb/r0$i;

    .line 10
    .line 11
    .line 12
    move-result-object v2

    .line 13
    filled-new-array {p1, v2}, [Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    const-string v3, "Received health status {0} for subchannel {1}"

    .line 18
    .line 19
    invoke-virtual {v0, v1, v3, v2}, Ljava/util/logging/Logger;->log(Ljava/util/logging/Level;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 20
    .line 21
    .line 22
    iput-object p1, p0, Ltb/r1$c;->a:Lrb/q;

    .line 23
    .line 24
    iget-object p1, p0, Ltb/r1$c;->c:Ltb/r1;

    .line 25
    .line 26
    invoke-static {p1}, Ltb/r1;->m(Ltb/r1;)Ltb/r1$d;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    invoke-virtual {p1}, Ltb/r1$d;->c()Z

    .line 31
    .line 32
    .line 33
    move-result p1

    .line 34
    if-eqz p1, :cond_0

    .line 35
    .line 36
    iget-object p1, p0, Ltb/r1$c;->c:Ltb/r1;

    .line 37
    .line 38
    invoke-static {p1}, Ltb/r1;->i(Ltb/r1;)Ljava/util/Map;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    iget-object v0, p0, Ltb/r1$c;->c:Ltb/r1;

    .line 43
    .line 44
    invoke-static {v0}, Ltb/r1;->m(Ltb/r1;)Ltb/r1$d;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    invoke-virtual {v0}, Ltb/r1$d;->a()Ljava/net/SocketAddress;

    .line 49
    .line 50
    .line 51
    move-result-object v0

    .line 52
    invoke-interface {p1, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    .line 54
    .line 55
    move-result-object p1

    .line 56
    check-cast p1, Ltb/r1$g;

    .line 57
    .line 58
    invoke-static {p1}, Ltb/r1$g;->e(Ltb/r1$g;)Ltb/r1$c;

    .line 59
    .line 60
    .line 61
    move-result-object p1

    .line 62
    if-ne p1, p0, :cond_0

    .line 63
    .line 64
    iget-object p1, p0, Ltb/r1$c;->c:Ltb/r1;

    .line 65
    .line 66
    iget-object v0, p0, Ltb/r1$c;->b:Ltb/r1$g;

    .line 67
    .line 68
    invoke-static {p1, v0}, Ltb/r1;->j(Ltb/r1;Ltb/r1$g;)V

    .line 69
    .line 70
    .line 71
    :cond_0
    return-void
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
