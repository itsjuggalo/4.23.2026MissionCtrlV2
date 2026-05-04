.class public final Lae/n;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lae/h;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lae/n$a;,
        Lae/n$b;
    }
.end annotation


# instance fields
.field public final a:Z

.field public final b:Lae/h;

.field public final c:Ljava/lang/reflect/Member;

.field public final d:Lae/n$a;

.field public final e:[Lvd/g;

.field public final f:Z


# direct methods
.method public constructor <init>(Lfe/b;Lae/h;Z)V
    .locals 10

    .line 1
    const-string v0, "descriptor"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    const-string v0, "oldCaller"

    .line 7
    .line 8
    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    .line 10
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    .line 13
    .line 14
    iput-boolean p3, p0, Lae/n;->a:Z

    .line 15
    .line 16
    instance-of v0, p2, Lae/i$h$c;

    .line 17
    .line 18
    const/4 v1, 0x0

    .line 19
    const/4 v2, 0x0

    .line 20
    if-eqz v0, :cond_6

    .line 21
    .line 22
    invoke-interface {p1}, Lfe/a;->k0()Lfe/b1;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    if-nez v0, :cond_0

    .line 27
    .line 28
    invoke-interface {p1}, Lfe/a;->e0()Lfe/b1;

    .line 29
    .line 30
    .line 31
    move-result-object v0

    .line 32
    :cond_0
    if-eqz v0, :cond_1

    .line 33
    .line 34
    invoke-interface {v0}, Lfe/r1;->getType()Lxf/r0;

    .line 35
    .line 36
    .line 37
    move-result-object v0

    .line 38
    goto :goto_0

    .line 39
    :cond_1
    move-object v0, v1

    .line 40
    :goto_0
    if-eqz v0, :cond_6

    .line 41
    .line 42
    invoke-static {v0}, Ljf/k;->i(Lxf/r0;)Z

    .line 43
    .line 44
    .line 45
    move-result v3

    .line 46
    if-eqz v3, :cond_6

    .line 47
    .line 48
    if-eqz p3, :cond_4

    .line 49
    .line 50
    invoke-interface {p1}, Lfe/a;->i()Ljava/util/List;

    .line 51
    .line 52
    .line 53
    move-result-object p3

    .line 54
    const-string v3, "getValueParameters(...)"

    .line 55
    .line 56
    invoke-static {p3, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 57
    .line 58
    .line 59
    if-eqz p3, :cond_2

    .line 60
    .line 61
    invoke-interface {p3}, Ljava/util/Collection;->isEmpty()Z

    .line 62
    .line 63
    .line 64
    move-result v3

    .line 65
    if-eqz v3, :cond_2

    .line 66
    .line 67
    goto :goto_2

    .line 68
    :cond_2
    invoke-interface {p3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 69
    .line 70
    .line 71
    move-result-object p3

    .line 72
    :cond_3
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 73
    .line 74
    .line 75
    move-result v3

    .line 76
    if-eqz v3, :cond_6

    .line 77
    .line 78
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 79
    .line 80
    .line 81
    move-result-object v3

    .line 82
    check-cast v3, Lfe/s1;

    .line 83
    .line 84
    invoke-interface {v3}, Lfe/s1;->s0()Z

    .line 85
    .line 86
    .line 87
    move-result v3

    .line 88
    if-eqz v3, :cond_3

    .line 89
    .line 90
    :cond_4
    invoke-static {v0}, Lxf/e2;->a(Lxf/r0;)Lxf/c1;

    .line 91
    .line 92
    .line 93
    move-result-object p3

    .line 94
    invoke-static {p3}, Lae/o;->n(Lxf/c1;)Ljava/util/List;

    .line 95
    .line 96
    .line 97
    move-result-object p3

    .line 98
    invoke-static {p3}, Lkotlin/jvm/internal/t;->c(Ljava/lang/Object;)V

    .line 99
    .line 100
    .line 101
    new-instance v0, Ljava/util/ArrayList;

    .line 102
    .line 103
    const/16 v3, 0xa

    .line 104
    .line 105
    invoke-static {p3, v3}, Ldd/s;->u(Ljava/lang/Iterable;I)I

    .line 106
    .line 107
    .line 108
    move-result v3

    .line 109
    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 110
    .line 111
    .line 112
    invoke-interface {p3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 113
    .line 114
    .line 115
    move-result-object p3

    .line 116
    :goto_1
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 117
    .line 118
    .line 119
    move-result v3

    .line 120
    if-eqz v3, :cond_5

    .line 121
    .line 122
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 123
    .line 124
    .line 125
    move-result-object v3

    .line 126
    check-cast v3, Ljava/lang/reflect/Method;

    .line 127
    .line 128
    move-object v4, p2

    .line 129
    check-cast v4, Lae/i$h$c;

    .line 130
    .line 131
    invoke-virtual {v4}, Lae/i$h$c;->h()Ljava/lang/Object;

    .line 132
    .line 133
    .line 134
    move-result-object v4

    .line 135
    invoke-virtual {v3, v4, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 136
    .line 137
    .line 138
    move-result-object v3

    .line 139
    invoke-interface {v0, v3}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 140
    .line 141
    .line 142
    goto :goto_1

    .line 143
    :cond_5
    new-array p3, v2, [Ljava/lang/Object;

    .line 144
    .line 145
    invoke-interface {v0, p3}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 146
    .line 147
    .line 148
    move-result-object p3

    .line 149
    new-instance v0, Lae/i$h$d;

    .line 150
    .line 151
    check-cast p2, Lae/i$h;

    .line 152
    .line 153
    invoke-virtual {p2}, Lae/i;->b()Ljava/lang/reflect/Member;

    .line 154
    .line 155
    .line 156
    move-result-object p2

    .line 157
    check-cast p2, Ljava/lang/reflect/Method;

    .line 158
    .line 159
    invoke-direct {v0, p2, p3}, Lae/i$h$d;-><init>(Ljava/lang/reflect/Method;[Ljava/lang/Object;)V

    .line 160
    .line 161
    .line 162
    move-object p2, v0

    .line 163
    :cond_6
    :goto_2
    iput-object p2, p0, Lae/n;->b:Lae/h;

    .line 164
    .line 165
    invoke-interface {p2}, Lae/h;->b()Ljava/lang/reflect/Member;

    .line 166
    .line 167
    .line 168
    move-result-object p3

    .line 169
    iput-object p3, p0, Lae/n;->c:Ljava/lang/reflect/Member;

    .line 170
    .line 171
    invoke-interface {p1}, Lfe/a;->getReturnType()Lxf/r0;

    .line 172
    .line 173
    .line 174
    move-result-object p3

    .line 175
    invoke-static {p3}, Lkotlin/jvm/internal/t;->c(Ljava/lang/Object;)V

    .line 176
    .line 177
    .line 178
    instance-of v0, p1, Lfe/z;

    .line 179
    .line 180
    const/4 v3, 0x1

    .line 181
    if-eqz v0, :cond_8

    .line 182
    .line 183
    move-object v4, p1

    .line 184
    check-cast v4, Lfe/z;

    .line 185
    .line 186
    invoke-interface {v4}, Lfe/z;->isSuspend()Z

    .line 187
    .line 188
    .line 189
    move-result v4

    .line 190
    if-eqz v4, :cond_8

    .line 191
    .line 192
    invoke-static {p3}, Ljf/k;->j(Lxf/r0;)Lxf/r0;

    .line 193
    .line 194
    .line 195
    move-result-object v4

    .line 196
    if-eqz v4, :cond_8

    .line 197
    .line 198
    invoke-static {v4}, Lce/i;->t0(Lxf/r0;)Z

    .line 199
    .line 200
    .line 201
    move-result v4

    .line 202
    if-ne v4, v3, :cond_8

    .line 203
    .line 204
    :cond_7
    move-object p3, v1

    .line 205
    goto :goto_3

    .line 206
    :cond_8
    invoke-static {p3}, Lae/o;->f(Lxf/r0;)Ljava/lang/Class;

    .line 207
    .line 208
    .line 209
    move-result-object p3

    .line 210
    if-eqz p3, :cond_7

    .line 211
    .line 212
    invoke-static {p3, p1}, Lae/o;->c(Ljava/lang/Class;Lfe/b;)Ljava/lang/reflect/Method;

    .line 213
    .line 214
    .line 215
    move-result-object p3

    .line 216
    :goto_3
    invoke-static {p1}, Ljf/k;->a(Lfe/a;)Z

    .line 217
    .line 218
    .line 219
    move-result v4

    .line 220
    if-eqz v4, :cond_9

    .line 221
    .line 222
    new-instance p1, Lae/n$a;

    .line 223
    .line 224
    sget-object p2, Lvd/g;->e:Lvd/g$a;

    .line 225
    .line 226
    invoke-virtual {p2}, Lvd/g$a;->a()Lvd/g;

    .line 227
    .line 228
    .line 229
    move-result-object p2

    .line 230
    new-array v0, v2, [Ljava/util/List;

    .line 231
    .line 232
    invoke-direct {p1, p2, v0, p3}, Lae/n$a;-><init>(Lvd/g;[Ljava/util/List;Ljava/lang/reflect/Method;)V

    .line 233
    .line 234
    .line 235
    goto/16 :goto_d

    .line 236
    .line 237
    :cond_9
    instance-of v4, p2, Lae/i$h$c;

    .line 238
    .line 239
    const/4 v5, -0x1

    .line 240
    if-eqz v4, :cond_a

    .line 241
    .line 242
    move-object v4, p2

    .line 243
    check-cast v4, Lae/i$h$c;

    .line 244
    .line 245
    invoke-virtual {v4}, Lae/i$h$c;->i()Z

    .line 246
    .line 247
    .line 248
    move-result v4

    .line 249
    if-nez v4, :cond_a

    .line 250
    .line 251
    goto :goto_5

    .line 252
    :cond_a
    instance-of v4, p2, Lae/i$h$d;

    .line 253
    .line 254
    if-eqz v4, :cond_b

    .line 255
    .line 256
    goto :goto_5

    .line 257
    :cond_b
    instance-of v4, p1, Lfe/l;

    .line 258
    .line 259
    if-eqz v4, :cond_d

    .line 260
    .line 261
    instance-of v4, p2, Lae/g;

    .line 262
    .line 263
    if-eqz v4, :cond_c

    .line 264
    .line 265
    goto :goto_5

    .line 266
    :cond_c
    :goto_4
    move v5, v2

    .line 267
    goto :goto_5

    .line 268
    :cond_d
    invoke-interface {p1}, Lfe/a;->e0()Lfe/b1;

    .line 269
    .line 270
    .line 271
    move-result-object v4

    .line 272
    if-eqz v4, :cond_c

    .line 273
    .line 274
    instance-of v4, p2, Lae/g;

    .line 275
    .line 276
    if-nez v4, :cond_c

    .line 277
    .line 278
    invoke-interface {p1}, Lfe/n;->b()Lfe/m;

    .line 279
    .line 280
    .line 281
    move-result-object v4

    .line 282
    const-string v5, "getContainingDeclaration(...)"

    .line 283
    .line 284
    invoke-static {v4, v5}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 285
    .line 286
    .line 287
    invoke-static {v4}, Ljf/k;->g(Lfe/m;)Z

    .line 288
    .line 289
    .line 290
    move-result v4

    .line 291
    if-eqz v4, :cond_e

    .line 292
    .line 293
    goto :goto_4

    .line 294
    :cond_e
    move v5, v3

    .line 295
    :goto_5
    instance-of v4, p2, Lae/i$h$d;

    .line 296
    .line 297
    if-eqz v4, :cond_f

    .line 298
    .line 299
    move-object v4, p2

    .line 300
    check-cast v4, Lae/i$h$d;

    .line 301
    .line 302
    invoke-virtual {v4}, Lae/i$h$d;->i()I

    .line 303
    .line 304
    .line 305
    move-result v4

    .line 306
    neg-int v4, v4

    .line 307
    goto :goto_6

    .line 308
    :cond_f
    move v4, v5

    .line 309
    :goto_6
    invoke-interface {p2}, Lae/h;->b()Ljava/lang/reflect/Member;

    .line 310
    .line 311
    .line 312
    move-result-object p2

    .line 313
    sget-object v6, Lae/m;->a:Lae/m;

    .line 314
    .line 315
    invoke-static {p1, p2, v6}, Lae/o;->e(Lfe/b;Ljava/lang/reflect/Member;Lpd/k;)Ljava/util/List;

    .line 316
    .line 317
    .line 318
    move-result-object p2

    .line 319
    invoke-interface {p2}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 320
    .line 321
    .line 322
    move-result-object v6

    .line 323
    move v7, v2

    .line 324
    :goto_7
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 325
    .line 326
    .line 327
    move-result v8

    .line 328
    if-eqz v8, :cond_11

    .line 329
    .line 330
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 331
    .line 332
    .line 333
    move-result-object v8

    .line 334
    check-cast v8, Lxf/r0;

    .line 335
    .line 336
    invoke-static {v8}, Lxf/e2;->a(Lxf/r0;)Lxf/c1;

    .line 337
    .line 338
    .line 339
    move-result-object v8

    .line 340
    invoke-static {v8}, Lae/o;->n(Lxf/c1;)Ljava/util/List;

    .line 341
    .line 342
    .line 343
    move-result-object v8

    .line 344
    if-eqz v8, :cond_10

    .line 345
    .line 346
    invoke-interface {v8}, Ljava/util/List;->size()I

    .line 347
    .line 348
    .line 349
    move-result v8

    .line 350
    goto :goto_8

    .line 351
    :cond_10
    move v8, v3

    .line 352
    :goto_8
    add-int/2addr v7, v8

    .line 353
    goto :goto_7

    .line 354
    :cond_11
    iget-boolean v6, p0, Lae/n;->a:Z

    .line 355
    .line 356
    if-eqz v6, :cond_12

    .line 357
    .line 358
    add-int/lit8 v6, v7, 0x1f

    .line 359
    .line 360
    div-int/lit8 v6, v6, 0x20

    .line 361
    .line 362
    add-int/2addr v6, v3

    .line 363
    goto :goto_9

    .line 364
    :cond_12
    move v6, v2

    .line 365
    :goto_9
    if-eqz v0, :cond_13

    .line 366
    .line 367
    move-object v0, p1

    .line 368
    check-cast v0, Lfe/z;

    .line 369
    .line 370
    invoke-interface {v0}, Lfe/z;->isSuspend()Z

    .line 371
    .line 372
    .line 373
    move-result v0

    .line 374
    if-eqz v0, :cond_13

    .line 375
    .line 376
    move v0, v3

    .line 377
    goto :goto_a

    .line 378
    :cond_13
    move v0, v2

    .line 379
    :goto_a
    add-int/2addr v6, v0

    .line 380
    add-int/2addr v7, v4

    .line 381
    add-int/2addr v7, v6

    .line 382
    iget-boolean v0, p0, Lae/n;->a:Z

    .line 383
    .line 384
    invoke-static {p0, v7, p1, v0}, Lae/o;->b(Lae/h;ILfe/b;Z)V

    .line 385
    .line 386
    .line 387
    invoke-static {v5, v2}, Ljava/lang/Math;->max(II)I

    .line 388
    .line 389
    .line 390
    move-result v0

    .line 391
    invoke-interface {p2}, Ljava/util/List;->size()I

    .line 392
    .line 393
    .line 394
    move-result v4

    .line 395
    add-int/2addr v4, v5

    .line 396
    invoke-static {v0, v4}, Lvd/l;->l(II)Lvd/g;

    .line 397
    .line 398
    .line 399
    move-result-object v0

    .line 400
    new-array v4, v7, [Ljava/util/List;

    .line 401
    .line 402
    move v6, v2

    .line 403
    :goto_b
    if-ge v6, v7, :cond_15

    .line 404
    .line 405
    invoke-virtual {v0}, Lvd/e;->e()I

    .line 406
    .line 407
    .line 408
    move-result v8

    .line 409
    invoke-virtual {v0}, Lvd/e;->f()I

    .line 410
    .line 411
    .line 412
    move-result v9

    .line 413
    if-gt v6, v9, :cond_14

    .line 414
    .line 415
    if-gt v8, v6, :cond_14

    .line 416
    .line 417
    sub-int v8, v6, v5

    .line 418
    .line 419
    invoke-interface {p2, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    .line 420
    .line 421
    .line 422
    move-result-object v8

    .line 423
    check-cast v8, Lxf/r0;

    .line 424
    .line 425
    invoke-static {v8}, Lxf/e2;->a(Lxf/r0;)Lxf/c1;

    .line 426
    .line 427
    .line 428
    move-result-object v8

    .line 429
    invoke-static {v8, p1}, Lae/o;->d(Lxf/c1;Lfe/b;)Ljava/util/List;

    .line 430
    .line 431
    .line 432
    move-result-object v8

    .line 433
    goto :goto_c

    .line 434
    :cond_14
    move-object v8, v1

    .line 435
    :goto_c
    aput-object v8, v4, v6

    .line 436
    .line 437
    add-int/lit8 v6, v6, 0x1

    .line 438
    .line 439
    goto :goto_b

    .line 440
    :cond_15
    new-instance p1, Lae/n$a;

    .line 441
    .line 442
    invoke-direct {p1, v0, v4, p3}, Lae/n$a;-><init>(Lvd/g;[Ljava/util/List;Ljava/lang/reflect/Method;)V

    .line 443
    .line 444
    .line 445
    :goto_d
    iput-object p1, p0, Lae/n;->d:Lae/n$a;

    .line 446
    .line 447
    invoke-static {}, Ldd/q;->c()Ljava/util/List;

    .line 448
    .line 449
    .line 450
    move-result-object p2

    .line 451
    iget-object p3, p0, Lae/n;->b:Lae/h;

    .line 452
    .line 453
    instance-of v0, p3, Lae/i$h$d;

    .line 454
    .line 455
    if-eqz v0, :cond_16

    .line 456
    .line 457
    check-cast p3, Lae/i$h$d;

    .line 458
    .line 459
    invoke-virtual {p3}, Lae/i$h$d;->h()[Ljava/lang/Object;

    .line 460
    .line 461
    .line 462
    move-result-object p3

    .line 463
    array-length p3, p3

    .line 464
    goto :goto_e

    .line 465
    :cond_16
    instance-of p3, p3, Lae/i$h$c;

    .line 466
    .line 467
    if-eqz p3, :cond_17

    .line 468
    .line 469
    move p3, v3

    .line 470
    goto :goto_e

    .line 471
    :cond_17
    move p3, v2

    .line 472
    :goto_e
    if-lez p3, :cond_18

    .line 473
    .line 474
    invoke-static {v2, p3}, Lvd/l;->l(II)Lvd/g;

    .line 475
    .line 476
    .line 477
    move-result-object v0

    .line 478
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 479
    .line 480
    .line 481
    :cond_18
    invoke-virtual {p1}, Lae/n$a;->c()[Ljava/util/List;

    .line 482
    .line 483
    .line 484
    move-result-object p1

    .line 485
    array-length v0, p1

    .line 486
    move v1, v2

    .line 487
    :goto_f
    if-ge v1, v0, :cond_1a

    .line 488
    .line 489
    aget-object v4, p1, v1

    .line 490
    .line 491
    if-eqz v4, :cond_19

    .line 492
    .line 493
    invoke-interface {v4}, Ljava/util/List;->size()I

    .line 494
    .line 495
    .line 496
    move-result v4

    .line 497
    goto :goto_10

    .line 498
    :cond_19
    move v4, v3

    .line 499
    :goto_10
    add-int/2addr v4, p3

    .line 500
    invoke-static {p3, v4}, Lvd/l;->l(II)Lvd/g;

    .line 501
    .line 502
    .line 503
    move-result-object p3

    .line 504
    invoke-interface {p2, p3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 505
    .line 506
    .line 507
    add-int/lit8 v1, v1, 0x1

    .line 508
    .line 509
    move p3, v4

    .line 510
    goto :goto_f

    .line 511
    :cond_1a
    invoke-static {p2}, Ldd/q;->a(Ljava/util/List;)Ljava/util/List;

    .line 512
    .line 513
    .line 514
    move-result-object p1

    .line 515
    new-array p2, v2, [Lvd/g;

    .line 516
    .line 517
    invoke-interface {p1, p2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 518
    .line 519
    .line 520
    move-result-object p1

    .line 521
    check-cast p1, [Lvd/g;

    .line 522
    .line 523
    iput-object p1, p0, Lae/n;->e:[Lvd/g;

    .line 524
    .line 525
    iget-object p1, p0, Lae/n;->d:Lae/n$a;

    .line 526
    .line 527
    invoke-virtual {p1}, Lae/n$a;->a()Lvd/g;

    .line 528
    .line 529
    .line 530
    move-result-object p1

    .line 531
    instance-of p2, p1, Ljava/util/Collection;

    .line 532
    .line 533
    if-eqz p2, :cond_1b

    .line 534
    .line 535
    move-object p2, p1

    .line 536
    check-cast p2, Ljava/util/Collection;

    .line 537
    .line 538
    invoke-interface {p2}, Ljava/util/Collection;->isEmpty()Z

    .line 539
    .line 540
    .line 541
    move-result p2

    .line 542
    if-eqz p2, :cond_1b

    .line 543
    .line 544
    goto :goto_12

    .line 545
    :cond_1b
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 546
    .line 547
    .line 548
    move-result-object p1

    .line 549
    :cond_1c
    :goto_11
    invoke-interface {p1}, Ljava/util/Iterator;->hasNext()Z

    .line 550
    .line 551
    .line 552
    move-result p2

    .line 553
    if-eqz p2, :cond_1e

    .line 554
    .line 555
    move-object p2, p1

    .line 556
    check-cast p2, Ldd/j0;

    .line 557
    .line 558
    invoke-virtual {p2}, Ldd/j0;->nextInt()I

    .line 559
    .line 560
    .line 561
    move-result p2

    .line 562
    iget-object p3, p0, Lae/n;->d:Lae/n$a;

    .line 563
    .line 564
    invoke-virtual {p3}, Lae/n$a;->c()[Ljava/util/List;

    .line 565
    .line 566
    .line 567
    move-result-object p3

    .line 568
    aget-object p2, p3, p2

    .line 569
    .line 570
    if-nez p2, :cond_1d

    .line 571
    .line 572
    goto :goto_11

    .line 573
    :cond_1d
    invoke-interface {p2}, Ljava/util/List;->size()I

    .line 574
    .line 575
    .line 576
    move-result p2

    .line 577
    if-le p2, v3, :cond_1c

    .line 578
    .line 579
    move v2, v3

    .line 580
    :cond_1e
    :goto_12
    iput-boolean v2, p0, Lae/n;->f:Z

    .line 581
    .line 582
    return-void
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

.method public static synthetic d(Lfe/e;)Z
    .locals 0

    .line 1
    invoke-static {p0}, Lae/n;->e(Lfe/e;)Z

    .line 2
    .line 3
    .line 4
    move-result p0

    .line 5
    return p0
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
.end method

.method public static final e(Lfe/e;)Z
    .locals 1

    .line 1
    const-string v0, "$this$makeKotlinParameterTypes"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-static {p0}, Ljf/k;->g(Lfe/m;)Z

    .line 7
    .line 8
    .line 9
    move-result p0

    .line 10
    return p0
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
.method public a()Ljava/util/List;
    .locals 1

    .line 1
    iget-object v0, p0, Lae/n;->b:Lae/h;

    .line 2
    .line 3
    invoke-interface {v0}, Lae/h;->a()Ljava/util/List;

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

.method public b()Ljava/lang/reflect/Member;
    .locals 1

    .line 1
    iget-object v0, p0, Lae/n;->c:Ljava/lang/reflect/Member;

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

.method public c()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lae/n;->b:Lae/h;

    .line 2
    .line 3
    instance-of v0, v0, Lae/i$h$a;

    .line 4
    .line 5
    return v0
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

.method public call([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 12

    .line 1
    const-string v0, "args"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Lae/n;->d:Lae/n$a;

    .line 7
    .line 8
    invoke-virtual {v0}, Lae/n$a;->a()Lvd/g;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    iget-object v1, p0, Lae/n;->d:Lae/n$a;

    .line 13
    .line 14
    invoke-virtual {v1}, Lae/n$a;->c()[Ljava/util/List;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    iget-object v2, p0, Lae/n;->d:Lae/n$a;

    .line 19
    .line 20
    invoke-virtual {v2}, Lae/n$a;->b()Ljava/lang/reflect/Method;

    .line 21
    .line 22
    .line 23
    move-result-object v2

    .line 24
    invoke-virtual {v0}, Lvd/g;->isEmpty()Z

    .line 25
    .line 26
    .line 27
    move-result v3

    .line 28
    const/4 v4, 0x0

    .line 29
    if-eqz v3, :cond_0

    .line 30
    .line 31
    goto/16 :goto_8

    .line 32
    .line 33
    :cond_0
    iget-boolean v3, p0, Lae/n;->f:Z

    .line 34
    .line 35
    const-string v5, "getReturnType(...)"

    .line 36
    .line 37
    const/4 v6, 0x0

    .line 38
    if-eqz v3, :cond_7

    .line 39
    .line 40
    array-length v3, p1

    .line 41
    invoke-static {v3}, Ldd/q;->d(I)Ljava/util/List;

    .line 42
    .line 43
    .line 44
    move-result-object v3

    .line 45
    invoke-virtual {v0}, Lvd/e;->e()I

    .line 46
    .line 47
    .line 48
    move-result v7

    .line 49
    move v8, v6

    .line 50
    :goto_0
    if-ge v8, v7, :cond_1

    .line 51
    .line 52
    aget-object v9, p1, v8

    .line 53
    .line 54
    invoke-interface {v3, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 55
    .line 56
    .line 57
    add-int/lit8 v8, v8, 0x1

    .line 58
    .line 59
    goto :goto_0

    .line 60
    :cond_1
    invoke-virtual {v0}, Lvd/e;->e()I

    .line 61
    .line 62
    .line 63
    move-result v7

    .line 64
    invoke-virtual {v0}, Lvd/e;->f()I

    .line 65
    .line 66
    .line 67
    move-result v8

    .line 68
    if-gt v7, v8, :cond_5

    .line 69
    .line 70
    :goto_1
    aget-object v9, v1, v7

    .line 71
    .line 72
    aget-object v10, p1, v7

    .line 73
    .line 74
    if-eqz v9, :cond_3

    .line 75
    .line 76
    invoke-interface {v9}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 77
    .line 78
    .line 79
    move-result-object v9

    .line 80
    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    .line 81
    .line 82
    .line 83
    move-result v11

    .line 84
    if-eqz v11, :cond_4

    .line 85
    .line 86
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 87
    .line 88
    .line 89
    move-result-object v11

    .line 90
    check-cast v11, Ljava/lang/reflect/Method;

    .line 91
    .line 92
    if-eqz v10, :cond_2

    .line 93
    .line 94
    invoke-virtual {v11, v10, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    .line 96
    .line 97
    move-result-object v11

    .line 98
    goto :goto_3

    .line 99
    :cond_2
    invoke-virtual {v11}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    .line 100
    .line 101
    .line 102
    move-result-object v11

    .line 103
    invoke-static {v11, v5}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 104
    .line 105
    .line 106
    invoke-static {v11}, Lzd/i3;->g(Ljava/lang/reflect/Type;)Ljava/lang/Object;

    .line 107
    .line 108
    .line 109
    move-result-object v11

    .line 110
    :goto_3
    invoke-interface {v3, v11}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 111
    .line 112
    .line 113
    goto :goto_2

    .line 114
    :cond_3
    invoke-interface {v3, v10}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 115
    .line 116
    .line 117
    :cond_4
    if-eq v7, v8, :cond_5

    .line 118
    .line 119
    add-int/lit8 v7, v7, 0x1

    .line 120
    .line 121
    goto :goto_1

    .line 122
    :cond_5
    invoke-virtual {v0}, Lvd/e;->f()I

    .line 123
    .line 124
    .line 125
    move-result v0

    .line 126
    add-int/lit8 v0, v0, 0x1

    .line 127
    .line 128
    invoke-static {p1}, Ldd/n;->G([Ljava/lang/Object;)I

    .line 129
    .line 130
    .line 131
    move-result v1

    .line 132
    if-gt v0, v1, :cond_6

    .line 133
    .line 134
    :goto_4
    aget-object v5, p1, v0

    .line 135
    .line 136
    invoke-interface {v3, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    .line 138
    .line 139
    if-eq v0, v1, :cond_6

    .line 140
    .line 141
    add-int/lit8 v0, v0, 0x1

    .line 142
    .line 143
    goto :goto_4

    .line 144
    :cond_6
    invoke-static {v3}, Ldd/q;->a(Ljava/util/List;)Ljava/util/List;

    .line 145
    .line 146
    .line 147
    move-result-object p1

    .line 148
    new-array v0, v6, [Ljava/lang/Object;

    .line 149
    .line 150
    invoke-interface {p1, v0}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 151
    .line 152
    .line 153
    move-result-object p1

    .line 154
    goto :goto_8

    .line 155
    :cond_7
    array-length v3, p1

    .line 156
    new-array v7, v3, [Ljava/lang/Object;

    .line 157
    .line 158
    :goto_5
    if-ge v6, v3, :cond_c

    .line 159
    .line 160
    invoke-virtual {v0}, Lvd/e;->e()I

    .line 161
    .line 162
    .line 163
    move-result v8

    .line 164
    invoke-virtual {v0}, Lvd/e;->f()I

    .line 165
    .line 166
    .line 167
    move-result v9

    .line 168
    if-gt v6, v9, :cond_b

    .line 169
    .line 170
    if-gt v8, v6, :cond_b

    .line 171
    .line 172
    aget-object v8, v1, v6

    .line 173
    .line 174
    if-eqz v8, :cond_8

    .line 175
    .line 176
    invoke-static {v8}, Ldd/a0;->v0(Ljava/util/List;)Ljava/lang/Object;

    .line 177
    .line 178
    .line 179
    move-result-object v8

    .line 180
    check-cast v8, Ljava/lang/reflect/Method;

    .line 181
    .line 182
    goto :goto_6

    .line 183
    :cond_8
    move-object v8, v4

    .line 184
    :goto_6
    aget-object v9, p1, v6

    .line 185
    .line 186
    if-nez v8, :cond_9

    .line 187
    .line 188
    goto :goto_7

    .line 189
    :cond_9
    if-eqz v9, :cond_a

    .line 190
    .line 191
    invoke-virtual {v8, v9, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    .line 193
    .line 194
    move-result-object v9

    .line 195
    goto :goto_7

    .line 196
    :cond_a
    invoke-virtual {v8}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    .line 197
    .line 198
    .line 199
    move-result-object v8

    .line 200
    invoke-static {v8, v5}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 201
    .line 202
    .line 203
    invoke-static {v8}, Lzd/i3;->g(Ljava/lang/reflect/Type;)Ljava/lang/Object;

    .line 204
    .line 205
    .line 206
    move-result-object v9

    .line 207
    goto :goto_7

    .line 208
    :cond_b
    aget-object v9, p1, v6

    .line 209
    .line 210
    :goto_7
    aput-object v9, v7, v6

    .line 211
    .line 212
    add-int/lit8 v6, v6, 0x1

    .line 213
    .line 214
    goto :goto_5

    .line 215
    :cond_c
    move-object p1, v7

    .line 216
    :goto_8
    iget-object v0, p0, Lae/n;->b:Lae/h;

    .line 217
    .line 218
    invoke-interface {v0, p1}, Lae/h;->call([Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    .line 220
    .line 221
    move-result-object p1

    .line 222
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 223
    .line 224
    .line 225
    move-result-object v0

    .line 226
    if-ne p1, v0, :cond_d

    .line 227
    .line 228
    goto :goto_9

    .line 229
    :cond_d
    if-eqz v2, :cond_f

    .line 230
    .line 231
    filled-new-array {p1}, [Ljava/lang/Object;

    .line 232
    .line 233
    .line 234
    move-result-object v0

    .line 235
    invoke-virtual {v2, v4, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 236
    .line 237
    .line 238
    move-result-object v0

    .line 239
    if-nez v0, :cond_e

    .line 240
    .line 241
    goto :goto_9

    .line 242
    :cond_e
    return-object v0

    .line 243
    :cond_f
    :goto_9
    return-object p1
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

.method public final f(I)Lvd/g;
    .locals 2

    .line 1
    if-ltz p1, :cond_0

    .line 2
    .line 3
    iget-object v0, p0, Lae/n;->e:[Lvd/g;

    .line 4
    .line 5
    array-length v1, v0

    .line 6
    if-ge p1, v1, :cond_0

    .line 7
    .line 8
    aget-object p1, v0, p1

    .line 9
    .line 10
    return-object p1

    .line 11
    :cond_0
    iget-object v0, p0, Lae/n;->e:[Lvd/g;

    .line 12
    .line 13
    array-length v1, v0

    .line 14
    if-nez v1, :cond_1

    .line 15
    .line 16
    new-instance v0, Lvd/g;

    .line 17
    .line 18
    invoke-direct {v0, p1, p1}, Lvd/g;-><init>(II)V

    .line 19
    .line 20
    .line 21
    return-object v0

    .line 22
    :cond_1
    array-length v1, v0

    .line 23
    sub-int/2addr p1, v1

    .line 24
    invoke-static {v0}, Ldd/n;->k0([Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object v0

    .line 28
    check-cast v0, Lvd/g;

    .line 29
    .line 30
    invoke-virtual {v0}, Lvd/e;->f()I

    .line 31
    .line 32
    .line 33
    move-result v0

    .line 34
    add-int/lit8 v0, v0, 0x1

    .line 35
    .line 36
    add-int/2addr p1, v0

    .line 37
    new-instance v0, Lvd/g;

    .line 38
    .line 39
    invoke-direct {v0, p1, p1}, Lvd/g;-><init>(II)V

    .line 40
    .line 41
    .line 42
    return-object v0
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

.method public getReturnType()Ljava/lang/reflect/Type;
    .locals 1

    .line 1
    iget-object v0, p0, Lae/n;->b:Lae/h;

    .line 2
    .line 3
    invoke-interface {v0}, Lae/h;->getReturnType()Ljava/lang/reflect/Type;

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
