.class public final Lcom/google/firebase/sessions/a$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/firebase/sessions/b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/firebase/sessions/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "c"
.end annotation


# instance fields
.field public final a:Lcom/google/firebase/sessions/a$c;

.field public b:Lwa/e;

.field public c:Lwa/e;

.field public d:Lwa/e;

.field public e:Lwa/e;

.field public f:Lwa/e;

.field public g:Lwa/e;

.field public h:Lwa/e;

.field public i:Lwa/e;

.field public j:Lwa/e;

.field public k:Lwa/e;

.field public l:Lwa/e;

.field public m:Lwa/e;

.field public n:Lwa/e;

.field public o:Lwa/e;

.field public p:Lwa/e;

.field public q:Lwa/e;

.field public r:Lwa/e;

.field public s:Lwa/e;

.field public t:Lwa/e;

.field public u:Lwa/e;

.field public v:Lwa/e;

.field public w:Lwa/e;

.field public x:Lwa/e;

.field public y:Lwa/e;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lgd/i;Lgd/i;La7/g;Lga/h;Lfa/b;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput-object p0, p0, Lcom/google/firebase/sessions/a$c;->a:Lcom/google/firebase/sessions/a$c;

    .line 4
    invoke-virtual/range {p0 .. p6}, Lcom/google/firebase/sessions/a$c;->c(Landroid/content/Context;Lgd/i;Lgd/i;La7/g;Lga/h;Lfa/b;)V

    return-void
.end method

.method public synthetic constructor <init>(Landroid/content/Context;Lgd/i;Lgd/i;La7/g;Lga/h;Lfa/b;Lcom/google/firebase/sessions/a$a;)V
    .locals 0

    .line 1
    invoke-direct/range {p0 .. p6}, Lcom/google/firebase/sessions/a$c;-><init>(Landroid/content/Context;Lgd/i;Lgd/i;La7/g;Lga/h;Lfa/b;)V

    return-void
.end method


# virtual methods
.method public a()Lua/l;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/firebase/sessions/a$c;->y:Lwa/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbd/a;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lua/l;

    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public b()Lua/s0;
    .locals 1

    .line 1
    iget-object v0, p0, Lcom/google/firebase/sessions/a$c;->w:Lwa/e;

    .line 2
    .line 3
    invoke-interface {v0}, Lbd/a;->get()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lua/s0;

    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public final c(Landroid/content/Context;Lgd/i;Lgd/i;La7/g;Lga/h;Lfa/b;)V
    .locals 7

    .line 1
    invoke-static {p4}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 2
    .line 3
    .line 4
    move-result-object p4

    .line 5
    iput-object p4, p0, Lcom/google/firebase/sessions/a$c;->b:Lwa/e;

    .line 6
    .line 7
    invoke-static {p1}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 8
    .line 9
    .line 10
    move-result-object p1

    .line 11
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->c:Lwa/e;

    .line 12
    .line 13
    invoke-static {p1}, Lxa/c;->a(Lbd/a;)Lxa/c;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->d:Lwa/e;

    .line 22
    .line 23
    invoke-static {}, Lcom/google/firebase/sessions/f;->a()Lcom/google/firebase/sessions/f;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->e:Lwa/e;

    .line 32
    .line 33
    invoke-static {p5}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 34
    .line 35
    .line 36
    move-result-object p1

    .line 37
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->f:Lwa/e;

    .line 38
    .line 39
    iget-object p1, p0, Lcom/google/firebase/sessions/a$c;->b:Lwa/e;

    .line 40
    .line 41
    invoke-static {p1}, Lcom/google/firebase/sessions/c;->b(Lbd/a;)Lcom/google/firebase/sessions/c;

    .line 42
    .line 43
    .line 44
    move-result-object p1

    .line 45
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 46
    .line 47
    .line 48
    move-result-object p1

    .line 49
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->g:Lwa/e;

    .line 50
    .line 51
    invoke-static {p3}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->h:Lwa/e;

    .line 56
    .line 57
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->g:Lwa/e;

    .line 58
    .line 59
    invoke-static {p3, p1}, Lxa/f;->a(Lbd/a;Lbd/a;)Lxa/f;

    .line 60
    .line 61
    .line 62
    move-result-object p1

    .line 63
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 64
    .line 65
    .line 66
    move-result-object p1

    .line 67
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->i:Lwa/e;

    .line 68
    .line 69
    invoke-static {p2}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 70
    .line 71
    .line 72
    move-result-object p1

    .line 73
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->j:Lwa/e;

    .line 74
    .line 75
    iget-object p1, p0, Lcom/google/firebase/sessions/a$c;->c:Lwa/e;

    .line 76
    .line 77
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->h:Lwa/e;

    .line 78
    .line 79
    invoke-static {p1, p2}, Lcom/google/firebase/sessions/d;->a(Lbd/a;Lbd/a;)Lcom/google/firebase/sessions/d;

    .line 80
    .line 81
    .line 82
    move-result-object p1

    .line 83
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 84
    .line 85
    .line 86
    move-result-object p1

    .line 87
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->k:Lwa/e;

    .line 88
    .line 89
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->j:Lwa/e;

    .line 90
    .line 91
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->e:Lwa/e;

    .line 92
    .line 93
    invoke-static {p2, p3, p1}, Lxa/n;->a(Lbd/a;Lbd/a;Lbd/a;)Lxa/n;

    .line 94
    .line 95
    .line 96
    move-result-object p1

    .line 97
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 98
    .line 99
    .line 100
    move-result-object p1

    .line 101
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->l:Lwa/e;

    .line 102
    .line 103
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->e:Lwa/e;

    .line 104
    .line 105
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->f:Lwa/e;

    .line 106
    .line 107
    iget-object p4, p0, Lcom/google/firebase/sessions/a$c;->g:Lwa/e;

    .line 108
    .line 109
    iget-object p5, p0, Lcom/google/firebase/sessions/a$c;->i:Lwa/e;

    .line 110
    .line 111
    invoke-static {p2, p3, p4, p5, p1}, Lxa/g;->a(Lbd/a;Lbd/a;Lbd/a;Lbd/a;Lbd/a;)Lxa/g;

    .line 112
    .line 113
    .line 114
    move-result-object p1

    .line 115
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 116
    .line 117
    .line 118
    move-result-object p1

    .line 119
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->m:Lwa/e;

    .line 120
    .line 121
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->d:Lwa/e;

    .line 122
    .line 123
    invoke-static {p2, p1}, Lxa/k;->a(Lbd/a;Lbd/a;)Lxa/k;

    .line 124
    .line 125
    .line 126
    move-result-object p1

    .line 127
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 128
    .line 129
    .line 130
    move-result-object p1

    .line 131
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->n:Lwa/e;

    .line 132
    .line 133
    invoke-static {}, Lcom/google/firebase/sessions/g;->a()Lcom/google/firebase/sessions/g;

    .line 134
    .line 135
    .line 136
    move-result-object p1

    .line 137
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 138
    .line 139
    .line 140
    move-result-object p1

    .line 141
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->o:Lwa/e;

    .line 142
    .line 143
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->e:Lwa/e;

    .line 144
    .line 145
    invoke-static {p2, p1}, Lua/o0;->a(Lbd/a;Lbd/a;)Lua/o0;

    .line 146
    .line 147
    .line 148
    move-result-object p1

    .line 149
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 150
    .line 151
    .line 152
    move-result-object p1

    .line 153
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->p:Lwa/e;

    .line 154
    .line 155
    invoke-static {p6}, Lwa/c;->a(Ljava/lang/Object;)Lwa/b;

    .line 156
    .line 157
    .line 158
    move-result-object p1

    .line 159
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->q:Lwa/e;

    .line 160
    .line 161
    invoke-static {p1}, Lua/i;->a(Lbd/a;)Lua/i;

    .line 162
    .line 163
    .line 164
    move-result-object p1

    .line 165
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 166
    .line 167
    .line 168
    move-result-object p1

    .line 169
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->r:Lwa/e;

    .line 170
    .line 171
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->b:Lwa/e;

    .line 172
    .line 173
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->f:Lwa/e;

    .line 174
    .line 175
    iget-object p4, p0, Lcom/google/firebase/sessions/a$c;->n:Lwa/e;

    .line 176
    .line 177
    iget-object p5, p0, Lcom/google/firebase/sessions/a$c;->j:Lwa/e;

    .line 178
    .line 179
    invoke-static {p2, p3, p4, p1, p5}, Lua/m0;->a(Lbd/a;Lbd/a;Lbd/a;Lbd/a;Lbd/a;)Lua/m0;

    .line 180
    .line 181
    .line 182
    move-result-object p1

    .line 183
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 184
    .line 185
    .line 186
    move-result-object p1

    .line 187
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->s:Lwa/e;

    .line 188
    .line 189
    iget-object p1, p0, Lcom/google/firebase/sessions/a$c;->p:Lwa/e;

    .line 190
    .line 191
    invoke-static {p1}, Lua/g0;->a(Lbd/a;)Lua/g0;

    .line 192
    .line 193
    .line 194
    move-result-object p1

    .line 195
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 196
    .line 197
    .line 198
    move-result-object p1

    .line 199
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->t:Lwa/e;

    .line 200
    .line 201
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->c:Lwa/e;

    .line 202
    .line 203
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->h:Lwa/e;

    .line 204
    .line 205
    invoke-static {p2, p3, p1}, Lcom/google/firebase/sessions/e;->a(Lbd/a;Lbd/a;Lbd/a;)Lcom/google/firebase/sessions/e;

    .line 206
    .line 207
    .line 208
    move-result-object p1

    .line 209
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 210
    .line 211
    .line 212
    move-result-object p1

    .line 213
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->u:Lwa/e;

    .line 214
    .line 215
    iget-object p1, p0, Lcom/google/firebase/sessions/a$c;->c:Lwa/e;

    .line 216
    .line 217
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->o:Lwa/e;

    .line 218
    .line 219
    invoke-static {p1, p2}, Lua/b0;->a(Lbd/a;Lbd/a;)Lua/b0;

    .line 220
    .line 221
    .line 222
    move-result-object p1

    .line 223
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 224
    .line 225
    .line 226
    move-result-object v5

    .line 227
    iput-object v5, p0, Lcom/google/firebase/sessions/a$c;->v:Lwa/e;

    .line 228
    .line 229
    iget-object v0, p0, Lcom/google/firebase/sessions/a$c;->n:Lwa/e;

    .line 230
    .line 231
    iget-object v1, p0, Lcom/google/firebase/sessions/a$c;->p:Lwa/e;

    .line 232
    .line 233
    iget-object v2, p0, Lcom/google/firebase/sessions/a$c;->s:Lwa/e;

    .line 234
    .line 235
    iget-object v3, p0, Lcom/google/firebase/sessions/a$c;->e:Lwa/e;

    .line 236
    .line 237
    iget-object v4, p0, Lcom/google/firebase/sessions/a$c;->u:Lwa/e;

    .line 238
    .line 239
    iget-object v6, p0, Lcom/google/firebase/sessions/a$c;->j:Lwa/e;

    .line 240
    .line 241
    invoke-static/range {v0 .. v6}, Lua/u0;->a(Lbd/a;Lbd/a;Lbd/a;Lbd/a;Lbd/a;Lbd/a;Lbd/a;)Lua/u0;

    .line 242
    .line 243
    .line 244
    move-result-object p1

    .line 245
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 246
    .line 247
    .line 248
    move-result-object p1

    .line 249
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->w:Lwa/e;

    .line 250
    .line 251
    invoke-static {p1}, Lua/r0;->a(Lbd/a;)Lua/r0;

    .line 252
    .line 253
    .line 254
    move-result-object p1

    .line 255
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 256
    .line 257
    .line 258
    move-result-object p1

    .line 259
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->x:Lwa/e;

    .line 260
    .line 261
    iget-object p2, p0, Lcom/google/firebase/sessions/a$c;->b:Lwa/e;

    .line 262
    .line 263
    iget-object p3, p0, Lcom/google/firebase/sessions/a$c;->n:Lwa/e;

    .line 264
    .line 265
    iget-object p4, p0, Lcom/google/firebase/sessions/a$c;->j:Lwa/e;

    .line 266
    .line 267
    invoke-static {p2, p3, p4, p1}, Lua/s;->a(Lbd/a;Lbd/a;Lbd/a;Lbd/a;)Lua/s;

    .line 268
    .line 269
    .line 270
    move-result-object p1

    .line 271
    invoke-static {p1}, Lwa/a;->a(Lwa/e;)Lwa/e;

    .line 272
    .line 273
    .line 274
    move-result-object p1

    .line 275
    iput-object p1, p0, Lcom/google/firebase/sessions/a$c;->y:Lwa/e;

    .line 276
    .line 277
    return-void
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
.end method
