.class public Lio/flutter/embedding/android/KeyboardMap;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/embedding/android/KeyboardMap$TogglingGoal;,
        Lio/flutter/embedding/android/KeyboardMap$PressingGoal;,
        Lio/flutter/embedding/android/KeyboardMap$KeyPair;
    }
.end annotation


# static fields
.field public static final kAndroidPlane:J = 0x1100000000L

.field public static final kUnicodePlane:J = 0x0L

.field public static final kValueMask:J = 0xffffffffL

.field public static final keyCodeToLogical:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field public static final pressingGoals:[Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

.field public static final scanCodeToPhysical:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .line 1
    new-instance v0, Lio/flutter/embedding/android/KeyboardMap$1;

    .line 2
    .line 3
    invoke-direct {v0}, Lio/flutter/embedding/android/KeyboardMap$1;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lio/flutter/embedding/android/KeyboardMap;->scanCodeToPhysical:Ljava/util/HashMap;

    .line 7
    .line 8
    new-instance v0, Lio/flutter/embedding/android/KeyboardMap$2;

    .line 9
    .line 10
    invoke-direct {v0}, Lio/flutter/embedding/android/KeyboardMap$2;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Lio/flutter/embedding/android/KeyboardMap;->keyCodeToLogical:Ljava/util/HashMap;

    .line 14
    .line 15
    new-instance v0, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

    .line 16
    .line 17
    new-instance v1, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 18
    .line 19
    const-wide/32 v2, 0x700e0

    .line 20
    .line 21
    .line 22
    const-wide v4, 0x200000100L

    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    invoke-direct {v1, v2, v3, v4, v5}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 28
    .line 29
    .line 30
    new-instance v2, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 31
    .line 32
    const-wide/32 v3, 0x700e4

    .line 33
    .line 34
    .line 35
    const-wide v5, 0x200000101L

    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    invoke-direct {v2, v3, v4, v5, v6}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 41
    .line 42
    .line 43
    filled-new-array {v1, v2}, [Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 44
    .line 45
    .line 46
    move-result-object v1

    .line 47
    const/16 v2, 0x1000

    .line 48
    .line 49
    invoke-direct {v0, v2, v1}, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;-><init>(I[Lio/flutter/embedding/android/KeyboardMap$KeyPair;)V

    .line 50
    .line 51
    .line 52
    new-instance v1, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

    .line 53
    .line 54
    new-instance v2, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 55
    .line 56
    const-wide/32 v3, 0x700e1

    .line 57
    .line 58
    .line 59
    const-wide v5, 0x200000102L

    .line 60
    .line 61
    .line 62
    .line 63
    .line 64
    invoke-direct {v2, v3, v4, v5, v6}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 65
    .line 66
    .line 67
    new-instance v3, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 68
    .line 69
    const-wide/32 v4, 0x700e5

    .line 70
    .line 71
    .line 72
    const-wide v6, 0x200000103L

    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    invoke-direct {v3, v4, v5, v6, v7}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 78
    .line 79
    .line 80
    filled-new-array {v2, v3}, [Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 81
    .line 82
    .line 83
    move-result-object v2

    .line 84
    const/4 v3, 0x1

    .line 85
    invoke-direct {v1, v3, v2}, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;-><init>(I[Lio/flutter/embedding/android/KeyboardMap$KeyPair;)V

    .line 86
    .line 87
    .line 88
    new-instance v2, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

    .line 89
    .line 90
    new-instance v3, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 91
    .line 92
    const-wide/32 v4, 0x700e2

    .line 93
    .line 94
    .line 95
    const-wide v6, 0x200000104L

    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    invoke-direct {v3, v4, v5, v6, v7}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 101
    .line 102
    .line 103
    new-instance v4, Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 104
    .line 105
    const-wide/32 v5, 0x700e6

    .line 106
    .line 107
    .line 108
    const-wide v7, 0x200000105L

    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    invoke-direct {v4, v5, v6, v7, v8}, Lio/flutter/embedding/android/KeyboardMap$KeyPair;-><init>(JJ)V

    .line 114
    .line 115
    .line 116
    filled-new-array {v3, v4}, [Lio/flutter/embedding/android/KeyboardMap$KeyPair;

    .line 117
    .line 118
    .line 119
    move-result-object v3

    .line 120
    const/4 v4, 0x2

    .line 121
    invoke-direct {v2, v4, v3}, Lio/flutter/embedding/android/KeyboardMap$PressingGoal;-><init>(I[Lio/flutter/embedding/android/KeyboardMap$KeyPair;)V

    .line 122
    .line 123
    .line 124
    filled-new-array {v0, v1, v2}, [Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

    .line 125
    .line 126
    .line 127
    move-result-object v0

    .line 128
    sput-object v0, Lio/flutter/embedding/android/KeyboardMap;->pressingGoals:[Lio/flutter/embedding/android/KeyboardMap$PressingGoal;

    .line 129
    .line 130
    return-void
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
.end method

.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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

.method public static getTogglingGoals()[Lio/flutter/embedding/android/KeyboardMap$TogglingGoal;
    .locals 6

    .line 1
    new-instance v0, Lio/flutter/embedding/android/KeyboardMap$TogglingGoal;

    .line 2
    .line 3
    const-wide/32 v2, 0x70039

    .line 4
    .line 5
    .line 6
    const-wide v4, 0x100000104L

    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    const/high16 v1, 0x100000

    .line 12
    .line 13
    invoke-direct/range {v0 .. v5}, Lio/flutter/embedding/android/KeyboardMap$TogglingGoal;-><init>(IJJ)V

    .line 14
    .line 15
    .line 16
    filled-new-array {v0}, [Lio/flutter/embedding/android/KeyboardMap$TogglingGoal;

    .line 17
    .line 18
    .line 19
    move-result-object v0

    .line 20
    return-object v0
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
.end method
