.class public Lac/h$f;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lac/h$j;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lac/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "f"
.end annotation


# instance fields
.field public final a:Lac/h$g;

.field public final b:Lrb/f;


# direct methods
.method public constructor <init>(Lac/h$g;Lrb/f;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    iput-object p1, p0, Lac/h$f;->a:Lac/h$g;

    .line 5
    .line 6
    iput-object p2, p0, Lac/h$f;->b:Lrb/f;

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
.method public a(Lac/h$c;J)V
    .locals 6

    .line 1
    iget-object v0, p0, Lac/h$f;->a:Lac/h$g;

    .line 2
    .line 3
    iget-object v0, v0, Lac/h$g;->f:Lac/h$g$b;

    .line 4
    .line 5
    iget-object v0, v0, Lac/h$g$b;->d:Ljava/lang/Integer;

    .line 6
    .line 7
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    invoke-static {p1, v0}, Lac/h;->l(Lac/h$c;I)Ljava/util/List;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 16
    .line 17
    .line 18
    move-result v1

    .line 19
    iget-object v2, p0, Lac/h$f;->a:Lac/h$g;

    .line 20
    .line 21
    iget-object v2, v2, Lac/h$g;->f:Lac/h$g$b;

    .line 22
    .line 23
    iget-object v2, v2, Lac/h$g$b;->c:Ljava/lang/Integer;

    .line 24
    .line 25
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    .line 26
    .line 27
    .line 28
    move-result v2

    .line 29
    if-lt v1, v2, :cond_4

    .line 30
    .line 31
    invoke-interface {v0}, Ljava/util/List;->size()I

    .line 32
    .line 33
    .line 34
    move-result v1

    .line 35
    if-nez v1, :cond_0

    .line 36
    .line 37
    goto/16 :goto_1

    .line 38
    .line 39
    :cond_0
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 40
    .line 41
    .line 42
    move-result-object v0

    .line 43
    :cond_1
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    .line 44
    .line 45
    .line 46
    move-result v1

    .line 47
    if-eqz v1, :cond_4

    .line 48
    .line 49
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 50
    .line 51
    .line 52
    move-result-object v1

    .line 53
    check-cast v1, Lac/h$b;

    .line 54
    .line 55
    invoke-virtual {p1}, Lac/h$c;->e()D

    .line 56
    .line 57
    .line 58
    move-result-wide v2

    .line 59
    iget-object v4, p0, Lac/h$f;->a:Lac/h$g;

    .line 60
    .line 61
    iget-object v4, v4, Lac/h$g;->d:Ljava/lang/Integer;

    .line 62
    .line 63
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    .line 64
    .line 65
    .line 66
    move-result v4

    .line 67
    int-to-double v4, v4

    .line 68
    cmpl-double v2, v2, v4

    .line 69
    .line 70
    if-ltz v2, :cond_2

    .line 71
    .line 72
    goto :goto_1

    .line 73
    :cond_2
    invoke-virtual {v1}, Lac/h$b;->f()J

    .line 74
    .line 75
    .line 76
    move-result-wide v2

    .line 77
    iget-object v4, p0, Lac/h$f;->a:Lac/h$g;

    .line 78
    .line 79
    iget-object v4, v4, Lac/h$g;->f:Lac/h$g$b;

    .line 80
    .line 81
    iget-object v4, v4, Lac/h$g$b;->d:Ljava/lang/Integer;

    .line 82
    .line 83
    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    .line 84
    .line 85
    .line 86
    move-result v4

    .line 87
    int-to-long v4, v4

    .line 88
    cmp-long v2, v2, v4

    .line 89
    .line 90
    if-gez v2, :cond_3

    .line 91
    .line 92
    goto :goto_0

    .line 93
    :cond_3
    iget-object v2, p0, Lac/h$f;->a:Lac/h$g;

    .line 94
    .line 95
    iget-object v2, v2, Lac/h$g;->f:Lac/h$g$b;

    .line 96
    .line 97
    iget-object v2, v2, Lac/h$g$b;->a:Ljava/lang/Integer;

    .line 98
    .line 99
    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    .line 100
    .line 101
    .line 102
    move-result v2

    .line 103
    int-to-double v2, v2

    .line 104
    const-wide/high16 v4, 0x4059000000000000L    # 100.0

    .line 105
    .line 106
    div-double/2addr v2, v4

    .line 107
    invoke-virtual {v1}, Lac/h$b;->e()D

    .line 108
    .line 109
    .line 110
    move-result-wide v4

    .line 111
    cmpl-double v2, v4, v2

    .line 112
    .line 113
    if-lez v2, :cond_1

    .line 114
    .line 115
    iget-object v2, p0, Lac/h$f;->b:Lrb/f;

    .line 116
    .line 117
    sget-object v3, Lrb/f$a;->a:Lrb/f$a;

    .line 118
    .line 119
    invoke-virtual {v1}, Lac/h$b;->e()D

    .line 120
    .line 121
    .line 122
    move-result-wide v4

    .line 123
    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    .line 124
    .line 125
    .line 126
    move-result-object v4

    .line 127
    filled-new-array {v1, v4}, [Ljava/lang/Object;

    .line 128
    .line 129
    .line 130
    move-result-object v4

    .line 131
    const-string v5, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}"

    .line 132
    .line 133
    invoke-virtual {v2, v3, v5, v4}, Lrb/f;->b(Lrb/f$a;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 134
    .line 135
    .line 136
    new-instance v2, Ljava/util/Random;

    .line 137
    .line 138
    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    .line 139
    .line 140
    .line 141
    const/16 v3, 0x64

    .line 142
    .line 143
    invoke-virtual {v2, v3}, Ljava/util/Random;->nextInt(I)I

    .line 144
    .line 145
    .line 146
    move-result v2

    .line 147
    iget-object v3, p0, Lac/h$f;->a:Lac/h$g;

    .line 148
    .line 149
    iget-object v3, v3, Lac/h$g;->f:Lac/h$g$b;

    .line 150
    .line 151
    iget-object v3, v3, Lac/h$g$b;->b:Ljava/lang/Integer;

    .line 152
    .line 153
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    .line 154
    .line 155
    .line 156
    move-result v3

    .line 157
    if-ge v2, v3, :cond_1

    .line 158
    .line 159
    invoke-virtual {v1, p2, p3}, Lac/h$b;->d(J)V

    .line 160
    .line 161
    .line 162
    goto :goto_0

    .line 163
    :cond_4
    :goto_1
    return-void
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
