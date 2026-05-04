.class public Lac/e$b;
.super Lac/c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lac/e;->r(Lrb/r0$c;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "b"
.end annotation


# instance fields
.field public a:Lrb/r0;

.field public final synthetic b:Lac/e;


# direct methods
.method public constructor <init>(Lac/e;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lac/e$b;->b:Lac/e;

    .line 2
    .line 3
    invoke-direct {p0}, Lac/c;-><init>()V

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


# virtual methods
.method public f(Lrb/p;Lrb/r0$j;)V
    .locals 2

    .line 1
    iget-object v0, p0, Lac/e$b;->a:Lrb/r0;

    .line 2
    .line 3
    iget-object v1, p0, Lac/e$b;->b:Lac/e;

    .line 4
    .line 5
    invoke-static {v1}, Lac/e;->i(Lac/e;)Lrb/r0;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    if-ne v0, v1, :cond_0

    .line 10
    .line 11
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 12
    .line 13
    invoke-static {v0}, Lac/e;->j(Lac/e;)Z

    .line 14
    .line 15
    .line 16
    move-result v0

    .line 17
    const-string v1, "there\'s pending lb while current lb has been out of READY"

    .line 18
    .line 19
    invoke-static {v0, v1}, Lp6/n;->u(ZLjava/lang/Object;)V

    .line 20
    .line 21
    .line 22
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 23
    .line 24
    invoke-static {v0, p1}, Lac/e;->l(Lac/e;Lrb/p;)Lrb/p;

    .line 25
    .line 26
    .line 27
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 28
    .line 29
    invoke-static {v0, p2}, Lac/e;->m(Lac/e;Lrb/r0$j;)Lrb/r0$j;

    .line 30
    .line 31
    .line 32
    sget-object p2, Lrb/p;->b:Lrb/p;

    .line 33
    .line 34
    if-ne p1, p2, :cond_3

    .line 35
    .line 36
    iget-object p1, p0, Lac/e$b;->b:Lac/e;

    .line 37
    .line 38
    invoke-static {p1}, Lac/e;->n(Lac/e;)V

    .line 39
    .line 40
    .line 41
    return-void

    .line 42
    :cond_0
    iget-object v0, p0, Lac/e$b;->a:Lrb/r0;

    .line 43
    .line 44
    iget-object v1, p0, Lac/e$b;->b:Lac/e;

    .line 45
    .line 46
    invoke-static {v1}, Lac/e;->o(Lac/e;)Lrb/r0;

    .line 47
    .line 48
    .line 49
    move-result-object v1

    .line 50
    if-ne v0, v1, :cond_3

    .line 51
    .line 52
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 53
    .line 54
    sget-object v1, Lrb/p;->b:Lrb/p;

    .line 55
    .line 56
    if-ne p1, v1, :cond_1

    .line 57
    .line 58
    const/4 v1, 0x1

    .line 59
    goto :goto_0

    .line 60
    :cond_1
    const/4 v1, 0x0

    .line 61
    :goto_0
    invoke-static {v0, v1}, Lac/e;->k(Lac/e;Z)Z

    .line 62
    .line 63
    .line 64
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 65
    .line 66
    invoke-static {v0}, Lac/e;->j(Lac/e;)Z

    .line 67
    .line 68
    .line 69
    move-result v0

    .line 70
    if-nez v0, :cond_2

    .line 71
    .line 72
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 73
    .line 74
    invoke-static {v0}, Lac/e;->i(Lac/e;)Lrb/r0;

    .line 75
    .line 76
    .line 77
    move-result-object v0

    .line 78
    iget-object v1, p0, Lac/e$b;->b:Lac/e;

    .line 79
    .line 80
    invoke-static {v1}, Lac/e;->p(Lac/e;)Lrb/r0;

    .line 81
    .line 82
    .line 83
    move-result-object v1

    .line 84
    if-eq v0, v1, :cond_2

    .line 85
    .line 86
    iget-object p1, p0, Lac/e$b;->b:Lac/e;

    .line 87
    .line 88
    invoke-static {p1}, Lac/e;->n(Lac/e;)V

    .line 89
    .line 90
    .line 91
    return-void

    .line 92
    :cond_2
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 93
    .line 94
    invoke-static {v0}, Lac/e;->h(Lac/e;)Lrb/r0$e;

    .line 95
    .line 96
    .line 97
    move-result-object v0

    .line 98
    invoke-virtual {v0, p1, p2}, Lrb/r0$e;->f(Lrb/p;Lrb/r0$j;)V

    .line 99
    .line 100
    .line 101
    :cond_3
    return-void
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
.end method

.method public g()Lrb/r0$e;
    .locals 1

    .line 1
    iget-object v0, p0, Lac/e$b;->b:Lac/e;

    .line 2
    .line 3
    invoke-static {v0}, Lac/e;->h(Lac/e;)Lrb/r0$e;

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
