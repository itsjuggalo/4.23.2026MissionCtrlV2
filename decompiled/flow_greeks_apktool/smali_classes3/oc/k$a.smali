.class public final Loc/k$a;
.super Lwc/a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lcc/i;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Loc/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lkh/b;

.field public final b:Lic/e;

.field public final c:I

.field public final d:I

.field public final e:Ljava/util/concurrent/atomic/AtomicLong;

.field public f:Lkh/c;

.field public g:Llc/i;

.field public volatile h:Z

.field public volatile i:Z

.field public final j:Ljava/util/concurrent/atomic/AtomicReference;

.field public k:Ljava/util/Iterator;

.field public l:I

.field public m:I


# direct methods
.method public constructor <init>(Lkh/b;Lic/e;I)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lwc/a;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Loc/k$a;->a:Lkh/b;

    .line 5
    .line 6
    iput-object p2, p0, Loc/k$a;->b:Lic/e;

    .line 7
    .line 8
    iput p3, p0, Loc/k$a;->c:I

    .line 9
    .line 10
    shr-int/lit8 p1, p3, 0x2

    .line 11
    .line 12
    sub-int/2addr p3, p1

    .line 13
    iput p3, p0, Loc/k$a;->d:I

    .line 14
    .line 15
    new-instance p1, Ljava/util/concurrent/atomic/AtomicReference;

    .line 16
    .line 17
    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    .line 18
    .line 19
    .line 20
    iput-object p1, p0, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 21
    .line 22
    new-instance p1, Ljava/util/concurrent/atomic/AtomicLong;

    .line 23
    .line 24
    invoke-direct {p1}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    .line 25
    .line 26
    .line 27
    iput-object p1, p0, Loc/k$a;->e:Ljava/util/concurrent/atomic/AtomicLong;

    .line 28
    .line 29
    return-void
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
.end method


# virtual methods
.method public b(Lkh/c;)V
    .locals 3

    .line 1
    iget-object v0, p0, Loc/k$a;->f:Lkh/c;

    .line 2
    .line 3
    invoke-static {v0, p1}, Lwc/g;->m(Lkh/c;Lkh/c;)Z

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_2

    .line 8
    .line 9
    iput-object p1, p0, Loc/k$a;->f:Lkh/c;

    .line 10
    .line 11
    instance-of v0, p1, Llc/f;

    .line 12
    .line 13
    if-eqz v0, :cond_1

    .line 14
    .line 15
    move-object v0, p1

    .line 16
    check-cast v0, Llc/f;

    .line 17
    .line 18
    const/4 v1, 0x3

    .line 19
    invoke-interface {v0, v1}, Llc/e;->h(I)I

    .line 20
    .line 21
    .line 22
    move-result v1

    .line 23
    const/4 v2, 0x1

    .line 24
    if-ne v1, v2, :cond_0

    .line 25
    .line 26
    iput v1, p0, Loc/k$a;->m:I

    .line 27
    .line 28
    iput-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 29
    .line 30
    iput-boolean v2, p0, Loc/k$a;->h:Z

    .line 31
    .line 32
    iget-object p1, p0, Loc/k$a;->a:Lkh/b;

    .line 33
    .line 34
    invoke-interface {p1, p0}, Lkh/b;->b(Lkh/c;)V

    .line 35
    .line 36
    .line 37
    return-void

    .line 38
    :cond_0
    const/4 v2, 0x2

    .line 39
    if-ne v1, v2, :cond_1

    .line 40
    .line 41
    iput v1, p0, Loc/k$a;->m:I

    .line 42
    .line 43
    iput-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 44
    .line 45
    iget-object v0, p0, Loc/k$a;->a:Lkh/b;

    .line 46
    .line 47
    invoke-interface {v0, p0}, Lkh/b;->b(Lkh/c;)V

    .line 48
    .line 49
    .line 50
    iget v0, p0, Loc/k$a;->c:I

    .line 51
    .line 52
    int-to-long v0, v0

    .line 53
    invoke-interface {p1, v0, v1}, Lkh/c;->request(J)V

    .line 54
    .line 55
    .line 56
    return-void

    .line 57
    :cond_1
    new-instance v0, Ltc/a;

    .line 58
    .line 59
    iget v1, p0, Loc/k$a;->c:I

    .line 60
    .line 61
    invoke-direct {v0, v1}, Ltc/a;-><init>(I)V

    .line 62
    .line 63
    .line 64
    iput-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 65
    .line 66
    iget-object v0, p0, Loc/k$a;->a:Lkh/b;

    .line 67
    .line 68
    invoke-interface {v0, p0}, Lkh/b;->b(Lkh/c;)V

    .line 69
    .line 70
    .line 71
    iget v0, p0, Loc/k$a;->c:I

    .line 72
    .line 73
    int-to-long v0, v0

    .line 74
    invoke-interface {p1, v0, v1}, Lkh/c;->request(J)V

    .line 75
    .line 76
    .line 77
    :cond_2
    return-void
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

.method public c(ZZLkh/b;Llc/i;)Z
    .locals 3

    .line 1
    iget-boolean v0, p0, Loc/k$a;->i:Z

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    const/4 v2, 0x1

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    iput-object v1, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 8
    .line 9
    invoke-interface {p4}, Llc/i;->clear()V

    .line 10
    .line 11
    .line 12
    return v2

    .line 13
    :cond_0
    if-eqz p1, :cond_2

    .line 14
    .line 15
    iget-object p1, p0, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 16
    .line 17
    invoke-virtual {p1}, Ljava/util/concurrent/atomic/AtomicReference;->get()Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object p1

    .line 21
    check-cast p1, Ljava/lang/Throwable;

    .line 22
    .line 23
    if-eqz p1, :cond_1

    .line 24
    .line 25
    iget-object p1, p0, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 26
    .line 27
    invoke-static {p1}, Lxc/g;->b(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    iput-object v1, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 32
    .line 33
    invoke-interface {p4}, Llc/i;->clear()V

    .line 34
    .line 35
    .line 36
    invoke-interface {p3, p1}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 37
    .line 38
    .line 39
    return v2

    .line 40
    :cond_1
    if-eqz p2, :cond_2

    .line 41
    .line 42
    invoke-interface {p3}, Lkh/b;->onComplete()V

    .line 43
    .line 44
    .line 45
    return v2

    .line 46
    :cond_2
    const/4 p1, 0x0

    .line 47
    return p1
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
.end method

.method public cancel()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Loc/k$a;->i:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    const/4 v0, 0x1

    .line 6
    iput-boolean v0, p0, Loc/k$a;->i:Z

    .line 7
    .line 8
    iget-object v0, p0, Loc/k$a;->f:Lkh/c;

    .line 9
    .line 10
    invoke-interface {v0}, Lkh/c;->cancel()V

    .line 11
    .line 12
    .line 13
    invoke-virtual {p0}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    if-nez v0, :cond_0

    .line 18
    .line 19
    iget-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 20
    .line 21
    invoke-interface {v0}, Llc/i;->clear()V

    .line 22
    .line 23
    .line 24
    :cond_0
    return-void
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
.end method

.method public clear()V
    .locals 1

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-object v0, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 3
    .line 4
    iget-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 5
    .line 6
    invoke-interface {v0}, Llc/i;->clear()V

    .line 7
    .line 8
    .line 9
    return-void
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

.method public e(Z)V
    .locals 3

    .line 1
    if-eqz p1, :cond_1

    .line 2
    .line 3
    iget p1, p0, Loc/k$a;->l:I

    .line 4
    .line 5
    add-int/lit8 p1, p1, 0x1

    .line 6
    .line 7
    iget v0, p0, Loc/k$a;->d:I

    .line 8
    .line 9
    if-ne p1, v0, :cond_0

    .line 10
    .line 11
    const/4 v0, 0x0

    .line 12
    iput v0, p0, Loc/k$a;->l:I

    .line 13
    .line 14
    iget-object v0, p0, Loc/k$a;->f:Lkh/c;

    .line 15
    .line 16
    int-to-long v1, p1

    .line 17
    invoke-interface {v0, v1, v2}, Lkh/c;->request(J)V

    .line 18
    .line 19
    .line 20
    return-void

    .line 21
    :cond_0
    iput p1, p0, Loc/k$a;->l:I

    .line 22
    .line 23
    :cond_1
    return-void
    .line 24
    .line 25
    .line 26
.end method

.method public f()V
    .locals 18

    .line 1
    move-object/from16 v1, p0

    .line 2
    .line 3
    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicInteger;->getAndIncrement()I

    .line 4
    .line 5
    .line 6
    move-result v0

    .line 7
    if-eqz v0, :cond_0

    .line 8
    .line 9
    goto/16 :goto_7

    .line 10
    .line 11
    :cond_0
    iget-object v2, v1, Loc/k$a;->a:Lkh/b;

    .line 12
    .line 13
    iget-object v3, v1, Loc/k$a;->g:Llc/i;

    .line 14
    .line 15
    iget v0, v1, Loc/k$a;->m:I

    .line 16
    .line 17
    const/4 v4, 0x0

    .line 18
    const/4 v5, 0x1

    .line 19
    if-eq v0, v5, :cond_1

    .line 20
    .line 21
    move v0, v5

    .line 22
    goto :goto_0

    .line 23
    :cond_1
    move v0, v4

    .line 24
    :goto_0
    iget-object v6, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 25
    .line 26
    move v7, v5

    .line 27
    :goto_1
    const/4 v8, 0x0

    .line 28
    if-nez v6, :cond_5

    .line 29
    .line 30
    iget-boolean v9, v1, Loc/k$a;->h:Z

    .line 31
    .line 32
    :try_start_0
    invoke-interface {v3}, Llc/i;->poll()Ljava/lang/Object;

    .line 33
    .line 34
    .line 35
    move-result-object v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 36
    if-nez v10, :cond_2

    .line 37
    .line 38
    move v11, v5

    .line 39
    goto :goto_2

    .line 40
    :cond_2
    move v11, v4

    .line 41
    :goto_2
    invoke-virtual {v1, v9, v11, v2, v3}, Loc/k$a;->c(ZZLkh/b;Llc/i;)Z

    .line 42
    .line 43
    .line 44
    move-result v9

    .line 45
    if-eqz v9, :cond_3

    .line 46
    .line 47
    goto/16 :goto_7

    .line 48
    .line 49
    :cond_3
    if-eqz v10, :cond_5

    .line 50
    .line 51
    :try_start_1
    iget-object v6, v1, Loc/k$a;->b:Lic/e;

    .line 52
    .line 53
    invoke-interface {v6, v10}, Lic/e;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    .line 55
    .line 56
    move-result-object v6

    .line 57
    check-cast v6, Ljava/lang/Iterable;

    .line 58
    .line 59
    invoke-interface {v6}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 60
    .line 61
    .line 62
    move-result-object v6

    .line 63
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 64
    .line 65
    .line 66
    move-result v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 67
    if-nez v9, :cond_4

    .line 68
    .line 69
    invoke-virtual {v1, v0}, Loc/k$a;->e(Z)V

    .line 70
    .line 71
    .line 72
    move-object v6, v8

    .line 73
    goto :goto_1

    .line 74
    :cond_4
    iput-object v6, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 75
    .line 76
    goto :goto_3

    .line 77
    :catchall_0
    move-exception v0

    .line 78
    invoke-static {v0}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 79
    .line 80
    .line 81
    iget-object v3, v1, Loc/k$a;->f:Lkh/c;

    .line 82
    .line 83
    invoke-interface {v3}, Lkh/c;->cancel()V

    .line 84
    .line 85
    .line 86
    iget-object v3, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 87
    .line 88
    invoke-static {v3, v0}, Lxc/g;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    .line 89
    .line 90
    .line 91
    iget-object v0, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 92
    .line 93
    invoke-static {v0}, Lxc/g;->b(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    .line 94
    .line 95
    .line 96
    move-result-object v0

    .line 97
    invoke-interface {v2, v0}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 98
    .line 99
    .line 100
    return-void

    .line 101
    :catchall_1
    move-exception v0

    .line 102
    invoke-static {v0}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 103
    .line 104
    .line 105
    iget-object v4, v1, Loc/k$a;->f:Lkh/c;

    .line 106
    .line 107
    invoke-interface {v4}, Lkh/c;->cancel()V

    .line 108
    .line 109
    .line 110
    iget-object v4, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 111
    .line 112
    invoke-static {v4, v0}, Lxc/g;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    .line 113
    .line 114
    .line 115
    iget-object v0, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 116
    .line 117
    invoke-static {v0}, Lxc/g;->b(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    .line 118
    .line 119
    .line 120
    move-result-object v0

    .line 121
    iput-object v8, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 122
    .line 123
    invoke-interface {v3}, Llc/i;->clear()V

    .line 124
    .line 125
    .line 126
    invoke-interface {v2, v0}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 127
    .line 128
    .line 129
    return-void

    .line 130
    :cond_5
    :goto_3
    if-eqz v6, :cond_e

    .line 131
    .line 132
    iget-object v9, v1, Loc/k$a;->e:Ljava/util/concurrent/atomic/AtomicLong;

    .line 133
    .line 134
    invoke-virtual {v9}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    .line 135
    .line 136
    .line 137
    move-result-wide v9

    .line 138
    const-wide/16 v11, 0x0

    .line 139
    .line 140
    move-wide v13, v11

    .line 141
    :goto_4
    cmp-long v15, v13, v9

    .line 142
    .line 143
    if-eqz v15, :cond_9

    .line 144
    .line 145
    iget-boolean v15, v1, Loc/k$a;->h:Z

    .line 146
    .line 147
    invoke-virtual {v1, v15, v4, v2, v3}, Loc/k$a;->c(ZZLkh/b;Llc/i;)Z

    .line 148
    .line 149
    .line 150
    move-result v15

    .line 151
    if-eqz v15, :cond_6

    .line 152
    .line 153
    goto/16 :goto_7

    .line 154
    .line 155
    :cond_6
    :try_start_2
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 156
    .line 157
    .line 158
    move-result-object v15

    .line 159
    const-string v5, "The iterator returned a null value"

    .line 160
    .line 161
    invoke-static {v15, v5}, Lkc/b;->d(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 162
    .line 163
    .line 164
    move-result-object v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    .line 165
    invoke-interface {v2, v5}, Lkh/b;->onNext(Ljava/lang/Object;)V

    .line 166
    .line 167
    .line 168
    iget-boolean v5, v1, Loc/k$a;->h:Z

    .line 169
    .line 170
    invoke-virtual {v1, v5, v4, v2, v3}, Loc/k$a;->c(ZZLkh/b;Llc/i;)Z

    .line 171
    .line 172
    .line 173
    move-result v5

    .line 174
    if-eqz v5, :cond_7

    .line 175
    .line 176
    goto/16 :goto_7

    .line 177
    .line 178
    :cond_7
    const-wide/16 v16, 0x1

    .line 179
    .line 180
    add-long v13, v13, v16

    .line 181
    .line 182
    :try_start_3
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    .line 183
    .line 184
    .line 185
    move-result v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 186
    if-nez v5, :cond_8

    .line 187
    .line 188
    invoke-virtual {v1, v0}, Loc/k$a;->e(Z)V

    .line 189
    .line 190
    .line 191
    iput-object v8, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 192
    .line 193
    move-object v6, v8

    .line 194
    goto :goto_5

    .line 195
    :cond_8
    const/4 v5, 0x1

    .line 196
    goto :goto_4

    .line 197
    :catchall_2
    move-exception v0

    .line 198
    invoke-static {v0}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 199
    .line 200
    .line 201
    iput-object v8, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 202
    .line 203
    iget-object v3, v1, Loc/k$a;->f:Lkh/c;

    .line 204
    .line 205
    invoke-interface {v3}, Lkh/c;->cancel()V

    .line 206
    .line 207
    .line 208
    iget-object v3, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 209
    .line 210
    invoke-static {v3, v0}, Lxc/g;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    .line 211
    .line 212
    .line 213
    iget-object v0, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 214
    .line 215
    invoke-static {v0}, Lxc/g;->b(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    .line 216
    .line 217
    .line 218
    move-result-object v0

    .line 219
    invoke-interface {v2, v0}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 220
    .line 221
    .line 222
    return-void

    .line 223
    :catchall_3
    move-exception v0

    .line 224
    invoke-static {v0}, Lgc/b;->b(Ljava/lang/Throwable;)V

    .line 225
    .line 226
    .line 227
    iput-object v8, v1, Loc/k$a;->k:Ljava/util/Iterator;

    .line 228
    .line 229
    iget-object v3, v1, Loc/k$a;->f:Lkh/c;

    .line 230
    .line 231
    invoke-interface {v3}, Lkh/c;->cancel()V

    .line 232
    .line 233
    .line 234
    iget-object v3, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 235
    .line 236
    invoke-static {v3, v0}, Lxc/g;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    .line 237
    .line 238
    .line 239
    iget-object v0, v1, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 240
    .line 241
    invoke-static {v0}, Lxc/g;->b(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Throwable;

    .line 242
    .line 243
    .line 244
    move-result-object v0

    .line 245
    invoke-interface {v2, v0}, Lkh/b;->onError(Ljava/lang/Throwable;)V

    .line 246
    .line 247
    .line 248
    return-void

    .line 249
    :cond_9
    :goto_5
    cmp-long v5, v13, v9

    .line 250
    .line 251
    if-nez v5, :cond_b

    .line 252
    .line 253
    iget-boolean v5, v1, Loc/k$a;->h:Z

    .line 254
    .line 255
    invoke-interface {v3}, Llc/i;->isEmpty()Z

    .line 256
    .line 257
    .line 258
    move-result v8

    .line 259
    if-eqz v8, :cond_a

    .line 260
    .line 261
    if-nez v6, :cond_a

    .line 262
    .line 263
    const/4 v8, 0x1

    .line 264
    goto :goto_6

    .line 265
    :cond_a
    move v8, v4

    .line 266
    :goto_6
    invoke-virtual {v1, v5, v8, v2, v3}, Loc/k$a;->c(ZZLkh/b;Llc/i;)Z

    .line 267
    .line 268
    .line 269
    move-result v5

    .line 270
    if-eqz v5, :cond_b

    .line 271
    .line 272
    goto :goto_7

    .line 273
    :cond_b
    cmp-long v5, v13, v11

    .line 274
    .line 275
    if-eqz v5, :cond_c

    .line 276
    .line 277
    const-wide v11, 0x7fffffffffffffffL

    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    cmp-long v5, v9, v11

    .line 283
    .line 284
    if-eqz v5, :cond_c

    .line 285
    .line 286
    iget-object v5, v1, Loc/k$a;->e:Ljava/util/concurrent/atomic/AtomicLong;

    .line 287
    .line 288
    neg-long v8, v13

    .line 289
    invoke-virtual {v5, v8, v9}, Ljava/util/concurrent/atomic/AtomicLong;->addAndGet(J)J

    .line 290
    .line 291
    .line 292
    :cond_c
    if-nez v6, :cond_e

    .line 293
    .line 294
    :cond_d
    const/4 v5, 0x1

    .line 295
    goto/16 :goto_1

    .line 296
    .line 297
    :cond_e
    neg-int v5, v7

    .line 298
    invoke-virtual {v1, v5}, Ljava/util/concurrent/atomic/AtomicInteger;->addAndGet(I)I

    .line 299
    .line 300
    .line 301
    move-result v7

    .line 302
    if-nez v7, :cond_d

    .line 303
    .line 304
    :goto_7
    return-void
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

.method public h(I)I
    .locals 1

    .line 1
    const/4 v0, 0x1

    .line 2
    and-int/2addr p1, v0

    .line 3
    if-eqz p1, :cond_0

    .line 4
    .line 5
    iget p1, p0, Loc/k$a;->m:I

    .line 6
    .line 7
    if-ne p1, v0, :cond_0

    .line 8
    .line 9
    return v0

    .line 10
    :cond_0
    const/4 p1, 0x0

    .line 11
    return p1
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

.method public isEmpty()Z
    .locals 1

    .line 1
    iget-object v0, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 6
    .line 7
    invoke-interface {v0}, Llc/i;->isEmpty()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    const/4 v0, 0x1

    .line 14
    return v0

    .line 15
    :cond_0
    const/4 v0, 0x0

    .line 16
    return v0
    .line 17
    .line 18
    .line 19
.end method

.method public onComplete()V
    .locals 1

    .line 1
    iget-boolean v0, p0, Loc/k$a;->h:Z

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
    iput-boolean v0, p0, Loc/k$a;->h:Z

    .line 8
    .line 9
    invoke-virtual {p0}, Loc/k$a;->f()V

    .line 10
    .line 11
    .line 12
    return-void
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public onError(Ljava/lang/Throwable;)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Loc/k$a;->h:Z

    .line 2
    .line 3
    if-nez v0, :cond_0

    .line 4
    .line 5
    iget-object v0, p0, Loc/k$a;->j:Ljava/util/concurrent/atomic/AtomicReference;

    .line 6
    .line 7
    invoke-static {v0, p1}, Lxc/g;->a(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Throwable;)Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    const/4 p1, 0x1

    .line 14
    iput-boolean p1, p0, Loc/k$a;->h:Z

    .line 15
    .line 16
    invoke-virtual {p0}, Loc/k$a;->f()V

    .line 17
    .line 18
    .line 19
    return-void

    .line 20
    :cond_0
    invoke-static {p1}, Lyc/a;->q(Ljava/lang/Throwable;)V

    .line 21
    .line 22
    .line 23
    return-void
    .line 24
    .line 25
    .line 26
.end method

.method public onNext(Ljava/lang/Object;)V
    .locals 1

    .line 1
    iget-boolean v0, p0, Loc/k$a;->h:Z

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-void

    .line 6
    :cond_0
    iget v0, p0, Loc/k$a;->m:I

    .line 7
    .line 8
    if-nez v0, :cond_1

    .line 9
    .line 10
    iget-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 11
    .line 12
    invoke-interface {v0, p1}, Llc/i;->offer(Ljava/lang/Object;)Z

    .line 13
    .line 14
    .line 15
    move-result p1

    .line 16
    if-nez p1, :cond_1

    .line 17
    .line 18
    new-instance p1, Lgc/c;

    .line 19
    .line 20
    const-string v0, "Queue is full?!"

    .line 21
    .line 22
    invoke-direct {p1, v0}, Lgc/c;-><init>(Ljava/lang/String;)V

    .line 23
    .line 24
    .line 25
    invoke-virtual {p0, p1}, Loc/k$a;->onError(Ljava/lang/Throwable;)V

    .line 26
    .line 27
    .line 28
    return-void

    .line 29
    :cond_1
    invoke-virtual {p0}, Loc/k$a;->f()V

    .line 30
    .line 31
    .line 32
    return-void
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
.end method

.method public poll()Ljava/lang/Object;
    .locals 4

    .line 1
    iget-object v0, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 2
    .line 3
    :goto_0
    const/4 v1, 0x0

    .line 4
    if-nez v0, :cond_2

    .line 5
    .line 6
    iget-object v0, p0, Loc/k$a;->g:Llc/i;

    .line 7
    .line 8
    invoke-interface {v0}, Llc/i;->poll()Ljava/lang/Object;

    .line 9
    .line 10
    .line 11
    move-result-object v0

    .line 12
    if-nez v0, :cond_0

    .line 13
    .line 14
    return-object v1

    .line 15
    :cond_0
    iget-object v2, p0, Loc/k$a;->b:Lic/e;

    .line 16
    .line 17
    invoke-interface {v2, v0}, Lic/e;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object v0

    .line 21
    check-cast v0, Ljava/lang/Iterable;

    .line 22
    .line 23
    invoke-interface {v0}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    .line 24
    .line 25
    .line 26
    move-result-object v0

    .line 27
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 28
    .line 29
    .line 30
    move-result v2

    .line 31
    if-nez v2, :cond_1

    .line 32
    .line 33
    move-object v0, v1

    .line 34
    goto :goto_0

    .line 35
    :cond_1
    iput-object v0, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 36
    .line 37
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 38
    .line 39
    .line 40
    move-result-object v2

    .line 41
    const-string v3, "The iterator returned a null value"

    .line 42
    .line 43
    invoke-static {v2, v3}, Lkc/b;->d(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    .line 44
    .line 45
    .line 46
    move-result-object v2

    .line 47
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 48
    .line 49
    .line 50
    move-result v0

    .line 51
    if-nez v0, :cond_3

    .line 52
    .line 53
    iput-object v1, p0, Loc/k$a;->k:Ljava/util/Iterator;

    .line 54
    .line 55
    :cond_3
    return-object v2
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

.method public request(J)V
    .locals 1

    .line 1
    invoke-static {p1, p2}, Lwc/g;->l(J)Z

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    if-eqz v0, :cond_0

    .line 6
    .line 7
    iget-object v0, p0, Loc/k$a;->e:Ljava/util/concurrent/atomic/AtomicLong;

    .line 8
    .line 9
    invoke-static {v0, p1, p2}, Lxc/d;->a(Ljava/util/concurrent/atomic/AtomicLong;J)J

    .line 10
    .line 11
    .line 12
    invoke-virtual {p0}, Loc/k$a;->f()V

    .line 13
    .line 14
    .line 15
    :cond_0
    return-void
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
