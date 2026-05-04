.class public final enum Lhf/v;
.super Ljava/lang/Enum;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lhf/v$a;
    }
.end annotation


# static fields
.field public static final b:Lhf/v$a;

.field public static final c:Ljava/util/Set;

.field public static final d:Ljava/util/Set;

.field public static final enum e:Lhf/v;

.field public static final enum f:Lhf/v;

.field public static final enum g:Lhf/v;

.field public static final enum h:Lhf/v;

.field public static final enum i:Lhf/v;

.field public static final enum j:Lhf/v;

.field public static final enum k:Lhf/v;

.field public static final enum l:Lhf/v;

.field public static final enum m:Lhf/v;

.field public static final enum n:Lhf/v;

.field public static final enum o:Lhf/v;

.field public static final enum p:Lhf/v;

.field public static final enum q:Lhf/v;

.field public static final enum r:Lhf/v;

.field public static final synthetic s:[Lhf/v;

.field public static final synthetic t:Ljd/a;


# instance fields
.field public final a:Z


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 1
    new-instance v0, Lhf/v;

    .line 2
    .line 3
    const-string v1, "VISIBILITY"

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    const/4 v3, 0x1

    .line 7
    invoke-direct {v0, v1, v2, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 8
    .line 9
    .line 10
    sput-object v0, Lhf/v;->e:Lhf/v;

    .line 11
    .line 12
    new-instance v0, Lhf/v;

    .line 13
    .line 14
    const-string v1, "MODALITY"

    .line 15
    .line 16
    invoke-direct {v0, v1, v3, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 17
    .line 18
    .line 19
    sput-object v0, Lhf/v;->f:Lhf/v;

    .line 20
    .line 21
    new-instance v0, Lhf/v;

    .line 22
    .line 23
    const-string v1, "OVERRIDE"

    .line 24
    .line 25
    const/4 v4, 0x2

    .line 26
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 27
    .line 28
    .line 29
    sput-object v0, Lhf/v;->g:Lhf/v;

    .line 30
    .line 31
    new-instance v0, Lhf/v;

    .line 32
    .line 33
    const-string v1, "ANNOTATIONS"

    .line 34
    .line 35
    const/4 v4, 0x3

    .line 36
    invoke-direct {v0, v1, v4, v2}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 37
    .line 38
    .line 39
    sput-object v0, Lhf/v;->h:Lhf/v;

    .line 40
    .line 41
    new-instance v0, Lhf/v;

    .line 42
    .line 43
    const-string v1, "INNER"

    .line 44
    .line 45
    const/4 v4, 0x4

    .line 46
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 47
    .line 48
    .line 49
    sput-object v0, Lhf/v;->i:Lhf/v;

    .line 50
    .line 51
    new-instance v0, Lhf/v;

    .line 52
    .line 53
    const-string v1, "MEMBER_KIND"

    .line 54
    .line 55
    const/4 v4, 0x5

    .line 56
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 57
    .line 58
    .line 59
    sput-object v0, Lhf/v;->j:Lhf/v;

    .line 60
    .line 61
    new-instance v0, Lhf/v;

    .line 62
    .line 63
    const-string v1, "DATA"

    .line 64
    .line 65
    const/4 v4, 0x6

    .line 66
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 67
    .line 68
    .line 69
    sput-object v0, Lhf/v;->k:Lhf/v;

    .line 70
    .line 71
    new-instance v0, Lhf/v;

    .line 72
    .line 73
    const-string v1, "INLINE"

    .line 74
    .line 75
    const/4 v4, 0x7

    .line 76
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 77
    .line 78
    .line 79
    sput-object v0, Lhf/v;->l:Lhf/v;

    .line 80
    .line 81
    new-instance v0, Lhf/v;

    .line 82
    .line 83
    const-string v1, "EXPECT"

    .line 84
    .line 85
    const/16 v4, 0x8

    .line 86
    .line 87
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 88
    .line 89
    .line 90
    sput-object v0, Lhf/v;->m:Lhf/v;

    .line 91
    .line 92
    new-instance v0, Lhf/v;

    .line 93
    .line 94
    const-string v1, "ACTUAL"

    .line 95
    .line 96
    const/16 v4, 0x9

    .line 97
    .line 98
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 99
    .line 100
    .line 101
    sput-object v0, Lhf/v;->n:Lhf/v;

    .line 102
    .line 103
    new-instance v0, Lhf/v;

    .line 104
    .line 105
    const-string v1, "CONST"

    .line 106
    .line 107
    const/16 v4, 0xa

    .line 108
    .line 109
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 110
    .line 111
    .line 112
    sput-object v0, Lhf/v;->o:Lhf/v;

    .line 113
    .line 114
    new-instance v0, Lhf/v;

    .line 115
    .line 116
    const-string v1, "LATEINIT"

    .line 117
    .line 118
    const/16 v4, 0xb

    .line 119
    .line 120
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 121
    .line 122
    .line 123
    sput-object v0, Lhf/v;->p:Lhf/v;

    .line 124
    .line 125
    new-instance v0, Lhf/v;

    .line 126
    .line 127
    const-string v1, "FUN"

    .line 128
    .line 129
    const/16 v4, 0xc

    .line 130
    .line 131
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 132
    .line 133
    .line 134
    sput-object v0, Lhf/v;->q:Lhf/v;

    .line 135
    .line 136
    new-instance v0, Lhf/v;

    .line 137
    .line 138
    const-string v1, "VALUE"

    .line 139
    .line 140
    const/16 v4, 0xd

    .line 141
    .line 142
    invoke-direct {v0, v1, v4, v3}, Lhf/v;-><init>(Ljava/lang/String;IZ)V

    .line 143
    .line 144
    .line 145
    sput-object v0, Lhf/v;->r:Lhf/v;

    .line 146
    .line 147
    invoke-static {}, Lhf/v;->a()[Lhf/v;

    .line 148
    .line 149
    .line 150
    move-result-object v0

    .line 151
    sput-object v0, Lhf/v;->s:[Lhf/v;

    .line 152
    .line 153
    invoke-static {v0}, Ljd/b;->a([Ljava/lang/Enum;)Ljd/a;

    .line 154
    .line 155
    .line 156
    move-result-object v0

    .line 157
    sput-object v0, Lhf/v;->t:Ljd/a;

    .line 158
    .line 159
    new-instance v0, Lhf/v$a;

    .line 160
    .line 161
    const/4 v1, 0x0

    .line 162
    invoke-direct {v0, v1}, Lhf/v$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 163
    .line 164
    .line 165
    sput-object v0, Lhf/v;->b:Lhf/v$a;

    .line 166
    .line 167
    invoke-static {}, Lhf/v;->values()[Lhf/v;

    .line 168
    .line 169
    .line 170
    move-result-object v0

    .line 171
    new-instance v1, Ljava/util/ArrayList;

    .line 172
    .line 173
    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 174
    .line 175
    .line 176
    array-length v3, v0

    .line 177
    :goto_0
    if-ge v2, v3, :cond_1

    .line 178
    .line 179
    aget-object v4, v0, v2

    .line 180
    .line 181
    iget-boolean v5, v4, Lhf/v;->a:Z

    .line 182
    .line 183
    if-eqz v5, :cond_0

    .line 184
    .line 185
    invoke-interface {v1, v4}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 186
    .line 187
    .line 188
    :cond_0
    add-int/lit8 v2, v2, 0x1

    .line 189
    .line 190
    goto :goto_0

    .line 191
    :cond_1
    invoke-static {v1}, Ldd/a0;->N0(Ljava/lang/Iterable;)Ljava/util/Set;

    .line 192
    .line 193
    .line 194
    move-result-object v0

    .line 195
    sput-object v0, Lhf/v;->c:Ljava/util/Set;

    .line 196
    .line 197
    invoke-static {}, Lhf/v;->values()[Lhf/v;

    .line 198
    .line 199
    .line 200
    move-result-object v0

    .line 201
    invoke-static {v0}, Ldd/n;->L0([Ljava/lang/Object;)Ljava/util/Set;

    .line 202
    .line 203
    .line 204
    move-result-object v0

    .line 205
    sput-object v0, Lhf/v;->d:Ljava/util/Set;

    .line 206
    .line 207
    return-void
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
.end method

.method public constructor <init>(Ljava/lang/String;IZ)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 2
    .line 3
    .line 4
    iput-boolean p3, p0, Lhf/v;->a:Z

    .line 5
    .line 6
    return-void
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

.method public static final synthetic a()[Lhf/v;
    .locals 14

    .line 1
    sget-object v0, Lhf/v;->e:Lhf/v;

    .line 2
    .line 3
    sget-object v1, Lhf/v;->f:Lhf/v;

    .line 4
    .line 5
    sget-object v2, Lhf/v;->g:Lhf/v;

    .line 6
    .line 7
    sget-object v3, Lhf/v;->h:Lhf/v;

    .line 8
    .line 9
    sget-object v4, Lhf/v;->i:Lhf/v;

    .line 10
    .line 11
    sget-object v5, Lhf/v;->j:Lhf/v;

    .line 12
    .line 13
    sget-object v6, Lhf/v;->k:Lhf/v;

    .line 14
    .line 15
    sget-object v7, Lhf/v;->l:Lhf/v;

    .line 16
    .line 17
    sget-object v8, Lhf/v;->m:Lhf/v;

    .line 18
    .line 19
    sget-object v9, Lhf/v;->n:Lhf/v;

    .line 20
    .line 21
    sget-object v10, Lhf/v;->o:Lhf/v;

    .line 22
    .line 23
    sget-object v11, Lhf/v;->p:Lhf/v;

    .line 24
    .line 25
    sget-object v12, Lhf/v;->q:Lhf/v;

    .line 26
    .line 27
    sget-object v13, Lhf/v;->r:Lhf/v;

    .line 28
    .line 29
    filled-new-array/range {v0 .. v13}, [Lhf/v;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    return-object v0
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
.end method

.method public static valueOf(Ljava/lang/String;)Lhf/v;
    .locals 1

    .line 1
    const-class v0, Lhf/v;

    .line 2
    .line 3
    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Lhf/v;

    .line 8
    .line 9
    return-object p0
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

.method public static values()[Lhf/v;
    .locals 1

    .line 1
    sget-object v0, Lhf/v;->s:[Lhf/v;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Object;->clone()Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, [Lhf/v;

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
    .line 17
    .line 18
    .line 19
.end method
