.class public Le8/i;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Ljava/util/Map;

.field public final b:La7/g;

.field public final c:Lj8/b0;

.field public final d:Lj8/b0;


# direct methods
.method public constructor <init>(La7/g;Lfa/a;Lfa/a;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/HashMap;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Le8/i;->a:Ljava/util/Map;

    .line 10
    .line 11
    iput-object p1, p0, Le8/i;->b:La7/g;

    .line 12
    .line 13
    new-instance p1, Lf8/n;

    .line 14
    .line 15
    invoke-direct {p1, p2}, Lf8/n;-><init>(Lfa/a;)V

    .line 16
    .line 17
    .line 18
    iput-object p1, p0, Le8/i;->c:Lj8/b0;

    .line 19
    .line 20
    new-instance p1, Lf8/g;

    .line 21
    .line 22
    invoke-direct {p1, p3}, Lf8/g;-><init>(Lfa/a;)V

    .line 23
    .line 24
    .line 25
    iput-object p1, p0, Le8/i;->d:Lj8/b0;

    .line 26
    .line 27
    return-void
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
.end method


# virtual methods
.method public declared-synchronized a(Lj8/q;)Le8/h;
    .locals 3

    .line 1
    monitor-enter p0

    .line 2
    :try_start_0
    iget-object v0, p0, Le8/i;->a:Ljava/util/Map;

    .line 3
    .line 4
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    .line 5
    .line 6
    .line 7
    move-result-object v0

    .line 8
    check-cast v0, Le8/h;

    .line 9
    .line 10
    if-nez v0, :cond_1

    .line 11
    .line 12
    new-instance v0, Lj8/h;

    .line 13
    .line 14
    invoke-direct {v0}, Lj8/h;-><init>()V

    .line 15
    .line 16
    .line 17
    iget-object v1, p0, Le8/i;->b:La7/g;

    .line 18
    .line 19
    invoke-virtual {v1}, La7/g;->y()Z

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    if-nez v1, :cond_0

    .line 24
    .line 25
    iget-object v1, p0, Le8/i;->b:La7/g;

    .line 26
    .line 27
    invoke-virtual {v1}, La7/g;->q()Ljava/lang/String;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    invoke-virtual {v0, v1}, Lj8/h;->N(Ljava/lang/String;)V

    .line 32
    .line 33
    .line 34
    goto :goto_0

    .line 35
    :catchall_0
    move-exception p1

    .line 36
    goto :goto_1

    .line 37
    :cond_0
    :goto_0
    iget-object v1, p0, Le8/i;->b:La7/g;

    .line 38
    .line 39
    invoke-virtual {v0, v1}, Lj8/h;->J(La7/g;)V

    .line 40
    .line 41
    .line 42
    iget-object v1, p0, Le8/i;->c:Lj8/b0;

    .line 43
    .line 44
    invoke-virtual {v0, v1}, Lj8/h;->I(Lj8/b0;)V

    .line 45
    .line 46
    .line 47
    iget-object v1, p0, Le8/i;->d:Lj8/b0;

    .line 48
    .line 49
    invoke-virtual {v0, v1}, Lj8/h;->H(Lj8/b0;)V

    .line 50
    .line 51
    .line 52
    new-instance v1, Le8/h;

    .line 53
    .line 54
    iget-object v2, p0, Le8/i;->b:La7/g;

    .line 55
    .line 56
    invoke-direct {v1, v2, p1, v0}, Le8/h;-><init>(La7/g;Lj8/q;Lj8/h;)V

    .line 57
    .line 58
    .line 59
    iget-object v0, p0, Le8/i;->a:Ljava/util/Map;

    .line 60
    .line 61
    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 62
    .line 63
    .line 64
    move-object v0, v1

    .line 65
    :cond_1
    monitor-exit p0

    .line 66
    return-object v0

    .line 67
    :goto_1
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 68
    throw p1
    .line 69
    .line 70
    .line 71
.end method
