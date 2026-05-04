.class public abstract Loe/b0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final a:Lef/c;

.field public static final b:Lef/c;

.field public static final c:Lef/c;

.field public static final d:Lef/c;

.field public static final e:Ljava/lang/String;

.field public static final f:[Lef/c;

.field public static final g:Loe/k0;

.field public static final h:Loe/c0;


# direct methods
.method static constructor <clinit>()V
    .locals 26

    .line 1
    new-instance v0, Lef/c;

    .line 2
    .line 3
    const-string v1, "org.jspecify.nullness"

    .line 4
    .line 5
    invoke-direct {v0, v1}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    sput-object v0, Loe/b0;->a:Lef/c;

    .line 9
    .line 10
    new-instance v1, Lef/c;

    .line 11
    .line 12
    const-string v2, "org.jspecify.annotations"

    .line 13
    .line 14
    invoke-direct {v1, v2}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 15
    .line 16
    .line 17
    sput-object v1, Loe/b0;->b:Lef/c;

    .line 18
    .line 19
    new-instance v2, Lef/c;

    .line 20
    .line 21
    const-string v3, "io.reactivex.rxjava3.annotations"

    .line 22
    .line 23
    invoke-direct {v2, v3}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 24
    .line 25
    .line 26
    sput-object v2, Loe/b0;->c:Lef/c;

    .line 27
    .line 28
    new-instance v3, Lef/c;

    .line 29
    .line 30
    const-string v4, "org.checkerframework.checker.nullness.compatqual"

    .line 31
    .line 32
    invoke-direct {v3, v4}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 33
    .line 34
    .line 35
    sput-object v3, Loe/b0;->d:Lef/c;

    .line 36
    .line 37
    invoke-virtual {v2}, Lef/c;->a()Ljava/lang/String;

    .line 38
    .line 39
    .line 40
    move-result-object v4

    .line 41
    sput-object v4, Loe/b0;->e:Ljava/lang/String;

    .line 42
    .line 43
    new-instance v5, Lef/c;

    .line 44
    .line 45
    new-instance v6, Ljava/lang/StringBuilder;

    .line 46
    .line 47
    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 48
    .line 49
    .line 50
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 51
    .line 52
    .line 53
    const-string v7, ".Nullable"

    .line 54
    .line 55
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 59
    .line 60
    .line 61
    move-result-object v6

    .line 62
    invoke-direct {v5, v6}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 63
    .line 64
    .line 65
    new-instance v6, Lef/c;

    .line 66
    .line 67
    new-instance v7, Ljava/lang/StringBuilder;

    .line 68
    .line 69
    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 70
    .line 71
    .line 72
    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    const-string v4, ".NonNull"

    .line 76
    .line 77
    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    .line 79
    .line 80
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 81
    .line 82
    .line 83
    move-result-object v4

    .line 84
    invoke-direct {v6, v4}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 85
    .line 86
    .line 87
    filled-new-array {v5, v6}, [Lef/c;

    .line 88
    .line 89
    .line 90
    move-result-object v4

    .line 91
    sput-object v4, Loe/b0;->f:[Lef/c;

    .line 92
    .line 93
    new-instance v4, Loe/m0;

    .line 94
    .line 95
    new-instance v5, Lef/c;

    .line 96
    .line 97
    const-string v6, "org.jetbrains.annotations"

    .line 98
    .line 99
    invoke-direct {v5, v6}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 100
    .line 101
    .line 102
    sget-object v6, Loe/c0;->d:Loe/c0$a;

    .line 103
    .line 104
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 105
    .line 106
    .line 107
    move-result-object v7

    .line 108
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 109
    .line 110
    .line 111
    move-result-object v8

    .line 112
    new-instance v5, Lef/c;

    .line 113
    .line 114
    const-string v7, "androidx.annotation"

    .line 115
    .line 116
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 117
    .line 118
    .line 119
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 120
    .line 121
    .line 122
    move-result-object v7

    .line 123
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 124
    .line 125
    .line 126
    move-result-object v9

    .line 127
    new-instance v5, Lef/c;

    .line 128
    .line 129
    const-string v7, "android.support.annotation"

    .line 130
    .line 131
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 132
    .line 133
    .line 134
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 135
    .line 136
    .line 137
    move-result-object v7

    .line 138
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 139
    .line 140
    .line 141
    move-result-object v10

    .line 142
    new-instance v5, Lef/c;

    .line 143
    .line 144
    const-string v7, "android.annotation"

    .line 145
    .line 146
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 147
    .line 148
    .line 149
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 150
    .line 151
    .line 152
    move-result-object v7

    .line 153
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 154
    .line 155
    .line 156
    move-result-object v11

    .line 157
    new-instance v5, Lef/c;

    .line 158
    .line 159
    const-string v7, "com.android.annotations"

    .line 160
    .line 161
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 162
    .line 163
    .line 164
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 165
    .line 166
    .line 167
    move-result-object v7

    .line 168
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 169
    .line 170
    .line 171
    move-result-object v12

    .line 172
    new-instance v5, Lef/c;

    .line 173
    .line 174
    const-string v7, "org.eclipse.jdt.annotation"

    .line 175
    .line 176
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 177
    .line 178
    .line 179
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 180
    .line 181
    .line 182
    move-result-object v7

    .line 183
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 184
    .line 185
    .line 186
    move-result-object v13

    .line 187
    new-instance v5, Lef/c;

    .line 188
    .line 189
    const-string v7, "org.checkerframework.checker.nullness.qual"

    .line 190
    .line 191
    invoke-direct {v5, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 192
    .line 193
    .line 194
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 195
    .line 196
    .line 197
    move-result-object v7

    .line 198
    invoke-static {v5, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 199
    .line 200
    .line 201
    move-result-object v14

    .line 202
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 203
    .line 204
    .line 205
    move-result-object v5

    .line 206
    invoke-static {v3, v5}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 207
    .line 208
    .line 209
    move-result-object v15

    .line 210
    new-instance v3, Lef/c;

    .line 211
    .line 212
    const-string v5, "javax.annotation"

    .line 213
    .line 214
    invoke-direct {v3, v5}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 215
    .line 216
    .line 217
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 218
    .line 219
    .line 220
    move-result-object v5

    .line 221
    invoke-static {v3, v5}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 222
    .line 223
    .line 224
    move-result-object v16

    .line 225
    new-instance v3, Lef/c;

    .line 226
    .line 227
    const-string v5, "edu.umd.cs.findbugs.annotations"

    .line 228
    .line 229
    invoke-direct {v3, v5}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 230
    .line 231
    .line 232
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 233
    .line 234
    .line 235
    move-result-object v5

    .line 236
    invoke-static {v3, v5}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 237
    .line 238
    .line 239
    move-result-object v17

    .line 240
    new-instance v3, Lef/c;

    .line 241
    .line 242
    const-string v5, "io.reactivex.annotations"

    .line 243
    .line 244
    invoke-direct {v3, v5}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 245
    .line 246
    .line 247
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 248
    .line 249
    .line 250
    move-result-object v5

    .line 251
    invoke-static {v3, v5}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 252
    .line 253
    .line 254
    move-result-object v18

    .line 255
    new-instance v3, Lef/c;

    .line 256
    .line 257
    const-string v5, "androidx.annotation.RecentlyNullable"

    .line 258
    .line 259
    invoke-direct {v3, v5}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 260
    .line 261
    .line 262
    new-instance v19, Loe/c0;

    .line 263
    .line 264
    sget-object v21, Loe/o0;->d:Loe/o0;

    .line 265
    .line 266
    const/16 v23, 0x4

    .line 267
    .line 268
    const/16 v24, 0x0

    .line 269
    .line 270
    move-object/from16 v20, v21

    .line 271
    .line 272
    const/16 v21, 0x0

    .line 273
    .line 274
    const/16 v22, 0x0

    .line 275
    .line 276
    invoke-direct/range {v19 .. v24}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;ILkotlin/jvm/internal/k;)V

    .line 277
    .line 278
    .line 279
    move-object/from16 v5, v19

    .line 280
    .line 281
    invoke-static {v3, v5}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 282
    .line 283
    .line 284
    move-result-object v19

    .line 285
    new-instance v3, Lef/c;

    .line 286
    .line 287
    const-string v5, "androidx.annotation.RecentlyNonNull"

    .line 288
    .line 289
    invoke-direct {v3, v5}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 290
    .line 291
    .line 292
    move-object/from16 v21, v20

    .line 293
    .line 294
    new-instance v20, Loe/c0;

    .line 295
    .line 296
    const/16 v24, 0x4

    .line 297
    .line 298
    const/16 v25, 0x0

    .line 299
    .line 300
    const/16 v23, 0x0

    .line 301
    .line 302
    invoke-direct/range {v20 .. v25}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;ILkotlin/jvm/internal/k;)V

    .line 303
    .line 304
    .line 305
    move-object/from16 v7, v20

    .line 306
    .line 307
    move-object/from16 v5, v21

    .line 308
    .line 309
    invoke-static {v3, v7}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 310
    .line 311
    .line 312
    move-result-object v20

    .line 313
    new-instance v3, Lef/c;

    .line 314
    .line 315
    const-string v7, "lombok"

    .line 316
    .line 317
    invoke-direct {v3, v7}, Lef/c;-><init>(Ljava/lang/String;)V

    .line 318
    .line 319
    .line 320
    invoke-virtual {v6}, Loe/c0$a;->a()Loe/c0;

    .line 321
    .line 322
    .line 323
    move-result-object v6

    .line 324
    invoke-static {v3, v6}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 325
    .line 326
    .line 327
    move-result-object v21

    .line 328
    new-instance v3, Loe/c0;

    .line 329
    .line 330
    new-instance v6, Lcd/i;

    .line 331
    .line 332
    const/4 v7, 0x2

    .line 333
    move-object/from16 v22, v8

    .line 334
    .line 335
    const/4 v8, 0x1

    .line 336
    invoke-direct {v6, v7, v8}, Lcd/i;-><init>(II)V

    .line 337
    .line 338
    .line 339
    sget-object v7, Loe/o0;->e:Loe/o0;

    .line 340
    .line 341
    invoke-direct {v3, v5, v6, v7}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;)V

    .line 342
    .line 343
    .line 344
    invoke-static {v0, v3}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 345
    .line 346
    .line 347
    move-result-object v0

    .line 348
    new-instance v3, Loe/c0;

    .line 349
    .line 350
    new-instance v6, Lcd/i;

    .line 351
    .line 352
    move-object/from16 v24, v0

    .line 353
    .line 354
    const/4 v0, 0x2

    .line 355
    invoke-direct {v6, v0, v8}, Lcd/i;-><init>(II)V

    .line 356
    .line 357
    .line 358
    invoke-direct {v3, v5, v6, v7}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;)V

    .line 359
    .line 360
    .line 361
    invoke-static {v1, v3}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 362
    .line 363
    .line 364
    move-result-object v23

    .line 365
    new-instance v0, Loe/c0;

    .line 366
    .line 367
    new-instance v1, Lcd/i;

    .line 368
    .line 369
    const/16 v3, 0x8

    .line 370
    .line 371
    invoke-direct {v1, v8, v3}, Lcd/i;-><init>(II)V

    .line 372
    .line 373
    .line 374
    invoke-direct {v0, v5, v1, v7}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;)V

    .line 375
    .line 376
    .line 377
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 378
    .line 379
    .line 380
    move-result-object v0

    .line 381
    move-object/from16 v8, v22

    .line 382
    .line 383
    move-object/from16 v22, v24

    .line 384
    .line 385
    move-object/from16 v24, v0

    .line 386
    .line 387
    filled-new-array/range {v8 .. v24}, [Lcd/q;

    .line 388
    .line 389
    .line 390
    move-result-object v0

    .line 391
    invoke-static {v0}, Ldd/o0;->l([Lcd/q;)Ljava/util/Map;

    .line 392
    .line 393
    .line 394
    move-result-object v0

    .line 395
    invoke-direct {v4, v0}, Loe/m0;-><init>(Ljava/util/Map;)V

    .line 396
    .line 397
    .line 398
    sput-object v4, Loe/b0;->g:Loe/k0;

    .line 399
    .line 400
    new-instance v20, Loe/c0;

    .line 401
    .line 402
    const/16 v24, 0x4

    .line 403
    .line 404
    const/16 v22, 0x0

    .line 405
    .line 406
    const/16 v23, 0x0

    .line 407
    .line 408
    move-object/from16 v21, v5

    .line 409
    .line 410
    invoke-direct/range {v20 .. v25}, Loe/c0;-><init>(Loe/o0;Lcd/i;Loe/o0;ILkotlin/jvm/internal/k;)V

    .line 411
    .line 412
    .line 413
    sput-object v20, Loe/b0;->h:Loe/c0;

    .line 414
    .line 415
    return-void
    .line 416
    .line 417
    .line 418
.end method

.method public static final a(Lcd/i;)Loe/g0;
    .locals 6

    .line 1
    const-string v0, "configuredKotlinVersion"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Loe/b0;->h:Loe/c0;

    .line 7
    .line 8
    invoke-virtual {v0}, Loe/c0;->d()Lcd/i;

    .line 9
    .line 10
    .line 11
    move-result-object v1

    .line 12
    if-eqz v1, :cond_0

    .line 13
    .line 14
    invoke-virtual {v0}, Loe/c0;->d()Lcd/i;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    invoke-virtual {v1, p0}, Lcd/i;->a(Lcd/i;)I

    .line 19
    .line 20
    .line 21
    move-result p0

    .line 22
    if-gtz p0, :cond_0

    .line 23
    .line 24
    invoke-virtual {v0}, Loe/c0;->b()Loe/o0;

    .line 25
    .line 26
    .line 27
    move-result-object p0

    .line 28
    :goto_0
    move-object v1, p0

    .line 29
    goto :goto_1

    .line 30
    :cond_0
    invoke-virtual {v0}, Loe/c0;->c()Loe/o0;

    .line 31
    .line 32
    .line 33
    move-result-object p0

    .line 34
    goto :goto_0

    .line 35
    :goto_1
    invoke-static {v1}, Loe/b0;->c(Loe/o0;)Loe/o0;

    .line 36
    .line 37
    .line 38
    move-result-object v2

    .line 39
    new-instance v0, Loe/g0;

    .line 40
    .line 41
    const/4 v4, 0x4

    .line 42
    const/4 v5, 0x0

    .line 43
    const/4 v3, 0x0

    .line 44
    invoke-direct/range {v0 .. v5}, Loe/g0;-><init>(Loe/o0;Loe/o0;Ljava/util/Map;ILkotlin/jvm/internal/k;)V

    .line 45
    .line 46
    .line 47
    return-object v0
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

.method public static synthetic b(Lcd/i;ILjava/lang/Object;)Loe/g0;
    .locals 0

    .line 1
    and-int/lit8 p1, p1, 0x1

    .line 2
    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    sget-object p0, Lcd/i;->f:Lcd/i;

    .line 6
    .line 7
    :cond_0
    invoke-static {p0}, Loe/b0;->a(Lcd/i;)Loe/g0;

    .line 8
    .line 9
    .line 10
    move-result-object p0

    .line 11
    return-object p0
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
.end method

.method public static final c(Loe/o0;)Loe/o0;
    .locals 1

    .line 1
    const-string v0, "globalReportLevel"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Loe/o0;->d:Loe/o0;

    .line 7
    .line 8
    if-ne p0, v0, :cond_0

    .line 9
    .line 10
    const/4 p0, 0x0

    .line 11
    :cond_0
    return-object p0
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

.method public static final d(Lef/c;)Loe/o0;
    .locals 3

    .line 1
    const-string v0, "annotationFqName"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Loe/k0;->a:Loe/k0$a;

    .line 7
    .line 8
    invoke-virtual {v0}, Loe/k0$a;->a()Loe/k0;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    const/4 v1, 0x0

    .line 13
    const/4 v2, 0x4

    .line 14
    invoke-static {p0, v0, v1, v2, v1}, Loe/b0;->h(Lef/c;Loe/k0;Lcd/i;ILjava/lang/Object;)Loe/o0;

    .line 15
    .line 16
    .line 17
    move-result-object p0

    .line 18
    return-object p0
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static final e()Lef/c;
    .locals 1

    .line 1
    sget-object v0, Loe/b0;->b:Lef/c;

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

.method public static final f()[Lef/c;
    .locals 1

    .line 1
    sget-object v0, Loe/b0;->f:[Lef/c;

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

.method public static final g(Lef/c;Loe/k0;Lcd/i;)Loe/o0;
    .locals 1

    .line 1
    const-string v0, "annotation"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    const-string v0, "configuredReportLevels"

    .line 7
    .line 8
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 9
    .line 10
    .line 11
    const-string v0, "configuredKotlinVersion"

    .line 12
    .line 13
    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 14
    .line 15
    .line 16
    invoke-interface {p1, p0}, Loe/k0;->a(Lef/c;)Ljava/lang/Object;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    check-cast p1, Loe/o0;

    .line 21
    .line 22
    if-eqz p1, :cond_0

    .line 23
    .line 24
    return-object p1

    .line 25
    :cond_0
    sget-object p1, Loe/b0;->g:Loe/k0;

    .line 26
    .line 27
    invoke-interface {p1, p0}, Loe/k0;->a(Lef/c;)Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object p0

    .line 31
    check-cast p0, Loe/c0;

    .line 32
    .line 33
    if-nez p0, :cond_1

    .line 34
    .line 35
    sget-object p0, Loe/o0;->c:Loe/o0;

    .line 36
    .line 37
    return-object p0

    .line 38
    :cond_1
    invoke-virtual {p0}, Loe/c0;->d()Lcd/i;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    if-eqz p1, :cond_2

    .line 43
    .line 44
    invoke-virtual {p0}, Loe/c0;->d()Lcd/i;

    .line 45
    .line 46
    .line 47
    move-result-object p1

    .line 48
    invoke-virtual {p1, p2}, Lcd/i;->a(Lcd/i;)I

    .line 49
    .line 50
    .line 51
    move-result p1

    .line 52
    if-gtz p1, :cond_2

    .line 53
    .line 54
    invoke-virtual {p0}, Loe/c0;->b()Loe/o0;

    .line 55
    .line 56
    .line 57
    move-result-object p0

    .line 58
    return-object p0

    .line 59
    :cond_2
    invoke-virtual {p0}, Loe/c0;->c()Loe/o0;

    .line 60
    .line 61
    .line 62
    move-result-object p0

    .line 63
    return-object p0
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
.end method

.method public static synthetic h(Lef/c;Loe/k0;Lcd/i;ILjava/lang/Object;)Loe/o0;
    .locals 1

    .line 1
    and-int/lit8 p3, p3, 0x4

    .line 2
    .line 3
    if-eqz p3, :cond_0

    .line 4
    .line 5
    new-instance p2, Lcd/i;

    .line 6
    .line 7
    const/4 p3, 0x7

    .line 8
    const/16 p4, 0x14

    .line 9
    .line 10
    const/4 v0, 0x1

    .line 11
    invoke-direct {p2, v0, p3, p4}, Lcd/i;-><init>(III)V

    .line 12
    .line 13
    .line 14
    :cond_0
    invoke-static {p0, p1, p2}, Loe/b0;->g(Lef/c;Loe/k0;Lcd/i;)Loe/o0;

    .line 15
    .line 16
    .line 17
    move-result-object p0

    .line 18
    return-object p0
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
.end method
