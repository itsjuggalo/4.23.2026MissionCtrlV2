.class public Ltb/b2$s;
.super Lrb/k;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/b2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "s"
.end annotation


# instance fields
.field public final b:Ltb/b2$c0;

.field public c:J

.field public final synthetic d:Ltb/b2;


# direct methods
.method public constructor <init>(Ltb/b2;Ltb/b2$c0;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 2
    .line 3
    invoke-direct {p0}, Lrb/k;-><init>()V

    .line 4
    .line 5
    .line 6
    iput-object p2, p0, Ltb/b2$s;->b:Ltb/b2$c0;

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
.method public h(J)V
    .locals 5

    .line 1
    iget-object v0, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v0, v0, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    goto/16 :goto_2

    .line 12
    .line 13
    :cond_0
    iget-object v0, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 14
    .line 15
    invoke-static {v0}, Ltb/b2;->W(Ltb/b2;)Ljava/lang/Object;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    monitor-enter v0

    .line 20
    :try_start_0
    iget-object v1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 21
    .line 22
    invoke-static {v1}, Ltb/b2;->K(Ltb/b2;)Ltb/b2$a0;

    .line 23
    .line 24
    .line 25
    move-result-object v1

    .line 26
    iget-object v1, v1, Ltb/b2$a0;->f:Ltb/b2$c0;

    .line 27
    .line 28
    if-nez v1, :cond_7

    .line 29
    .line 30
    iget-object v1, p0, Ltb/b2$s;->b:Ltb/b2$c0;

    .line 31
    .line 32
    iget-boolean v1, v1, Ltb/b2$c0;->b:Z

    .line 33
    .line 34
    if-eqz v1, :cond_1

    .line 35
    .line 36
    goto :goto_3

    .line 37
    :cond_1
    iget-wide v1, p0, Ltb/b2$s;->c:J

    .line 38
    .line 39
    add-long/2addr v1, p1

    .line 40
    iput-wide v1, p0, Ltb/b2$s;->c:J

    .line 41
    .line 42
    iget-object p1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 43
    .line 44
    invoke-static {p1}, Ltb/b2;->P(Ltb/b2;)J

    .line 45
    .line 46
    .line 47
    move-result-wide p1

    .line 48
    cmp-long p1, v1, p1

    .line 49
    .line 50
    if-gtz p1, :cond_2

    .line 51
    .line 52
    monitor-exit v0

    .line 53
    return-void

    .line 54
    :catchall_0
    move-exception p1

    .line 55
    goto :goto_4

    .line 56
    :cond_2
    iget-wide p1, p0, Ltb/b2$s;->c:J

    .line 57
    .line 58
    iget-object v1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 59
    .line 60
    invoke-static {v1}, Ltb/b2;->R(Ltb/b2;)J

    .line 61
    .line 62
    .line 63
    move-result-wide v1

    .line 64
    cmp-long p1, p1, v1

    .line 65
    .line 66
    const/4 p2, 0x1

    .line 67
    if-lez p1, :cond_3

    .line 68
    .line 69
    iget-object p1, p0, Ltb/b2$s;->b:Ltb/b2$c0;

    .line 70
    .line 71
    iput-boolean p2, p1, Ltb/b2$c0;->c:Z

    .line 72
    .line 73
    goto :goto_0

    .line 74
    :cond_3
    iget-object p1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 75
    .line 76
    invoke-static {p1}, Ltb/b2;->S(Ltb/b2;)Ltb/b2$t;

    .line 77
    .line 78
    .line 79
    move-result-object p1

    .line 80
    iget-wide v1, p0, Ltb/b2$s;->c:J

    .line 81
    .line 82
    iget-object v3, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 83
    .line 84
    invoke-static {v3}, Ltb/b2;->P(Ltb/b2;)J

    .line 85
    .line 86
    .line 87
    move-result-wide v3

    .line 88
    sub-long/2addr v1, v3

    .line 89
    invoke-virtual {p1, v1, v2}, Ltb/b2$t;->a(J)J

    .line 90
    .line 91
    .line 92
    move-result-wide v1

    .line 93
    iget-object p1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 94
    .line 95
    iget-wide v3, p0, Ltb/b2$s;->c:J

    .line 96
    .line 97
    invoke-static {p1, v3, v4}, Ltb/b2;->Q(Ltb/b2;J)J

    .line 98
    .line 99
    .line 100
    iget-object p1, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 101
    .line 102
    invoke-static {p1}, Ltb/b2;->T(Ltb/b2;)J

    .line 103
    .line 104
    .line 105
    move-result-wide v3

    .line 106
    cmp-long p1, v1, v3

    .line 107
    .line 108
    if-lez p1, :cond_4

    .line 109
    .line 110
    iget-object p1, p0, Ltb/b2$s;->b:Ltb/b2$c0;

    .line 111
    .line 112
    iput-boolean p2, p1, Ltb/b2$c0;->c:Z

    .line 113
    .line 114
    :cond_4
    :goto_0
    iget-object p1, p0, Ltb/b2$s;->b:Ltb/b2$c0;

    .line 115
    .line 116
    iget-boolean p2, p1, Ltb/b2$c0;->c:Z

    .line 117
    .line 118
    if-eqz p2, :cond_5

    .line 119
    .line 120
    iget-object p2, p0, Ltb/b2$s;->d:Ltb/b2;

    .line 121
    .line 122
    invoke-static {p2, p1}, Ltb/b2;->U(Ltb/b2;Ltb/b2$c0;)Ljava/lang/Runnable;

    .line 123
    .line 124
    .line 125
    move-result-object p1

    .line 126
    goto :goto_1

    .line 127
    :cond_5
    const/4 p1, 0x0

    .line 128
    :goto_1
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    if-eqz p1, :cond_6

    .line 130
    .line 131
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 132
    .line 133
    .line 134
    :cond_6
    :goto_2
    return-void

    .line 135
    :cond_7
    :goto_3
    :try_start_1
    monitor-exit v0

    .line 136
    return-void

    .line 137
    :goto_4
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 138
    throw p1
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
