.class public final Ltb/g1;
.super Lrb/u0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lrb/j0;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltb/g1$v;,
        Ltb/g1$w;,
        Ltb/g1$p;,
        Ltb/g1$q;,
        Ltb/g1$o;,
        Ltb/g1$x;,
        Ltb/g1$t;,
        Ltb/g1$s;,
        Ltb/g1$y;,
        Ltb/g1$n;,
        Ltb/g1$u;,
        Ltb/g1$m;,
        Ltb/g1$r;
    }
.end annotation


# static fields
.field public static final m0:Ljava/util/logging/Logger;

.field public static final n0:Ljava/util/regex/Pattern;

.field public static final o0:Lrb/k1;

.field public static final p0:Lrb/k1;

.field public static final q0:Lrb/k1;

.field public static final r0:Ltb/j1;

.field public static final s0:Lrb/g0;

.field public static final t0:Lrb/g;


# instance fields
.field public final A:Ljava/util/List;

.field public final B:Ljava/lang/String;

.field public C:Lrb/b1;

.field public D:Z

.field public E:Ltb/g1$s;

.field public volatile F:Lrb/r0$j;

.field public G:Z

.field public final H:Ljava/util/Set;

.field public I:Ljava/util/Collection;

.field public final J:Ljava/lang/Object;

.field public final K:Ljava/util/Set;

.field public final L:Ltb/b0;

.field public final M:Ltb/g1$y;

.field public final N:Ljava/util/concurrent/atomic/AtomicBoolean;

.field public O:Z

.field public P:Z

.field public volatile Q:Z

.field public final R:Ljava/util/concurrent/CountDownLatch;

.field public final S:Ltb/n$b;

.field public final T:Ltb/n;

.field public final U:Ltb/p;

.field public final V:Lrb/f;

.field public final W:Lrb/e0;

.field public final X:Ltb/g1$u;

.field public Y:Ltb/g1$v;

.field public Z:Ltb/j1;

.field public final a:Lrb/k0;

.field public final a0:Ltb/j1;

.field public final b:Ljava/lang/String;

.field public b0:Z

.field public final c:Ljava/lang/String;

.field public final c0:Z

.field public final d:Lrb/d1;

.field public final d0:Ltb/b2$t;

.field public final e:Lrb/b1$a;

.field public final e0:J

.field public final f:Ltb/i;

.field public final f0:J

.field public final g:Ltb/u;

.field public final g0:Z

.field public final h:Ltb/u;

.field public final h0:Lrb/t$c;

.field public final i:Ltb/u;

.field public final i0:Ltb/k1$a;

.field public final j:Ltb/g1$w;

.field public final j0:Ltb/w0;

.field public final k:Ljava/util/concurrent/Executor;

.field public final k0:Ltb/g1$m;

.field public final l:Ltb/p1;

.field public final l0:Ltb/a2;

.field public final m:Ltb/p1;

.field public final n:Ltb/g1$p;

.field public final o:Ltb/g1$p;

.field public final p:Ltb/q2;

.field public final q:I

.field public final r:Lrb/o1;

.field public s:Z

.field public final t:Lrb/v;

.field public final u:Lrb/o;

.field public final v:Lp6/s;

.field public final w:J

.field public final x:Ltb/x;

.field public final y:Ltb/j$a;

.field public final z:Lrb/d;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    const-class v0, Ltb/g1;

    .line 2
    .line 3
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-static {v0}, Ljava/util/logging/Logger;->getLogger(Ljava/lang/String;)Ljava/util/logging/Logger;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    sput-object v0, Ltb/g1;->m0:Ljava/util/logging/Logger;

    .line 12
    .line 13
    const-string v0, "[a-zA-Z][a-zA-Z0-9+.-]*:/.*"

    .line 14
    .line 15
    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    .line 16
    .line 17
    .line 18
    move-result-object v0

    .line 19
    sput-object v0, Ltb/g1;->n0:Ljava/util/regex/Pattern;

    .line 20
    .line 21
    sget-object v0, Lrb/k1;->t:Lrb/k1;

    .line 22
    .line 23
    const-string v1, "Channel shutdownNow invoked"

    .line 24
    .line 25
    invoke-virtual {v0, v1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 26
    .line 27
    .line 28
    move-result-object v1

    .line 29
    sput-object v1, Ltb/g1;->o0:Lrb/k1;

    .line 30
    .line 31
    const-string v1, "Channel shutdown invoked"

    .line 32
    .line 33
    invoke-virtual {v0, v1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 34
    .line 35
    .line 36
    move-result-object v1

    .line 37
    sput-object v1, Ltb/g1;->p0:Lrb/k1;

    .line 38
    .line 39
    const-string v1, "Subchannel shutdown invoked"

    .line 40
    .line 41
    invoke-virtual {v0, v1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 42
    .line 43
    .line 44
    move-result-object v0

    .line 45
    sput-object v0, Ltb/g1;->q0:Lrb/k1;

    .line 46
    .line 47
    invoke-static {}, Ltb/j1;->a()Ltb/j1;

    .line 48
    .line 49
    .line 50
    move-result-object v0

    .line 51
    sput-object v0, Ltb/g1;->r0:Ltb/j1;

    .line 52
    .line 53
    new-instance v0, Ltb/g1$a;

    .line 54
    .line 55
    invoke-direct {v0}, Ltb/g1$a;-><init>()V

    .line 56
    .line 57
    .line 58
    sput-object v0, Ltb/g1;->s0:Lrb/g0;

    .line 59
    .line 60
    new-instance v0, Ltb/g1$l;

    .line 61
    .line 62
    invoke-direct {v0}, Ltb/g1$l;-><init>()V

    .line 63
    .line 64
    .line 65
    sput-object v0, Ltb/g1;->t0:Lrb/g;

    .line 66
    .line 67
    return-void
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

.method public constructor <init>(Ltb/h1;Ltb/u;Ltb/j$a;Ltb/p1;Lp6/s;Ljava/util/List;Ltb/q2;)V
    .locals 20

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    move-object/from16 v1, p1

    .line 4
    .line 5
    move-object/from16 v2, p2

    .line 6
    .line 7
    move-object/from16 v3, p4

    .line 8
    .line 9
    move-object/from16 v4, p7

    .line 10
    .line 11
    invoke-direct {v0}, Lrb/u0;-><init>()V

    .line 12
    .line 13
    .line 14
    new-instance v5, Lrb/o1;

    .line 15
    .line 16
    new-instance v6, Ltb/g1$j;

    .line 17
    .line 18
    invoke-direct {v6, v0}, Ltb/g1$j;-><init>(Ltb/g1;)V

    .line 19
    .line 20
    .line 21
    invoke-direct {v5, v6}, Lrb/o1;-><init>(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 22
    .line 23
    .line 24
    iput-object v5, v0, Ltb/g1;->r:Lrb/o1;

    .line 25
    .line 26
    new-instance v6, Ltb/x;

    .line 27
    .line 28
    invoke-direct {v6}, Ltb/x;-><init>()V

    .line 29
    .line 30
    .line 31
    iput-object v6, v0, Ltb/g1;->x:Ltb/x;

    .line 32
    .line 33
    new-instance v6, Ljava/util/HashSet;

    .line 34
    .line 35
    const/16 v7, 0x10

    .line 36
    .line 37
    const/high16 v8, 0x3f400000    # 0.75f

    .line 38
    .line 39
    invoke-direct {v6, v7, v8}, Ljava/util/HashSet;-><init>(IF)V

    .line 40
    .line 41
    .line 42
    iput-object v6, v0, Ltb/g1;->H:Ljava/util/Set;

    .line 43
    .line 44
    new-instance v6, Ljava/lang/Object;

    .line 45
    .line 46
    invoke-direct {v6}, Ljava/lang/Object;-><init>()V

    .line 47
    .line 48
    .line 49
    iput-object v6, v0, Ltb/g1;->J:Ljava/lang/Object;

    .line 50
    .line 51
    new-instance v6, Ljava/util/HashSet;

    .line 52
    .line 53
    const/4 v7, 0x1

    .line 54
    invoke-direct {v6, v7, v8}, Ljava/util/HashSet;-><init>(IF)V

    .line 55
    .line 56
    .line 57
    iput-object v6, v0, Ltb/g1;->K:Ljava/util/Set;

    .line 58
    .line 59
    new-instance v6, Ltb/g1$y;

    .line 60
    .line 61
    const/4 v8, 0x0

    .line 62
    invoke-direct {v6, v0, v8}, Ltb/g1$y;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 63
    .line 64
    .line 65
    iput-object v6, v0, Ltb/g1;->M:Ltb/g1$y;

    .line 66
    .line 67
    new-instance v6, Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 68
    .line 69
    const/4 v9, 0x0

    .line 70
    invoke-direct {v6, v9}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    .line 71
    .line 72
    .line 73
    iput-object v6, v0, Ltb/g1;->N:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 74
    .line 75
    new-instance v6, Ljava/util/concurrent/CountDownLatch;

    .line 76
    .line 77
    invoke-direct {v6, v7}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 78
    .line 79
    .line 80
    iput-object v6, v0, Ltb/g1;->R:Ljava/util/concurrent/CountDownLatch;

    .line 81
    .line 82
    sget-object v6, Ltb/g1$v;->a:Ltb/g1$v;

    .line 83
    .line 84
    iput-object v6, v0, Ltb/g1;->Y:Ltb/g1$v;

    .line 85
    .line 86
    sget-object v6, Ltb/g1;->r0:Ltb/j1;

    .line 87
    .line 88
    iput-object v6, v0, Ltb/g1;->Z:Ltb/j1;

    .line 89
    .line 90
    iput-boolean v9, v0, Ltb/g1;->b0:Z

    .line 91
    .line 92
    new-instance v6, Ltb/b2$t;

    .line 93
    .line 94
    invoke-direct {v6}, Ltb/b2$t;-><init>()V

    .line 95
    .line 96
    .line 97
    iput-object v6, v0, Ltb/g1;->d0:Ltb/b2$t;

    .line 98
    .line 99
    invoke-static {}, Lrb/t;->k()Lrb/t$c;

    .line 100
    .line 101
    .line 102
    move-result-object v6

    .line 103
    iput-object v6, v0, Ltb/g1;->h0:Lrb/t$c;

    .line 104
    .line 105
    new-instance v6, Ltb/g1$o;

    .line 106
    .line 107
    invoke-direct {v6, v0, v8}, Ltb/g1$o;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 108
    .line 109
    .line 110
    iput-object v6, v0, Ltb/g1;->i0:Ltb/k1$a;

    .line 111
    .line 112
    new-instance v10, Ltb/g1$q;

    .line 113
    .line 114
    invoke-direct {v10, v0, v8}, Ltb/g1$q;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 115
    .line 116
    .line 117
    iput-object v10, v0, Ltb/g1;->j0:Ltb/w0;

    .line 118
    .line 119
    new-instance v10, Ltb/g1$m;

    .line 120
    .line 121
    invoke-direct {v10, v0, v8}, Ltb/g1$m;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 122
    .line 123
    .line 124
    iput-object v10, v0, Ltb/g1;->k0:Ltb/g1$m;

    .line 125
    .line 126
    iget-object v10, v1, Ltb/h1;->f:Ljava/lang/String;

    .line 127
    .line 128
    const-string v11, "target"

    .line 129
    .line 130
    invoke-static {v10, v11}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    .line 132
    .line 133
    move-result-object v10

    .line 134
    check-cast v10, Ljava/lang/String;

    .line 135
    .line 136
    iput-object v10, v0, Ltb/g1;->b:Ljava/lang/String;

    .line 137
    .line 138
    const-string v11, "Channel"

    .line 139
    .line 140
    invoke-static {v11, v10}, Lrb/k0;->b(Ljava/lang/String;Ljava/lang/String;)Lrb/k0;

    .line 141
    .line 142
    .line 143
    move-result-object v13

    .line 144
    iput-object v13, v0, Ltb/g1;->a:Lrb/k0;

    .line 145
    .line 146
    const-string v11, "timeProvider"

    .line 147
    .line 148
    invoke-static {v4, v11}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    .line 150
    .line 151
    move-result-object v11

    .line 152
    check-cast v11, Ltb/q2;

    .line 153
    .line 154
    iput-object v11, v0, Ltb/g1;->p:Ltb/q2;

    .line 155
    .line 156
    iget-object v11, v1, Ltb/h1;->a:Ltb/p1;

    .line 157
    .line 158
    const-string v12, "executorPool"

    .line 159
    .line 160
    invoke-static {v11, v12}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    .line 162
    .line 163
    move-result-object v11

    .line 164
    check-cast v11, Ltb/p1;

    .line 165
    .line 166
    iput-object v11, v0, Ltb/g1;->l:Ltb/p1;

    .line 167
    .line 168
    invoke-interface {v11}, Ltb/p1;->a()Ljava/lang/Object;

    .line 169
    .line 170
    .line 171
    move-result-object v11

    .line 172
    check-cast v11, Ljava/util/concurrent/Executor;

    .line 173
    .line 174
    const-string v12, "executor"

    .line 175
    .line 176
    invoke-static {v11, v12}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    .line 178
    .line 179
    move-result-object v11

    .line 180
    check-cast v11, Ljava/util/concurrent/Executor;

    .line 181
    .line 182
    iput-object v11, v0, Ltb/g1;->k:Ljava/util/concurrent/Executor;

    .line 183
    .line 184
    iput-object v2, v0, Ltb/g1;->g:Ltb/u;

    .line 185
    .line 186
    new-instance v12, Ltb/g1$p;

    .line 187
    .line 188
    iget-object v14, v1, Ltb/h1;->b:Ltb/p1;

    .line 189
    .line 190
    const-string v15, "offloadExecutorPool"

    .line 191
    .line 192
    invoke-static {v14, v15}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    .line 194
    .line 195
    move-result-object v14

    .line 196
    check-cast v14, Ltb/p1;

    .line 197
    .line 198
    invoke-direct {v12, v14}, Ltb/g1$p;-><init>(Ltb/p1;)V

    .line 199
    .line 200
    .line 201
    iput-object v12, v0, Ltb/g1;->o:Ltb/g1$p;

    .line 202
    .line 203
    new-instance v14, Ltb/m;

    .line 204
    .line 205
    iget-object v15, v1, Ltb/h1;->g:Lrb/b;

    .line 206
    .line 207
    invoke-direct {v14, v2, v15, v12}, Ltb/m;-><init>(Ltb/u;Lrb/b;Ljava/util/concurrent/Executor;)V

    .line 208
    .line 209
    .line 210
    iput-object v14, v0, Ltb/g1;->h:Ltb/u;

    .line 211
    .line 212
    new-instance v15, Ltb/m;

    .line 213
    .line 214
    invoke-direct {v15, v2, v8, v12}, Ltb/m;-><init>(Ltb/u;Lrb/b;Ljava/util/concurrent/Executor;)V

    .line 215
    .line 216
    .line 217
    iput-object v15, v0, Ltb/g1;->i:Ltb/u;

    .line 218
    .line 219
    new-instance v2, Ltb/g1$w;

    .line 220
    .line 221
    invoke-interface {v14}, Ltb/u;->Q()Ljava/util/concurrent/ScheduledExecutorService;

    .line 222
    .line 223
    .line 224
    move-result-object v15

    .line 225
    invoke-direct {v2, v15, v8}, Ltb/g1$w;-><init>(Ljava/util/concurrent/ScheduledExecutorService;Ltb/g1$a;)V

    .line 226
    .line 227
    .line 228
    iput-object v2, v0, Ltb/g1;->j:Ltb/g1$w;

    .line 229
    .line 230
    iget v15, v1, Ltb/h1;->v:I

    .line 231
    .line 232
    iput v15, v0, Ltb/g1;->q:I

    .line 233
    .line 234
    move-object v15, v12

    .line 235
    new-instance v12, Ltb/p;

    .line 236
    .line 237
    move-object/from16 v16, v14

    .line 238
    .line 239
    iget v14, v1, Ltb/h1;->v:I

    .line 240
    .line 241
    move-object/from16 v17, v15

    .line 242
    .line 243
    move-object/from16 v18, v16

    .line 244
    .line 245
    invoke-interface {v4}, Ltb/q2;->a()J

    .line 246
    .line 247
    .line 248
    move-result-wide v15

    .line 249
    new-instance v9, Ljava/lang/StringBuilder;

    .line 250
    .line 251
    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    .line 252
    .line 253
    .line 254
    const-string v7, "Channel for \'"

    .line 255
    .line 256
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 257
    .line 258
    .line 259
    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 260
    .line 261
    .line 262
    const-string v7, "\'"

    .line 263
    .line 264
    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 265
    .line 266
    .line 267
    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 268
    .line 269
    .line 270
    move-result-object v7

    .line 271
    move-object/from16 v19, v17

    .line 272
    .line 273
    move-object/from16 v17, v7

    .line 274
    .line 275
    move-object/from16 v7, v19

    .line 276
    .line 277
    invoke-direct/range {v12 .. v17}, Ltb/p;-><init>(Lrb/k0;IJLjava/lang/String;)V

    .line 278
    .line 279
    .line 280
    iput-object v12, v0, Ltb/g1;->U:Ltb/p;

    .line 281
    .line 282
    new-instance v9, Ltb/o;

    .line 283
    .line 284
    invoke-direct {v9, v12, v4}, Ltb/o;-><init>(Ltb/p;Ltb/q2;)V

    .line 285
    .line 286
    .line 287
    iput-object v9, v0, Ltb/g1;->V:Lrb/f;

    .line 288
    .line 289
    iget-object v12, v1, Ltb/h1;->y:Lrb/g1;

    .line 290
    .line 291
    if-eqz v12, :cond_0

    .line 292
    .line 293
    goto :goto_0

    .line 294
    :cond_0
    sget-object v12, Ltb/r0;->q:Lrb/g1;

    .line 295
    .line 296
    :goto_0
    iget-boolean v13, v1, Ltb/h1;->t:Z

    .line 297
    .line 298
    iput-boolean v13, v0, Ltb/g1;->g0:Z

    .line 299
    .line 300
    new-instance v14, Ltb/i;

    .line 301
    .line 302
    iget-object v15, v1, Ltb/h1;->k:Ljava/lang/String;

    .line 303
    .line 304
    invoke-direct {v14, v15}, Ltb/i;-><init>(Ljava/lang/String;)V

    .line 305
    .line 306
    .line 307
    iput-object v14, v0, Ltb/g1;->f:Ltb/i;

    .line 308
    .line 309
    iget-object v15, v1, Ltb/h1;->d:Lrb/d1;

    .line 310
    .line 311
    iput-object v15, v0, Ltb/g1;->d:Lrb/d1;

    .line 312
    .line 313
    new-instance v8, Ltb/g2;

    .line 314
    .line 315
    iget v4, v1, Ltb/h1;->p:I

    .line 316
    .line 317
    move-object/from16 v17, v6

    .line 318
    .line 319
    iget v6, v1, Ltb/h1;->q:I

    .line 320
    .line 321
    invoke-direct {v8, v13, v4, v6, v14}, Ltb/g2;-><init>(ZIILtb/i;)V

    .line 322
    .line 323
    .line 324
    iget-object v4, v1, Ltb/h1;->j:Ljava/lang/String;

    .line 325
    .line 326
    iput-object v4, v0, Ltb/g1;->c:Ljava/lang/String;

    .line 327
    .line 328
    invoke-static {}, Lrb/b1$a;->g()Lrb/b1$a$a;

    .line 329
    .line 330
    .line 331
    move-result-object v6

    .line 332
    invoke-virtual {v1}, Ltb/h1;->e()I

    .line 333
    .line 334
    .line 335
    move-result v13

    .line 336
    invoke-virtual {v6, v13}, Lrb/b1$a$a;->c(I)Lrb/b1$a$a;

    .line 337
    .line 338
    .line 339
    move-result-object v6

    .line 340
    invoke-virtual {v6, v12}, Lrb/b1$a$a;->f(Lrb/g1;)Lrb/b1$a$a;

    .line 341
    .line 342
    .line 343
    move-result-object v6

    .line 344
    invoke-virtual {v6, v5}, Lrb/b1$a$a;->i(Lrb/o1;)Lrb/b1$a$a;

    .line 345
    .line 346
    .line 347
    move-result-object v6

    .line 348
    invoke-virtual {v6, v2}, Lrb/b1$a$a;->g(Ljava/util/concurrent/ScheduledExecutorService;)Lrb/b1$a$a;

    .line 349
    .line 350
    .line 351
    move-result-object v2

    .line 352
    invoke-virtual {v2, v8}, Lrb/b1$a$a;->h(Lrb/b1$f;)Lrb/b1$a$a;

    .line 353
    .line 354
    .line 355
    move-result-object v2

    .line 356
    invoke-virtual {v2, v9}, Lrb/b1$a$a;->b(Lrb/f;)Lrb/b1$a$a;

    .line 357
    .line 358
    .line 359
    move-result-object v2

    .line 360
    invoke-virtual {v2, v7}, Lrb/b1$a$a;->d(Ljava/util/concurrent/Executor;)Lrb/b1$a$a;

    .line 361
    .line 362
    .line 363
    move-result-object v2

    .line 364
    invoke-virtual {v2, v4}, Lrb/b1$a$a;->e(Ljava/lang/String;)Lrb/b1$a$a;

    .line 365
    .line 366
    .line 367
    move-result-object v2

    .line 368
    invoke-virtual {v2}, Lrb/b1$a$a;->a()Lrb/b1$a;

    .line 369
    .line 370
    .line 371
    move-result-object v2

    .line 372
    iput-object v2, v0, Ltb/g1;->e:Lrb/b1$a;

    .line 373
    .line 374
    invoke-interface/range {v18 .. v18}, Ltb/u;->Y()Ljava/util/Collection;

    .line 375
    .line 376
    .line 377
    move-result-object v6

    .line 378
    invoke-static {v10, v4, v15, v2, v6}, Ltb/g1;->B0(Ljava/lang/String;Ljava/lang/String;Lrb/d1;Lrb/b1$a;Ljava/util/Collection;)Lrb/b1;

    .line 379
    .line 380
    .line 381
    move-result-object v2

    .line 382
    iput-object v2, v0, Ltb/g1;->C:Lrb/b1;

    .line 383
    .line 384
    const-string v2, "balancerRpcExecutorPool"

    .line 385
    .line 386
    invoke-static {v3, v2}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 387
    .line 388
    .line 389
    move-result-object v2

    .line 390
    check-cast v2, Ltb/p1;

    .line 391
    .line 392
    iput-object v2, v0, Ltb/g1;->m:Ltb/p1;

    .line 393
    .line 394
    new-instance v2, Ltb/g1$p;

    .line 395
    .line 396
    invoke-direct {v2, v3}, Ltb/g1$p;-><init>(Ltb/p1;)V

    .line 397
    .line 398
    .line 399
    iput-object v2, v0, Ltb/g1;->n:Ltb/g1$p;

    .line 400
    .line 401
    new-instance v2, Ltb/b0;

    .line 402
    .line 403
    invoke-direct {v2, v11, v5}, Ltb/b0;-><init>(Ljava/util/concurrent/Executor;Lrb/o1;)V

    .line 404
    .line 405
    .line 406
    iput-object v2, v0, Ltb/g1;->L:Ltb/b0;

    .line 407
    .line 408
    move-object/from16 v3, v17

    .line 409
    .line 410
    invoke-virtual {v2, v3}, Ltb/b0;->d(Ltb/k1$a;)Ljava/lang/Runnable;

    .line 411
    .line 412
    .line 413
    move-object/from16 v2, p3

    .line 414
    .line 415
    iput-object v2, v0, Ltb/g1;->y:Ltb/j$a;

    .line 416
    .line 417
    iget-object v2, v1, Ltb/h1;->w:Ljava/util/Map;

    .line 418
    .line 419
    if-eqz v2, :cond_2

    .line 420
    .line 421
    invoke-virtual {v8, v2}, Ltb/g2;->a(Ljava/util/Map;)Lrb/b1$b;

    .line 422
    .line 423
    .line 424
    move-result-object v2

    .line 425
    invoke-virtual {v2}, Lrb/b1$b;->d()Lrb/k1;

    .line 426
    .line 427
    .line 428
    move-result-object v3

    .line 429
    if-nez v3, :cond_1

    .line 430
    .line 431
    const/4 v3, 0x1

    .line 432
    goto :goto_1

    .line 433
    :cond_1
    const/4 v3, 0x0

    .line 434
    :goto_1
    const-string v4, "Default config is invalid: %s"

    .line 435
    .line 436
    invoke-virtual {v2}, Lrb/b1$b;->d()Lrb/k1;

    .line 437
    .line 438
    .line 439
    move-result-object v6

    .line 440
    invoke-static {v3, v4, v6}, Lp6/n;->x(ZLjava/lang/String;Ljava/lang/Object;)V

    .line 441
    .line 442
    .line 443
    invoke-virtual {v2}, Lrb/b1$b;->c()Ljava/lang/Object;

    .line 444
    .line 445
    .line 446
    move-result-object v2

    .line 447
    check-cast v2, Ltb/j1;

    .line 448
    .line 449
    iput-object v2, v0, Ltb/g1;->a0:Ltb/j1;

    .line 450
    .line 451
    iput-object v2, v0, Ltb/g1;->Z:Ltb/j1;

    .line 452
    .line 453
    const/4 v2, 0x0

    .line 454
    goto :goto_2

    .line 455
    :cond_2
    const/4 v2, 0x0

    .line 456
    iput-object v2, v0, Ltb/g1;->a0:Ltb/j1;

    .line 457
    .line 458
    :goto_2
    iget-boolean v3, v1, Ltb/h1;->x:Z

    .line 459
    .line 460
    iput-boolean v3, v0, Ltb/g1;->c0:Z

    .line 461
    .line 462
    new-instance v4, Ltb/g1$u;

    .line 463
    .line 464
    iget-object v6, v0, Ltb/g1;->C:Lrb/b1;

    .line 465
    .line 466
    invoke-virtual {v6}, Lrb/b1;->a()Ljava/lang/String;

    .line 467
    .line 468
    .line 469
    move-result-object v6

    .line 470
    invoke-direct {v4, v0, v6, v2}, Ltb/g1$u;-><init>(Ltb/g1;Ljava/lang/String;Ltb/g1$a;)V

    .line 471
    .line 472
    .line 473
    iput-object v4, v0, Ltb/g1;->X:Ltb/g1$u;

    .line 474
    .line 475
    move-object/from16 v2, p6

    .line 476
    .line 477
    invoke-static {v4, v2}, Lrb/j;->a(Lrb/d;Ljava/util/List;)Lrb/d;

    .line 478
    .line 479
    .line 480
    move-result-object v2

    .line 481
    iput-object v2, v0, Ltb/g1;->z:Lrb/d;

    .line 482
    .line 483
    new-instance v2, Ljava/util/ArrayList;

    .line 484
    .line 485
    iget-object v4, v1, Ltb/h1;->e:Ljava/util/List;

    .line 486
    .line 487
    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 488
    .line 489
    .line 490
    iput-object v2, v0, Ltb/g1;->A:Ljava/util/List;

    .line 491
    .line 492
    const-string v2, "stopwatchSupplier"

    .line 493
    .line 494
    move-object/from16 v4, p5

    .line 495
    .line 496
    invoke-static {v4, v2}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 497
    .line 498
    .line 499
    move-result-object v2

    .line 500
    check-cast v2, Lp6/s;

    .line 501
    .line 502
    iput-object v2, v0, Ltb/g1;->v:Lp6/s;

    .line 503
    .line 504
    iget-wide v6, v1, Ltb/h1;->o:J

    .line 505
    .line 506
    const-wide/16 v10, -0x1

    .line 507
    .line 508
    cmp-long v2, v6, v10

    .line 509
    .line 510
    if-nez v2, :cond_3

    .line 511
    .line 512
    iput-wide v6, v0, Ltb/g1;->w:J

    .line 513
    .line 514
    goto :goto_4

    .line 515
    :cond_3
    sget-wide v10, Ltb/h1;->J:J

    .line 516
    .line 517
    cmp-long v2, v6, v10

    .line 518
    .line 519
    if-ltz v2, :cond_4

    .line 520
    .line 521
    const/4 v2, 0x1

    .line 522
    goto :goto_3

    .line 523
    :cond_4
    const/4 v2, 0x0

    .line 524
    :goto_3
    const-string v8, "invalid idleTimeoutMillis %s"

    .line 525
    .line 526
    invoke-static {v2, v8, v6, v7}, Lp6/n;->i(ZLjava/lang/String;J)V

    .line 527
    .line 528
    .line 529
    iget-wide v6, v1, Ltb/h1;->o:J

    .line 530
    .line 531
    iput-wide v6, v0, Ltb/g1;->w:J

    .line 532
    .line 533
    :goto_4
    new-instance v2, Ltb/a2;

    .line 534
    .line 535
    new-instance v6, Ltb/g1$r;

    .line 536
    .line 537
    const/4 v7, 0x0

    .line 538
    invoke-direct {v6, v0, v7}, Ltb/g1$r;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 539
    .line 540
    .line 541
    invoke-interface/range {v18 .. v18}, Ltb/u;->Q()Ljava/util/concurrent/ScheduledExecutorService;

    .line 542
    .line 543
    .line 544
    move-result-object v7

    .line 545
    invoke-interface {v4}, Lp6/s;->get()Ljava/lang/Object;

    .line 546
    .line 547
    .line 548
    move-result-object v4

    .line 549
    check-cast v4, Lp6/q;

    .line 550
    .line 551
    invoke-direct {v2, v6, v5, v7, v4}, Ltb/a2;-><init>(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;Lp6/q;)V

    .line 552
    .line 553
    .line 554
    iput-object v2, v0, Ltb/g1;->l0:Ltb/a2;

    .line 555
    .line 556
    iget-boolean v2, v1, Ltb/h1;->l:Z

    .line 557
    .line 558
    iput-boolean v2, v0, Ltb/g1;->s:Z

    .line 559
    .line 560
    iget-object v2, v1, Ltb/h1;->m:Lrb/v;

    .line 561
    .line 562
    const-string v4, "decompressorRegistry"

    .line 563
    .line 564
    invoke-static {v2, v4}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 565
    .line 566
    .line 567
    move-result-object v2

    .line 568
    check-cast v2, Lrb/v;

    .line 569
    .line 570
    iput-object v2, v0, Ltb/g1;->t:Lrb/v;

    .line 571
    .line 572
    iget-object v2, v1, Ltb/h1;->n:Lrb/o;

    .line 573
    .line 574
    const-string v4, "compressorRegistry"

    .line 575
    .line 576
    invoke-static {v2, v4}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 577
    .line 578
    .line 579
    move-result-object v2

    .line 580
    check-cast v2, Lrb/o;

    .line 581
    .line 582
    iput-object v2, v0, Ltb/g1;->u:Lrb/o;

    .line 583
    .line 584
    iget-object v2, v1, Ltb/h1;->i:Ljava/lang/String;

    .line 585
    .line 586
    iput-object v2, v0, Ltb/g1;->B:Ljava/lang/String;

    .line 587
    .line 588
    iget-wide v4, v1, Ltb/h1;->r:J

    .line 589
    .line 590
    iput-wide v4, v0, Ltb/g1;->f0:J

    .line 591
    .line 592
    iget-wide v4, v1, Ltb/h1;->s:J

    .line 593
    .line 594
    iput-wide v4, v0, Ltb/g1;->e0:J

    .line 595
    .line 596
    new-instance v2, Ltb/g1$c;

    .line 597
    .line 598
    move-object/from16 v4, p7

    .line 599
    .line 600
    invoke-direct {v2, v0, v4}, Ltb/g1$c;-><init>(Ltb/g1;Ltb/q2;)V

    .line 601
    .line 602
    .line 603
    iput-object v2, v0, Ltb/g1;->S:Ltb/n$b;

    .line 604
    .line 605
    invoke-interface {v2}, Ltb/n$b;->a()Ltb/n;

    .line 606
    .line 607
    .line 608
    move-result-object v2

    .line 609
    iput-object v2, v0, Ltb/g1;->T:Ltb/n;

    .line 610
    .line 611
    iget-object v1, v1, Ltb/h1;->u:Lrb/e0;

    .line 612
    .line 613
    invoke-static {v1}, Lp6/n;->n(Ljava/lang/Object;)Ljava/lang/Object;

    .line 614
    .line 615
    .line 616
    move-result-object v1

    .line 617
    check-cast v1, Lrb/e0;

    .line 618
    .line 619
    iput-object v1, v0, Ltb/g1;->W:Lrb/e0;

    .line 620
    .line 621
    invoke-virtual {v1, v0}, Lrb/e0;->d(Lrb/j0;)V

    .line 622
    .line 623
    .line 624
    if-nez v3, :cond_6

    .line 625
    .line 626
    iget-object v1, v0, Ltb/g1;->a0:Ltb/j1;

    .line 627
    .line 628
    if-eqz v1, :cond_5

    .line 629
    .line 630
    sget-object v1, Lrb/f$a;->b:Lrb/f$a;

    .line 631
    .line 632
    const-string v2, "Service config look-up disabled, using default service config"

    .line 633
    .line 634
    invoke-virtual {v9, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 635
    .line 636
    .line 637
    :cond_5
    const/4 v1, 0x1

    .line 638
    iput-boolean v1, v0, Ltb/g1;->b0:Z

    .line 639
    .line 640
    :cond_6
    return-void
    .line 641
    .line 642
    .line 643
    .line 644
    .line 645
    .line 646
    .line 647
    .line 648
    .line 649
    .line 650
    .line 651
    .line 652
    .line 653
    .line 654
    .line 655
    .line 656
    .line 657
    .line 658
    .line 659
    .line 660
    .line 661
    .line 662
    .line 663
    .line 664
    .line 665
    .line 666
    .line 667
    .line 668
    .line 669
    .line 670
    .line 671
    .line 672
    .line 673
    .line 674
    .line 675
    .line 676
    .line 677
    .line 678
    .line 679
    .line 680
    .line 681
    .line 682
    .line 683
    .line 684
    .line 685
    .line 686
    .line 687
    .line 688
    .line 689
    .line 690
    .line 691
    .line 692
    .line 693
    .line 694
    .line 695
    .line 696
    .line 697
    .line 698
    .line 699
    .line 700
    .line 701
    .line 702
    .line 703
    .line 704
    .line 705
    .line 706
    .line 707
    .line 708
    .line 709
    .line 710
    .line 711
    .line 712
    .line 713
    .line 714
    .line 715
    .line 716
    .line 717
    .line 718
    .line 719
    .line 720
    .line 721
    .line 722
    .line 723
    .line 724
    .line 725
    .line 726
    .line 727
    .line 728
    .line 729
    .line 730
    .line 731
    .line 732
    .line 733
    .line 734
    .line 735
    .line 736
    .line 737
    .line 738
    .line 739
    .line 740
    .line 741
    .line 742
    .line 743
    .line 744
    .line 745
    .line 746
    .line 747
    .line 748
    .line 749
    .line 750
    .line 751
    .line 752
    .line 753
    .line 754
    .line 755
    .line 756
    .line 757
    .line 758
    .line 759
    .line 760
    .line 761
    .line 762
    .line 763
    .line 764
    .line 765
    .line 766
    .line 767
    .line 768
    .line 769
    .line 770
    .line 771
    .line 772
    .line 773
    .line 774
    .line 775
    .line 776
    .line 777
    .line 778
    .line 779
    .line 780
    .line 781
    .line 782
    .line 783
    .line 784
    .line 785
    .line 786
    .line 787
    .line 788
    .line 789
    .line 790
    .line 791
    .line 792
    .line 793
    .line 794
    .line 795
    .line 796
    .line 797
    .line 798
    .line 799
    .line 800
    .line 801
    .line 802
    .line 803
    .line 804
    .line 805
    .line 806
    .line 807
    .line 808
    .line 809
    .line 810
    .line 811
    .line 812
    .line 813
    .line 814
    .line 815
    .line 816
    .line 817
    .line 818
    .line 819
    .line 820
    .line 821
    .line 822
    .line 823
    .line 824
    .line 825
    .line 826
    .line 827
    .line 828
    .line 829
    .line 830
    .line 831
    .line 832
    .line 833
    .line 834
    .line 835
    .line 836
    .line 837
    .line 838
    .line 839
    .line 840
    .line 841
    .line 842
    .line 843
    .line 844
    .line 845
    .line 846
    .line 847
    .line 848
    .line 849
    .line 850
    .line 851
    .line 852
    .line 853
    .line 854
    .line 855
    .line 856
    .line 857
    .line 858
    .line 859
    .line 860
    .line 861
    .line 862
    .line 863
    .line 864
    .line 865
    .line 866
    .line 867
    .line 868
    .line 869
    .line 870
    .line 871
    .line 872
    .line 873
    .line 874
    .line 875
    .line 876
    .line 877
    .line 878
    .line 879
    .line 880
    .line 881
    .line 882
    .line 883
    .line 884
    .line 885
    .line 886
    .line 887
    .line 888
    .line 889
    .line 890
    .line 891
    .line 892
    .line 893
    .line 894
    .line 895
    .line 896
    .line 897
    .line 898
    .line 899
    .line 900
    .line 901
    .line 902
    .line 903
    .line 904
    .line 905
    .line 906
    .line 907
    .line 908
    .line 909
    .line 910
    .line 911
    .line 912
    .line 913
    .line 914
    .line 915
    .line 916
    .line 917
    .line 918
    .line 919
    .line 920
    .line 921
    .line 922
    .line 923
    .line 924
    .line 925
    .line 926
    .line 927
    .line 928
    .line 929
    .line 930
    .line 931
    .line 932
    .line 933
    .line 934
    .line 935
    .line 936
    .line 937
    .line 938
    .line 939
    .line 940
    .line 941
    .line 942
    .line 943
    .line 944
    .line 945
    .line 946
    .line 947
    .line 948
    .line 949
    .line 950
    .line 951
    .line 952
    .line 953
    .line 954
    .line 955
    .line 956
    .line 957
    .line 958
    .line 959
    .line 960
    .line 961
    .line 962
    .line 963
    .line 964
    .line 965
    .line 966
    .line 967
    .line 968
    .line 969
    .line 970
    .line 971
    .line 972
    .line 973
    .line 974
    .line 975
    .line 976
    .line 977
    .line 978
    .line 979
    .line 980
    .line 981
    .line 982
    .line 983
    .line 984
    .line 985
    .line 986
    .line 987
    .line 988
    .line 989
    .line 990
    .line 991
    .line 992
    .line 993
    .line 994
    .line 995
    .line 996
    .line 997
    .line 998
    .line 999
    .line 1000
    .line 1001
    .line 1002
    .line 1003
    .line 1004
    .line 1005
    .line 1006
    .line 1007
    .line 1008
    .line 1009
    .line 1010
    .line 1011
    .line 1012
    .line 1013
    .line 1014
    .line 1015
    .line 1016
    .line 1017
    .line 1018
    .line 1019
    .line 1020
    .line 1021
    .line 1022
    .line 1023
    .line 1024
    .line 1025
    .line 1026
    .line 1027
    .line 1028
    .line 1029
    .line 1030
    .line 1031
    .line 1032
    .line 1033
    .line 1034
    .line 1035
    .line 1036
    .line 1037
    .line 1038
    .line 1039
    .line 1040
    .line 1041
    .line 1042
    .line 1043
    .line 1044
    .line 1045
    .line 1046
    .line 1047
    .line 1048
    .line 1049
    .line 1050
    .line 1051
    .line 1052
    .line 1053
    .line 1054
    .line 1055
    .line 1056
    .line 1057
    .line 1058
    .line 1059
    .line 1060
    .line 1061
    .line 1062
    .line 1063
    .line 1064
    .line 1065
    .line 1066
    .line 1067
    .line 1068
    .line 1069
    .line 1070
    .line 1071
    .line 1072
    .line 1073
    .line 1074
    .line 1075
    .line 1076
    .line 1077
    .line 1078
    .line 1079
    .line 1080
    .line 1081
    .line 1082
    .line 1083
    .line 1084
    .line 1085
    .line 1086
    .line 1087
    .line 1088
    .line 1089
    .line 1090
    .line 1091
    .line 1092
    .line 1093
    .line 1094
    .line 1095
    .line 1096
    .line 1097
    .line 1098
    .line 1099
    .line 1100
    .line 1101
    .line 1102
    .line 1103
    .line 1104
    .line 1105
    .line 1106
    .line 1107
    .line 1108
    .line 1109
    .line 1110
    .line 1111
    .line 1112
    .line 1113
    .line 1114
    .line 1115
    .line 1116
    .line 1117
    .line 1118
    .line 1119
    .line 1120
    .line 1121
    .line 1122
    .line 1123
    .line 1124
    .line 1125
    .line 1126
    .line 1127
    .line 1128
    .line 1129
    .line 1130
    .line 1131
    .line 1132
    .line 1133
    .line 1134
    .line 1135
    .line 1136
    .line 1137
    .line 1138
    .line 1139
    .line 1140
    .line 1141
    .line 1142
    .line 1143
    .line 1144
    .line 1145
    .line 1146
    .line 1147
    .line 1148
    .line 1149
    .line 1150
    .line 1151
    .line 1152
    .line 1153
    .line 1154
    .line 1155
    .line 1156
    .line 1157
    .line 1158
    .line 1159
    .line 1160
    .line 1161
    .line 1162
    .line 1163
    .line 1164
    .line 1165
    .line 1166
    .line 1167
    .line 1168
    .line 1169
    .line 1170
    .line 1171
    .line 1172
    .line 1173
    .line 1174
    .line 1175
    .line 1176
    .line 1177
    .line 1178
    .line 1179
    .line 1180
    .line 1181
    .line 1182
    .line 1183
    .line 1184
    .line 1185
    .line 1186
    .line 1187
    .line 1188
    .line 1189
    .line 1190
    .line 1191
    .line 1192
    .line 1193
    .line 1194
    .line 1195
    .line 1196
    .line 1197
    .line 1198
    .line 1199
    .line 1200
    .line 1201
    .line 1202
    .line 1203
    .line 1204
    .line 1205
    .line 1206
    .line 1207
    .line 1208
    .line 1209
    .line 1210
    .line 1211
    .line 1212
    .line 1213
    .line 1214
    .line 1215
    .line 1216
    .line 1217
    .line 1218
    .line 1219
    .line 1220
    .line 1221
    .line 1222
    .line 1223
    .line 1224
    .line 1225
    .line 1226
    .line 1227
    .line 1228
    .line 1229
    .line 1230
    .line 1231
    .line 1232
    .line 1233
    .line 1234
    .line 1235
    .line 1236
    .line 1237
    .line 1238
    .line 1239
    .line 1240
    .line 1241
    .line 1242
    .line 1243
    .line 1244
    .line 1245
    .line 1246
    .line 1247
    .line 1248
    .line 1249
    .line 1250
    .line 1251
    .line 1252
    .line 1253
    .line 1254
    .line 1255
    .line 1256
    .line 1257
    .line 1258
    .line 1259
    .line 1260
    .line 1261
    .line 1262
    .line 1263
    .line 1264
    .line 1265
    .line 1266
    .line 1267
    .line 1268
    .line 1269
    .line 1270
    .line 1271
    .line 1272
    .line 1273
    .line 1274
    .line 1275
    .line 1276
    .line 1277
    .line 1278
.end method

.method public static synthetic A(Ltb/g1;Z)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1;->x0(Z)V

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

.method public static synthetic B(Ltb/g1;)Ltb/n;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->T:Ltb/n;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static B0(Ljava/lang/String;Ljava/lang/String;Lrb/d1;Lrb/b1$a;Ljava/util/Collection;)Lrb/b1;
    .locals 3

    .line 1
    invoke-static {p0, p2, p3, p4}, Ltb/g1;->C0(Ljava/lang/String;Lrb/d1;Lrb/b1$a;Ljava/util/Collection;)Lrb/b1;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    new-instance p2, Ltb/e2;

    .line 6
    .line 7
    new-instance p4, Ltb/l;

    .line 8
    .line 9
    new-instance v0, Ltb/f0$a;

    .line 10
    .line 11
    invoke-direct {v0}, Ltb/f0$a;-><init>()V

    .line 12
    .line 13
    .line 14
    invoke-virtual {p3}, Lrb/b1$a;->d()Ljava/util/concurrent/ScheduledExecutorService;

    .line 15
    .line 16
    .line 17
    move-result-object v1

    .line 18
    invoke-virtual {p3}, Lrb/b1$a;->f()Lrb/o1;

    .line 19
    .line 20
    .line 21
    move-result-object v2

    .line 22
    invoke-direct {p4, v0, v1, v2}, Ltb/l;-><init>(Ltb/j$a;Ljava/util/concurrent/ScheduledExecutorService;Lrb/o1;)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {p3}, Lrb/b1$a;->f()Lrb/o1;

    .line 26
    .line 27
    .line 28
    move-result-object p3

    .line 29
    invoke-direct {p2, p0, p4, p3}, Ltb/e2;-><init>(Lrb/b1;Ltb/d2;Lrb/o1;)V

    .line 30
    .line 31
    .line 32
    if-nez p1, :cond_0

    .line 33
    .line 34
    return-object p2

    .line 35
    :cond_0
    new-instance p0, Ltb/g1$k;

    .line 36
    .line 37
    invoke-direct {p0, p2, p1}, Ltb/g1$k;-><init>(Lrb/b1;Ljava/lang/String;)V

    .line 38
    .line 39
    .line 40
    return-object p0
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
.end method

.method public static synthetic C(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->O:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static C0(Ljava/lang/String;Lrb/d1;Lrb/b1$a;Ljava/util/Collection;)Lrb/b1;
    .locals 7

    .line 1
    new-instance v0, Ljava/lang/StringBuilder;

    .line 2
    .line 3
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 4
    .line 5
    .line 6
    const/4 v1, 0x0

    .line 7
    :try_start_0
    new-instance v2, Ljava/net/URI;

    .line 8
    .line 9
    invoke-direct {v2, p0}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 10
    .line 11
    .line 12
    goto :goto_0

    .line 13
    :catch_0
    move-exception v2

    .line 14
    invoke-virtual {v2}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object v2

    .line 18
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 19
    .line 20
    .line 21
    move-object v2, v1

    .line 22
    :goto_0
    if-eqz v2, :cond_0

    .line 23
    .line 24
    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    .line 25
    .line 26
    .line 27
    move-result-object v3

    .line 28
    invoke-virtual {p1, v3}, Lrb/d1;->e(Ljava/lang/String;)Lrb/c1;

    .line 29
    .line 30
    .line 31
    move-result-object v3

    .line 32
    goto :goto_1

    .line 33
    :cond_0
    move-object v3, v1

    .line 34
    :goto_1
    const-string v4, ""

    .line 35
    .line 36
    if-nez v3, :cond_1

    .line 37
    .line 38
    sget-object v5, Ltb/g1;->n0:Ljava/util/regex/Pattern;

    .line 39
    .line 40
    invoke-virtual {v5, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    .line 41
    .line 42
    .line 43
    move-result-object v5

    .line 44
    invoke-virtual {v5}, Ljava/util/regex/Matcher;->matches()Z

    .line 45
    .line 46
    .line 47
    move-result v5

    .line 48
    if-nez v5, :cond_1

    .line 49
    .line 50
    :try_start_1
    new-instance v2, Ljava/net/URI;

    .line 51
    .line 52
    invoke-virtual {p1}, Lrb/d1;->c()Ljava/lang/String;

    .line 53
    .line 54
    .line 55
    move-result-object v3

    .line 56
    new-instance v5, Ljava/lang/StringBuilder;

    .line 57
    .line 58
    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 59
    .line 60
    .line 61
    const-string v6, "/"

    .line 62
    .line 63
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 64
    .line 65
    .line 66
    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    .line 68
    .line 69
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 70
    .line 71
    .line 72
    move-result-object v5

    .line 73
    invoke-direct {v2, v3, v4, v5, v1}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_1

    .line 74
    .line 75
    .line 76
    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    .line 77
    .line 78
    .line 79
    move-result-object v1

    .line 80
    invoke-virtual {p1, v1}, Lrb/d1;->e(Ljava/lang/String;)Lrb/c1;

    .line 81
    .line 82
    .line 83
    move-result-object v3

    .line 84
    goto :goto_2

    .line 85
    :catch_1
    move-exception p0

    .line 86
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 87
    .line 88
    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    .line 89
    .line 90
    .line 91
    throw p1

    .line 92
    :cond_1
    :goto_2
    const-string p1, ")"

    .line 93
    .line 94
    const-string v1, " ("

    .line 95
    .line 96
    if-nez v3, :cond_3

    .line 97
    .line 98
    new-instance p2, Ljava/lang/IllegalArgumentException;

    .line 99
    .line 100
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    .line 101
    .line 102
    .line 103
    move-result p3

    .line 104
    if-lez p3, :cond_2

    .line 105
    .line 106
    new-instance p3, Ljava/lang/StringBuilder;

    .line 107
    .line 108
    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    .line 109
    .line 110
    .line 111
    invoke-virtual {p3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 115
    .line 116
    .line 117
    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 118
    .line 119
    .line 120
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 121
    .line 122
    .line 123
    move-result-object v4

    .line 124
    :cond_2
    filled-new-array {p0, v4}, [Ljava/lang/Object;

    .line 125
    .line 126
    .line 127
    move-result-object p0

    .line 128
    const-string p1, "Could not find a NameResolverProvider for %s%s"

    .line 129
    .line 130
    invoke-static {p1, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 131
    .line 132
    .line 133
    move-result-object p0

    .line 134
    invoke-direct {p2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 135
    .line 136
    .line 137
    throw p2

    .line 138
    :cond_3
    if-eqz p3, :cond_5

    .line 139
    .line 140
    invoke-virtual {v3}, Lrb/c1;->c()Ljava/util/Collection;

    .line 141
    .line 142
    .line 143
    move-result-object v5

    .line 144
    invoke-interface {p3, v5}, Ljava/util/Collection;->containsAll(Ljava/util/Collection;)Z

    .line 145
    .line 146
    .line 147
    move-result p3

    .line 148
    if-eqz p3, :cond_4

    .line 149
    .line 150
    goto :goto_3

    .line 151
    :cond_4
    new-instance p1, Ljava/lang/IllegalArgumentException;

    .line 152
    .line 153
    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    .line 154
    .line 155
    .line 156
    move-result-object p2

    .line 157
    filled-new-array {p2, p0}, [Ljava/lang/Object;

    .line 158
    .line 159
    .line 160
    move-result-object p0

    .line 161
    const-string p2, "Address types of NameResolver \'%s\' for \'%s\' not supported by transport"

    .line 162
    .line 163
    invoke-static {p2, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 164
    .line 165
    .line 166
    move-result-object p0

    .line 167
    invoke-direct {p1, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 168
    .line 169
    .line 170
    throw p1

    .line 171
    :cond_5
    :goto_3
    invoke-virtual {v3, v2, p2}, Lrb/b1$c;->b(Ljava/net/URI;Lrb/b1$a;)Lrb/b1;

    .line 172
    .line 173
    .line 174
    move-result-object p2

    .line 175
    if-eqz p2, :cond_6

    .line 176
    .line 177
    return-object p2

    .line 178
    :cond_6
    new-instance p2, Ljava/lang/IllegalArgumentException;

    .line 179
    .line 180
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    .line 181
    .line 182
    .line 183
    move-result p3

    .line 184
    if-lez p3, :cond_7

    .line 185
    .line 186
    new-instance p3, Ljava/lang/StringBuilder;

    .line 187
    .line 188
    invoke-direct {p3}, Ljava/lang/StringBuilder;-><init>()V

    .line 189
    .line 190
    .line 191
    invoke-virtual {p3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 192
    .line 193
    .line 194
    invoke-virtual {p3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 195
    .line 196
    .line 197
    invoke-virtual {p3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 198
    .line 199
    .line 200
    invoke-virtual {p3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 201
    .line 202
    .line 203
    move-result-object v4

    .line 204
    :cond_7
    filled-new-array {p0, v4}, [Ljava/lang/Object;

    .line 205
    .line 206
    .line 207
    move-result-object p0

    .line 208
    const-string p1, "cannot create a NameResolver for %s%s"

    .line 209
    .line 210
    invoke-static {p1, p0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 211
    .line 212
    .line 213
    move-result-object p0

    .line 214
    invoke-direct {p2, p0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 215
    .line 216
    .line 217
    throw p2
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
.end method

.method public static synthetic D(Ltb/g1;Z)Z
    .locals 0

    .line 1
    iput-boolean p1, p0, Ltb/g1;->O:Z

    .line 2
    .line 3
    return p1
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

.method public static synthetic E(Ltb/g1;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/g1;->D0()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic F()Lrb/g0;
    .locals 1

    .line 1
    sget-object v0, Ltb/g1;->s0:Lrb/g0;

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

.method public static synthetic G(Ltb/g1;)Lrb/o;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->u:Lrb/o;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic H(Ltb/g1;)Lrb/v;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->t:Lrb/v;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic I(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->s:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic J(Ltb/g1;)Ltb/g1$m;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->k0:Ltb/g1$m;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic K(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->Q:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic L(Ltb/g1;)Ljava/util/Collection;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->I:Ljava/util/Collection;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic M(Ltb/g1;Ljava/util/Collection;)Ljava/util/Collection;
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1;->I:Ljava/util/Collection;

    .line 2
    .line 3
    return-object p1
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

.method public static synthetic N(Ltb/g1;)Ltb/p;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->U:Ltb/p;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic O(Ltb/g1;)Ljava/lang/Object;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->J:Ljava/lang/Object;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic P(Ltb/g1;)Ltb/g1$w;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->j:Ltb/g1$w;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic Q(Ltb/g1;)Lrb/t$c;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->h0:Lrb/t$c;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic R(Ltb/g1;)Ljava/util/concurrent/Executor;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->k:Ljava/util/concurrent/Executor;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic S()Lrb/g;
    .locals 1

    .line 1
    sget-object v0, Ltb/g1;->t0:Lrb/g;

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

.method public static synthetic T(Ltb/g1;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/g1;->G0()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic U(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->P:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic V(Ltb/g1;Z)Z
    .locals 0

    .line 1
    iput-boolean p1, p0, Ltb/g1;->P:Z

    .line 2
    .line 3
    return p1
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

.method public static synthetic W(Ltb/g1;)Ltb/x;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->x:Ltb/x;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic X(Ltb/g1;Lrb/r0$j;)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1;->L0(Lrb/r0$j;)V

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

.method public static synthetic Y(Ltb/g1;)Ltb/q2;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->p:Ltb/q2;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic Z(Ltb/g1;)I
    .locals 0

    .line 1
    iget p0, p0, Ltb/g1;->q:I

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic a0(Ltb/g1;)Ltb/n$b;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->S:Ltb/n$b;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic b0(Ltb/g1;)Lrb/e0;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->W:Lrb/e0;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic c0(Ltb/g1;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/g1;->E0()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic d0(Ltb/g1;)Ljava/lang/String;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->B:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic e0(Ltb/g1;)Ltb/j$a;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->y:Ltb/j$a;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic f0(Ltb/g1;)Lp6/s;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->v:Lp6/s;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic g0(Ltb/g1;)Ljava/util/List;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->A:Ljava/util/List;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic h0(Ltb/g1;)Lrb/b1;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->C:Lrb/b1;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic i0(Ltb/g1;)Ltb/g1$v;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->Y:Ltb/g1$v;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic j0(Ltb/g1;Ltb/g1$v;)Ltb/g1$v;
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1;->Y:Ltb/g1$v;

    .line 2
    .line 3
    return-object p1
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

.method public static synthetic k0(Ltb/g1;)Ljava/util/Set;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->H:Ljava/util/Set;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic l0(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->c0:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic m0(Ltb/g1;)Ltb/j1;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->a0:Ltb/j1;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic n0()Ltb/j1;
    .locals 1

    .line 1
    sget-object v0, Ltb/g1;->r0:Ltb/j1;

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

.method public static synthetic o(Ltb/g1;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/g1;->y0()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic o0(Ltb/g1;)Ltb/g1$u;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->X:Ltb/g1$u;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic p(Ltb/g1;)Lrb/r0$j;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->F:Lrb/r0$j;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic p0(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->b0:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic q(Ltb/g1;)Ljava/util/concurrent/atomic/AtomicBoolean;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->N:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic q0(Ltb/g1;Z)Z
    .locals 0

    .line 1
    iput-boolean p1, p0, Ltb/g1;->b0:Z

    .line 2
    .line 3
    return p1
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

.method public static synthetic r(Ltb/g1;)Ltb/b0;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->L:Ltb/b0;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic r0(Ltb/g1;)Ltb/j1;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->Z:Ltb/j1;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic s(Ltb/g1;)Z
    .locals 0

    .line 1
    iget-boolean p0, p0, Ltb/g1;->g0:Z

    .line 2
    .line 3
    return p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic s0(Ltb/g1;Ltb/j1;)Ltb/j1;
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1;->Z:Ltb/j1;

    .line 2
    .line 3
    return-object p1
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

.method public static synthetic t(Ltb/g1;)Ltb/b2$t;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->d0:Ltb/b2$t;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic t0(Ltb/g1;)Ljava/lang/String;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->c:Ljava/lang/String;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic u(Ltb/g1;)J
    .locals 2

    .line 1
    iget-wide v0, p0, Ltb/g1;->e0:J

    .line 2
    .line 3
    return-wide v0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic u0(Ltb/g1;Z)V
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1;->J0(Z)V

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

.method public static synthetic v(Ltb/g1;)J
    .locals 2

    .line 1
    iget-wide v0, p0, Ltb/g1;->f0:J

    .line 2
    .line 3
    return-wide v0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic v0(Ltb/g1;)V
    .locals 0

    .line 1
    invoke-virtual {p0}, Ltb/g1;->H0()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic w(Ltb/g1;Lrb/c;)Ljava/util/concurrent/Executor;
    .locals 0

    .line 1
    invoke-virtual {p0, p1}, Ltb/g1;->A0(Lrb/c;)Ljava/util/concurrent/Executor;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
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

.method public static synthetic w0(Ltb/g1;)Ltb/g1$s;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic x(Ltb/g1;)Ltb/u;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->h:Ltb/u;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic y(Ltb/g1;)Ltb/g1$y;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->M:Ltb/g1$y;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic z(Ltb/g1;)Lrb/f;
    .locals 0

    .line 1
    iget-object p0, p0, Ltb/g1;->V:Lrb/f;

    .line 2
    .line 3
    return-object p0
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public final A0(Lrb/c;)Ljava/util/concurrent/Executor;
    .locals 0

    .line 1
    invoke-virtual {p1}, Lrb/c;->e()Ljava/util/concurrent/Executor;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    if-nez p1, :cond_0

    .line 6
    .line 7
    iget-object p1, p0, Ltb/g1;->k:Ljava/util/concurrent/Executor;

    .line 8
    .line 9
    :cond_0
    return-object p1
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
.end method

.method public final D0()V
    .locals 3

    .line 1
    iget-boolean v0, p0, Ltb/g1;->O:Z

    .line 2
    .line 3
    if-eqz v0, :cond_2

    .line 4
    .line 5
    iget-object v0, p0, Ltb/g1;->H:Ljava/util/Set;

    .line 6
    .line 7
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 12
    .line 13
    .line 14
    move-result v1

    .line 15
    if-eqz v1, :cond_0

    .line 16
    .line 17
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v1

    .line 21
    check-cast v1, Ltb/y0;

    .line 22
    .line 23
    sget-object v2, Ltb/g1;->o0:Lrb/k1;

    .line 24
    .line 25
    invoke-virtual {v1, v2}, Ltb/y0;->h(Lrb/k1;)V

    .line 26
    .line 27
    .line 28
    goto :goto_0

    .line 29
    :cond_0
    iget-object v0, p0, Ltb/g1;->K:Ljava/util/Set;

    .line 30
    .line 31
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 36
    .line 37
    .line 38
    move-result v1

    .line 39
    if-nez v1, :cond_1

    .line 40
    .line 41
    goto :goto_1

    .line 42
    :cond_1
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 43
    .line 44
    .line 45
    move-result-object v0

    .line 46
    invoke-static {v0}, Landroid/support/v4/media/session/b;->a(Ljava/lang/Object;)V

    .line 47
    .line 48
    .line 49
    const/4 v0, 0x0

    .line 50
    throw v0

    .line 51
    :cond_2
    :goto_1
    return-void
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
.end method

.method public final E0()V
    .locals 3

    .line 1
    iget-boolean v0, p0, Ltb/g1;->Q:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    goto :goto_0

    .line 6
    :cond_0
    iget-object v0, p0, Ltb/g1;->N:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 7
    .line 8
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-eqz v0, :cond_1

    .line 13
    .line 14
    iget-object v0, p0, Ltb/g1;->H:Ljava/util/Set;

    .line 15
    .line 16
    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    .line 17
    .line 18
    .line 19
    move-result v0

    .line 20
    if-eqz v0, :cond_1

    .line 21
    .line 22
    iget-object v0, p0, Ltb/g1;->K:Ljava/util/Set;

    .line 23
    .line 24
    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    .line 25
    .line 26
    .line 27
    move-result v0

    .line 28
    if-eqz v0, :cond_1

    .line 29
    .line 30
    iget-object v0, p0, Ltb/g1;->V:Lrb/f;

    .line 31
    .line 32
    sget-object v1, Lrb/f$a;->b:Lrb/f$a;

    .line 33
    .line 34
    const-string v2, "Terminated"

    .line 35
    .line 36
    invoke-virtual {v0, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 37
    .line 38
    .line 39
    iget-object v0, p0, Ltb/g1;->W:Lrb/e0;

    .line 40
    .line 41
    invoke-virtual {v0, p0}, Lrb/e0;->j(Lrb/j0;)V

    .line 42
    .line 43
    .line 44
    iget-object v0, p0, Ltb/g1;->l:Ltb/p1;

    .line 45
    .line 46
    iget-object v1, p0, Ltb/g1;->k:Ljava/util/concurrent/Executor;

    .line 47
    .line 48
    invoke-interface {v0, v1}, Ltb/p1;->b(Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    .line 50
    .line 51
    iget-object v0, p0, Ltb/g1;->n:Ltb/g1$p;

    .line 52
    .line 53
    invoke-virtual {v0}, Ltb/g1$p;->b()V

    .line 54
    .line 55
    .line 56
    iget-object v0, p0, Ltb/g1;->o:Ltb/g1$p;

    .line 57
    .line 58
    invoke-virtual {v0}, Ltb/g1$p;->b()V

    .line 59
    .line 60
    .line 61
    iget-object v0, p0, Ltb/g1;->h:Ltb/u;

    .line 62
    .line 63
    invoke-interface {v0}, Ltb/u;->close()V

    .line 64
    .line 65
    .line 66
    const/4 v0, 0x1

    .line 67
    iput-boolean v0, p0, Ltb/g1;->Q:Z

    .line 68
    .line 69
    iget-object v0, p0, Ltb/g1;->R:Ljava/util/concurrent/CountDownLatch;

    .line 70
    .line 71
    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 72
    .line 73
    .line 74
    :cond_1
    :goto_0
    return-void
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
.end method

.method public F0(Ljava/lang/Throwable;)V
    .locals 2

    .line 1
    iget-boolean v0, p0, Ltb/g1;->G:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    const/4 v0, 0x1

    .line 7
    iput-boolean v0, p0, Ltb/g1;->G:Z

    .line 8
    .line 9
    invoke-virtual {p0, v0}, Ltb/g1;->x0(Z)V

    .line 10
    .line 11
    .line 12
    const/4 v0, 0x0

    .line 13
    invoke-virtual {p0, v0}, Ltb/g1;->J0(Z)V

    .line 14
    .line 15
    .line 16
    new-instance v0, Ltb/g1$e;

    .line 17
    .line 18
    invoke-direct {v0, p0, p1}, Ltb/g1$e;-><init>(Ltb/g1;Ljava/lang/Throwable;)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {p0, v0}, Ltb/g1;->L0(Lrb/r0$j;)V

    .line 22
    .line 23
    .line 24
    iget-object p1, p0, Ltb/g1;->X:Ltb/g1$u;

    .line 25
    .line 26
    const/4 v0, 0x0

    .line 27
    invoke-virtual {p1, v0}, Ltb/g1$u;->p(Lrb/g0;)V

    .line 28
    .line 29
    .line 30
    iget-object p1, p0, Ltb/g1;->V:Lrb/f;

    .line 31
    .line 32
    sget-object v0, Lrb/f$a;->d:Lrb/f$a;

    .line 33
    .line 34
    const-string v1, "PANIC! Entering TRANSIENT_FAILURE"

    .line 35
    .line 36
    invoke-virtual {p1, v0, v1}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 37
    .line 38
    .line 39
    iget-object p1, p0, Ltb/g1;->x:Ltb/x;

    .line 40
    .line 41
    sget-object v0, Lrb/p;->c:Lrb/p;

    .line 42
    .line 43
    invoke-virtual {p1, v0}, Ltb/x;->b(Lrb/p;)V

    .line 44
    .line 45
    .line 46
    return-void
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
.end method

.method public final G0()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 4
    .line 5
    .line 6
    iget-boolean v0, p0, Ltb/g1;->D:Z

    .line 7
    .line 8
    if-eqz v0, :cond_0

    .line 9
    .line 10
    iget-object v0, p0, Ltb/g1;->C:Lrb/b1;

    .line 11
    .line 12
    invoke-virtual {v0}, Lrb/b1;->b()V

    .line 13
    .line 14
    .line 15
    :cond_0
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public final H0()V
    .locals 4

    .line 1
    iget-wide v0, p0, Ltb/g1;->w:J

    .line 2
    .line 3
    const-wide/16 v2, -0x1

    .line 4
    .line 5
    cmp-long v2, v0, v2

    .line 6
    .line 7
    if-nez v2, :cond_0

    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object v2, p0, Ltb/g1;->l0:Ltb/a2;

    .line 11
    .line 12
    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    .line 13
    .line 14
    invoke-virtual {v2, v0, v1, v3}, Ltb/a2;->k(JLjava/util/concurrent/TimeUnit;)V

    .line 15
    .line 16
    .line 17
    return-void
    .line 18
    .line 19
.end method

.method public I0()Ltb/g1;
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/g1;->V:Lrb/f;

    .line 2
    .line 3
    sget-object v1, Lrb/f$a;->a:Lrb/f$a;

    .line 4
    .line 5
    const-string v2, "shutdown() called"

    .line 6
    .line 7
    invoke-virtual {v0, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    iget-object v0, p0, Ltb/g1;->N:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 11
    .line 12
    const/4 v1, 0x0

    .line 13
    const/4 v2, 0x1

    .line 14
    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    .line 15
    .line 16
    .line 17
    move-result v0

    .line 18
    if-nez v0, :cond_0

    .line 19
    .line 20
    return-object p0

    .line 21
    :cond_0
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 22
    .line 23
    new-instance v1, Ltb/g1$h;

    .line 24
    .line 25
    invoke-direct {v1, p0}, Ltb/g1$h;-><init>(Ltb/g1;)V

    .line 26
    .line 27
    .line 28
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 29
    .line 30
    .line 31
    iget-object v0, p0, Ltb/g1;->X:Ltb/g1$u;

    .line 32
    .line 33
    invoke-virtual {v0}, Ltb/g1$u;->n()V

    .line 34
    .line 35
    .line 36
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 37
    .line 38
    new-instance v1, Ltb/g1$b;

    .line 39
    .line 40
    invoke-direct {v1, p0}, Ltb/g1$b;-><init>(Ltb/g1;)V

    .line 41
    .line 42
    .line 43
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 44
    .line 45
    .line 46
    return-object p0
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
.end method

.method public final J0(Z)V
    .locals 5

    .line 1
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 4
    .line 5
    .line 6
    const/4 v0, 0x0

    .line 7
    if-eqz p1, :cond_1

    .line 8
    .line 9
    iget-boolean v1, p0, Ltb/g1;->D:Z

    .line 10
    .line 11
    const-string v2, "nameResolver is not started"

    .line 12
    .line 13
    invoke-static {v1, v2}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 14
    .line 15
    .line 16
    iget-object v1, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 17
    .line 18
    if-eqz v1, :cond_0

    .line 19
    .line 20
    const/4 v1, 0x1

    .line 21
    goto :goto_0

    .line 22
    :cond_0
    move v1, v0

    .line 23
    :goto_0
    const-string v2, "lbHelper is null"

    .line 24
    .line 25
    invoke-static {v1, v2}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 26
    .line 27
    .line 28
    :cond_1
    iget-object v1, p0, Ltb/g1;->C:Lrb/b1;

    .line 29
    .line 30
    const/4 v2, 0x0

    .line 31
    if-eqz v1, :cond_3

    .line 32
    .line 33
    invoke-virtual {v1}, Lrb/b1;->c()V

    .line 34
    .line 35
    .line 36
    iput-boolean v0, p0, Ltb/g1;->D:Z

    .line 37
    .line 38
    if-eqz p1, :cond_2

    .line 39
    .line 40
    iget-object p1, p0, Ltb/g1;->b:Ljava/lang/String;

    .line 41
    .line 42
    iget-object v0, p0, Ltb/g1;->c:Ljava/lang/String;

    .line 43
    .line 44
    iget-object v1, p0, Ltb/g1;->d:Lrb/d1;

    .line 45
    .line 46
    iget-object v3, p0, Ltb/g1;->e:Lrb/b1$a;

    .line 47
    .line 48
    iget-object v4, p0, Ltb/g1;->h:Ltb/u;

    .line 49
    .line 50
    invoke-interface {v4}, Ltb/u;->Y()Ljava/util/Collection;

    .line 51
    .line 52
    .line 53
    move-result-object v4

    .line 54
    invoke-static {p1, v0, v1, v3, v4}, Ltb/g1;->B0(Ljava/lang/String;Ljava/lang/String;Lrb/d1;Lrb/b1$a;Ljava/util/Collection;)Lrb/b1;

    .line 55
    .line 56
    .line 57
    move-result-object p1

    .line 58
    iput-object p1, p0, Ltb/g1;->C:Lrb/b1;

    .line 59
    .line 60
    goto :goto_1

    .line 61
    :cond_2
    iput-object v2, p0, Ltb/g1;->C:Lrb/b1;

    .line 62
    .line 63
    :cond_3
    :goto_1
    iget-object p1, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 64
    .line 65
    if-eqz p1, :cond_4

    .line 66
    .line 67
    iget-object p1, p1, Ltb/g1$s;->a:Ltb/i$b;

    .line 68
    .line 69
    invoke-virtual {p1}, Ltb/i$b;->d()V

    .line 70
    .line 71
    .line 72
    iput-object v2, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 73
    .line 74
    :cond_4
    iput-object v2, p0, Ltb/g1;->F:Lrb/r0$j;

    .line 75
    .line 76
    return-void
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
.end method

.method public K0()Ltb/g1;
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/g1;->V:Lrb/f;

    .line 2
    .line 3
    sget-object v1, Lrb/f$a;->a:Lrb/f$a;

    .line 4
    .line 5
    const-string v2, "shutdownNow() called"

    .line 6
    .line 7
    invoke-virtual {v0, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 8
    .line 9
    .line 10
    invoke-virtual {p0}, Ltb/g1;->I0()Ltb/g1;

    .line 11
    .line 12
    .line 13
    iget-object v0, p0, Ltb/g1;->X:Ltb/g1$u;

    .line 14
    .line 15
    invoke-virtual {v0}, Ltb/g1$u;->o()V

    .line 16
    .line 17
    .line 18
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 19
    .line 20
    new-instance v1, Ltb/g1$i;

    .line 21
    .line 22
    invoke-direct {v1, p0}, Ltb/g1$i;-><init>(Ltb/g1;)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 26
    .line 27
    .line 28
    return-object p0
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
.end method

.method public final L0(Lrb/r0$j;)V
    .locals 1

    .line 1
    iput-object p1, p0, Ltb/g1;->F:Lrb/r0$j;

    .line 2
    .line 3
    iget-object v0, p0, Ltb/g1;->L:Ltb/b0;

    .line 4
    .line 5
    invoke-virtual {v0, p1}, Ltb/b0;->r(Lrb/r0$j;)V

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
.end method

.method public a()Ljava/lang/String;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->z:Lrb/d;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/d;->a()Ljava/lang/String;

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
    .line 17
    .line 18
    .line 19
.end method

.method public e(Lrb/z0;Lrb/c;)Lrb/g;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->z:Lrb/d;

    .line 2
    .line 3
    invoke-virtual {v0, p1, p2}, Lrb/d;->e(Lrb/z0;Lrb/c;)Lrb/g;

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
.end method

.method public f()Lrb/k0;
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->a:Lrb/k0;

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

.method public i(JLjava/util/concurrent/TimeUnit;)Z
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->R:Ljava/util/concurrent/CountDownLatch;

    .line 2
    .line 3
    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

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

.method public j()V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 2
    .line 3
    new-instance v1, Ltb/g1$f;

    .line 4
    .line 5
    invoke-direct {v1, p0}, Ltb/g1$f;-><init>(Ltb/g1;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 9
    .line 10
    .line 11
    return-void
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public k(Z)Lrb/p;
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1;->x:Ltb/x;

    .line 2
    .line 3
    invoke-virtual {v0}, Ltb/x;->a()Lrb/p;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    if-eqz p1, :cond_0

    .line 8
    .line 9
    sget-object p1, Lrb/p;->d:Lrb/p;

    .line 10
    .line 11
    if-ne v0, p1, :cond_0

    .line 12
    .line 13
    iget-object p1, p0, Ltb/g1;->r:Lrb/o1;

    .line 14
    .line 15
    new-instance v1, Ltb/g1$g;

    .line 16
    .line 17
    invoke-direct {v1, p0}, Ltb/g1$g;-><init>(Ltb/g1;)V

    .line 18
    .line 19
    .line 20
    invoke-virtual {p1, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 21
    .line 22
    .line 23
    :cond_0
    return-object v0
    .line 24
    .line 25
    .line 26
.end method

.method public l(Lrb/p;Ljava/lang/Runnable;)V
    .locals 2

    .line 1
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 2
    .line 3
    new-instance v1, Ltb/g1$d;

    .line 4
    .line 5
    invoke-direct {v1, p0, p2, p1}, Ltb/g1$d;-><init>(Ltb/g1;Ljava/lang/Runnable;Lrb/p;)V

    .line 6
    .line 7
    .line 8
    invoke-virtual {v0, v1}, Lrb/o1;->execute(Ljava/lang/Runnable;)V

    .line 9
    .line 10
    .line 11
    return-void
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

.method public bridge synthetic m()Lrb/u0;
    .locals 1

    .line 1
    invoke-virtual {p0}, Ltb/g1;->I0()Ltb/g1;

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

.method public bridge synthetic n()Lrb/u0;
    .locals 1

    .line 1
    invoke-virtual {p0}, Ltb/g1;->K0()Ltb/g1;

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

.method public toString()Ljava/lang/String;
    .locals 4

    .line 1
    invoke-static {p0}, Lp6/h;->b(Ljava/lang/Object;)Lp6/h$b;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    iget-object v1, p0, Ltb/g1;->a:Lrb/k0;

    .line 6
    .line 7
    invoke-virtual {v1}, Lrb/k0;->d()J

    .line 8
    .line 9
    .line 10
    move-result-wide v1

    .line 11
    const-string v3, "logId"

    .line 12
    .line 13
    invoke-virtual {v0, v3, v1, v2}, Lp6/h$b;->c(Ljava/lang/String;J)Lp6/h$b;

    .line 14
    .line 15
    .line 16
    move-result-object v0

    .line 17
    const-string v1, "target"

    .line 18
    .line 19
    iget-object v2, p0, Ltb/g1;->b:Ljava/lang/String;

    .line 20
    .line 21
    invoke-virtual {v0, v1, v2}, Lp6/h$b;->d(Ljava/lang/String;Ljava/lang/Object;)Lp6/h$b;

    .line 22
    .line 23
    .line 24
    move-result-object v0

    .line 25
    invoke-virtual {v0}, Lp6/h$b;->toString()Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v0

    .line 29
    return-object v0
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
.end method

.method public final x0(Z)V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1;->l0:Ltb/a2;

    .line 2
    .line 3
    invoke-virtual {v0, p1}, Ltb/a2;->i(Z)V

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
    .line 25
    .line 26
.end method

.method public final y0()V
    .locals 3

    .line 1
    const/4 v0, 0x1

    .line 2
    invoke-virtual {p0, v0}, Ltb/g1;->J0(Z)V

    .line 3
    .line 4
    .line 5
    iget-object v0, p0, Ltb/g1;->L:Ltb/b0;

    .line 6
    .line 7
    const/4 v1, 0x0

    .line 8
    invoke-virtual {v0, v1}, Ltb/b0;->r(Lrb/r0$j;)V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Ltb/g1;->V:Lrb/f;

    .line 12
    .line 13
    sget-object v1, Lrb/f$a;->b:Lrb/f$a;

    .line 14
    .line 15
    const-string v2, "Entering IDLE state"

    .line 16
    .line 17
    invoke-virtual {v0, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    iget-object v0, p0, Ltb/g1;->x:Ltb/x;

    .line 21
    .line 22
    sget-object v1, Lrb/p;->d:Lrb/p;

    .line 23
    .line 24
    invoke-virtual {v0, v1}, Ltb/x;->b(Lrb/p;)V

    .line 25
    .line 26
    .line 27
    iget-object v0, p0, Ltb/g1;->j0:Ltb/w0;

    .line 28
    .line 29
    iget-object v1, p0, Ltb/g1;->J:Ljava/lang/Object;

    .line 30
    .line 31
    iget-object v2, p0, Ltb/g1;->L:Ltb/b0;

    .line 32
    .line 33
    filled-new-array {v1, v2}, [Ljava/lang/Object;

    .line 34
    .line 35
    .line 36
    move-result-object v1

    .line 37
    invoke-virtual {v0, v1}, Ltb/w0;->a([Ljava/lang/Object;)Z

    .line 38
    .line 39
    .line 40
    move-result v0

    .line 41
    if-eqz v0, :cond_0

    .line 42
    .line 43
    invoke-virtual {p0}, Ltb/g1;->z0()V

    .line 44
    .line 45
    .line 46
    :cond_0
    return-void
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
.end method

.method public z0()V
    .locals 3

    .line 1
    iget-object v0, p0, Ltb/g1;->r:Lrb/o1;

    .line 2
    .line 3
    invoke-virtual {v0}, Lrb/o1;->f()V

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ltb/g1;->N:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 7
    .line 8
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    .line 9
    .line 10
    .line 11
    move-result v0

    .line 12
    if-nez v0, :cond_3

    .line 13
    .line 14
    iget-boolean v0, p0, Ltb/g1;->G:Z

    .line 15
    .line 16
    if-eqz v0, :cond_0

    .line 17
    .line 18
    goto :goto_1

    .line 19
    :cond_0
    iget-object v0, p0, Ltb/g1;->j0:Ltb/w0;

    .line 20
    .line 21
    invoke-virtual {v0}, Ltb/w0;->d()Z

    .line 22
    .line 23
    .line 24
    move-result v0

    .line 25
    if-eqz v0, :cond_1

    .line 26
    .line 27
    const/4 v0, 0x0

    .line 28
    invoke-virtual {p0, v0}, Ltb/g1;->x0(Z)V

    .line 29
    .line 30
    .line 31
    goto :goto_0

    .line 32
    :cond_1
    invoke-virtual {p0}, Ltb/g1;->H0()V

    .line 33
    .line 34
    .line 35
    :goto_0
    iget-object v0, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 36
    .line 37
    if-eqz v0, :cond_2

    .line 38
    .line 39
    goto :goto_1

    .line 40
    :cond_2
    iget-object v0, p0, Ltb/g1;->V:Lrb/f;

    .line 41
    .line 42
    sget-object v1, Lrb/f$a;->b:Lrb/f$a;

    .line 43
    .line 44
    const-string v2, "Exiting idle mode"

    .line 45
    .line 46
    invoke-virtual {v0, v1, v2}, Lrb/f;->a(Lrb/f$a;Ljava/lang/String;)V

    .line 47
    .line 48
    .line 49
    new-instance v0, Ltb/g1$s;

    .line 50
    .line 51
    const/4 v1, 0x0

    .line 52
    invoke-direct {v0, p0, v1}, Ltb/g1$s;-><init>(Ltb/g1;Ltb/g1$a;)V

    .line 53
    .line 54
    .line 55
    iget-object v1, p0, Ltb/g1;->f:Ltb/i;

    .line 56
    .line 57
    invoke-virtual {v1, v0}, Ltb/i;->e(Lrb/r0$e;)Ltb/i$b;

    .line 58
    .line 59
    .line 60
    move-result-object v1

    .line 61
    iput-object v1, v0, Ltb/g1$s;->a:Ltb/i$b;

    .line 62
    .line 63
    iput-object v0, p0, Ltb/g1;->E:Ltb/g1$s;

    .line 64
    .line 65
    new-instance v1, Ltb/g1$t;

    .line 66
    .line 67
    iget-object v2, p0, Ltb/g1;->C:Lrb/b1;

    .line 68
    .line 69
    invoke-direct {v1, p0, v0, v2}, Ltb/g1$t;-><init>(Ltb/g1;Ltb/g1$s;Lrb/b1;)V

    .line 70
    .line 71
    .line 72
    iget-object v0, p0, Ltb/g1;->C:Lrb/b1;

    .line 73
    .line 74
    invoke-virtual {v0, v1}, Lrb/b1;->d(Lrb/b1$d;)V

    .line 75
    .line 76
    .line 77
    const/4 v0, 0x1

    .line 78
    iput-boolean v0, p0, Ltb/g1;->D:Z

    .line 79
    .line 80
    :cond_3
    :goto_1
    return-void
    .line 81
    .line 82
.end method
