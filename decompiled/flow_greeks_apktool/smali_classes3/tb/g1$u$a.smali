.class public Ltb/g1$u$a;
.super Lrb/d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1$u;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ltb/g1$u;


# direct methods
.method public constructor <init>(Ltb/g1$u;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 2
    .line 3
    invoke-direct {p0}, Lrb/d;-><init>()V

    .line 4
    .line 5
    .line 6
    return-void
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
.method public a()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1$u;->j(Ltb/g1$u;)Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
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

.method public e(Lrb/z0;Lrb/c;)Lrb/g;
    .locals 8

    .line 1
    new-instance v0, Ltb/q;

    .line 2
    .line 3
    iget-object v1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 4
    .line 5
    iget-object v1, v1, Ltb/g1$u;->d:Ltb/g1;

    .line 6
    .line 7
    invoke-static {v1, p2}, Ltb/g1;->w(Ltb/g1;Lrb/c;)Ljava/util/concurrent/Executor;

    .line 8
    .line 9
    .line 10
    move-result-object v2

    .line 11
    iget-object v1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 12
    .line 13
    iget-object v1, v1, Ltb/g1$u;->d:Ltb/g1;

    .line 14
    .line 15
    invoke-static {v1}, Ltb/g1;->J(Ltb/g1;)Ltb/g1$m;

    .line 16
    .line 17
    .line 18
    move-result-object v4

    .line 19
    iget-object v1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 20
    .line 21
    iget-object v1, v1, Ltb/g1$u;->d:Ltb/g1;

    .line 22
    .line 23
    invoke-static {v1}, Ltb/g1;->K(Ltb/g1;)Z

    .line 24
    .line 25
    .line 26
    move-result v1

    .line 27
    if-eqz v1, :cond_0

    .line 28
    .line 29
    const/4 v1, 0x0

    .line 30
    :goto_0
    move-object v5, v1

    .line 31
    goto :goto_1

    .line 32
    :cond_0
    iget-object v1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 33
    .line 34
    iget-object v1, v1, Ltb/g1$u;->d:Ltb/g1;

    .line 35
    .line 36
    invoke-static {v1}, Ltb/g1;->x(Ltb/g1;)Ltb/u;

    .line 37
    .line 38
    .line 39
    move-result-object v1

    .line 40
    invoke-interface {v1}, Ltb/u;->Q()Ljava/util/concurrent/ScheduledExecutorService;

    .line 41
    .line 42
    .line 43
    move-result-object v1

    .line 44
    goto :goto_0

    .line 45
    :goto_1
    iget-object v1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 46
    .line 47
    iget-object v1, v1, Ltb/g1$u;->d:Ltb/g1;

    .line 48
    .line 49
    invoke-static {v1}, Ltb/g1;->B(Ltb/g1;)Ltb/n;

    .line 50
    .line 51
    .line 52
    move-result-object v6

    .line 53
    const/4 v7, 0x0

    .line 54
    move-object v1, p1

    .line 55
    move-object v3, p2

    .line 56
    invoke-direct/range {v0 .. v7}, Ltb/q;-><init>(Lrb/z0;Ljava/util/concurrent/Executor;Lrb/c;Ltb/q$e;Ljava/util/concurrent/ScheduledExecutorService;Ltb/n;Lrb/g0;)V

    .line 57
    .line 58
    .line 59
    iget-object p1, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 60
    .line 61
    iget-object p1, p1, Ltb/g1$u;->d:Ltb/g1;

    .line 62
    .line 63
    invoke-static {p1}, Ltb/g1;->I(Ltb/g1;)Z

    .line 64
    .line 65
    .line 66
    move-result p1

    .line 67
    invoke-virtual {v0, p1}, Ltb/q;->E(Z)Ltb/q;

    .line 68
    .line 69
    .line 70
    move-result-object p1

    .line 71
    iget-object p2, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 72
    .line 73
    iget-object p2, p2, Ltb/g1$u;->d:Ltb/g1;

    .line 74
    .line 75
    invoke-static {p2}, Ltb/g1;->H(Ltb/g1;)Lrb/v;

    .line 76
    .line 77
    .line 78
    move-result-object p2

    .line 79
    invoke-virtual {p1, p2}, Ltb/q;->D(Lrb/v;)Ltb/q;

    .line 80
    .line 81
    .line 82
    move-result-object p1

    .line 83
    iget-object p2, p0, Ltb/g1$u$a;->a:Ltb/g1$u;

    .line 84
    .line 85
    iget-object p2, p2, Ltb/g1$u;->d:Ltb/g1;

    .line 86
    .line 87
    invoke-static {p2}, Ltb/g1;->G(Ltb/g1;)Lrb/o;

    .line 88
    .line 89
    .line 90
    move-result-object p2

    .line 91
    invoke-virtual {p1, p2}, Ltb/q;->C(Lrb/o;)Ltb/q;

    .line 92
    .line 93
    .line 94
    move-result-object p1

    .line 95
    return-object p1
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
