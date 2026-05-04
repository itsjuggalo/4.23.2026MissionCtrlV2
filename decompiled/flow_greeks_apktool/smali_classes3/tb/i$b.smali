.class public final Ltb/i$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "b"
.end annotation


# instance fields
.field public final a:Lrb/r0$e;

.field public b:Lrb/r0;

.field public c:Lrb/s0;

.field public final synthetic d:Ltb/i;


# direct methods
.method public constructor <init>(Ltb/i;Lrb/r0$e;)V
    .locals 2

    .line 1
    iput-object p1, p0, Ltb/i$b;->d:Ltb/i;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 7
    .line 8
    invoke-static {p1}, Ltb/i;->b(Ltb/i;)Lrb/t0;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    invoke-static {p1}, Ltb/i;->a(Ltb/i;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v1

    .line 16
    invoke-virtual {v0, v1}, Lrb/t0;->d(Ljava/lang/String;)Lrb/s0;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    iput-object v0, p0, Ltb/i$b;->c:Lrb/s0;

    .line 21
    .line 22
    if-eqz v0, :cond_0

    .line 23
    .line 24
    invoke-virtual {v0, p2}, Lrb/r0$c;->a(Lrb/r0$e;)Lrb/r0;

    .line 25
    .line 26
    .line 27
    move-result-object p1

    .line 28
    iput-object p1, p0, Ltb/i$b;->b:Lrb/r0;

    .line 29
    .line 30
    return-void

    .line 31
    :cond_0
    new-instance p2, Ljava/lang/IllegalStateException;

    .line 32
    .line 33
    new-instance v0, Ljava/lang/StringBuilder;

    .line 34
    .line 35
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 36
    .line 37
    .line 38
    const-string v1, "Could not find policy \'"

    .line 39
    .line 40
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 41
    .line 42
    .line 43
    invoke-static {p1}, Ltb/i;->a(Ltb/i;)Ljava/lang/String;

    .line 44
    .line 45
    .line 46
    move-result-object p1

    .line 47
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 48
    .line 49
    .line 50
    const-string p1, "\'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files."

    .line 51
    .line 52
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 53
    .line 54
    .line 55
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    invoke-direct {p2, p1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 60
    .line 61
    .line 62
    throw p2
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


# virtual methods
.method public a()Lrb/r0;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/i$b;->b:Lrb/r0;

    .line 2
    .line 3
    return-object v0
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

.method public b(Lrb/k1;)V
    .locals 1

    .line 1
    invoke-virtual {p0}, Ltb/i$b;->a()Lrb/r0;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0, p1}, Lrb/r0;->c(Lrb/k1;)V

    .line 6
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
.end method

.method public c()V
    .locals 1

    .line 1
    invoke-virtual {p0}, Ltb/i$b;->a()Lrb/r0;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Lrb/r0;->e()V

    .line 6
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
.end method

.method public d()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/i$b;->b:Lrb/r0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/r0;->f()V

    .line 4
    .line 5
    .line 6
    const/4 v0, 0x0

    .line 7
    iput-object v0, p0, Ltb/i$b;->b:Lrb/r0;

    .line 8
    .line 9
    return-void
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

.method public e(Lrb/r0$h;)Lrb/k1;
    .locals 5

    .line 1
    invoke-virtual {p1}, Lrb/r0$h;->c()Ljava/lang/Object;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    check-cast v0, Ltb/j2$b;

    .line 6
    .line 7
    const/4 v1, 0x0

    .line 8
    if-nez v0, :cond_0

    .line 9
    .line 10
    :try_start_0
    iget-object v0, p0, Ltb/i$b;->d:Ltb/i;

    .line 11
    .line 12
    invoke-static {v0}, Ltb/i;->a(Ltb/i;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v2

    .line 16
    const-string v3, "using default policy"

    .line 17
    .line 18
    invoke-static {v0, v2, v3}, Ltb/i;->c(Ltb/i;Ljava/lang/String;Ljava/lang/String;)Lrb/s0;

    .line 19
    .line 20
    .line 21
    move-result-object v0
    :try_end_0
    .catch Ltb/i$f; {:try_start_0 .. :try_end_0} :catch_0

    .line 22
    new-instance v2, Ltb/j2$b;

    .line 23
    .line 24
    invoke-direct {v2, v0, v1}, Ltb/j2$b;-><init>(Lrb/s0;Ljava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    move-object v0, v2

    .line 28
    goto :goto_0

    .line 29
    :catch_0
    move-exception p1

    .line 30
    sget-object v0, Lrb/k1;->s:Lrb/k1;

    .line 31
    .line 32
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 33
    .line 34
    .line 35
    move-result-object p1

    .line 36
    invoke-virtual {v0, p1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 37
    .line 38
    .line 39
    move-result-object p1

    .line 40
    iget-object v0, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 41
    .line 42
    sget-object v2, Lrb/p;->c:Lrb/p;

    .line 43
    .line 44
    new-instance v3, Ltb/i$d;

    .line 45
    .line 46
    invoke-direct {v3, p1}, Ltb/i$d;-><init>(Lrb/k1;)V

    .line 47
    .line 48
    .line 49
    invoke-virtual {v0, v2, v3}, Lrb/r0$e;->f(Lrb/p;Lrb/r0$j;)V

    .line 50
    .line 51
    .line 52
    iget-object p1, p0, Ltb/i$b;->b:Lrb/r0;

    .line 53
    .line 54
    invoke-virtual {p1}, Lrb/r0;->f()V

    .line 55
    .line 56
    .line 57
    iput-object v1, p0, Ltb/i$b;->c:Lrb/s0;

    .line 58
    .line 59
    new-instance p1, Ltb/i$e;

    .line 60
    .line 61
    invoke-direct {p1, v1}, Ltb/i$e;-><init>(Ltb/i$a;)V

    .line 62
    .line 63
    .line 64
    iput-object p1, p0, Ltb/i$b;->b:Lrb/r0;

    .line 65
    .line 66
    sget-object p1, Lrb/k1;->e:Lrb/k1;

    .line 67
    .line 68
    return-object p1

    .line 69
    :cond_0
    :goto_0
    iget-object v2, p0, Ltb/i$b;->c:Lrb/s0;

    .line 70
    .line 71
    if-eqz v2, :cond_1

    .line 72
    .line 73
    iget-object v2, v0, Ltb/j2$b;->a:Lrb/s0;

    .line 74
    .line 75
    invoke-virtual {v2}, Lrb/s0;->b()Ljava/lang/String;

    .line 76
    .line 77
    .line 78
    move-result-object v2

    .line 79
    iget-object v3, p0, Ltb/i$b;->c:Lrb/s0;

    .line 80
    .line 81
    invoke-virtual {v3}, Lrb/s0;->b()Ljava/lang/String;

    .line 82
    .line 83
    .line 84
    move-result-object v3

    .line 85
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    .line 86
    .line 87
    .line 88
    move-result v2

    .line 89
    if-nez v2, :cond_2

    .line 90
    .line 91
    :cond_1
    iget-object v2, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 92
    .line 93
    sget-object v3, Lrb/p;->a:Lrb/p;

    .line 94
    .line 95
    new-instance v4, Ltb/i$c;

    .line 96
    .line 97
    invoke-direct {v4, v1}, Ltb/i$c;-><init>(Ltb/i$a;)V

    .line 98
    .line 99
    .line 100
    invoke-virtual {v2, v3, v4}, Lrb/r0$e;->f(Lrb/p;Lrb/r0$j;)V

    .line 101
    .line 102
    .line 103
    iget-object v1, p0, Ltb/i$b;->b:Lrb/r0;

    .line 104
    .line 105
    invoke-virtual {v1}, Lrb/r0;->f()V

    .line 106
    .line 107
    .line 108
    iget-object v1, v0, Ltb/j2$b;->a:Lrb/s0;

    .line 109
    .line 110
    iput-object v1, p0, Ltb/i$b;->c:Lrb/s0;

    .line 111
    .line 112
    iget-object v2, p0, Ltb/i$b;->b:Lrb/r0;

    .line 113
    .line 114
    iget-object v3, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 115
    .line 116
    invoke-virtual {v1, v3}, Lrb/r0$c;->a(Lrb/r0$e;)Lrb/r0;

    .line 117
    .line 118
    .line 119
    move-result-object v1

    .line 120
    iput-object v1, p0, Ltb/i$b;->b:Lrb/r0;

    .line 121
    .line 122
    iget-object v1, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 123
    .line 124
    invoke-virtual {v1}, Lrb/r0$e;->b()Lrb/f;

    .line 125
    .line 126
    .line 127
    move-result-object v1

    .line 128
    sget-object v3, Lrb/f$a;->b:Lrb/f$a;

    .line 129
    .line 130
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 131
    .line 132
    .line 133
    move-result-object v2

    .line 134
    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 135
    .line 136
    .line 137
    move-result-object v2

    .line 138
    iget-object v4, p0, Ltb/i$b;->b:Lrb/r0;

    .line 139
    .line 140
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 141
    .line 142
    .line 143
    move-result-object v4

    .line 144
    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    .line 145
    .line 146
    .line 147
    move-result-object v4

    .line 148
    filled-new-array {v2, v4}, [Ljava/lang/Object;

    .line 149
    .line 150
    .line 151
    move-result-object v2

    .line 152
    const-string v4, "Load balancer changed from {0} to {1}"

    .line 153
    .line 154
    invoke-virtual {v1, v3, v4, v2}, Lrb/f;->b(Lrb/f$a;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 155
    .line 156
    .line 157
    :cond_2
    iget-object v1, v0, Ltb/j2$b;->b:Ljava/lang/Object;

    .line 158
    .line 159
    if-eqz v1, :cond_3

    .line 160
    .line 161
    iget-object v2, p0, Ltb/i$b;->a:Lrb/r0$e;

    .line 162
    .line 163
    invoke-virtual {v2}, Lrb/r0$e;->b()Lrb/f;

    .line 164
    .line 165
    .line 166
    move-result-object v2

    .line 167
    sget-object v3, Lrb/f$a;->a:Lrb/f$a;

    .line 168
    .line 169
    iget-object v0, v0, Ltb/j2$b;->b:Ljava/lang/Object;

    .line 170
    .line 171
    filled-new-array {v0}, [Ljava/lang/Object;

    .line 172
    .line 173
    .line 174
    move-result-object v0

    .line 175
    const-string v4, "Load-balancing config: {0}"

    .line 176
    .line 177
    invoke-virtual {v2, v3, v4, v0}, Lrb/f;->b(Lrb/f$a;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    .line 179
    .line 180
    :cond_3
    invoke-virtual {p0}, Ltb/i$b;->a()Lrb/r0;

    .line 181
    .line 182
    .line 183
    move-result-object v0

    .line 184
    invoke-static {}, Lrb/r0$h;->d()Lrb/r0$h$a;

    .line 185
    .line 186
    .line 187
    move-result-object v2

    .line 188
    invoke-virtual {p1}, Lrb/r0$h;->a()Ljava/util/List;

    .line 189
    .line 190
    .line 191
    move-result-object v3

    .line 192
    invoke-virtual {v2, v3}, Lrb/r0$h$a;->b(Ljava/util/List;)Lrb/r0$h$a;

    .line 193
    .line 194
    .line 195
    move-result-object v2

    .line 196
    invoke-virtual {p1}, Lrb/r0$h;->b()Lrb/a;

    .line 197
    .line 198
    .line 199
    move-result-object p1

    .line 200
    invoke-virtual {v2, p1}, Lrb/r0$h$a;->c(Lrb/a;)Lrb/r0$h$a;

    .line 201
    .line 202
    .line 203
    move-result-object p1

    .line 204
    invoke-virtual {p1, v1}, Lrb/r0$h$a;->d(Ljava/lang/Object;)Lrb/r0$h$a;

    .line 205
    .line 206
    .line 207
    move-result-object p1

    .line 208
    invoke-virtual {p1}, Lrb/r0$h$a;->a()Lrb/r0$h;

    .line 209
    .line 210
    .line 211
    move-result-object p1

    .line 212
    invoke-virtual {v0, p1}, Lrb/r0;->a(Lrb/r0$h;)Lrb/k1;

    .line 213
    .line 214
    .line 215
    move-result-object p1

    .line 216
    return-object p1
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
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
    .line 374
    .line 375
    .line 376
    .line 377
    .line 378
    .line 379
    .line 380
    .line 381
    .line 382
    .line 383
    .line 384
    .line 385
    .line 386
    .line 387
    .line 388
    .line 389
    .line 390
    .line 391
    .line 392
    .line 393
    .line 394
    .line 395
    .line 396
    .line 397
    .line 398
    .line 399
    .line 400
    .line 401
    .line 402
    .line 403
    .line 404
    .line 405
    .line 406
    .line 407
    .line 408
    .line 409
    .line 410
    .line 411
    .line 412
    .line 413
    .line 414
    .line 415
    .line 416
    .line 417
    .line 418
    .line 419
    .line 420
    .line 421
    .line 422
    .line 423
    .line 424
    .line 425
    .line 426
    .line 427
    .line 428
    .line 429
    .line 430
    .line 431
    .line 432
    .line 433
    .line 434
    .line 435
    .line 436
    .line 437
    .line 438
    .line 439
    .line 440
.end method
