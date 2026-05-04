.class public Lk8/b;
.super Lk8/d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public constructor <init>(Lk8/e;Lj8/l;)V
    .locals 1

    .line 1
    sget-object v0, Lk8/d$a;->d:Lk8/d$a;

    .line 2
    .line 3
    invoke-direct {p0, v0, p1, p2}, Lk8/d;-><init>(Lk8/d$a;Lk8/e;Lj8/l;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p1}, Lk8/e;->d()Z

    .line 7
    .line 8
    .line 9
    move-result p1

    .line 10
    xor-int/lit8 p1, p1, 0x1

    .line 11
    .line 12
    const-string p2, "Can\'t have a listen complete from a user source"

    .line 13
    .line 14
    invoke-static {p1, p2}, Lm8/m;->g(ZLjava/lang/String;)V

    .line 15
    .line 16
    .line 17
    return-void
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
.method public d(Lr8/b;)Lk8/d;
    .locals 2

    .line 1
    iget-object p1, p0, Lk8/d;->c:Lj8/l;

    .line 2
    .line 3
    invoke-virtual {p1}, Lj8/l;->isEmpty()Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    new-instance p1, Lk8/b;

    .line 10
    .line 11
    iget-object v0, p0, Lk8/d;->b:Lk8/e;

    .line 12
    .line 13
    invoke-static {}, Lj8/l;->G()Lj8/l;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-direct {p1, v0, v1}, Lk8/b;-><init>(Lk8/e;Lj8/l;)V

    .line 18
    .line 19
    .line 20
    return-object p1

    .line 21
    :cond_0
    new-instance p1, Lk8/b;

    .line 22
    .line 23
    iget-object v0, p0, Lk8/d;->b:Lk8/e;

    .line 24
    .line 25
    iget-object v1, p0, Lk8/d;->c:Lj8/l;

    .line 26
    .line 27
    invoke-virtual {v1}, Lj8/l;->S()Lj8/l;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    invoke-direct {p1, v0, v1}, Lk8/b;-><init>(Lk8/e;Lj8/l;)V

    .line 32
    .line 33
    .line 34
    return-object p1
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
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 1
    invoke-virtual {p0}, Lk8/d;->a()Lj8/l;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p0}, Lk8/d;->b()Lk8/e;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    filled-new-array {v0, v1}, [Ljava/lang/Object;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    const-string v1, "ListenComplete { path=%s, source=%s }"

    .line 14
    .line 15
    invoke-static {v1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    return-object v0
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
.end method
