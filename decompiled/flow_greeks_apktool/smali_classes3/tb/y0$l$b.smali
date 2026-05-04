.class public Ltb/y0$l$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/y0$l;->c(Lrb/k1;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lrb/k1;

.field public final synthetic b:Ltb/y0$l;


# direct methods
.method public constructor <init>(Ltb/y0$l;Lrb/k1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/y0$l$b;->a:Lrb/k1;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
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
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 2
    .line 3
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 4
    .line 5
    invoke-static {v0}, Ltb/y0;->i(Ltb/y0;)Lrb/q;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    invoke-virtual {v0}, Lrb/q;->c()Lrb/p;

    .line 10
    .line 11
    .line 12
    move-result-object v0

    .line 13
    sget-object v1, Lrb/p;->e:Lrb/p;

    .line 14
    .line 15
    if-ne v0, v1, :cond_0

    .line 16
    .line 17
    goto/16 :goto_1

    .line 18
    .line 19
    :cond_0
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 20
    .line 21
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 22
    .line 23
    invoke-static {v0}, Ltb/y0;->j(Ltb/y0;)Ltb/k1;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    iget-object v1, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 28
    .line 29
    iget-object v2, v1, Ltb/y0$l;->a:Ltb/w;

    .line 30
    .line 31
    const/4 v3, 0x0

    .line 32
    if-ne v0, v2, :cond_1

    .line 33
    .line 34
    iget-object v0, v1, Ltb/y0$l;->c:Ltb/y0;

    .line 35
    .line 36
    invoke-static {v0, v3}, Ltb/y0;->k(Ltb/y0;Ltb/k1;)Ltb/k1;

    .line 37
    .line 38
    .line 39
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 40
    .line 41
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 42
    .line 43
    invoke-static {v0}, Ltb/y0;->J(Ltb/y0;)Ltb/y0$k;

    .line 44
    .line 45
    .line 46
    move-result-object v0

    .line 47
    invoke-virtual {v0}, Ltb/y0$k;->f()V

    .line 48
    .line 49
    .line 50
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 51
    .line 52
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 53
    .line 54
    sget-object v1, Lrb/p;->d:Lrb/p;

    .line 55
    .line 56
    invoke-static {v0, v1}, Ltb/y0;->F(Ltb/y0;Lrb/p;)V

    .line 57
    .line 58
    .line 59
    return-void

    .line 60
    :cond_1
    iget-object v0, v1, Ltb/y0$l;->c:Ltb/y0;

    .line 61
    .line 62
    invoke-static {v0}, Ltb/y0;->l(Ltb/y0;)Ltb/w;

    .line 63
    .line 64
    .line 65
    move-result-object v0

    .line 66
    iget-object v1, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 67
    .line 68
    iget-object v2, v1, Ltb/y0$l;->a:Ltb/w;

    .line 69
    .line 70
    if-ne v0, v2, :cond_4

    .line 71
    .line 72
    iget-object v0, v1, Ltb/y0$l;->c:Ltb/y0;

    .line 73
    .line 74
    invoke-static {v0}, Ltb/y0;->i(Ltb/y0;)Lrb/q;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    invoke-virtual {v0}, Lrb/q;->c()Lrb/p;

    .line 79
    .line 80
    .line 81
    move-result-object v0

    .line 82
    sget-object v1, Lrb/p;->a:Lrb/p;

    .line 83
    .line 84
    if-ne v0, v1, :cond_2

    .line 85
    .line 86
    const/4 v0, 0x1

    .line 87
    goto :goto_0

    .line 88
    :cond_2
    const/4 v0, 0x0

    .line 89
    :goto_0
    iget-object v1, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 90
    .line 91
    iget-object v1, v1, Ltb/y0$l;->c:Ltb/y0;

    .line 92
    .line 93
    invoke-static {v1}, Ltb/y0;->i(Ltb/y0;)Lrb/q;

    .line 94
    .line 95
    .line 96
    move-result-object v1

    .line 97
    invoke-virtual {v1}, Lrb/q;->c()Lrb/p;

    .line 98
    .line 99
    .line 100
    move-result-object v1

    .line 101
    const-string v2, "Expected state is CONNECTING, actual state is %s"

    .line 102
    .line 103
    invoke-static {v0, v2, v1}, Lp6/n;->x(ZLjava/lang/String;Ljava/lang/Object;)V

    .line 104
    .line 105
    .line 106
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 107
    .line 108
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 109
    .line 110
    invoke-static {v0}, Ltb/y0;->J(Ltb/y0;)Ltb/y0$k;

    .line 111
    .line 112
    .line 113
    move-result-object v0

    .line 114
    invoke-virtual {v0}, Ltb/y0$k;->c()V

    .line 115
    .line 116
    .line 117
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 118
    .line 119
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 120
    .line 121
    invoke-static {v0}, Ltb/y0;->J(Ltb/y0;)Ltb/y0$k;

    .line 122
    .line 123
    .line 124
    move-result-object v0

    .line 125
    invoke-virtual {v0}, Ltb/y0$k;->e()Z

    .line 126
    .line 127
    .line 128
    move-result v0

    .line 129
    if-nez v0, :cond_3

    .line 130
    .line 131
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 132
    .line 133
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 134
    .line 135
    invoke-static {v0, v3}, Ltb/y0;->m(Ltb/y0;Ltb/w;)Ltb/w;

    .line 136
    .line 137
    .line 138
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 139
    .line 140
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 141
    .line 142
    invoke-static {v0}, Ltb/y0;->J(Ltb/y0;)Ltb/y0$k;

    .line 143
    .line 144
    .line 145
    move-result-object v0

    .line 146
    invoke-virtual {v0}, Ltb/y0$k;->f()V

    .line 147
    .line 148
    .line 149
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 150
    .line 151
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 152
    .line 153
    iget-object v1, p0, Ltb/y0$l$b;->a:Lrb/k1;

    .line 154
    .line 155
    invoke-static {v0, v1}, Ltb/y0;->D(Ltb/y0;Lrb/k1;)V

    .line 156
    .line 157
    .line 158
    return-void

    .line 159
    :cond_3
    iget-object v0, p0, Ltb/y0$l$b;->b:Ltb/y0$l;

    .line 160
    .line 161
    iget-object v0, v0, Ltb/y0$l;->c:Ltb/y0;

    .line 162
    .line 163
    invoke-static {v0}, Ltb/y0;->G(Ltb/y0;)V

    .line 164
    .line 165
    .line 166
    :cond_4
    :goto_1
    return-void
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
