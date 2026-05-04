.class public Ln9/r;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Ln9/g;

.field public final b:Ln9/g$d;

.field public final c:J

.field public final d:D

.field public final e:J

.field public f:J

.field public g:J

.field public h:J

.field public i:Ln9/g$b;


# direct methods
.method public constructor <init>(Ln9/g;Ln9/g$d;)V
    .locals 9

    const-wide/high16 v5, 0x3ff8000000000000L    # 1.5

    const-wide/32 v7, 0xea60

    const-wide/16 v3, 0x3e8

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    .line 10
    invoke-direct/range {v0 .. v8}, Ln9/r;-><init>(Ln9/g;Ln9/g$d;JDJ)V

    return-void
.end method

.method public constructor <init>(Ln9/g;Ln9/g$d;JDJ)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    iput-object p1, p0, Ln9/r;->a:Ln9/g;

    .line 3
    iput-object p2, p0, Ln9/r;->b:Ln9/g$d;

    .line 4
    iput-wide p3, p0, Ln9/r;->c:J

    .line 5
    iput-wide p5, p0, Ln9/r;->d:D

    .line 6
    iput-wide p7, p0, Ln9/r;->e:J

    .line 7
    iput-wide p7, p0, Ln9/r;->f:J

    .line 8
    new-instance p1, Ljava/util/Date;

    invoke-direct {p1}, Ljava/util/Date;-><init>()V

    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide p1

    iput-wide p1, p0, Ln9/r;->h:J

    .line 9
    invoke-virtual {p0}, Ln9/r;->e()V

    return-void
.end method

.method public static synthetic a(Ln9/r;Ljava/lang/Runnable;)V
    .locals 2

    .line 1
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/Date;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 7
    .line 8
    .line 9
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    .line 10
    .line 11
    .line 12
    move-result-wide v0

    .line 13
    iput-wide v0, p0, Ln9/r;->h:J

    .line 14
    .line 15
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 16
    .line 17
    .line 18
    return-void
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
.method public b(Ljava/lang/Runnable;)V
    .locals 10

    .line 1
    invoke-virtual {p0}, Ln9/r;->c()V

    .line 2
    .line 3
    .line 4
    iget-wide v0, p0, Ln9/r;->g:J

    .line 5
    .line 6
    invoke-virtual {p0}, Ln9/r;->d()J

    .line 7
    .line 8
    .line 9
    move-result-wide v2

    .line 10
    add-long/2addr v0, v2

    .line 11
    new-instance v2, Ljava/util/Date;

    .line 12
    .line 13
    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    .line 14
    .line 15
    .line 16
    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    .line 17
    .line 18
    .line 19
    move-result-wide v2

    .line 20
    iget-wide v4, p0, Ln9/r;->h:J

    .line 21
    .line 22
    sub-long/2addr v2, v4

    .line 23
    const-wide/16 v4, 0x0

    .line 24
    .line 25
    invoke-static {v4, v5, v2, v3}, Ljava/lang/Math;->max(JJ)J

    .line 26
    .line 27
    .line 28
    move-result-wide v2

    .line 29
    sub-long v6, v0, v2

    .line 30
    .line 31
    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    .line 32
    .line 33
    .line 34
    move-result-wide v6

    .line 35
    iget-wide v8, p0, Ln9/r;->g:J

    .line 36
    .line 37
    cmp-long v4, v8, v4

    .line 38
    .line 39
    if-lez v4, :cond_0

    .line 40
    .line 41
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 42
    .line 43
    .line 44
    move-result-object v4

    .line 45
    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 46
    .line 47
    .line 48
    move-result-object v4

    .line 49
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 50
    .line 51
    .line 52
    move-result-object v5

    .line 53
    iget-wide v8, p0, Ln9/r;->g:J

    .line 54
    .line 55
    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 56
    .line 57
    .line 58
    move-result-object v8

    .line 59
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 60
    .line 61
    .line 62
    move-result-object v0

    .line 63
    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 64
    .line 65
    .line 66
    move-result-object v1

    .line 67
    filled-new-array {v5, v8, v0, v1}, [Ljava/lang/Object;

    .line 68
    .line 69
    .line 70
    move-result-object v0

    .line 71
    const-string v1, "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)"

    .line 72
    .line 73
    invoke-static {v4, v1, v0}, Ln9/v;->a(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 74
    .line 75
    .line 76
    :cond_0
    iget-object v0, p0, Ln9/r;->a:Ln9/g;

    .line 77
    .line 78
    iget-object v1, p0, Ln9/r;->b:Ln9/g$d;

    .line 79
    .line 80
    new-instance v2, Ln9/q;

    .line 81
    .line 82
    invoke-direct {v2, p0, p1}, Ln9/q;-><init>(Ln9/r;Ljava/lang/Runnable;)V

    .line 83
    .line 84
    .line 85
    invoke-virtual {v0, v1, v6, v7, v2}, Ln9/g;->k(Ln9/g$d;JLjava/lang/Runnable;)Ln9/g$b;

    .line 86
    .line 87
    .line 88
    move-result-object p1

    .line 89
    iput-object p1, p0, Ln9/r;->i:Ln9/g$b;

    .line 90
    .line 91
    iget-wide v0, p0, Ln9/r;->g:J

    .line 92
    .line 93
    long-to-double v0, v0

    .line 94
    iget-wide v2, p0, Ln9/r;->d:D

    .line 95
    .line 96
    mul-double/2addr v0, v2

    .line 97
    double-to-long v0, v0

    .line 98
    iput-wide v0, p0, Ln9/r;->g:J

    .line 99
    .line 100
    iget-wide v2, p0, Ln9/r;->c:J

    .line 101
    .line 102
    cmp-long p1, v0, v2

    .line 103
    .line 104
    if-gez p1, :cond_1

    .line 105
    .line 106
    iput-wide v2, p0, Ln9/r;->g:J

    .line 107
    .line 108
    goto :goto_0

    .line 109
    :cond_1
    iget-wide v2, p0, Ln9/r;->f:J

    .line 110
    .line 111
    cmp-long p1, v0, v2

    .line 112
    .line 113
    if-lez p1, :cond_2

    .line 114
    .line 115
    iput-wide v2, p0, Ln9/r;->g:J

    .line 116
    .line 117
    :cond_2
    :goto_0
    iget-wide v0, p0, Ln9/r;->e:J

    .line 118
    .line 119
    iput-wide v0, p0, Ln9/r;->f:J

    .line 120
    .line 121
    return-void
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
    .line 197
.end method

.method public c()V
    .locals 1

    .line 1
    iget-object v0, p0, Ln9/r;->i:Ln9/g$b;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    invoke-virtual {v0}, Ln9/g$b;->c()V

    .line 6
    .line 7
    .line 8
    const/4 v0, 0x0

    .line 9
    iput-object v0, p0, Ln9/r;->i:Ln9/g$b;

    .line 10
    .line 11
    :cond_0
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public final d()J
    .locals 4

    .line 1
    invoke-static {}, Ljava/lang/Math;->random()D

    .line 2
    .line 3
    .line 4
    move-result-wide v0

    .line 5
    const-wide/high16 v2, 0x3fe0000000000000L    # 0.5

    .line 6
    .line 7
    sub-double/2addr v0, v2

    .line 8
    iget-wide v2, p0, Ln9/r;->g:J

    .line 9
    .line 10
    long-to-double v2, v2

    .line 11
    mul-double/2addr v0, v2

    .line 12
    double-to-long v0, v0

    .line 13
    return-wide v0
    .line 14
    .line 15
    .line 16
.end method

.method public e()V
    .locals 2

    .line 1
    const-wide/16 v0, 0x0

    .line 2
    .line 3
    iput-wide v0, p0, Ln9/r;->g:J

    .line 4
    .line 5
    return-void
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
.end method

.method public f()V
    .locals 2

    .line 1
    iget-wide v0, p0, Ln9/r;->f:J

    .line 2
    .line 3
    iput-wide v0, p0, Ln9/r;->g:J

    .line 4
    .line 5
    return-void
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
.end method

.method public g(J)V
    .locals 0

    .line 1
    iput-wide p1, p0, Ln9/r;->f:J

    .line 2
    .line 3
    return-void
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
.end method
