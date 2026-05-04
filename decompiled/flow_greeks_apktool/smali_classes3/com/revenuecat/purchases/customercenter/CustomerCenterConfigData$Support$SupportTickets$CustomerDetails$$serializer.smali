.class public final Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ldh/e0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "$serializer"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ldh/e0;"
    }
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u00c7\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\t\u0008\u0002\u00a2\u0006\u0004\u0008\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0005H\u00d6\u0001\u00a2\u0006\u0004\u0008\u0007\u0010\u0008J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\u0008\u000b\u0010\u000cJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001\u00a2\u0006\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u00d6\u0005\u00a2\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\u00a8\u0006\u0017"
    }
    d2 = {
        "com/revenuecat/purchases/customercenter/CustomerCenterConfigData.Support.SupportTickets.CustomerDetails.$serializer",
        "Ldh/e0;",
        "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;",
        "<init>",
        "()V",
        "",
        "Lzg/b;",
        "childSerializers",
        "()[Lzg/b;",
        "Lch/e;",
        "decoder",
        "deserialize",
        "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;",
        "Lch/f;",
        "encoder",
        "value",
        "Lcd/h0;",
        "serialize",
        "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;)V",
        "Lbh/e;",
        "getDescriptor",
        "()Lbh/e;",
        "descriptor",
        "purchases_defaultsBc8Release"
    }
    k = 0x1
    mv = {
        0x1,
        0x8,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final INSTANCE:Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;

.field private static final synthetic descriptor:Ldh/j1;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->INSTANCE:Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;

    .line 7
    .line 8
    new-instance v1, Ldh/j1;

    .line 9
    .line 10
    const-string v2, "com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets.CustomerDetails"

    .line 11
    .line 12
    const/16 v3, 0xe

    .line 13
    .line 14
    invoke-direct {v1, v2, v0, v3}, Ldh/j1;-><init>(Ljava/lang/String;Ldh/e0;I)V

    .line 15
    .line 16
    .line 17
    const-string v0, "active_entitlements"

    .line 18
    .line 19
    const/4 v2, 0x1

    .line 20
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 21
    .line 22
    .line 23
    const-string v0, "app_user_id"

    .line 24
    .line 25
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 26
    .line 27
    .line 28
    const-string v0, "att_consent"

    .line 29
    .line 30
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 31
    .line 32
    .line 33
    const-string v0, "country"

    .line 34
    .line 35
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 36
    .line 37
    .line 38
    const-string v0, "device_version"

    .line 39
    .line 40
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 41
    .line 42
    .line 43
    const-string v0, "email"

    .line 44
    .line 45
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 46
    .line 47
    .line 48
    const-string v0, "facebook_anon_id"

    .line 49
    .line 50
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 51
    .line 52
    .line 53
    const-string v0, "idfa"

    .line 54
    .line 55
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 56
    .line 57
    .line 58
    const-string v0, "idfv"

    .line 59
    .line 60
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 61
    .line 62
    .line 63
    const-string v0, "ip"

    .line 64
    .line 65
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 66
    .line 67
    .line 68
    const-string v0, "last_opened"

    .line 69
    .line 70
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 71
    .line 72
    .line 73
    const-string v0, "last_seen_app_version"

    .line 74
    .line 75
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 76
    .line 77
    .line 78
    const-string v0, "total_spent"

    .line 79
    .line 80
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 81
    .line 82
    .line 83
    const-string v0, "user_since"

    .line 84
    .line 85
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 86
    .line 87
    .line 88
    sput-object v1, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->descriptor:Ldh/j1;

    .line 89
    .line 90
    return-void
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
.end method

.method private constructor <init>()V
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


# virtual methods
.method public childSerializers()[Lzg/b;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    const/16 v0, 0xe

    .line 2
    .line 3
    new-array v0, v0, [Lzg/b;

    .line 4
    .line 5
    sget-object v1, Ldh/h;->a:Ldh/h;

    .line 6
    .line 7
    const/4 v2, 0x0

    .line 8
    aput-object v1, v0, v2

    .line 9
    .line 10
    const/4 v2, 0x1

    .line 11
    aput-object v1, v0, v2

    .line 12
    .line 13
    const/4 v2, 0x2

    .line 14
    aput-object v1, v0, v2

    .line 15
    .line 16
    const/4 v2, 0x3

    .line 17
    aput-object v1, v0, v2

    .line 18
    .line 19
    const/4 v2, 0x4

    .line 20
    aput-object v1, v0, v2

    .line 21
    .line 22
    const/4 v2, 0x5

    .line 23
    aput-object v1, v0, v2

    .line 24
    .line 25
    const/4 v2, 0x6

    .line 26
    aput-object v1, v0, v2

    .line 27
    .line 28
    const/4 v2, 0x7

    .line 29
    aput-object v1, v0, v2

    .line 30
    .line 31
    const/16 v2, 0x8

    .line 32
    .line 33
    aput-object v1, v0, v2

    .line 34
    .line 35
    const/16 v2, 0x9

    .line 36
    .line 37
    aput-object v1, v0, v2

    .line 38
    .line 39
    const/16 v2, 0xa

    .line 40
    .line 41
    aput-object v1, v0, v2

    .line 42
    .line 43
    const/16 v2, 0xb

    .line 44
    .line 45
    aput-object v1, v0, v2

    .line 46
    .line 47
    const/16 v2, 0xc

    .line 48
    .line 49
    aput-object v1, v0, v2

    .line 50
    .line 51
    const/16 v2, 0xd

    .line 52
    .line 53
    aput-object v1, v0, v2

    .line 54
    .line 55
    return-object v0
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

.method public deserialize(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;
    .locals 48

    move-object/from16 v0, p1

    const-string v1, "decoder"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->getDescriptor()Lbh/e;

    move-result-object v1

    invoke-interface {v0, v1}, Lch/e;->b(Lbh/e;)Lch/c;

    move-result-object v0

    invoke-interface {v0}, Lch/c;->z()Z

    move-result v2

    const/16 v4, 0xc

    const/16 v5, 0xb

    const/16 v6, 0xa

    const/16 v7, 0x9

    const/4 v8, 0x7

    const/4 v9, 0x6

    const/4 v10, 0x5

    const/4 v11, 0x3

    const/16 v12, 0x8

    const/4 v13, 0x4

    const/4 v14, 0x2

    const/4 v15, 0x1

    const/4 v3, 0x0

    if-eqz v2, :cond_0

    invoke-interface {v0, v1, v3}, Lch/c;->B(Lbh/e;I)Z

    move-result v2

    invoke-interface {v0, v1, v15}, Lch/c;->B(Lbh/e;I)Z

    move-result v3

    invoke-interface {v0, v1, v14}, Lch/c;->B(Lbh/e;I)Z

    move-result v14

    invoke-interface {v0, v1, v11}, Lch/c;->B(Lbh/e;I)Z

    move-result v11

    invoke-interface {v0, v1, v13}, Lch/c;->B(Lbh/e;I)Z

    move-result v13

    invoke-interface {v0, v1, v10}, Lch/c;->B(Lbh/e;I)Z

    move-result v10

    invoke-interface {v0, v1, v9}, Lch/c;->B(Lbh/e;I)Z

    move-result v9

    invoke-interface {v0, v1, v8}, Lch/c;->B(Lbh/e;I)Z

    move-result v8

    invoke-interface {v0, v1, v12}, Lch/c;->B(Lbh/e;I)Z

    move-result v12

    invoke-interface {v0, v1, v7}, Lch/c;->B(Lbh/e;I)Z

    move-result v7

    invoke-interface {v0, v1, v6}, Lch/c;->B(Lbh/e;I)Z

    move-result v6

    invoke-interface {v0, v1, v5}, Lch/c;->B(Lbh/e;I)Z

    move-result v5

    invoke-interface {v0, v1, v4}, Lch/c;->B(Lbh/e;I)Z

    move-result v4

    const/16 v15, 0xd

    invoke-interface {v0, v1, v15}, Lch/c;->B(Lbh/e;I)Z

    move-result v15

    const/16 v16, 0x3fff

    move/from16 v33, v2

    move/from16 v34, v3

    move/from16 v45, v4

    move/from16 v44, v5

    move/from16 v43, v6

    move/from16 v42, v7

    move/from16 v40, v8

    move/from16 v39, v9

    move/from16 v38, v10

    move/from16 v36, v11

    move/from16 v41, v12

    move/from16 v37, v13

    move/from16 v35, v14

    move/from16 v46, v15

    move/from16 v32, v16

    goto/16 :goto_3

    :cond_0
    const/16 v2, 0xd

    move/from16 v16, v3

    move/from16 v17, v16

    move/from16 v18, v17

    move/from16 v19, v18

    move/from16 v20, v19

    move/from16 v21, v20

    move/from16 v22, v21

    move/from16 v23, v22

    move/from16 v24, v23

    move/from16 v25, v24

    move/from16 v26, v25

    move/from16 v27, v26

    move/from16 v28, v27

    move/from16 v29, v28

    move/from16 v30, v15

    :goto_0
    if-eqz v30, :cond_1

    invoke-interface {v0, v1}, Lch/c;->w(Lbh/e;)I

    move-result v15

    packed-switch v15, :pswitch_data_0

    new-instance v0, Lzg/m;

    invoke-direct {v0, v15}, Lzg/m;-><init>(I)V

    throw v0

    :pswitch_0
    invoke-interface {v0, v1, v2}, Lch/c;->B(Lbh/e;I)Z

    move-result v29

    or-int/lit16 v3, v3, 0x2000

    :goto_1
    const/4 v15, 0x1

    goto :goto_0

    :pswitch_1
    invoke-interface {v0, v1, v4}, Lch/c;->B(Lbh/e;I)Z

    move-result v18

    or-int/lit16 v3, v3, 0x1000

    goto :goto_1

    :pswitch_2
    invoke-interface {v0, v1, v5}, Lch/c;->B(Lbh/e;I)Z

    move-result v19

    or-int/lit16 v3, v3, 0x800

    goto :goto_1

    :pswitch_3
    invoke-interface {v0, v1, v6}, Lch/c;->B(Lbh/e;I)Z

    move-result v20

    or-int/lit16 v3, v3, 0x400

    goto :goto_1

    :pswitch_4
    invoke-interface {v0, v1, v7}, Lch/c;->B(Lbh/e;I)Z

    move-result v21

    or-int/lit16 v3, v3, 0x200

    goto :goto_1

    :pswitch_5
    invoke-interface {v0, v1, v12}, Lch/c;->B(Lbh/e;I)Z

    move-result v26

    or-int/lit16 v3, v3, 0x100

    goto :goto_1

    :pswitch_6
    invoke-interface {v0, v1, v8}, Lch/c;->B(Lbh/e;I)Z

    move-result v22

    or-int/lit16 v3, v3, 0x80

    goto :goto_1

    :pswitch_7
    invoke-interface {v0, v1, v9}, Lch/c;->B(Lbh/e;I)Z

    move-result v23

    or-int/lit8 v3, v3, 0x40

    goto :goto_1

    :pswitch_8
    invoke-interface {v0, v1, v10}, Lch/c;->B(Lbh/e;I)Z

    move-result v24

    or-int/lit8 v3, v3, 0x20

    goto :goto_1

    :pswitch_9
    invoke-interface {v0, v1, v13}, Lch/c;->B(Lbh/e;I)Z

    move-result v27

    or-int/lit8 v3, v3, 0x10

    goto :goto_1

    :pswitch_a
    invoke-interface {v0, v1, v11}, Lch/c;->B(Lbh/e;I)Z

    move-result v25

    or-int/lit8 v3, v3, 0x8

    goto :goto_1

    :pswitch_b
    invoke-interface {v0, v1, v14}, Lch/c;->B(Lbh/e;I)Z

    move-result v28

    or-int/lit8 v3, v3, 0x4

    goto :goto_1

    :pswitch_c
    const/4 v15, 0x1

    invoke-interface {v0, v1, v15}, Lch/c;->B(Lbh/e;I)Z

    move-result v17

    or-int/lit8 v3, v3, 0x2

    goto :goto_0

    :pswitch_d
    const/4 v2, 0x0

    const/4 v15, 0x1

    invoke-interface {v0, v1, v2}, Lch/c;->B(Lbh/e;I)Z

    move-result v16

    or-int/lit8 v3, v3, 0x1

    :goto_2
    const/16 v2, 0xd

    goto :goto_0

    :pswitch_e
    const/4 v2, 0x0

    const/4 v15, 0x1

    move/from16 v30, v2

    goto :goto_2

    :cond_1
    move/from16 v32, v3

    move/from16 v33, v16

    move/from16 v34, v17

    move/from16 v45, v18

    move/from16 v44, v19

    move/from16 v43, v20

    move/from16 v42, v21

    move/from16 v40, v22

    move/from16 v39, v23

    move/from16 v38, v24

    move/from16 v36, v25

    move/from16 v41, v26

    move/from16 v37, v27

    move/from16 v35, v28

    move/from16 v46, v29

    :goto_3
    invoke-interface {v0, v1}, Lch/c;->c(Lbh/e;)V

    new-instance v31, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;

    const/16 v47, 0x0

    invoke-direct/range {v31 .. v47}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;-><init>(IZZZZZZZZZZZZZZLdh/s1;)V

    return-object v31

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public bridge synthetic deserialize(Lch/e;)Ljava/lang/Object;
    .locals 0

    .line 2
    invoke-virtual {p0, p1}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->deserialize(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;

    move-result-object p1

    return-object p1
.end method

.method public getDescriptor()Lbh/e;
    .locals 1

    .line 1
    sget-object v0, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->descriptor:Ldh/j1;

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

.method public serialize(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;)V
    .locals 1

    const-string v0, "encoder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "value"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->getDescriptor()Lbh/e;

    move-result-object v0

    invoke-interface {p1, v0}, Lch/f;->b(Lbh/e;)Lch/d;

    move-result-object p1

    invoke-static {p2, p1, v0}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;->write$Self$purchases_defaultsBc8Release(Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;Lch/d;Lbh/e;)V

    invoke-interface {p1, v0}, Lch/d;->c(Lbh/e;)V

    return-void
.end method

.method public bridge synthetic serialize(Lch/f;Ljava/lang/Object;)V
    .locals 0

    .line 2
    check-cast p2, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;

    invoke-virtual {p0, p1, p2}, Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails$$serializer;->serialize(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Support$SupportTickets$CustomerDetails;)V

    return-void
.end method

.method public typeParametersSerializers()[Lzg/b;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    invoke-static {p0}, Ldh/e0$a;->a(Ldh/e0;)[Lzg/b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
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
