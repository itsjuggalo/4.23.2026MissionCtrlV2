.class public final Ltb/g1$x;
.super Ltb/d;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "x"
.end annotation


# instance fields
.field public final a:Lrb/r0$b;

.field public final b:Lrb/k0;

.field public final c:Ltb/o;

.field public final d:Ltb/p;

.field public e:Ljava/util/List;

.field public f:Ltb/y0;

.field public g:Z

.field public h:Z

.field public i:Lrb/o1$d;

.field public final synthetic j:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;Lrb/r0$b;)V
    .locals 8

    .line 1
    iput-object p1, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 2
    .line 3
    invoke-direct {p0}, Ltb/d;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string v0, "args"

    .line 7
    .line 8
    invoke-static {p2, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    invoke-virtual {p2}, Lrb/r0$b;->a()Ljava/util/List;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    iput-object v0, p0, Ltb/g1$x;->e:Ljava/util/List;

    .line 16
    .line 17
    invoke-static {p1}, Ltb/g1;->t0(Ltb/g1;)Ljava/lang/String;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    if-eqz v0, :cond_0

    .line 22
    .line 23
    invoke-virtual {p2}, Lrb/r0$b;->a()Ljava/util/List;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-virtual {p0, v0}, Ltb/g1$x;->j(Ljava/util/List;)Ljava/util/List;

    .line 28
    .line 29
    .line 30
    move-result-object v0

    .line 31
    invoke-virtual {p2}, Lrb/r0$b;->e()Lrb/r0$b$a;

    .line 32
    .line 33
    .line 34
    move-result-object p2

    .line 35
    invoke-virtual {p2, v0}, Lrb/r0$b$a;->e(Ljava/util/List;)Lrb/r0$b$a;

    .line 36
    .line 37
    .line 38
    move-result-object p2

    .line 39
    invoke-virtual {p2}, Lrb/r0$b$a;->c()Lrb/r0$b;

    .line 40
    .line 41
    .line 42
    move-result-object p2

    .line 43
    :cond_0
    iput-object p2, p0, Ltb/g1$x;->a:Lrb/r0$b;

    .line 44
    .line 45
    const-string v0, "Subchannel"

    .line 46
    .line 47
    invoke-virtual {p1}, Ltb/g1;->a()Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object v1

    .line 51
    invoke-static {v0, v1}, Lrb/k0;->b(Ljava/lang/String;Ljava/lang/String;)Lrb/k0;

    .line 52
    .line 53
    .line 54
    move-result-object v3

    .line 55
    iput-object v3, p0, Ltb/g1$x;->b:Lrb/k0;

    .line 56
    .line 57
    new-instance v2, Ltb/p;

    .line 58
    .line 59
    invoke-static {p1}, Ltb/g1;->Z(Ltb/g1;)I

    .line 60
    .line 61
    .line 62
    move-result v4

    .line 63
    invoke-static {p1}, Ltb/g1;->Y(Ltb/g1;)Ltb/q2;

    .line 64
    .line 65
    .line 66
    move-result-object v0

    .line 67
    invoke-interface {v0}, Ltb/q2;->a()J

    .line 68
    .line 69
    .line 70
    move-result-wide v5

    .line 71
    new-instance v0, Ljava/lang/StringBuilder;

    .line 72
    .line 73
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 74
    .line 75
    .line 76
    const-string v1, "Subchannel for "

    .line 77
    .line 78
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    .line 80
    .line 81
    invoke-virtual {p2}, Lrb/r0$b;->a()Ljava/util/List;

    .line 82
    .line 83
    .line 84
    move-result-object p2

    .line 85
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 86
    .line 87
    .line 88
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 89
    .line 90
    .line 91
    move-result-object v7

    .line 92
    invoke-direct/range {v2 .. v7}, Ltb/p;-><init>(Lrb/k0;IJLjava/lang/String;)V

    .line 93
    .line 94
    .line 95
    iput-object v2, p0, Ltb/g1$x;->d:Ltb/p;

    .line 96
    .line 97
    new-instance p2, Ltb/o;

    .line 98
    .line 99
    invoke-static {p1}, Ltb/g1;->Y(Ltb/g1;)Ltb/q2;

    .line 100
    .line 101
    .line 102
    move-result-object p1

    .line 103
    invoke-direct {p2, v2, p1}, Ltb/o;-><init>(Ltb/p;Ltb/q2;)V

    .line 104
    .line 105
    .line 106
    iput-object p2, p0, Ltb/g1$x;->c:Ltb/o;

    .line 107
    .line 108
    return-void
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
.method public b()Ljava/util/List;
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 4
    .line 5
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 6
    .line 7
    .line 8
    iget-boolean v0, p0, Ltb/g1$x;->g:Z

    .line 9
    .line 10
    const-string v1, "not started"

    .line 11
    .line 12
    invoke-static {v0, v1}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 13
    .line 14
    .line 15
    iget-object v0, p0, Ltb/g1$x;->e:Ljava/util/List;

    .line 16
    .line 17
    return-object v0
    .line 18
    .line 19
.end method

.method public c()Lrb/a;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$x;->a:Lrb/r0$b;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/r0$b;->b()Lrb/a;

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

.method public d()Lrb/f;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$x;->c:Ltb/o;

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

.method public e()Ljava/lang/Object;
    .locals 2

    .line 1
    iget-boolean v0, p0, Ltb/g1$x;->g:Z

    .line 2
    .line 3
    const-string v1, "Subchannel is not started"

    .line 4
    .line 5
    invoke-static {v0, v1}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Ltb/g1$x;->f:Ltb/y0;

    .line 9
    .line 10
    return-object v0
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

.method public f()V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 4
    .line 5
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 6
    .line 7
    .line 8
    iget-boolean v0, p0, Ltb/g1$x;->g:Z

    .line 9
    .line 10
    const-string v1, "not started"

    .line 11
    .line 12
    invoke-static {v0, v1}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 13
    .line 14
    .line 15
    iget-object v0, p0, Ltb/g1$x;->f:Ltb/y0;

    .line 16
    .line 17
    invoke-virtual {v0}, Ltb/y0;->a()Ltb/t;

    .line 18
    .line 19
    .line 20
    return-void
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

.method public g()V
    .locals 7

    .line 1
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 4
    .line 5
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Ltb/g1$x;->f:Ltb/y0;

    .line 9
    .line 10
    const/4 v1, 0x1

    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    iput-boolean v1, p0, Ltb/g1$x;->h:Z

    .line 14
    .line 15
    return-void

    .line 16
    :cond_0
    iget-boolean v0, p0, Ltb/g1$x;->h:Z

    .line 17
    .line 18
    if-eqz v0, :cond_2

    .line 19
    .line 20
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 21
    .line 22
    invoke-static {v0}, Ltb/g1;->U(Ltb/g1;)Z

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    if-eqz v0, :cond_1

    .line 27
    .line 28
    iget-object v0, p0, Ltb/g1$x;->i:Lrb/o1$d;

    .line 29
    .line 30
    if-eqz v0, :cond_1

    .line 31
    .line 32
    invoke-virtual {v0}, Lrb/o1$d;->a()V

    .line 33
    .line 34
    .line 35
    const/4 v0, 0x0

    .line 36
    iput-object v0, p0, Ltb/g1$x;->i:Lrb/o1$d;

    .line 37
    .line 38
    goto :goto_0

    .line 39
    :cond_1
    return-void

    .line 40
    :cond_2
    iput-boolean v1, p0, Ltb/g1$x;->h:Z

    .line 41
    .line 42
    :goto_0
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 43
    .line 44
    invoke-static {v0}, Ltb/g1;->U(Ltb/g1;)Z

    .line 45
    .line 46
    .line 47
    move-result v0

    .line 48
    if-nez v0, :cond_3

    .line 49
    .line 50
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 51
    .line 52
    iget-object v1, v0, Ltb/g1;->r:Lrb/o1;

    .line 53
    .line 54
    new-instance v2, Ltb/d1;

    .line 55
    .line 56
    new-instance v0, Ltb/g1$x$b;

    .line 57
    .line 58
    invoke-direct {v0, p0}, Ltb/g1$x$b;-><init>(Ltb/g1$x;)V

    .line 59
    .line 60
    .line 61
    invoke-direct {v2, v0}, Ltb/d1;-><init>(Ljava/lang/Runnable;)V

    .line 62
    .line 63
    .line 64
    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    .line 65
    .line 66
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 67
    .line 68
    invoke-static {v0}, Ltb/g1;->x(Ltb/g1;)Ltb/u;

    .line 69
    .line 70
    .line 71
    move-result-object v0

    .line 72
    invoke-interface {v0}, Ltb/u;->Q()Ljava/util/concurrent/ScheduledExecutorService;

    .line 73
    .line 74
    .line 75
    move-result-object v6

    .line 76
    const-wide/16 v3, 0x5

    .line 77
    .line 78
    invoke-virtual/range {v1 .. v6}, Lrb/o1;->d(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/ScheduledExecutorService;)Lrb/o1$d;

    .line 79
    .line 80
    .line 81
    move-result-object v0

    .line 82
    iput-object v0, p0, Ltb/g1$x;->i:Lrb/o1$d;

    .line 83
    .line 84
    return-void

    .line 85
    :cond_3
    iget-object v0, p0, Ltb/g1$x;->f:Ltb/y0;

    .line 86
    .line 87
    sget-object v1, Ltb/g1;->p0:Lrb/k1;

    .line 88
    .line 89
    invoke-virtual {v0, v1}, Ltb/y0;->c(Lrb/k1;)V

    .line 90
    .line 91
    .line 92
    return-void
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
.end method

.method public h(Lrb/r0$k;)V
    .locals 20

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 4
    .line 5
    iget-object v1, v1, Ltb/g1;->r:Lrb/o1;

    .line 6
    .line 7
    invoke-virtual {v1}, Lrb/o1;->f()V

    .line 8
    .line 9
    .line 10
    iget-boolean v1, v0, Ltb/g1$x;->g:Z

    .line 11
    .line 12
    const/4 v2, 0x1

    .line 13
    xor-int/2addr v1, v2

    .line 14
    const-string v3, "already started"

    .line 15
    .line 16
    invoke-static {v1, v3}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 17
    .line 18
    .line 19
    iget-boolean v1, v0, Ltb/g1$x;->h:Z

    .line 20
    .line 21
    xor-int/2addr v1, v2

    .line 22
    const-string v3, "already shutdown"

    .line 23
    .line 24
    invoke-static {v1, v3}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 25
    .line 26
    .line 27
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 28
    .line 29
    invoke-static {v1}, Ltb/g1;->U(Ltb/g1;)Z

    .line 30
    .line 31
    .line 32
    move-result v1

    .line 33
    xor-int/2addr v1, v2

    .line 34
    const-string v3, "Channel is being terminated"

    .line 35
    .line 36
    invoke-static {v1, v3}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 37
    .line 38
    .line 39
    iput-boolean v2, v0, Ltb/g1$x;->g:Z

    .line 40
    .line 41
    new-instance v4, Ltb/y0;

    .line 42
    .line 43
    iget-object v1, v0, Ltb/g1$x;->a:Lrb/r0$b;

    .line 44
    .line 45
    invoke-virtual {v1}, Lrb/r0$b;->a()Ljava/util/List;

    .line 46
    .line 47
    .line 48
    move-result-object v5

    .line 49
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 50
    .line 51
    invoke-virtual {v1}, Ltb/g1;->a()Ljava/lang/String;

    .line 52
    .line 53
    .line 54
    move-result-object v6

    .line 55
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 56
    .line 57
    invoke-static {v1}, Ltb/g1;->d0(Ltb/g1;)Ljava/lang/String;

    .line 58
    .line 59
    .line 60
    move-result-object v7

    .line 61
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 62
    .line 63
    invoke-static {v1}, Ltb/g1;->e0(Ltb/g1;)Ltb/j$a;

    .line 64
    .line 65
    .line 66
    move-result-object v8

    .line 67
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 68
    .line 69
    invoke-static {v1}, Ltb/g1;->x(Ltb/g1;)Ltb/u;

    .line 70
    .line 71
    .line 72
    move-result-object v9

    .line 73
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 74
    .line 75
    invoke-static {v1}, Ltb/g1;->x(Ltb/g1;)Ltb/u;

    .line 76
    .line 77
    .line 78
    move-result-object v1

    .line 79
    invoke-interface {v1}, Ltb/u;->Q()Ljava/util/concurrent/ScheduledExecutorService;

    .line 80
    .line 81
    .line 82
    move-result-object v10

    .line 83
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 84
    .line 85
    invoke-static {v1}, Ltb/g1;->f0(Ltb/g1;)Lp6/s;

    .line 86
    .line 87
    .line 88
    move-result-object v11

    .line 89
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 90
    .line 91
    iget-object v12, v1, Ltb/g1;->r:Lrb/o1;

    .line 92
    .line 93
    new-instance v13, Ltb/g1$x$a;

    .line 94
    .line 95
    move-object/from16 v1, p1

    .line 96
    .line 97
    invoke-direct {v13, v0, v1}, Ltb/g1$x$a;-><init>(Ltb/g1$x;Lrb/r0$k;)V

    .line 98
    .line 99
    .line 100
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 101
    .line 102
    invoke-static {v1}, Ltb/g1;->b0(Ltb/g1;)Lrb/e0;

    .line 103
    .line 104
    .line 105
    move-result-object v14

    .line 106
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 107
    .line 108
    invoke-static {v1}, Ltb/g1;->a0(Ltb/g1;)Ltb/n$b;

    .line 109
    .line 110
    .line 111
    move-result-object v1

    .line 112
    invoke-interface {v1}, Ltb/n$b;->a()Ltb/n;

    .line 113
    .line 114
    .line 115
    move-result-object v15

    .line 116
    iget-object v1, v0, Ltb/g1$x;->d:Ltb/p;

    .line 117
    .line 118
    iget-object v2, v0, Ltb/g1$x;->b:Lrb/k0;

    .line 119
    .line 120
    iget-object v3, v0, Ltb/g1$x;->c:Ltb/o;

    .line 121
    .line 122
    move-object/from16 v16, v1

    .line 123
    .line 124
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 125
    .line 126
    invoke-static {v1}, Ltb/g1;->g0(Ltb/g1;)Ljava/util/List;

    .line 127
    .line 128
    .line 129
    move-result-object v19

    .line 130
    move-object/from16 v17, v2

    .line 131
    .line 132
    move-object/from16 v18, v3

    .line 133
    .line 134
    invoke-direct/range {v4 .. v19}, Ltb/y0;-><init>(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ltb/j$a;Ltb/u;Ljava/util/concurrent/ScheduledExecutorService;Lp6/s;Lrb/o1;Ltb/y0$j;Lrb/e0;Ltb/n;Ltb/p;Lrb/k0;Lrb/f;Ljava/util/List;)V

    .line 135
    .line 136
    .line 137
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 138
    .line 139
    invoke-static {v1}, Ltb/g1;->N(Ltb/g1;)Ltb/p;

    .line 140
    .line 141
    .line 142
    move-result-object v1

    .line 143
    new-instance v2, Lrb/f0$a;

    .line 144
    .line 145
    invoke-direct {v2}, Lrb/f0$a;-><init>()V

    .line 146
    .line 147
    .line 148
    const-string v3, "Child Subchannel started"

    .line 149
    .line 150
    invoke-virtual {v2, v3}, Lrb/f0$a;->b(Ljava/lang/String;)Lrb/f0$a;

    .line 151
    .line 152
    .line 153
    move-result-object v2

    .line 154
    sget-object v3, Lrb/f0$b;->b:Lrb/f0$b;

    .line 155
    .line 156
    invoke-virtual {v2, v3}, Lrb/f0$a;->c(Lrb/f0$b;)Lrb/f0$a;

    .line 157
    .line 158
    .line 159
    move-result-object v2

    .line 160
    iget-object v3, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 161
    .line 162
    invoke-static {v3}, Ltb/g1;->Y(Ltb/g1;)Ltb/q2;

    .line 163
    .line 164
    .line 165
    move-result-object v3

    .line 166
    invoke-interface {v3}, Ltb/q2;->a()J

    .line 167
    .line 168
    .line 169
    move-result-wide v5

    .line 170
    invoke-virtual {v2, v5, v6}, Lrb/f0$a;->e(J)Lrb/f0$a;

    .line 171
    .line 172
    .line 173
    move-result-object v2

    .line 174
    invoke-virtual {v2, v4}, Lrb/f0$a;->d(Lrb/p0;)Lrb/f0$a;

    .line 175
    .line 176
    .line 177
    move-result-object v2

    .line 178
    invoke-virtual {v2}, Lrb/f0$a;->a()Lrb/f0;

    .line 179
    .line 180
    .line 181
    move-result-object v2

    .line 182
    invoke-virtual {v1, v2}, Ltb/p;->e(Lrb/f0;)V

    .line 183
    .line 184
    .line 185
    iput-object v4, v0, Ltb/g1$x;->f:Ltb/y0;

    .line 186
    .line 187
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 188
    .line 189
    invoke-static {v1}, Ltb/g1;->b0(Ltb/g1;)Lrb/e0;

    .line 190
    .line 191
    .line 192
    move-result-object v1

    .line 193
    invoke-virtual {v1, v4}, Lrb/e0;->e(Lrb/j0;)V

    .line 194
    .line 195
    .line 196
    iget-object v1, v0, Ltb/g1$x;->j:Ltb/g1;

    .line 197
    .line 198
    invoke-static {v1}, Ltb/g1;->k0(Ltb/g1;)Ljava/util/Set;

    .line 199
    .line 200
    .line 201
    move-result-object v1

    .line 202
    invoke-interface {v1, v4}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 203
    .line 204
    .line 205
    return-void
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

.method public i(Ljava/util/List;)V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/g1;->r:Lrb/o1;

    .line 4
    .line 5
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 6
    .line 7
    .line 8
    iput-object p1, p0, Ltb/g1$x;->e:Ljava/util/List;

    .line 9
    .line 10
    iget-object v0, p0, Ltb/g1$x;->j:Ltb/g1;

    .line 11
    .line 12
    invoke-static {v0}, Ltb/g1;->t0(Ltb/g1;)Ljava/lang/String;

    .line 13
    .line 14
    .line 15
    move-result-object v0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    invoke-virtual {p0, p1}, Ltb/g1$x;->j(Ljava/util/List;)Ljava/util/List;

    .line 19
    .line 20
    .line 21
    move-result-object p1

    .line 22
    :cond_0
    iget-object v0, p0, Ltb/g1$x;->f:Ltb/y0;

    .line 23
    .line 24
    invoke-virtual {v0, p1}, Ltb/y0;->U(Ljava/util/List;)V

    .line 25
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

.method public final j(Ljava/util/List;)Ljava/util/List;
    .locals 5

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 4
    .line 5
    .line 6
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    if-eqz v1, :cond_0

    .line 15
    .line 16
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object v1

    .line 20
    check-cast v1, Lrb/x;

    .line 21
    .line 22
    new-instance v2, Lrb/x;

    .line 23
    .line 24
    invoke-virtual {v1}, Lrb/x;->a()Ljava/util/List;

    .line 25
    .line 26
    .line 27
    move-result-object v3

    .line 28
    invoke-virtual {v1}, Lrb/x;->b()Lrb/a;

    .line 29
    .line 30
    .line 31
    move-result-object v1

    .line 32
    invoke-virtual {v1}, Lrb/a;->d()Lrb/a$b;

    .line 33
    .line 34
    .line 35
    move-result-object v1

    .line 36
    sget-object v4, Lrb/x;->d:Lrb/a$c;

    .line 37
    .line 38
    invoke-virtual {v1, v4}, Lrb/a$b;->c(Lrb/a$c;)Lrb/a$b;

    .line 39
    .line 40
    .line 41
    move-result-object v1

    .line 42
    invoke-virtual {v1}, Lrb/a$b;->a()Lrb/a;

    .line 43
    .line 44
    .line 45
    move-result-object v1

    .line 46
    invoke-direct {v2, v3, v1}, Lrb/x;-><init>(Ljava/util/List;Lrb/a;)V

    .line 47
    .line 48
    .line 49
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 50
    .line 51
    .line 52
    goto :goto_0

    .line 53
    :cond_0
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    .line 54
    .line 55
    .line 56
    move-result-object p1

    .line 57
    return-object p1
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

.method public toString()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$x;->b:Lrb/k0;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/k0;->toString()Ljava/lang/String;

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
