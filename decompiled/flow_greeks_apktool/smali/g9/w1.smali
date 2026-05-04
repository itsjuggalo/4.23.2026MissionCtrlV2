.class public Lg9/w1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lg9/w1$b;
    }
.end annotation


# instance fields
.field public final a:Lg9/b1;

.field public b:Lg9/y1$a;

.field public c:Z

.field public d:Lj9/m;

.field public e:Lg8/e;

.field public f:Lg8/e;

.field public g:Lg8/e;


# direct methods
.method public constructor <init>(Lg9/b1;Lg8/e;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lg9/w1;->a:Lg9/b1;

    .line 5
    .line 6
    sget-object v0, Lg9/y1$a;->a:Lg9/y1$a;

    .line 7
    .line 8
    iput-object v0, p0, Lg9/w1;->b:Lg9/y1$a;

    .line 9
    .line 10
    invoke-virtual {p1}, Lg9/b1;->c()Ljava/util/Comparator;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    invoke-static {p1}, Lj9/m;->d(Ljava/util/Comparator;)Lj9/m;

    .line 15
    .line 16
    .line 17
    move-result-object p1

    .line 18
    iput-object p1, p0, Lg9/w1;->d:Lj9/m;

    .line 19
    .line 20
    iput-object p2, p0, Lg9/w1;->e:Lg8/e;

    .line 21
    .line 22
    invoke-static {}, Lj9/k;->h()Lg8/e;

    .line 23
    .line 24
    .line 25
    move-result-object p1

    .line 26
    iput-object p1, p0, Lg9/w1;->f:Lg8/e;

    .line 27
    .line 28
    invoke-static {}, Lj9/k;->h()Lg8/e;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    iput-object p1, p0, Lg9/w1;->g:Lg8/e;

    .line 33
    .line 34
    return-void
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method

.method public static synthetic a(Ljava/util/Comparator;Lg9/m;Lg9/m;)I
    .locals 2

    .line 1
    invoke-static {p1}, Lg9/w1;->g(Lg9/m;)I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-static {p2}, Lg9/w1;->g(Lg9/m;)I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    invoke-static {v0, v1}, Ljava/lang/Integer;->compare(II)I

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    if-eqz v0, :cond_0

    .line 14
    .line 15
    return v0

    .line 16
    :cond_0
    invoke-virtual {p1}, Lg9/m;->b()Lj9/h;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    invoke-virtual {p2}, Lg9/m;->b()Lj9/h;

    .line 21
    .line 22
    .line 23
    move-result-object p2

    .line 24
    invoke-interface {p0, p1, p2}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    .line 25
    .line 26
    .line 27
    move-result p0

    .line 28
    return p0
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

.method public static g(Lg9/m;)I
    .locals 3

    .line 1
    sget-object v0, Lg9/w1$a;->a:[I

    .line 2
    .line 3
    invoke-virtual {p0}, Lg9/m;->c()Lg9/m$a;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    invoke-virtual {v1}, Ljava/lang/Enum;->ordinal()I

    .line 8
    .line 9
    .line 10
    move-result v1

    .line 11
    aget v0, v0, v1

    .line 12
    .line 13
    const/4 v1, 0x1

    .line 14
    if-eq v0, v1, :cond_1

    .line 15
    .line 16
    const/4 v1, 0x2

    .line 17
    if-eq v0, v1, :cond_1

    .line 18
    .line 19
    const/4 v2, 0x3

    .line 20
    if-eq v0, v2, :cond_1

    .line 21
    .line 22
    const/4 v1, 0x4

    .line 23
    if-ne v0, v1, :cond_0

    .line 24
    .line 25
    const/4 p0, 0x0

    .line 26
    return p0

    .line 27
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 28
    .line 29
    new-instance v1, Ljava/lang/StringBuilder;

    .line 30
    .line 31
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 32
    .line 33
    .line 34
    const-string v2, "Unknown change type: "

    .line 35
    .line 36
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 37
    .line 38
    .line 39
    invoke-virtual {p0}, Lg9/m;->c()Lg9/m$a;

    .line 40
    .line 41
    .line 42
    move-result-object p0

    .line 43
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 44
    .line 45
    .line 46
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 47
    .line 48
    .line 49
    move-result-object p0

    .line 50
    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 51
    .line 52
    .line 53
    throw v0

    .line 54
    :cond_1
    return v1
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


# virtual methods
.method public b(Lg9/w1$b;)Lg9/x1;
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-virtual {p0, p1, v0}, Lg9/w1;->c(Lg9/w1$b;Lm9/v0;)Lg9/x1;

    .line 3
    .line 4
    .line 5
    move-result-object p1

    .line 6
    return-object p1
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

.method public c(Lg9/w1$b;Lm9/v0;)Lg9/x1;
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-virtual {p0, p1, p2, v0}, Lg9/w1;->d(Lg9/w1$b;Lm9/v0;Z)Lg9/x1;

    .line 3
    .line 4
    .line 5
    move-result-object p1

    .line 6
    return-object p1
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
.end method

.method public d(Lg9/w1$b;Lm9/v0;Z)Lg9/x1;
    .locals 18

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    move-object/from16 v2, p2

    .line 6
    .line 7
    invoke-static {v1}, Lg9/w1$b;->a(Lg9/w1$b;)Z

    .line 8
    .line 9
    .line 10
    move-result v3

    .line 11
    const/4 v4, 0x1

    .line 12
    xor-int/2addr v3, v4

    .line 13
    const/4 v5, 0x0

    .line 14
    new-array v6, v5, [Ljava/lang/Object;

    .line 15
    .line 16
    const-string v7, "Cannot apply changes that need a refill"

    .line 17
    .line 18
    invoke-static {v3, v7, v6}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 19
    .line 20
    .line 21
    iget-object v11, v0, Lg9/w1;->d:Lj9/m;

    .line 22
    .line 23
    iget-object v3, v1, Lg9/w1$b;->a:Lj9/m;

    .line 24
    .line 25
    iput-object v3, v0, Lg9/w1;->d:Lj9/m;

    .line 26
    .line 27
    iget-object v3, v1, Lg9/w1$b;->d:Lg8/e;

    .line 28
    .line 29
    iput-object v3, v0, Lg9/w1;->g:Lg8/e;

    .line 30
    .line 31
    iget-object v3, v1, Lg9/w1$b;->b:Lg9/n;

    .line 32
    .line 33
    invoke-virtual {v3}, Lg9/n;->b()Ljava/util/List;

    .line 34
    .line 35
    .line 36
    move-result-object v12

    .line 37
    iget-object v3, v0, Lg9/w1;->a:Lg9/b1;

    .line 38
    .line 39
    invoke-virtual {v3}, Lg9/b1;->c()Ljava/util/Comparator;

    .line 40
    .line 41
    .line 42
    move-result-object v3

    .line 43
    new-instance v6, Lg9/v1;

    .line 44
    .line 45
    invoke-direct {v6, v3}, Lg9/v1;-><init>(Ljava/util/Comparator;)V

    .line 46
    .line 47
    .line 48
    invoke-static {v12, v6}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 49
    .line 50
    .line 51
    invoke-virtual {v0, v2}, Lg9/w1;->f(Lm9/v0;)V

    .line 52
    .line 53
    .line 54
    if-eqz p3, :cond_0

    .line 55
    .line 56
    sget-object v3, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 57
    .line 58
    goto :goto_0

    .line 59
    :cond_0
    invoke-virtual {v0}, Lg9/w1;->n()Ljava/util/List;

    .line 60
    .line 61
    .line 62
    move-result-object v3

    .line 63
    :goto_0
    iget-object v6, v0, Lg9/w1;->f:Lg8/e;

    .line 64
    .line 65
    invoke-virtual {v6}, Lg8/e;->size()I

    .line 66
    .line 67
    .line 68
    move-result v6

    .line 69
    if-nez v6, :cond_1

    .line 70
    .line 71
    iget-boolean v6, v0, Lg9/w1;->c:Z

    .line 72
    .line 73
    if-eqz v6, :cond_1

    .line 74
    .line 75
    if-nez p3, :cond_1

    .line 76
    .line 77
    sget-object v6, Lg9/y1$a;->c:Lg9/y1$a;

    .line 78
    .line 79
    goto :goto_1

    .line 80
    :cond_1
    sget-object v6, Lg9/y1$a;->b:Lg9/y1$a;

    .line 81
    .line 82
    :goto_1
    iget-object v7, v0, Lg9/w1;->b:Lg9/y1$a;

    .line 83
    .line 84
    if-eq v6, v7, :cond_2

    .line 85
    .line 86
    move v15, v4

    .line 87
    goto :goto_2

    .line 88
    :cond_2
    move v15, v5

    .line 89
    :goto_2
    iput-object v6, v0, Lg9/w1;->b:Lg9/y1$a;

    .line 90
    .line 91
    invoke-interface {v12}, Ljava/util/List;->size()I

    .line 92
    .line 93
    .line 94
    move-result v7

    .line 95
    if-nez v7, :cond_4

    .line 96
    .line 97
    if-eqz v15, :cond_3

    .line 98
    .line 99
    goto :goto_3

    .line 100
    :cond_3
    const/4 v1, 0x0

    .line 101
    goto :goto_6

    .line 102
    :cond_4
    :goto_3
    sget-object v7, Lg9/y1$a;->b:Lg9/y1$a;

    .line 103
    .line 104
    if-ne v6, v7, :cond_5

    .line 105
    .line 106
    move v13, v4

    .line 107
    goto :goto_4

    .line 108
    :cond_5
    move v13, v5

    .line 109
    :goto_4
    if-nez v2, :cond_7

    .line 110
    .line 111
    :cond_6
    move/from16 v17, v5

    .line 112
    .line 113
    goto :goto_5

    .line 114
    :cond_7
    invoke-virtual {v2}, Lm9/v0;->e()Lcom/google/protobuf/i;

    .line 115
    .line 116
    .line 117
    move-result-object v2

    .line 118
    invoke-virtual {v2}, Lcom/google/protobuf/i;->isEmpty()Z

    .line 119
    .line 120
    .line 121
    move-result v2

    .line 122
    if-nez v2, :cond_6

    .line 123
    .line 124
    move/from16 v17, v4

    .line 125
    .line 126
    :goto_5
    new-instance v8, Lg9/y1;

    .line 127
    .line 128
    iget-object v9, v0, Lg9/w1;->a:Lg9/b1;

    .line 129
    .line 130
    iget-object v10, v1, Lg9/w1$b;->a:Lj9/m;

    .line 131
    .line 132
    iget-object v14, v1, Lg9/w1$b;->d:Lg8/e;

    .line 133
    .line 134
    const/16 v16, 0x0

    .line 135
    .line 136
    invoke-direct/range {v8 .. v17}, Lg9/y1;-><init>(Lg9/b1;Lj9/m;Lj9/m;Ljava/util/List;ZLg8/e;ZZZ)V

    .line 137
    .line 138
    .line 139
    move-object v1, v8

    .line 140
    :goto_6
    new-instance v2, Lg9/x1;

    .line 141
    .line 142
    invoke-direct {v2, v1, v3}, Lg9/x1;-><init>(Lg9/y1;Ljava/util/List;)V

    .line 143
    .line 144
    .line 145
    return-object v2
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
    .line 441
    .line 442
    .line 443
    .line 444
    .line 445
    .line 446
    .line 447
    .line 448
    .line 449
    .line 450
    .line 451
    .line 452
    .line 453
    .line 454
    .line 455
    .line 456
    .line 457
    .line 458
    .line 459
    .line 460
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
.end method

.method public e(Lg9/z0;)Lg9/x1;
    .locals 6

    .line 1
    iget-boolean v0, p0, Lg9/w1;->c:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    sget-object v0, Lg9/z0;->c:Lg9/z0;

    .line 6
    .line 7
    if-ne p1, v0, :cond_0

    .line 8
    .line 9
    const/4 p1, 0x0

    .line 10
    iput-boolean p1, p0, Lg9/w1;->c:Z

    .line 11
    .line 12
    new-instance v0, Lg9/w1$b;

    .line 13
    .line 14
    iget-object v1, p0, Lg9/w1;->d:Lj9/m;

    .line 15
    .line 16
    new-instance v2, Lg9/n;

    .line 17
    .line 18
    invoke-direct {v2}, Lg9/n;-><init>()V

    .line 19
    .line 20
    .line 21
    iget-object v3, p0, Lg9/w1;->g:Lg8/e;

    .line 22
    .line 23
    const/4 v4, 0x0

    .line 24
    const/4 v5, 0x0

    .line 25
    invoke-direct/range {v0 .. v5}, Lg9/w1$b;-><init>(Lj9/m;Lg9/n;Lg8/e;ZLg9/w1$a;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {p0, v0}, Lg9/w1;->b(Lg9/w1$b;)Lg9/x1;

    .line 29
    .line 30
    .line 31
    move-result-object p1

    .line 32
    return-object p1

    .line 33
    :cond_0
    new-instance p1, Lg9/x1;

    .line 34
    .line 35
    const/4 v0, 0x0

    .line 36
    sget-object v1, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 37
    .line 38
    invoke-direct {p1, v0, v1}, Lg9/x1;-><init>(Lg9/y1;Ljava/util/List;)V

    .line 39
    .line 40
    .line 41
    return-object p1
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

.method public final f(Lm9/v0;)V
    .locals 4

    .line 1
    if-eqz p1, :cond_3

    .line 2
    .line 3
    invoke-virtual {p1}, Lm9/v0;->b()Lg8/e;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-eqz v1, :cond_0

    .line 16
    .line 17
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    check-cast v1, Lj9/k;

    .line 22
    .line 23
    iget-object v2, p0, Lg9/w1;->e:Lg8/e;

    .line 24
    .line 25
    invoke-virtual {v2, v1}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    iput-object v1, p0, Lg9/w1;->e:Lg8/e;

    .line 30
    .line 31
    goto :goto_0

    .line 32
    :cond_0
    invoke-virtual {p1}, Lm9/v0;->c()Lg8/e;

    .line 33
    .line 34
    .line 35
    move-result-object v0

    .line 36
    invoke-virtual {v0}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 37
    .line 38
    .line 39
    move-result-object v0

    .line 40
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 41
    .line 42
    .line 43
    move-result v1

    .line 44
    if-eqz v1, :cond_1

    .line 45
    .line 46
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 47
    .line 48
    .line 49
    move-result-object v1

    .line 50
    check-cast v1, Lj9/k;

    .line 51
    .line 52
    iget-object v2, p0, Lg9/w1;->e:Lg8/e;

    .line 53
    .line 54
    invoke-virtual {v2, v1}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 55
    .line 56
    .line 57
    move-result v2

    .line 58
    const-string v3, "Modified document %s not found in view."

    .line 59
    .line 60
    filled-new-array {v1}, [Ljava/lang/Object;

    .line 61
    .line 62
    .line 63
    move-result-object v1

    .line 64
    invoke-static {v2, v3, v1}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 65
    .line 66
    .line 67
    goto :goto_1

    .line 68
    :cond_1
    invoke-virtual {p1}, Lm9/v0;->d()Lg8/e;

    .line 69
    .line 70
    .line 71
    move-result-object v0

    .line 72
    invoke-virtual {v0}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 73
    .line 74
    .line 75
    move-result-object v0

    .line 76
    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 77
    .line 78
    .line 79
    move-result v1

    .line 80
    if-eqz v1, :cond_2

    .line 81
    .line 82
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 83
    .line 84
    .line 85
    move-result-object v1

    .line 86
    check-cast v1, Lj9/k;

    .line 87
    .line 88
    iget-object v2, p0, Lg9/w1;->e:Lg8/e;

    .line 89
    .line 90
    invoke-virtual {v2, v1}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 91
    .line 92
    .line 93
    move-result-object v1

    .line 94
    iput-object v1, p0, Lg9/w1;->e:Lg8/e;

    .line 95
    .line 96
    goto :goto_2

    .line 97
    :cond_2
    invoke-virtual {p1}, Lm9/v0;->f()Z

    .line 98
    .line 99
    .line 100
    move-result p1

    .line 101
    iput-boolean p1, p0, Lg9/w1;->c:Z

    .line 102
    .line 103
    :cond_3
    return-void
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
.end method

.method public h(Lg8/c;)Lg9/w1$b;
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-virtual {p0, p1, v0}, Lg9/w1;->i(Lg8/c;Lg9/w1$b;)Lg9/w1$b;

    .line 3
    .line 4
    .line 5
    move-result-object p1

    .line 6
    return-object p1
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

.method public i(Lg8/c;Lg9/w1$b;)Lg9/w1$b;
    .locals 17

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p2

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    iget-object v2, v1, Lg9/w1$b;->b:Lg9/n;

    .line 8
    .line 9
    :goto_0
    move-object v5, v2

    .line 10
    goto :goto_1

    .line 11
    :cond_0
    new-instance v2, Lg9/n;

    .line 12
    .line 13
    invoke-direct {v2}, Lg9/n;-><init>()V

    .line 14
    .line 15
    .line 16
    goto :goto_0

    .line 17
    :goto_1
    if-eqz v1, :cond_1

    .line 18
    .line 19
    iget-object v2, v1, Lg9/w1$b;->a:Lj9/m;

    .line 20
    .line 21
    goto :goto_2

    .line 22
    :cond_1
    iget-object v2, v0, Lg9/w1;->d:Lj9/m;

    .line 23
    .line 24
    :goto_2
    if-eqz v1, :cond_2

    .line 25
    .line 26
    iget-object v3, v1, Lg9/w1$b;->d:Lg8/e;

    .line 27
    .line 28
    goto :goto_3

    .line 29
    :cond_2
    iget-object v3, v0, Lg9/w1;->g:Lg8/e;

    .line 30
    .line 31
    :goto_3
    iget-object v4, v0, Lg9/w1;->a:Lg9/b1;

    .line 32
    .line 33
    invoke-virtual {v4}, Lg9/b1;->l()Lg9/b1$a;

    .line 34
    .line 35
    .line 36
    move-result-object v4

    .line 37
    sget-object v6, Lg9/b1$a;->a:Lg9/b1$a;

    .line 38
    .line 39
    invoke-virtual {v4, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 40
    .line 41
    .line 42
    move-result v4

    .line 43
    if-eqz v4, :cond_3

    .line 44
    .line 45
    invoke-virtual {v2}, Lj9/m;->size()I

    .line 46
    .line 47
    .line 48
    move-result v4

    .line 49
    int-to-long v7, v4

    .line 50
    iget-object v4, v0, Lg9/w1;->a:Lg9/b1;

    .line 51
    .line 52
    invoke-virtual {v4}, Lg9/b1;->k()J

    .line 53
    .line 54
    .line 55
    move-result-wide v9

    .line 56
    cmp-long v4, v7, v9

    .line 57
    .line 58
    if-nez v4, :cond_3

    .line 59
    .line 60
    invoke-virtual {v2}, Lj9/m;->g()Lj9/h;

    .line 61
    .line 62
    .line 63
    move-result-object v4

    .line 64
    goto :goto_4

    .line 65
    :cond_3
    const/4 v4, 0x0

    .line 66
    :goto_4
    iget-object v7, v0, Lg9/w1;->a:Lg9/b1;

    .line 67
    .line 68
    invoke-virtual {v7}, Lg9/b1;->l()Lg9/b1$a;

    .line 69
    .line 70
    .line 71
    move-result-object v7

    .line 72
    sget-object v8, Lg9/b1$a;->b:Lg9/b1$a;

    .line 73
    .line 74
    invoke-virtual {v7, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 75
    .line 76
    .line 77
    move-result v7

    .line 78
    if-eqz v7, :cond_4

    .line 79
    .line 80
    invoke-virtual {v2}, Lj9/m;->size()I

    .line 81
    .line 82
    .line 83
    move-result v7

    .line 84
    int-to-long v7, v7

    .line 85
    iget-object v9, v0, Lg9/w1;->a:Lg9/b1;

    .line 86
    .line 87
    invoke-virtual {v9}, Lg9/b1;->k()J

    .line 88
    .line 89
    .line 90
    move-result-wide v9

    .line 91
    cmp-long v7, v7, v9

    .line 92
    .line 93
    if-nez v7, :cond_4

    .line 94
    .line 95
    invoke-virtual {v2}, Lj9/m;->f()Lj9/h;

    .line 96
    .line 97
    .line 98
    move-result-object v7

    .line 99
    goto :goto_5

    .line 100
    :cond_4
    const/4 v7, 0x0

    .line 101
    :goto_5
    iget-object v8, v0, Lg9/w1;->a:Lg9/b1;

    .line 102
    .line 103
    invoke-virtual {v8}, Lg9/b1;->c()Ljava/util/Comparator;

    .line 104
    .line 105
    .line 106
    move-result-object v8

    .line 107
    invoke-virtual/range {p1 .. p1}, Lg8/c;->iterator()Ljava/util/Iterator;

    .line 108
    .line 109
    .line 110
    move-result-object v9

    .line 111
    move-object v11, v2

    .line 112
    const/4 v12, 0x0

    .line 113
    :goto_6
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    .line 114
    .line 115
    .line 116
    move-result v13

    .line 117
    if-eqz v13, :cond_13

    .line 118
    .line 119
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 120
    .line 121
    .line 122
    move-result-object v13

    .line 123
    check-cast v13, Ljava/util/Map$Entry;

    .line 124
    .line 125
    invoke-interface {v13}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    .line 126
    .line 127
    .line 128
    move-result-object v15

    .line 129
    check-cast v15, Lj9/k;

    .line 130
    .line 131
    invoke-virtual {v2, v15}, Lj9/m;->e(Lj9/k;)Lj9/h;

    .line 132
    .line 133
    .line 134
    move-result-object v6

    .line 135
    iget-object v14, v0, Lg9/w1;->a:Lg9/b1;

    .line 136
    .line 137
    invoke-interface {v13}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    .line 138
    .line 139
    .line 140
    move-result-object v16

    .line 141
    move-object/from16 v10, v16

    .line 142
    .line 143
    check-cast v10, Lj9/h;

    .line 144
    .line 145
    invoke-virtual {v14, v10}, Lg9/b1;->u(Lj9/h;)Z

    .line 146
    .line 147
    .line 148
    move-result v10

    .line 149
    if-eqz v10, :cond_5

    .line 150
    .line 151
    invoke-interface {v13}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    .line 152
    .line 153
    .line 154
    move-result-object v10

    .line 155
    check-cast v10, Lj9/h;

    .line 156
    .line 157
    goto :goto_7

    .line 158
    :cond_5
    const/4 v10, 0x0

    .line 159
    :goto_7
    if-eqz v6, :cond_6

    .line 160
    .line 161
    iget-object v13, v0, Lg9/w1;->g:Lg8/e;

    .line 162
    .line 163
    invoke-interface {v6}, Lj9/h;->getKey()Lj9/k;

    .line 164
    .line 165
    .line 166
    move-result-object v14

    .line 167
    invoke-virtual {v13, v14}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 168
    .line 169
    .line 170
    move-result v13

    .line 171
    if-eqz v13, :cond_6

    .line 172
    .line 173
    const/4 v13, 0x1

    .line 174
    goto :goto_8

    .line 175
    :cond_6
    const/4 v13, 0x0

    .line 176
    :goto_8
    if-eqz v10, :cond_8

    .line 177
    .line 178
    invoke-interface {v10}, Lj9/h;->d()Z

    .line 179
    .line 180
    .line 181
    move-result v14

    .line 182
    if-nez v14, :cond_7

    .line 183
    .line 184
    iget-object v14, v0, Lg9/w1;->g:Lg8/e;

    .line 185
    .line 186
    invoke-interface {v10}, Lj9/h;->getKey()Lj9/k;

    .line 187
    .line 188
    .line 189
    move-result-object v1

    .line 190
    invoke-virtual {v14, v1}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 191
    .line 192
    .line 193
    move-result v1

    .line 194
    if-eqz v1, :cond_8

    .line 195
    .line 196
    invoke-interface {v10}, Lj9/h;->c()Z

    .line 197
    .line 198
    .line 199
    move-result v1

    .line 200
    if-eqz v1, :cond_8

    .line 201
    .line 202
    :cond_7
    const/4 v1, 0x1

    .line 203
    goto :goto_9

    .line 204
    :cond_8
    const/4 v1, 0x0

    .line 205
    :goto_9
    if-eqz v6, :cond_b

    .line 206
    .line 207
    if-eqz v10, :cond_b

    .line 208
    .line 209
    invoke-interface {v6}, Lj9/h;->getData()Lj9/s;

    .line 210
    .line 211
    .line 212
    move-result-object v14

    .line 213
    move-object/from16 v16, v2

    .line 214
    .line 215
    invoke-interface {v10}, Lj9/h;->getData()Lj9/s;

    .line 216
    .line 217
    .line 218
    move-result-object v2

    .line 219
    invoke-virtual {v14, v2}, Lj9/s;->equals(Ljava/lang/Object;)Z

    .line 220
    .line 221
    .line 222
    move-result v2

    .line 223
    if-nez v2, :cond_a

    .line 224
    .line 225
    invoke-virtual {v0, v6, v10}, Lg9/w1;->m(Lj9/h;Lj9/h;)Z

    .line 226
    .line 227
    .line 228
    move-result v1

    .line 229
    if-nez v1, :cond_f

    .line 230
    .line 231
    sget-object v1, Lg9/m$a;->c:Lg9/m$a;

    .line 232
    .line 233
    invoke-static {v1, v10}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 234
    .line 235
    .line 236
    move-result-object v1

    .line 237
    invoke-virtual {v5, v1}, Lg9/n;->a(Lg9/m;)V

    .line 238
    .line 239
    .line 240
    if-eqz v4, :cond_9

    .line 241
    .line 242
    invoke-interface {v8, v10, v4}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    .line 243
    .line 244
    .line 245
    move-result v1

    .line 246
    if-gtz v1, :cond_e

    .line 247
    .line 248
    :cond_9
    if-eqz v7, :cond_c

    .line 249
    .line 250
    invoke-interface {v8, v10, v7}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    .line 251
    .line 252
    .line 253
    move-result v1

    .line 254
    if-gez v1, :cond_c

    .line 255
    .line 256
    goto :goto_b

    .line 257
    :cond_a
    if-eq v13, v1, :cond_f

    .line 258
    .line 259
    sget-object v1, Lg9/m$a;->d:Lg9/m$a;

    .line 260
    .line 261
    invoke-static {v1, v10}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 262
    .line 263
    .line 264
    move-result-object v1

    .line 265
    invoke-virtual {v5, v1}, Lg9/n;->a(Lg9/m;)V

    .line 266
    .line 267
    .line 268
    goto :goto_a

    .line 269
    :cond_b
    move-object/from16 v16, v2

    .line 270
    .line 271
    if-nez v6, :cond_d

    .line 272
    .line 273
    if-eqz v10, :cond_d

    .line 274
    .line 275
    sget-object v1, Lg9/m$a;->b:Lg9/m$a;

    .line 276
    .line 277
    invoke-static {v1, v10}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 278
    .line 279
    .line 280
    move-result-object v1

    .line 281
    invoke-virtual {v5, v1}, Lg9/n;->a(Lg9/m;)V

    .line 282
    .line 283
    .line 284
    :cond_c
    :goto_a
    const/4 v14, 0x1

    .line 285
    goto :goto_c

    .line 286
    :cond_d
    if-eqz v6, :cond_f

    .line 287
    .line 288
    if-nez v10, :cond_f

    .line 289
    .line 290
    sget-object v1, Lg9/m$a;->a:Lg9/m$a;

    .line 291
    .line 292
    invoke-static {v1, v6}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 293
    .line 294
    .line 295
    move-result-object v1

    .line 296
    invoke-virtual {v5, v1}, Lg9/n;->a(Lg9/m;)V

    .line 297
    .line 298
    .line 299
    if-nez v4, :cond_e

    .line 300
    .line 301
    if-eqz v7, :cond_c

    .line 302
    .line 303
    :cond_e
    :goto_b
    const/4 v12, 0x1

    .line 304
    goto :goto_a

    .line 305
    :cond_f
    const/4 v14, 0x0

    .line 306
    :goto_c
    if-eqz v14, :cond_12

    .line 307
    .line 308
    if-eqz v10, :cond_11

    .line 309
    .line 310
    invoke-virtual {v11, v10}, Lj9/m;->c(Lj9/h;)Lj9/m;

    .line 311
    .line 312
    .line 313
    move-result-object v11

    .line 314
    invoke-interface {v10}, Lj9/h;->d()Z

    .line 315
    .line 316
    .line 317
    move-result v1

    .line 318
    if-eqz v1, :cond_10

    .line 319
    .line 320
    invoke-interface {v10}, Lj9/h;->getKey()Lj9/k;

    .line 321
    .line 322
    .line 323
    move-result-object v1

    .line 324
    invoke-virtual {v3, v1}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 325
    .line 326
    .line 327
    move-result-object v1

    .line 328
    :goto_d
    move-object v3, v1

    .line 329
    goto :goto_e

    .line 330
    :cond_10
    invoke-interface {v10}, Lj9/h;->getKey()Lj9/k;

    .line 331
    .line 332
    .line 333
    move-result-object v1

    .line 334
    invoke-virtual {v3, v1}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 335
    .line 336
    .line 337
    move-result-object v1

    .line 338
    goto :goto_d

    .line 339
    :cond_11
    invoke-virtual {v11, v15}, Lj9/m;->q(Lj9/k;)Lj9/m;

    .line 340
    .line 341
    .line 342
    move-result-object v11

    .line 343
    invoke-virtual {v3, v15}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 344
    .line 345
    .line 346
    move-result-object v1

    .line 347
    goto :goto_d

    .line 348
    :cond_12
    :goto_e
    move-object/from16 v1, p2

    .line 349
    .line 350
    move-object/from16 v2, v16

    .line 351
    .line 352
    goto/16 :goto_6

    .line 353
    .line 354
    :cond_13
    iget-object v1, v0, Lg9/w1;->a:Lg9/b1;

    .line 355
    .line 356
    invoke-virtual {v1}, Lg9/b1;->p()Z

    .line 357
    .line 358
    .line 359
    move-result v1

    .line 360
    if-eqz v1, :cond_15

    .line 361
    .line 362
    invoke-virtual {v11}, Lj9/m;->size()I

    .line 363
    .line 364
    .line 365
    move-result v1

    .line 366
    int-to-long v1, v1

    .line 367
    iget-object v4, v0, Lg9/w1;->a:Lg9/b1;

    .line 368
    .line 369
    invoke-virtual {v4}, Lg9/b1;->k()J

    .line 370
    .line 371
    .line 372
    move-result-wide v6

    .line 373
    :goto_f
    sub-long/2addr v1, v6

    .line 374
    const-wide/16 v6, 0x0

    .line 375
    .line 376
    cmp-long v4, v1, v6

    .line 377
    .line 378
    if-lez v4, :cond_15

    .line 379
    .line 380
    iget-object v4, v0, Lg9/w1;->a:Lg9/b1;

    .line 381
    .line 382
    invoke-virtual {v4}, Lg9/b1;->l()Lg9/b1$a;

    .line 383
    .line 384
    .line 385
    move-result-object v4

    .line 386
    sget-object v6, Lg9/b1$a;->a:Lg9/b1$a;

    .line 387
    .line 388
    invoke-virtual {v4, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 389
    .line 390
    .line 391
    move-result v4

    .line 392
    if-eqz v4, :cond_14

    .line 393
    .line 394
    invoke-virtual {v11}, Lj9/m;->g()Lj9/h;

    .line 395
    .line 396
    .line 397
    move-result-object v4

    .line 398
    goto :goto_10

    .line 399
    :cond_14
    invoke-virtual {v11}, Lj9/m;->f()Lj9/h;

    .line 400
    .line 401
    .line 402
    move-result-object v4

    .line 403
    :goto_10
    invoke-interface {v4}, Lj9/h;->getKey()Lj9/k;

    .line 404
    .line 405
    .line 406
    move-result-object v6

    .line 407
    invoke-virtual {v11, v6}, Lj9/m;->q(Lj9/k;)Lj9/m;

    .line 408
    .line 409
    .line 410
    move-result-object v11

    .line 411
    invoke-interface {v4}, Lj9/h;->getKey()Lj9/k;

    .line 412
    .line 413
    .line 414
    move-result-object v6

    .line 415
    invoke-virtual {v3, v6}, Lg8/e;->g(Ljava/lang/Object;)Lg8/e;

    .line 416
    .line 417
    .line 418
    move-result-object v3

    .line 419
    sget-object v6, Lg9/m$a;->a:Lg9/m$a;

    .line 420
    .line 421
    invoke-static {v6, v4}, Lg9/m;->a(Lg9/m$a;Lj9/h;)Lg9/m;

    .line 422
    .line 423
    .line 424
    move-result-object v4

    .line 425
    invoke-virtual {v5, v4}, Lg9/n;->a(Lg9/m;)V

    .line 426
    .line 427
    .line 428
    const-wide/16 v6, 0x1

    .line 429
    .line 430
    goto :goto_f

    .line 431
    :cond_15
    move-object v6, v3

    .line 432
    move-object v4, v11

    .line 433
    if-eqz v12, :cond_17

    .line 434
    .line 435
    if-nez p2, :cond_16

    .line 436
    .line 437
    goto :goto_11

    .line 438
    :cond_16
    const/4 v14, 0x0

    .line 439
    goto :goto_12

    .line 440
    :cond_17
    :goto_11
    const/4 v14, 0x1

    .line 441
    :goto_12
    const-string v1, "View was refilled using docs that themselves needed refilling."

    .line 442
    .line 443
    const/4 v2, 0x0

    .line 444
    new-array v2, v2, [Ljava/lang/Object;

    .line 445
    .line 446
    invoke-static {v14, v1, v2}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 447
    .line 448
    .line 449
    new-instance v3, Lg9/w1$b;

    .line 450
    .line 451
    const/4 v8, 0x0

    .line 452
    move v7, v12

    .line 453
    invoke-direct/range {v3 .. v8}, Lg9/w1$b;-><init>(Lj9/m;Lg9/n;Lg8/e;ZLg9/w1$a;)V

    .line 454
    .line 455
    .line 456
    return-object v3
    .line 457
    .line 458
    .line 459
    .line 460
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
    .line 762
    .line 763
    .line 764
    .line 765
    .line 766
    .line 767
    .line 768
    .line 769
    .line 770
    .line 771
    .line 772
    .line 773
    .line 774
    .line 775
    .line 776
    .line 777
    .line 778
    .line 779
    .line 780
    .line 781
    .line 782
    .line 783
    .line 784
    .line 785
    .line 786
    .line 787
    .line 788
    .line 789
    .line 790
    .line 791
    .line 792
    .line 793
    .line 794
    .line 795
    .line 796
    .line 797
    .line 798
    .line 799
    .line 800
    .line 801
    .line 802
    .line 803
    .line 804
    .line 805
    .line 806
    .line 807
    .line 808
    .line 809
    .line 810
    .line 811
    .line 812
    .line 813
    .line 814
    .line 815
    .line 816
    .line 817
    .line 818
    .line 819
    .line 820
    .line 821
    .line 822
    .line 823
    .line 824
    .line 825
    .line 826
    .line 827
    .line 828
    .line 829
    .line 830
    .line 831
    .line 832
    .line 833
    .line 834
    .line 835
    .line 836
    .line 837
    .line 838
    .line 839
    .line 840
    .line 841
    .line 842
    .line 843
    .line 844
    .line 845
    .line 846
    .line 847
    .line 848
    .line 849
    .line 850
    .line 851
    .line 852
    .line 853
    .line 854
    .line 855
    .line 856
    .line 857
    .line 858
    .line 859
    .line 860
    .line 861
    .line 862
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    .line 872
    .line 873
    .line 874
    .line 875
    .line 876
    .line 877
    .line 878
    .line 879
    .line 880
    .line 881
    .line 882
    .line 883
    .line 884
    .line 885
    .line 886
    .line 887
    .line 888
    .line 889
    .line 890
    .line 891
    .line 892
    .line 893
    .line 894
    .line 895
    .line 896
    .line 897
    .line 898
    .line 899
    .line 900
    .line 901
    .line 902
    .line 903
    .line 904
    .line 905
    .line 906
    .line 907
    .line 908
    .line 909
    .line 910
    .line 911
    .line 912
    .line 913
    .line 914
    .line 915
    .line 916
    .line 917
    .line 918
    .line 919
    .line 920
    .line 921
    .line 922
    .line 923
    .line 924
    .line 925
    .line 926
    .line 927
    .line 928
    .line 929
    .line 930
    .line 931
    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    .line 938
    .line 939
    .line 940
    .line 941
    .line 942
    .line 943
    .line 944
    .line 945
    .line 946
    .line 947
    .line 948
    .line 949
    .line 950
    .line 951
    .line 952
    .line 953
    .line 954
    .line 955
    .line 956
    .line 957
    .line 958
    .line 959
    .line 960
    .line 961
    .line 962
    .line 963
    .line 964
    .line 965
    .line 966
    .line 967
    .line 968
    .line 969
    .line 970
    .line 971
    .line 972
    .line 973
    .line 974
    .line 975
    .line 976
    .line 977
    .line 978
    .line 979
    .line 980
    .line 981
    .line 982
    .line 983
    .line 984
    .line 985
    .line 986
    .line 987
    .line 988
    .line 989
    .line 990
    .line 991
    .line 992
    .line 993
    .line 994
    .line 995
    .line 996
    .line 997
    .line 998
    .line 999
    .line 1000
    .line 1001
    .line 1002
    .line 1003
    .line 1004
    .line 1005
    .line 1006
    .line 1007
    .line 1008
    .line 1009
    .line 1010
    .line 1011
    .line 1012
    .line 1013
    .line 1014
    .line 1015
    .line 1016
    .line 1017
.end method

.method public j()Lg9/y1$a;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/w1;->b:Lg9/y1$a;

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
.end method

.method public k()Lg8/e;
    .locals 1

    .line 1
    iget-object v0, p0, Lg9/w1;->e:Lg8/e;

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
.end method

.method public final l(Lj9/k;)Z
    .locals 2

    .line 1
    iget-object v0, p0, Lg9/w1;->e:Lg8/e;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/4 v1, 0x0

    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    return v1

    .line 11
    :cond_0
    iget-object v0, p0, Lg9/w1;->d:Lj9/m;

    .line 12
    .line 13
    invoke-virtual {v0, p1}, Lj9/m;->e(Lj9/k;)Lj9/h;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    if-nez p1, :cond_1

    .line 18
    .line 19
    return v1

    .line 20
    :cond_1
    invoke-interface {p1}, Lj9/h;->d()Z

    .line 21
    .line 22
    .line 23
    move-result p1

    .line 24
    if-eqz p1, :cond_2

    .line 25
    .line 26
    return v1

    .line 27
    :cond_2
    const/4 p1, 0x1

    .line 28
    return p1
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
.end method

.method public final m(Lj9/h;Lj9/h;)Z
    .locals 0

    .line 1
    invoke-interface {p1}, Lj9/h;->d()Z

    .line 2
    .line 3
    .line 4
    move-result p1

    .line 5
    if-eqz p1, :cond_0

    .line 6
    .line 7
    invoke-interface {p2}, Lj9/h;->c()Z

    .line 8
    .line 9
    .line 10
    move-result p1

    .line 11
    if-eqz p1, :cond_0

    .line 12
    .line 13
    invoke-interface {p2}, Lj9/h;->d()Z

    .line 14
    .line 15
    .line 16
    move-result p1

    .line 17
    if-nez p1, :cond_0

    .line 18
    .line 19
    const/4 p1, 0x1

    .line 20
    return p1

    .line 21
    :cond_0
    const/4 p1, 0x0

    .line 22
    return p1
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

.method public final n()Ljava/util/List;
    .locals 6

    .line 1
    iget-boolean v0, p0, Lg9/w1;->c:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    sget-object v0, Ljava/util/Collections;->EMPTY_LIST:Ljava/util/List;

    .line 6
    .line 7
    return-object v0

    .line 8
    :cond_0
    iget-object v0, p0, Lg9/w1;->f:Lg8/e;

    .line 9
    .line 10
    invoke-static {}, Lj9/k;->h()Lg8/e;

    .line 11
    .line 12
    .line 13
    move-result-object v1

    .line 14
    iput-object v1, p0, Lg9/w1;->f:Lg8/e;

    .line 15
    .line 16
    iget-object v1, p0, Lg9/w1;->d:Lj9/m;

    .line 17
    .line 18
    invoke-virtual {v1}, Lj9/m;->iterator()Ljava/util/Iterator;

    .line 19
    .line 20
    .line 21
    move-result-object v1

    .line 22
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    .line 23
    .line 24
    .line 25
    move-result v2

    .line 26
    if-eqz v2, :cond_2

    .line 27
    .line 28
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 29
    .line 30
    .line 31
    move-result-object v2

    .line 32
    check-cast v2, Lj9/h;

    .line 33
    .line 34
    invoke-interface {v2}, Lj9/h;->getKey()Lj9/k;

    .line 35
    .line 36
    .line 37
    move-result-object v3

    .line 38
    invoke-virtual {p0, v3}, Lg9/w1;->l(Lj9/k;)Z

    .line 39
    .line 40
    .line 41
    move-result v3

    .line 42
    if-eqz v3, :cond_1

    .line 43
    .line 44
    iget-object v3, p0, Lg9/w1;->f:Lg8/e;

    .line 45
    .line 46
    invoke-interface {v2}, Lj9/h;->getKey()Lj9/k;

    .line 47
    .line 48
    .line 49
    move-result-object v2

    .line 50
    invoke-virtual {v3, v2}, Lg8/e;->e(Ljava/lang/Object;)Lg8/e;

    .line 51
    .line 52
    .line 53
    move-result-object v2

    .line 54
    iput-object v2, p0, Lg9/w1;->f:Lg8/e;

    .line 55
    .line 56
    goto :goto_0

    .line 57
    :cond_2
    new-instance v1, Ljava/util/ArrayList;

    .line 58
    .line 59
    invoke-virtual {v0}, Lg8/e;->size()I

    .line 60
    .line 61
    .line 62
    move-result v2

    .line 63
    iget-object v3, p0, Lg9/w1;->f:Lg8/e;

    .line 64
    .line 65
    invoke-virtual {v3}, Lg8/e;->size()I

    .line 66
    .line 67
    .line 68
    move-result v3

    .line 69
    add-int/2addr v2, v3

    .line 70
    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 71
    .line 72
    .line 73
    invoke-virtual {v0}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 74
    .line 75
    .line 76
    move-result-object v2

    .line 77
    :cond_3
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 78
    .line 79
    .line 80
    move-result v3

    .line 81
    if-eqz v3, :cond_4

    .line 82
    .line 83
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 84
    .line 85
    .line 86
    move-result-object v3

    .line 87
    check-cast v3, Lj9/k;

    .line 88
    .line 89
    iget-object v4, p0, Lg9/w1;->f:Lg8/e;

    .line 90
    .line 91
    invoke-virtual {v4, v3}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 92
    .line 93
    .line 94
    move-result v4

    .line 95
    if-nez v4, :cond_3

    .line 96
    .line 97
    new-instance v4, Lg9/v0;

    .line 98
    .line 99
    sget-object v5, Lg9/v0$a;->b:Lg9/v0$a;

    .line 100
    .line 101
    invoke-direct {v4, v5, v3}, Lg9/v0;-><init>(Lg9/v0$a;Lj9/k;)V

    .line 102
    .line 103
    .line 104
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 105
    .line 106
    .line 107
    goto :goto_1

    .line 108
    :cond_4
    iget-object v2, p0, Lg9/w1;->f:Lg8/e;

    .line 109
    .line 110
    invoke-virtual {v2}, Lg8/e;->iterator()Ljava/util/Iterator;

    .line 111
    .line 112
    .line 113
    move-result-object v2

    .line 114
    :cond_5
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    .line 115
    .line 116
    .line 117
    move-result v3

    .line 118
    if-eqz v3, :cond_6

    .line 119
    .line 120
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 121
    .line 122
    .line 123
    move-result-object v3

    .line 124
    check-cast v3, Lj9/k;

    .line 125
    .line 126
    invoke-virtual {v0, v3}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 127
    .line 128
    .line 129
    move-result v4

    .line 130
    if-nez v4, :cond_5

    .line 131
    .line 132
    new-instance v4, Lg9/v0;

    .line 133
    .line 134
    sget-object v5, Lg9/v0$a;->a:Lg9/v0$a;

    .line 135
    .line 136
    invoke-direct {v4, v5, v3}, Lg9/v0;-><init>(Lg9/v0$a;Lj9/k;)V

    .line 137
    .line 138
    .line 139
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    .line 141
    .line 142
    goto :goto_2

    .line 143
    :cond_6
    return-object v1
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
.end method
