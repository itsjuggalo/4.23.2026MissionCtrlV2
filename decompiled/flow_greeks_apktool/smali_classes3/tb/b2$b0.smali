.class public final Ltb/b2$b0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/s;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/b2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "b0"
.end annotation


# instance fields
.field public final a:Ltb/b2$c0;

.field public final synthetic b:Ltb/b2;


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .line 1
    return-void
    .line 2
    .line 3
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

.method public constructor <init>(Ltb/b2;Ltb/b2$c0;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

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
.method public a(Ltb/p2$a;)V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 8
    .line 9
    if-eqz v1, :cond_0

    .line 10
    .line 11
    const/4 v1, 0x1

    .line 12
    goto :goto_0

    .line 13
    :cond_0
    const/4 v1, 0x0

    .line 14
    :goto_0
    const-string v2, "Headers should be received prior to messages."

    .line 15
    .line 16
    invoke-static {v1, v2}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 17
    .line 18
    .line 19
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 20
    .line 21
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 22
    .line 23
    if-eq v0, v1, :cond_1

    .line 24
    .line 25
    invoke-static {p1}, Ltb/r0;->e(Ltb/p2$a;)V

    .line 26
    .line 27
    .line 28
    return-void

    .line 29
    :cond_1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 30
    .line 31
    invoke-static {v0}, Ltb/b2;->x(Ltb/b2;)Ljava/util/concurrent/Executor;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    new-instance v1, Ltb/b2$b0$e;

    .line 36
    .line 37
    invoke-direct {v1, p0, p1}, Ltb/b2$b0$e;-><init>(Ltb/b2$b0;Ltb/p2$a;)V

    .line 38
    .line 39
    .line 40
    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 41
    .line 42
    .line 43
    return-void
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

.method public b()V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 2
    .line 3
    invoke-virtual {v0}, Ltb/b2;->f()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 11
    .line 12
    invoke-static {v0}, Ltb/b2;->x(Ltb/b2;)Ljava/util/concurrent/Executor;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    new-instance v1, Ltb/b2$b0$f;

    .line 17
    .line 18
    invoke-direct {v1, p0}, Ltb/b2$b0$f;-><init>(Ltb/b2$b0;)V

    .line 19
    .line 20
    .line 21
    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 22
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

.method public c(Lrb/y0;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 2
    .line 3
    iget v0, v0, Ltb/b2$c0;->d:I

    .line 4
    .line 5
    if-lez v0, :cond_0

    .line 6
    .line 7
    sget-object v0, Ltb/b2;->A:Lrb/y0$g;

    .line 8
    .line 9
    invoke-virtual {p1, v0}, Lrb/y0;->e(Lrb/y0$g;)V

    .line 10
    .line 11
    .line 12
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 13
    .line 14
    iget v1, v1, Ltb/b2$c0;->d:I

    .line 15
    .line 16
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    invoke-virtual {p1, v0, v1}, Lrb/y0;->p(Lrb/y0$g;Ljava/lang/Object;)V

    .line 21
    .line 22
    .line 23
    :cond_0
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 24
    .line 25
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 26
    .line 27
    invoke-static {v0, v1}, Ltb/b2;->w(Ltb/b2;Ltb/b2$c0;)V

    .line 28
    .line 29
    .line 30
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 31
    .line 32
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 37
    .line 38
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 39
    .line 40
    if-ne v0, v1, :cond_2

    .line 41
    .line 42
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 43
    .line 44
    invoke-static {v0}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    if-eqz v0, :cond_1

    .line 49
    .line 50
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 51
    .line 52
    invoke-static {v0}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    invoke-virtual {v0}, Ltb/b2$d0;->c()V

    .line 57
    .line 58
    .line 59
    :cond_1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 60
    .line 61
    invoke-static {v0}, Ltb/b2;->x(Ltb/b2;)Ljava/util/concurrent/Executor;

    .line 62
    .line 63
    .line 64
    move-result-object v0

    .line 65
    new-instance v1, Ltb/b2$b0$a;

    .line 66
    .line 67
    invoke-direct {v1, p0, p1}, Ltb/b2$b0$a;-><init>(Ltb/b2$b0;Lrb/y0;)V

    .line 68
    .line 69
    .line 70
    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 71
    .line 72
    .line 73
    :cond_2
    return-void
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

.method public d(Lrb/k1;Ltb/s$a;Lrb/y0;)V
    .locals 5

    .line 1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    monitor-enter v0

    .line 8
    :try_start_0
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 9
    .line 10
    invoke-static {v1}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 11
    .line 12
    .line 13
    move-result-object v2

    .line 14
    iget-object v3, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 15
    .line 16
    invoke-virtual {v2, v3}, Ltb/b2$a0;->g(Ltb/b2$c0;)Ltb/b2$a0;

    .line 17
    .line 18
    .line 19
    move-result-object v2

    .line 20
    invoke-static {v1, v2}, Ltb/b2;->N(Ltb/b2;Ltb/b2$a0;)Ltb/b2$a0;

    .line 21
    .line 22
    .line 23
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 24
    .line 25
    invoke-static {v1}, Ltb/b2;->y(Ltb/b2;)Ltb/x0;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    invoke-virtual {p1}, Lrb/k1;->n()Lrb/k1$b;

    .line 30
    .line 31
    .line 32
    move-result-object v2

    .line 33
    invoke-virtual {v1, v2}, Ltb/x0;->a(Ljava/lang/Object;)Ltb/x0;

    .line 34
    .line 35
    .line 36
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_3

    .line 37
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 38
    .line 39
    invoke-static {v0}, Ltb/b2;->z(Ltb/b2;)Ljava/util/concurrent/atomic/AtomicInteger;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 44
    .line 45
    .line 46
    move-result v0

    .line 47
    const/high16 v1, -0x80000000

    .line 48
    .line 49
    if-ne v0, v1, :cond_0

    .line 50
    .line 51
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 52
    .line 53
    invoke-static {p1}, Ltb/b2;->x(Ltb/b2;)Ljava/util/concurrent/Executor;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    new-instance p2, Ltb/b2$b0$c;

    .line 58
    .line 59
    invoke-direct {p2, p0}, Ltb/b2$b0$c;-><init>(Ltb/b2$b0;)V

    .line 60
    .line 61
    .line 62
    invoke-interface {p1, p2}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 63
    .line 64
    .line 65
    return-void

    .line 66
    :cond_0
    iget-object v0, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 67
    .line 68
    iget-boolean v1, v0, Ltb/b2$c0;->c:Z

    .line 69
    .line 70
    if-eqz v1, :cond_1

    .line 71
    .line 72
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 73
    .line 74
    invoke-static {v1, v0}, Ltb/b2;->w(Ltb/b2;Ltb/b2$c0;)V

    .line 75
    .line 76
    .line 77
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 78
    .line 79
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 80
    .line 81
    .line 82
    move-result-object v0

    .line 83
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 84
    .line 85
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 86
    .line 87
    if-ne v0, v1, :cond_e

    .line 88
    .line 89
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 90
    .line 91
    invoke-static {v0, p1, p2, p3}, Ltb/b2;->C(Ltb/b2;Lrb/k1;Ltb/s$a;Lrb/y0;)V

    .line 92
    .line 93
    .line 94
    return-void

    .line 95
    :cond_1
    sget-object v0, Ltb/s$a;->d:Ltb/s$a;

    .line 96
    .line 97
    if-ne p2, v0, :cond_2

    .line 98
    .line 99
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 100
    .line 101
    invoke-static {v1}, Ltb/b2;->D(Ltb/b2;)Ljava/util/concurrent/atomic/AtomicInteger;

    .line 102
    .line 103
    .line 104
    move-result-object v1

    .line 105
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    .line 106
    .line 107
    .line 108
    move-result v1

    .line 109
    const/16 v2, 0x3e8

    .line 110
    .line 111
    if-le v1, v2, :cond_2

    .line 112
    .line 113
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 114
    .line 115
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 116
    .line 117
    invoke-static {v0, v1}, Ltb/b2;->w(Ltb/b2;Ltb/b2$c0;)V

    .line 118
    .line 119
    .line 120
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 121
    .line 122
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 123
    .line 124
    .line 125
    move-result-object v0

    .line 126
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 127
    .line 128
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 129
    .line 130
    if-ne v0, v1, :cond_e

    .line 131
    .line 132
    sget-object v0, Lrb/k1;->s:Lrb/k1;

    .line 133
    .line 134
    const-string v1, "Too many transparent retries. Might be a bug in gRPC"

    .line 135
    .line 136
    invoke-virtual {v0, v1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 137
    .line 138
    .line 139
    move-result-object v0

    .line 140
    invoke-virtual {p1}, Lrb/k1;->d()Lrb/m1;

    .line 141
    .line 142
    .line 143
    move-result-object p1

    .line 144
    invoke-virtual {v0, p1}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 145
    .line 146
    .line 147
    move-result-object p1

    .line 148
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 149
    .line 150
    invoke-static {v0, p1, p2, p3}, Ltb/b2;->C(Ltb/b2;Lrb/k1;Ltb/s$a;Lrb/y0;)V

    .line 151
    .line 152
    .line 153
    return-void

    .line 154
    :cond_2
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 155
    .line 156
    invoke-static {v1}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 157
    .line 158
    .line 159
    move-result-object v1

    .line 160
    iget-object v1, v1, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 161
    .line 162
    if-nez v1, :cond_d

    .line 163
    .line 164
    const/4 v1, 0x1

    .line 165
    if-eq p2, v0, :cond_a

    .line 166
    .line 167
    sget-object v0, Ltb/s$a;->b:Ltb/s$a;

    .line 168
    .line 169
    const/4 v2, 0x0

    .line 170
    if-ne p2, v0, :cond_3

    .line 171
    .line 172
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 173
    .line 174
    invoke-static {v0}, Ltb/b2;->E(Ltb/b2;)Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 175
    .line 176
    .line 177
    move-result-object v0

    .line 178
    invoke-virtual {v0, v2, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    .line 179
    .line 180
    .line 181
    move-result v0

    .line 182
    if-eqz v0, :cond_3

    .line 183
    .line 184
    goto/16 :goto_2

    .line 185
    .line 186
    :cond_3
    sget-object v0, Ltb/s$a;->c:Ltb/s$a;

    .line 187
    .line 188
    if-ne p2, v0, :cond_4

    .line 189
    .line 190
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 191
    .line 192
    invoke-static {v0}, Ltb/b2;->F(Ltb/b2;)Z

    .line 193
    .line 194
    .line 195
    move-result v0

    .line 196
    if-eqz v0, :cond_d

    .line 197
    .line 198
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 199
    .line 200
    invoke-static {v0}, Ltb/b2;->G(Ltb/b2;)V

    .line 201
    .line 202
    .line 203
    goto/16 :goto_4

    .line 204
    .line 205
    :cond_4
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 206
    .line 207
    invoke-static {v0}, Ltb/b2;->E(Ltb/b2;)Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 208
    .line 209
    .line 210
    move-result-object v0

    .line 211
    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 212
    .line 213
    .line 214
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 215
    .line 216
    invoke-static {v0}, Ltb/b2;->F(Ltb/b2;)Z

    .line 217
    .line 218
    .line 219
    move-result v0

    .line 220
    if-eqz v0, :cond_8

    .line 221
    .line 222
    invoke-virtual {p0, p1, p3}, Ltb/b2$b0;->f(Lrb/k1;Lrb/y0;)Ltb/b2$v;

    .line 223
    .line 224
    .line 225
    move-result-object v0

    .line 226
    iget-boolean v1, v0, Ltb/b2$v;->a:Z

    .line 227
    .line 228
    if-eqz v1, :cond_5

    .line 229
    .line 230
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 231
    .line 232
    iget-object v2, v0, Ltb/b2$v;->b:Ljava/lang/Integer;

    .line 233
    .line 234
    invoke-static {v1, v2}, Ltb/b2;->H(Ltb/b2;Ljava/lang/Integer;)V

    .line 235
    .line 236
    .line 237
    :cond_5
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 238
    .line 239
    invoke-static {v1}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 240
    .line 241
    .line 242
    move-result-object v3

    .line 243
    monitor-enter v3

    .line 244
    :try_start_1
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 245
    .line 246
    invoke-static {v1}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 247
    .line 248
    .line 249
    move-result-object v2

    .line 250
    iget-object v4, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 251
    .line 252
    invoke-virtual {v2, v4}, Ltb/b2$a0;->e(Ltb/b2$c0;)Ltb/b2$a0;

    .line 253
    .line 254
    .line 255
    move-result-object v2

    .line 256
    invoke-static {v1, v2}, Ltb/b2;->N(Ltb/b2;Ltb/b2$a0;)Ltb/b2$a0;

    .line 257
    .line 258
    .line 259
    iget-boolean v0, v0, Ltb/b2$v;->a:Z

    .line 260
    .line 261
    if-eqz v0, :cond_7

    .line 262
    .line 263
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 264
    .line 265
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 266
    .line 267
    .line 268
    move-result-object v1

    .line 269
    invoke-static {v0, v1}, Ltb/b2;->X(Ltb/b2;Ltb/b2$a0;)Z

    .line 270
    .line 271
    .line 272
    move-result v0

    .line 273
    if-nez v0, :cond_6

    .line 274
    .line 275
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 276
    .line 277
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 278
    .line 279
    .line 280
    move-result-object v0

    .line 281
    iget-object v0, v0, Ltb/b2$a0;->d:Ljava/util/Collection;

    .line 282
    .line 283
    invoke-interface {v0}, Ljava/util/Collection;->isEmpty()Z

    .line 284
    .line 285
    .line 286
    move-result v0

    .line 287
    if-nez v0, :cond_7

    .line 288
    .line 289
    goto :goto_0

    .line 290
    :catchall_0
    move-exception p1

    .line 291
    goto :goto_1

    .line 292
    :cond_6
    :goto_0
    monitor-exit v3

    .line 293
    return-void

    .line 294
    :cond_7
    monitor-exit v3

    .line 295
    goto/16 :goto_4

    .line 296
    .line 297
    :goto_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 298
    throw p1

    .line 299
    :cond_8
    invoke-virtual {p0, p1, p3}, Ltb/b2$b0;->g(Lrb/k1;Lrb/y0;)Ltb/b2$x;

    .line 300
    .line 301
    .line 302
    move-result-object v0

    .line 303
    iget-boolean v3, v0, Ltb/b2$x;->a:Z

    .line 304
    .line 305
    if-eqz v3, :cond_d

    .line 306
    .line 307
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 308
    .line 309
    iget-object p2, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 310
    .line 311
    iget p2, p2, Ltb/b2$c0;->d:I

    .line 312
    .line 313
    add-int/2addr p2, v1

    .line 314
    invoke-static {p1, p2, v2}, Ltb/b2;->V(Ltb/b2;IZ)Ltb/b2$c0;

    .line 315
    .line 316
    .line 317
    move-result-object p1

    .line 318
    if-nez p1, :cond_9

    .line 319
    .line 320
    goto/16 :goto_5

    .line 321
    .line 322
    :cond_9
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 323
    .line 324
    invoke-static {p2}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 325
    .line 326
    .line 327
    move-result-object v1

    .line 328
    monitor-enter v1

    .line 329
    :try_start_2
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 330
    .line 331
    new-instance p3, Ltb/b2$u;

    .line 332
    .line 333
    invoke-static {p2}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 334
    .line 335
    .line 336
    move-result-object v2

    .line 337
    invoke-direct {p3, v2}, Ltb/b2$u;-><init>(Ljava/lang/Object;)V

    .line 338
    .line 339
    .line 340
    invoke-static {p2, p3}, Ltb/b2;->I(Ltb/b2;Ltb/b2$u;)Ltb/b2$u;

    .line 341
    .line 342
    .line 343
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 344
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 345
    .line 346
    invoke-static {p2}, Ltb/b2;->r(Ltb/b2;)Ljava/util/concurrent/ScheduledExecutorService;

    .line 347
    .line 348
    .line 349
    move-result-object p2

    .line 350
    new-instance v1, Ltb/b2$b0$b;

    .line 351
    .line 352
    invoke-direct {v1, p0, p1}, Ltb/b2$b0$b;-><init>(Ltb/b2$b0;Ltb/b2$c0;)V

    .line 353
    .line 354
    .line 355
    iget-wide v2, v0, Ltb/b2$x;->b:J

    .line 356
    .line 357
    sget-object p1, Ljava/util/concurrent/TimeUnit;->NANOSECONDS:Ljava/util/concurrent/TimeUnit;

    .line 358
    .line 359
    invoke-interface {p2, v1, v2, v3, p1}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 360
    .line 361
    .line 362
    move-result-object p1

    .line 363
    invoke-virtual {p3, p1}, Ltb/b2$u;->c(Ljava/util/concurrent/Future;)V

    .line 364
    .line 365
    .line 366
    return-void

    .line 367
    :catchall_1
    move-exception p1

    .line 368
    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 369
    throw p1

    .line 370
    :cond_a
    :goto_2
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 371
    .line 372
    iget-object p2, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 373
    .line 374
    iget p2, p2, Ltb/b2$c0;->d:I

    .line 375
    .line 376
    invoke-static {p1, p2, v1}, Ltb/b2;->V(Ltb/b2;IZ)Ltb/b2$c0;

    .line 377
    .line 378
    .line 379
    move-result-object p1

    .line 380
    if-nez p1, :cond_b

    .line 381
    .line 382
    goto :goto_5

    .line 383
    :cond_b
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 384
    .line 385
    invoke-static {p2}, Ltb/b2;->F(Ltb/b2;)Z

    .line 386
    .line 387
    .line 388
    move-result p2

    .line 389
    if-eqz p2, :cond_c

    .line 390
    .line 391
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 392
    .line 393
    invoke-static {p2}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 394
    .line 395
    .line 396
    move-result-object p2

    .line 397
    monitor-enter p2

    .line 398
    :try_start_4
    iget-object p3, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 399
    .line 400
    invoke-static {p3}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 401
    .line 402
    .line 403
    move-result-object v0

    .line 404
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 405
    .line 406
    invoke-virtual {v0, v1, p1}, Ltb/b2$a0;->f(Ltb/b2$c0;Ltb/b2$c0;)Ltb/b2$a0;

    .line 407
    .line 408
    .line 409
    move-result-object v0

    .line 410
    invoke-static {p3, v0}, Ltb/b2;->N(Ltb/b2;Ltb/b2$a0;)Ltb/b2$a0;

    .line 411
    .line 412
    .line 413
    monitor-exit p2

    .line 414
    goto :goto_3

    .line 415
    :catchall_2
    move-exception p1

    .line 416
    monitor-exit p2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 417
    throw p1

    .line 418
    :cond_c
    :goto_3
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 419
    .line 420
    invoke-static {p2}, Ltb/b2;->u(Ltb/b2;)Ljava/util/concurrent/Executor;

    .line 421
    .line 422
    .line 423
    move-result-object p2

    .line 424
    new-instance p3, Ltb/b2$b0$d;

    .line 425
    .line 426
    invoke-direct {p3, p0, p1}, Ltb/b2$b0$d;-><init>(Ltb/b2$b0;Ltb/b2$c0;)V

    .line 427
    .line 428
    .line 429
    invoke-interface {p2, p3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 430
    .line 431
    .line 432
    return-void

    .line 433
    :cond_d
    :goto_4
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 434
    .line 435
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 436
    .line 437
    invoke-static {v0, v1}, Ltb/b2;->w(Ltb/b2;Ltb/b2$c0;)V

    .line 438
    .line 439
    .line 440
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 441
    .line 442
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 443
    .line 444
    .line 445
    move-result-object v0

    .line 446
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 447
    .line 448
    iget-object v1, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 449
    .line 450
    if-ne v0, v1, :cond_e

    .line 451
    .line 452
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 453
    .line 454
    invoke-static {v0, p1, p2, p3}, Ltb/b2;->C(Ltb/b2;Lrb/k1;Ltb/s$a;Lrb/y0;)V

    .line 455
    .line 456
    .line 457
    :cond_e
    :goto_5
    return-void

    .line 458
    :catchall_3
    move-exception p1

    .line 459
    :try_start_5
    monitor-exit v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    .line 460
    throw p1
    .line 461
    .line 462
    .line 463
    .line 464
    .line 465
    .line 466
    .line 467
    .line 468
    .line 469
    .line 470
    .line 471
    .line 472
    .line 473
    .line 474
    .line 475
    .line 476
    .line 477
    .line 478
    .line 479
    .line 480
    .line 481
    .line 482
    .line 483
    .line 484
    .line 485
    .line 486
    .line 487
    .line 488
    .line 489
    .line 490
    .line 491
    .line 492
    .line 493
    .line 494
    .line 495
    .line 496
    .line 497
    .line 498
    .line 499
    .line 500
    .line 501
    .line 502
    .line 503
    .line 504
    .line 505
    .line 506
    .line 507
    .line 508
    .line 509
    .line 510
    .line 511
    .line 512
    .line 513
    .line 514
    .line 515
    .line 516
    .line 517
    .line 518
    .line 519
    .line 520
    .line 521
    .line 522
    .line 523
    .line 524
    .line 525
    .line 526
    .line 527
    .line 528
    .line 529
    .line 530
    .line 531
    .line 532
    .line 533
    .line 534
    .line 535
    .line 536
    .line 537
    .line 538
    .line 539
    .line 540
    .line 541
    .line 542
    .line 543
    .line 544
    .line 545
    .line 546
    .line 547
    .line 548
    .line 549
    .line 550
    .line 551
    .line 552
    .line 553
    .line 554
    .line 555
    .line 556
    .line 557
    .line 558
    .line 559
    .line 560
    .line 561
    .line 562
    .line 563
    .line 564
    .line 565
    .line 566
    .line 567
    .line 568
    .line 569
    .line 570
    .line 571
    .line 572
    .line 573
    .line 574
    .line 575
    .line 576
    .line 577
    .line 578
    .line 579
    .line 580
    .line 581
    .line 582
    .line 583
    .line 584
    .line 585
    .line 586
    .line 587
    .line 588
    .line 589
    .line 590
    .line 591
    .line 592
    .line 593
    .line 594
    .line 595
    .line 596
    .line 597
    .line 598
    .line 599
    .line 600
    .line 601
    .line 602
    .line 603
    .line 604
    .line 605
    .line 606
    .line 607
    .line 608
    .line 609
    .line 610
    .line 611
    .line 612
    .line 613
    .line 614
    .line 615
    .line 616
    .line 617
    .line 618
    .line 619
    .line 620
    .line 621
    .line 622
    .line 623
    .line 624
    .line 625
    .line 626
    .line 627
    .line 628
    .line 629
    .line 630
    .line 631
    .line 632
    .line 633
    .line 634
    .line 635
    .line 636
    .line 637
    .line 638
    .line 639
    .line 640
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
    .line 672
    .line 673
    .line 674
    .line 675
    .line 676
    .line 677
    .line 678
    .line 679
    .line 680
    .line 681
    .line 682
    .line 683
    .line 684
    .line 685
    .line 686
    .line 687
    .line 688
    .line 689
    .line 690
    .line 691
    .line 692
    .line 693
    .line 694
    .line 695
    .line 696
    .line 697
    .line 698
    .line 699
    .line 700
    .line 701
    .line 702
    .line 703
    .line 704
    .line 705
    .line 706
    .line 707
    .line 708
    .line 709
    .line 710
    .line 711
    .line 712
    .line 713
    .line 714
    .line 715
    .line 716
    .line 717
    .line 718
    .line 719
    .line 720
    .line 721
    .line 722
    .line 723
    .line 724
    .line 725
    .line 726
    .line 727
    .line 728
    .line 729
    .line 730
    .line 731
    .line 732
    .line 733
    .line 734
    .line 735
    .line 736
    .line 737
    .line 738
    .line 739
    .line 740
    .line 741
    .line 742
    .line 743
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
    .line 749
    .line 750
    .line 751
    .line 752
    .line 753
    .line 754
    .line 755
    .line 756
    .line 757
    .line 758
    .line 759
    .line 760
    .line 761
.end method

.method public final e(Lrb/y0;)Ljava/lang/Integer;
    .locals 1

    .line 1
    sget-object v0, Ltb/b2;->B:Lrb/y0$g;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    check-cast p1, Ljava/lang/String;

    .line 8
    .line 9
    if-eqz p1, :cond_0

    .line 10
    .line 11
    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    .line 12
    .line 13
    .line 14
    move-result-object p1
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 15
    return-object p1

    .line 16
    :catch_0
    const/4 p1, -0x1

    .line 17
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    return-object p1

    .line 22
    :cond_0
    const/4 p1, 0x0

    .line 23
    return-object p1
    .line 24
    .line 25
    .line 26
.end method

.method public final f(Lrb/k1;Lrb/y0;)Ltb/b2$v;
    .locals 4

    .line 1
    invoke-virtual {p0, p2}, Ltb/b2$b0;->e(Lrb/y0;)Ljava/lang/Integer;

    .line 2
    .line 3
    .line 4
    move-result-object p2

    .line 5
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 6
    .line 7
    invoke-static {v0}, Ltb/b2;->a0(Ltb/b2;)Ltb/t0;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    iget-object v0, v0, Ltb/t0;->c:Ljava/util/Set;

    .line 12
    .line 13
    invoke-virtual {p1}, Lrb/k1;->n()Lrb/k1$b;

    .line 14
    .line 15
    .line 16
    move-result-object v1

    .line 17
    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 18
    .line 19
    .line 20
    move-result v0

    .line 21
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 22
    .line 23
    invoke-static {v1}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 24
    .line 25
    .line 26
    move-result-object v1

    .line 27
    const/4 v2, 0x1

    .line 28
    const/4 v3, 0x0

    .line 29
    if-eqz v1, :cond_1

    .line 30
    .line 31
    if-nez v0, :cond_0

    .line 32
    .line 33
    if-eqz p2, :cond_1

    .line 34
    .line 35
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    if-gez v1, :cond_1

    .line 40
    .line 41
    :cond_0
    iget-object v1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 42
    .line 43
    invoke-static {v1}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 44
    .line 45
    .line 46
    move-result-object v1

    .line 47
    invoke-virtual {v1}, Ltb/b2$d0;->b()Z

    .line 48
    .line 49
    .line 50
    move-result v1

    .line 51
    xor-int/2addr v1, v2

    .line 52
    goto :goto_0

    .line 53
    :cond_1
    move v1, v3

    .line 54
    :goto_0
    if-eqz v0, :cond_2

    .line 55
    .line 56
    if-nez v1, :cond_2

    .line 57
    .line 58
    invoke-virtual {p1}, Lrb/k1;->p()Z

    .line 59
    .line 60
    .line 61
    move-result p1

    .line 62
    if-nez p1, :cond_2

    .line 63
    .line 64
    if-eqz p2, :cond_2

    .line 65
    .line 66
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 67
    .line 68
    .line 69
    move-result p1

    .line 70
    if-lez p1, :cond_2

    .line 71
    .line 72
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    .line 73
    .line 74
    .line 75
    move-result-object p2

    .line 76
    :cond_2
    new-instance p1, Ltb/b2$v;

    .line 77
    .line 78
    if-eqz v0, :cond_3

    .line 79
    .line 80
    if-nez v1, :cond_3

    .line 81
    .line 82
    goto :goto_1

    .line 83
    :cond_3
    move v2, v3

    .line 84
    :goto_1
    invoke-direct {p1, v2, p2}, Ltb/b2$v;-><init>(ZLjava/lang/Integer;)V

    .line 85
    .line 86
    .line 87
    return-object p1
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
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
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
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
.end method

.method public final g(Lrb/k1;Lrb/y0;)Ltb/b2$x;
    .locals 9

    .line 1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-wide/16 v1, 0x0

    .line 8
    .line 9
    const/4 v3, 0x0

    .line 10
    if-nez v0, :cond_0

    .line 11
    .line 12
    new-instance p1, Ltb/b2$x;

    .line 13
    .line 14
    invoke-direct {p1, v3, v1, v2}, Ltb/b2$x;-><init>(ZJ)V

    .line 15
    .line 16
    .line 17
    return-object p1

    .line 18
    :cond_0
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 19
    .line 20
    invoke-static {v0}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 21
    .line 22
    .line 23
    move-result-object v0

    .line 24
    iget-object v0, v0, Ltb/c2;->f:Ljava/util/Set;

    .line 25
    .line 26
    invoke-virtual {p1}, Lrb/k1;->n()Lrb/k1$b;

    .line 27
    .line 28
    .line 29
    move-result-object p1

    .line 30
    invoke-interface {v0, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    .line 31
    .line 32
    .line 33
    move-result p1

    .line 34
    invoke-virtual {p0, p2}, Ltb/b2$b0;->e(Lrb/y0;)Ljava/lang/Integer;

    .line 35
    .line 36
    .line 37
    move-result-object p2

    .line 38
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 39
    .line 40
    invoke-static {v0}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 41
    .line 42
    .line 43
    move-result-object v0

    .line 44
    const/4 v4, 0x1

    .line 45
    if-eqz v0, :cond_2

    .line 46
    .line 47
    if-nez p1, :cond_1

    .line 48
    .line 49
    if-eqz p2, :cond_2

    .line 50
    .line 51
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 52
    .line 53
    .line 54
    move-result v0

    .line 55
    if-gez v0, :cond_2

    .line 56
    .line 57
    :cond_1
    iget-object v0, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 58
    .line 59
    invoke-static {v0}, Ltb/b2;->Y(Ltb/b2;)Ltb/b2$d0;

    .line 60
    .line 61
    .line 62
    move-result-object v0

    .line 63
    invoke-virtual {v0}, Ltb/b2$d0;->b()Z

    .line 64
    .line 65
    .line 66
    move-result v0

    .line 67
    xor-int/2addr v0, v4

    .line 68
    goto :goto_0

    .line 69
    :cond_2
    move v0, v3

    .line 70
    :goto_0
    iget-object v5, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 71
    .line 72
    invoke-static {v5}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 73
    .line 74
    .line 75
    move-result-object v5

    .line 76
    iget v5, v5, Ltb/c2;->a:I

    .line 77
    .line 78
    iget-object v6, p0, Ltb/b2$b0;->a:Ltb/b2$c0;

    .line 79
    .line 80
    iget v6, v6, Ltb/b2$c0;->d:I

    .line 81
    .line 82
    add-int/2addr v6, v4

    .line 83
    if-le v5, v6, :cond_4

    .line 84
    .line 85
    if-nez v0, :cond_4

    .line 86
    .line 87
    if-nez p2, :cond_3

    .line 88
    .line 89
    if-eqz p1, :cond_4

    .line 90
    .line 91
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 92
    .line 93
    invoke-static {p1}, Ltb/b2;->L(Ltb/b2;)J

    .line 94
    .line 95
    .line 96
    move-result-wide p1

    .line 97
    long-to-double p1, p1

    .line 98
    invoke-static {}, Ltb/b2;->O()Ljava/util/Random;

    .line 99
    .line 100
    .line 101
    move-result-object v0

    .line 102
    invoke-virtual {v0}, Ljava/util/Random;->nextDouble()D

    .line 103
    .line 104
    .line 105
    move-result-wide v0

    .line 106
    mul-double/2addr p1, v0

    .line 107
    double-to-long v1, p1

    .line 108
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 109
    .line 110
    invoke-static {p1}, Ltb/b2;->L(Ltb/b2;)J

    .line 111
    .line 112
    .line 113
    move-result-wide v5

    .line 114
    long-to-double v5, v5

    .line 115
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 116
    .line 117
    invoke-static {p2}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 118
    .line 119
    .line 120
    move-result-object p2

    .line 121
    iget-wide v7, p2, Ltb/c2;->d:D

    .line 122
    .line 123
    mul-double/2addr v5, v7

    .line 124
    double-to-long v5, v5

    .line 125
    iget-object p2, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 126
    .line 127
    invoke-static {p2}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 128
    .line 129
    .line 130
    move-result-object p2

    .line 131
    iget-wide v7, p2, Ltb/c2;->c:J

    .line 132
    .line 133
    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->min(JJ)J

    .line 134
    .line 135
    .line 136
    move-result-wide v5

    .line 137
    invoke-static {p1, v5, v6}, Ltb/b2;->M(Ltb/b2;J)J

    .line 138
    .line 139
    .line 140
    :goto_1
    move v3, v4

    .line 141
    goto :goto_2

    .line 142
    :cond_3
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 143
    .line 144
    .line 145
    move-result p1

    .line 146
    if-ltz p1, :cond_4

    .line 147
    .line 148
    sget-object p1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 149
    .line 150
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    .line 151
    .line 152
    .line 153
    move-result p2

    .line 154
    int-to-long v0, p2

    .line 155
    invoke-virtual {p1, v0, v1}, Ljava/util/concurrent/TimeUnit;->toNanos(J)J

    .line 156
    .line 157
    .line 158
    move-result-wide v1

    .line 159
    iget-object p1, p0, Ltb/b2$b0;->b:Ltb/b2;

    .line 160
    .line 161
    invoke-static {p1}, Ltb/b2;->J(Ltb/b2;)Ltb/c2;

    .line 162
    .line 163
    .line 164
    move-result-object p2

    .line 165
    iget-wide v5, p2, Ltb/c2;->b:J

    .line 166
    .line 167
    invoke-static {p1, v5, v6}, Ltb/b2;->M(Ltb/b2;J)J

    .line 168
    .line 169
    .line 170
    goto :goto_1

    .line 171
    :cond_4
    :goto_2
    new-instance p1, Ltb/b2$x;

    .line 172
    .line 173
    invoke-direct {p1, v3, v1, v2}, Ltb/b2$x;-><init>(ZJ)V

    .line 174
    .line 175
    .line 176
    return-object p1
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
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
.end method
