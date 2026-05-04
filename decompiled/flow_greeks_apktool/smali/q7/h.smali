.class public Lq7/h;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# instance fields
.field public final a:Lu7/w;


# direct methods
.method public constructor <init>(Lu7/w;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lq7/h;->a:Lu7/w;

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

.method public static synthetic a(Ljava/lang/Exception;)V
    .locals 2

    .line 1
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    const-string v1, "Error fetching settings."

    .line 6
    .line 7
    invoke-virtual {v0, v1, p0}, Lr7/g;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 8
    .line 9
    .line 10
    return-void
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

.method public static b(La7/g;Lga/h;Lfa/a;Lfa/a;Lfa/a;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;)Lq7/h;
    .locals 15

    .line 1
    invoke-virtual {p0}, La7/g;->m()Landroid/content/Context;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 10
    .line 11
    .line 12
    move-result-object v2

    .line 13
    new-instance v3, Ljava/lang/StringBuilder;

    .line 14
    .line 15
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 16
    .line 17
    .line 18
    const-string v4, "Initializing Firebase Crashlytics "

    .line 19
    .line 20
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    invoke-static {}, Lu7/w;->k()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object v4

    .line 27
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 28
    .line 29
    .line 30
    const-string v4, " for "

    .line 31
    .line 32
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 33
    .line 34
    .line 35
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    .line 37
    .line 38
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 39
    .line 40
    .line 41
    move-result-object v3

    .line 42
    invoke-virtual {v2, v3}, Lr7/g;->g(Ljava/lang/String;)V

    .line 43
    .line 44
    .line 45
    new-instance v14, Lv7/i;

    .line 46
    .line 47
    move-object/from16 v2, p5

    .line 48
    .line 49
    move-object/from16 v3, p6

    .line 50
    .line 51
    invoke-direct {v14, v2, v3}, Lv7/i;-><init>(Ljava/util/concurrent/ExecutorService;Ljava/util/concurrent/ExecutorService;)V

    .line 52
    .line 53
    .line 54
    new-instance v11, La8/g;

    .line 55
    .line 56
    invoke-direct {v11, v0}, La8/g;-><init>(Landroid/content/Context;)V

    .line 57
    .line 58
    .line 59
    new-instance v8, Lu7/c0;

    .line 60
    .line 61
    invoke-direct {v8, p0}, Lu7/c0;-><init>(La7/g;)V

    .line 62
    .line 63
    .line 64
    new-instance v2, Lu7/h0;

    .line 65
    .line 66
    move-object/from16 v3, p1

    .line 67
    .line 68
    invoke-direct {v2, v0, v1, v3, v8}, Lu7/h0;-><init>(Landroid/content/Context;Ljava/lang/String;Lga/h;Lu7/c0;)V

    .line 69
    .line 70
    .line 71
    new-instance v7, Lr7/d;

    .line 72
    .line 73
    move-object/from16 v1, p2

    .line 74
    .line 75
    invoke-direct {v7, v1}, Lr7/d;-><init>(Lfa/a;)V

    .line 76
    .line 77
    .line 78
    new-instance v1, Lq7/d;

    .line 79
    .line 80
    move-object/from16 v3, p3

    .line 81
    .line 82
    invoke-direct {v1, v3}, Lq7/d;-><init>(Lfa/a;)V

    .line 83
    .line 84
    .line 85
    new-instance v12, Lu7/m;

    .line 86
    .line 87
    invoke-direct {v12, v8, v11}, Lu7/m;-><init>(Lu7/c0;La8/g;)V

    .line 88
    .line 89
    .line 90
    invoke-static {v12}, Lva/b;->e(Lva/c;)V

    .line 91
    .line 92
    .line 93
    new-instance v13, Lr7/k;

    .line 94
    .line 95
    move-object/from16 v3, p4

    .line 96
    .line 97
    invoke-direct {v13, v3}, Lr7/k;-><init>(Lfa/a;)V

    .line 98
    .line 99
    .line 100
    new-instance v4, Lu7/w;

    .line 101
    .line 102
    invoke-virtual {v1}, Lq7/d;->e()Lt7/b;

    .line 103
    .line 104
    .line 105
    move-result-object v9

    .line 106
    invoke-virtual {v1}, Lq7/d;->d()Ls7/a;

    .line 107
    .line 108
    .line 109
    move-result-object v10

    .line 110
    move-object v5, p0

    .line 111
    move-object v6, v2

    .line 112
    invoke-direct/range {v4 .. v14}, Lu7/w;-><init>(La7/g;Lu7/h0;Lr7/a;Lu7/c0;Lt7/b;Ls7/a;La8/g;Lu7/m;Lr7/k;Lv7/i;)V

    .line 113
    .line 114
    .line 115
    move-object v9, v4

    .line 116
    invoke-virtual {p0}, La7/g;->r()La7/p;

    .line 117
    .line 118
    .line 119
    move-result-object p0

    .line 120
    invoke-virtual {p0}, La7/p;->c()Ljava/lang/String;

    .line 121
    .line 122
    .line 123
    move-result-object v1

    .line 124
    invoke-static {v0}, Lu7/i;->m(Landroid/content/Context;)Ljava/lang/String;

    .line 125
    .line 126
    .line 127
    move-result-object p0

    .line 128
    invoke-static {v0}, Lu7/i;->j(Landroid/content/Context;)Ljava/util/List;

    .line 129
    .line 130
    .line 131
    move-result-object v3

    .line 132
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 133
    .line 134
    .line 135
    move-result-object v4

    .line 136
    new-instance v5, Ljava/lang/StringBuilder;

    .line 137
    .line 138
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 139
    .line 140
    .line 141
    const-string v6, "Mapping file ID is: "

    .line 142
    .line 143
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 144
    .line 145
    .line 146
    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 147
    .line 148
    .line 149
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 150
    .line 151
    .line 152
    move-result-object v5

    .line 153
    invoke-virtual {v4, v5}, Lr7/g;->b(Ljava/lang/String;)V

    .line 154
    .line 155
    .line 156
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 157
    .line 158
    .line 159
    move-result-object v4

    .line 160
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    .line 161
    .line 162
    .line 163
    move-result v5

    .line 164
    if-eqz v5, :cond_0

    .line 165
    .line 166
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 167
    .line 168
    .line 169
    move-result-object v5

    .line 170
    check-cast v5, Lu7/f;

    .line 171
    .line 172
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 173
    .line 174
    .line 175
    move-result-object v6

    .line 176
    invoke-virtual {v5}, Lu7/f;->c()Ljava/lang/String;

    .line 177
    .line 178
    .line 179
    move-result-object v7

    .line 180
    invoke-virtual {v5}, Lu7/f;->a()Ljava/lang/String;

    .line 181
    .line 182
    .line 183
    move-result-object v10

    .line 184
    invoke-virtual {v5}, Lu7/f;->b()Ljava/lang/String;

    .line 185
    .line 186
    .line 187
    move-result-object v5

    .line 188
    filled-new-array {v7, v10, v5}, [Ljava/lang/Object;

    .line 189
    .line 190
    .line 191
    move-result-object v5

    .line 192
    const-string v7, "Build id for %s on %s: %s"

    .line 193
    .line 194
    invoke-static {v7, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 195
    .line 196
    .line 197
    move-result-object v5

    .line 198
    invoke-virtual {v6, v5}, Lr7/g;->b(Ljava/lang/String;)V

    .line 199
    .line 200
    .line 201
    goto :goto_0

    .line 202
    :cond_0
    new-instance v4, Lr7/f;

    .line 203
    .line 204
    invoke-direct {v4, v0}, Lr7/f;-><init>(Landroid/content/Context;)V

    .line 205
    .line 206
    .line 207
    move-object/from16 p3, p0

    .line 208
    .line 209
    move-object p0, v0

    .line 210
    move-object/from16 p2, v1

    .line 211
    .line 212
    move-object/from16 p1, v2

    .line 213
    .line 214
    move-object/from16 p4, v3

    .line 215
    .line 216
    move-object/from16 p5, v4

    .line 217
    .line 218
    :try_start_0
    invoke-static/range {p0 .. p5}, Lu7/a;->a(Landroid/content/Context;Lu7/h0;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lr7/f;)Lu7/a;

    .line 219
    .line 220
    .line 221
    move-result-object v10
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 222
    move-object/from16 v2, p1

    .line 223
    .line 224
    move-object/from16 v1, p2

    .line 225
    .line 226
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 227
    .line 228
    .line 229
    move-result-object v0

    .line 230
    new-instance v3, Ljava/lang/StringBuilder;

    .line 231
    .line 232
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 233
    .line 234
    .line 235
    const-string v4, "Installer package name is: "

    .line 236
    .line 237
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 238
    .line 239
    .line 240
    iget-object v4, v10, Lu7/a;->d:Ljava/lang/String;

    .line 241
    .line 242
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 243
    .line 244
    .line 245
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 246
    .line 247
    .line 248
    move-result-object v3

    .line 249
    invoke-virtual {v0, v3}, Lr7/g;->i(Ljava/lang/String;)V

    .line 250
    .line 251
    .line 252
    new-instance v3, Lz7/b;

    .line 253
    .line 254
    invoke-direct {v3}, Lz7/b;-><init>()V

    .line 255
    .line 256
    .line 257
    iget-object v4, v10, Lu7/a;->f:Ljava/lang/String;

    .line 258
    .line 259
    iget-object v5, v10, Lu7/a;->g:Ljava/lang/String;

    .line 260
    .line 261
    move-object v0, p0

    .line 262
    move-object v7, v8

    .line 263
    move-object v6, v11

    .line 264
    invoke-static/range {v0 .. v7}, Lc8/g;->l(Landroid/content/Context;Ljava/lang/String;Lu7/h0;Lz7/b;Ljava/lang/String;Ljava/lang/String;La8/g;Lu7/c0;)Lc8/g;

    .line 265
    .line 266
    .line 267
    move-result-object p0

    .line 268
    invoke-virtual {p0, v14}, Lc8/g;->p(Lv7/i;)Lcom/google/android/gms/tasks/Task;

    .line 269
    .line 270
    .line 271
    move-result-object v0

    .line 272
    new-instance v1, Lq7/g;

    .line 273
    .line 274
    invoke-direct {v1}, Lq7/g;-><init>()V

    .line 275
    .line 276
    .line 277
    move-object/from16 v2, p7

    .line 278
    .line 279
    invoke-virtual {v0, v2, v1}, Lcom/google/android/gms/tasks/Task;->addOnFailureListener(Ljava/util/concurrent/Executor;Lcom/google/android/gms/tasks/OnFailureListener;)Lcom/google/android/gms/tasks/Task;

    .line 280
    .line 281
    .line 282
    invoke-virtual {v9, v10, p0}, Lu7/w;->p(Lu7/a;Lc8/j;)Z

    .line 283
    .line 284
    .line 285
    move-result v0

    .line 286
    if-eqz v0, :cond_1

    .line 287
    .line 288
    invoke-virtual {v9, p0}, Lu7/w;->i(Lc8/j;)Lcom/google/android/gms/tasks/Task;

    .line 289
    .line 290
    .line 291
    :cond_1
    new-instance p0, Lq7/h;

    .line 292
    .line 293
    invoke-direct {p0, v9}, Lq7/h;-><init>(Lu7/w;)V

    .line 294
    .line 295
    .line 296
    return-object p0

    .line 297
    :catch_0
    move-exception v0

    .line 298
    move-object p0, v0

    .line 299
    invoke-static {}, Lr7/g;->f()Lr7/g;

    .line 300
    .line 301
    .line 302
    move-result-object v0

    .line 303
    const-string v1, "Error retrieving app package info."

    .line 304
    .line 305
    invoke-virtual {v0, v1, p0}, Lr7/g;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 306
    .line 307
    .line 308
    const/4 p0, 0x0

    .line 309
    return-object p0
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
.end method
