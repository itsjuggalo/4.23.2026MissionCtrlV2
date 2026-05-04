.class public final Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ldh/e0;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;
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
        "com/revenuecat/purchases/paywalls/components/CarouselComponent.$serializer",
        "Ldh/e0;",
        "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;",
        "<init>",
        "()V",
        "",
        "Lzg/b;",
        "childSerializers",
        "()[Lzg/b;",
        "Lch/e;",
        "decoder",
        "deserialize",
        "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;",
        "Lch/f;",
        "encoder",
        "value",
        "Lcd/h0;",
        "serialize",
        "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;)V",
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
.field public static final INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;

.field private static final synthetic descriptor:Ldh/j1;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;

    .line 2
    .line 3
    invoke-direct {v0}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;

    .line 7
    .line 8
    new-instance v1, Ldh/j1;

    .line 9
    .line 10
    const-string v2, "carousel"

    .line 11
    .line 12
    const/16 v3, 0x12

    .line 13
    .line 14
    invoke-direct {v1, v2, v0, v3}, Ldh/j1;-><init>(Ljava/lang/String;Ldh/e0;I)V

    .line 15
    .line 16
    .line 17
    const-string v0, "pages"

    .line 18
    .line 19
    const/4 v2, 0x0

    .line 20
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 21
    .line 22
    .line 23
    const-string v0, "visible"

    .line 24
    .line 25
    const/4 v3, 0x1

    .line 26
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 27
    .line 28
    .line 29
    const-string v0, "initial_page_index"

    .line 30
    .line 31
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 32
    .line 33
    .line 34
    const-string v0, "page_alignment"

    .line 35
    .line 36
    invoke-virtual {v1, v0, v2}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 37
    .line 38
    .line 39
    const-string v0, "size"

    .line 40
    .line 41
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 42
    .line 43
    .line 44
    const-string v0, "page_peek"

    .line 45
    .line 46
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 47
    .line 48
    .line 49
    const-string v0, "page_spacing"

    .line 50
    .line 51
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 52
    .line 53
    .line 54
    const-string v0, "background_color"

    .line 55
    .line 56
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 57
    .line 58
    .line 59
    const-string v0, "background"

    .line 60
    .line 61
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 62
    .line 63
    .line 64
    const-string v0, "padding"

    .line 65
    .line 66
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 67
    .line 68
    .line 69
    const-string v0, "margin"

    .line 70
    .line 71
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 72
    .line 73
    .line 74
    const-string v0, "shape"

    .line 75
    .line 76
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 77
    .line 78
    .line 79
    const-string v0, "border"

    .line 80
    .line 81
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 82
    .line 83
    .line 84
    const-string v0, "shadow"

    .line 85
    .line 86
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 87
    .line 88
    .line 89
    const-string v0, "page_control"

    .line 90
    .line 91
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 92
    .line 93
    .line 94
    const-string v0, "loop"

    .line 95
    .line 96
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 97
    .line 98
    .line 99
    const-string v0, "auto_advance"

    .line 100
    .line 101
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 102
    .line 103
    .line 104
    const-string v0, "overrides"

    .line 105
    .line 106
    invoke-virtual {v1, v0, v3}, Ldh/j1;->g(Ljava/lang/String;Z)V

    .line 107
    .line 108
    .line 109
    sput-object v1, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->descriptor:Ldh/j1;

    .line 110
    .line 111
    return-void
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
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()[",
            "Lzg/b;"
        }
    .end annotation

    .line 1
    invoke-static {}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;->access$get$childSerializers$cp()[Lzg/b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const/4 v1, 0x0

    .line 6
    aget-object v2, v0, v1

    .line 7
    .line 8
    sget-object v3, Ldh/h;->a:Ldh/h;

    .line 9
    .line 10
    invoke-static {v3}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 11
    .line 12
    .line 13
    move-result-object v4

    .line 14
    sget-object v5, Ldh/j0;->a:Ldh/j0;

    .line 15
    .line 16
    invoke-static {v5}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 17
    .line 18
    .line 19
    move-result-object v6

    .line 20
    invoke-static {v5}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 21
    .line 22
    .line 23
    move-result-object v5

    .line 24
    sget-object v7, Ldh/d0;->a:Ldh/d0;

    .line 25
    .line 26
    invoke-static {v7}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 27
    .line 28
    .line 29
    move-result-object v7

    .line 30
    sget-object v8, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    .line 31
    .line 32
    invoke-static {v8}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 33
    .line 34
    .line 35
    move-result-object v8

    .line 36
    sget-object v9, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    .line 37
    .line 38
    invoke-static {v9}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 39
    .line 40
    .line 41
    move-result-object v9

    .line 42
    sget-object v10, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    .line 43
    .line 44
    invoke-static {v10}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 45
    .line 46
    .line 47
    move-result-object v10

    .line 48
    sget-object v11, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    .line 49
    .line 50
    invoke-static {v11}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 51
    .line 52
    .line 53
    move-result-object v11

    .line 54
    sget-object v12, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    .line 55
    .line 56
    invoke-static {v12}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 57
    .line 58
    .line 59
    move-result-object v12

    .line 60
    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    .line 61
    .line 62
    invoke-static {v13}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 63
    .line 64
    .line 65
    move-result-object v13

    .line 66
    invoke-static {v3}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 67
    .line 68
    .line 69
    move-result-object v3

    .line 70
    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    .line 71
    .line 72
    invoke-static {v14}, Lah/a;->p(Lzg/b;)Lzg/b;

    .line 73
    .line 74
    .line 75
    move-result-object v14

    .line 76
    const/16 v15, 0x11

    .line 77
    .line 78
    aget-object v0, v0, v15

    .line 79
    .line 80
    move/from16 v16, v1

    .line 81
    .line 82
    const/16 v1, 0x12

    .line 83
    .line 84
    new-array v1, v1, [Lzg/b;

    .line 85
    .line 86
    aput-object v2, v1, v16

    .line 87
    .line 88
    const/4 v2, 0x1

    .line 89
    aput-object v4, v1, v2

    .line 90
    .line 91
    const/4 v2, 0x2

    .line 92
    aput-object v6, v1, v2

    .line 93
    .line 94
    sget-object v2, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    .line 95
    .line 96
    const/4 v4, 0x3

    .line 97
    aput-object v2, v1, v4

    .line 98
    .line 99
    sget-object v2, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    .line 100
    .line 101
    const/4 v4, 0x4

    .line 102
    aput-object v2, v1, v4

    .line 103
    .line 104
    const/4 v2, 0x5

    .line 105
    aput-object v5, v1, v2

    .line 106
    .line 107
    const/4 v2, 0x6

    .line 108
    aput-object v7, v1, v2

    .line 109
    .line 110
    const/4 v2, 0x7

    .line 111
    aput-object v8, v1, v2

    .line 112
    .line 113
    const/16 v2, 0x8

    .line 114
    .line 115
    aput-object v9, v1, v2

    .line 116
    .line 117
    sget-object v2, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    .line 118
    .line 119
    const/16 v4, 0x9

    .line 120
    .line 121
    aput-object v2, v1, v4

    .line 122
    .line 123
    const/16 v4, 0xa

    .line 124
    .line 125
    aput-object v2, v1, v4

    .line 126
    .line 127
    const/16 v2, 0xb

    .line 128
    .line 129
    aput-object v10, v1, v2

    .line 130
    .line 131
    const/16 v2, 0xc

    .line 132
    .line 133
    aput-object v11, v1, v2

    .line 134
    .line 135
    const/16 v2, 0xd

    .line 136
    .line 137
    aput-object v12, v1, v2

    .line 138
    .line 139
    const/16 v2, 0xe

    .line 140
    .line 141
    aput-object v13, v1, v2

    .line 142
    .line 143
    const/16 v2, 0xf

    .line 144
    .line 145
    aput-object v3, v1, v2

    .line 146
    .line 147
    const/16 v2, 0x10

    .line 148
    .line 149
    aput-object v14, v1, v2

    .line 150
    .line 151
    aput-object v0, v1, v15

    .line 152
    .line 153
    return-object v1
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

.method public deserialize(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;
    .locals 55

    move-object/from16 v0, p1

    const-string v1, "decoder"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual/range {p0 .. p0}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->getDescriptor()Lbh/e;

    move-result-object v1

    invoke-interface {v0, v1}, Lch/e;->b(Lbh/e;)Lch/c;

    move-result-object v0

    invoke-static {}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;->access$get$childSerializers$cp()[Lzg/b;

    move-result-object v2

    invoke-interface {v0}, Lch/c;->z()Z

    move-result v3

    const/4 v11, 0x7

    const/4 v12, 0x6

    const/4 v13, 0x5

    const/4 v14, 0x3

    const/16 v15, 0x8

    const/4 v4, 0x4

    const/4 v5, 0x2

    const/16 v19, 0x11

    const/4 v6, 0x1

    const/4 v7, 0x0

    const/4 v8, 0x0

    if-eqz v3, :cond_0

    aget-object v3, v2, v7

    invoke-interface {v0, v1, v7, v3, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    sget-object v7, Ldh/h;->a:Ldh/h;

    invoke-interface {v0, v1, v6, v7, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    sget-object v9, Ldh/j0;->a:Ldh/j0;

    invoke-interface {v0, v1, v5, v9, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    sget-object v10, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    invoke-interface {v0, v1, v14, v10, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    invoke-interface {v0, v1, v4, v14, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/revenuecat/purchases/paywalls/components/properties/Size;

    invoke-interface {v0, v1, v13, v9, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Integer;

    sget-object v13, Ldh/d0;->a:Ldh/d0;

    invoke-interface {v0, v1, v12, v13, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Float;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    invoke-interface {v0, v1, v11, v13, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;

    sget-object v13, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    invoke-interface {v0, v1, v15, v13, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/revenuecat/purchases/paywalls/components/common/Background;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    const/16 v15, 0x9

    invoke-interface {v0, v1, v15, v14, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    move-object/from16 v23, v2

    const/16 v2, 0xa

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    move-object/from16 v22, v2

    const/16 v2, 0xb

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/properties/Shape;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    move-object/from16 v21, v2

    const/16 v2, 0xc

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/properties/Border;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    move-object/from16 v20, v2

    const/16 v2, 0xd

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    move-object/from16 v18, v2

    const/16 v2, 0xe

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;

    const/16 v14, 0xf

    invoke-interface {v0, v1, v14, v7, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Boolean;

    sget-object v14, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    move-object/from16 v16, v2

    const/16 v2, 0x10

    invoke-interface {v0, v1, v2, v14, v8}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;

    aget-object v14, v23, v19

    move-object/from16 p1, v7

    move/from16 v7, v19

    invoke-interface {v0, v1, v7, v14, v8}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    const v8, 0x3ffff

    move-object/from16 v51, p1

    move-object/from16 v52, v2

    move-object/from16 v36, v3

    move-object/from16 v40, v4

    move-object/from16 v38, v5

    move-object/from16 v37, v6

    move-object/from16 v53, v7

    move-object/from16 v41, v9

    move-object/from16 v39, v10

    move-object/from16 v43, v11

    move-object/from16 v42, v12

    move-object/from16 v45, v15

    move-object/from16 v50, v16

    move-object/from16 v49, v18

    move-object/from16 v48, v20

    move-object/from16 v47, v21

    move-object/from16 v46, v22

    :goto_0
    move/from16 v35, v8

    move-object/from16 v44, v13

    goto/16 :goto_5

    :cond_0
    move-object/from16 v23, v2

    move v2, v7

    move/from16 v7, v19

    move/from16 v19, v2

    move/from16 v31, v6

    move-object v3, v8

    move-object v4, v3

    move-object v5, v4

    move-object v6, v5

    move-object v9, v6

    move-object v10, v9

    move-object v11, v10

    move-object v12, v11

    move-object v13, v12

    move-object v14, v13

    move-object v15, v14

    move-object/from16 v25, v15

    move-object/from16 v26, v25

    move-object/from16 v27, v26

    move-object/from16 v28, v27

    move-object/from16 v29, v28

    move-object/from16 v30, v29

    move/from16 v8, v19

    move-object/from16 v2, v30

    :goto_1
    if-eqz v31, :cond_1

    move/from16 v32, v7

    invoke-interface {v0, v1}, Lch/c;->w(Lbh/e;)I

    move-result v7

    packed-switch v7, :pswitch_data_0

    new-instance v0, Lzg/m;

    invoke-direct {v0, v7}, Lzg/m;-><init>(I)V

    throw v0

    :pswitch_0
    aget-object v7, v23, v32

    move-object/from16 v33, v9

    move/from16 v9, v32

    invoke-interface {v0, v1, v9, v7, v3}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/List;

    const/high16 v7, 0x20000

    or-int/2addr v8, v7

    move v7, v9

    move-object/from16 v9, v33

    goto :goto_1

    :pswitch_1
    move-object/from16 v33, v9

    move/from16 v9, v32

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$$serializer;

    move-object/from16 v9, v29

    move-object/from16 v29, v3

    const/16 v3, 0x10

    invoke-interface {v0, v1, v3, v7, v9}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;

    const/high16 v9, 0x10000

    or-int/2addr v8, v9

    move-object/from16 v3, v29

    move-object/from16 v9, v33

    move-object/from16 v29, v7

    const/16 v7, 0x11

    goto :goto_1

    :pswitch_2
    move-object/from16 v33, v9

    move-object/from16 v9, v29

    move-object/from16 v29, v3

    const/16 v3, 0x10

    sget-object v7, Ldh/h;->a:Ldh/h;

    move-object/from16 v16, v9

    move-object/from16 v3, v28

    const/16 v9, 0xf

    invoke-interface {v0, v1, v9, v7, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object/from16 v28, v3

    check-cast v28, Ljava/lang/Boolean;

    const v3, 0x8000

    or-int/2addr v8, v3

    :goto_2
    move-object/from16 v3, v29

    move-object/from16 v9, v33

    const/16 v7, 0x11

    :goto_3
    move-object/from16 v29, v16

    goto :goto_1

    :pswitch_3
    move-object/from16 v33, v9

    move-object/from16 v16, v29

    const/16 v9, 0xf

    move-object/from16 v29, v3

    move-object/from16 v3, v28

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$$serializer;

    move-object/from16 v17, v3

    move-object/from16 v9, v27

    const/16 v3, 0xe

    invoke-interface {v0, v1, v3, v7, v9}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object/from16 v27, v7

    check-cast v27, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;

    or-int/lit16 v8, v8, 0x4000

    move-object/from16 v28, v17

    goto :goto_2

    :pswitch_4
    move-object/from16 v33, v9

    move-object/from16 v9, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0xe

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Shadow$$serializer;

    move-object/from16 v18, v9

    move-object/from16 v3, v26

    const/16 v9, 0xd

    invoke-interface {v0, v1, v9, v7, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object/from16 v26, v3

    check-cast v26, Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;

    or-int/lit16 v8, v8, 0x2000

    move-object/from16 v27, v18

    goto :goto_2

    :pswitch_5
    move-object/from16 v33, v9

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    const/16 v9, 0xd

    move-object/from16 v29, v3

    move-object/from16 v3, v26

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Border$$serializer;

    move-object/from16 v20, v3

    move-object/from16 v9, v25

    const/16 v3, 0xc

    invoke-interface {v0, v1, v3, v7, v9}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object/from16 v25, v7

    check-cast v25, Lcom/revenuecat/purchases/paywalls/components/properties/Border;

    or-int/lit16 v8, v8, 0x1000

    move-object/from16 v26, v20

    goto :goto_2

    :pswitch_6
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0xc

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ShapeDeserializer;

    const/16 v3, 0xb

    invoke-interface {v0, v1, v3, v7, v15}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v15, v7

    check-cast v15, Lcom/revenuecat/purchases/paywalls/components/properties/Shape;

    or-int/lit16 v8, v8, 0x800

    goto/16 :goto_2

    :pswitch_7
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0xb

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    const/16 v3, 0xa

    invoke-interface {v0, v1, v3, v7, v11}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v11, v7

    check-cast v11, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    or-int/lit16 v8, v8, 0x400

    goto/16 :goto_2

    :pswitch_8
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0xa

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Padding$$serializer;

    const/16 v3, 0x9

    invoke-interface {v0, v1, v3, v7, v12}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v12, v7

    check-cast v12, Lcom/revenuecat/purchases/paywalls/components/properties/Padding;

    or-int/lit16 v8, v8, 0x200

    goto/16 :goto_2

    :pswitch_9
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0x9

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/common/BackgroundDeserializer;

    const/16 v3, 0x8

    invoke-interface {v0, v1, v3, v7, v13}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v13, v7

    check-cast v13, Lcom/revenuecat/purchases/paywalls/components/common/Background;

    or-int/lit16 v8, v8, 0x100

    goto/16 :goto_2

    :pswitch_a
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/16 v3, 0x8

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme$$serializer;

    const/4 v3, 0x7

    invoke-interface {v0, v1, v3, v7, v4}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;

    or-int/lit16 v8, v8, 0x80

    goto/16 :goto_2

    :pswitch_b
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x7

    sget-object v7, Ldh/d0;->a:Ldh/d0;

    const/4 v3, 0x6

    invoke-interface {v0, v1, v3, v7, v14}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v14, v7

    check-cast v14, Ljava/lang/Float;

    or-int/lit8 v8, v8, 0x40

    goto/16 :goto_2

    :pswitch_c
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x6

    sget-object v7, Ldh/j0;->a:Ldh/j0;

    const/4 v3, 0x5

    invoke-interface {v0, v1, v3, v7, v5}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    or-int/lit8 v8, v8, 0x20

    goto/16 :goto_2

    :pswitch_d
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x5

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/Size$$serializer;

    const/4 v3, 0x4

    invoke-interface {v0, v1, v3, v7, v6}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/revenuecat/purchases/paywalls/components/properties/Size;

    or-int/lit8 v8, v8, 0x10

    goto/16 :goto_2

    :pswitch_e
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x4

    sget-object v7, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;->INSTANCE:Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignmentDeserializer;

    const/4 v3, 0x3

    invoke-interface {v0, v1, v3, v7, v2}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;

    or-int/lit8 v8, v8, 0x8

    goto/16 :goto_2

    :pswitch_f
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x3

    sget-object v7, Ldh/j0;->a:Ldh/j0;

    const/4 v3, 0x2

    invoke-interface {v0, v1, v3, v7, v10}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v10, v7

    check-cast v10, Ljava/lang/Integer;

    or-int/lit8 v8, v8, 0x4

    goto/16 :goto_2

    :pswitch_10
    move-object/from16 v33, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v29, v3

    const/4 v3, 0x2

    sget-object v7, Ldh/h;->a:Ldh/h;

    move-object/from16 v24, v2

    move-object/from16 v3, v33

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2, v7, v3}, Lch/c;->n(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    or-int/lit8 v8, v8, 0x2

    move-object/from16 v2, v24

    const/16 v7, 0x11

    move-object v9, v3

    :goto_4
    move-object/from16 v3, v29

    goto/16 :goto_3

    :pswitch_11
    move-object/from16 v24, v2

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    const/4 v2, 0x1

    move-object/from16 v29, v3

    move-object v3, v9

    move-object/from16 v9, v25

    aget-object v7, v23, v19

    move/from16 v2, v19

    move-object/from16 v19, v3

    move v3, v2

    move-object/from16 v2, v30

    invoke-interface {v0, v1, v3, v7, v2}, Lch/c;->h(Lbh/e;ILzg/a;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object/from16 v30, v2

    check-cast v30, Ljava/util/List;

    or-int/lit8 v8, v8, 0x1

    move-object/from16 v9, v19

    move-object/from16 v2, v24

    const/16 v7, 0x11

    move/from16 v19, v3

    goto :goto_4

    :pswitch_12
    move-object/from16 v24, v2

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v2, v30

    move-object/from16 v29, v3

    move/from16 v3, v19

    move-object/from16 v19, v9

    move-object/from16 v9, v25

    move/from16 v31, v3

    move-object/from16 v9, v19

    move-object/from16 v2, v24

    const/16 v7, 0x11

    move/from16 v19, v31

    goto :goto_4

    :cond_1
    move-object/from16 v24, v2

    move-object/from16 v19, v9

    move-object/from16 v9, v25

    move-object/from16 v20, v26

    move-object/from16 v18, v27

    move-object/from16 v17, v28

    move-object/from16 v16, v29

    move-object/from16 v2, v30

    move-object/from16 v29, v3

    move-object/from16 v36, v2

    move-object/from16 v43, v4

    move-object/from16 v41, v5

    move-object/from16 v40, v6

    move-object/from16 v48, v9

    move-object/from16 v38, v10

    move-object/from16 v46, v11

    move-object/from16 v45, v12

    move-object/from16 v42, v14

    move-object/from16 v47, v15

    move-object/from16 v52, v16

    move-object/from16 v51, v17

    move-object/from16 v50, v18

    move-object/from16 v37, v19

    move-object/from16 v49, v20

    move-object/from16 v39, v24

    move-object/from16 v53, v29

    goto/16 :goto_0

    :goto_5
    invoke-interface {v0, v1}, Lch/c;->c(Lbh/e;)V

    new-instance v34, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;

    const/16 v54, 0x0

    invoke-direct/range {v34 .. v54}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;-><init>(ILjava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/revenuecat/purchases/paywalls/components/properties/VerticalAlignment;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/Integer;Ljava/lang/Float;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lcom/revenuecat/purchases/paywalls/components/common/Background;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/paywalls/components/properties/Border;Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Ljava/util/List;Ldh/s1;)V

    return-object v34

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_12
        :pswitch_11
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
    invoke-virtual {p0, p1}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->deserialize(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;

    move-result-object p1

    return-object p1
.end method

.method public getDescriptor()Lbh/e;
    .locals 1

    .line 1
    sget-object v0, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->descriptor:Ldh/j1;

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

.method public serialize(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;)V
    .locals 1

    const-string v0, "encoder"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "value"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1
    invoke-virtual {p0}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->getDescriptor()Lbh/e;

    move-result-object v0

    invoke-interface {p1, v0}, Lch/f;->b(Lbh/e;)Lch/d;

    move-result-object p1

    invoke-static {p2, p1, v0}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;->write$Self$purchases_defaultsBc8Release(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;Lch/d;Lbh/e;)V

    invoke-interface {p1, v0}, Lch/d;->c(Lbh/e;)V

    return-void
.end method

.method public bridge synthetic serialize(Lch/f;Ljava/lang/Object;)V
    .locals 0

    .line 2
    check-cast p2, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;

    invoke-virtual {p0, p1, p2}, Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$$serializer;->serialize(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;)V

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
