.class public final Ltb/g1$m;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/q$e;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "m"
.end annotation


# instance fields
.field public volatile a:Ltb/b2$d0;

.field public final synthetic b:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$m;->b:Ltb/g1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ltb/g1;Ltb/g1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Ltb/g1$m;-><init>(Ltb/g1;)V

    return-void
.end method

.method public static synthetic b(Ltb/g1$m;Lrb/r0$g;)Ltb/t;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1$m;->c(Lrb/r0$g;)Ltb/t;

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


# virtual methods
.method public a(Lrb/z0;Lrb/c;Lrb/y0;Lrb/r;)Ltb/r;
    .locals 11

    .line 1
    iget-object v0, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1;->s(Ltb/g1;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    new-instance v0, Ltb/v1;

    .line 10
    .line 11
    invoke-direct {v0, p1, p3, p2}, Ltb/v1;-><init>(Lrb/z0;Lrb/y0;Lrb/c;)V

    .line 12
    .line 13
    .line 14
    invoke-virtual {p0, v0}, Ltb/g1$m;->c(Lrb/r0$g;)Ltb/t;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    invoke-virtual {p4}, Lrb/r;->b()Lrb/r;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    const/4 v2, 0x0

    .line 23
    invoke-static {p2, p3, v2, v2}, Ltb/r0;->f(Lrb/c;Lrb/y0;IZ)[Lrb/k;

    .line 24
    .line 25
    .line 26
    move-result-object v2

    .line 27
    :try_start_0
    invoke-interface {v0, p1, p3, p2, v2}, Ltb/t;->g(Lrb/z0;Lrb/y0;Lrb/c;[Lrb/k;)Ltb/r;

    .line 28
    .line 29
    .line 30
    move-result-object p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 31
    invoke-virtual {p4, v1}, Lrb/r;->f(Lrb/r;)V

    .line 32
    .line 33
    .line 34
    return-object p1

    .line 35
    :catchall_0
    move-exception v0

    .line 36
    move-object p1, v0

    .line 37
    invoke-virtual {p4, v1}, Lrb/r;->f(Lrb/r;)V

    .line 38
    .line 39
    .line 40
    throw p1

    .line 41
    :cond_0
    sget-object v0, Ltb/j1$b;->g:Lrb/c$c;

    .line 42
    .line 43
    invoke-virtual {p2, v0}, Lrb/c;->h(Lrb/c$c;)Ljava/lang/Object;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    check-cast v0, Ltb/j1$b;

    .line 48
    .line 49
    const/4 v1, 0x0

    .line 50
    if-nez v0, :cond_1

    .line 51
    .line 52
    move-object v8, v1

    .line 53
    goto :goto_0

    .line 54
    :cond_1
    iget-object v2, v0, Ltb/j1$b;->e:Ltb/c2;

    .line 55
    .line 56
    move-object v8, v2

    .line 57
    :goto_0
    if-nez v0, :cond_2

    .line 58
    .line 59
    :goto_1
    move-object v9, v1

    .line 60
    goto :goto_2

    .line 61
    :cond_2
    iget-object v1, v0, Ltb/j1$b;->f:Ltb/t0;

    .line 62
    .line 63
    goto :goto_1

    .line 64
    :goto_2
    new-instance v3, Ltb/g1$m$b;

    .line 65
    .line 66
    move-object v4, p0

    .line 67
    move-object v5, p1

    .line 68
    move-object v7, p2

    .line 69
    move-object v6, p3

    .line 70
    move-object v10, p4

    .line 71
    invoke-direct/range {v3 .. v10}, Ltb/g1$m$b;-><init>(Ltb/g1$m;Lrb/z0;Lrb/y0;Lrb/c;Ltb/c2;Ltb/t0;Lrb/r;)V

    .line 72
    .line 73
    .line 74
    return-object v3
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
.end method

.method public final c(Lrb/r0$g;)Ltb/t;
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1;->p(Ltb/g1;)Lrb/r0$j;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 8
    .line 9
    invoke-static {v1}, Ltb/g1;->q(Ltb/g1;)Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    .line 14
    .line 15
    .line 16
    move-result v1

    .line 17
    if-eqz v1, :cond_0

    .line 18
    .line 19
    iget-object p1, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 20
    .line 21
    invoke-static {p1}, Ltb/g1;->r(Ltb/g1;)Ltb/b0;

    .line 22
    .line 23
    .line 24
    move-result-object p1

    .line 25
    return-object p1

    .line 26
    :cond_0
    if-nez v0, :cond_1

    .line 27
    .line 28
    iget-object p1, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 29
    .line 30
    iget-object p1, p1, Ltb/g1;->r:Lrb/o1;

    .line 31
    .line 32
    new-instance v0, Ltb/g1$m$a;

    .line 33
    .line 34
    invoke-direct {v0, p0}, Ltb/g1$m$a;-><init>(Ltb/g1$m;)V

    .line 35
    .line 36
    .line 37
    invoke-virtual {p1, v0}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 38
    .line 39
    .line 40
    iget-object p1, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 41
    .line 42
    invoke-static {p1}, Ltb/g1;->r(Ltb/g1;)Ltb/b0;

    .line 43
    .line 44
    .line 45
    move-result-object p1

    .line 46
    return-object p1

    .line 47
    :cond_1
    invoke-virtual {v0, p1}, Lrb/r0$j;->a(Lrb/r0$g;)Lrb/r0$f;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    invoke-virtual {p1}, Lrb/r0$g;->a()Lrb/c;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    invoke-virtual {p1}, Lrb/c;->j()Z

    .line 56
    .line 57
    .line 58
    move-result p1

    .line 59
    invoke-static {v0, p1}, Ltb/r0;->k(Lrb/r0$f;Z)Ltb/t;

    .line 60
    .line 61
    .line 62
    move-result-object p1

    .line 63
    if-eqz p1, :cond_2

    .line 64
    .line 65
    return-object p1

    .line 66
    :cond_2
    iget-object p1, p0, Ltb/g1$m;->b:Ltb/g1;

    .line 67
    .line 68
    invoke-static {p1}, Ltb/g1;->r(Ltb/g1;)Ltb/b0;

    .line 69
    .line 70
    .line 71
    move-result-object p1

    .line 72
    return-object p1
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
