.class public final Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ldh/e0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;
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
        "com/revenuecat/purchases/paywalls/components/PartialCarouselComponent.$serializer",
        "Ldh/e0;",
        "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;",
        "<init>",
        "()V",
        "",
        "Lzg/b;",
        "childSerializers",
        "()[Lzg/b;",
        "Lch/e;",
        "decoder",
        "deserialize",
        "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;",
        "Lch/f;",
        "encoder",
        "value",
        "Lcd/h0;",
        "serialize",
        "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;)V",
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
.field public static final INSTANCE:Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;

.field private static final synthetic descriptor:Ldh/j1;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;

    .line 7
    .line 8
    new-instance v1, Ldh/j1;

    .line 9
    .line 10
    const-string v2, "com.revenuecat.purchases.paywalls.components.PartialCarouselComponent"

    .line 11
    .line 12
    const/16 v3, 0x10

    .line 13
    .line 14
    invoke-direct {v1, v2, v0, v3}, Ldh/j1;-><init>(Ljava/lang/String;Ldh/e0;I)V

    .line 15
    .line 16
    .line 17
    const-string v0, "visible"

    .line 18
    .line 19
    const/4 v2, 0x1

    .line 20
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 21
    .line 22
    .line 23
    const-string v0, "initial_page_index"

    .line 24
    .line 25
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 26
    .line 27
    .line 28
    const-string v0, "page_alignment"

    .line 29
    .line 30
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 31
    .line 32
    .line 33
    const-string v0, "size"

    .line 34
    .line 35
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 36
    .line 37
    .line 38
    const-string v0, "page_peek"

    .line 39
    .line 40
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 41
    .line 42
    .line 43
    const-string v0, "page_spacing"

    .line 44
    .line 45
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 46
    .line 47
    .line 48
    const-string v0, "background_color"

    .line 49
    .line 50
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 51
    .line 52
    .line 53
    const-string v0, "background"

    .line 54
    .line 55
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 56
    .line 57
    .line 58
    const-string v0, "padding"

    .line 59
    .line 60
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 61
    .line 62
    .line 63
    const-string v0, "margin"

    .line 64
    .line 65
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 66
    .line 67
    .line 68
    const-string v0, "shape"

    .line 69
    .line 70
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 71
    .line 72
    .line 73
    const-string v0, "border"

    .line 74
    .line 75
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 76
    .line 77
    .line 78
    const-string v0, "shadow"

    .line 79
    .line 80
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 81
    .line 82
    .line 83
    const-string v0, "page_control"

    .line 84
    .line 85
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 86
    .line 87
    .line 88
    const-string v0, "loop"

    .line 89
    .line 90
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 91
    .line 92
    .line 93
    const-string v0, "auto_advance"

    .line 94
    .line 95
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 96
    .line 97
    .line 98
    sput-object v1, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->descriptor:Ldh/j1;

    .line 99
    .line 100
    return-void
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
    .locals 18
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    sget-object v0, Ldh/h;->a:Ldh/h;

    .line 2
    .line 3
    invoke-static {v0}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 4
    .line 5
    .line 6
    move-result-object v1

    .line 7
    sget-object v2, Ldh/j0;->a:Ldh/j0;

    .line 8
    .line 9
    invoke-static {v2}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 10
    .line 11
    .line 12
    move-result-object v3

    .line 13
    sget-object v4, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    .line 14
    .line 15
    invoke-static {v4}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 16
    .line 17
    .line 18
    move-result-object v4

    .line 19
    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    .line 20
    .line 21
    invoke-static {v5}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 22
    .line 23
    .line 24
    move-result-object v5

    .line 25
    invoke-static {v2}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    sget-object v6, Ldh/d0;->a:Ldh/d0;

    .line 30
    .line 31
    invoke-static {v6}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 32
    .line 33
    .line 34
    move-result-object v6

    .line 35
    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    .line 36
    .line 37
    invoke-static {v7}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 38
    .line 39
    .line 40
    move-result-object v7

    .line 41
    sget-object v8, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    .line 42
    .line 43
    invoke-static {v8}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 44
    .line 45
    .line 46
    move-result-object v8

    .line 47
    sget-object v9, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    .line 48
    .line 49
    invoke-static {v9}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 50
    .line 51
    .line 52
    move-result-object v10

    .line 53
    invoke-static {v9}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 54
    .line 55
    .line 56
    move-result-object v9

    .line 57
    sget-object v11, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    .line 58
    .line 59
    invoke-static {v11}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 60
    .line 61
    .line 62
    move-result-object v11

    .line 63
    sget-object v12, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    .line 64
    .line 65
    invoke-static {v12}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 66
    .line 67
    .line 68
    move-result-object v12

    .line 69
    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    .line 70
    .line 71
    invoke-static {v13}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 72
    .line 73
    .line 74
    move-result-object v13

    .line 75
    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    .line 76
    .line 77
    invoke-static {v14}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 78
    .line 79
    .line 80
    move-result-object v14

    .line 81
    invoke-static {v0}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 82
    .line 83
    .line 84
    move-result-object v0

    .line 85
    sget-object v15, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    .line 86
    .line 87
    invoke-static {v15}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 88
    .line 89
    .line 90
    move-result-object v15

    .line 91
    move-object/from16 v16, v0

    .line 92
    .line 93
    const/16 v0, 0x10

    .line 94
    .line 95
    new-array v0, v0, [Lzg/b;

    .line 96
    .line 97
    const/16 v17, 0x0

    .line 98
    .line 99
    aput-object v1, v0, v17

    .line 100
    .line 101
    const/4 v1, 0x1

    .line 102
    aput-object v3, v0, v1

    .line 103
    .line 104
    const/4 v1, 0x2

    .line 105
    aput-object v4, v0, v1

    .line 106
    .line 107
    const/4 v1, 0x3

    .line 108
    aput-object v5, v0, v1

    .line 109
    .line 110
    const/4 v1, 0x4

    .line 111
    aput-object v2, v0, v1

    .line 112
    .line 113
    const/4 v1, 0x5

    .line 114
    aput-object v6, v0, v1

    .line 115
    .line 116
    const/4 v1, 0x6

    .line 117
    aput-object v7, v0, v1

    .line 118
    .line 119
    const/4 v1, 0x7

    .line 120
    aput-object v8, v0, v1

    .line 121
    .line 122
    const/16 v1, 0x8

    .line 123
    .line 124
    aput-object v10, v0, v1

    .line 125
    .line 126
    const/16 v1, 0x9

    .line 127
    .line 128
    aput-object v9, v0, v1

    .line 129
    .line 130
    const/16 v1, 0xa

    .line 131
    .line 132
    aput-object v11, v0, v1

    .line 133
    .line 134
    const/16 v1, 0xb

    .line 135
    .line 136
    aput-object v12, v0, v1

    .line 137
    .line 138
    const/16 v1, 0xc

    .line 139
    .line 140
    aput-object v13, v0, v1

    .line 141
    .line 142
    const/16 v1, 0xd

    .line 143
    .line 144
    aput-object v14, v0, v1

    .line 145
    .line 146
    const/16 v1, 0xe

    .line 147
    .line 148
    aput-object v16, v0, v1

    .line 149
    .line 150
    const/16 v1, 0xf

    .line 151
    .line 152
    aput-object v15, v0, v1

    .line 153
    .line 154
    return-object v0
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

.method public deserialize(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;
    .locals 50

    move-object/from16 v0, p1

    const-string v1, "decoder"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->getDescriptor()Lbh/e;

    move-result-object v1

    invoke-interface {v0, v1}, Lch/e;->b(Lbh/e;)Lch/c;

    move-result-object v0

    invoke-interface {v0}, Lch/c;->z()Z

    move-result v2

    const/16 v9, 0x9

    const/4 v10, 0x7

    const/4 v11, 0x6

    const/4 v12, 0x5

    const/4 v13, 0x3

    const/16 v14, 0x8

    const/4 v15, 0x4

    const/4 v3, 0x2

    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    if-eqz v2, :cond_0

    sget-object v2, Ldh/h;->a:Ldh/h;

    invoke-interface {v0, v1, v5, v2, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Boolean;

    sget-object v7, Ldh/j0;->a:Ldh/j0;

    invoke-interface {v0, v1, v4, v7, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    sget-object v8, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    invoke-interface {v0, v1, v3, v8, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;

    sget-object v8, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    invoke-interface {v0, v1, v13, v8, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/revenuecat/purchases/paywalls/components/properties/Size;

    invoke-interface {v0, v1, v15, v7, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    sget-object v13, Ldh/d0;->a:Ldh/d0;

    invoke-interface {v0, v1, v12, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Float;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    invoke-interface {v0, v1, v11, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    invoke-interface {v0, v1, v10, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/revenuecat/purchases/paywalls/components/common/Background;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    invoke-interface {v0, v1, v14, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    invoke-interface {v0, v1, v9, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    const/16 v15, 0xa

    invoke-interface {v0, v1, v15, v13, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/revenuecat/purchases/paywalls/components/properties/Shape;

    sget-object v15, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    move-object/from16 v19, v3

    const/16 v3, 0xb

    invoke-interface {v0, v1, v3, v15, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/revenuecat/purchases/paywalls/components/properties/Border;

    sget-object v15, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    move-object/from16 v18, v3

    const/16 v3, 0xc

    invoke-interface {v0, v1, v3, v15, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;

    sget-object v15, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    move-object/from16 v17, v3

    const/16 v3, 0xd

    invoke-interface {v0, v1, v3, v15, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;

    const/16 v15, 0xe

    invoke-interface {v0, v1, v15, v2, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    sget-object v15, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    move-object/from16 v16, v2

    const/16 v2, 0xf

    invoke-interface {v0, v1, v2, v15, v6}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;

    const v6, 0xffff

    move-object/from16 v48, v2

    move-object/from16 v46, v3

    move-object/from16 v34, v4

    move-object/from16 v33, v5

    move-object/from16 v37, v7

    move-object/from16 v36, v8

    move-object/from16 v42, v9

    move-object/from16 v40, v10

    move-object/from16 v39, v11

    move-object/from16 v38, v12

    move-object/from16 v43, v13

    move-object/from16 v41, v14

    move-object/from16 v47, v16

    move-object/from16 v45, v17

    move-object/from16 v44, v18

    move-object/from16 v35, v19

    :goto_0
    move/from16 v32, v6

    goto/16 :goto_5

    :cond_0
    move/from16 v28, v4

    move-object v2, v6

    move-object v3, v2

    move-object v4, v3

    move-object v7, v4

    move-object v8, v7

    move-object v9, v8

    move-object v10, v9

    move-object v11, v10

    move-object v12, v11

    move-object v13, v12

    move-object v14, v13

    move-object v15, v14

    move-object/from16 v25, v15

    move-object/from16 v26, v25

    move-object/from16 v27, v26

    move v6, v5

    move-object/from16 v5, v27

    :goto_1
    if-eqz v28, :cond_1

    move-object/from16 v29, v5

    invoke-interface {v0, v1}, Lch/c;->w(Lbh/e;)I

    move-result v5

    packed-switch v5, :pswitch_data_0

    new-instance v0, Lzg/m;

    invoke-direct {v0, v5}, Lzg/m;-><init>(I)V

    throw v0

    :pswitch_0
    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    move-object/from16 v30, v4

    const/16 v4, 0xf

    invoke-interface {v0, v1, v4, v5, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v8, v5

    check-cast v8, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;

    const v5, 0x8000

    or-int/2addr v6, v5

    :goto_2
    move-object/from16 v5, v29

    move-object/from16 v4, v30

    goto :goto_1

    :pswitch_1
    move-object/from16 v30, v4

    const/16 v4, 0xf

    sget-object v5, Ldh/h;->a:Ldh/h;

    const/16 v4, 0xe

    invoke-interface {v0, v1, v4, v5, v7}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v7, v5

    check-cast v7, Ljava/lang/Boolean;

    or-int/lit16 v6, v6, 0x4000

    goto :goto_2

    :pswitch_2
    move-object/from16 v30, v4

    const/16 v4, 0xe

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    const/16 v4, 0xd

    invoke-interface {v0, v1, v4, v5, v2}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;

    or-int/lit16 v6, v6, 0x2000

    goto :goto_2

    :pswitch_3
    move-object/from16 v30, v4

    const/16 v4, 0xd

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    const/16 v4, 0xc

    invoke-interface {v0, v1, v4, v5, v9}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v9, v5

    check-cast v9, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;

    or-int/lit16 v6, v6, 0x1000

    goto :goto_2

    :pswitch_4
    move-object/from16 v30, v4

    const/16 v4, 0xc

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    const/16 v4, 0xb

    invoke-interface {v0, v1, v4, v5, v14}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v14, v5

    check-cast v14, Lcom/revenuecat/purchases/paywalls/components/properties/Border;

    or-int/lit16 v6, v6, 0x800

    goto :goto_2

    :pswitch_5
    move-object/from16 v30, v4

    const/16 v4, 0xb

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    const/16 v4, 0xa

    invoke-interface {v0, v1, v4, v5, v10}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v10, v5

    check-cast v10, Lcom/revenuecat/purchases/paywalls/components/properties/Shape;

    or-int/lit16 v6, v6, 0x400

    goto :goto_2

    :pswitch_6
    move-object/from16 v30, v4

    const/16 v4, 0xa

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    const/16 v4, 0x9

    invoke-interface {v0, v1, v4, v5, v11}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v11, v5

    check-cast v11, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    or-int/lit16 v6, v6, 0x200

    goto :goto_2

    :pswitch_7
    move-object/from16 v30, v4

    const/16 v4, 0x9

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    const/16 v4, 0x8

    invoke-interface {v0, v1, v4, v5, v12}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v12, v5

    check-cast v12, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    or-int/lit16 v6, v6, 0x100

    goto/16 :goto_2

    :pswitch_8
    move-object/from16 v30, v4

    const/16 v4, 0x8

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    const/4 v4, 0x7

    invoke-interface {v0, v1, v4, v5, v15}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v15, v5

    check-cast v15, Lcom/revenuecat/purchases/paywalls/components/common/Background;

    or-int/lit16 v6, v6, 0x80

    goto/16 :goto_2

    :pswitch_9
    move-object/from16 v30, v4

    const/4 v4, 0x7

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    const/4 v4, 0x6

    invoke-interface {v0, v1, v4, v5, v13}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v13, v5

    check-cast v13, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;

    or-int/lit8 v6, v6, 0x40

    goto/16 :goto_2

    :pswitch_a
    move-object/from16 v30, v4

    const/4 v4, 0x6

    sget-object v5, Ldh/d0;->a:Ldh/d0;

    const/4 v4, 0x5

    invoke-interface {v0, v1, v4, v5, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Float;

    or-int/lit8 v6, v6, 0x20

    goto/16 :goto_2

    :pswitch_b
    move-object/from16 v30, v4

    const/4 v4, 0x5

    sget-object v5, Ldh/j0;->a:Ldh/j0;

    move-object/from16 v24, v2

    move-object/from16 v4, v30

    const/4 v2, 0x4

    invoke-interface {v0, v1, v2, v5, v4}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    or-int/lit8 v6, v6, 0x10

    move-object/from16 v2, v24

    move-object/from16 v5, v29

    goto/16 :goto_1

    :pswitch_c
    move-object/from16 v24, v2

    const/4 v2, 0x4

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    move-object/from16 v23, v3

    move-object/from16 v2, v29

    const/4 v3, 0x3

    invoke-interface {v0, v1, v3, v5, v2}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v5, v2

    check-cast v5, Lcom/revenuecat/purchases/paywalls/components/properties/Size;

    or-int/lit8 v6, v6, 0x8

    :goto_3
    move-object/from16 v3, v23

    move-object/from16 v2, v24

    goto/16 :goto_1

    :pswitch_d
    move-object/from16 v24, v2

    move-object/from16 v23, v3

    move-object/from16 v2, v29

    const/4 v3, 0x3

    sget-object v5, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    move-object/from16 v22, v2

    move-object/from16 v3, v27

    const/4 v2, 0x2

    invoke-interface {v0, v1, v2, v5, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object/from16 v27, v3

    check-cast v27, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;

    or-int/lit8 v6, v6, 0x4

    :goto_4
    move-object/from16 v5, v22

    goto :goto_3

    :pswitch_e
    move-object/from16 v24, v2

    move-object/from16 v23, v3

    move-object/from16 v3, v27

    move-object/from16 v22, v29

    const/4 v2, 0x2

    sget-object v5, Ldh/j0;->a:Ldh/j0;

    move-object/from16 v21, v3

    move-object/from16 v2, v26

    const/4 v3, 0x1

    invoke-interface {v0, v1, v3, v5, v2}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object/from16 v26, v2

    check-cast v26, Ljava/lang/Integer;

    or-int/lit8 v6, v6, 0x2

    move-object/from16 v27, v21

    goto :goto_4

    :pswitch_f
    move-object/from16 v24, v2

    move-object/from16 v23, v3

    move-object/from16 v2, v26

    move-object/from16 v21, v27

    move-object/from16 v22, v29

    const/4 v3, 0x1

    sget-object v5, Ldh/h;->a:Ldh/h;

    move-object/from16 v20, v2

    move-object/from16 v3, v25

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2, v5, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object/from16 v25, v3

    check-cast v25, Ljava/lang/Boolean;

    or-int/lit8 v6, v6, 0x1

    move-object/from16 v26, v20

    goto :goto_4

    :pswitch_10
    move-object/from16 v24, v2

    move-object/from16 v23, v3

    move-object/from16 v3, v25

    move-object/from16 v20, v26

    move-object/from16 v21, v27

    move-object/from16 v22, v29

    const/4 v2, 0x0

    move/from16 v28, v2

    goto :goto_4

    :cond_1
    move-object/from16 v24, v2

    move-object/from16 v23, v3

    move-object/from16 v22, v5

    move-object/from16 v3, v25

    move-object/from16 v20, v26

    move-object/from16 v21, v27

    move-object/from16 v33, v3

    move-object/from16 v37, v4

    move-object/from16 v47, v7

    move-object/from16 v48, v8

    move-object/from16 v45, v9

    move-object/from16 v43, v10

    move-object/from16 v42, v11

    move-object/from16 v41, v12

    move-object/from16 v39, v13

    move-object/from16 v44, v14

    move-object/from16 v40, v15

    move-object/from16 v34, v20

    move-object/from16 v35, v21

    move-object/from16 v36, v22

    move-object/from16 v38, v23

    move-object/from16 v46, v24

    goto/16 :goto_0

    :goto_5
    invoke-interface {v0, v1}, Lch/c;->c(Lbh/e;)V

    new-instance v31, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;

    const/16 v49, 0x0

    invoke-direct/range {v31 .. v49}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;-><init>(ILjava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Ldh/s1;)V

    return-object v31

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_10
        :pswitch_f
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
    invoke-virtual {p0, p1}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->deserialize(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;

    move-result-object p1

    return-object p1
.end method

.method public getDescriptor()Lbh/e;
    .locals 1

    .line 1
    sget-object v0, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->descriptor:Ldh/j1;

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

.method public serialize(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;)V
    .locals 1

    const-string v0, "encoder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "value"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->getDescriptor()Lbh/e;

    move-result-object v0

    invoke-interface {p1, v0}, Lch/f;->b(Lbh/e;)Lch/d;

    move-result-object p1

    invoke-static {p2, p1, v0}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;->write$Self$purchases_defaultsBc8Release(Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;Lch/d;Lbh/e;)V

    invoke-interface {p1, v0}, Lch/d;->c(Lbh/e;)V

    return-void
.end method

.method public bridge synthetic serialize(Lch/f;Ljava/lang/Object;)V
    .locals 0

    .line 2
    check-cast p2, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;

    invoke-virtual {p0, p1, p2}, Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent$$serializer;->serialize(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;)V

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
