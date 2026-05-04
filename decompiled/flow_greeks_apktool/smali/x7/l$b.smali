.class public final Lx7/l$b;
.super Lx7/f0$e$d$b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lx7/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field public a:J

.field public b:Ljava/lang/String;

.field public c:Lx7/f0$e$d$a;

.field public d:Lx7/f0$e$d$c;

.field public e:Lx7/f0$e$d$d;

.field public f:Lx7/f0$e$d$f;

.field public g:B


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2
    invoke-direct {p0}, Lx7/f0$e$d$b;-><init>()V

    return-void
.end method

.method public constructor <init>(Lx7/f0$e$d;)V
    .locals 2

    .line 3
    invoke-direct {p0}, Lx7/f0$e$d$b;-><init>()V

    .line 4
    invoke-virtual {p1}, Lx7/f0$e$d;->f()J

    move-result-wide v0

    iput-wide v0, p0, Lx7/l$b;->a:J

    .line 5
    invoke-virtual {p1}, Lx7/f0$e$d;->g()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lx7/l$b;->b:Ljava/lang/String;

    .line 6
    invoke-virtual {p1}, Lx7/f0$e$d;->b()Lx7/f0$e$d$a;

    move-result-object v0

    iput-object v0, p0, Lx7/l$b;->c:Lx7/f0$e$d$a;

    .line 7
    invoke-virtual {p1}, Lx7/f0$e$d;->c()Lx7/f0$e$d$c;

    move-result-object v0

    iput-object v0, p0, Lx7/l$b;->d:Lx7/f0$e$d$c;

    .line 8
    invoke-virtual {p1}, Lx7/f0$e$d;->d()Lx7/f0$e$d$d;

    move-result-object v0

    iput-object v0, p0, Lx7/l$b;->e:Lx7/f0$e$d$d;

    .line 9
    invoke-virtual {p1}, Lx7/f0$e$d;->e()Lx7/f0$e$d$f;

    move-result-object p1

    iput-object p1, p0, Lx7/l$b;->f:Lx7/f0$e$d$f;

    const/4 p1, 0x1

    .line 10
    iput-byte p1, p0, Lx7/l$b;->g:B

    return-void
.end method

.method public synthetic constructor <init>(Lx7/f0$e$d;Lx7/l$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lx7/l$b;-><init>(Lx7/f0$e$d;)V

    return-void
.end method


# virtual methods
.method public a()Lx7/f0$e$d;
    .locals 11

    .line 1
    iget-byte v0, p0, Lx7/l$b;->g:B

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    if-ne v0, v1, :cond_1

    .line 5
    .line 6
    iget-object v5, p0, Lx7/l$b;->b:Ljava/lang/String;

    .line 7
    .line 8
    if-eqz v5, :cond_1

    .line 9
    .line 10
    iget-object v6, p0, Lx7/l$b;->c:Lx7/f0$e$d$a;

    .line 11
    .line 12
    if-eqz v6, :cond_1

    .line 13
    .line 14
    iget-object v7, p0, Lx7/l$b;->d:Lx7/f0$e$d$c;

    .line 15
    .line 16
    if-nez v7, :cond_0

    .line 17
    .line 18
    goto :goto_0

    .line 19
    :cond_0
    new-instance v2, Lx7/l;

    .line 20
    .line 21
    iget-wide v3, p0, Lx7/l$b;->a:J

    .line 22
    .line 23
    iget-object v8, p0, Lx7/l$b;->e:Lx7/f0$e$d$d;

    .line 24
    .line 25
    iget-object v9, p0, Lx7/l$b;->f:Lx7/f0$e$d$f;

    .line 26
    .line 27
    const/4 v10, 0x0

    .line 28
    invoke-direct/range {v2 .. v10}, Lx7/l;-><init>(JLjava/lang/String;Lx7/f0$e$d$a;Lx7/f0$e$d$c;Lx7/f0$e$d$d;Lx7/f0$e$d$f;Lx7/l$a;)V

    .line 29
    .line 30
    .line 31
    return-object v2

    .line 32
    :cond_1
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    .line 33
    .line 34
    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 35
    .line 36
    .line 37
    iget-byte v2, p0, Lx7/l$b;->g:B

    .line 38
    .line 39
    and-int/2addr v1, v2

    .line 40
    if-nez v1, :cond_2

    .line 41
    .line 42
    const-string v1, " timestamp"

    .line 43
    .line 44
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 45
    .line 46
    .line 47
    :cond_2
    iget-object v1, p0, Lx7/l$b;->b:Ljava/lang/String;

    .line 48
    .line 49
    if-nez v1, :cond_3

    .line 50
    .line 51
    const-string v1, " type"

    .line 52
    .line 53
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 54
    .line 55
    .line 56
    :cond_3
    iget-object v1, p0, Lx7/l$b;->c:Lx7/f0$e$d$a;

    .line 57
    .line 58
    if-nez v1, :cond_4

    .line 59
    .line 60
    const-string v1, " app"

    .line 61
    .line 62
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 63
    .line 64
    .line 65
    :cond_4
    iget-object v1, p0, Lx7/l$b;->d:Lx7/f0$e$d$c;

    .line 66
    .line 67
    if-nez v1, :cond_5

    .line 68
    .line 69
    const-string v1, " device"

    .line 70
    .line 71
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 72
    .line 73
    .line 74
    :cond_5
    new-instance v1, Ljava/lang/IllegalStateException;

    .line 75
    .line 76
    new-instance v2, Ljava/lang/StringBuilder;

    .line 77
    .line 78
    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 79
    .line 80
    .line 81
    const-string v3, "Missing required properties:"

    .line 82
    .line 83
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    .line 85
    .line 86
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 87
    .line 88
    .line 89
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 90
    .line 91
    .line 92
    move-result-object v0

    .line 93
    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 94
    .line 95
    .line 96
    throw v1
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
.end method

.method public b(Lx7/f0$e$d$a;)Lx7/f0$e$d$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/l$b;->c:Lx7/f0$e$d$a;

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

.method public c(Lx7/f0$e$d$c;)Lx7/f0$e$d$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/l$b;->d:Lx7/f0$e$d$c;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null device"

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

.method public d(Lx7/f0$e$d$d;)Lx7/f0$e$d$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/l$b;->e:Lx7/f0$e$d$d;

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

.method public e(Lx7/f0$e$d$f;)Lx7/f0$e$d$b;
    .locals 0

    .line 1
    iput-object p1, p0, Lx7/l$b;->f:Lx7/f0$e$d$f;

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

.method public f(J)Lx7/f0$e$d$b;
    .locals 0

    .line 1
    iput-wide p1, p0, Lx7/l$b;->a:J

    .line 2
    .line 3
    iget-byte p1, p0, Lx7/l$b;->g:B

    .line 4
    .line 5
    or-int/lit8 p1, p1, 0x1

    .line 6
    .line 7
    int-to-byte p1, p1

    .line 8
    iput-byte p1, p0, Lx7/l$b;->g:B

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

.method public g(Ljava/lang/String;)Lx7/f0$e$d$b;
    .locals 1

    .line 1
    if-eqz p1, :cond_0

    .line 2
    .line 3
    iput-object p1, p0, Lx7/l$b;->b:Ljava/lang/String;

    .line 4
    .line 5
    return-object p0

    .line 6
    :cond_0
    new-instance p1, Ljava/lang/NullPointerException;

    .line 7
    .line 8
    const-string v0, "Null type"

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
