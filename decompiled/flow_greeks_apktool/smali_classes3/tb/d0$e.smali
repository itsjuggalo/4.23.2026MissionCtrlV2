.class public final Ltb/d0$e;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/d0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "e"
.end annotation


# instance fields
.field public final a:Lrb/b1$d;

.field public final synthetic b:Ltb/d0;


# direct methods
.method public constructor <init>(Ltb/d0;Lrb/b1$d;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    .line 5
    .line 6
    const-string p1, "savedListener"

    .line 7
    .line 8
    invoke-static {p2, p1}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    check-cast p1, Lrb/b1$d;

    .line 13
    .line 14
    iput-object p1, p0, Ltb/d0$e;->a:Lrb/b1$d;

    .line 15
    .line 16
    return-void
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
.method public run()V
    .locals 8

    .line 1
    invoke-static {}, Ltb/d0;->f()Ljava/util/logging/Logger;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    sget-object v1, Ljava/util/logging/Level;->FINER:Ljava/util/logging/Level;

    .line 6
    .line 7
    invoke-virtual {v0, v1}, Ljava/util/logging/Logger;->isLoggable(Ljava/util/logging/Level;)Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    invoke-static {}, Ltb/d0;->f()Ljava/util/logging/Logger;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    new-instance v2, Ljava/lang/StringBuilder;

    .line 18
    .line 19
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 20
    .line 21
    .line 22
    const-string v3, "Attempting DNS resolution of "

    .line 23
    .line 24
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 25
    .line 26
    .line 27
    iget-object v3, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 28
    .line 29
    invoke-static {v3}, Ltb/d0;->g(Ltb/d0;)Ljava/lang/String;

    .line 30
    .line 31
    .line 32
    move-result-object v3

    .line 33
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 34
    .line 35
    .line 36
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 37
    .line 38
    .line 39
    move-result-object v2

    .line 40
    invoke-virtual {v0, v2}, Ljava/util/logging/Logger;->finer(Ljava/lang/String;)V

    .line 41
    .line 42
    .line 43
    :cond_0
    const/4 v0, 0x1

    .line 44
    const/4 v2, 0x0

    .line 45
    const/4 v3, 0x0

    .line 46
    :try_start_0
    iget-object v4, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 47
    .line 48
    invoke-static {v4}, Ltb/d0;->h(Ltb/d0;)Lrb/x;

    .line 49
    .line 50
    .line 51
    move-result-object v4

    .line 52
    invoke-static {}, Lrb/b1$e;->d()Lrb/b1$e$a;

    .line 53
    .line 54
    .line 55
    move-result-object v5

    .line 56
    if-eqz v4, :cond_2

    .line 57
    .line 58
    invoke-static {}, Ltb/d0;->f()Ljava/util/logging/Logger;

    .line 59
    .line 60
    .line 61
    move-result-object v6

    .line 62
    invoke-virtual {v6, v1}, Ljava/util/logging/Logger;->isLoggable(Ljava/util/logging/Level;)Z

    .line 63
    .line 64
    .line 65
    move-result v1

    .line 66
    if-eqz v1, :cond_1

    .line 67
    .line 68
    invoke-static {}, Ltb/d0;->f()Ljava/util/logging/Logger;

    .line 69
    .line 70
    .line 71
    move-result-object v1

    .line 72
    new-instance v6, Ljava/lang/StringBuilder;

    .line 73
    .line 74
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 75
    .line 76
    .line 77
    const-string v7, "Using proxy address "

    .line 78
    .line 79
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 80
    .line 81
    .line 82
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 83
    .line 84
    .line 85
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 86
    .line 87
    .line 88
    move-result-object v6

    .line 89
    invoke-virtual {v1, v6}, Ljava/util/logging/Logger;->finer(Ljava/lang/String;)V

    .line 90
    .line 91
    .line 92
    goto :goto_0

    .line 93
    :catchall_0
    move-exception v1

    .line 94
    goto/16 :goto_7

    .line 95
    .line 96
    :catch_0
    move-exception v1

    .line 97
    goto/16 :goto_5

    .line 98
    .line 99
    :cond_1
    :goto_0
    invoke-static {v4}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    .line 100
    .line 101
    .line 102
    move-result-object v1

    .line 103
    invoke-virtual {v5, v1}, Lrb/b1$e$a;->b(Ljava/util/List;)Lrb/b1$e$a;

    .line 104
    .line 105
    .line 106
    goto :goto_3

    .line 107
    :cond_2
    iget-object v1, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 108
    .line 109
    invoke-virtual {v1, v2}, Ltb/d0;->n(Z)Ltb/d0$c;

    .line 110
    .line 111
    .line 112
    move-result-object v3

    .line 113
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 114
    .line 115
    .line 116
    move-result-object v1

    .line 117
    if-eqz v1, :cond_4

    .line 118
    .line 119
    iget-object v1, p0, Ltb/d0$e;->a:Lrb/b1$d;

    .line 120
    .line 121
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 122
    .line 123
    .line 124
    move-result-object v4

    .line 125
    invoke-virtual {v1, v4}, Lrb/b1$d;->a(Lrb/k1;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 126
    .line 127
    .line 128
    if-eqz v3, :cond_3

    .line 129
    .line 130
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 131
    .line 132
    .line 133
    move-result-object v1

    .line 134
    if-nez v1, :cond_3

    .line 135
    .line 136
    goto :goto_1

    .line 137
    :cond_3
    move v0, v2

    .line 138
    :goto_1
    iget-object v1, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 139
    .line 140
    invoke-static {v1}, Ltb/d0;->e(Ltb/d0;)Lrb/o1;

    .line 141
    .line 142
    .line 143
    move-result-object v1

    .line 144
    new-instance v2, Ltb/d0$e$a;

    .line 145
    .line 146
    invoke-direct {v2, p0, v0}, Ltb/d0$e$a;-><init>(Ltb/d0$e;Z)V

    .line 147
    .line 148
    .line 149
    :goto_2
    invoke-virtual {v1, v2}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 150
    .line 151
    .line 152
    return-void

    .line 153
    :cond_4
    :try_start_1
    invoke-static {v3}, Ltb/d0$c;->a(Ltb/d0$c;)Ljava/util/List;

    .line 154
    .line 155
    .line 156
    move-result-object v1

    .line 157
    if-eqz v1, :cond_5

    .line 158
    .line 159
    invoke-static {v3}, Ltb/d0$c;->a(Ltb/d0$c;)Ljava/util/List;

    .line 160
    .line 161
    .line 162
    move-result-object v1

    .line 163
    invoke-virtual {v5, v1}, Lrb/b1$e$a;->b(Ljava/util/List;)Lrb/b1$e$a;

    .line 164
    .line 165
    .line 166
    :cond_5
    invoke-static {v3}, Ltb/d0$c;->e(Ltb/d0$c;)Lrb/b1$b;

    .line 167
    .line 168
    .line 169
    move-result-object v1

    .line 170
    if-eqz v1, :cond_6

    .line 171
    .line 172
    invoke-static {v3}, Ltb/d0$c;->e(Ltb/d0$c;)Lrb/b1$b;

    .line 173
    .line 174
    .line 175
    move-result-object v1

    .line 176
    invoke-virtual {v5, v1}, Lrb/b1$e$a;->d(Lrb/b1$b;)Lrb/b1$e$a;

    .line 177
    .line 178
    .line 179
    :cond_6
    iget-object v1, v3, Ltb/d0$c;->d:Lrb/a;

    .line 180
    .line 181
    if-eqz v1, :cond_7

    .line 182
    .line 183
    invoke-virtual {v5, v1}, Lrb/b1$e$a;->c(Lrb/a;)Lrb/b1$e$a;

    .line 184
    .line 185
    .line 186
    :cond_7
    :goto_3
    iget-object v1, p0, Ltb/d0$e;->a:Lrb/b1$d;

    .line 187
    .line 188
    invoke-virtual {v5}, Lrb/b1$e$a;->a()Lrb/b1$e;

    .line 189
    .line 190
    .line 191
    move-result-object v4

    .line 192
    invoke-virtual {v1, v4}, Lrb/b1$d;->b(Lrb/b1$e;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 193
    .line 194
    .line 195
    if-eqz v3, :cond_8

    .line 196
    .line 197
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 198
    .line 199
    .line 200
    move-result-object v1

    .line 201
    if-nez v1, :cond_8

    .line 202
    .line 203
    goto :goto_4

    .line 204
    :cond_8
    move v0, v2

    .line 205
    :goto_4
    iget-object v1, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 206
    .line 207
    invoke-static {v1}, Ltb/d0;->e(Ltb/d0;)Lrb/o1;

    .line 208
    .line 209
    .line 210
    move-result-object v1

    .line 211
    new-instance v2, Ltb/d0$e$a;

    .line 212
    .line 213
    invoke-direct {v2, p0, v0}, Ltb/d0$e$a;-><init>(Ltb/d0$e;Z)V

    .line 214
    .line 215
    .line 216
    goto :goto_2

    .line 217
    :goto_5
    :try_start_2
    iget-object v4, p0, Ltb/d0$e;->a:Lrb/b1$d;

    .line 218
    .line 219
    sget-object v5, Lrb/k1;->t:Lrb/k1;

    .line 220
    .line 221
    new-instance v6, Ljava/lang/StringBuilder;

    .line 222
    .line 223
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 224
    .line 225
    .line 226
    const-string v7, "Unable to resolve host "

    .line 227
    .line 228
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 229
    .line 230
    .line 231
    iget-object v7, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 232
    .line 233
    invoke-static {v7}, Ltb/d0;->g(Ltb/d0;)Ljava/lang/String;

    .line 234
    .line 235
    .line 236
    move-result-object v7

    .line 237
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 238
    .line 239
    .line 240
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 241
    .line 242
    .line 243
    move-result-object v6

    .line 244
    invoke-virtual {v5, v6}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 245
    .line 246
    .line 247
    move-result-object v5

    .line 248
    invoke-virtual {v5, v1}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 249
    .line 250
    .line 251
    move-result-object v1

    .line 252
    invoke-virtual {v4, v1}, Lrb/b1$d;->a(Lrb/k1;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 253
    .line 254
    .line 255
    if-eqz v3, :cond_9

    .line 256
    .line 257
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 258
    .line 259
    .line 260
    move-result-object v1

    .line 261
    if-nez v1, :cond_9

    .line 262
    .line 263
    goto :goto_6

    .line 264
    :cond_9
    move v0, v2

    .line 265
    :goto_6
    iget-object v1, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 266
    .line 267
    invoke-static {v1}, Ltb/d0;->e(Ltb/d0;)Lrb/o1;

    .line 268
    .line 269
    .line 270
    move-result-object v1

    .line 271
    new-instance v2, Ltb/d0$e$a;

    .line 272
    .line 273
    invoke-direct {v2, p0, v0}, Ltb/d0$e$a;-><init>(Ltb/d0$e;Z)V

    .line 274
    .line 275
    .line 276
    goto :goto_2

    .line 277
    :goto_7
    if-eqz v3, :cond_a

    .line 278
    .line 279
    invoke-static {v3}, Ltb/d0$c;->c(Ltb/d0$c;)Lrb/k1;

    .line 280
    .line 281
    .line 282
    move-result-object v3

    .line 283
    if-nez v3, :cond_a

    .line 284
    .line 285
    goto :goto_8

    .line 286
    :cond_a
    move v0, v2

    .line 287
    :goto_8
    iget-object v2, p0, Ltb/d0$e;->b:Ltb/d0;

    .line 288
    .line 289
    invoke-static {v2}, Ltb/d0;->e(Ltb/d0;)Lrb/o1;

    .line 290
    .line 291
    .line 292
    move-result-object v2

    .line 293
    new-instance v3, Ltb/d0$e$a;

    .line 294
    .line 295
    invoke-direct {v3, p0, v0}, Ltb/d0$e$a;-><init>(Ltb/d0$e;Z)V

    .line 296
    .line 297
    .line 298
    invoke-virtual {v2, v3}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 299
    .line 300
    .line 301
    throw v1
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
