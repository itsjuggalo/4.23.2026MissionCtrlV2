.class public Lcom/google/firebase/appcheck/FirebaseAppCheckRegistrar;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcom/google/firebase/components/ComponentRegistrar;


# direct methods
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
.end method

.method public static synthetic a(Lo7/e0;Lo7/e0;Lo7/e0;Lo7/e0;Lo7/d;)Le7/e;
    .locals 7

    .line 1
    new-instance v0, Lh7/j;

    .line 2
    .line 3
    const-class v1, La7/g;

    .line 4
    .line 5
    invoke-interface {p4, v1}, Lo7/d;->get(Ljava/lang/Class;)Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    check-cast v1, La7/g;

    .line 10
    .line 11
    const-class v2, Lo9/i;

    .line 12
    .line 13
    invoke-interface {p4, v2}, Lo7/d;->b(Ljava/lang/Class;)Lfa/b;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    invoke-interface {p4, p0}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object p0

    .line 21
    move-object v3, p0

    .line 22
    check-cast v3, Ljava/util/concurrent/Executor;

    .line 23
    .line 24
    invoke-interface {p4, p1}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 25
    .line 26
    .line 27
    move-result-object p0

    .line 28
    move-object v4, p0

    .line 29
    check-cast v4, Ljava/util/concurrent/Executor;

    .line 30
    .line 31
    invoke-interface {p4, p2}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 32
    .line 33
    .line 34
    move-result-object p0

    .line 35
    move-object v5, p0

    .line 36
    check-cast v5, Ljava/util/concurrent/Executor;

    .line 37
    .line 38
    invoke-interface {p4, p3}, Lo7/d;->f(Lo7/e0;)Ljava/lang/Object;

    .line 39
    .line 40
    .line 41
    move-result-object p0

    .line 42
    move-object v6, p0

    .line 43
    check-cast v6, Ljava/util/concurrent/ScheduledExecutorService;

    .line 44
    .line 45
    invoke-direct/range {v0 .. v6}, Lh7/j;-><init>(La7/g;Lfa/b;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;)V

    .line 46
    .line 47
    .line 48
    return-object v0
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


# virtual methods
.method public getComponents()Ljava/util/List;
    .locals 7

    .line 1
    const-class v0, Ld7/d;

    .line 2
    .line 3
    const-class v1, Ljava/util/concurrent/Executor;

    .line 4
    .line 5
    invoke-static {v0, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 6
    .line 7
    .line 8
    move-result-object v0

    .line 9
    const-class v2, Ld7/c;

    .line 10
    .line 11
    invoke-static {v2, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 12
    .line 13
    .line 14
    move-result-object v2

    .line 15
    const-class v3, Ld7/a;

    .line 16
    .line 17
    invoke-static {v3, v1}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    const-class v3, Ld7/b;

    .line 22
    .line 23
    const-class v4, Ljava/util/concurrent/ScheduledExecutorService;

    .line 24
    .line 25
    invoke-static {v3, v4}, Lo7/e0;->a(Ljava/lang/Class;Ljava/lang/Class;)Lo7/e0;

    .line 26
    .line 27
    .line 28
    move-result-object v3

    .line 29
    const-class v4, Lj7/b;

    .line 30
    .line 31
    filled-new-array {v4}, [Ljava/lang/Class;

    .line 32
    .line 33
    .line 34
    move-result-object v4

    .line 35
    const-class v5, Le7/e;

    .line 36
    .line 37
    invoke-static {v5, v4}, Lo7/c;->d(Ljava/lang/Class;[Ljava/lang/Class;)Lo7/c$b;

    .line 38
    .line 39
    .line 40
    move-result-object v4

    .line 41
    const-string v5, "fire-app-check"

    .line 42
    .line 43
    invoke-virtual {v4, v5}, Lo7/c$b;->h(Ljava/lang/String;)Lo7/c$b;

    .line 44
    .line 45
    .line 46
    move-result-object v4

    .line 47
    const-class v6, La7/g;

    .line 48
    .line 49
    invoke-static {v6}, Lo7/q;->k(Ljava/lang/Class;)Lo7/q;

    .line 50
    .line 51
    .line 52
    move-result-object v6

    .line 53
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 54
    .line 55
    .line 56
    move-result-object v4

    .line 57
    invoke-static {v0}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 58
    .line 59
    .line 60
    move-result-object v6

    .line 61
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 62
    .line 63
    .line 64
    move-result-object v4

    .line 65
    invoke-static {v2}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 66
    .line 67
    .line 68
    move-result-object v6

    .line 69
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 70
    .line 71
    .line 72
    move-result-object v4

    .line 73
    invoke-static {v1}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 74
    .line 75
    .line 76
    move-result-object v6

    .line 77
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 78
    .line 79
    .line 80
    move-result-object v4

    .line 81
    invoke-static {v3}, Lo7/q;->l(Lo7/e0;)Lo7/q;

    .line 82
    .line 83
    .line 84
    move-result-object v6

    .line 85
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 86
    .line 87
    .line 88
    move-result-object v4

    .line 89
    const-class v6, Lo9/i;

    .line 90
    .line 91
    invoke-static {v6}, Lo7/q;->i(Ljava/lang/Class;)Lo7/q;

    .line 92
    .line 93
    .line 94
    move-result-object v6

    .line 95
    invoke-virtual {v4, v6}, Lo7/c$b;->b(Lo7/q;)Lo7/c$b;

    .line 96
    .line 97
    .line 98
    move-result-object v4

    .line 99
    new-instance v6, Le7/f;

    .line 100
    .line 101
    invoke-direct {v6, v0, v2, v1, v3}, Le7/f;-><init>(Lo7/e0;Lo7/e0;Lo7/e0;Lo7/e0;)V

    .line 102
    .line 103
    .line 104
    invoke-virtual {v4, v6}, Lo7/c$b;->f(Lo7/g;)Lo7/c$b;

    .line 105
    .line 106
    .line 107
    move-result-object v0

    .line 108
    invoke-virtual {v0}, Lo7/c$b;->c()Lo7/c$b;

    .line 109
    .line 110
    .line 111
    move-result-object v0

    .line 112
    invoke-virtual {v0}, Lo7/c$b;->d()Lo7/c;

    .line 113
    .line 114
    .line 115
    move-result-object v0

    .line 116
    invoke-static {}, Lo9/h;->a()Lo7/c;

    .line 117
    .line 118
    .line 119
    move-result-object v1

    .line 120
    const-string v2, "19.0.1"

    .line 121
    .line 122
    invoke-static {v5, v2}, Loa/h;->b(Ljava/lang/String;Ljava/lang/String;)Lo7/c;

    .line 123
    .line 124
    .line 125
    move-result-object v2

    .line 126
    filled-new-array {v0, v1, v2}, [Lo7/c;

    .line 127
    .line 128
    .line 129
    move-result-object v0

    .line 130
    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    .line 131
    .line 132
    .line 133
    move-result-object v0

    .line 134
    return-object v0
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
.end method
