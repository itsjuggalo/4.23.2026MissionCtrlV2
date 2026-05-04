.class public final Lx7/h$b;
.super Lx7/f0$e$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx7/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:Ljava/lang/String;

.field public d:J

.field public e:Ljava/lang/Long;

.field public f:Z

.field public g:Lx7/f0$e$a;

.field public h:Lx7/f0$e$f;

.field public i:Lx7/f0$e$e;

.field public j:Lx7/f0$e$c;

.field public k:Ljava/util/List;

.field public l:I

.field public m:B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Lx7/f0$e$b;-><init>()V

    return-void
.end method

.method public constructor <init>(Lx7/f0$e;)V
    .locals 2

    .line 3
    invoke-direct {p0}, Lx7/f0$e$b;-><init>()V

    .line 4
    invoke-virtual {p1}, Lx7/f0$e;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->a:Ljava/lang/String;

    .line 5
    invoke-virtual {p1}, Lx7/f0$e;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->b:Ljava/lang/String;

    .line 6
    invoke-virtual {p1}, Lx7/f0$e;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->c:Ljava/lang/String;

    .line 7
    invoke-virtual {p1}, Lx7/f0$e;->l()J

    move-result-wide v0

    iput-wide v0, p0, Lx7/h$b;->d:J

    .line 8
    invoke-virtual {p1}, Lx7/f0$e;->e()Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->e:Ljava/lang/Long;

    .line 9
    invoke-virtual {p1}, Lx7/f0$e;->n()Z

    move-result v0

    iput-boolean v0, p0, Lx7/h$b;->f:Z

    .line 10
    invoke-virtual {p1}, Lx7/f0$e;->b()Lx7/f0$e$a;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->g:Lx7/f0$e$a;

    .line 11
    invoke-virtual {p1}, Lx7/f0$e;->m()Lx7/f0$e$f;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->h:Lx7/f0$e$f;

    .line 12
    invoke-virtual {p1}, Lx7/f0$e;->k()Lx7/f0$e$e;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->i:Lx7/f0$e$e;

    .line 13
    invoke-virtual {p1}, Lx7/f0$e;->d()Lx7/f0$e$c;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->j:Lx7/f0$e$c;

    .line 14
    invoke-virtual {p1}, Lx7/f0$e;->f()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lx7/h$b;->k:Ljava/util/List;

    .line 15
    invoke-virtual {p1}, Lx7/f0$e;->h()I

    move-result p1

    iput p1, p0, Lx7/h$b;->l:I

    const/4 p1, 0x7

    .line 16
    iput-byte p1, p0, Lx7/h$b;->m:B

    return-void
.end method

.method public synthetic constructor <init>(Lx7/f0$e;Lx7/h$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lx7/h$b;-><init>(Lx7/f0$e;)V

    return-void
.end method


# virtual methods
.method public a()Lx7/f0$e;
    .locals 18

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-byte v1, v0, Lx7/h$b;->m:B

    .line 4
    .line 5
    const/4 v2, 0x7

    .line 6
    if-ne v1, v2, :cond_1

    .line 7
    .line 8
    iget-object v4, v0, Lx7/h$b;->a:Ljava/lang/String;

    .line 9
    .line 10
    if-eqz v4, :cond_1

    .line 11
    .line 12
    iget-object v5, v0, Lx7/h$b;->b:Ljava/lang/String;

    .line 13
    .line 14
    if-eqz v5, :cond_1

    .line 15
    .line 16
    iget-object v11, v0, Lx7/h$b;->g:Lx7/f0$e$a;

    .line 17
    .line 18
    if-nez v11, :cond_0

    .line 19
    .line 20
    goto :goto_0

    .line 21
    :cond_0
    new-instance v3, Lx7/h;

    .line 22
    .line 23
    iget-object v6, v0, Lx7/h$b;->c:Ljava/lang/String;

    .line 24
    .line 25
    iget-wide v7, v0, Lx7/h$b;->d:J

    .line 26
    .line 27
    iget-object v9, v0, Lx7/h$b;->e:Ljava/lang/Long;

    .line 28
    .line 29
    iget-boolean v10, v0, Lx7/h$b;->f:Z

    .line 30
    .line 31
    iget-object v12, v0, Lx7/h$b;->h:Lx7/f0$e$f;

    .line 32
    .line 33
    iget-object v13, v0, Lx7/h$b;->i:Lx7/f0$e$e;

    .line 34
    .line 35
    iget-object v14, v0, Lx7/h$b;->j:Lx7/f0$e$c;

    .line 36
    .line 37
    iget-object v15, v0, Lx7/h$b;->k:Ljava/util/List;

    .line 38
    .line 39
    iget v1, v0, Lx7/h$b;->l:I

    .line 40
    .line 41
    const/16 v17, 0x0

    .line 42
    .line 43
    move/from16 v16, v1

    .line 44
    .line 45
    invoke-direct/range {v3 .. v17}, Lx7/h;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;ZLx7/f0$e$a;Lx7/f0$e$f;Lx7/f0$e$e;Lx7/f0$e$c;Ljava/util/List;ILx7/h$a;)V

    .line 46
    .line 47
    .line 48
    return-object v3

    .line 49
    :cond_1
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    .line 50
    .line 51
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 52
    .line 53
    .line 54
    iget-object v2, v0, Lx7/h$b;->a:Ljava/lang/String;

    .line 55
    .line 56
    if-nez v2, :cond_2

    .line 57
    .line 58
    const-string v2, " generator"

    .line 59
    .line 60
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 61
    .line 62
    .line 63
    :cond_2
    iget-object v2, v0, Lx7/h$b;->b:Ljava/lang/String;

    .line 64
    .line 65
    if-nez v2, :cond_3

    .line 66
    .line 67
    const-string v2, " identifier"

    .line 68
    .line 69
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 70
    .line 71
    .line 72
    :cond_3
    iget-byte v2, v0, Lx7/h$b;->m:B

    .line 73
    .line 74
    and-int/lit8 v2, v2, 0x1

    .line 75
    .line 76
    if-nez v2, :cond_4

    .line 77
    .line 78
    const-string v2, " startedAt"

    .line 79
    .line 80
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    .line 82
    .line 83
    :cond_4
    iget-byte v2, v0, Lx7/h$b;->m:B

    .line 84
    .line 85
    and-int/lit8 v2, v2, 0x2

    .line 86
    .line 87
    if-nez v2, :cond_5

    .line 88
    .line 89
    const-string v2, " crashed"

    .line 90
    .line 91
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    .line 93
    .line 94
    :cond_5
    iget-object v2, v0, Lx7/h$b;->g:Lx7/f0$e$a;

    .line 95
    .line 96
    if-nez v2, :cond_6

    .line 97
    .line 98
    const-string v2, " app"

    .line 99
    .line 100
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    .line 102
    .line 103
    :cond_6
    iget-byte v2, v0, Lx7/h$b;->m:B

    .line 104
    .line 105
    and-int/lit8 v2, v2, 0x4

    .line 106
    .line 107
    if-nez v2, :cond_7

    .line 108
    .line 109
    const-string v2, " generatorType"

    .line 110
    .line 111
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    :cond_7
    new-instance v2, Ljava/lang/IllegalStateException;

    .line 115
    .line 116
    new-instance v3, Ljava/lang/StringBuilder;

    .line 117
    .line 118
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 119
    .line 120
    .line 121
    const-string v4, "Missing required properties:"

    .line 122
    .line 123
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 124
    .line 125
    .line 126
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 127
    .line 128
    .line 129
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 130
    .line 131
    .line 132
    move-result-object v1

    .line 133
    invoke-direct {v2, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 134
    .line 135
    .line 136
    throw v2
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

.method public b(Lx7/f0$e$a;)Lx7/f0$e$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/h$b;->g:Lx7/f0$e$a;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null app"

    .line 9
    .line 10
    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw p1
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

.method public c(Ljava/lang/String;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->c:Ljava/lang/String;

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
.end method

.method public d(Z)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-boolean p1, p0, Lx7/h$b;->f:Z

    .line 2
    .line 3
    iget-byte p1, p0, Lx7/h$b;->m:B

    .line 4
    .line 5
    or-int/lit8 p1, p1, 0x2

    .line 6
    .line 7
    int-to-byte p1, p1

    .line 8
    iput-byte p1, p0, Lx7/h$b;->m:B

    .line 9
    .line 10
    return-object p0
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

.method public e(Lx7/f0$e$c;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->j:Lx7/f0$e$c;

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
.end method

.method public f(Ljava/lang/Long;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->e:Ljava/lang/Long;

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
.end method

.method public g(Ljava/util/List;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->k:Ljava/util/List;

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
.end method

.method public h(Ljava/lang/String;)Lx7/f0$e$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/h$b;->a:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null generator"

    .line 9
    .line 10
    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw p1
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

.method public i(I)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput p1, p0, Lx7/h$b;->l:I

    .line 2
    .line 3
    iget-byte p1, p0, Lx7/h$b;->m:B

    .line 4
    .line 5
    or-int/lit8 p1, p1, 0x4

    .line 6
    .line 7
    int-to-byte p1, p1

    .line 8
    iput-byte p1, p0, Lx7/h$b;->m:B

    .line 9
    .line 10
    return-object p0
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

.method public j(Ljava/lang/String;)Lx7/f0$e$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/h$b;->b:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null identifier"

    .line 9
    .line 10
    invoke-direct {p1, v0}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw p1
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

.method public l(Lx7/f0$e$e;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->i:Lx7/f0$e$e;

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
.end method

.method public m(J)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-wide p1, p0, Lx7/h$b;->d:J

    .line 2
    .line 3
    iget-byte p1, p0, Lx7/h$b;->m:B

    .line 4
    .line 5
    or-int/lit8 p1, p1, 0x1

    .line 6
    .line 7
    int-to-byte p1, p1

    .line 8
    iput-byte p1, p0, Lx7/h$b;->m:B

    .line 9
    .line 10
    return-object p0
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

.method public n(Lx7/f0$e$f;)Lx7/f0$e$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/h$b;->h:Lx7/f0$e$f;

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
.end method
