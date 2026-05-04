.class public abstract Lyd/a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public static final a(Lwd/c;)Z
    .locals 5

    .line 1
    const-string v0, "<this>"

    .line 2
    .line 3
    invoke-static {p0, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    instance-of v0, p0, Lwd/i;

    .line 7
    .line 8
    const/4 v1, 0x0

    .line 9
    const/4 v2, 0x1

    .line 10
    if-eqz v0, :cond_4

    .line 11
    .line 12
    move-object v0, p0

    .line 13
    check-cast v0, Lwd/m;

    .line 14
    .line 15
    invoke-static {v0}, Lyd/c;->b(Lwd/m;)Ljava/lang/reflect/Field;

    .line 16
    .line 17
    .line 18
    move-result-object v3

    .line 19
    if-eqz v3, :cond_0

    .line 20
    .line 21
    invoke-virtual {v3}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 22
    .line 23
    .line 24
    move-result v3

    .line 25
    goto :goto_0

    .line 26
    :cond_0
    move v3, v2

    .line 27
    :goto_0
    if-eqz v3, :cond_3

    .line 28
    .line 29
    invoke-static {v0}, Lyd/c;->c(Lwd/m;)Ljava/lang/reflect/Method;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    if-eqz v0, :cond_1

    .line 34
    .line 35
    invoke-virtual {v0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 36
    .line 37
    .line 38
    move-result v0

    .line 39
    goto :goto_1

    .line 40
    :cond_1
    move v0, v2

    .line 41
    :goto_1
    if-eqz v0, :cond_3

    .line 42
    .line 43
    check-cast p0, Lwd/i;

    .line 44
    .line 45
    invoke-static {p0}, Lyd/c;->e(Lwd/i;)Ljava/lang/reflect/Method;

    .line 46
    .line 47
    .line 48
    move-result-object p0

    .line 49
    if-eqz p0, :cond_2

    .line 50
    .line 51
    invoke-virtual {p0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 52
    .line 53
    .line 54
    move-result p0

    .line 55
    goto :goto_2

    .line 56
    :cond_2
    move p0, v2

    .line 57
    :goto_2
    if-eqz p0, :cond_3

    .line 58
    .line 59
    return v2

    .line 60
    :cond_3
    return v1

    .line 61
    :cond_4
    instance-of v0, p0, Lwd/m;

    .line 62
    .line 63
    if-eqz v0, :cond_8

    .line 64
    .line 65
    check-cast p0, Lwd/m;

    .line 66
    .line 67
    invoke-static {p0}, Lyd/c;->b(Lwd/m;)Ljava/lang/reflect/Field;

    .line 68
    .line 69
    .line 70
    move-result-object v0

    .line 71
    if-eqz v0, :cond_5

    .line 72
    .line 73
    invoke-virtual {v0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 74
    .line 75
    .line 76
    move-result v0

    .line 77
    goto :goto_3

    .line 78
    :cond_5
    move v0, v2

    .line 79
    :goto_3
    if-eqz v0, :cond_7

    .line 80
    .line 81
    invoke-static {p0}, Lyd/c;->c(Lwd/m;)Ljava/lang/reflect/Method;

    .line 82
    .line 83
    .line 84
    move-result-object p0

    .line 85
    if-eqz p0, :cond_6

    .line 86
    .line 87
    invoke-virtual {p0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 88
    .line 89
    .line 90
    move-result p0

    .line 91
    goto :goto_4

    .line 92
    :cond_6
    move p0, v2

    .line 93
    :goto_4
    if-eqz p0, :cond_7

    .line 94
    .line 95
    return v2

    .line 96
    :cond_7
    return v1

    .line 97
    :cond_8
    instance-of v0, p0, Lwd/m$b;

    .line 98
    .line 99
    if-eqz v0, :cond_c

    .line 100
    .line 101
    move-object v0, p0

    .line 102
    check-cast v0, Lwd/m$b;

    .line 103
    .line 104
    invoke-interface {v0}, Lwd/m$a;->o()Lwd/m;

    .line 105
    .line 106
    .line 107
    move-result-object v0

    .line 108
    invoke-static {v0}, Lyd/c;->b(Lwd/m;)Ljava/lang/reflect/Field;

    .line 109
    .line 110
    .line 111
    move-result-object v0

    .line 112
    if-eqz v0, :cond_9

    .line 113
    .line 114
    invoke-virtual {v0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 115
    .line 116
    .line 117
    move-result v0

    .line 118
    goto :goto_5

    .line 119
    :cond_9
    move v0, v2

    .line 120
    :goto_5
    if-eqz v0, :cond_b

    .line 121
    .line 122
    check-cast p0, Lwd/h;

    .line 123
    .line 124
    invoke-static {p0}, Lyd/c;->d(Lwd/h;)Ljava/lang/reflect/Method;

    .line 125
    .line 126
    .line 127
    move-result-object p0

    .line 128
    if-eqz p0, :cond_a

    .line 129
    .line 130
    invoke-virtual {p0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 131
    .line 132
    .line 133
    move-result p0

    .line 134
    goto :goto_6

    .line 135
    :cond_a
    move p0, v2

    .line 136
    :goto_6
    if-eqz p0, :cond_b

    .line 137
    .line 138
    return v2

    .line 139
    :cond_b
    return v1

    .line 140
    :cond_c
    instance-of v0, p0, Lwd/i$a;

    .line 141
    .line 142
    if-eqz v0, :cond_10

    .line 143
    .line 144
    move-object v0, p0

    .line 145
    check-cast v0, Lwd/i$a;

    .line 146
    .line 147
    invoke-interface {v0}, Lwd/m$a;->o()Lwd/m;

    .line 148
    .line 149
    .line 150
    move-result-object v0

    .line 151
    invoke-static {v0}, Lyd/c;->b(Lwd/m;)Ljava/lang/reflect/Field;

    .line 152
    .line 153
    .line 154
    move-result-object v0

    .line 155
    if-eqz v0, :cond_d

    .line 156
    .line 157
    invoke-virtual {v0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 158
    .line 159
    .line 160
    move-result v0

    .line 161
    goto :goto_7

    .line 162
    :cond_d
    move v0, v2

    .line 163
    :goto_7
    if-eqz v0, :cond_f

    .line 164
    .line 165
    check-cast p0, Lwd/h;

    .line 166
    .line 167
    invoke-static {p0}, Lyd/c;->d(Lwd/h;)Ljava/lang/reflect/Method;

    .line 168
    .line 169
    .line 170
    move-result-object p0

    .line 171
    if-eqz p0, :cond_e

    .line 172
    .line 173
    invoke-virtual {p0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 174
    .line 175
    .line 176
    move-result p0

    .line 177
    goto :goto_8

    .line 178
    :cond_e
    move p0, v2

    .line 179
    :goto_8
    if-eqz p0, :cond_f

    .line 180
    .line 181
    return v2

    .line 182
    :cond_f
    return v1

    .line 183
    :cond_10
    instance-of v0, p0, Lwd/h;

    .line 184
    .line 185
    if-eqz v0, :cond_17

    .line 186
    .line 187
    move-object v0, p0

    .line 188
    check-cast v0, Lwd/h;

    .line 189
    .line 190
    invoke-static {v0}, Lyd/c;->d(Lwd/h;)Ljava/lang/reflect/Method;

    .line 191
    .line 192
    .line 193
    move-result-object v3

    .line 194
    if-eqz v3, :cond_11

    .line 195
    .line 196
    invoke-virtual {v3}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 197
    .line 198
    .line 199
    move-result v3

    .line 200
    goto :goto_9

    .line 201
    :cond_11
    move v3, v2

    .line 202
    :goto_9
    if-eqz v3, :cond_16

    .line 203
    .line 204
    invoke-static {p0}, Lzd/i3;->b(Ljava/lang/Object;)Lzd/a0;

    .line 205
    .line 206
    .line 207
    move-result-object p0

    .line 208
    const/4 v3, 0x0

    .line 209
    if-eqz p0, :cond_12

    .line 210
    .line 211
    invoke-virtual {p0}, Lzd/a0;->Q()Lae/h;

    .line 212
    .line 213
    .line 214
    move-result-object p0

    .line 215
    if-eqz p0, :cond_12

    .line 216
    .line 217
    invoke-interface {p0}, Lae/h;->b()Ljava/lang/reflect/Member;

    .line 218
    .line 219
    .line 220
    move-result-object p0

    .line 221
    goto :goto_a

    .line 222
    :cond_12
    move-object p0, v3

    .line 223
    :goto_a
    instance-of v4, p0, Ljava/lang/reflect/AccessibleObject;

    .line 224
    .line 225
    if-eqz v4, :cond_13

    .line 226
    .line 227
    move-object v3, p0

    .line 228
    check-cast v3, Ljava/lang/reflect/AccessibleObject;

    .line 229
    .line 230
    :cond_13
    if-eqz v3, :cond_14

    .line 231
    .line 232
    invoke-virtual {v3}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 233
    .line 234
    .line 235
    move-result p0

    .line 236
    goto :goto_b

    .line 237
    :cond_14
    move p0, v2

    .line 238
    :goto_b
    if-eqz p0, :cond_16

    .line 239
    .line 240
    invoke-static {v0}, Lyd/c;->a(Lwd/h;)Ljava/lang/reflect/Constructor;

    .line 241
    .line 242
    .line 243
    move-result-object p0

    .line 244
    if-eqz p0, :cond_15

    .line 245
    .line 246
    invoke-virtual {p0}, Ljava/lang/reflect/AccessibleObject;->isAccessible()Z

    .line 247
    .line 248
    .line 249
    move-result p0

    .line 250
    goto :goto_c

    .line 251
    :cond_15
    move p0, v2

    .line 252
    :goto_c
    if-eqz p0, :cond_16

    .line 253
    .line 254
    return v2

    .line 255
    :cond_16
    return v1

    .line 256
    :cond_17
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    .line 257
    .line 258
    new-instance v1, Ljava/lang/StringBuilder;

    .line 259
    .line 260
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 261
    .line 262
    .line 263
    const-string v2, "Unknown callable: "

    .line 264
    .line 265
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 266
    .line 267
    .line 268
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 269
    .line 270
    .line 271
    const-string v2, " ("

    .line 272
    .line 273
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 274
    .line 275
    .line 276
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    .line 277
    .line 278
    .line 279
    move-result-object p0

    .line 280
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 281
    .line 282
    .line 283
    const/16 p0, 0x29

    .line 284
    .line 285
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 286
    .line 287
    .line 288
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 289
    .line 290
    .line 291
    move-result-object p0

    .line 292
    invoke-direct {v0, p0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    .line 293
    .line 294
    .line 295
    throw v0
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
