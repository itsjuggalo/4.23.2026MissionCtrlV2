.class public final Lac/i;
.super Lrb/s0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lrb/s0;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
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


# virtual methods
.method public a(Lrb/r0$e;)Lrb/r0;
    .locals 2

    .line 1
    new-instance v0, Lac/h;

    .line 2
    .line 3
    sget-object v1, Ltb/q2;->a:Ltb/q2;

    .line 4
    .line 5
    invoke-direct {v0, p1, v1}, Lac/h;-><init>(Lrb/r0$e;Ltb/q2;)V

    .line 6
    .line 7
    .line 8
    return-object v0
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

.method public b()Ljava/lang/String;
    .locals 1

    .line 1
    const-string v0, "outlier_detection_experimental"

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

.method public c()I
    .locals 1

    .line 1
    const/4 v0, 0x5

    .line 2
    return v0
    .line 3
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

.method public d()Z
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    return v0
    .line 3
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

.method public e(Ljava/util/Map;)Lrb/b1$b;
    .locals 2

    .line 1
    :try_start_0
    invoke-virtual {p0, p1}, Lac/i;->f(Ljava/util/Map;)Lrb/b1$b;

    .line 2
    .line 3
    .line 4
    move-result-object p1
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 5
    return-object p1

    .line 6
    :catch_0
    move-exception p1

    .line 7
    sget-object v0, Lrb/k1;->t:Lrb/k1;

    .line 8
    .line 9
    invoke-virtual {v0, p1}, Lrb/k1;->q(Ljava/lang/Throwable;)Lrb/k1;

    .line 10
    .line 11
    .line 12
    move-result-object p1

    .line 13
    new-instance v0, Ljava/lang/StringBuilder;

    .line 14
    .line 15
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 16
    .line 17
    .line 18
    const-string v1, "Failed parsing configuration for "

    .line 19
    .line 20
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    invoke-virtual {p0}, Lac/i;->b()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object v1

    .line 27
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 28
    .line 29
    .line 30
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 31
    .line 32
    .line 33
    move-result-object v0

    .line 34
    invoke-virtual {p1, v0}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 35
    .line 36
    .line 37
    move-result-object p1

    .line 38
    invoke-static {p1}, Lrb/b1$b;->b(Lrb/k1;)Lrb/b1$b;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    return-object p1
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

.method public final f(Ljava/util/Map;)Lrb/b1$b;
    .locals 9

    .line 1
    const-string v0, "interval"

    .line 2
    .line 3
    invoke-static {p1, v0}, Ltb/b1;->l(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Long;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    const-string v1, "baseEjectionTime"

    .line 8
    .line 9
    invoke-static {p1, v1}, Ltb/b1;->l(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Long;

    .line 10
    .line 11
    .line 12
    move-result-object v1

    .line 13
    const-string v2, "maxEjectionTime"

    .line 14
    .line 15
    invoke-static {p1, v2}, Ltb/b1;->l(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Long;

    .line 16
    .line 17
    .line 18
    move-result-object v2

    .line 19
    const-string v3, "maxEjectionPercentage"

    .line 20
    .line 21
    invoke-static {p1, v3}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 22
    .line 23
    .line 24
    move-result-object v3

    .line 25
    new-instance v4, Lac/h$g$a;

    .line 26
    .line 27
    invoke-direct {v4}, Lac/h$g$a;-><init>()V

    .line 28
    .line 29
    .line 30
    if-eqz v0, :cond_0

    .line 31
    .line 32
    invoke-virtual {v4, v0}, Lac/h$g$a;->e(Ljava/lang/Long;)Lac/h$g$a;

    .line 33
    .line 34
    .line 35
    :cond_0
    if-eqz v1, :cond_1

    .line 36
    .line 37
    invoke-virtual {v4, v1}, Lac/h$g$a;->b(Ljava/lang/Long;)Lac/h$g$a;

    .line 38
    .line 39
    .line 40
    :cond_1
    if-eqz v2, :cond_2

    .line 41
    .line 42
    invoke-virtual {v4, v2}, Lac/h$g$a;->g(Ljava/lang/Long;)Lac/h$g$a;

    .line 43
    .line 44
    .line 45
    :cond_2
    if-eqz v3, :cond_3

    .line 46
    .line 47
    invoke-virtual {v4, v3}, Lac/h$g$a;->f(Ljava/lang/Integer;)Lac/h$g$a;

    .line 48
    .line 49
    .line 50
    :cond_3
    const-string v0, "successRateEjection"

    .line 51
    .line 52
    invoke-static {p1, v0}, Ltb/b1;->j(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;

    .line 53
    .line 54
    .line 55
    move-result-object v0

    .line 56
    const-string v1, "requestVolume"

    .line 57
    .line 58
    const-string v2, "minimumHosts"

    .line 59
    .line 60
    const-string v3, "enforcementPercentage"

    .line 61
    .line 62
    if-eqz v0, :cond_8

    .line 63
    .line 64
    new-instance v5, Lac/h$g$c$a;

    .line 65
    .line 66
    invoke-direct {v5}, Lac/h$g$c$a;-><init>()V

    .line 67
    .line 68
    .line 69
    const-string v6, "stdevFactor"

    .line 70
    .line 71
    invoke-static {v0, v6}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 72
    .line 73
    .line 74
    move-result-object v6

    .line 75
    invoke-static {v0, v3}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 76
    .line 77
    .line 78
    move-result-object v7

    .line 79
    invoke-static {v0, v2}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 80
    .line 81
    .line 82
    move-result-object v8

    .line 83
    invoke-static {v0, v1}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 84
    .line 85
    .line 86
    move-result-object v0

    .line 87
    if-eqz v6, :cond_4

    .line 88
    .line 89
    invoke-virtual {v5, v6}, Lac/h$g$c$a;->e(Ljava/lang/Integer;)Lac/h$g$c$a;

    .line 90
    .line 91
    .line 92
    :cond_4
    if-eqz v7, :cond_5

    .line 93
    .line 94
    invoke-virtual {v5, v7}, Lac/h$g$c$a;->b(Ljava/lang/Integer;)Lac/h$g$c$a;

    .line 95
    .line 96
    .line 97
    :cond_5
    if-eqz v8, :cond_6

    .line 98
    .line 99
    invoke-virtual {v5, v8}, Lac/h$g$c$a;->c(Ljava/lang/Integer;)Lac/h$g$c$a;

    .line 100
    .line 101
    .line 102
    :cond_6
    if-eqz v0, :cond_7

    .line 103
    .line 104
    invoke-virtual {v5, v0}, Lac/h$g$c$a;->d(Ljava/lang/Integer;)Lac/h$g$c$a;

    .line 105
    .line 106
    .line 107
    :cond_7
    invoke-virtual {v5}, Lac/h$g$c$a;->a()Lac/h$g$c;

    .line 108
    .line 109
    .line 110
    move-result-object v0

    .line 111
    invoke-virtual {v4, v0}, Lac/h$g$a;->h(Lac/h$g$c;)Lac/h$g$a;

    .line 112
    .line 113
    .line 114
    :cond_8
    const-string v0, "failurePercentageEjection"

    .line 115
    .line 116
    invoke-static {p1, v0}, Ltb/b1;->j(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;

    .line 117
    .line 118
    .line 119
    move-result-object v0

    .line 120
    if-eqz v0, :cond_d

    .line 121
    .line 122
    new-instance v5, Lac/h$g$b$a;

    .line 123
    .line 124
    invoke-direct {v5}, Lac/h$g$b$a;-><init>()V

    .line 125
    .line 126
    .line 127
    const-string v6, "threshold"

    .line 128
    .line 129
    invoke-static {v0, v6}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 130
    .line 131
    .line 132
    move-result-object v6

    .line 133
    invoke-static {v0, v3}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 134
    .line 135
    .line 136
    move-result-object v3

    .line 137
    invoke-static {v0, v2}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 138
    .line 139
    .line 140
    move-result-object v2

    .line 141
    invoke-static {v0, v1}, Ltb/b1;->i(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Integer;

    .line 142
    .line 143
    .line 144
    move-result-object v0

    .line 145
    if-eqz v6, :cond_9

    .line 146
    .line 147
    invoke-virtual {v5, v6}, Lac/h$g$b$a;->e(Ljava/lang/Integer;)Lac/h$g$b$a;

    .line 148
    .line 149
    .line 150
    :cond_9
    if-eqz v3, :cond_a

    .line 151
    .line 152
    invoke-virtual {v5, v3}, Lac/h$g$b$a;->b(Ljava/lang/Integer;)Lac/h$g$b$a;

    .line 153
    .line 154
    .line 155
    :cond_a
    if-eqz v2, :cond_b

    .line 156
    .line 157
    invoke-virtual {v5, v2}, Lac/h$g$b$a;->c(Ljava/lang/Integer;)Lac/h$g$b$a;

    .line 158
    .line 159
    .line 160
    :cond_b
    if-eqz v0, :cond_c

    .line 161
    .line 162
    invoke-virtual {v5, v0}, Lac/h$g$b$a;->d(Ljava/lang/Integer;)Lac/h$g$b$a;

    .line 163
    .line 164
    .line 165
    :cond_c
    invoke-virtual {v5}, Lac/h$g$b$a;->a()Lac/h$g$b;

    .line 166
    .line 167
    .line 168
    move-result-object v0

    .line 169
    invoke-virtual {v4, v0}, Lac/h$g$a;->d(Lac/h$g$b;)Lac/h$g$a;

    .line 170
    .line 171
    .line 172
    :cond_d
    const-string v0, "childPolicy"

    .line 173
    .line 174
    invoke-static {p1, v0}, Ltb/b1;->f(Ljava/util/Map;Ljava/lang/String;)Ljava/util/List;

    .line 175
    .line 176
    .line 177
    move-result-object v0

    .line 178
    invoke-static {v0}, Ltb/j2;->A(Ljava/util/List;)Ljava/util/List;

    .line 179
    .line 180
    .line 181
    move-result-object v0

    .line 182
    if-eqz v0, :cond_10

    .line 183
    .line 184
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    .line 185
    .line 186
    .line 187
    move-result v1

    .line 188
    if-eqz v1, :cond_e

    .line 189
    .line 190
    goto :goto_0

    .line 191
    :cond_e
    invoke-static {}, Lrb/t0;->b()Lrb/t0;

    .line 192
    .line 193
    .line 194
    move-result-object p1

    .line 195
    invoke-static {v0, p1}, Ltb/j2;->y(Ljava/util/List;Lrb/t0;)Lrb/b1$b;

    .line 196
    .line 197
    .line 198
    move-result-object p1

    .line 199
    invoke-virtual {p1}, Lrb/b1$b;->d()Lrb/k1;

    .line 200
    .line 201
    .line 202
    move-result-object v0

    .line 203
    if-eqz v0, :cond_f

    .line 204
    .line 205
    return-object p1

    .line 206
    :cond_f
    invoke-virtual {p1}, Lrb/b1$b;->c()Ljava/lang/Object;

    .line 207
    .line 208
    .line 209
    move-result-object p1

    .line 210
    check-cast p1, Ltb/j2$b;

    .line 211
    .line 212
    invoke-virtual {v4, p1}, Lac/h$g$a;->c(Ltb/j2$b;)Lac/h$g$a;

    .line 213
    .line 214
    .line 215
    invoke-virtual {v4}, Lac/h$g$a;->a()Lac/h$g;

    .line 216
    .line 217
    .line 218
    move-result-object p1

    .line 219
    invoke-static {p1}, Lrb/b1$b;->a(Ljava/lang/Object;)Lrb/b1$b;

    .line 220
    .line 221
    .line 222
    move-result-object p1

    .line 223
    return-object p1

    .line 224
    :cond_10
    :goto_0
    sget-object v0, Lrb/k1;->s:Lrb/k1;

    .line 225
    .line 226
    new-instance v1, Ljava/lang/StringBuilder;

    .line 227
    .line 228
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 229
    .line 230
    .line 231
    const-string v2, "No child policy in outlier_detection_experimental LB policy: "

    .line 232
    .line 233
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 234
    .line 235
    .line 236
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 237
    .line 238
    .line 239
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 240
    .line 241
    .line 242
    move-result-object p1

    .line 243
    invoke-virtual {v0, p1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 244
    .line 245
    .line 246
    move-result-object p1

    .line 247
    invoke-static {p1}, Lrb/b1$b;->b(Lrb/k1;)Lrb/b1$b;

    .line 248
    .line 249
    .line 250
    move-result-object p1

    .line 251
    return-object p1
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
