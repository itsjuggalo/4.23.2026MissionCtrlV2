.class public final Lxe/k$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lxe/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lxe/k$a$a;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lxe/k$a;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lxe/v;Lxe/v;Loe/u;Ljava/lang/String;Ltf/w;Lue/b;)Lxe/k$a$a;
    .locals 24

    .line 1
    move-object/from16 v0, p4

    .line 2
    .line 3
    const-string v1, "kotlinClassFinder"

    .line 4
    .line 5
    move-object/from16 v6, p1

    .line 6
    .line 7
    invoke-static {v6, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    const-string v1, "jvmBuiltInsKotlinClassFinder"

    .line 11
    .line 12
    move-object/from16 v14, p2

    .line 13
    .line 14
    invoke-static {v14, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 15
    .line 16
    .line 17
    const-string v1, "javaClassFinder"

    .line 18
    .line 19
    move-object/from16 v2, p3

    .line 20
    .line 21
    invoke-static {v2, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 22
    .line 23
    .line 24
    const-string v1, "moduleName"

    .line 25
    .line 26
    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 27
    .line 28
    .line 29
    const-string v1, "errorReporter"

    .line 30
    .line 31
    move-object/from16 v8, p5

    .line 32
    .line 33
    invoke-static {v8, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 34
    .line 35
    .line 36
    const-string v1, "javaSourceElementFactory"

    .line 37
    .line 38
    move-object/from16 v9, p6

    .line 39
    .line 40
    invoke-static {v9, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 41
    .line 42
    .line 43
    new-instance v3, Lwf/f;

    .line 44
    .line 45
    const-string v1, "DeserializationComponentsForJava.ModuleData"

    .line 46
    .line 47
    invoke-direct {v3, v1}, Lwf/f;-><init>(Ljava/lang/String;)V

    .line 48
    .line 49
    .line 50
    new-instance v1, Lee/k;

    .line 51
    .line 52
    sget-object v4, Lee/k$a;->a:Lee/k$a;

    .line 53
    .line 54
    invoke-direct {v1, v3, v4}, Lee/k;-><init>(Lwf/n;Lee/k$a;)V

    .line 55
    .line 56
    .line 57
    new-instance v15, Lie/f0;

    .line 58
    .line 59
    new-instance v4, Ljava/lang/StringBuilder;

    .line 60
    .line 61
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 62
    .line 63
    .line 64
    const/16 v5, 0x3c

    .line 65
    .line 66
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 70
    .line 71
    .line 72
    const/16 v0, 0x3e

    .line 73
    .line 74
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 75
    .line 76
    .line 77
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 78
    .line 79
    .line 80
    move-result-object v0

    .line 81
    invoke-static {v0}, Lef/f;->o(Ljava/lang/String;)Lef/f;

    .line 82
    .line 83
    .line 84
    move-result-object v0

    .line 85
    const-string v4, "special(...)"

    .line 86
    .line 87
    invoke-static {v0, v4}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 88
    .line 89
    .line 90
    const/16 v22, 0x38

    .line 91
    .line 92
    const/16 v23, 0x0

    .line 93
    .line 94
    const/16 v19, 0x0

    .line 95
    .line 96
    const/16 v20, 0x0

    .line 97
    .line 98
    const/16 v21, 0x0

    .line 99
    .line 100
    move-object/from16 v16, v0

    .line 101
    .line 102
    move-object/from16 v18, v1

    .line 103
    .line 104
    move-object/from16 v17, v3

    .line 105
    .line 106
    invoke-direct/range {v15 .. v23}, Lie/f0;-><init>(Lef/f;Lwf/n;Lce/i;Lff/a;Ljava/util/Map;Lef/f;ILkotlin/jvm/internal/k;)V

    .line 107
    .line 108
    .line 109
    move-object/from16 v0, v18

    .line 110
    .line 111
    invoke-virtual {v0, v15}, Lce/i;->F0(Lie/f0;)V

    .line 112
    .line 113
    .line 114
    const/4 v1, 0x1

    .line 115
    invoke-virtual {v0, v15, v1}, Lee/k;->N0(Lfe/h0;Z)V

    .line 116
    .line 117
    .line 118
    new-instance v7, Lxe/n;

    .line 119
    .line 120
    invoke-direct {v7}, Lxe/n;-><init>()V

    .line 121
    .line 122
    .line 123
    new-instance v10, Lre/o;

    .line 124
    .line 125
    invoke-direct {v10}, Lre/o;-><init>()V

    .line 126
    .line 127
    .line 128
    new-instance v4, Lfe/m0;

    .line 129
    .line 130
    invoke-direct {v4, v3, v15}, Lfe/m0;-><init>(Lwf/n;Lfe/h0;)V

    .line 131
    .line 132
    .line 133
    const/16 v12, 0x200

    .line 134
    .line 135
    const/4 v13, 0x0

    .line 136
    const/4 v11, 0x0

    .line 137
    move-object v5, v4

    .line 138
    move-object v4, v3

    .line 139
    move-object v3, v15

    .line 140
    invoke-static/range {v2 .. v13}, Lxe/l;->c(Loe/u;Lfe/h0;Lwf/n;Lfe/m0;Lxe/v;Lxe/n;Ltf/w;Lue/b;Lre/n;Lxe/d0;ILjava/lang/Object;)Lre/j;

    .line 141
    .line 142
    .line 143
    move-result-object v2

    .line 144
    move-object v3, v4

    .line 145
    move-object v4, v5

    .line 146
    sget-object v9, Ldf/e;->i:Ldf/e;

    .line 147
    .line 148
    move-object v5, v2

    .line 149
    move-object v2, v15

    .line 150
    invoke-static/range {v2 .. v9}, Lxe/l;->a(Lfe/h0;Lwf/n;Lfe/m0;Lre/j;Lxe/v;Lxe/n;Ltf/w;Ldf/e;)Lxe/k;

    .line 151
    .line 152
    .line 153
    move-result-object v12

    .line 154
    move-object v13, v7

    .line 155
    invoke-virtual {v13, v12}, Lxe/n;->p(Lxe/k;)V

    .line 156
    .line 157
    .line 158
    new-instance v2, Lof/c;

    .line 159
    .line 160
    sget-object v6, Lpe/j;->a:Lpe/j;

    .line 161
    .line 162
    const-string v7, "EMPTY"

    .line 163
    .line 164
    invoke-static {v6, v7}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 165
    .line 166
    .line 167
    invoke-direct {v2, v5, v6}, Lof/c;-><init>(Lre/j;Lpe/j;)V

    .line 168
    .line 169
    .line 170
    invoke-virtual {v10, v2}, Lre/o;->c(Lof/c;)V

    .line 171
    .line 172
    .line 173
    move-object v5, v2

    .line 174
    new-instance v2, Lee/w;

    .line 175
    .line 176
    invoke-virtual {v0}, Lee/k;->M0()Lee/u;

    .line 177
    .line 178
    .line 179
    move-result-object v7

    .line 180
    invoke-virtual {v0}, Lee/k;->M0()Lee/u;

    .line 181
    .line 182
    .line 183
    move-result-object v8

    .line 184
    sget-object v9, Ltf/o$a;->a:Ltf/o$a;

    .line 185
    .line 186
    sget-object v0, Lyf/p;->b:Lyf/p$a;

    .line 187
    .line 188
    invoke-virtual {v0}, Lyf/p$a;->a()Lyf/q;

    .line 189
    .line 190
    .line 191
    move-result-object v10

    .line 192
    new-instance v11, Lpf/b;

    .line 193
    .line 194
    invoke-static {}, Ldd/r;->k()Ljava/util/List;

    .line 195
    .line 196
    .line 197
    move-result-object v0

    .line 198
    invoke-direct {v11, v3, v0}, Lpf/b;-><init>(Lwf/n;Ljava/lang/Iterable;)V

    .line 199
    .line 200
    .line 201
    move-object v6, v4

    .line 202
    move-object v0, v5

    .line 203
    move-object v4, v14

    .line 204
    move-object v5, v15

    .line 205
    invoke-direct/range {v2 .. v11}, Lee/w;-><init>(Lwf/n;Lxe/v;Lfe/h0;Lfe/m0;Lhe/a;Lhe/c;Ltf/o;Lyf/p;Lpf/a;)V

    .line 206
    .line 207
    .line 208
    filled-new-array {v15}, [Lie/f0;

    .line 209
    .line 210
    .line 211
    move-result-object v3

    .line 212
    invoke-virtual {v15, v3}, Lie/f0;->W0([Lie/f0;)V

    .line 213
    .line 214
    .line 215
    new-instance v3, Lie/l;

    .line 216
    .line 217
    invoke-virtual {v0}, Lof/c;->a()Lre/j;

    .line 218
    .line 219
    .line 220
    move-result-object v0

    .line 221
    const/4 v4, 0x2

    .line 222
    new-array v4, v4, [Lfe/t0;

    .line 223
    .line 224
    const/4 v5, 0x0

    .line 225
    aput-object v0, v4, v5

    .line 226
    .line 227
    aput-object v2, v4, v1

    .line 228
    .line 229
    invoke-static {v4}, Ldd/r;->n([Ljava/lang/Object;)Ljava/util/List;

    .line 230
    .line 231
    .line 232
    move-result-object v0

    .line 233
    new-instance v1, Ljava/lang/StringBuilder;

    .line 234
    .line 235
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 236
    .line 237
    .line 238
    const-string v2, "CompositeProvider@RuntimeModuleData for "

    .line 239
    .line 240
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 241
    .line 242
    .line 243
    invoke-virtual {v1, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 244
    .line 245
    .line 246
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 247
    .line 248
    .line 249
    move-result-object v1

    .line 250
    invoke-direct {v3, v0, v1}, Lie/l;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 251
    .line 252
    .line 253
    invoke-virtual {v15, v3}, Lie/f0;->O0(Lfe/o0;)V

    .line 254
    .line 255
    .line 256
    new-instance v0, Lxe/k$a$a;

    .line 257
    .line 258
    invoke-direct {v0, v12, v13}, Lxe/k$a$a;-><init>(Lxe/k;Lxe/n;)V

    .line 259
    .line 260
    .line 261
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
.end method
