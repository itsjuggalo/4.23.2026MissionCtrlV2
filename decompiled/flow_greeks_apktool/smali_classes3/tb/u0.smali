.class public abstract Ltb/u0;
.super Ltb/a$c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final w:Lrb/m0$a;

.field public static final x:Lrb/y0$g;


# instance fields
.field public s:Lrb/k1;

.field public t:Lrb/y0;

.field public u:Ljava/nio/charset/Charset;

.field public v:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Ltb/u0$a;

    .line 2
    .line 3
    invoke-direct {v0}, Ltb/u0$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Ltb/u0;->w:Lrb/m0$a;

    .line 7
    .line 8
    const-string v1, ":status"

    .line 9
    .line 10
    invoke-static {v1, v0}, Lrb/m0;->b(Ljava/lang/String;Lrb/m0$a;)Lrb/y0$g;

    .line 11
    .line 12
    .line 13
    move-result-object v0

    .line 14
    sput-object v0, Ltb/u0;->x:Lrb/y0$g;

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method

.method public constructor <init>(ILtb/n2;Ltb/t2;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2, p3}, Ltb/a$c;-><init>(ILtb/n2;Ltb/t2;)V

    .line 2
    .line 3
    .line 4
    sget-object p1, Lp6/d;->c:Ljava/nio/charset/Charset;

    .line 5
    .line 6
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

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

.method public static O(Lrb/y0;)Ljava/nio/charset/Charset;
    .locals 2

    .line 1
    sget-object v0, Ltb/r0;->j:Lrb/y0$g;

    .line 2
    .line 3
    invoke-virtual {p0, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object p0

    .line 7
    check-cast p0, Ljava/lang/String;

    .line 8
    .line 9
    if-eqz p0, :cond_0

    .line 10
    .line 11
    const-string v0, "charset="

    .line 12
    .line 13
    const/4 v1, 0x2

    .line 14
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    .line 15
    .line 16
    .line 17
    move-result-object p0

    .line 18
    :try_start_0
    array-length v0, p0

    .line 19
    add-int/lit8 v0, v0, -0x1

    .line 20
    .line 21
    aget-object p0, p0, v0

    .line 22
    .line 23
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object p0

    .line 27
    invoke-static {p0}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    .line 28
    .line 29
    .line 30
    move-result-object p0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    return-object p0

    .line 32
    :catch_0
    :cond_0
    sget-object p0, Lp6/d;->c:Ljava/nio/charset/Charset;

    .line 33
    .line 34
    return-object p0
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

.method public static R(Lrb/y0;)V
    .locals 1

    .line 1
    sget-object v0, Ltb/u0;->x:Lrb/y0$g;

    .line 2
    .line 3
    invoke-virtual {p0, v0}, Lrb/y0;->e(Lrb/y0$g;)V

    .line 4
    .line 5
    .line 6
    sget-object v0, Lrb/o0;->b:Lrb/y0$g;

    .line 7
    .line 8
    invoke-virtual {p0, v0}, Lrb/y0;->e(Lrb/y0$g;)V

    .line 9
    .line 10
    .line 11
    sget-object v0, Lrb/o0;->a:Lrb/y0$g;

    .line 12
    .line 13
    invoke-virtual {p0, v0}, Lrb/y0;->e(Lrb/y0$g;)V

    .line 14
    .line 15
    .line 16
    return-void
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
.method public abstract P(Lrb/k1;ZLrb/y0;)V
.end method

.method public final Q(Lrb/y0;)Lrb/k1;
    .locals 2

    .line 1
    sget-object v0, Lrb/o0;->b:Lrb/y0$g;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Lrb/k1;

    .line 8
    .line 9
    if-eqz v0, :cond_0

    .line 10
    .line 11
    sget-object v1, Lrb/o0;->a:Lrb/y0$g;

    .line 12
    .line 13
    invoke-virtual {p1, v1}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 14
    .line 15
    .line 16
    move-result-object p1

    .line 17
    check-cast p1, Ljava/lang/String;

    .line 18
    .line 19
    invoke-virtual {v0, p1}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 20
    .line 21
    .line 22
    move-result-object p1

    .line 23
    return-object p1

    .line 24
    :cond_0
    iget-boolean v0, p0, Ltb/u0;->v:Z

    .line 25
    .line 26
    if-eqz v0, :cond_1

    .line 27
    .line 28
    sget-object p1, Lrb/k1;->g:Lrb/k1;

    .line 29
    .line 30
    const-string v0, "missing GRPC status in response"

    .line 31
    .line 32
    invoke-virtual {p1, v0}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 33
    .line 34
    .line 35
    move-result-object p1

    .line 36
    return-object p1

    .line 37
    :cond_1
    sget-object v0, Ltb/u0;->x:Lrb/y0$g;

    .line 38
    .line 39
    invoke-virtual {p1, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 40
    .line 41
    .line 42
    move-result-object p1

    .line 43
    check-cast p1, Ljava/lang/Integer;

    .line 44
    .line 45
    if-eqz p1, :cond_2

    .line 46
    .line 47
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    .line 48
    .line 49
    .line 50
    move-result p1

    .line 51
    invoke-static {p1}, Ltb/r0;->m(I)Lrb/k1;

    .line 52
    .line 53
    .line 54
    move-result-object p1

    .line 55
    goto :goto_0

    .line 56
    :cond_2
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 57
    .line 58
    const-string v0, "missing HTTP status code"

    .line 59
    .line 60
    invoke-virtual {p1, v0}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 61
    .line 62
    .line 63
    move-result-object p1

    .line 64
    :goto_0
    const-string v0, "missing GRPC status, inferred error from HTTP status code"

    .line 65
    .line 66
    invoke-virtual {p1, v0}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 67
    .line 68
    .line 69
    move-result-object p1

    .line 70
    return-object p1
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

.method public S(Ltb/x1;Z)V
    .locals 4

    .line 1
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    if-eqz v0, :cond_1

    .line 5
    .line 6
    new-instance v2, Ljava/lang/StringBuilder;

    .line 7
    .line 8
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 9
    .line 10
    .line 11
    const-string v3, "DATA-----------------------------\n"

    .line 12
    .line 13
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 14
    .line 15
    .line 16
    iget-object v3, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 17
    .line 18
    invoke-static {p1, v3}, Ltb/y1;->e(Ltb/x1;Ljava/nio/charset/Charset;)Ljava/lang/String;

    .line 19
    .line 20
    .line 21
    move-result-object v3

    .line 22
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 23
    .line 24
    .line 25
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 26
    .line 27
    .line 28
    move-result-object v2

    .line 29
    invoke-virtual {v0, v2}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 30
    .line 31
    .line 32
    move-result-object v0

    .line 33
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 34
    .line 35
    invoke-interface {p1}, Ltb/x1;->close()V

    .line 36
    .line 37
    .line 38
    iget-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 39
    .line 40
    invoke-virtual {p1}, Lrb/k1;->o()Ljava/lang/String;

    .line 41
    .line 42
    .line 43
    move-result-object p1

    .line 44
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    .line 45
    .line 46
    .line 47
    move-result p1

    .line 48
    const/16 v0, 0x3e8

    .line 49
    .line 50
    if-gt p1, v0, :cond_0

    .line 51
    .line 52
    if-eqz p2, :cond_4

    .line 53
    .line 54
    :cond_0
    iget-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 55
    .line 56
    iget-object p2, p0, Ltb/u0;->t:Lrb/y0;

    .line 57
    .line 58
    invoke-virtual {p0, p1, v1, p2}, Ltb/u0;->P(Lrb/k1;ZLrb/y0;)V

    .line 59
    .line 60
    .line 61
    return-void

    .line 62
    :cond_1
    iget-boolean v0, p0, Ltb/u0;->v:Z

    .line 63
    .line 64
    if-nez v0, :cond_2

    .line 65
    .line 66
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 67
    .line 68
    const-string p2, "headers not received before payload"

    .line 69
    .line 70
    invoke-virtual {p1, p2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 71
    .line 72
    .line 73
    move-result-object p1

    .line 74
    new-instance p2, Lrb/y0;

    .line 75
    .line 76
    invoke-direct {p2}, Lrb/y0;-><init>()V

    .line 77
    .line 78
    .line 79
    invoke-virtual {p0, p1, v1, p2}, Ltb/u0;->P(Lrb/k1;ZLrb/y0;)V

    .line 80
    .line 81
    .line 82
    return-void

    .line 83
    :cond_2
    invoke-interface {p1}, Ltb/x1;->d()I

    .line 84
    .line 85
    .line 86
    move-result v0

    .line 87
    invoke-virtual {p0, p1}, Ltb/a$c;->D(Ltb/x1;)V

    .line 88
    .line 89
    .line 90
    if-eqz p2, :cond_4

    .line 91
    .line 92
    if-lez v0, :cond_3

    .line 93
    .line 94
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 95
    .line 96
    const-string p2, "Received unexpected EOS on non-empty DATA frame from server"

    .line 97
    .line 98
    invoke-virtual {p1, p2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 99
    .line 100
    .line 101
    move-result-object p1

    .line 102
    iput-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 103
    .line 104
    goto :goto_0

    .line 105
    :cond_3
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 106
    .line 107
    const-string p2, "Received unexpected EOS on empty DATA frame from server"

    .line 108
    .line 109
    invoke-virtual {p1, p2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 110
    .line 111
    .line 112
    move-result-object p1

    .line 113
    iput-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 114
    .line 115
    :goto_0
    new-instance p1, Lrb/y0;

    .line 116
    .line 117
    invoke-direct {p1}, Lrb/y0;-><init>()V

    .line 118
    .line 119
    .line 120
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 121
    .line 122
    iget-object p2, p0, Ltb/u0;->s:Lrb/k1;

    .line 123
    .line 124
    invoke-virtual {p0, p2, v1, p1}, Ltb/a$c;->N(Lrb/k1;ZLrb/y0;)V

    .line 125
    .line 126
    .line 127
    :cond_4
    return-void
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
.end method

.method public T(Lrb/y0;)V
    .locals 4

    .line 1
    const-string v0, "headers"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 7
    .line 8
    const-string v1, "headers: "

    .line 9
    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    new-instance v2, Ljava/lang/StringBuilder;

    .line 13
    .line 14
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 15
    .line 16
    .line 17
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 18
    .line 19
    .line 20
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 21
    .line 22
    .line 23
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 24
    .line 25
    .line 26
    move-result-object p1

    .line 27
    invoke-virtual {v0, p1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 28
    .line 29
    .line 30
    move-result-object p1

    .line 31
    iput-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 32
    .line 33
    return-void

    .line 34
    :cond_0
    :try_start_0
    iget-boolean v0, p0, Ltb/u0;->v:Z

    .line 35
    .line 36
    if-eqz v0, :cond_1

    .line 37
    .line 38
    sget-object v0, Lrb/k1;->s:Lrb/k1;

    .line 39
    .line 40
    const-string v2, "Received headers twice"

    .line 41
    .line 42
    invoke-virtual {v0, v2}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 43
    .line 44
    .line 45
    move-result-object v0

    .line 46
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    .line 48
    if-eqz v0, :cond_4

    .line 49
    .line 50
    new-instance v2, Ljava/lang/StringBuilder;

    .line 51
    .line 52
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 53
    .line 54
    .line 55
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 56
    .line 57
    .line 58
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 59
    .line 60
    .line 61
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 62
    .line 63
    .line 64
    move-result-object v1

    .line 65
    invoke-virtual {v0, v1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 66
    .line 67
    .line 68
    move-result-object v0

    .line 69
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 70
    .line 71
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 72
    .line 73
    invoke-static {p1}, Ltb/u0;->O(Lrb/y0;)Ljava/nio/charset/Charset;

    .line 74
    .line 75
    .line 76
    move-result-object p1

    .line 77
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 78
    .line 79
    return-void

    .line 80
    :catchall_0
    move-exception v0

    .line 81
    goto/16 :goto_0

    .line 82
    .line 83
    :cond_1
    :try_start_1
    sget-object v0, Ltb/u0;->x:Lrb/y0$g;

    .line 84
    .line 85
    invoke-virtual {p1, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 86
    .line 87
    .line 88
    move-result-object v0

    .line 89
    check-cast v0, Ljava/lang/Integer;

    .line 90
    .line 91
    if-eqz v0, :cond_2

    .line 92
    .line 93
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 94
    .line 95
    .line 96
    move-result v2

    .line 97
    const/16 v3, 0x64

    .line 98
    .line 99
    if-lt v2, v3, :cond_2

    .line 100
    .line 101
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 102
    .line 103
    .line 104
    move-result v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 105
    const/16 v2, 0xc8

    .line 106
    .line 107
    if-ge v0, v2, :cond_2

    .line 108
    .line 109
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 110
    .line 111
    if-eqz v0, :cond_4

    .line 112
    .line 113
    new-instance v2, Ljava/lang/StringBuilder;

    .line 114
    .line 115
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 116
    .line 117
    .line 118
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 119
    .line 120
    .line 121
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 122
    .line 123
    .line 124
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 125
    .line 126
    .line 127
    move-result-object v1

    .line 128
    invoke-virtual {v0, v1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 129
    .line 130
    .line 131
    move-result-object v0

    .line 132
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 133
    .line 134
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 135
    .line 136
    invoke-static {p1}, Ltb/u0;->O(Lrb/y0;)Ljava/nio/charset/Charset;

    .line 137
    .line 138
    .line 139
    move-result-object p1

    .line 140
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 141
    .line 142
    return-void

    .line 143
    :cond_2
    const/4 v0, 0x1

    .line 144
    :try_start_2
    iput-boolean v0, p0, Ltb/u0;->v:Z

    .line 145
    .line 146
    invoke-virtual {p0, p1}, Ltb/u0;->V(Lrb/y0;)Lrb/k1;

    .line 147
    .line 148
    .line 149
    move-result-object v0

    .line 150
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 151
    .line 152
    if-eqz v0, :cond_3

    .line 153
    .line 154
    if-eqz v0, :cond_4

    .line 155
    .line 156
    new-instance v2, Ljava/lang/StringBuilder;

    .line 157
    .line 158
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 159
    .line 160
    .line 161
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 162
    .line 163
    .line 164
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 165
    .line 166
    .line 167
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 168
    .line 169
    .line 170
    move-result-object v1

    .line 171
    invoke-virtual {v0, v1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 172
    .line 173
    .line 174
    move-result-object v0

    .line 175
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 176
    .line 177
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 178
    .line 179
    invoke-static {p1}, Ltb/u0;->O(Lrb/y0;)Ljava/nio/charset/Charset;

    .line 180
    .line 181
    .line 182
    move-result-object p1

    .line 183
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 184
    .line 185
    return-void

    .line 186
    :cond_3
    :try_start_3
    invoke-static {p1}, Ltb/u0;->R(Lrb/y0;)V

    .line 187
    .line 188
    .line 189
    invoke-virtual {p0, p1}, Ltb/a$c;->E(Lrb/y0;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 190
    .line 191
    .line 192
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 193
    .line 194
    if-eqz v0, :cond_4

    .line 195
    .line 196
    new-instance v2, Ljava/lang/StringBuilder;

    .line 197
    .line 198
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 199
    .line 200
    .line 201
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 202
    .line 203
    .line 204
    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 205
    .line 206
    .line 207
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 208
    .line 209
    .line 210
    move-result-object v1

    .line 211
    invoke-virtual {v0, v1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 212
    .line 213
    .line 214
    move-result-object v0

    .line 215
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 216
    .line 217
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 218
    .line 219
    invoke-static {p1}, Ltb/u0;->O(Lrb/y0;)Ljava/nio/charset/Charset;

    .line 220
    .line 221
    .line 222
    move-result-object p1

    .line 223
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 224
    .line 225
    :cond_4
    return-void

    .line 226
    :goto_0
    iget-object v2, p0, Ltb/u0;->s:Lrb/k1;

    .line 227
    .line 228
    if-eqz v2, :cond_5

    .line 229
    .line 230
    new-instance v3, Ljava/lang/StringBuilder;

    .line 231
    .line 232
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 233
    .line 234
    .line 235
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 236
    .line 237
    .line 238
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 239
    .line 240
    .line 241
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 242
    .line 243
    .line 244
    move-result-object v1

    .line 245
    invoke-virtual {v2, v1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 246
    .line 247
    .line 248
    move-result-object v1

    .line 249
    iput-object v1, p0, Ltb/u0;->s:Lrb/k1;

    .line 250
    .line 251
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 252
    .line 253
    invoke-static {p1}, Ltb/u0;->O(Lrb/y0;)Ljava/nio/charset/Charset;

    .line 254
    .line 255
    .line 256
    move-result-object p1

    .line 257
    iput-object p1, p0, Ltb/u0;->u:Ljava/nio/charset/Charset;

    .line 258
    .line 259
    :cond_5
    throw v0
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

.method public U(Lrb/y0;)V
    .locals 3

    .line 1
    const-string v0, "trailers"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lp6/n;->o(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 7
    .line 8
    if-nez v0, :cond_0

    .line 9
    .line 10
    iget-boolean v0, p0, Ltb/u0;->v:Z

    .line 11
    .line 12
    if-nez v0, :cond_0

    .line 13
    .line 14
    invoke-virtual {p0, p1}, Ltb/u0;->V(Lrb/y0;)Lrb/k1;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iput-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 19
    .line 20
    if-eqz v0, :cond_0

    .line 21
    .line 22
    iput-object p1, p0, Ltb/u0;->t:Lrb/y0;

    .line 23
    .line 24
    :cond_0
    iget-object v0, p0, Ltb/u0;->s:Lrb/k1;

    .line 25
    .line 26
    if-eqz v0, :cond_1

    .line 27
    .line 28
    new-instance v1, Ljava/lang/StringBuilder;

    .line 29
    .line 30
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 31
    .line 32
    .line 33
    const-string v2, "trailers: "

    .line 34
    .line 35
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 36
    .line 37
    .line 38
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 39
    .line 40
    .line 41
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 42
    .line 43
    .line 44
    move-result-object p1

    .line 45
    invoke-virtual {v0, p1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 46
    .line 47
    .line 48
    move-result-object p1

    .line 49
    iput-object p1, p0, Ltb/u0;->s:Lrb/k1;

    .line 50
    .line 51
    const/4 v0, 0x0

    .line 52
    iget-object v1, p0, Ltb/u0;->t:Lrb/y0;

    .line 53
    .line 54
    invoke-virtual {p0, p1, v0, v1}, Ltb/u0;->P(Lrb/k1;ZLrb/y0;)V

    .line 55
    .line 56
    .line 57
    return-void

    .line 58
    :cond_1
    invoke-virtual {p0, p1}, Ltb/u0;->Q(Lrb/y0;)Lrb/k1;

    .line 59
    .line 60
    .line 61
    move-result-object v0

    .line 62
    invoke-static {p1}, Ltb/u0;->R(Lrb/y0;)V

    .line 63
    .line 64
    .line 65
    invoke-virtual {p0, p1, v0}, Ltb/a$c;->F(Lrb/y0;Lrb/k1;)V

    .line 66
    .line 67
    .line 68
    return-void
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

.method public final V(Lrb/y0;)Lrb/k1;
    .locals 3

    .line 1
    sget-object v0, Ltb/u0;->x:Lrb/y0$g;

    .line 2
    .line 3
    invoke-virtual {p1, v0}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    check-cast v0, Ljava/lang/Integer;

    .line 8
    .line 9
    if-nez v0, :cond_0

    .line 10
    .line 11
    sget-object p1, Lrb/k1;->s:Lrb/k1;

    .line 12
    .line 13
    const-string v0, "Missing HTTP status code"

    .line 14
    .line 15
    invoke-virtual {p1, v0}, Lrb/k1;->r(Ljava/lang/String;)Lrb/k1;

    .line 16
    .line 17
    .line 18
    move-result-object p1

    .line 19
    return-object p1

    .line 20
    :cond_0
    sget-object v1, Ltb/r0;->j:Lrb/y0$g;

    .line 21
    .line 22
    invoke-virtual {p1, v1}, Lrb/y0;->g(Lrb/y0$g;)Ljava/lang/Object;

    .line 23
    .line 24
    .line 25
    move-result-object p1

    .line 26
    check-cast p1, Ljava/lang/String;

    .line 27
    .line 28
    invoke-static {p1}, Ltb/r0;->n(Ljava/lang/String;)Z

    .line 29
    .line 30
    .line 31
    move-result v1

    .line 32
    if-nez v1, :cond_1

    .line 33
    .line 34
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 35
    .line 36
    .line 37
    move-result v0

    .line 38
    invoke-static {v0}, Ltb/r0;->m(I)Lrb/k1;

    .line 39
    .line 40
    .line 41
    move-result-object v0

    .line 42
    new-instance v1, Ljava/lang/StringBuilder;

    .line 43
    .line 44
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 45
    .line 46
    .line 47
    const-string v2, "invalid content-type: "

    .line 48
    .line 49
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 50
    .line 51
    .line 52
    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 53
    .line 54
    .line 55
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 56
    .line 57
    .line 58
    move-result-object p1

    .line 59
    invoke-virtual {v0, p1}, Lrb/k1;->f(Ljava/lang/String;)Lrb/k1;

    .line 60
    .line 61
    .line 62
    move-result-object p1

    .line 63
    return-object p1

    .line 64
    :cond_1
    const/4 p1, 0x0

    .line 65
    return-object p1
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

.method public bridge synthetic c(Z)V
    .locals 0

    .line 1
    invoke-super {p0, p1}, Ltb/a$c;->c(Z)V

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
