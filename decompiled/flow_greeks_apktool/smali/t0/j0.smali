.class public Lt0/j0;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lt0/j0$l;,
        Lt0/j0$m;,
        Lt0/j0$k;,
        Lt0/j0$j;,
        Lt0/j0$i;,
        Lt0/j0$h;,
        Lt0/j0$g;,
        Lt0/j0$n;,
        Lt0/j0$a;,
        Lt0/j0$p;,
        Lt0/j0$o;,
        Lt0/j0$e;,
        Lt0/j0$d;,
        Lt0/j0$c;,
        Lt0/j0$b;,
        Lt0/j0$f;
    }
.end annotation


# static fields
.field public static final b:Lt0/j0;


# instance fields
.field public final a:Lt0/j0$m;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 2
    .line 3
    const/16 v1, 0x22

    .line 4
    .line 5
    if-lt v0, v1, :cond_0

    .line 6
    .line 7
    sget-object v0, Lt0/j0$l;->s:Lt0/j0;

    .line 8
    .line 9
    sput-object v0, Lt0/j0;->b:Lt0/j0;

    .line 10
    .line 11
    return-void

    .line 12
    :cond_0
    const/16 v1, 0x1e

    .line 13
    .line 14
    if-lt v0, v1, :cond_1

    .line 15
    .line 16
    sget-object v0, Lt0/j0$k;->r:Lt0/j0;

    .line 17
    .line 18
    sput-object v0, Lt0/j0;->b:Lt0/j0;

    .line 19
    .line 20
    return-void

    .line 21
    :cond_1
    sget-object v0, Lt0/j0$m;->b:Lt0/j0;

    .line 22
    .line 23
    sput-object v0, Lt0/j0;->b:Lt0/j0;

    .line 24
    .line 25
    return-void
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
.end method

.method public constructor <init>(Landroid/view/WindowInsets;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-lt v0, v1, :cond_0

    .line 3
    new-instance v0, Lt0/j0$l;

    invoke-direct {v0, p0, p1}, Lt0/j0$l;-><init>(Lt0/j0;Landroid/view/WindowInsets;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void

    :cond_0
    const/16 v1, 0x1e

    if-lt v0, v1, :cond_1

    .line 4
    new-instance v0, Lt0/j0$k;

    invoke-direct {v0, p0, p1}, Lt0/j0$k;-><init>(Lt0/j0;Landroid/view/WindowInsets;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void

    :cond_1
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_2

    .line 5
    new-instance v0, Lt0/j0$j;

    invoke-direct {v0, p0, p1}, Lt0/j0$j;-><init>(Lt0/j0;Landroid/view/WindowInsets;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void

    :cond_2
    const/16 v1, 0x1c

    if-lt v0, v1, :cond_3

    .line 6
    new-instance v0, Lt0/j0$i;

    invoke-direct {v0, p0, p1}, Lt0/j0$i;-><init>(Lt0/j0;Landroid/view/WindowInsets;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void

    .line 7
    :cond_3
    new-instance v0, Lt0/j0$h;

    invoke-direct {v0, p0, p1}, Lt0/j0$h;-><init>(Lt0/j0;Landroid/view/WindowInsets;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void
.end method

.method public constructor <init>(Lt0/j0;)V
    .locals 2

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-eqz p1, :cond_6

    .line 9
    iget-object p1, p1, Lt0/j0;->a:Lt0/j0$m;

    .line 10
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x22

    if-lt v0, v1, :cond_0

    instance-of v1, p1, Lt0/j0$l;

    if-eqz v1, :cond_0

    .line 11
    new-instance v0, Lt0/j0$l;

    move-object v1, p1

    check-cast v1, Lt0/j0$l;

    invoke-direct {v0, p0, v1}, Lt0/j0$l;-><init>(Lt0/j0;Lt0/j0$l;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    :cond_0
    const/16 v1, 0x1e

    if-lt v0, v1, :cond_1

    .line 12
    instance-of v1, p1, Lt0/j0$k;

    if-eqz v1, :cond_1

    .line 13
    new-instance v0, Lt0/j0$k;

    move-object v1, p1

    check-cast v1, Lt0/j0$k;

    invoke-direct {v0, p0, v1}, Lt0/j0$k;-><init>(Lt0/j0;Lt0/j0$k;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    :cond_1
    const/16 v1, 0x1d

    if-lt v0, v1, :cond_2

    .line 14
    instance-of v1, p1, Lt0/j0$j;

    if-eqz v1, :cond_2

    .line 15
    new-instance v0, Lt0/j0$j;

    move-object v1, p1

    check-cast v1, Lt0/j0$j;

    invoke-direct {v0, p0, v1}, Lt0/j0$j;-><init>(Lt0/j0;Lt0/j0$j;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    :cond_2
    const/16 v1, 0x1c

    if-lt v0, v1, :cond_3

    .line 16
    instance-of v0, p1, Lt0/j0$i;

    if-eqz v0, :cond_3

    .line 17
    new-instance v0, Lt0/j0$i;

    move-object v1, p1

    check-cast v1, Lt0/j0$i;

    invoke-direct {v0, p0, v1}, Lt0/j0$i;-><init>(Lt0/j0;Lt0/j0$i;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    .line 18
    :cond_3
    instance-of v0, p1, Lt0/j0$h;

    if-eqz v0, :cond_4

    .line 19
    new-instance v0, Lt0/j0$h;

    move-object v1, p1

    check-cast v1, Lt0/j0$h;

    invoke-direct {v0, p0, v1}, Lt0/j0$h;-><init>(Lt0/j0;Lt0/j0$h;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    .line 20
    :cond_4
    instance-of v0, p1, Lt0/j0$g;

    if-eqz v0, :cond_5

    .line 21
    new-instance v0, Lt0/j0$g;

    move-object v1, p1

    check-cast v1, Lt0/j0$g;

    invoke-direct {v0, p0, v1}, Lt0/j0$g;-><init>(Lt0/j0;Lt0/j0$g;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    goto :goto_0

    .line 22
    :cond_5
    new-instance v0, Lt0/j0$m;

    invoke-direct {v0, p0}, Lt0/j0$m;-><init>(Lt0/j0;)V

    iput-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 23
    :goto_0
    invoke-virtual {p1, p0}, Lt0/j0$m;->e(Lt0/j0;)V

    return-void

    .line 24
    :cond_6
    new-instance p1, Lt0/j0$m;

    invoke-direct {p1, p0}, Lt0/j0$m;-><init>(Lt0/j0;)V

    iput-object p1, p0, Lt0/j0;->a:Lt0/j0$m;

    return-void
.end method

.method public static m(Ll0/b;IIII)Ll0/b;
    .locals 5

    .line 1
    iget v0, p0, Ll0/b;->a:I

    .line 2
    .line 3
    sub-int/2addr v0, p1

    .line 4
    const/4 v1, 0x0

    .line 5
    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    iget v2, p0, Ll0/b;->b:I

    .line 10
    .line 11
    sub-int/2addr v2, p2

    .line 12
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    .line 13
    .line 14
    .line 15
    move-result v2

    .line 16
    iget v3, p0, Ll0/b;->c:I

    .line 17
    .line 18
    sub-int/2addr v3, p3

    .line 19
    invoke-static {v1, v3}, Ljava/lang/Math;->max(II)I

    .line 20
    .line 21
    .line 22
    move-result v3

    .line 23
    iget v4, p0, Ll0/b;->d:I

    .line 24
    .line 25
    sub-int/2addr v4, p4

    .line 26
    invoke-static {v1, v4}, Ljava/lang/Math;->max(II)I

    .line 27
    .line 28
    .line 29
    move-result v1

    .line 30
    if-ne v0, p1, :cond_0

    .line 31
    .line 32
    if-ne v2, p2, :cond_0

    .line 33
    .line 34
    if-ne v3, p3, :cond_0

    .line 35
    .line 36
    if-ne v1, p4, :cond_0

    .line 37
    .line 38
    return-object p0

    .line 39
    :cond_0
    invoke-static {v0, v2, v3, v1}, Ll0/b;->b(IIII)Ll0/b;

    .line 40
    .line 41
    .line 42
    move-result-object p0

    .line 43
    return-object p0
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
.end method

.method public static v(Landroid/view/WindowInsets;)Lt0/j0;
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    invoke-static {p0, v0}, Lt0/j0;->w(Landroid/view/WindowInsets;Landroid/view/View;)Lt0/j0;

    .line 3
    .line 4
    .line 5
    move-result-object p0

    .line 6
    return-object p0
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
.end method

.method public static w(Landroid/view/WindowInsets;Landroid/view/View;)Lt0/j0;
    .locals 1

    .line 1
    new-instance v0, Lt0/j0;

    .line 2
    .line 3
    invoke-static {p0}, Ls0/f;->d(Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Landroid/view/WindowInsets;

    .line 8
    .line 9
    invoke-direct {v0, p0}, Lt0/j0;-><init>(Landroid/view/WindowInsets;)V

    .line 10
    .line 11
    .line 12
    if-eqz p1, :cond_0

    .line 13
    .line 14
    invoke-virtual {p1}, Landroid/view/View;->isAttachedToWindow()Z

    .line 15
    .line 16
    .line 17
    move-result p0

    .line 18
    if-eqz p0, :cond_0

    .line 19
    .line 20
    invoke-static {p1}, Lt0/c0;->t(Landroid/view/View;)Lt0/j0;

    .line 21
    .line 22
    .line 23
    move-result-object p0

    .line 24
    invoke-virtual {v0, p0}, Lt0/j0;->r(Lt0/j0;)V

    .line 25
    .line 26
    .line 27
    invoke-virtual {p1}, Landroid/view/View;->getRootView()Landroid/view/View;

    .line 28
    .line 29
    .line 30
    move-result-object p0

    .line 31
    invoke-virtual {v0, p0}, Lt0/j0;->d(Landroid/view/View;)V

    .line 32
    .line 33
    .line 34
    invoke-virtual {p1}, Landroid/view/View;->getWindowSystemUiVisibility()I

    .line 35
    .line 36
    .line 37
    move-result p0

    .line 38
    invoke-virtual {v0, p0}, Lt0/j0;->t(I)V

    .line 39
    .line 40
    .line 41
    :cond_0
    return-object v0
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
.end method


# virtual methods
.method public a()Lt0/j0;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->a()Lt0/j0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public b()Lt0/j0;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->b()Lt0/j0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public c()Lt0/j0;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->c()Lt0/j0;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public d(Landroid/view/View;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->d(Landroid/view/View;)V

    .line 4
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
.end method

.method public e()Lt0/g;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->f()Lt0/g;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1

    .line 1
    if-ne p0, p1, :cond_0

    .line 2
    .line 3
    const/4 p1, 0x1

    .line 4
    return p1

    .line 5
    :cond_0
    instance-of v0, p1, Lt0/j0;

    .line 6
    .line 7
    if-nez v0, :cond_1

    .line 8
    .line 9
    const/4 p1, 0x0

    .line 10
    return p1

    .line 11
    :cond_1
    check-cast p1, Lt0/j0;

    .line 12
    .line 13
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 14
    .line 15
    iget-object p1, p1, Lt0/j0;->a:Lt0/j0$m;

    .line 16
    .line 17
    invoke-static {v0, p1}, Ls0/b;->a(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 18
    .line 19
    .line 20
    move-result p1

    .line 21
    return p1
    .line 22
    .line 23
    .line 24
.end method

.method public f(I)Ll0/b;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->g(I)Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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
.end method

.method public g()Ll0/b;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->i()Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    return-object v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public h()I
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->k()Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget v0, v0, Ll0/b;->d:I

    .line 8
    .line 9
    return v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public hashCode()I
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x0

    .line 6
    return v0

    .line 7
    :cond_0
    invoke-virtual {v0}, Lt0/j0$m;->hashCode()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    return v0
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public i()I
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->k()Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget v0, v0, Ll0/b;->a:I

    .line 8
    .line 9
    return v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public j()I
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->k()Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget v0, v0, Ll0/b;->c:I

    .line 8
    .line 9
    return v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public k()I
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->k()Ll0/b;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget v0, v0, Ll0/b;->b:I

    .line 8
    .line 9
    return v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public l(IIII)Lt0/j0;
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1, p2, p3, p4}, Lt0/j0$m;->m(IIII)Lt0/j0;

    .line 4
    .line 5
    .line 6
    move-result-object p1

    .line 7
    return-object p1
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
.end method

.method public n()Z
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0}, Lt0/j0$m;->n()Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    return v0
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method

.method public o(I)Z
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->p(I)Z

    .line 4
    .line 5
    .line 6
    move-result p1

    .line 7
    return p1
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
.end method

.method public p([Ll0/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->q([Ll0/b;)V

    .line 4
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
.end method

.method public q(Ll0/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->r(Ll0/b;)V

    .line 4
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
.end method

.method public r(Lt0/j0;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->s(Lt0/j0;)V

    .line 4
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
.end method

.method public s(Ll0/b;)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->t(Ll0/b;)V

    .line 4
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
.end method

.method public t(I)V
    .locals 1

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Lt0/j0$m;->u(I)V

    .line 4
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
.end method

.method public u()Landroid/view/WindowInsets;
    .locals 2

    .line 1
    iget-object v0, p0, Lt0/j0;->a:Lt0/j0$m;

    .line 2
    .line 3
    instance-of v1, v0, Lt0/j0$g;

    .line 4
    .line 5
    if-eqz v1, :cond_0

    .line 6
    .line 7
    check-cast v0, Lt0/j0$g;

    .line 8
    .line 9
    iget-object v0, v0, Lt0/j0$g;->c:Landroid/view/WindowInsets;

    .line 10
    .line 11
    return-object v0

    .line 12
    :cond_0
    const/4 v0, 0x0

    .line 13
    return-object v0
    .line 14
    .line 15
    .line 16
.end method
