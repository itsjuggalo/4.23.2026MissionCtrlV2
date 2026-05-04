.class public final Lqg/k$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lqg/d;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lqg/k;->d(Lqg/d;Lpd/p;)Lqg/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = null
.end annotation


# instance fields
.field public final synthetic a:Lqg/d;

.field public final synthetic b:Lpd/p;


# direct methods
.method public constructor <init>(Lqg/d;Lpd/p;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lqg/k$b;->a:Lqg/d;

    .line 2
    .line 3
    iput-object p2, p0, Lqg/k$b;->b:Lpd/p;

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
.method public collect(Lqg/e;Lgd/e;)Ljava/lang/Object;
    .locals 8

    .line 1
    instance-of v0, p2, Lqg/k$b$a;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    move-object v0, p2

    .line 6
    check-cast v0, Lqg/k$b$a;

    .line 7
    .line 8
    iget v1, v0, Lqg/k$b$a;->b:I

    .line 9
    .line 10
    const/high16 v2, -0x80000000

    .line 11
    .line 12
    and-int v3, v1, v2

    .line 13
    .line 14
    if-eqz v3, :cond_0

    .line 15
    .line 16
    sub-int/2addr v1, v2

    .line 17
    iput v1, v0, Lqg/k$b$a;->b:I

    .line 18
    .line 19
    goto :goto_0

    .line 20
    :cond_0
    new-instance v0, Lqg/k$b$a;

    .line 21
    .line 22
    invoke-direct {v0, p0, p2}, Lqg/k$b$a;-><init>(Lqg/k$b;Lgd/e;)V

    .line 23
    .line 24
    .line 25
    :goto_0
    iget-object p2, v0, Lqg/k$b$a;->a:Ljava/lang/Object;

    .line 26
    .line 27
    invoke-static {}, Lhd/c;->f()Ljava/lang/Object;

    .line 28
    .line 29
    .line 30
    move-result-object v1

    .line 31
    iget v2, v0, Lqg/k$b$a;->b:I

    .line 32
    .line 33
    const/4 v3, 0x3

    .line 34
    const/4 v4, 0x2

    .line 35
    const/4 v5, 0x1

    .line 36
    const/4 v6, 0x0

    .line 37
    if-eqz v2, :cond_4

    .line 38
    .line 39
    if-eq v2, v5, :cond_3

    .line 40
    .line 41
    if-eq v2, v4, :cond_2

    .line 42
    .line 43
    if-ne v2, v3, :cond_1

    .line 44
    .line 45
    iget-object p1, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 46
    .line 47
    check-cast p1, Lrg/o;

    .line 48
    .line 49
    :try_start_0
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 50
    .line 51
    .line 52
    goto :goto_2

    .line 53
    :catchall_0
    move-exception p2

    .line 54
    goto :goto_3

    .line 55
    :cond_1
    new-instance p1, Ljava/lang/IllegalStateException;

    .line 56
    .line 57
    const-string p2, "call to \'resume\' before \'invoke\' with coroutine"

    .line 58
    .line 59
    invoke-direct {p1, p2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 60
    .line 61
    .line 62
    throw p1

    .line 63
    :cond_2
    iget-object p1, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 64
    .line 65
    check-cast p1, Ljava/lang/Throwable;

    .line 66
    .line 67
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 68
    .line 69
    .line 70
    goto/16 :goto_6

    .line 71
    .line 72
    :cond_3
    iget-object p1, v0, Lqg/k$b$a;->e:Ljava/lang/Object;

    .line 73
    .line 74
    check-cast p1, Lqg/e;

    .line 75
    .line 76
    iget-object v2, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 77
    .line 78
    check-cast v2, Lqg/k$b;

    .line 79
    .line 80
    :try_start_1
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 81
    .line 82
    .line 83
    goto :goto_1

    .line 84
    :catchall_1
    move-exception p1

    .line 85
    goto :goto_4

    .line 86
    :cond_4
    invoke-static {p2}, Lcd/s;->b(Ljava/lang/Object;)V

    .line 87
    .line 88
    .line 89
    :try_start_2
    iget-object p2, p0, Lqg/k$b;->a:Lqg/d;

    .line 90
    .line 91
    iput-object p0, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 92
    .line 93
    iput-object p1, v0, Lqg/k$b$a;->e:Ljava/lang/Object;

    .line 94
    .line 95
    iput v5, v0, Lqg/k$b$a;->b:I

    .line 96
    .line 97
    invoke-interface {p2, p1, v0}, Lqg/d;->collect(Lqg/e;Lgd/e;)Ljava/lang/Object;

    .line 98
    .line 99
    .line 100
    move-result-object p2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    .line 101
    if-ne p2, v1, :cond_5

    .line 102
    .line 103
    goto :goto_5

    .line 104
    :cond_5
    move-object v2, p0

    .line 105
    :goto_1
    new-instance p2, Lrg/o;

    .line 106
    .line 107
    invoke-interface {v0}, Lgd/e;->getContext()Lgd/i;

    .line 108
    .line 109
    .line 110
    move-result-object v4

    .line 111
    invoke-direct {p2, p1, v4}, Lrg/o;-><init>(Lqg/e;Lgd/i;)V

    .line 112
    .line 113
    .line 114
    :try_start_3
    iget-object p1, v2, Lqg/k$b;->b:Lpd/p;

    .line 115
    .line 116
    iput-object p2, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 117
    .line 118
    iput-object v6, v0, Lqg/k$b$a;->e:Ljava/lang/Object;

    .line 119
    .line 120
    iput v3, v0, Lqg/k$b$a;->b:I

    .line 121
    .line 122
    const/4 v2, 0x6

    .line 123
    invoke-static {v2}, Lkotlin/jvm/internal/r;->a(I)V

    .line 124
    .line 125
    .line 126
    invoke-interface {p1, p2, v6, v0}, Lpd/p;->invoke(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    .line 128
    .line 129
    move-result-object p1

    .line 130
    const/4 v0, 0x7

    .line 131
    invoke-static {v0}, Lkotlin/jvm/internal/r;->a(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 132
    .line 133
    .line 134
    if-ne p1, v1, :cond_6

    .line 135
    .line 136
    goto :goto_5

    .line 137
    :cond_6
    move-object p1, p2

    .line 138
    :goto_2
    invoke-virtual {p1}, Lrg/o;->releaseIntercepted()V

    .line 139
    .line 140
    .line 141
    sget-object p1, Lcd/h0;->a:Lcd/h0;

    .line 142
    .line 143
    return-object p1

    .line 144
    :catchall_2
    move-exception p1

    .line 145
    move-object v7, p2

    .line 146
    move-object p2, p1

    .line 147
    move-object p1, v7

    .line 148
    :goto_3
    invoke-virtual {p1}, Lrg/o;->releaseIntercepted()V

    .line 149
    .line 150
    .line 151
    throw p2

    .line 152
    :catchall_3
    move-exception p1

    .line 153
    move-object v2, p0

    .line 154
    :goto_4
    new-instance p2, Lqg/w;

    .line 155
    .line 156
    invoke-direct {p2, p1}, Lqg/w;-><init>(Ljava/lang/Throwable;)V

    .line 157
    .line 158
    .line 159
    iget-object v2, v2, Lqg/k$b;->b:Lpd/p;

    .line 160
    .line 161
    iput-object p1, v0, Lqg/k$b$a;->d:Ljava/lang/Object;

    .line 162
    .line 163
    iput-object v6, v0, Lqg/k$b$a;->e:Ljava/lang/Object;

    .line 164
    .line 165
    iput v4, v0, Lqg/k$b$a;->b:I

    .line 166
    .line 167
    invoke-static {p2, v2, p1, v0}, Lqg/k;->a(Lqg/e;Lpd/p;Ljava/lang/Throwable;Lgd/e;)Ljava/lang/Object;

    .line 168
    .line 169
    .line 170
    move-result-object p2

    .line 171
    if-ne p2, v1, :cond_7

    .line 172
    .line 173
    :goto_5
    return-object v1

    .line 174
    :cond_7
    :goto_6
    throw p1
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
.end method
