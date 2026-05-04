.class public final Lcom/revenuecat/purchases/hybridcommon/mappers/EntitlementInfoMapperKt;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004\u00a8\u0006\u0005"
    }
    d2 = {
        "map",
        "",
        "",
        "",
        "Lcom/revenuecat/purchases/EntitlementInfo;",
        "hybridcommon_bc8Release"
    }
    k = 0x2
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# direct methods
.method public static final map(Lcom/revenuecat/purchases/EntitlementInfo;)Ljava/util/Map;
    .locals 24
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/revenuecat/purchases/EntitlementInfo;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .line 1
    const-string v0, "<this>"

    .line 2
    .line 3
    move-object/from16 v1, p0

    .line 4
    .line 5
    invoke-static {v1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    const-string v0, "identifier"

    .line 9
    .line 10
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getIdentifier()Ljava/lang/String;

    .line 11
    .line 12
    .line 13
    move-result-object v2

    .line 14
    invoke-static {v0, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 15
    .line 16
    .line 17
    move-result-object v3

    .line 18
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->isActive()Z

    .line 19
    .line 20
    .line 21
    move-result v0

    .line 22
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 23
    .line 24
    .line 25
    move-result-object v0

    .line 26
    const-string v2, "isActive"

    .line 27
    .line 28
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 29
    .line 30
    .line 31
    move-result-object v4

    .line 32
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getWillRenew()Z

    .line 33
    .line 34
    .line 35
    move-result v0

    .line 36
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 37
    .line 38
    .line 39
    move-result-object v0

    .line 40
    const-string v2, "willRenew"

    .line 41
    .line 42
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 43
    .line 44
    .line 45
    move-result-object v5

    .line 46
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getPeriodType()Lcom/revenuecat/purchases/PeriodType;

    .line 47
    .line 48
    .line 49
    move-result-object v0

    .line 50
    invoke-virtual {v0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 51
    .line 52
    .line 53
    move-result-object v0

    .line 54
    const-string v2, "periodType"

    .line 55
    .line 56
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 57
    .line 58
    .line 59
    move-result-object v6

    .line 60
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getLatestPurchaseDate()Ljava/util/Date;

    .line 61
    .line 62
    .line 63
    move-result-object v0

    .line 64
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toMillis(Ljava/util/Date;)J

    .line 65
    .line 66
    .line 67
    move-result-wide v7

    .line 68
    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 69
    .line 70
    .line 71
    move-result-object v0

    .line 72
    const-string v2, "latestPurchaseDateMillis"

    .line 73
    .line 74
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 75
    .line 76
    .line 77
    move-result-object v7

    .line 78
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getLatestPurchaseDate()Ljava/util/Date;

    .line 79
    .line 80
    .line 81
    move-result-object v0

    .line 82
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toIso8601(Ljava/util/Date;)Ljava/lang/String;

    .line 83
    .line 84
    .line 85
    move-result-object v0

    .line 86
    const-string v2, "latestPurchaseDate"

    .line 87
    .line 88
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 89
    .line 90
    .line 91
    move-result-object v8

    .line 92
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getOriginalPurchaseDate()Ljava/util/Date;

    .line 93
    .line 94
    .line 95
    move-result-object v0

    .line 96
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toMillis(Ljava/util/Date;)J

    .line 97
    .line 98
    .line 99
    move-result-wide v9

    .line 100
    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 101
    .line 102
    .line 103
    move-result-object v0

    .line 104
    const-string v2, "originalPurchaseDateMillis"

    .line 105
    .line 106
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 107
    .line 108
    .line 109
    move-result-object v9

    .line 110
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getOriginalPurchaseDate()Ljava/util/Date;

    .line 111
    .line 112
    .line 113
    move-result-object v0

    .line 114
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toIso8601(Ljava/util/Date;)Ljava/lang/String;

    .line 115
    .line 116
    .line 117
    move-result-object v0

    .line 118
    const-string v2, "originalPurchaseDate"

    .line 119
    .line 120
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 121
    .line 122
    .line 123
    move-result-object v10

    .line 124
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getExpirationDate()Ljava/util/Date;

    .line 125
    .line 126
    .line 127
    move-result-object v0

    .line 128
    if-eqz v0, :cond_0

    .line 129
    .line 130
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toMillis(Ljava/util/Date;)J

    .line 131
    .line 132
    .line 133
    move-result-wide v11

    .line 134
    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 135
    .line 136
    .line 137
    move-result-object v0

    .line 138
    goto :goto_0

    .line 139
    :cond_0
    const/4 v0, 0x0

    .line 140
    :goto_0
    const-string v11, "expirationDateMillis"

    .line 141
    .line 142
    invoke-static {v11, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 143
    .line 144
    .line 145
    move-result-object v11

    .line 146
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getExpirationDate()Ljava/util/Date;

    .line 147
    .line 148
    .line 149
    move-result-object v0

    .line 150
    if-eqz v0, :cond_1

    .line 151
    .line 152
    invoke-static {v0}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toIso8601(Ljava/util/Date;)Ljava/lang/String;

    .line 153
    .line 154
    .line 155
    move-result-object v0

    .line 156
    goto :goto_1

    .line 157
    :cond_1
    const/4 v0, 0x0

    .line 158
    :goto_1
    const-string v12, "expirationDate"

    .line 159
    .line 160
    invoke-static {v12, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 161
    .line 162
    .line 163
    move-result-object v12

    .line 164
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getStore()Lcom/revenuecat/purchases/Store;

    .line 165
    .line 166
    .line 167
    move-result-object v0

    .line 168
    invoke-virtual {v0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 169
    .line 170
    .line 171
    move-result-object v0

    .line 172
    const-string v13, "store"

    .line 173
    .line 174
    invoke-static {v13, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 175
    .line 176
    .line 177
    move-result-object v13

    .line 178
    const-string v0, "productIdentifier"

    .line 179
    .line 180
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getProductIdentifier()Ljava/lang/String;

    .line 181
    .line 182
    .line 183
    move-result-object v14

    .line 184
    invoke-static {v0, v14}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 185
    .line 186
    .line 187
    move-result-object v14

    .line 188
    const-string v0, "productPlanIdentifier"

    .line 189
    .line 190
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getProductPlanIdentifier()Ljava/lang/String;

    .line 191
    .line 192
    .line 193
    move-result-object v15

    .line 194
    invoke-static {v0, v15}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 195
    .line 196
    .line 197
    move-result-object v15

    .line 198
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->isSandbox()Z

    .line 199
    .line 200
    .line 201
    move-result v0

    .line 202
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    .line 203
    .line 204
    .line 205
    move-result-object v0

    .line 206
    const-string v2, "isSandbox"

    .line 207
    .line 208
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 209
    .line 210
    .line 211
    move-result-object v0

    .line 212
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getUnsubscribeDetectedAt()Ljava/util/Date;

    .line 213
    .line 214
    .line 215
    move-result-object v2

    .line 216
    if-eqz v2, :cond_2

    .line 217
    .line 218
    invoke-static {v2}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toIso8601(Ljava/util/Date;)Ljava/lang/String;

    .line 219
    .line 220
    .line 221
    move-result-object v2

    .line 222
    :goto_2
    move-object/from16 v17, v0

    .line 223
    .line 224
    goto :goto_3

    .line 225
    :cond_2
    const/4 v2, 0x0

    .line 226
    goto :goto_2

    .line 227
    :goto_3
    const-string v0, "unsubscribeDetectedAt"

    .line 228
    .line 229
    invoke-static {v0, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 230
    .line 231
    .line 232
    move-result-object v0

    .line 233
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getUnsubscribeDetectedAt()Ljava/util/Date;

    .line 234
    .line 235
    .line 236
    move-result-object v2

    .line 237
    if-eqz v2, :cond_3

    .line 238
    .line 239
    invoke-static {v2}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toMillis(Ljava/util/Date;)J

    .line 240
    .line 241
    .line 242
    move-result-wide v18

    .line 243
    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 244
    .line 245
    .line 246
    move-result-object v2

    .line 247
    :goto_4
    move-object/from16 v18, v0

    .line 248
    .line 249
    goto :goto_5

    .line 250
    :cond_3
    const/4 v2, 0x0

    .line 251
    goto :goto_4

    .line 252
    :goto_5
    const-string v0, "unsubscribeDetectedAtMillis"

    .line 253
    .line 254
    invoke-static {v0, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 255
    .line 256
    .line 257
    move-result-object v0

    .line 258
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getBillingIssueDetectedAt()Ljava/util/Date;

    .line 259
    .line 260
    .line 261
    move-result-object v2

    .line 262
    if-eqz v2, :cond_4

    .line 263
    .line 264
    invoke-static {v2}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toIso8601(Ljava/util/Date;)Ljava/lang/String;

    .line 265
    .line 266
    .line 267
    move-result-object v2

    .line 268
    :goto_6
    move-object/from16 v19, v0

    .line 269
    .line 270
    goto :goto_7

    .line 271
    :cond_4
    const/4 v2, 0x0

    .line 272
    goto :goto_6

    .line 273
    :goto_7
    const-string v0, "billingIssueDetectedAt"

    .line 274
    .line 275
    invoke-static {v0, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 276
    .line 277
    .line 278
    move-result-object v0

    .line 279
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getBillingIssueDetectedAt()Ljava/util/Date;

    .line 280
    .line 281
    .line 282
    move-result-object v2

    .line 283
    if-eqz v2, :cond_5

    .line 284
    .line 285
    invoke-static {v2}, Lcom/revenuecat/purchases/hybridcommon/mappers/MappersHelpersKt;->toMillis(Ljava/util/Date;)J

    .line 286
    .line 287
    .line 288
    move-result-wide v20

    .line 289
    invoke-static/range {v20 .. v21}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    .line 290
    .line 291
    .line 292
    move-result-object v2

    .line 293
    :goto_8
    move-object/from16 v16, v0

    .line 294
    .line 295
    goto :goto_9

    .line 296
    :cond_5
    const/4 v2, 0x0

    .line 297
    goto :goto_8

    .line 298
    :goto_9
    const-string v0, "billingIssueDetectedAtMillis"

    .line 299
    .line 300
    invoke-static {v0, v2}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 301
    .line 302
    .line 303
    move-result-object v20

    .line 304
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getOwnershipType()Lcom/revenuecat/purchases/OwnershipType;

    .line 305
    .line 306
    .line 307
    move-result-object v0

    .line 308
    invoke-virtual {v0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 309
    .line 310
    .line 311
    move-result-object v0

    .line 312
    const-string v2, "ownershipType"

    .line 313
    .line 314
    invoke-static {v2, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 315
    .line 316
    .line 317
    move-result-object v21

    .line 318
    invoke-virtual {v1}, Lcom/revenuecat/purchases/EntitlementInfo;->getVerification()Lcom/revenuecat/purchases/VerificationResult;

    .line 319
    .line 320
    .line 321
    move-result-object v0

    .line 322
    invoke-virtual {v0}, Ljava/lang/Enum;->name()Ljava/lang/String;

    .line 323
    .line 324
    .line 325
    move-result-object v0

    .line 326
    const-string v1, "verification"

    .line 327
    .line 328
    invoke-static {v1, v0}, Lcd/w;->a(Ljava/lang/Object;Ljava/lang/Object;)Lcd/q;

    .line 329
    .line 330
    .line 331
    move-result-object v22

    .line 332
    move-object/from16 v23, v19

    .line 333
    .line 334
    move-object/from16 v19, v16

    .line 335
    .line 336
    move-object/from16 v16, v17

    .line 337
    .line 338
    move-object/from16 v17, v18

    .line 339
    .line 340
    move-object/from16 v18, v23

    .line 341
    .line 342
    filled-new-array/range {v3 .. v22}, [Lcd/q;

    .line 343
    .line 344
    .line 345
    move-result-object v0

    .line 346
    invoke-static {v0}, Ldd/o0;->l([Lcd/q;)Ljava/util/Map;

    .line 347
    .line 348
    .line 349
    move-result-object v0

    .line 350
    return-object v0
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
