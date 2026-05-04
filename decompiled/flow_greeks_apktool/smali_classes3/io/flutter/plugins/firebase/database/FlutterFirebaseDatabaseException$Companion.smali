.class public final Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\t\u00a2\u0006\u0004\u0008\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0018\u00010\u000cj\u0004\u0018\u0001`\r\u00a2\u0006\u0004\u0008\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\u0004\u0008\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\u0008\u0010\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\u0008\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\u0008\u0018\u0010\u0016\u00a8\u0006\u0019"
    }
    d2 = {
        "Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;",
        "",
        "<init>",
        "()V",
        "Le8/c;",
        "e",
        "Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "fromDatabaseError",
        "(Le8/c;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "Le8/d;",
        "fromDatabaseException",
        "(Le8/d;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "Ljava/lang/Exception;",
        "Lkotlin/Exception;",
        "fromException",
        "(Ljava/lang/Exception;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "unknown",
        "()Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "",
        "errorMessage",
        "(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;",
        "UNKNOWN_ERROR_CODE",
        "Ljava/lang/String;",
        "UNKNOWN_ERROR_MESSAGE",
        "MODULE",
        "firebase_database_release"
    }
    k = 0x1
    mv = {
        0x2,
        0x1,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/k;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final fromDatabaseError(Le8/c;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
    .locals 4

    .line 1
    const-string v0, "e"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-virtual {p1}, Le8/c;->f()I

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    const/16 v1, -0x19

    .line 11
    .line 12
    const-string v2, "An unknown error occurred"

    .line 13
    .line 14
    const-string v3, "unknown"

    .line 15
    .line 16
    if-eq v0, v1, :cond_5

    .line 17
    .line 18
    const/16 v1, -0x18

    .line 19
    .line 20
    if-eq v0, v1, :cond_4

    .line 21
    .line 22
    const/4 v1, -0x4

    .line 23
    if-eq v0, v1, :cond_3

    .line 24
    .line 25
    const/4 v1, -0x3

    .line 26
    if-eq v0, v1, :cond_2

    .line 27
    .line 28
    const/4 v1, -0x2

    .line 29
    if-eq v0, v1, :cond_1

    .line 30
    .line 31
    const/4 v1, -0x1

    .line 32
    if-eq v0, v1, :cond_0

    .line 33
    .line 34
    packed-switch v0, :pswitch_data_0

    .line 35
    .line 36
    .line 37
    invoke-static {v3, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 38
    .line 39
    .line 40
    move-result-object v0

    .line 41
    goto :goto_0

    .line 42
    :pswitch_0
    const-string v0, "expired-token"

    .line 43
    .line 44
    const-string v1, "The supplied auth token has expired."

    .line 45
    .line 46
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 47
    .line 48
    .line 49
    move-result-object v0

    .line 50
    goto :goto_0

    .line 51
    :pswitch_1
    const-string v0, "invalid-token"

    .line 52
    .line 53
    const-string v1, "The supplied auth token was invalid."

    .line 54
    .line 55
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 56
    .line 57
    .line 58
    move-result-object v0

    .line 59
    goto :goto_0

    .line 60
    :pswitch_2
    const-string v0, "max-retries"

    .line 61
    .line 62
    const-string v1, "The transaction had too many retries."

    .line 63
    .line 64
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 65
    .line 66
    .line 67
    move-result-object v0

    .line 68
    goto :goto_0

    .line 69
    :pswitch_3
    const-string v0, "overridden-by-set"

    .line 70
    .line 71
    const-string v1, "The transaction was overridden by a subsequent set."

    .line 72
    .line 73
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 74
    .line 75
    .line 76
    move-result-object v0

    .line 77
    goto :goto_0

    .line 78
    :pswitch_4
    const-string v0, "unavailable"

    .line 79
    .line 80
    const-string v1, "The service is unavailable."

    .line 81
    .line 82
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    goto :goto_0

    .line 87
    :cond_0
    const-string v0, "data-stale"

    .line 88
    .line 89
    const-string v1, "The transaction needs to be run again with current data."

    .line 90
    .line 91
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 92
    .line 93
    .line 94
    move-result-object v0

    .line 95
    goto :goto_0

    .line 96
    :cond_1
    const-string v0, "failure"

    .line 97
    .line 98
    const-string v1, "The server indicated that this operation failed."

    .line 99
    .line 100
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 101
    .line 102
    .line 103
    move-result-object v0

    .line 104
    goto :goto_0

    .line 105
    :cond_2
    const-string v0, "permission-denied"

    .line 106
    .line 107
    const-string v1, "Client doesn\'t have permission to access the desired data."

    .line 108
    .line 109
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 110
    .line 111
    .line 112
    move-result-object v0

    .line 113
    goto :goto_0

    .line 114
    :cond_3
    const-string v0, "disconnected"

    .line 115
    .line 116
    const-string v1, "The operation had to be aborted due to a network disconnect."

    .line 117
    .line 118
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 119
    .line 120
    .line 121
    move-result-object v0

    .line 122
    goto :goto_0

    .line 123
    :cond_4
    const-string v0, "network-error"

    .line 124
    .line 125
    const-string v1, "The operation could not be performed due to a network error."

    .line 126
    .line 127
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 128
    .line 129
    .line 130
    move-result-object v0

    .line 131
    goto :goto_0

    .line 132
    :cond_5
    const-string v0, "write-cancelled"

    .line 133
    .line 134
    const-string v1, "The write was canceled by the user."

    .line 135
    .line 136
    invoke-static {v0, v1}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 137
    .line 138
    .line 139
    move-result-object v0

    .line 140
    :goto_0
    invoke-virtual {v0}, Lcd/q;->a()Ljava/lang/Object;

    .line 141
    .line 142
    .line 143
    move-result-object v1

    .line 144
    check-cast v1, Ljava/lang/String;

    .line 145
    .line 146
    invoke-virtual {v0}, Lcd/q;->b()Ljava/lang/Object;

    .line 147
    .line 148
    .line 149
    move-result-object v0

    .line 150
    check-cast v0, Ljava/lang/String;

    .line 151
    .line 152
    invoke-static {v1, v3}, Lkotlin/jvm/internal/t;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 153
    .line 154
    .line 155
    move-result v3

    .line 156
    if-eqz v3, :cond_7

    .line 157
    .line 158
    invoke-virtual {p1}, Le8/c;->h()Ljava/lang/String;

    .line 159
    .line 160
    .line 161
    move-result-object p1

    .line 162
    if-nez p1, :cond_6

    .line 163
    .line 164
    goto :goto_1

    .line 165
    :cond_6
    move-object v2, p1

    .line 166
    :goto_1
    invoke-virtual {p0, v2}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;->unknown(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    .line 167
    .line 168
    .line 169
    move-result-object p1

    .line 170
    return-object p1

    .line 171
    :cond_7
    new-instance v2, Ljava/util/LinkedHashMap;

    .line 172
    .line 173
    invoke-direct {v2}, Ljava/util/LinkedHashMap;-><init>()V

    .line 174
    .line 175
    .line 176
    invoke-virtual {p1}, Le8/c;->g()Ljava/lang/String;

    .line 177
    .line 178
    .line 179
    move-result-object p1

    .line 180
    const-string v3, "getDetails(...)"

    .line 181
    .line 182
    invoke-static {p1, v3}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 183
    .line 184
    .line 185
    const-string v3, "details"

    .line 186
    .line 187
    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    .line 189
    .line 190
    new-instance p1, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    .line 191
    .line 192
    invoke-direct {p1, v1, v0, v2}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 193
    .line 194
    .line 195
    return-object p1

    .line 196
    nop

    .line 197
    :pswitch_data_0
    .packed-switch -0xa
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
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

.method public final fromDatabaseException(Le8/d;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
    .locals 1

    .line 1
    const-string v0, "e"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-static {p1}, Le8/c;->b(Ljava/lang/Throwable;)Le8/c;

    .line 7
    .line 8
    .line 9
    move-result-object p1

    .line 10
    const-string v0, "fromException(...)"

    .line 11
    .line 12
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->e(Ljava/lang/Object;Ljava/lang/String;)V

    .line 13
    .line 14
    .line 15
    invoke-virtual {p0, p1}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;->fromDatabaseError(Le8/c;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    return-object p1
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public final fromException(Ljava/lang/Exception;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
    .locals 0

    .line 1
    if-nez p1, :cond_0

    .line 2
    .line 3
    invoke-virtual {p0}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;->unknown()Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1

    .line 8
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    .line 9
    .line 10
    .line 11
    move-result-object p1

    .line 12
    if-nez p1, :cond_1

    .line 13
    .line 14
    const-string p1, "An unknown error occurred"

    .line 15
    .line 16
    :cond_1
    invoke-virtual {p0, p1}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;->unknown(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    .line 17
    .line 18
    .line 19
    move-result-object p1

    .line 20
    return-object p1
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public final unknown()Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
    .locals 1

    const/4 v0, 0x0

    .line 1
    invoke-virtual {p0, v0}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException$Companion;->unknown(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    move-result-object v0

    return-object v0
.end method

.method public final unknown(Ljava/lang/String;)Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;
    .locals 8

    .line 2
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 3
    const-string v1, "An unknown error occurred"

    if-nez p1, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    move-object v2, p1

    .line 4
    :goto_0
    const-string p1, "Index not defined, add \".indexOn\""

    const/4 v3, 0x0

    const/4 v4, 0x2

    const/4 v5, 0x0

    invoke-static {v2, p1, v3, v4, v5}, Lkg/c0;->P(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z

    move-result p1

    const/4 v6, 0x1

    if-ne p1, v6, :cond_2

    const/4 v6, 0x4

    const/4 v7, 0x0

    .line 5
    const-string v3, "java.lang.Exception: "

    const-string v4, ""

    const/4 v5, 0x0

    invoke-static/range {v2 .. v7}, Lkg/z;->H(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object p1

    if-nez p1, :cond_1

    goto :goto_1

    :cond_1
    move-object v1, p1

    :goto_1
    const-string p1, "index-not-defined"

    move-object v2, v1

    goto :goto_3

    .line 6
    :cond_2
    const-string p1, "Permission denied"

    invoke-static {v2, p1, v3, v4, v5}, Lkg/c0;->P(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z

    move-result p1

    if-ne p1, v6, :cond_3

    goto :goto_2

    :cond_3
    const-string p1, "Client doesn\'t have permission"

    invoke-static {v2, p1, v3, v4, v5}, Lkg/c0;->P(Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z

    move-result p1

    if-ne p1, v6, :cond_4

    .line 7
    :goto_2
    const-string p1, "permission-denied"

    const-string v2, "Client doesn\'t have permission to access the desired data."

    goto :goto_3

    .line 8
    :cond_4
    const-string p1, "unknown"

    .line 9
    :goto_3
    new-instance v1, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;

    invoke-direct {v1, p1, v2, v0}, Lio/flutter/plugins/firebase/database/FlutterFirebaseDatabaseException;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    return-object v1
.end method
