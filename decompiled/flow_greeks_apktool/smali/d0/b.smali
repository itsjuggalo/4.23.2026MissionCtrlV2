.class public Ld0/b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ld0/b$a;,
        Ld0/b$b;
    }
.end annotation


# instance fields
.field public final a:Ljava/util/ArrayList;

.field public b:Ld0/b$a;

.field public c:Lc0/f;


# direct methods
.method public constructor <init>(Lc0/f;)V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Ljava/util/ArrayList;

    .line 5
    .line 6
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 7
    .line 8
    .line 9
    iput-object v0, p0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 10
    .line 11
    new-instance v0, Ld0/b$a;

    .line 12
    .line 13
    invoke-direct {v0}, Ld0/b$a;-><init>()V

    .line 14
    .line 15
    .line 16
    iput-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 17
    .line 18
    iput-object p1, p0, Ld0/b;->c:Lc0/f;

    .line 19
    .line 20
    return-void
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public final a(Ld0/b$b;Lc0/e;I)Z
    .locals 5

    .line 1
    iget-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 2
    .line 3
    invoke-virtual {p2}, Lc0/e;->y()Lc0/e$b;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    iput-object v1, v0, Ld0/b$a;->a:Lc0/e$b;

    .line 8
    .line 9
    iget-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 10
    .line 11
    invoke-virtual {p2}, Lc0/e;->R()Lc0/e$b;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    iput-object v1, v0, Ld0/b$a;->b:Lc0/e$b;

    .line 16
    .line 17
    iget-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 18
    .line 19
    invoke-virtual {p2}, Lc0/e;->U()I

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    iput v1, v0, Ld0/b$a;->c:I

    .line 24
    .line 25
    iget-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 26
    .line 27
    invoke-virtual {p2}, Lc0/e;->v()I

    .line 28
    .line 29
    .line 30
    move-result v1

    .line 31
    iput v1, v0, Ld0/b$a;->d:I

    .line 32
    .line 33
    iget-object v0, p0, Ld0/b;->b:Ld0/b$a;

    .line 34
    .line 35
    const/4 v1, 0x0

    .line 36
    iput-boolean v1, v0, Ld0/b$a;->i:Z

    .line 37
    .line 38
    iput p3, v0, Ld0/b$a;->j:I

    .line 39
    .line 40
    iget-object p3, v0, Ld0/b$a;->a:Lc0/e$b;

    .line 41
    .line 42
    sget-object v2, Lc0/e$b;->c:Lc0/e$b;

    .line 43
    .line 44
    const/4 v3, 0x1

    .line 45
    if-ne p3, v2, :cond_0

    .line 46
    .line 47
    move p3, v3

    .line 48
    goto :goto_0

    .line 49
    :cond_0
    move p3, v1

    .line 50
    :goto_0
    iget-object v4, v0, Ld0/b$a;->b:Lc0/e$b;

    .line 51
    .line 52
    if-ne v4, v2, :cond_1

    .line 53
    .line 54
    move v2, v3

    .line 55
    goto :goto_1

    .line 56
    :cond_1
    move v2, v1

    .line 57
    :goto_1
    const/4 v4, 0x0

    .line 58
    if-eqz p3, :cond_2

    .line 59
    .line 60
    iget p3, p2, Lc0/e;->d0:F

    .line 61
    .line 62
    cmpl-float p3, p3, v4

    .line 63
    .line 64
    if-lez p3, :cond_2

    .line 65
    .line 66
    move p3, v3

    .line 67
    goto :goto_2

    .line 68
    :cond_2
    move p3, v1

    .line 69
    :goto_2
    if-eqz v2, :cond_3

    .line 70
    .line 71
    iget v2, p2, Lc0/e;->d0:F

    .line 72
    .line 73
    cmpl-float v2, v2, v4

    .line 74
    .line 75
    if-lez v2, :cond_3

    .line 76
    .line 77
    move v2, v3

    .line 78
    goto :goto_3

    .line 79
    :cond_3
    move v2, v1

    .line 80
    :goto_3
    const/4 v4, 0x4

    .line 81
    if-eqz p3, :cond_4

    .line 82
    .line 83
    iget-object p3, p2, Lc0/e;->y:[I

    .line 84
    .line 85
    aget p3, p3, v1

    .line 86
    .line 87
    if-ne p3, v4, :cond_4

    .line 88
    .line 89
    sget-object p3, Lc0/e$b;->a:Lc0/e$b;

    .line 90
    .line 91
    iput-object p3, v0, Ld0/b$a;->a:Lc0/e$b;

    .line 92
    .line 93
    :cond_4
    if-eqz v2, :cond_5

    .line 94
    .line 95
    iget-object p3, p2, Lc0/e;->y:[I

    .line 96
    .line 97
    aget p3, p3, v3

    .line 98
    .line 99
    if-ne p3, v4, :cond_5

    .line 100
    .line 101
    sget-object p3, Lc0/e$b;->a:Lc0/e$b;

    .line 102
    .line 103
    iput-object p3, v0, Ld0/b$a;->b:Lc0/e$b;

    .line 104
    .line 105
    :cond_5
    invoke-interface {p1, p2, v0}, Ld0/b$b;->b(Lc0/e;Ld0/b$a;)V

    .line 106
    .line 107
    .line 108
    iget-object p1, p0, Ld0/b;->b:Ld0/b$a;

    .line 109
    .line 110
    iget p1, p1, Ld0/b$a;->e:I

    .line 111
    .line 112
    invoke-virtual {p2, p1}, Lc0/e;->g1(I)V

    .line 113
    .line 114
    .line 115
    iget-object p1, p0, Ld0/b;->b:Ld0/b$a;

    .line 116
    .line 117
    iget p1, p1, Ld0/b$a;->f:I

    .line 118
    .line 119
    invoke-virtual {p2, p1}, Lc0/e;->I0(I)V

    .line 120
    .line 121
    .line 122
    iget-object p1, p0, Ld0/b;->b:Ld0/b$a;

    .line 123
    .line 124
    iget-boolean p1, p1, Ld0/b$a;->h:Z

    .line 125
    .line 126
    invoke-virtual {p2, p1}, Lc0/e;->H0(Z)V

    .line 127
    .line 128
    .line 129
    iget-object p1, p0, Ld0/b;->b:Ld0/b$a;

    .line 130
    .line 131
    iget p1, p1, Ld0/b$a;->g:I

    .line 132
    .line 133
    invoke-virtual {p2, p1}, Lc0/e;->x0(I)V

    .line 134
    .line 135
    .line 136
    iget-object p1, p0, Ld0/b;->b:Ld0/b$a;

    .line 137
    .line 138
    sget p2, Ld0/b$a;->k:I

    .line 139
    .line 140
    iput p2, p1, Ld0/b$a;->j:I

    .line 141
    .line 142
    iget-boolean p1, p1, Ld0/b$a;->i:Z

    .line 143
    .line 144
    return p1
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

.method public final b(Lc0/f;)V
    .locals 12

    .line 1
    iget-object v0, p1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    const/16 v1, 0x40

    .line 8
    .line 9
    invoke-virtual {p1, v1}, Lc0/f;->O1(I)Z

    .line 10
    .line 11
    .line 12
    move-result v1

    .line 13
    invoke-virtual {p1}, Lc0/f;->E1()Ld0/b$b;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    const/4 v3, 0x0

    .line 18
    move v4, v3

    .line 19
    :goto_0
    if-ge v4, v0, :cond_a

    .line 20
    .line 21
    iget-object v5, p1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 22
    .line 23
    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 24
    .line 25
    .line 26
    move-result-object v5

    .line 27
    check-cast v5, Lc0/e;

    .line 28
    .line 29
    instance-of v6, v5, Lc0/g;

    .line 30
    .line 31
    if-eqz v6, :cond_0

    .line 32
    .line 33
    goto/16 :goto_3

    .line 34
    .line 35
    :cond_0
    instance-of v6, v5, Lc0/a;

    .line 36
    .line 37
    if-eqz v6, :cond_1

    .line 38
    .line 39
    goto/16 :goto_3

    .line 40
    .line 41
    :cond_1
    invoke-virtual {v5}, Lc0/e;->j0()Z

    .line 42
    .line 43
    .line 44
    move-result v6

    .line 45
    if-eqz v6, :cond_2

    .line 46
    .line 47
    goto/16 :goto_3

    .line 48
    .line 49
    :cond_2
    if-eqz v1, :cond_3

    .line 50
    .line 51
    iget-object v6, v5, Lc0/e;->e:Ld0/l;

    .line 52
    .line 53
    if-eqz v6, :cond_3

    .line 54
    .line 55
    iget-object v7, v5, Lc0/e;->f:Ld0/n;

    .line 56
    .line 57
    if-eqz v7, :cond_3

    .line 58
    .line 59
    iget-object v6, v6, Ld0/p;->e:Ld0/g;

    .line 60
    .line 61
    iget-boolean v6, v6, Ld0/f;->j:Z

    .line 62
    .line 63
    if-eqz v6, :cond_3

    .line 64
    .line 65
    iget-object v6, v7, Ld0/p;->e:Ld0/g;

    .line 66
    .line 67
    iget-boolean v6, v6, Ld0/f;->j:Z

    .line 68
    .line 69
    if-eqz v6, :cond_3

    .line 70
    .line 71
    goto :goto_3

    .line 72
    :cond_3
    invoke-virtual {v5, v3}, Lc0/e;->s(I)Lc0/e$b;

    .line 73
    .line 74
    .line 75
    move-result-object v6

    .line 76
    const/4 v7, 0x1

    .line 77
    invoke-virtual {v5, v7}, Lc0/e;->s(I)Lc0/e$b;

    .line 78
    .line 79
    .line 80
    move-result-object v8

    .line 81
    sget-object v9, Lc0/e$b;->c:Lc0/e$b;

    .line 82
    .line 83
    if-ne v6, v9, :cond_4

    .line 84
    .line 85
    iget v10, v5, Lc0/e;->w:I

    .line 86
    .line 87
    if-eq v10, v7, :cond_4

    .line 88
    .line 89
    if-ne v8, v9, :cond_4

    .line 90
    .line 91
    iget v10, v5, Lc0/e;->x:I

    .line 92
    .line 93
    if-eq v10, v7, :cond_4

    .line 94
    .line 95
    move v10, v7

    .line 96
    goto :goto_1

    .line 97
    :cond_4
    move v10, v3

    .line 98
    :goto_1
    if-nez v10, :cond_8

    .line 99
    .line 100
    invoke-virtual {p1, v7}, Lc0/f;->O1(I)Z

    .line 101
    .line 102
    .line 103
    move-result v11

    .line 104
    if-eqz v11, :cond_8

    .line 105
    .line 106
    if-ne v6, v9, :cond_5

    .line 107
    .line 108
    iget v11, v5, Lc0/e;->w:I

    .line 109
    .line 110
    if-nez v11, :cond_5

    .line 111
    .line 112
    if-eq v8, v9, :cond_5

    .line 113
    .line 114
    invoke-virtual {v5}, Lc0/e;->g0()Z

    .line 115
    .line 116
    .line 117
    move-result v11

    .line 118
    if-nez v11, :cond_5

    .line 119
    .line 120
    move v10, v7

    .line 121
    :cond_5
    if-ne v8, v9, :cond_6

    .line 122
    .line 123
    iget v11, v5, Lc0/e;->x:I

    .line 124
    .line 125
    if-nez v11, :cond_6

    .line 126
    .line 127
    if-eq v6, v9, :cond_6

    .line 128
    .line 129
    invoke-virtual {v5}, Lc0/e;->g0()Z

    .line 130
    .line 131
    .line 132
    move-result v11

    .line 133
    if-nez v11, :cond_6

    .line 134
    .line 135
    move v10, v7

    .line 136
    :cond_6
    if-eq v6, v9, :cond_7

    .line 137
    .line 138
    if-ne v8, v9, :cond_8

    .line 139
    .line 140
    :cond_7
    iget v6, v5, Lc0/e;->d0:F

    .line 141
    .line 142
    const/4 v8, 0x0

    .line 143
    cmpl-float v6, v6, v8

    .line 144
    .line 145
    if-lez v6, :cond_8

    .line 146
    .line 147
    goto :goto_2

    .line 148
    :cond_8
    move v7, v10

    .line 149
    :goto_2
    if-eqz v7, :cond_9

    .line 150
    .line 151
    goto :goto_3

    .line 152
    :cond_9
    sget v6, Ld0/b$a;->k:I

    .line 153
    .line 154
    invoke-virtual {p0, v2, v5, v6}, Ld0/b;->a(Ld0/b$b;Lc0/e;I)Z

    .line 155
    .line 156
    .line 157
    :goto_3
    add-int/lit8 v4, v4, 0x1

    .line 158
    .line 159
    goto/16 :goto_0

    .line 160
    .line 161
    :cond_a
    invoke-interface {v2}, Ld0/b$b;->a()V

    .line 162
    .line 163
    .line 164
    return-void
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

.method public final c(Lc0/f;Ljava/lang/String;III)V
    .locals 2

    .line 1
    invoke-virtual {p1}, Lc0/e;->G()I

    .line 2
    .line 3
    .line 4
    move-result p2

    .line 5
    invoke-virtual {p1}, Lc0/e;->F()I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    const/4 v1, 0x0

    .line 10
    invoke-virtual {p1, v1}, Lc0/e;->W0(I)V

    .line 11
    .line 12
    .line 13
    invoke-virtual {p1, v1}, Lc0/e;->V0(I)V

    .line 14
    .line 15
    .line 16
    invoke-virtual {p1, p4}, Lc0/e;->g1(I)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {p1, p5}, Lc0/e;->I0(I)V

    .line 20
    .line 21
    .line 22
    invoke-virtual {p1, p2}, Lc0/e;->W0(I)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {p1, v0}, Lc0/e;->V0(I)V

    .line 26
    .line 27
    .line 28
    iget-object p1, p0, Ld0/b;->c:Lc0/f;

    .line 29
    .line 30
    invoke-virtual {p1, p3}, Lc0/f;->S1(I)V

    .line 31
    .line 32
    .line 33
    iget-object p1, p0, Ld0/b;->c:Lc0/f;

    .line 34
    .line 35
    invoke-virtual {p1}, Lc0/f;->o1()V

    .line 36
    .line 37
    .line 38
    return-void
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
.end method

.method public d(Lc0/f;IIIIIIIII)J
    .locals 20

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    move/from16 v2, p2

    .line 6
    .line 7
    move/from16 v3, p5

    .line 8
    .line 9
    move/from16 v4, p7

    .line 10
    .line 11
    invoke-virtual {v1}, Lc0/f;->E1()Ld0/b$b;

    .line 12
    .line 13
    .line 14
    move-result-object v5

    .line 15
    iget-object v6, v1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    .line 18
    .line 19
    .line 20
    move-result v6

    .line 21
    invoke-virtual {v1}, Lc0/e;->U()I

    .line 22
    .line 23
    .line 24
    move-result v7

    .line 25
    invoke-virtual {v1}, Lc0/e;->v()I

    .line 26
    .line 27
    .line 28
    move-result v8

    .line 29
    const/16 v9, 0x80

    .line 30
    .line 31
    invoke-static {v2, v9}, Lc0/j;->b(II)Z

    .line 32
    .line 33
    .line 34
    move-result v9

    .line 35
    const/4 v11, 0x0

    .line 36
    if-nez v9, :cond_1

    .line 37
    .line 38
    const/16 v12, 0x40

    .line 39
    .line 40
    invoke-static {v2, v12}, Lc0/j;->b(II)Z

    .line 41
    .line 42
    .line 43
    move-result v2

    .line 44
    if-eqz v2, :cond_0

    .line 45
    .line 46
    goto :goto_0

    .line 47
    :cond_0
    move v2, v11

    .line 48
    goto :goto_1

    .line 49
    :cond_1
    :goto_0
    const/4 v2, 0x1

    .line 50
    :goto_1
    if-eqz v2, :cond_9

    .line 51
    .line 52
    move v12, v11

    .line 53
    :goto_2
    if-ge v12, v6, :cond_9

    .line 54
    .line 55
    iget-object v13, v1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 56
    .line 57
    invoke-virtual {v13, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 58
    .line 59
    .line 60
    move-result-object v13

    .line 61
    check-cast v13, Lc0/e;

    .line 62
    .line 63
    invoke-virtual {v13}, Lc0/e;->y()Lc0/e$b;

    .line 64
    .line 65
    .line 66
    move-result-object v14

    .line 67
    sget-object v15, Lc0/e$b;->c:Lc0/e$b;

    .line 68
    .line 69
    if-ne v14, v15, :cond_2

    .line 70
    .line 71
    const/4 v14, 0x1

    .line 72
    goto :goto_3

    .line 73
    :cond_2
    move v14, v11

    .line 74
    :goto_3
    invoke-virtual {v13}, Lc0/e;->R()Lc0/e$b;

    .line 75
    .line 76
    .line 77
    move-result-object v10

    .line 78
    if-ne v10, v15, :cond_3

    .line 79
    .line 80
    const/4 v10, 0x1

    .line 81
    goto :goto_4

    .line 82
    :cond_3
    move v10, v11

    .line 83
    :goto_4
    if-eqz v14, :cond_4

    .line 84
    .line 85
    if-eqz v10, :cond_4

    .line 86
    .line 87
    invoke-virtual {v13}, Lc0/e;->t()F

    .line 88
    .line 89
    .line 90
    move-result v10

    .line 91
    const/4 v14, 0x0

    .line 92
    cmpl-float v10, v10, v14

    .line 93
    .line 94
    if-lez v10, :cond_4

    .line 95
    .line 96
    const/4 v10, 0x1

    .line 97
    goto :goto_5

    .line 98
    :cond_4
    move v10, v11

    .line 99
    :goto_5
    invoke-virtual {v13}, Lc0/e;->g0()Z

    .line 100
    .line 101
    .line 102
    move-result v14

    .line 103
    if-eqz v14, :cond_6

    .line 104
    .line 105
    if-eqz v10, :cond_6

    .line 106
    .line 107
    :cond_5
    :goto_6
    move v2, v11

    .line 108
    goto :goto_7

    .line 109
    :cond_6
    invoke-virtual {v13}, Lc0/e;->i0()Z

    .line 110
    .line 111
    .line 112
    move-result v14

    .line 113
    if-eqz v14, :cond_7

    .line 114
    .line 115
    if-eqz v10, :cond_7

    .line 116
    .line 117
    goto :goto_6

    .line 118
    :cond_7
    invoke-virtual {v13}, Lc0/e;->g0()Z

    .line 119
    .line 120
    .line 121
    move-result v10

    .line 122
    if-nez v10, :cond_5

    .line 123
    .line 124
    invoke-virtual {v13}, Lc0/e;->i0()Z

    .line 125
    .line 126
    .line 127
    move-result v10

    .line 128
    if-eqz v10, :cond_8

    .line 129
    .line 130
    goto :goto_6

    .line 131
    :cond_8
    add-int/lit8 v12, v12, 0x1

    .line 132
    .line 133
    goto :goto_2

    .line 134
    :cond_9
    :goto_7
    if-eqz v2, :cond_a

    .line 135
    .line 136
    sget-boolean v10, Lz/d;->r:Z

    .line 137
    .line 138
    :cond_a
    const/high16 v10, 0x40000000    # 2.0f

    .line 139
    .line 140
    if-ne v3, v10, :cond_b

    .line 141
    .line 142
    if-eq v4, v10, :cond_c

    .line 143
    .line 144
    :cond_b
    if-eqz v9, :cond_d

    .line 145
    .line 146
    :cond_c
    const/4 v12, 0x1

    .line 147
    goto :goto_8

    .line 148
    :cond_d
    move v12, v11

    .line 149
    :goto_8
    and-int/2addr v2, v12

    .line 150
    const/4 v12, 0x2

    .line 151
    if-eqz v2, :cond_15

    .line 152
    .line 153
    invoke-virtual {v1}, Lc0/e;->E()I

    .line 154
    .line 155
    .line 156
    move-result v13

    .line 157
    move/from16 v14, p6

    .line 158
    .line 159
    invoke-static {v13, v14}, Ljava/lang/Math;->min(II)I

    .line 160
    .line 161
    .line 162
    move-result v13

    .line 163
    invoke-virtual {v1}, Lc0/e;->D()I

    .line 164
    .line 165
    .line 166
    move-result v14

    .line 167
    move/from16 v15, p8

    .line 168
    .line 169
    invoke-static {v14, v15}, Ljava/lang/Math;->min(II)I

    .line 170
    .line 171
    .line 172
    move-result v14

    .line 173
    if-ne v3, v10, :cond_e

    .line 174
    .line 175
    invoke-virtual {v1}, Lc0/e;->U()I

    .line 176
    .line 177
    .line 178
    move-result v15

    .line 179
    if-eq v15, v13, :cond_e

    .line 180
    .line 181
    invoke-virtual {v1, v13}, Lc0/e;->g1(I)V

    .line 182
    .line 183
    .line 184
    invoke-virtual {v1}, Lc0/f;->H1()V

    .line 185
    .line 186
    .line 187
    :cond_e
    if-ne v4, v10, :cond_f

    .line 188
    .line 189
    invoke-virtual {v1}, Lc0/e;->v()I

    .line 190
    .line 191
    .line 192
    move-result v13

    .line 193
    if-eq v13, v14, :cond_f

    .line 194
    .line 195
    invoke-virtual {v1, v14}, Lc0/e;->I0(I)V

    .line 196
    .line 197
    .line 198
    invoke-virtual {v1}, Lc0/f;->H1()V

    .line 199
    .line 200
    .line 201
    :cond_f
    if-ne v3, v10, :cond_10

    .line 202
    .line 203
    if-ne v4, v10, :cond_10

    .line 204
    .line 205
    invoke-virtual {v1, v9}, Lc0/f;->B1(Z)Z

    .line 206
    .line 207
    .line 208
    move-result v9

    .line 209
    move v14, v12

    .line 210
    goto :goto_a

    .line 211
    :cond_10
    invoke-virtual {v1, v9}, Lc0/f;->C1(Z)Z

    .line 212
    .line 213
    .line 214
    move-result v13

    .line 215
    if-ne v3, v10, :cond_11

    .line 216
    .line 217
    invoke-virtual {v1, v9, v11}, Lc0/f;->D1(ZI)Z

    .line 218
    .line 219
    .line 220
    move-result v14

    .line 221
    and-int/2addr v13, v14

    .line 222
    const/4 v14, 0x1

    .line 223
    goto :goto_9

    .line 224
    :cond_11
    move v14, v11

    .line 225
    :goto_9
    if-ne v4, v10, :cond_12

    .line 226
    .line 227
    const/4 v15, 0x1

    .line 228
    invoke-virtual {v1, v9, v15}, Lc0/f;->D1(ZI)Z

    .line 229
    .line 230
    .line 231
    move-result v9

    .line 232
    and-int/2addr v9, v13

    .line 233
    add-int/lit8 v14, v14, 0x1

    .line 234
    .line 235
    goto :goto_a

    .line 236
    :cond_12
    move v9, v13

    .line 237
    :goto_a
    if-eqz v9, :cond_16

    .line 238
    .line 239
    if-ne v3, v10, :cond_13

    .line 240
    .line 241
    const/4 v15, 0x1

    .line 242
    goto :goto_b

    .line 243
    :cond_13
    move v15, v11

    .line 244
    :goto_b
    if-ne v4, v10, :cond_14

    .line 245
    .line 246
    const/4 v3, 0x1

    .line 247
    goto :goto_c

    .line 248
    :cond_14
    move v3, v11

    .line 249
    :goto_c
    invoke-virtual {v1, v15, v3}, Lc0/f;->l1(ZZ)V

    .line 250
    .line 251
    .line 252
    goto :goto_d

    .line 253
    :cond_15
    move v9, v11

    .line 254
    move v14, v9

    .line 255
    :cond_16
    :goto_d
    const-wide/16 v3, 0x0

    .line 256
    .line 257
    if-eqz v9, :cond_18

    .line 258
    .line 259
    if-eq v14, v12, :cond_17

    .line 260
    .line 261
    goto :goto_e

    .line 262
    :cond_17
    return-wide v3

    .line 263
    :cond_18
    :goto_e
    invoke-virtual {v1}, Lc0/f;->F1()I

    .line 264
    .line 265
    .line 266
    move-result v9

    .line 267
    if-lez v6, :cond_19

    .line 268
    .line 269
    invoke-virtual/range {p0 .. p1}, Ld0/b;->b(Lc0/f;)V

    .line 270
    .line 271
    .line 272
    :cond_19
    invoke-virtual/range {p0 .. p1}, Ld0/b;->e(Lc0/f;)V

    .line 273
    .line 274
    .line 275
    iget-object v10, v0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 276
    .line 277
    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    .line 278
    .line 279
    .line 280
    move-result v10

    .line 281
    if-lez v6, :cond_1a

    .line 282
    .line 283
    const-string v6, "First pass"

    .line 284
    .line 285
    const/4 v13, 0x0

    .line 286
    move-object/from16 p2, v0

    .line 287
    .line 288
    move-object/from16 p3, v1

    .line 289
    .line 290
    move-object/from16 p4, v6

    .line 291
    .line 292
    move/from16 p6, v7

    .line 293
    .line 294
    move/from16 p7, v8

    .line 295
    .line 296
    move/from16 p5, v13

    .line 297
    .line 298
    invoke-virtual/range {p2 .. p7}, Ld0/b;->c(Lc0/f;Ljava/lang/String;III)V

    .line 299
    .line 300
    .line 301
    move/from16 v1, p6

    .line 302
    .line 303
    move/from16 v6, p7

    .line 304
    .line 305
    goto :goto_f

    .line 306
    :cond_1a
    move v1, v7

    .line 307
    move v6, v8

    .line 308
    :goto_f
    if-lez v10, :cond_2a

    .line 309
    .line 310
    invoke-virtual/range {p1 .. p1}, Lc0/e;->y()Lc0/e$b;

    .line 311
    .line 312
    .line 313
    move-result-object v7

    .line 314
    sget-object v8, Lc0/e$b;->b:Lc0/e$b;

    .line 315
    .line 316
    if-ne v7, v8, :cond_1b

    .line 317
    .line 318
    const/4 v15, 0x1

    .line 319
    goto :goto_10

    .line 320
    :cond_1b
    move v15, v11

    .line 321
    :goto_10
    invoke-virtual/range {p1 .. p1}, Lc0/e;->R()Lc0/e$b;

    .line 322
    .line 323
    .line 324
    move-result-object v7

    .line 325
    if-ne v7, v8, :cond_1c

    .line 326
    .line 327
    const/4 v7, 0x1

    .line 328
    goto :goto_11

    .line 329
    :cond_1c
    move v7, v11

    .line 330
    :goto_11
    invoke-virtual/range {p1 .. p1}, Lc0/e;->U()I

    .line 331
    .line 332
    .line 333
    move-result v8

    .line 334
    iget-object v13, v0, Ld0/b;->c:Lc0/f;

    .line 335
    .line 336
    invoke-virtual {v13}, Lc0/e;->G()I

    .line 337
    .line 338
    .line 339
    move-result v13

    .line 340
    invoke-static {v8, v13}, Ljava/lang/Math;->max(II)I

    .line 341
    .line 342
    .line 343
    move-result v8

    .line 344
    invoke-virtual/range {p1 .. p1}, Lc0/e;->v()I

    .line 345
    .line 346
    .line 347
    move-result v13

    .line 348
    iget-object v14, v0, Ld0/b;->c:Lc0/f;

    .line 349
    .line 350
    invoke-virtual {v14}, Lc0/e;->F()I

    .line 351
    .line 352
    .line 353
    move-result v14

    .line 354
    invoke-static {v13, v14}, Ljava/lang/Math;->max(II)I

    .line 355
    .line 356
    .line 357
    move-result v13

    .line 358
    move v14, v11

    .line 359
    :goto_12
    if-ge v14, v10, :cond_1d

    .line 360
    .line 361
    move-wide/from16 v16, v3

    .line 362
    .line 363
    iget-object v3, v0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 364
    .line 365
    invoke-virtual {v3, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 366
    .line 367
    .line 368
    move-result-object v3

    .line 369
    check-cast v3, Lc0/e;

    .line 370
    .line 371
    add-int/lit8 v14, v14, 0x1

    .line 372
    .line 373
    move-wide/from16 v3, v16

    .line 374
    .line 375
    goto :goto_12

    .line 376
    :cond_1d
    move-wide/from16 v16, v3

    .line 377
    .line 378
    move v3, v11

    .line 379
    :goto_13
    if-ge v3, v12, :cond_29

    .line 380
    .line 381
    move v4, v11

    .line 382
    move v14, v4

    .line 383
    :goto_14
    if-ge v14, v10, :cond_28

    .line 384
    .line 385
    iget-object v11, v0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 386
    .line 387
    invoke-virtual {v11, v14}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 388
    .line 389
    .line 390
    move-result-object v11

    .line 391
    check-cast v11, Lc0/e;

    .line 392
    .line 393
    instance-of v12, v11, Lc0/h;

    .line 394
    .line 395
    if-eqz v12, :cond_1e

    .line 396
    .line 397
    :goto_15
    move/from16 p6, v1

    .line 398
    .line 399
    goto :goto_16

    .line 400
    :cond_1e
    instance-of v12, v11, Lc0/g;

    .line 401
    .line 402
    if-eqz v12, :cond_1f

    .line 403
    .line 404
    goto :goto_15

    .line 405
    :cond_1f
    invoke-virtual {v11}, Lc0/e;->T()I

    .line 406
    .line 407
    .line 408
    move-result v12

    .line 409
    move/from16 p6, v1

    .line 410
    .line 411
    const/16 v1, 0x8

    .line 412
    .line 413
    if-ne v12, v1, :cond_20

    .line 414
    .line 415
    goto :goto_16

    .line 416
    :cond_20
    if-eqz v2, :cond_21

    .line 417
    .line 418
    iget-object v1, v11, Lc0/e;->e:Ld0/l;

    .line 419
    .line 420
    iget-object v1, v1, Ld0/p;->e:Ld0/g;

    .line 421
    .line 422
    iget-boolean v1, v1, Ld0/f;->j:Z

    .line 423
    .line 424
    if-eqz v1, :cond_21

    .line 425
    .line 426
    iget-object v1, v11, Lc0/e;->f:Ld0/n;

    .line 427
    .line 428
    iget-object v1, v1, Ld0/p;->e:Ld0/g;

    .line 429
    .line 430
    iget-boolean v1, v1, Ld0/f;->j:Z

    .line 431
    .line 432
    if-eqz v1, :cond_21

    .line 433
    .line 434
    :goto_16
    move/from16 v18, v2

    .line 435
    .line 436
    move/from16 v19, v3

    .line 437
    .line 438
    goto/16 :goto_17

    .line 439
    .line 440
    :cond_21
    invoke-virtual {v11}, Lc0/e;->U()I

    .line 441
    .line 442
    .line 443
    move-result v1

    .line 444
    invoke-virtual {v11}, Lc0/e;->v()I

    .line 445
    .line 446
    .line 447
    move-result v12

    .line 448
    move/from16 v18, v2

    .line 449
    .line 450
    invoke-virtual {v11}, Lc0/e;->n()I

    .line 451
    .line 452
    .line 453
    move-result v2

    .line 454
    sget v19, Ld0/b$a;->l:I

    .line 455
    .line 456
    move/from16 p2, v4

    .line 457
    .line 458
    const/4 v4, 0x1

    .line 459
    if-ne v3, v4, :cond_22

    .line 460
    .line 461
    sget v19, Ld0/b$a;->m:I

    .line 462
    .line 463
    :cond_22
    move/from16 v4, v19

    .line 464
    .line 465
    invoke-virtual {v0, v5, v11, v4}, Ld0/b;->a(Ld0/b$b;Lc0/e;I)Z

    .line 466
    .line 467
    .line 468
    move-result v4

    .line 469
    or-int v4, p2, v4

    .line 470
    .line 471
    invoke-virtual {v11}, Lc0/e;->U()I

    .line 472
    .line 473
    .line 474
    move-result v0

    .line 475
    move/from16 v19, v3

    .line 476
    .line 477
    invoke-virtual {v11}, Lc0/e;->v()I

    .line 478
    .line 479
    .line 480
    move-result v3

    .line 481
    if-eq v0, v1, :cond_24

    .line 482
    .line 483
    invoke-virtual {v11, v0}, Lc0/e;->g1(I)V

    .line 484
    .line 485
    .line 486
    if-eqz v15, :cond_23

    .line 487
    .line 488
    invoke-virtual {v11}, Lc0/e;->K()I

    .line 489
    .line 490
    .line 491
    move-result v0

    .line 492
    if-le v0, v8, :cond_23

    .line 493
    .line 494
    invoke-virtual {v11}, Lc0/e;->K()I

    .line 495
    .line 496
    .line 497
    move-result v0

    .line 498
    sget-object v1, Lc0/d$b;->d:Lc0/d$b;

    .line 499
    .line 500
    invoke-virtual {v11, v1}, Lc0/e;->m(Lc0/d$b;)Lc0/d;

    .line 501
    .line 502
    .line 503
    move-result-object v1

    .line 504
    invoke-virtual {v1}, Lc0/d;->e()I

    .line 505
    .line 506
    .line 507
    move-result v1

    .line 508
    add-int/2addr v0, v1

    .line 509
    invoke-static {v8, v0}, Ljava/lang/Math;->max(II)I

    .line 510
    .line 511
    .line 512
    move-result v8

    .line 513
    :cond_23
    const/4 v4, 0x1

    .line 514
    :cond_24
    if-eq v3, v12, :cond_26

    .line 515
    .line 516
    invoke-virtual {v11, v3}, Lc0/e;->I0(I)V

    .line 517
    .line 518
    .line 519
    if-eqz v7, :cond_25

    .line 520
    .line 521
    invoke-virtual {v11}, Lc0/e;->p()I

    .line 522
    .line 523
    .line 524
    move-result v0

    .line 525
    if-le v0, v13, :cond_25

    .line 526
    .line 527
    invoke-virtual {v11}, Lc0/e;->p()I

    .line 528
    .line 529
    .line 530
    move-result v0

    .line 531
    sget-object v1, Lc0/d$b;->e:Lc0/d$b;

    .line 532
    .line 533
    invoke-virtual {v11, v1}, Lc0/e;->m(Lc0/d$b;)Lc0/d;

    .line 534
    .line 535
    .line 536
    move-result-object v1

    .line 537
    invoke-virtual {v1}, Lc0/d;->e()I

    .line 538
    .line 539
    .line 540
    move-result v1

    .line 541
    add-int/2addr v0, v1

    .line 542
    invoke-static {v13, v0}, Ljava/lang/Math;->max(II)I

    .line 543
    .line 544
    .line 545
    move-result v13

    .line 546
    :cond_25
    const/4 v4, 0x1

    .line 547
    :cond_26
    invoke-virtual {v11}, Lc0/e;->X()Z

    .line 548
    .line 549
    .line 550
    move-result v0

    .line 551
    if-eqz v0, :cond_27

    .line 552
    .line 553
    invoke-virtual {v11}, Lc0/e;->n()I

    .line 554
    .line 555
    .line 556
    move-result v0

    .line 557
    if-eq v2, v0, :cond_27

    .line 558
    .line 559
    const/4 v4, 0x1

    .line 560
    :cond_27
    :goto_17
    add-int/lit8 v14, v14, 0x1

    .line 561
    .line 562
    move-object/from16 v0, p0

    .line 563
    .line 564
    move/from16 v1, p6

    .line 565
    .line 566
    move/from16 v2, v18

    .line 567
    .line 568
    move/from16 v3, v19

    .line 569
    .line 570
    const/4 v11, 0x0

    .line 571
    const/4 v12, 0x2

    .line 572
    goto/16 :goto_14

    .line 573
    .line 574
    :cond_28
    move/from16 p6, v1

    .line 575
    .line 576
    move/from16 v18, v2

    .line 577
    .line 578
    move/from16 v19, v3

    .line 579
    .line 580
    move/from16 p2, v4

    .line 581
    .line 582
    if-eqz p2, :cond_29

    .line 583
    .line 584
    add-int/lit8 v3, v19, 0x1

    .line 585
    .line 586
    const-string v0, "intermediate pass"

    .line 587
    .line 588
    move-object/from16 p2, p0

    .line 589
    .line 590
    move-object/from16 p3, p1

    .line 591
    .line 592
    move-object/from16 p4, v0

    .line 593
    .line 594
    move/from16 p5, v3

    .line 595
    .line 596
    move/from16 p7, v6

    .line 597
    .line 598
    invoke-virtual/range {p2 .. p7}, Ld0/b;->c(Lc0/f;Ljava/lang/String;III)V

    .line 599
    .line 600
    .line 601
    move-object/from16 v1, p3

    .line 602
    .line 603
    move-object/from16 v0, p0

    .line 604
    .line 605
    move/from16 v1, p6

    .line 606
    .line 607
    move/from16 v2, v18

    .line 608
    .line 609
    const/4 v11, 0x0

    .line 610
    const/4 v12, 0x2

    .line 611
    goto/16 :goto_13

    .line 612
    .line 613
    :cond_29
    move-object/from16 v1, p1

    .line 614
    .line 615
    goto :goto_18

    .line 616
    :cond_2a
    move-object/from16 v1, p1

    .line 617
    .line 618
    move-wide/from16 v16, v3

    .line 619
    .line 620
    :goto_18
    invoke-virtual {v1, v9}, Lc0/f;->R1(I)V

    .line 621
    .line 622
    .line 623
    return-wide v16
.end method

.method public e(Lc0/f;)V
    .locals 5

    .line 1
    iget-object v0, p0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 7
    .line 8
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    const/4 v1, 0x0

    .line 13
    :goto_0
    if-ge v1, v0, :cond_2

    .line 14
    .line 15
    iget-object v2, p1, Lc0/k;->L0:Ljava/util/ArrayList;

    .line 16
    .line 17
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v2

    .line 21
    check-cast v2, Lc0/e;

    .line 22
    .line 23
    invoke-virtual {v2}, Lc0/e;->y()Lc0/e$b;

    .line 24
    .line 25
    .line 26
    move-result-object v3

    .line 27
    sget-object v4, Lc0/e$b;->c:Lc0/e$b;

    .line 28
    .line 29
    if-eq v3, v4, :cond_0

    .line 30
    .line 31
    invoke-virtual {v2}, Lc0/e;->R()Lc0/e$b;

    .line 32
    .line 33
    .line 34
    move-result-object v3

    .line 35
    if-ne v3, v4, :cond_1

    .line 36
    .line 37
    :cond_0
    iget-object v3, p0, Ld0/b;->a:Ljava/util/ArrayList;

    .line 38
    .line 39
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 40
    .line 41
    .line 42
    :cond_1
    add-int/lit8 v1, v1, 0x1

    .line 43
    .line 44
    goto :goto_0

    .line 45
    :cond_2
    invoke-virtual {p1}, Lc0/f;->H1()V

    .line 46
    .line 47
    .line 48
    return-void
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
