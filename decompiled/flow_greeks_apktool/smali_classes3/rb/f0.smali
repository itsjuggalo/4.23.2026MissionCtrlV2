.class public final Lrb/f0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lrb/f0$a;,
        Lrb/f0$b;
    }
.end annotation


# instance fields
.field public final a:Ljava/lang/String;

.field public final b:Lrb/f0$b;

.field public final c:J

.field public final d:Lrb/p0;

.field public final e:Lrb/p0;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lrb/f0$b;JLrb/p0;Lrb/p0;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p1, p0, Lrb/f0;->a:Ljava/lang/String;

    .line 4
    const-string p1, "severity"

    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    check-cast p1, Lrb/f0$b;

    iput-object p1, p0, Lrb/f0;->b:Lrb/f0$b;

    .line 5
    iput-wide p3, p0, Lrb/f0;->c:J

    .line 6
    iput-object p5, p0, Lrb/f0;->d:Lrb/p0;

    .line 7
    iput-object p6, p0, Lrb/f0;->e:Lrb/p0;

    return-void
.end method

.method public synthetic constructor <init>(Ljava/lang/String;Lrb/f0$b;JLrb/p0;Lrb/p0;Lrb/e0$a;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p6}, Lrb/f0;-><init>(Ljava/lang/String;Lrb/f0$b;JLrb/p0;Lrb/p0;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6

    .line 1
    instance-of v0, p1, Lrb/f0;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    check-cast p1, Lrb/f0;

    .line 7
    .line 8
    iget-object v0, p0, Lrb/f0;->a:Ljava/lang/String;

    .line 9
    .line 10
    iget-object v2, p1, Lrb/f0;->a:Ljava/lang/String;

    .line 11
    .line 12
    invoke-static {v0, v2}, Lp6/j;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    iget-object v0, p0, Lrb/f0;->b:Lrb/f0$b;

    .line 19
    .line 20
    iget-object v2, p1, Lrb/f0;->b:Lrb/f0$b;

    .line 21
    .line 22
    invoke-static {v0, v2}, Lp6/j;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    if-eqz v0, :cond_0

    .line 27
    .line 28
    iget-wide v2, p0, Lrb/f0;->c:J

    .line 29
    .line 30
    iget-wide v4, p1, Lrb/f0;->c:J

    .line 31
    .line 32
    cmp-long v0, v2, v4

    .line 33
    .line 34
    if-nez v0, :cond_0

    .line 35
    .line 36
    iget-object v0, p0, Lrb/f0;->d:Lrb/p0;

    .line 37
    .line 38
    iget-object v2, p1, Lrb/f0;->d:Lrb/p0;

    .line 39
    .line 40
    invoke-static {v0, v2}, Lp6/j;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 41
    .line 42
    .line 43
    move-result v0

    .line 44
    if-eqz v0, :cond_0

    .line 45
    .line 46
    iget-object v0, p0, Lrb/f0;->e:Lrb/p0;

    .line 47
    .line 48
    iget-object p1, p1, Lrb/f0;->e:Lrb/p0;

    .line 49
    .line 50
    invoke-static {v0, p1}, Lp6/j;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 51
    .line 52
    .line 53
    move-result p1

    .line 54
    if-eqz p1, :cond_0

    .line 55
    .line 56
    const/4 p1, 0x1

    .line 57
    return p1

    .line 58
    :cond_0
    return v1
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

.method public hashCode()I
    .locals 5

    .line 1
    iget-object v0, p0, Lrb/f0;->a:Ljava/lang/String;

    .line 2
    .line 3
    iget-object v1, p0, Lrb/f0;->b:Lrb/f0$b;

    .line 4
    .line 5
    iget-wide v2, p0, Lrb/f0;->c:J

    .line 6
    .line 7
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 8
    .line 9
    .line 10
    move-result-object v2

    .line 11
    iget-object v3, p0, Lrb/f0;->d:Lrb/p0;

    .line 12
    .line 13
    iget-object v4, p0, Lrb/f0;->e:Lrb/p0;

    .line 14
    .line 15
    filled-new-array {v0, v1, v2, v3, v4}, [Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    invoke-static {v0}, Lp6/j;->b([Ljava/lang/Object;)I

    .line 20
    .line 21
    .line 22
    move-result v0

    .line 23
    return v0
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

.method public toString()Ljava/lang/String;
    .locals 4

    .line 1
    invoke-static {p0}, Lp6/h;->b(Ljava/lang/Object;)Lp6/h$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "description"

    .line 6
    .line 7
    iget-object v2, p0, Lrb/f0;->a:Ljava/lang/String;

    .line 8
    .line 9
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    const-string v1, "severity"

    .line 14
    .line 15
    iget-object v2, p0, Lrb/f0;->b:Lrb/f0$b;

    .line 16
    .line 17
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    const-string v1, "timestampNanos"

    .line 22
    .line 23
    iget-wide v2, p0, Lrb/f0;->c:J

    .line 24
    .line 25
    invoke-virtual {v0, v1, v2, v3}, Lp6/h$b;->c(Ljava/lang/String;J)Lp6/h$b;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    const-string v1, "channelRef"

    .line 30
    .line 31
    iget-object v2, p0, Lrb/f0;->d:Lrb/p0;

    .line 32
    .line 33
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 34
    .line 35
    .line 36
    move-result-object v0

    .line 37
    const-string v1, "subchannelRef"

    .line 38
    .line 39
    iget-object v2, p0, Lrb/f0;->e:Lrb/p0;

    .line 40
    .line 41
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    invoke-virtual {v0}, Lp6/h$b;->toString()Ljava/lang/String;

    .line 46
    .line 47
    .line 48
    move-result-object v0

    .line 49
    return-object v0
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
