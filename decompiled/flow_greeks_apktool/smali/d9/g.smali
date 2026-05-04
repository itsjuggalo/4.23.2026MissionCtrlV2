.class public Ld9/g;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ld9/g$b;
    }
.end annotation


# instance fields
.field public final a:Ld9/g$b;

.field public final b:Lcom/google/firebase/firestore/j;

.field public final c:I

.field public final d:I


# direct methods
.method public constructor <init>(Lcom/google/firebase/firestore/j;Ld9/g$b;II)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p2, p0, Ld9/g;->a:Ld9/g$b;

    .line 5
    .line 6
    iput-object p1, p0, Ld9/g;->b:Lcom/google/firebase/firestore/j;

    .line 7
    .line 8
    iput p3, p0, Ld9/g;->c:I

    .line 9
    .line 10
    iput p4, p0, Ld9/g;->d:I

    .line 11
    .line 12
    return-void
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
.end method

.method public static a(Lcom/google/firebase/firestore/FirebaseFirestore;Ld9/b1;Lg9/y1;)Ljava/util/List;
    .locals 13

    .line 1
    new-instance v0, Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p2}, Lg9/y1;->g()Lj9/m;

    .line 7
    .line 8
    .line 9
    move-result-object v1

    .line 10
    invoke-virtual {v1}, Lj9/m;->isEmpty()Z

    .line 11
    .line 12
    .line 13
    move-result v1

    .line 14
    const/4 v2, -0x1

    .line 15
    const/4 v3, 0x1

    .line 16
    const/4 v4, 0x0

    .line 17
    if-eqz v1, :cond_3

    .line 18
    .line 19
    invoke-virtual {p2}, Lg9/y1;->d()Ljava/util/List;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    const/4 v1, 0x0

    .line 28
    move v5, v4

    .line 29
    :goto_0
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 30
    .line 31
    .line 32
    move-result v6

    .line 33
    if-eqz v6, :cond_9

    .line 34
    .line 35
    invoke-interface {p1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 36
    .line 37
    .line 38
    move-result-object v6

    .line 39
    check-cast v6, Lg9/m;

    .line 40
    .line 41
    invoke-virtual {v6}, Lg9/m;->b()Lj9/h;

    .line 42
    .line 43
    .line 44
    move-result-object v7

    .line 45
    invoke-virtual {p2}, Lg9/y1;->k()Z

    .line 46
    .line 47
    .line 48
    move-result v8

    .line 49
    invoke-virtual {p2}, Lg9/y1;->f()Lg8/e;

    .line 50
    .line 51
    .line 52
    move-result-object v9

    .line 53
    invoke-interface {v7}, Lj9/h;->getKey()Lj9/k;

    .line 54
    .line 55
    .line 56
    move-result-object v10

    .line 57
    invoke-virtual {v9, v10}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 58
    .line 59
    .line 60
    move-result v9

    .line 61
    invoke-static {p0, v7, v8, v9}, Lcom/google/firebase/firestore/j;->h(Lcom/google/firebase/firestore/FirebaseFirestore;Lj9/h;ZZ)Lcom/google/firebase/firestore/j;

    .line 62
    .line 63
    .line 64
    move-result-object v8

    .line 65
    invoke-virtual {v6}, Lg9/m;->c()Lg9/m$a;

    .line 66
    .line 67
    .line 68
    move-result-object v6

    .line 69
    sget-object v9, Lg9/m$a;->b:Lg9/m$a;

    .line 70
    .line 71
    if-ne v6, v9, :cond_0

    .line 72
    .line 73
    move v6, v3

    .line 74
    goto :goto_1

    .line 75
    :cond_0
    move v6, v4

    .line 76
    :goto_1
    const-string v9, "Invalid added event for first snapshot"

    .line 77
    .line 78
    new-array v10, v4, [Ljava/lang/Object;

    .line 79
    .line 80
    invoke-static {v6, v9, v10}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 81
    .line 82
    .line 83
    if-eqz v1, :cond_2

    .line 84
    .line 85
    invoke-virtual {p2}, Lg9/y1;->h()Lg9/b1;

    .line 86
    .line 87
    .line 88
    move-result-object v6

    .line 89
    invoke-virtual {v6}, Lg9/b1;->c()Ljava/util/Comparator;

    .line 90
    .line 91
    .line 92
    move-result-object v6

    .line 93
    invoke-interface {v6, v1, v7}, Ljava/util/Comparator;->compare(Ljava/lang/Object;Ljava/lang/Object;)I

    .line 94
    .line 95
    .line 96
    move-result v1

    .line 97
    if-gez v1, :cond_1

    .line 98
    .line 99
    goto :goto_2

    .line 100
    :cond_1
    move v1, v4

    .line 101
    goto :goto_3

    .line 102
    :cond_2
    :goto_2
    move v1, v3

    .line 103
    :goto_3
    const-string v6, "Got added events in wrong order"

    .line 104
    .line 105
    new-array v9, v4, [Ljava/lang/Object;

    .line 106
    .line 107
    invoke-static {v1, v6, v9}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 108
    .line 109
    .line 110
    new-instance v1, Ld9/g;

    .line 111
    .line 112
    sget-object v6, Ld9/g$b;->a:Ld9/g$b;

    .line 113
    .line 114
    add-int/lit8 v9, v5, 0x1

    .line 115
    .line 116
    invoke-direct {v1, v8, v6, v2, v5}, Ld9/g;-><init>(Lcom/google/firebase/firestore/j;Ld9/g$b;II)V

    .line 117
    .line 118
    .line 119
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 120
    .line 121
    .line 122
    move-object v1, v7

    .line 123
    move v5, v9

    .line 124
    goto :goto_0

    .line 125
    :cond_3
    invoke-virtual {p2}, Lg9/y1;->g()Lj9/m;

    .line 126
    .line 127
    .line 128
    move-result-object v1

    .line 129
    invoke-virtual {p2}, Lg9/y1;->d()Ljava/util/List;

    .line 130
    .line 131
    .line 132
    move-result-object v5

    .line 133
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 134
    .line 135
    .line 136
    move-result-object v5

    .line 137
    :goto_4
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    .line 138
    .line 139
    .line 140
    move-result v6

    .line 141
    if-eqz v6, :cond_9

    .line 142
    .line 143
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 144
    .line 145
    .line 146
    move-result-object v6

    .line 147
    check-cast v6, Lg9/m;

    .line 148
    .line 149
    sget-object v7, Ld9/b1;->a:Ld9/b1;

    .line 150
    .line 151
    if-ne p1, v7, :cond_4

    .line 152
    .line 153
    invoke-virtual {v6}, Lg9/m;->c()Lg9/m$a;

    .line 154
    .line 155
    .line 156
    move-result-object v7

    .line 157
    sget-object v8, Lg9/m$a;->d:Lg9/m$a;

    .line 158
    .line 159
    if-ne v7, v8, :cond_4

    .line 160
    .line 161
    goto :goto_4

    .line 162
    :cond_4
    invoke-virtual {v6}, Lg9/m;->b()Lj9/h;

    .line 163
    .line 164
    .line 165
    move-result-object v7

    .line 166
    invoke-virtual {p2}, Lg9/y1;->k()Z

    .line 167
    .line 168
    .line 169
    move-result v8

    .line 170
    invoke-virtual {p2}, Lg9/y1;->f()Lg8/e;

    .line 171
    .line 172
    .line 173
    move-result-object v9

    .line 174
    invoke-interface {v7}, Lj9/h;->getKey()Lj9/k;

    .line 175
    .line 176
    .line 177
    move-result-object v10

    .line 178
    invoke-virtual {v9, v10}, Lg8/e;->contains(Ljava/lang/Object;)Z

    .line 179
    .line 180
    .line 181
    move-result v9

    .line 182
    invoke-static {p0, v7, v8, v9}, Lcom/google/firebase/firestore/j;->h(Lcom/google/firebase/firestore/FirebaseFirestore;Lj9/h;ZZ)Lcom/google/firebase/firestore/j;

    .line 183
    .line 184
    .line 185
    move-result-object v8

    .line 186
    invoke-static {v6}, Ld9/g;->f(Lg9/m;)Ld9/g$b;

    .line 187
    .line 188
    .line 189
    move-result-object v6

    .line 190
    sget-object v9, Ld9/g$b;->a:Ld9/g$b;

    .line 191
    .line 192
    const-string v10, "Index for document not found"

    .line 193
    .line 194
    if-eq v6, v9, :cond_6

    .line 195
    .line 196
    invoke-interface {v7}, Lj9/h;->getKey()Lj9/k;

    .line 197
    .line 198
    .line 199
    move-result-object v9

    .line 200
    invoke-virtual {v1, v9}, Lj9/m;->p(Lj9/k;)I

    .line 201
    .line 202
    .line 203
    move-result v9

    .line 204
    if-ltz v9, :cond_5

    .line 205
    .line 206
    move v11, v3

    .line 207
    goto :goto_5

    .line 208
    :cond_5
    move v11, v4

    .line 209
    :goto_5
    new-array v12, v4, [Ljava/lang/Object;

    .line 210
    .line 211
    invoke-static {v11, v10, v12}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 212
    .line 213
    .line 214
    invoke-interface {v7}, Lj9/h;->getKey()Lj9/k;

    .line 215
    .line 216
    .line 217
    move-result-object v11

    .line 218
    invoke-virtual {v1, v11}, Lj9/m;->q(Lj9/k;)Lj9/m;

    .line 219
    .line 220
    .line 221
    move-result-object v1

    .line 222
    goto :goto_6

    .line 223
    :cond_6
    move v9, v2

    .line 224
    :goto_6
    sget-object v11, Ld9/g$b;->c:Ld9/g$b;

    .line 225
    .line 226
    if-eq v6, v11, :cond_8

    .line 227
    .line 228
    invoke-virtual {v1, v7}, Lj9/m;->c(Lj9/h;)Lj9/m;

    .line 229
    .line 230
    .line 231
    move-result-object v1

    .line 232
    invoke-interface {v7}, Lj9/h;->getKey()Lj9/k;

    .line 233
    .line 234
    .line 235
    move-result-object v7

    .line 236
    invoke-virtual {v1, v7}, Lj9/m;->p(Lj9/k;)I

    .line 237
    .line 238
    .line 239
    move-result v7

    .line 240
    if-ltz v7, :cond_7

    .line 241
    .line 242
    move v11, v3

    .line 243
    goto :goto_7

    .line 244
    :cond_7
    move v11, v4

    .line 245
    :goto_7
    new-array v12, v4, [Ljava/lang/Object;

    .line 246
    .line 247
    invoke-static {v11, v10, v12}, Ln9/b;->d(ZLjava/lang/String;[Ljava/lang/Object;)V

    .line 248
    .line 249
    .line 250
    goto :goto_8

    .line 251
    :cond_8
    move v7, v2

    .line 252
    :goto_8
    new-instance v10, Ld9/g;

    .line 253
    .line 254
    invoke-direct {v10, v8, v6, v9, v7}, Ld9/g;-><init>(Lcom/google/firebase/firestore/j;Ld9/g$b;II)V

    .line 255
    .line 256
    .line 257
    invoke-interface {v0, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 258
    .line 259
    .line 260
    goto :goto_4

    .line 261
    :cond_9
    return-object v0
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

.method public static f(Lg9/m;)Ld9/g$b;
    .locals 3

    .line 1
    sget-object v0, Ld9/g$a;->a:[I

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
    if-eq v0, v1, :cond_2

    .line 15
    .line 16
    const/4 v1, 0x2

    .line 17
    if-eq v0, v1, :cond_1

    .line 18
    .line 19
    const/4 v1, 0x3

    .line 20
    if-eq v0, v1, :cond_1

    .line 21
    .line 22
    const/4 v1, 0x4

    .line 23
    if-ne v0, v1, :cond_0

    .line 24
    .line 25
    sget-object p0, Ld9/g$b;->c:Ld9/g$b;

    .line 26
    .line 27
    return-object p0

    .line 28
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    .line 29
    .line 30
    new-instance v1, Ljava/lang/StringBuilder;

    .line 31
    .line 32
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 33
    .line 34
    .line 35
    const-string v2, "Unknown view change type: "

    .line 36
    .line 37
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 38
    .line 39
    .line 40
    invoke-virtual {p0}, Lg9/m;->c()Lg9/m$a;

    .line 41
    .line 42
    .line 43
    move-result-object p0

    .line 44
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 45
    .line 46
    .line 47
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 48
    .line 49
    .line 50
    move-result-object p0

    .line 51
    invoke-direct {v0, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 52
    .line 53
    .line 54
    throw v0

    .line 55
    :cond_1
    sget-object p0, Ld9/g$b;->b:Ld9/g$b;

    .line 56
    .line 57
    return-object p0

    .line 58
    :cond_2
    sget-object p0, Ld9/g$b;->a:Ld9/g$b;

    .line 59
    .line 60
    return-object p0
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
.method public b()Lcom/google/firebase/firestore/j;
    .locals 1

    .line 1
    iget-object v0, p0, Ld9/g;->b:Lcom/google/firebase/firestore/j;

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

.method public c()I
    .locals 1

    .line 1
    iget v0, p0, Ld9/g;->d:I

    .line 2
    .line 3
    return v0
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

.method public d()I
    .locals 1

    .line 1
    iget v0, p0, Ld9/g;->c:I

    .line 2
    .line 3
    return v0
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

.method public e()Ld9/g$b;
    .locals 1

    .line 1
    iget-object v0, p0, Ld9/g;->a:Ld9/g$b;

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

.method public equals(Ljava/lang/Object;)Z
    .locals 3

    .line 1
    instance-of v0, p1, Ld9/g;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_0

    .line 5
    .line 6
    check-cast p1, Ld9/g;

    .line 7
    .line 8
    iget-object v0, p0, Ld9/g;->a:Ld9/g$b;

    .line 9
    .line 10
    iget-object v2, p1, Ld9/g;->a:Ld9/g$b;

    .line 11
    .line 12
    invoke-virtual {v0, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    .line 13
    .line 14
    .line 15
    move-result v0

    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    iget-object v0, p0, Ld9/g;->b:Lcom/google/firebase/firestore/j;

    .line 19
    .line 20
    iget-object v2, p1, Ld9/g;->b:Lcom/google/firebase/firestore/j;

    .line 21
    .line 22
    invoke-virtual {v0, v2}, Lcom/google/firebase/firestore/d;->equals(Ljava/lang/Object;)Z

    .line 23
    .line 24
    .line 25
    move-result v0

    .line 26
    if-eqz v0, :cond_0

    .line 27
    .line 28
    iget v0, p0, Ld9/g;->c:I

    .line 29
    .line 30
    iget v2, p1, Ld9/g;->c:I

    .line 31
    .line 32
    if-ne v0, v2, :cond_0

    .line 33
    .line 34
    iget v0, p0, Ld9/g;->d:I

    .line 35
    .line 36
    iget p1, p1, Ld9/g;->d:I

    .line 37
    .line 38
    if-ne v0, p1, :cond_0

    .line 39
    .line 40
    const/4 p1, 0x1

    .line 41
    return p1

    .line 42
    :cond_0
    return v1
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

.method public hashCode()I
    .locals 2

    .line 1
    iget-object v0, p0, Ld9/g;->a:Ld9/g$b;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    mul-int/lit8 v0, v0, 0x1f

    .line 8
    .line 9
    iget-object v1, p0, Ld9/g;->b:Lcom/google/firebase/firestore/j;

    .line 10
    .line 11
    invoke-virtual {v1}, Lcom/google/firebase/firestore/d;->hashCode()I

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    add-int/2addr v0, v1

    .line 16
    mul-int/lit8 v0, v0, 0x1f

    .line 17
    .line 18
    iget v1, p0, Ld9/g;->c:I

    .line 19
    .line 20
    add-int/2addr v0, v1

    .line 21
    mul-int/lit8 v0, v0, 0x1f

    .line 22
    .line 23
    iget v1, p0, Ld9/g;->d:I

    .line 24
    .line 25
    add-int/2addr v0, v1

    .line 26
    return v0
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
.end method
