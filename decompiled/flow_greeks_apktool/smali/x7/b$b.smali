.class public final Lx7/b$b;
.super Lx7/f0$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx7/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field public a:Ljava/lang/String;

.field public b:Ljava/lang/String;

.field public c:I

.field public d:Ljava/lang/String;

.field public e:Ljava/lang/String;

.field public f:Ljava/lang/String;

.field public g:Ljava/lang/String;

.field public h:Ljava/lang/String;

.field public i:Ljava/lang/String;

.field public j:Lx7/f0$e;

.field public k:Lx7/f0$d;

.field public l:Lx7/f0$a;

.field public m:B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Lx7/f0$b;-><init>()V

    return-void
.end method

.method public constructor <init>(Lx7/f0;)V
    .locals 1

    .line 3
    invoke-direct {p0}, Lx7/f0$b;-><init>()V

    .line 4
    invoke-virtual {p1}, Lx7/f0;->m()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->a:Ljava/lang/String;

    .line 5
    invoke-virtual {p1}, Lx7/f0;->i()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->b:Ljava/lang/String;

    .line 6
    invoke-virtual {p1}, Lx7/f0;->l()I

    move-result v0

    iput v0, p0, Lx7/b$b;->c:I

    .line 7
    invoke-virtual {p1}, Lx7/f0;->j()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->d:Ljava/lang/String;

    .line 8
    invoke-virtual {p1}, Lx7/f0;->h()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->e:Ljava/lang/String;

    .line 9
    invoke-virtual {p1}, Lx7/f0;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->f:Ljava/lang/String;

    .line 10
    invoke-virtual {p1}, Lx7/f0;->d()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->g:Ljava/lang/String;

    .line 11
    invoke-virtual {p1}, Lx7/f0;->e()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->h:Ljava/lang/String;

    .line 12
    invoke-virtual {p1}, Lx7/f0;->f()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->i:Ljava/lang/String;

    .line 13
    invoke-virtual {p1}, Lx7/f0;->n()Lx7/f0$e;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->j:Lx7/f0$e;

    .line 14
    invoke-virtual {p1}, Lx7/f0;->k()Lx7/f0$d;

    move-result-object v0

    iput-object v0, p0, Lx7/b$b;->k:Lx7/f0$d;

    .line 15
    invoke-virtual {p1}, Lx7/f0;->c()Lx7/f0$a;

    move-result-object p1

    iput-object p1, p0, Lx7/b$b;->l:Lx7/f0$a;

    const/4 p1, 0x1

    .line 16
    iput-byte p1, p0, Lx7/b$b;->m:B

    return-void
.end method

.method public synthetic constructor <init>(Lx7/f0;Lx7/b$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lx7/b$b;-><init>(Lx7/f0;)V

    return-void
.end method


# virtual methods
.method public a()Lx7/f0;
    .locals 17

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-byte v1, v0, Lx7/b$b;->m:B

    .line 4
    .line 5
    const/4 v2, 0x1

    .line 6
    if-ne v1, v2, :cond_1

    .line 7
    .line 8
    iget-object v1, v0, Lx7/b$b;->a:Ljava/lang/String;

    .line 9
    .line 10
    if-eqz v1, :cond_1

    .line 11
    .line 12
    iget-object v1, v0, Lx7/b$b;->b:Ljava/lang/String;

    .line 13
    .line 14
    if-eqz v1, :cond_1

    .line 15
    .line 16
    iget-object v1, v0, Lx7/b$b;->d:Ljava/lang/String;

    .line 17
    .line 18
    if-eqz v1, :cond_1

    .line 19
    .line 20
    iget-object v1, v0, Lx7/b$b;->h:Ljava/lang/String;

    .line 21
    .line 22
    if-eqz v1, :cond_1

    .line 23
    .line 24
    iget-object v1, v0, Lx7/b$b;->i:Ljava/lang/String;

    .line 25
    .line 26
    if-nez v1, :cond_0

    .line 27
    .line 28
    goto :goto_0

    .line 29
    :cond_0
    new-instance v3, Lx7/b;

    .line 30
    .line 31
    iget-object v4, v0, Lx7/b$b;->a:Ljava/lang/String;

    .line 32
    .line 33
    iget-object v5, v0, Lx7/b$b;->b:Ljava/lang/String;

    .line 34
    .line 35
    iget v6, v0, Lx7/b$b;->c:I

    .line 36
    .line 37
    iget-object v7, v0, Lx7/b$b;->d:Ljava/lang/String;

    .line 38
    .line 39
    iget-object v8, v0, Lx7/b$b;->e:Ljava/lang/String;

    .line 40
    .line 41
    iget-object v9, v0, Lx7/b$b;->f:Ljava/lang/String;

    .line 42
    .line 43
    iget-object v10, v0, Lx7/b$b;->g:Ljava/lang/String;

    .line 44
    .line 45
    iget-object v11, v0, Lx7/b$b;->h:Ljava/lang/String;

    .line 46
    .line 47
    iget-object v12, v0, Lx7/b$b;->i:Ljava/lang/String;

    .line 48
    .line 49
    iget-object v13, v0, Lx7/b$b;->j:Lx7/f0$e;

    .line 50
    .line 51
    iget-object v14, v0, Lx7/b$b;->k:Lx7/f0$d;

    .line 52
    .line 53
    iget-object v15, v0, Lx7/b$b;->l:Lx7/f0$a;

    .line 54
    .line 55
    const/16 v16, 0x0

    .line 56
    .line 57
    invoke-direct/range {v3 .. v16}, Lx7/b;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lx7/f0$e;Lx7/f0$d;Lx7/f0$a;Lx7/b$a;)V

    .line 58
    .line 59
    .line 60
    return-object v3

    .line 61
    :cond_1
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    .line 62
    .line 63
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 64
    .line 65
    .line 66
    iget-object v3, v0, Lx7/b$b;->a:Ljava/lang/String;

    .line 67
    .line 68
    if-nez v3, :cond_2

    .line 69
    .line 70
    const-string v3, " sdkVersion"

    .line 71
    .line 72
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 73
    .line 74
    .line 75
    :cond_2
    iget-object v3, v0, Lx7/b$b;->b:Ljava/lang/String;

    .line 76
    .line 77
    if-nez v3, :cond_3

    .line 78
    .line 79
    const-string v3, " gmpAppId"

    .line 80
    .line 81
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 82
    .line 83
    .line 84
    :cond_3
    iget-byte v3, v0, Lx7/b$b;->m:B

    .line 85
    .line 86
    and-int/2addr v2, v3

    .line 87
    if-nez v2, :cond_4

    .line 88
    .line 89
    const-string v2, " platform"

    .line 90
    .line 91
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 92
    .line 93
    .line 94
    :cond_4
    iget-object v2, v0, Lx7/b$b;->d:Ljava/lang/String;

    .line 95
    .line 96
    if-nez v2, :cond_5

    .line 97
    .line 98
    const-string v2, " installationUuid"

    .line 99
    .line 100
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    .line 102
    .line 103
    :cond_5
    iget-object v2, v0, Lx7/b$b;->h:Ljava/lang/String;

    .line 104
    .line 105
    if-nez v2, :cond_6

    .line 106
    .line 107
    const-string v2, " buildVersion"

    .line 108
    .line 109
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 110
    .line 111
    .line 112
    :cond_6
    iget-object v2, v0, Lx7/b$b;->i:Ljava/lang/String;

    .line 113
    .line 114
    if-nez v2, :cond_7

    .line 115
    .line 116
    const-string v2, " displayVersion"

    .line 117
    .line 118
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 119
    .line 120
    .line 121
    :cond_7
    new-instance v2, Ljava/lang/IllegalStateException;

    .line 122
    .line 123
    new-instance v3, Ljava/lang/StringBuilder;

    .line 124
    .line 125
    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 126
    .line 127
    .line 128
    const-string v4, "Missing required properties:"

    .line 129
    .line 130
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 131
    .line 132
    .line 133
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 134
    .line 135
    .line 136
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 137
    .line 138
    .line 139
    move-result-object v1

    .line 140
    invoke-direct {v2, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 141
    .line 142
    .line 143
    throw v2
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

.method public b(Lx7/f0$a;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->l:Lx7/f0$a;

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

.method public c(Ljava/lang/String;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->g:Ljava/lang/String;

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

.method public d(Ljava/lang/String;)Lx7/f0$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/b$b;->h:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null buildVersion"

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

.method public e(Ljava/lang/String;)Lx7/f0$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/b$b;->i:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null displayVersion"

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

.method public f(Ljava/lang/String;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->f:Ljava/lang/String;

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

.method public g(Ljava/lang/String;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->e:Ljava/lang/String;

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

.method public h(Ljava/lang/String;)Lx7/f0$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/b$b;->b:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null gmpAppId"

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

.method public i(Ljava/lang/String;)Lx7/f0$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/b$b;->d:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null installationUuid"

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

.method public j(Lx7/f0$d;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->k:Lx7/f0$d;

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

.method public k(I)Lx7/f0$b;
    .locals 0

    .line 1
    iput p1, p0, Lx7/b$b;->c:I

    .line 2
    .line 3
    iget-byte p1, p0, Lx7/b$b;->m:B

    .line 4
    .line 5
    or-int/lit8 p1, p1, 0x1

    .line 6
    .line 7
    int-to-byte p1, p1

    .line 8
    iput-byte p1, p0, Lx7/b$b;->m:B

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

.method public l(Ljava/lang/String;)Lx7/f0$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/b$b;->a:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null sdkVersion"

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

.method public m(Lx7/f0$e;)Lx7/f0$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/b$b;->j:Lx7/f0$e;

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
